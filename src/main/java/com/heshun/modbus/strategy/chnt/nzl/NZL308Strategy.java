package com.heshun.modbus.strategy.chnt.nzl;

import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.modbus.strategy.Abs485UnpackStrategy;
import com.heshun.modbus.util.Utils;

public class NZL308Strategy extends Abs485UnpackStrategy<NZL308Packet, NZL308Convert> {

	public NZL308Strategy(IoSession s, IoBuffer b) {
		super(s, b);
	}

	@Override
	public NZL308Convert getConvert(NZL308Packet packet) {
		return new NZL308Convert(packet);
	}

	@Override
	public NZL308Convert initConvert(int address) {
		return new NZL308Convert(new NZL308Packet(address));
	}

	public int bytes2UnsignedShort(byte high, byte low, boolean reverse) {
		int result = 0;
		int _f = ((high << 8) | low & 0xff) & 0x0FFFF;
		boolean flag = (_f >> 15) != 0 ? true : false;
		int absValue = _f << 17 >> 17;

		if (absValue != 0) {
			result = flag ? -absValue : absValue;
		}
		return result;
	}

	@Override
	protected NZL308Packet handle(String signature, List<Byte> packet, NZL308Convert convert) {
		NZL308Packet p = convert.getOriginal();
		// 按回复报文的签名辨别报文顺序，从而解析到对应字段
		switch (signature) {
		// 01 03 16 ,03 01 04 00 ,09 4D 09 51 09 55, 10 1F 10 26 10 22, 02 BC 01
		// F1 02 9D, 03 E2
		case "3-34":
			p.set_ia(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_ib(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_ic(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			//
			p.set_ua(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_ub(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_uc(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			//
			p.set_uab(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_ubc(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_uca(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			//

			//
			p.set_pa(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_pb(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_pc(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_ptotal(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			//
			p.set_qa(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_qb(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_qc(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_qtotal(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));

			break;

		case "3-26":
			p.set_sa(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_sb(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_sc(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_stotal(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			//
			p.set_pfa(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_pfb(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_pfc(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			p.set_pftotal(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			//
			p.set_freq(bytes2UnsignedShort(packet.remove(0), packet.remove(0), true));
			//
			p.set_epi(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			p.set_eql(Utils.byte4toLong(new byte[] { packet.remove(0), packet.remove(0), packet.remove(0),
					packet.remove(0) }));
			break;

		}
		return p;

	}
}
