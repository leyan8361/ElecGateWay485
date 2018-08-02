package com.heshun.modbus.strategy.eqa300.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class EQA300HStrategy extends Abs485UnpackStrategy<EQA300HPacket, EQA300HConvert> {

	public EQA300HStrategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	protected EQA300HPacket handle(String signature, List<Byte> packet, EQA300HConvert convert) {
		EQA300HPacket p = convert.getOriginal();
		switch (signature) {
		// 01 04 1C 01 04 03 01 04 00, 09 1B 09 17 09 13, 0F C1 0F BB 0F BE, 05
		// E0 05 E8 05 71 00 00, 13 88 63 F4
		case "4-28":
			p.setEddy((short) packet.remove(0));
			p.setEddl((short) packet.remove(0));
			p.setDpt((short) packet.remove(0));
			p.setDct((short) packet.remove(0));
			p.setDqt((short) packet.remove(0));
			packet.remove(0);
			p.setUa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setUb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setUc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setUab(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setUbc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setUca(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setIa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setIb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setIc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setIn(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setFreq(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));

			break;
		// 01 03 20 ,01 58 01 54 01 37 03 E3, 00 4E 00 53 00 65 01 06,, 01 5F 01
		// 5E 01 47 04 04,, 03 D4 03 CB 03 B7 03 C7 76 E9
		case "3-32":
			p.setPa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setPb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setPc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setpTotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			// /
			p.setQa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setQb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setQc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setqTotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setSa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setSb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setSc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setsTotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setPfa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setPfb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setPfc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setPfTotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			break;
		// 01 03 10 ...00 11 11 1A 00 00 00 00 00 00 00 00 00 00 00 00 02 DE
		case "3-16":
			p.setEpi(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEpe(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEql(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEqc(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			break;
		case "3-180":
			try {
				List<Method> xieboFunc = new ArrayList<Method>() {
					private static final long serialVersionUID = 1L;

					{
						add(EQA300HPacket.class.getMethod("setHdva", short[].class));
						add(EQA300HPacket.class.getMethod("setHdvb", short[].class));
						add(EQA300HPacket.class.getMethod("setHdvc", short[].class));
					}
				};
				short[] _xiebo = new short[30];

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 30; j++) {
						_xiebo[j] = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
					}
					xieboFunc.get(i).invoke(p, _xiebo);
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			break;
		case "4-180":
			try {
				List<Method> xieboFunc = new ArrayList<Method>() {
					private static final long serialVersionUID = 1L;

					{
						add(EQA300HPacket.class.getMethod("setHdia", short[].class));
						add(EQA300HPacket.class.getMethod("setHdib", short[].class));
						add(EQA300HPacket.class.getMethod("setHdic", short[].class));
					}
				};
				short[] _xiebo = new short[30];

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 30; j++) {
						_xiebo[j] = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
					}
					xieboFunc.get(i).invoke(p, _xiebo);
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
		// 01 03 1C.. 00 0B 00 0E 00 10 ,00 7D 00 91 00 8C, 00 03 00 45, 00 26
		// 00 25 00 2C,, 05 B5 05 B9 05 BF B9 5D
		case "3-28":
			p.setThdva(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setThdvb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setThdvc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setThdia(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setThdib(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setThdic(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setU_nbl(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setI_nbl(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setKf_a(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setKf_b(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setKf_c(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.setCf_a(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setCf_b(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.setCf_c(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			break;
		case "3-36":
			p.setEn2_a_Y_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_a_W_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_a_S_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_b_Y_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_b_W_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_b_S_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_c_Y_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_c_W_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.setEn2_c_S_(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			break;

		}

		return p;
	}

	@Override
	public EQA300HConvert getConvert(EQA300HPacket packet) {
		return new EQA300HConvert(packet);
	}

	@Override
	public EQA300HConvert initConvert(int address) {
		return new EQA300HConvert(new EQA300HPacket(address));
	}

}
