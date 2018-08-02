package com.heshun.modbus.strategy.acrel.aem96;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class AEM96Convert extends AbsJsonConvert<AEM96Packet> {

	public AEM96Convert(AEM96Packet packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "eqa300";
	}

	private float formatU(short _original) {
		return (float) _original / 10;
	}

	private float formatI(short _original) {
		return (float) _original / 1000;
	}

	private float formatPQ(short _original) {
		return (float) _original / 10;
	}

	private float formatPF(short _original) {
		return (float) _original / 1000;
	}

	private float formatFreq(short _original) {
		return (float) _original / 100;
	}

	@Override
	public JSONObject toJsonObj(int logoType) {

		mJson.put("ua", formatU(mPacket._ua));
		mJson.put("ub", formatU(mPacket._ub));
		mJson.put("uc", formatU(mPacket._uc));
		mJson.put("uab", formatU(mPacket._uab));
		mJson.put("ubc", formatU(mPacket._ubc));
		mJson.put("uca", formatU(mPacket._uca));
		//
		mJson.put("ia", formatI(mPacket._ia));
		mJson.put("ib", formatI(mPacket._ib));
		mJson.put("ic", formatI(mPacket._ic));
		//
		mJson.put("pa", formatPQ(mPacket._pa));
		mJson.put("pb", formatPQ(mPacket._pb));
		mJson.put("pc", formatPQ(mPacket._pc));
		mJson.put("pt", formatPQ(mPacket._ptotal));
		//
		mJson.put("qa", formatPQ(mPacket._qa));
		mJson.put("qb", formatPQ(mPacket._qb));
		mJson.put("qc", formatPQ(mPacket._qc));
		mJson.put("qt", formatPQ(mPacket._qtotal));
		//
		mJson.put("pfa", formatPF(mPacket._pfa));
		mJson.put("pfb", formatPF(mPacket._pfb));
		mJson.put("pfc", formatPF(mPacket._pfc));
		mJson.put("pft", formatPF(mPacket._pftotal));
		//
		mJson.put("sa", formatPQ(mPacket._sa));
		mJson.put("sb", formatPQ(mPacket._sb));
		mJson.put("sc", formatPQ(mPacket._sc));
		mJson.put("st", formatPQ(mPacket._stotal));
		//
		mJson.put("freq", formatFreq(mPacket._freq));
		mJson.put("epi", String.valueOf(mPacket._epi));
		mJson.put("eql", String.valueOf(mPacket._eql));
		// mJson.put("ua", mPacket.getUan());
		// mJson.put("ub", mPacket.getUbn());
		// mJson.put("uc", mPacket.getUcn());
		// mJson.put("uab", mPacket.getUab());
		// mJson.put("ubc", mPacket.getUbc());
		// mJson.put("uca", mPacket.getUca());
		// mJson.put("ia", mPacket.getIa());
		// mJson.put("ib", mPacket.getIb());
		// mJson.put("ic", mPacket.getIc());
		//
		// mJson.put("pa", mPacket.getPa());
		// mJson.put("pb", mPacket.getPb());
		// mJson.put("pc", mPacket.getPc());
		// mJson.put("pt", mPacket.getPtotal());
		// mJson.put("qa", mPacket.getQa());
		// mJson.put("qb", mPacket.getQb());
		// mJson.put("qc", mPacket.getQc());
		// mJson.put("qt", mPacket.getQtotal());
		// mJson.put("st", mPacket.getS());
		// mJson.put("pft", mPacket.getPf());
		// mJson.put("freq", mPacket.getHz());
		// mJson.put("epi", mPacket.getPpd());
		// mJson.put("epe", mPacket.getMpd());
		// mJson.put("eql", mPacket.getPqd());
		// mJson.put("eqc", mPacket.getMqd());
		return super.toJsonObj(logoType);
	}
}
