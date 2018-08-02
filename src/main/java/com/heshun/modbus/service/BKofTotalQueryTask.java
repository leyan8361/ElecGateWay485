package com.heshun.modbus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.mina.core.session.IoSession;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.heshun.modbus.entity.Device;
import com.heshun.modbus.helper.SystemHelper;
import com.heshun.modbus.util.ELog;
import com.heshun.modbus.util.SessionUtils;

/**
 * 定时主动对所有设备发起总查询
 * 
 * @author huangxz
 * 
 */
public class BKofTotalQueryTask {

	private boolean isFirst = true;

	private boolean isStart = false;

	public void start() {

		if (!isStart) {
			new Timer().schedule(new TimerTask() {

				@Override
				public void run() {
					for (;;) {

						// 所有连接过来的session
						Map<Long, IoSession> sessionMap = SystemHelper.minaAcceptor.getManagedSessions();
						for (Entry<Long, IoSession> entry : sessionMap.entrySet()) {
							IoSession currSession = entry.getValue();
							// DTU提供logotype,并且在本地找到注册信息才视为一个合法链接
							if (SessionUtils.isSessionIllegal(currSession)) {
								ELog.getInstance().err("非法连接，未找到注册信息，强制关闭:(" + currSession.getId() + ")");
								currSession.closeNow();
								continue;
							}
							// mina(可能)会有死链接的bug，并且不能手动关闭。忽略这些 session
							if (SessionUtils.isSessionUnAvaliable(currSession)) {
								ELog.getInstance().err("异常连接，强制关闭:(" + currSession.getId() + ")");
								SessionUtils.reset(currSession);
								currSession.closeNow();
								continue;
							}
							// 获取DTU下的所有设备列表
							HashMap<Integer, Device> allDevices = SessionUtils.getDevices(currSession);
							if (allDevices != null) {
								for (Entry<Integer, Device> d : allDevices.entrySet()) {
									// 按设备ID发送查询命令，可能是多条命令组合
									d.getValue().sendRequests(currSession);
								}
							}
						}
						isStart = true;
						if (isFirst) {
							startFeedBackLoop();
						}

						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}

				}
			}, 3000);
		} else {
			ELog.getInstance().log("查询任务已经开始。。。。。");
		}

	}

	public void startFeedBackLoop() {
		Scheduler scheduler;

		Trigger t = TriggerBuilder.newTrigger().withIdentity("feed", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(5).repeatForever()).build();

		JobDetail job = JobBuilder.newJob(DataFeedBackJob.class).withIdentity("job", "group1").build();
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.scheduleJob(job, t);

			scheduler.startDelayed(20);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		isFirst = false;
	}

	private List<CommandPack> initCommandQueue() {
		List<CommandPack> result = new ArrayList<CommandPack>();
		long startTime = System.currentTimeMillis();
		// 第一步把所有session中所有设备对应的所有命令有序排列，按session分组
		Map<IoSession, List<byte[]>> _commandFlat = new HashMap<IoSession, List<byte[]>>();
		for (Entry<Long, IoSession> entry : SystemHelper.minaAcceptor.getManagedSessions().entrySet()) {
			IoSession _session = entry.getValue();
			HashMap<Integer, Device> _devices = SessionUtils.getDevices(_session);
			if (_devices == null)
				continue;
			List<byte[]> _commands = new ArrayList<byte[]>();
			for (Entry<Integer, Device> dev : _devices.entrySet()) {
				_commands.addAll(dev.getValue().requestPack);
			}
			_commandFlat.put(_session, _commands);
		}
		long endTime = System.currentTimeMillis();
		ELog.getInstance().log(String.format("铺平报文队列，用时---------->>>[%s] ms", endTime - startTime));
		// 生成报文队列
		for (;;) {
			if (_commandFlat.size() == 0)
				break;
			for (Entry<IoSession, List<byte[]>> c : _commandFlat.entrySet()) {

				IoSession s = c.getKey();
				List<byte[]> commands = c.getValue();
				if (commands != null && commands.size() != 0) {

					byte[] singleCommand = commands.remove(0);
					CommandPack _pack = new CommandPack(s, singleCommand);
					result.add(_pack);
				} else {
					_commandFlat.remove(s);
					continue;

				}
			}
			ELog.getInstance()
					.log(String.format("铺平报文队列，用时---------->>>[%s] ms", System.currentTimeMillis() - endTime));
		}
		return result;
	}

	/**
	 * 查询报文与session的关联关系，封装做一个对象好了
	 */
	class CommandPack {
		public IoSession mSession;
		public byte[] command;

		public CommandPack(IoSession s, byte[] c) {
			this.mSession = s;
			this.command = c;
		}
	}

}
