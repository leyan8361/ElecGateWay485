package com.heshun.modbus.strategy.pd194z._2;

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

	/**
	 * 电压
	 */
	public float getU(short origin) {
		return (float) origin / 10;
	}

	/**
	 * 电流
	 */
	public float getI(short origin) {
		return (float) origin / 1000;
	}

	// ADD
	/**
	 * 频率
	 */
	public float getFreq(short origin) {
		return (float) origin / 100;
	}

	/**
	 * 三相功率因数
	 */
	public float getPFTotal(short origin) {
		return (float) origin / 1000;
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
		mJson.put("ua", getU(mPacket._ua));
		mJson.put("ub", getU(mPacket._ub));
		mJson.put("uc", getU(mPacket._uc));
		mJson.put("uab", getU(mPacket._uab));
		mJson.put("ubc", getU(mPacket._ubc));
		mJson.put("uca", getU(mPacket._uca));
		mJson.put("ia", getI(mPacket._ia));
		mJson.put("ib", getI(mPacket._ib));
		mJson.put("ic", getI(mPacket._ic));
		// ADD
		mJson.put("freq", getFreq(mPacket._freq));

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

		mJson.put("pft", getPFTotal(mPacket._pftotal));
		mJson.put("epi", getEpi());
		mJson.put("eql", getEql());
		return mJson;
	}

	@Override
	public String getType() {
		return "eqa300";
	}

}
