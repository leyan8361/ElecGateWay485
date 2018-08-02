package com.heshun.modbus.strategy.chnt.nzl;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class NZL308Convert extends AbsJsonConvert<NZL308Packet> {

	public NZL308Convert(NZL308Packet packet) {
		super(packet);
	}

	private float formatU(int _original) {
		return (float) _original / 10;
	}

	private float formatI(int _original) {
		return (float) _original / 1000;
	}

	private float formatFreq(int _original) {
		return (float) _original / 100;
	}

	public JSONObject toJsonObj(int logotype) {
		super.toJsonObj(logotype);

		mJson.put("ua", formatU(mPacket._ua));
		mJson.put("ub", formatU(mPacket._ub));
		mJson.put("uc", formatU(mPacket._uc));
		mJson.put("uab", formatU(mPacket._uab));
		mJson.put("ubc", formatU(mPacket._ubc));
		mJson.put("uca", formatU(mPacket._uca));
		mJson.put("ia", formatI(mPacket._ia));
		mJson.put("ib", formatI(mPacket._ib));
		mJson.put("ic", formatI(mPacket._ic));
		// ADD
		mJson.put("freq", formatFreq(mPacket._freq));

		mJson.put("pa", mPacket._pa);
		mJson.put("pb", mPacket._pb);
		mJson.put("pc", mPacket._pc);
		mJson.put("pt", mPacket._ptotal);
		// ADD
		mJson.put("qa", mPacket._qa);
		mJson.put("qb", mPacket._qb);
		mJson.put("qc", mPacket._qc);
		mJson.put("qt", mPacket._qtotal);
		// ADD
		mJson.put("sa", mPacket._sa);
		mJson.put("sb", mPacket._sb);
		mJson.put("sc", mPacket._sc);
		mJson.put("st", mPacket._stotal);
		// ADD
		mJson.put("pfa", formatI(mPacket._pfa));
		mJson.put("pfb", formatI(mPacket._pfb));
		mJson.put("pfc", formatI(mPacket._pfc));
		mJson.put("pft", formatI(mPacket._ptotal));
		//
		mJson.put("epi", mPacket._epi * 10);
		mJson.put("eql", mPacket._eql * 10);
		return mJson;
	}

	@Override
	public String getType() {
		return "eqa300";
	}

}
