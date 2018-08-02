package com.heshun.modbus.strategy.eqa300.h;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class EQA300HConvert extends AbsJsonConvert<EQA300HPacket> {

	public EQA300HConvert(EQA300HPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "eqa300h";
	}

	public String getEDDY() {
		String dy = "380";
		switch (mPacket.eddy) {
		case 0:
			dy = "380";
			break;
		case 1:
			dy = "220";
			break;
		case 2:
			dy = "100";
			break;
		case 3:
			dy = "57.7";
			break;

		default:
			dy = "380";
			break;
		}
		return dy;
	}

	public String getEDDL() {
		String dy = "200";
		switch (mPacket.eddy) {
		case 0:
			dy = "200";
			break;
		case 1:
			dy = "100";
			break;
		case 2:
			dy = "50";
			break;
		case 3:
			dy = "20";
			break;
		case 4:
			dy = "5";
			break;
		case 5:
			dy = "1";
			break;

		default:
			dy = "200";
			break;
		}
		return dy;
	}

	/**
	 * A相电压
	 */
	public float getUa() {
		return (float) ((double) mPacket.ua / 10000 * Math.pow(10, mPacket.dpt));
	}

	/**
	 * B相电压
	 */
	public float getUb() {
		return (float) ((double) mPacket.ub / 10000 * Math.pow(10, mPacket.dpt));
	}

	/**
	 * C相电压
	 */
	public float getUc() {
		return (float) ((double) mPacket.uc / 10000 * Math.pow(10, mPacket.dpt));
	}

	/**
	 * ab相电压
	 */
	public float getUab() {
		return (float) ((double) mPacket.uab / 10000 * Math.pow(10, mPacket.dpt));
	}

	/**
	 * bc相电压
	 */
	public float getUbc() {
		return (float) ((double) mPacket.ubc / 10000 * Math.pow(10, mPacket.dpt));
	}

	/**
	 * ca相电压
	 */
	public float getUca() {
		return (float) ((double) mPacket.uca / 10000 * Math.pow(10, mPacket.dpt));
	}

	/**
	 * a相电流
	 */
	public float getIa() {
		return (float) ((double) mPacket.ia / 10000 * Math.pow(10, mPacket.dct));
	}

	/**
	 * b相电流
	 */
	public float getIb() {
		return (float) ((double) mPacket.ib / 10000 * Math.pow(10, mPacket.dct));
	}

	/**
	 * c相电流
	 */
	public float getIc() {
		return (float) ((double) mPacket.ic / 10000 * Math.pow(10, mPacket.dct));
	}

	/**
	 * n相电流
	 */
	public float getIn() {
		return (float) ((double) mPacket.in / 10000 * Math.pow(10, mPacket.dct));
	}

	/**
	 * 频率
	 */
	public float getFreq() {
		return (float) (double) mPacket.freq / 100;
	}

	/**
	 * A相有功功率
	 */
	public float getPa() {
		return (float) (((double) mPacket.pa / 10000) * Math.pow(10, mPacket.dqt));
	}

	/**
	 * B相有功功率
	 */
	public float getPb() {
		return (float) ((double) mPacket.pb / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * C相有功功率
	 */
	public float getPc() {
		return (float) ((double) mPacket.pc / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * 三相有功功率
	 */
	public float getPTotal() {
		return (float) ((double) mPacket.pTotal / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * A相无功功率
	 */
	public float getQa() {
		return (float) (((double) mPacket.qa / 10000) * Math.pow(10, mPacket.dqt));
	}

	/**
	 * B相无功功率
	 */
	public float getQb() {
		return (float) ((double) mPacket.qb / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * C相无功功率
	 */
	public float getQc() {
		return (float) ((double) mPacket.qc / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * 三相无功功率
	 */
	public float getQTotal() {
		return (float) ((double) mPacket.qTotal / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * A相视在功率
	 */
	public float getSa() {
		return (float) (((double) mPacket.sa / 10000) * Math.pow(10, mPacket.dqt));
	}

	/**
	 * B相视在功率
	 */
	public float getSb() {
		return (float) ((double) mPacket.sb / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * C相视在功率
	 */
	public float getSc() {
		return (float) ((double) mPacket.sc / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * 三相视在功率
	 */
	public float getSTotal() {
		return (float) ((double) mPacket.sTotal / 10000 * Math.pow(10, mPacket.dqt));
	}

	/**
	 * A相功率因数
	 */
	public float getPFA() {
		return (float) ((double) mPacket.pfa / 1000);
	}

	/**
	 * B相功率因数
	 */
	public float getPFB() {
		return (float) ((double) mPacket.pfb / 1000);
	}

	/**
	 * C相功率因数
	 */
	public float getPFC() {
		return (float) ((double) mPacket.pfc / 1000);
	}

	/**
	 * 三相功率因数
	 */
	public float getPFTotal() {
		return (float) ((double) mPacket.pfTotal / 1000);
	}

	/**
	 * 吸收有功总电度二次侧
	 */
	public String getEpi() {
		return String.valueOf(mPacket.epi);
	}

	/**
	 * 释放有功总电度二次侧
	 */
	public String getEpe() {
		return String.valueOf(mPacket.epe);
	}

	/**
	 * 感性误工总电度二次侧
	 */
	public String getEql() {
		return String.valueOf(mPacket.eql);
	}

	/**
	 * 容性无功总电度二次侧
	 */
	public String getEqc() {
		return String.valueOf(mPacket.eqc);
	}

	public short[] getHDVA() {
		return mPacket.hdva;
	}

	public short[] getHDVB() {
		return mPacket.hdvb;
	}

	public short[] getHDVC() {
		return mPacket.hdvc;
	}

	public short[] getHDIA() {
		return mPacket.hdia;
	}

	public short[] getHDIB() {
		return mPacket.hdib;
	}

	public short[] getHDIC() {
		return mPacket.hdic;
	}

	public float getTHDVA() {
		return (float) ((double) mPacket.thdva / 1000);
	}

	public float getTHDVB() {
		return (float) ((double) mPacket.thdvb / 1000);
	}

	public float getTHDVC() {
		return (float) ((double) mPacket.thdvc / 1000);
	}

	public float getTHDIA() {
		return (float) ((double) mPacket.thdia / 1000);
	}

	public float getTHDIB() {
		return (float) ((double) mPacket.thdib / 1000);
	}

	public float getTHDIC() {
		return (float) ((double) mPacket.thdic / 1000);
	}

	public float getUNBL() {
		return (float) ((double) mPacket.u_nbl / 1000);
	}

	public float getINBL() {
		return (float) ((double) mPacket.i_nbl / 1000);
	}

	public float getKFA() {
		return (float) ((double) mPacket.kf_a / 1000);
	}

	public float getKFB() {
		return (float) ((double) mPacket.kf_b / 1000);
	}

	public float getKFC() {
		return (float) ((double) mPacket.kf_c / 1000);
	}

	public float getCFA() {
		return (float) ((double) mPacket.cf_a / 1000);
	}

	public float getCFB() {
		return (float) ((double) mPacket.cf_b / 1000);
	}

	public float getCFC() {
		return (float) ((double) mPacket.cf_c / 1000);
	}

	@Override
	public JSONObject toJsonObj(int lo) {
		// mJson
		mJson.put("eddy", getEDDY());
		mJson.put("eddl", getEDDL());
		mJson.put("ua", getUa());
		mJson.put("ub", getUb());
		mJson.put("uc", getUc());
		mJson.put("uab", getUab());
		mJson.put("ubc", getUbc());
		mJson.put("uca", getUca());
		mJson.put("ia", getIa());
		mJson.put("ib", getIb());
		mJson.put("ic", getIc());

		mJson.put("freq", getFreq());

		mJson.put("pa", getPa());
		mJson.put("pb", getPb());
		mJson.put("pc", getPc());
		mJson.put("pt", getPTotal());
		//
		mJson.put("qa", getQa());
		mJson.put("qb", getQb());
		mJson.put("qc", getQc());
		mJson.put("qt", getQTotal());
		//
		mJson.put("sa", getSa());
		mJson.put("sb", getSb());
		mJson.put("sc", getSc());
		mJson.put("st", getSTotal());
		//
		mJson.put("pfa", getPFA());
		mJson.put("pfb", getPFB());
		mJson.put("pfc", getPFC());
		mJson.put("pft", getPFTotal());
		//
		mJson.put("epi", getEpi());
		mJson.put("eql", getEql());
		//
		mJson.put("hdva", getHDVA());
		mJson.put("hdvb", getHDVB());
		mJson.put("hdvc", getHDVC());
		mJson.put("hdia", getHDIA());
		mJson.put("hdib", getHDIB());
		mJson.put("hdic", getHDIC());
		//
		mJson.put("thdva", getTHDVA());
		mJson.put("thdvb", getTHDVB());
		mJson.put("thdvc", getTHDVC());
		mJson.put("thdia", getTHDIA());
		mJson.put("thdib", getTHDIB());
		mJson.put("thdic", getTHDIC());
		mJson.put("unbl", getUNBL());
		mJson.put("inbl", getINBL());
		//
		mJson.put("kfa", getKFA());
		mJson.put("kfb", getKFB());
		mJson.put("kfc", getKFC());
		mJson.put("cfa", getCFA());
		mJson.put("cfb", getCFB());
		mJson.put("cfc", getCFC());
		return super.toJsonObj(lo);
	}
}
