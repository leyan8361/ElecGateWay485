package com.heshun.modbus.strategy.acrel.c;

import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class PZ96LE4CStrategy extends Abs485UnpackStrategy<PZ96LE4CPacket, PZ96LE4CConvert> {

	public PZ96LE4CStrategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	protected PZ96LE4CPacket handle(String signature, List<Byte> packet, PZ96LE4CConvert convert) {
		// 07 03 58 03 03 06 00 08 E9 08 E7 08 EC 0F 6E 0F 70 0F 72 07 38 06 FD
		// 07 57 01 49 01 33 01 4F 03 CC 00 FA 01 00 00 FF 02 FB 03 0C 02 F2 03
		// 0D 03 04 01 A5 01 97 01 AD 04 EB 13 87 00 04 31 9A 00 00 00 00 00 03
		// 0A 23 00 00 00 0F 4C 27 C0 10 00 00 00 00 4B F3 2A F0 45 16 00 00 1C
		// 84
		PZ96LE4CPacket p = convert.getOriginal();
		switch (signature) {
		case "3-88":
			p.set_dpt((short) packet.remove(0));
			p.set_dct((short) packet.remove(0));
			p.set_dpq((short) packet.remove(0));
			p.set_pq(packet.remove(0));
			//
			p.set_ua(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_ub(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_uc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));

			p.set_uab(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_ubc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_uca(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));

			p.set_ia(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_ib(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_ic(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));

			p.set_pa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_pb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_pc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_ptotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.set_qa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_qb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_qc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_qtotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.set_pfa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_pfb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_pfc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_pftotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.set_sa(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_sb(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_sc(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			p.set_stotal(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.set_freq(Utils.bytes2Short(packet.remove(0), packet.remove(0), true));
			//
			p.set_epi(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			packet.remove(0);
			p.set_eql(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			packet.clear();

			break;
		}
		return p;
	}

	@Override
	public PZ96LE4CConvert getConvert(PZ96LE4CPacket packet) {
		return new PZ96LE4CConvert(packet);
	}

	@Override
	public PZ96LE4CConvert initConvert(int address) {
		return new PZ96LE4CConvert(new PZ96LE4CPacket(address));
	}

}
