package com.heshun.modbus.entity;

public class DefaultConvert extends AbsJsonConvert<DefaultDevicePacket> {

	public DefaultConvert(DefaultDevicePacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "default";
	}

}
