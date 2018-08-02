package com.heshun.modbus.strategy.enertech.yht2_tr;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class YHT2TRPacket extends DefaultDevicePacket{

	public YHT2TRPacket(int address) {
		super(address);
	}
	public short contactWarn;
	public short busbarWarn;
	
	//
	public short contactAUp;
	public short contactBUp;
	public short contactCUp;
	//
	public short contactADown;
	public short contactBDown;
	public short contactCDown;
	//
	//
	//
	public short busbarAUp;
	public short busbarBUp;
	public short busbarCUp;
	//
	public short busbarADown;
	public short busbarBDown;
	public short busbarCDown;
}
