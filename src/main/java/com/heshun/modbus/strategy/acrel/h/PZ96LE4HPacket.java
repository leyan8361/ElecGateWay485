package com.heshun.modbus.strategy.acrel.h;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class PZ96LE4HPacket extends DefaultDevicePacket {

	public PZ96LE4HPacket(int address) {
		super(address);
	}

	public short _in;
	public short _uan;
	public short _ubn;
	public short _ucn;
	public short _uab;
	public short _ubc;
	public short _uca;
	public short _ia;
	public short _ib;
	public short _ic;
	public short _freq;
	public long _pa;
	public long _pb;
	public long _pc;
	public long _pt;
	public long _qa;
	public long _qb;
	public long _qc;
	public long _qt;
	public long _sa;
	public long _sb;
	public long _sc;
	public long _st;
	public short _pfa;
	public short _pfb;
	public short _pfc;
	public short _pft;

	public long _epi;
	public long _epe;
	public long _eql;
	public long _eqc;

	public short[] hdva = new short[30];
	public short[] hdvb = new short[30];
	public short[] hdvc = new short[30];
	public short[] hdia = new short[30];
	public short[] hdib = new short[30];
	public short[] hdic = new short[30];

	public short jbua;
	public short jbub;
	public short jbuc;
	public short jbia;
	public short jbib;
	public short jbic;

	public void setHdva(short[] hdva) {
		this.hdva = hdva;
	}

	public void setHdvb(short[] hdvb) {
		this.hdvb = hdvb;
	}

	public void setHdvc(short[] hdvc) {
		this.hdvc = hdvc;
	}

	public void setHdia(short[] hdia) {
		this.hdia = hdia;
	}

	public void setHdib(short[] hdib) {
		this.hdib = hdib;
	}

	public void setHdic(short[] hdic) {
		this.hdic = hdic;
	}
}
