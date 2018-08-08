
package com.heshun.modbus.strategy.tonli.temp;

import com.alibaba.fastjson.JSONObject;
import com.heshun.modbus.entity.AbsJsonConvert;

public class WTDLConvert extends AbsJsonConvert<WTDLPacket> {

	public WTDLConvert(WTDLPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "WTDL";
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
		mJson.put("ta", mPacket.t_a);
		mJson.put("tb", mPacket.t_b);
		mJson.put("tc", mPacket.t_c);
		mJson.put("td", mPacket.t_d);

//		mJson.put("fanStatus", 0);
//		mJson.put("deviceStatus", "1");

		return mJson;
	}

}
