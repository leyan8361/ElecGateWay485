package com.heshun.modbus.strategy.tonli.pilot;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class SPM32Convert extends AbsJsonConvert<SPM32Packet> {

	public SPM32Convert(SPM32Packet packet) {
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
	public float getU(int origin) {
		return origin * 0.01f;
	}

	/**
	 * a相电流
	 */
	public float getI(int origin) {
		return origin * 0.001f;
	}

	// ADD
	/**
	 * 频率
	 */
	public float getFreq() {
		return (float) (double) mPacket._freq / 100;
	}

	public float getPQS(int origin) {
		return origin * 0.1f;
	}

	public double getPQST(long origin) {
		return origin * 0.1d;
	}

	//
	/**
	 * A相功率因数
	 */
	public float getPF(int origin) {
		return (float) ((double) mPacket._pfa / 1000);
	}

	public String getEpi() {
		return String.valueOf((double) mPacket._epi / 10);
	}

	public String getEql() {
		return String.valueOf((double) mPacket._eql / 10);
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
		mJson.put("freq", getFreq());

		mJson.put("pa", getPQS(mPacket._pa));
		mJson.put("pb", getPQS(mPacket._pb));
		mJson.put("pc", getPQS(mPacket._pc));

		// ADD
		mJson.put("qa", getPQS(mPacket._qa));
		mJson.put("qb", getPQS(mPacket._qb));
		mJson.put("qc", getPQS(mPacket._qc));

		// ADD
		mJson.put("sa", getPQS(mPacket._sa));
		mJson.put("sb", getPQS(mPacket._sb));
		mJson.put("sc", getPQS(mPacket._sc));
		mJson.put("pt", getPQST(mPacket._ptotal));
		mJson.put("qt", getPQST(mPacket._qtotal));
		mJson.put("st", getPQST(mPacket._stotal));
		// ADD
		mJson.put("pfa", getPF(mPacket._pfa));
		mJson.put("pfb", getPF(mPacket._pfb));
		mJson.put("pfc", getPF(mPacket._pfc));
		mJson.put("pft", getPF(mPacket._pftotal));
		mJson.put("epi", getEpi());
		mJson.put("eql", getEql());
		return mJson;
	}

	@Override
	public String getType() {
		return "eqa300";
	}
}
