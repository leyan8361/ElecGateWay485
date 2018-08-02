package com.heshun.modbus.strategy.hy194e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.entity.AbsJsonConvert;
import com.heshun.modbus.entity.DefaultDevicePacket;
import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class HY194EStrategy extends Abs485UnpackStrategy {
	private static int COMMAND_NUMBER = 3;
	private Method[] methods;

	public HY194EStrategy(IoSession session, IoBuffer buffer) {
		super(session, buffer);
		methods = new Method[30];
		try {

			methods[0] = HY194EPacket.class.getMethod("set_ua", short.class);
			methods[1] = HY194EPacket.class.getMethod("set_ub", short.class);
			methods[2] = HY194EPacket.class.getMethod("set_uc", short.class);
			methods[3] = HY194EPacket.class.getMethod("set_uab", short.class);
			methods[4] = HY194EPacket.class.getMethod("set_uca", short.class);
			methods[5] = HY194EPacket.class.getMethod("set_ubc", short.class);
			methods[6] = HY194EPacket.class.getMethod("set_ia", short.class);
			methods[7] = HY194EPacket.class.getMethod("set_ib", short.class);
			methods[8] = HY194EPacket.class.getMethod("set_ic", short.class);
			methods[9] = HY194EPacket.class.getMethod("set_pdp", byte[].class);

			methods[10] = HY194EPacket.class.getMethod("set_pa", short.class);
			methods[11] = HY194EPacket.class.getMethod("set_pb", short.class);
			methods[12] = HY194EPacket.class.getMethod("set_pc", short.class);
			methods[13] = HY194EPacket.class.getMethod("set_ptotal", short.class);
			methods[14] = HY194EPacket.class.getMethod("set_qa", short.class);
			methods[15] = HY194EPacket.class.getMethod("set_qb", short.class);
			methods[16] = HY194EPacket.class.getMethod("set_qc", short.class);
			methods[17] = HY194EPacket.class.getMethod("set_qtotal", short.class);
			methods[18] = HY194EPacket.class.getMethod("set_sa", short.class);
			methods[19] = HY194EPacket.class.getMethod("set_sb", short.class);
			methods[20] = HY194EPacket.class.getMethod("set_sc", short.class);
			methods[21] = HY194EPacket.class.getMethod("set_stotal", short.class);
			methods[22] = HY194EPacket.class.getMethod("set_pfa", short.class);
			methods[23] = HY194EPacket.class.getMethod("set_pfb", short.class);
			methods[24] = HY194EPacket.class.getMethod("set_pfc", short.class);
			methods[25] = HY194EPacket.class.getMethod("set_pftotal", short.class);
			methods[26] = HY194EPacket.class.getMethod("set_hz", short.class);

			methods[27] = HY194EPacket.class.getMethod("set_pp", float.class);
			methods[28] = HY194EPacket.class.getMethod("set_mp", float.class);
			methods[29] = HY194EPacket.class.getMethod("set_iq", float.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private void setParam(int index, byte[] _singleData, HY194EPacket packet) {
		try {
			switch (index) {
			case 0:
				for (int i = 27; i < 30; i++) {
					int nIndex = (i - 27) * 6;
					// 整数位word0 word1
					byte IHighHigh = _singleData[nIndex];
					byte IHighLow = _singleData[nIndex + 1];
					byte ILowHigh = _singleData[nIndex + 2];
					byte ILowlow = _singleData[nIndex + 3];
					// 小数位word2
					byte DHigh = _singleData[nIndex + 4];
					byte DLow = _singleData[nIndex + 5];
					// 电能值=Word0×65536 + Word1 + word2/1000
					int integer = Utils.byteArrayToInt(new byte[] { ILowlow, ILowHigh, IHighLow, IHighHigh }, 0);
					short decimal = Utils.bytes2Short(new byte[] { DLow, DHigh });

					methods[i].invoke(packet, (integer + (float) decimal / 1000));
				}
				break;
			case 1:
				for (int i = 0; i < 10; i++) {
					byte high, low;
					high = _singleData[i * 2];
					low = _singleData[i * 2 + 1];
					if (i == 9) {
						methods[i].invoke(packet, new byte[] { low, high });
					} else {
						methods[i].invoke(packet, (short) (Utils.bytes2Short(low, high) & 0xFFFF));
					}

				}
				break;
			case 2:
				for (int i = 10; i < 27; i++) {
					byte high, low;
					int nIndex = i - 10;
					high = _singleData[nIndex * 2];
					low = _singleData[nIndex * 2 + 1];
					methods[i].invoke(packet, (short) (Utils.bytes2Short(low, high) & 0xFFFF));
				}
				break;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public HY194EPacket decode(Map<String, byte[]> data, int address) {
		HY194EPacket packet = new HY194EPacket(address);
		if (data.size() == COMMAND_NUMBER) {
			int i = 0;
			for (Map.Entry<String, byte[]> entry : data.entrySet()) {
				byte[] _singleData = entry.getValue();

				setParam(i++, _singleData, packet);
			}
		} else {
			return null;
		}
		return packet;

	}

	@Override
	protected DefaultDevicePacket doUnpack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbsJsonConvert getConvert(DefaultDevicePacket packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DefaultDevicePacket handle(String signature, List packet, AbsJsonConvert convert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbsJsonConvert initConvert(int address) {
		// TODO Auto-generated method stub
		return null;
	}
}
