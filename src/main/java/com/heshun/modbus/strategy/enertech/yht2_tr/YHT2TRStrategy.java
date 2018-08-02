package com.heshun.modbus.strategy.enertech.yht2_tr;

import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class YHT2TRStrategy extends Abs485UnpackStrategy<YHT2TRPacket, YHT2TRConvert> {

	public YHT2TRStrategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	protected YHT2TRPacket handle(String signature, List<Byte> packet, YHT2TRConvert convert) {
		YHT2TRPacket p = convert.getOriginal();
		if (signature.equals("3-36")) {
			p.contactWarn = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p.busbarWarn = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			//
			for (int i = 0; i < 8; i++) {
				packet.remove(0);
			}
			p.contactAUp = handleData(packet, p.contactAUp);
			p.contactBUp = handleData(packet, p.contactBUp);
			p.contactCUp = handleData(packet, p.contactCUp);
			//
			p.contactADown = handleData(packet, p.contactADown);
			p.contactBDown = handleData(packet, p.contactBDown);
			p.contactCDown = handleData(packet, p.contactCDown);
			//
			p.busbarAUp = handleData(packet, p.busbarAUp);
			p.busbarBUp = handleData(packet, p.busbarBUp);
			p.busbarCUp = handleData(packet, p.busbarCUp);
			//
			p.busbarADown = handleData(packet, p.busbarADown);
			p.busbarBDown = handleData(packet, p.busbarBDown);
			p.busbarCDown = handleData(packet, p.busbarCDown);
			//
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
	public YHT2TRConvert getConvert(YHT2TRPacket packet) {
		return new YHT2TRConvert(packet);
	}

	@Override
	public YHT2TRConvert initConvert(int address) {
		return new YHT2TRConvert(new YHT2TRPacket(address));
	}

}
