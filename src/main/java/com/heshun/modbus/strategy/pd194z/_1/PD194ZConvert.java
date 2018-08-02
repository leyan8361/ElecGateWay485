package com.heshun.modbus.strategy.pd194z._1;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class PD194ZConvert extends AbsJsonConvert<PD194ZPacket> {

	public PD194ZConvert(PD194ZPacket packet) {
		super(packet);
	}

	/**
	 * 获取虚拟cpu
	 */
	public int getAddress() {
		return mPacket.address;
	}

	public String getEpi() {
		return String.valueOf(mPacket._epi);
	}

	public String getEql() {
		return String.valueOf(mPacket._eql);
	}

	public JSONObject toJsonObj(int logotype) {
		super.toJsonObj(logotype);
		mJson.put("address", getAddress());
		mJson.put("ua", mPacket._ua);
		mJson.put("ub", mPacket._ub);
		mJson.put("uc", mPacket._uc);
		mJson.put("uab", mPacket._uab);
		mJson.put("ubc", mPacket._ubc);
		mJson.put("uca", mPacket._uca);
		mJson.put("ia", mPacket._ia);
		mJson.put("ib", mPacket._ib);
		mJson.put("ic", mPacket._ic);
		// ADD
		mJson.put("freq", mPacket._freq);

		mJson.put("pa", mPacket._pa * 1000);
		mJson.put("pb", mPacket._pb * 1000);
		mJson.put("pc", mPacket._pc * 1000);
		mJson.put("pt", mPacket._ptotal * 1000);
		// ADD
		mJson.put("qa", mPacket._qa * 1000);
		mJson.put("qb", mPacket._qb * 1000);
		mJson.put("qc", mPacket._qc * 1000);
		mJson.put("qt", mPacket._qtotal * 1000);
		// ADD
		mJson.put("sa", mPacket._sa * 1000);
		mJson.put("sb", mPacket._sb * 1000);
		mJson.put("sc", mPacket._sc * 1000);
		mJson.put("st", mPacket._stotal * 1000);
		// ADD

		mJson.put("pft", mPacket._pftotal);
		mJson.put("epi", getEpi());
		mJson.put("eql", getEql());
		return mJson;
	}

	@Override
	public String getType() {
		return "eqa300";
	}

}
