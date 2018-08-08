package com.heshun.modbus.strategy.tonli.temp;

import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class WTDLStrategy extends Abs485UnpackStrategy<WTDLPacket, WTDLConvert> {

	public WTDLStrategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	protected WTDLPacket handle(String signature, List<Byte> packet, WTDLConvert convert) {
		WTDLPacket p = convert.getOriginal();
		if (signature.equals("3-8")) {
			p.t_a = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.t_b = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.t_c = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.t_d = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
		}
		return p;
	}

	private short handleData(List<Byte> packet, short origin) {
		short data = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
		if (data == -127) {
			return origin;
		}
		return data;
	}

	@Override
	public WTDLConvert getConvert(WTDLPacket packet) {
		return new WTDLConvert(packet);
	}

	@Override
	public WTDLConvert initConvert(int address) {
		return new WTDLConvert(new WTDLPacket(address));
	}

}
