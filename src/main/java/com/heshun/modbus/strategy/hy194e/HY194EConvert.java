package com.heshun.modbus.strategy.hy194e;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;
import com.heshun.modbus.util.Utils;

public class HY194EConvert extends AbsJsonConvert<HY194EPacket> {
	private int[] symbols = new int[12];

	public HY194EConvert(String logotype, HY194EPacket packet) {
		super(packet);
		symbols = getSymbol(packet._pdp);
	}

	/**
	 * 获取虚拟cpu
	 */
	public int getAddress() {
		return mPacket.address;
	}

	public float getUA() {
		return (float) mPacket._ua;
	}

	public float getUB() {
		return (float) mPacket._ub;
	}

	public float getUC() {
		return (float) mPacket._uc;
	}

	public float getUAB() {
		return (float) mPacket._uab;
	}

	public float getUCA() {
		return (float) mPacket._uca;
	}

	public float getUBC() {
		return (float) mPacket._ubc;
	}

	public float getIA() {
		return (float) mPacket._ia;
	}

	public float getIB() {
		return (float) mPacket._ib;
	}

	public float getIC() {
		return (float) mPacket._ic;
	}

	public float getPA() {
		return (float) mPacket._pa * symbols[0];
	}

	public float getPB() {
		return (float) mPacket._pb * symbols[1];
	}

	public float getPC() {
		return (float) mPacket._pc * symbols[2];
	}

	public float getPTotal() {
		return (float) mPacket._ptotal * symbols[3];
	}

	public float getQA() {
		return (float) mPacket._qa * symbols[4];
	}

	public float getQB() {
		return (float) mPacket._qb * symbols[5];
	}

	public float getQC() {
		return (float) mPacket._qc * symbols[6];
	}

	public float getQTotal() {
		return (float) mPacket._qtotal * symbols[7];
	}

	public float getSA() {
		return (float) mPacket._sa;
	}

	public float getSB() {
		return (float) mPacket._sb;
	}

	public float getSC() {
		return (float) mPacket._sc;
	}

	public float getSTotal() {
		return (float) mPacket._stotal;
	}

	public float getPFA() {
		// 0表示感性，1表示容性
		// int symble = symbols[8];
		return (float) (mPacket._pfa) / 1000;
	}

	public float getPFB() {
		// 0表示感性，1表示容性
		// int symble = symbols[9];
		return (float) (mPacket._pfb) / 1000;
	}

	public float getPFC() {
		// 0表示感性，1表示容性
		// int symble = symbols[10];
		return (float) (mPacket._pfc) / 1000;
	}

	public float getPFTotal() {
		// 0表示感性（正向无功），1表示容性
		// int symble = symbols[11];
		return (float) (mPacket._pftotal) / 1000;
	}

	public float getHZ() {
		return (float) (mPacket._hz) / 100;
	}

	public float getPP() {
		return mPacket._pp;
	}

	// 负有功电能不用
	public float getMP() {
		return mPacket._mp;
	}

	public float getIQ() {
		return mPacket._iq;
	}

	/**
	 * 功率符号位、功率因数感容性
	 * 
	 * @param arrays
	 *            pdp的高低位byte数组
	 * @return 符号和感容性数组的合并数组
	 */
	public int[] getSymbol(byte[] arrays) {
		int[] total = new int[12];
		// 各相有功无功符号
		int[] pqSymbol = Utils.getEachBit(arrays[0]);
		int[] temp = new int[8];
		for (int i = 0; i < pqSymbol.length; i++) {
			temp[i] = pqSymbol[i] == 0 ? 1 : -1;
		}
		// 各相功率类型
		int[] pfSymbol = Utils.getEachBit(arrays[1]);
		System.arraycopy(temp, 0, total, 0, pqSymbol.length);
		System.arraycopy(pfSymbol, 0, total, pqSymbol.length, 4);

		return total;
	}

	public JSONObject toJsonObj(int logo) {
		// JSONObject mJson = super.toJsonObj(logotype);
		super.toJsonObj(logo);
		if (mPacket != null) {
			mJson.put("address", getAddress());
			mJson.put("ua", getUA());
			mJson.put("ub", getUB());
			mJson.put("uc", getUC());
			mJson.put("uab", getUAB());
			mJson.put("uca", getUCA());
			mJson.put("ubc", getUBC());
			mJson.put("uia", getIA());
			mJson.put("uib", getIB());
			mJson.put("uic", getIC());

			mJson.put("pa", getPA());
			mJson.put("pb", getPB());
			mJson.put("pc", getPC());
			mJson.put("pt", getPTotal());
			mJson.put("qa", getQA());
			mJson.put("qb", getQB());
			mJson.put("qc", getQC());
			mJson.put("qt", getQTotal());
			mJson.put("sa", getSA());
			mJson.put("sb", getSB());
			mJson.put("sc", getSC());
			mJson.put("st", getSTotal());
			mJson.put("pfa", getPFA());
			mJson.put("pfb", getPFB());
			mJson.put("pfc", getPFC());
			mJson.put("pft", getPFTotal());
			mJson.put("freq", getHZ());

			mJson.put("epi", getPP());
			mJson.put("eql", getIQ());
		}
		return mJson;

	}

	@Override
	public String getType() {
		return "HY194E";
	}

}
