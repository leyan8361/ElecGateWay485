package com.heshun.modbus.strategy.acrel.aem96;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class AEM96Packet  extends DefaultDevicePacket{

	public AEM96Packet(int address) {
		super(address);
	}
 

	public short _ua;
	public short _ub;
	public short _uc;

	public short _uab;
	public short _ubc;
	public short _uca;

	public short _ia;
	public short _ib;
	public short _ic;
	public short _in;

	
	public short _pa;
	public short _pb;
	public short _pc;
	public short _ptotal;

	// ADD
	public short _qa;
	public short _qb;
	public short _qc;
	public short _qtotal;

	// ADD
	public short _sa;
	public short _sb;
	public short _sc;
	public short _stotal;

	public short _pfa;
	public short _pfb;
	public short _pfc;
	public short _pftotal;
	// ADD
		public short _freq;

	public long _epi;

	// ADD
	public long _eql;

}
