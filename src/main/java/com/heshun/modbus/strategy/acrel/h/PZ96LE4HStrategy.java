package com.heshun.modbus.strategy.acrel.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class PZ96LE4HStrategy extends Abs485UnpackStrategy<PZ96LE4HPacket, PZ96LE4HConvert> {

	public PZ96LE4HStrategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	protected PZ96LE4HPacket handle(String signature, List<Byte> packet, PZ96LE4HConvert convert) {
		PZ96LE4HPacket p = convert.getOriginal();
		switch (signature) {
		case "3-78":
			p._in = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._uan = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ubn = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ucn = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._uab = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ubc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._uca = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ia = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ib = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ic = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._freq = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pa = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._pb = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._pc = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._pt = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._qa = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._qb = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._qc = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._qt = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._sa = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._sb = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._sc = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._st = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._pfa = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pfb = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pfc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pft = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);

			break;
		case "3-176":
			p._epi = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._epe = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._eql = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			p._eqc = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			try {
				List<Method> xieboFunc = new ArrayList<Method>() {
					private static final long serialVersionUID = 1L;

					{
						add(PZ96LE4HPacket.class.getMethod("setHdva", short[].class));
						add(PZ96LE4HPacket.class.getMethod("setHdvb", short[].class));
						add(PZ96LE4HPacket.class.getMethod("setHdvc", short[].class));
					}
				};
				short[] _xiebo = new short[30];

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 20; j++) {
						_xiebo[j] = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
					}
					xieboFunc.get(i).invoke(p, _xiebo);
					// 消费掉10个预留寄存器
					consume(packet, 20);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			break;
		case "3-192":
			try {
				List<Method> xieboFunc = new ArrayList<Method>() {
					private static final long serialVersionUID = 1L;

					{
						add(PZ96LE4HPacket.class.getMethod("setHdva", short[].class));
						add(PZ96LE4HPacket.class.getMethod("setHdvb", short[].class));
						add(PZ96LE4HPacket.class.getMethod("setHdvc", short[].class));
					}
				};
				short[] _xiebo = new short[30];

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 20; j++) {
						_xiebo[j] = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
					}
					xieboFunc.get(i).invoke(p, _xiebo);
					// 消费掉10个预留寄存器
					consume(packet, 20);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			//
			p.jbua = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.jbub = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.jbuc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);

			p.jbia = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.jbib = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.jbic = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);

			break;

		}

		return p;
	}

	@Override
	public PZ96LE4HConvert getConvert(PZ96LE4HPacket packet) {
		return new PZ96LE4HConvert(packet);
	}

	@Override
	public PZ96LE4HConvert initConvert(int address) {
		return new PZ96LE4HConvert(new PZ96LE4HPacket(address));
	}

	private void consume(List<Byte> data, int count) {
		if (data != null && data.size() > count) {
			for (int i = 0; i < count; i++) {
				data.remove(0);
			}
		}
	}
}
