package com.heshun.modbus;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JList;
import javax.swing.JProgressBar;

import com.heshun.modbus.common.Constants;
import com.heshun.modbus.common.GloableStorage;
import com.heshun.modbus.entity.AbsJsonConvert;
import com.heshun.modbus.helper.SystemHelper;
import com.heshun.modbus.service.TotalQueryTask.OnProgressChangeListener;
import com.heshun.modbus.ui.ControlPanel;
import com.heshun.modbus.ui.ControlPanel.OnStatusChangeListener;
import com.heshun.modbus.ui.ListPanel;
import com.heshun.modbus.util.ELog;

public class GateWayMain {

	public static void main(String[] args) {

		new ControlPanel(mListener).open();

	}

	private static ControlPanel.OnClickListener mListener = new ControlPanel.OnClickListener() {

		@Override
		public void onInit(TextArea contentText, final Label countLabel, final JList<String> mJList,
				final TextArea mTvDatas, TextField mTfPort, final Button mBtnStart, final JProgressBar pb,
				final Label pl) {

			final ListPanel listPanel = new ListPanel(mJList);
			ELog.getInstance().log("---onInit----");
			listPanel.initJListPanel();

			try {
				ELog.getInstance().setOutputSource(contentText);
				SystemHelper.loadConfig(mTfPort);
				SystemHelper.initMessageListener(new OnStatusChangeListener() {

					@Override
					public void onDataChanged() {

						mTvDatas.setText("");
						StringBuffer sb = new StringBuffer("缓冲区数据：");

						Map<Integer, Map<Integer, AbsJsonConvert<?>>> mBuffer = GloableStorage.getInstance()
								.getDataBuffer();
						sb.append(mBuffer.size()).append("\r\n");
						for (Entry<Integer, Map<Integer, AbsJsonConvert<?>>> entry : mBuffer.entrySet()) {
							sb.append(entry.getKey()).append(":").append(entry.getValue().size()).append("\r\n");
						}
						mTvDatas.setText(sb.toString());
					}

					@Override
					public void onChange() {
						countLabel.setText(String.format("online:%s", SystemHelper.minaAcceptor.getManagedSessions()
								.size()));

						listPanel.upData();

					}

					@Override
					public void onReady() {
						mBtnStart.setVisible(true);
						mBtnStart.setLabel("start");
						mBtnStart.setEnabled(true);
					}
				}, new OnProgressChangeListener() {

					@Override
					public void onProgressChange(int current, int total) {

						pb.setValue((int) ((float) current / (float) total * 100));
						pl.setText(String.format("%s / %s", current, total));
					}

				});
			} catch (IOException e) {
				e.printStackTrace();
				String errorMessage = String.format("开启Tcp监听失败，请检查%s端口是否被占用", Constants.TCP_ACCEPTOR_PORT);
				ELog.getInstance().err(errorMessage);
				e.printStackTrace();
				return;
			} catch (com.alibaba.fastjson.JSONException e) {
				e.printStackTrace();
				String errorMessage = String.format("读取配置文件失败");
				ELog.getInstance().err(errorMessage);
				e.printStackTrace();
				return;
			}
		}

		@Override
		public void onStart() {
			SystemHelper.startQuery();
		}

		@Override
		public void onStop() {
			System.exit(0);
		}

		@Override
		public void onFlush() {

		}

		@Override
		public void onReset() {

		}

	};

}
