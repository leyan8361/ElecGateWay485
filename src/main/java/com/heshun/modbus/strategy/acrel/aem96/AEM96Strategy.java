package com.heshun.modbus.strategy.acrel.aem96;

import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class AEM96Strategy extends Abs485UnpackStrategy<AEM96Packet, AEM96Convert> {

	public AEM96Strategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	protected AEM96Packet handle(String signature, List<Byte> packet, AEM96Convert convert) {
		AEM96Packet p = convert.getOriginal();
		switch (signature) {
		case "3-56":
			p._ua = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ub = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._uc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			//
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			//
			p._ia = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ib = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ic = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._in = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			//
			p._pa = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pb = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._ptotal = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			//
			p._qa = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._qb = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._qc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._qtotal = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			//
			p._sa = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._sb = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._sc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._stotal = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			//
			p._pfa = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pfb = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pfc = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			p._pftotal = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			//
			packet.remove(0);
			packet.remove(0);
			//
			p._freq = Utils.bytes2Short(packet.remove(0), packet.remove(0), true);
			break;
		case "3-12":
			p._epi = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			p._eql = Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) });
			break;
		}
		return p;
	}

	@Override
	public AEM96Convert getConvert(AEM96Packet packet) {
		return new AEM96Convert(packet);
	}

	@Override
	public AEM96Convert initConvert(int address) {
		return new AEM96Convert(new AEM96Packet(address));
	}

}
