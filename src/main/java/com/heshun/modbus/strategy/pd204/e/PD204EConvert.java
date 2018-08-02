package com.heshun.modbus.strategy.pd204.e;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class PD204EConvert extends AbsJsonConvert<PD204EPacket> {

	public PD204EConvert(PD204EPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "PD204E";
	}

	@Override
	public JSONObject toJsonObj(int logoType) {
		mJson.put("ua", mPacket.getUan());
		mJson.put("ub", mPacket.getUbn());
		mJson.put("uc", mPacket.getUcn());
		mJson.put("uab", mPacket.getUab());
		mJson.put("ubc", mPacket.getUbc());
		mJson.put("uca", mPacket.getUca());
		mJson.put("ia", mPacket.getIa());
		mJson.put("ib", mPacket.getIb());
		mJson.put("ic", mPacket.getIc());
		
		mJson.put("pa", mPacket.getPa());
		mJson.put("pb", mPacket.getPb());
		mJson.put("pc", mPacket.getPc());
		mJson.put("pt", mPacket.getPtotal());
		mJson.put("qa", mPacket.getQa());
		mJson.put("qb", mPacket.getQb());
		mJson.put("qc", mPacket.getQc());
		mJson.put("qt", mPacket.getQtotal());
		mJson.put("st", mPacket.getS());
		mJson.put("pft", mPacket.getPf());
		mJson.put("freq", mPacket.getHz());
		mJson.put("epi", mPacket.getPpd());
		mJson.put("epe", mPacket.getMpd());
		mJson.put("eql", mPacket.getPqd());
		mJson.put("eqc", mPacket.getMqd());
		return super.toJsonObj(logoType);
	}

}
