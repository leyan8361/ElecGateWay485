package com.heshun.modbus.strategy.acrel.h;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class PZ96LE4HConvert extends AbsJsonConvert<PZ96LE4HPacket> {

	public PZ96LE4HConvert(PZ96LE4HPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "PZ96LE4H";
	}

	private float formatU(short _original) {
		return (float) ((double) _original / 10);
	}

	private float formatI_PF(short _original) {
		return (float) ((double) _original / 1000);
	}

	private float formatPQSK(long _original) {
		return (float) ((double) _original / 100);
	}

	private float[] formatXB(short[] _original) {
		float[] result = new float[30];
		for (int i = 0; i < _original.length; i++) {
			result[i] = formatPQSK(_original[i]);
		}
		return result;
	}

	private double formatDN(long _original) {
		return (double) ((double) _original / 100);
	}

	@Override
	public JSONObject toJsonObj(int logoType) {
		mJson.put("in", formatI_PF(mPacket._ia));
		mJson.put("ua", formatU(mPacket._uan));
		mJson.put("ub", formatU(mPacket._ubn));
		mJson.put("uc", formatU(mPacket._ucn));
		mJson.put("uab", formatU(mPacket._uab));
		mJson.put("ubc", formatU(mPacket._ubc));
		mJson.put("uca", formatU(mPacket._uca));

		mJson.put("ia", formatI_PF(mPacket._ia));
		mJson.put("ib", formatI_PF(mPacket._ib));
		mJson.put("ic", formatI_PF(mPacket._ic));

		mJson.put("freq", (float) ((double) mPacket._freq / 100));

		mJson.put("pa", formatPQSK(mPacket._pa));
		mJson.put("pb", formatPQSK(mPacket._pb));
		mJson.put("pc", formatPQSK(mPacket._pc));
		mJson.put("pt", formatPQSK(mPacket._pt));

		mJson.put("qa", formatPQSK(mPacket._qa));
		mJson.put("qb", formatPQSK(mPacket._qb));
		mJson.put("qc", formatPQSK(mPacket._qc));
		mJson.put("qt", formatPQSK(mPacket._qt));

		mJson.put("sa", formatPQSK(mPacket._sa));
		mJson.put("sb", formatPQSK(mPacket._sb));
		mJson.put("sc", formatPQSK(mPacket._sc));
		mJson.put("st", formatPQSK(mPacket._st));

		mJson.put("pfa", formatI_PF(mPacket._pfa));
		mJson.put("pfb", formatI_PF(mPacket._pfb));
		mJson.put("pfc", formatI_PF(mPacket._pfc));
		mJson.put("pft", formatI_PF(mPacket._pft));

		mJson.put("epi", String.valueOf(formatDN(mPacket._epi)));
		mJson.put("eql", String.valueOf(formatDN(mPacket._eql)));

		mJson.put("hdva", formatXB(mPacket.hdva));
		mJson.put("hdvb", formatXB(mPacket.hdvb));
		mJson.put("hdvc", formatXB(mPacket.hdvc));
		mJson.put("hdia", formatXB(mPacket.hdia));
		mJson.put("hdib", formatXB(mPacket.hdib));
		mJson.put("hdic", formatXB(mPacket.hdic));

		mJson.put("jbua", formatPQSK(mPacket.jbua));
		mJson.put("jbub", formatPQSK(mPacket.jbub));
		mJson.put("jbuc", formatPQSK(mPacket.jbuc));
		mJson.put("jbia", formatPQSK(mPacket.jbia));
		mJson.put("jbib", formatPQSK(mPacket.jbib));
		mJson.put("jbic", formatPQSK(mPacket.jbic));

		return super.toJsonObj(logoType);
	}
}
