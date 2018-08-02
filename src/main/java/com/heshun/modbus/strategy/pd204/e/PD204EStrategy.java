package com.heshun.modbus.strategy.pd204.e;

import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class PD204EStrategy extends Abs485UnpackStrategy<PD204EPacket, PD204EConvert> {

	public PD204EStrategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	protected PD204EPacket handle(String signature, List<Byte> packet, PD204EConvert convert) {
		PD204EPacket p = convert.getOriginal();
		switch (signature) {
		case "4-36":
			p.setUan(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setUbn(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setUcn(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setUab(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setUbc(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setUca(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setIa(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setIb(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setIc(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			break;
		case "4-60":
			p.setPa(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setPb(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setPc(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setPtotal(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setQa(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setQb(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setQc(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setQtotal(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setS(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setPf(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			p.setHz(Utils.intBytes2Float(Utils.listPop2byteArray(packet, 4)));
			// 定点数
			p.setPpd(Utils.byteArrayToInt(Utils.listPop2byteArray(packet, 4), 0));
			p.setMpd(Utils.byteArrayToInt(Utils.listPop2byteArray(packet, 4), 0));
			p.setPqd(Utils.byteArrayToInt(Utils.listPop2byteArray(packet, 4), 0));
			p.setMqd(Utils.byteArrayToInt(Utils.listPop2byteArray(packet, 4), 0));
			break;
		}
		return p;
	}

	@Override
	public PD204EConvert getConvert(PD204EPacket packet) {
		return new PD204EConvert(packet);
	}

	@Override
	public PD204EConvert initConvert(int address) {
		return new PD204EConvert(new PD204EPacket(address));
	}

}
