package com.heshun.modbus.strategy.tonli.acu;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class AcuvimConvert extends AbsJsonConvert<AcuvimPacket> {

	public AcuvimConvert(AcuvimPacket packet) {
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
		return origin * (((float) mPacket.pt1 / (float) mPacket.pt2) / 10);
	}

	/**
	 * a相电流
	 */
	public float getI(int origin) {
		return origin * ((float) mPacket.ct / 5) / 1000;
	}

	// ADD
	/**
	 * 频率
	 */
	public float getFreq() {
		return (float) (double) mPacket._freq / 100;
	}

	/**
	 * A相有功功率 P ＝ Rx× (PT1/PT2)× (CT1/ 5)
	 */
	public float getPQS(int origin) {
		return origin * (((float) mPacket.pt1 / (float) mPacket.pt2)) * ((float) mPacket.ct / 5);
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
		mJson.put("pt", getPQS(mPacket._ptotal));
		// ADD
		mJson.put("qa", getPQS(mPacket._qa));
		mJson.put("qb", getPQS(mPacket._qb));
		mJson.put("qc", getPQS(mPacket._qc));
		mJson.put("qt", getPQS(mPacket._qtotal));
		// ADD
		mJson.put("sa", getPQS(mPacket._sa));
		mJson.put("sb", getPQS(mPacket._sb));
		mJson.put("sc", getPQS(mPacket._sc));
		mJson.put("st", getPQS(mPacket._stotal));
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
