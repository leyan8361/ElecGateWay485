
package com.heshun.modbus.strategy.enertech.yht2_tr;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class YHT2TRConvert extends AbsJsonConvert<YHT2TRPacket> {

	public YHT2TRConvert(YHT2TRPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "infrared";
	}

	/**
	 * 获取虚拟cpu
	 */
	public int getAddress() {
		return mPacket.address;
	}

	@Override
	public JSONObject toJsonObj(int logotype) {
		super.toJsonObj(logotype);
		mJson.put("address", getAddress());
		mJson.put("busbarWarn",mPacket.busbarWarn);
		mJson.put("contactWarn", mPacket.contactWarn);
		//
		mJson.put("contactAUp", mPacket.contactAUp);
		mJson.put("contactBUp", mPacket.contactBUp);
		mJson.put("contactCUp", mPacket.contactCUp);
		mJson.put("contactADown", mPacket.contactADown);
		mJson.put("contactBDown", mPacket.contactBDown);
		mJson.put("contactCDown", mPacket.contactCDown);
		//
		mJson.put("busbarAUp", mPacket.busbarAUp);
		mJson.put("busbarBUp", mPacket.busbarBUp);
		mJson.put("busbarCUp", mPacket.busbarCUp);
		mJson.put("busbarADown", mPacket.busbarADown);
		mJson.put("busbarBDown", mPacket.busbarBDown);
		mJson.put("busbarCDown", mPacket.busbarCDown);
		
		mJson.put("AUp", mPacket.busbarAUp);
		mJson.put("BUp", mPacket.busbarBUp);
		mJson.put("CUp", mPacket.busbarCUp);
		//
		mJson.put("ADown", mPacket.busbarADown);
		mJson.put("BDown", mPacket.busbarBDown);
		mJson.put("CDown", mPacket.busbarCDown);
		mJson.put("address", mPacket.address);

		mJson.put("type", "infrared");
		mJson.put("fanStatus", 0);
		mJson.put("deviceStatus", "1");
		
		return mJson;
	}

}
