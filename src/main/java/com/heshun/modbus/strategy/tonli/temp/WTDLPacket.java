package com.heshun.modbus.strategy.tonli.temp;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class WTDLPacket extends DefaultDevicePacket{

	public WTDLPacket(int address) {
		super(address);
	}
	public short t_a;
	public short t_b;
	public short t_c;
	public short t_d;
	 
}
