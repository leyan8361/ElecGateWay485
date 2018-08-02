package com.heshun.modbus.strategy.enertech.yh396e;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class YH396EConvert extends AbsJsonConvert<YH396EPacket> {

	public YH396EConvert(YH396EPacket packet) {
		super(packet);
	}

	/**
	 * 获取虚拟cpu
	 */
	public int getAddress() {
		return mPacket.address;
	}

	/**
	 * A相电压
	 */
	public float getUa() {
		return (float) ((double) mPacket._ua / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * B相电压
	 */
	public float getUb() {
		return (float) ((double) mPacket._ub / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * C相电压
	 */
	public float getUc() {
		return (float) ((double) mPacket._uc / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * ab相电压
	 */
	public float getUab() {
		return (float) ((double) mPacket._uab / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * bc相电压
	 */
	public float getUbc() {
		return (float) ((double) mPacket._ubc / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * ca相电压
	 */
	public float getUca() {
		return (float) ((double) mPacket._uca / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * a相电流
	 */
	public float getIa() {
		return (float) ((double) mPacket._ia / 10000 * Math.pow(10, mPacket._dct));
	}

	/**
	 * b相电流
	 */
	public float getIb() {
		return (float) ((double) mPacket._ib / 10000 * Math.pow(10, mPacket._dct));
	}

	/**
	 * c相电流
	 */
	public float getIc() {
		return (float) ((double) mPacket._ic / 10000 * Math.pow(10, mPacket._dct));
	}

	// ADD
	/**
	 * 频率
	 */
	public float getFreq() {
		return (float) (double) mPacket._freq / 100;
	}

	/**
	 * A相有功功率
	 */
	public float getPa() {
		return (float) (((double) mPacket._pa / 10000) * Math.pow(10, mPacket._dqt));
	}

	/**
	 * B相有功功率
	 */
	public float getPb() {
		return (float) ((double) mPacket._pb / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * C相有功功率
	 */
	public float getPc() {
		return (float) ((double) mPacket._pc / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * 三相有功功率
	 */
	public float getPTotal() {
		return (float) ((double) mPacket._ptotal / 10000 * Math.pow(10, mPacket._dqt));
	}

	// ADD
	/**
	 * A相无功功率
	 */
	public float getQa() {
		return (float) (((double) mPacket._qa / 10000) * Math.pow(10, mPacket._dqt));
	}

	/**
	 * B相无功功率
	 */
	public float getQb() {
		return (float) ((double) mPacket._qb / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * C相无功功率
	 */
	public float getQc() {
		return (float) ((double) mPacket._qc / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * 三相无功功率
	 */
	public float getQTotal() {
		return (float) ((double) mPacket._qtotal / 10000 * Math.pow(10, mPacket._dqt));
	}

	// ADD
	/**
	 * A相视在功率
	 */
	public float getSa() {
		return (float) (((double) mPacket._sa / 10000) * Math.pow(10, mPacket._dqt));
	}

	/**
	 * B相视在功率
	 */
	public float getSb() {
		return (float) ((double) mPacket._sb / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * C相视在功率
	 */
	public float getSc() {
		return (float) ((double) mPacket._sc / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * 三相视在功率
	 */
	public float getSTotal() {
		return (float) ((double) mPacket._stotal / 10000 * Math.pow(10, mPacket._dqt));
	}

	//
	/**
	 * A相功率因数
	 */
	public float getPFA() {
		return (float) ((double) mPacket._pfa / 1000);
	}

	/**
	 * B相功率因数
	 */
	public float getPFB() {
		return (float) ((double) mPacket._pfb / 1000);
	}

	/**
	 * C相功率因数
	 */
	public float getPFC() {
		return (float) ((double) mPacket._pfc / 1000);
	}

	/**
	 * 三相功率因数
	 */
	public float getPFTotal() {
		return (float) ((double) mPacket._pftotal / 1000);
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
		mJson.put("ua", getUa());
		mJson.put("ub", getUb());
		mJson.put("uc", getUc());
		mJson.put("uab", getUab());
		mJson.put("ubc", getUbc());
		mJson.put("uca", getUca());
		mJson.put("ia", getIa());
		mJson.put("ib", getIb());
		mJson.put("ic", getIc());
		// ADD
		mJson.put("freq", getFreq());

		mJson.put("pa", getPa());
		mJson.put("pb", getPb());
		mJson.put("pc", getPc());
		mJson.put("pt", getPTotal());
		// ADD
		mJson.put("qa", getQa());
		mJson.put("qb", getQb());
		mJson.put("qc", getQc());
		mJson.put("qt", getQTotal());
		// ADD
		mJson.put("sa", getSa());
		mJson.put("sb", getSb());
		mJson.put("sc", getSc());
		mJson.put("st", getSTotal());
		// ADD
		mJson.put("pfa", getPFA());
		mJson.put("pfb", getPFB());
		mJson.put("pfc", getPFC());
		mJson.put("pft", getPFTotal());
		mJson.put("epi", getEpi());
		mJson.put("eql", getEql());
		return mJson;
	}

	@Override
	public String getType() {
		return "eqa300";
	}

}
