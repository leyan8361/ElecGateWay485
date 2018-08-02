package com.heshun.modbus.strategy.pd194z._1;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class PD194ZPacket extends DefaultDevicePacket {

	public float _ua;
	public float _ub;
	public float _uc;

	public float _uab;
	public float _ubc;
	public float _uca;

	public float _ia;
	public float _ib;
	public float _ic;

	// ADD
	public float _freq;

	public float _pa;
	public float _pb;
	public float _pc;
	public float _ptotal;

	// ADD
	public float _qa;
	public float _qb;
	public float _qc;
	public float _qtotal;

	// ADD
	public float _sa;
	public float _sb;
	public float _sc;
	public float _stotal;

	public float _pfa;
	public float _pfb;
	public float _pfc;
	public float _pftotal;

	public float _epi;

	// ADD
	public float _eql;

	public PD194ZPacket(int address) {
		super(address);
	}

	public void set_ua(float _ua) {
		this._ua = _ua;
	}

	public void set_ub(float _ub) {
		this._ub = _ub;
	}

	public void set_uc(float _uc) {
		this._uc = _uc;
	}

	public void set_uab(float _uab) {
		this._uab = _uab;
	}

	public void set_ubc(float _ubc) {
		this._ubc = _ubc;
	}

	public void set_uca(float _uca) {
		this._uca = _uca;
	}

	public void set_ia(float _ia) {
		this._ia = _ia;
	}

	public void set_ib(float _ib) {
		this._ib = _ib;
	}

	public void set_ic(float _ic) {
		this._ic = _ic;
	}

	public void set_freq(float _freq) {
		this._freq = _freq;
	}

	public void set_pa(float _pa) {
		this._pa = _pa;
	}

	public void set_pb(float _pb) {
		this._pb = _pb;
	}

	public void set_pc(float _pc) {
		this._pc = _pc;
	}

	public void set_ptotal(float _ptotal) {
		this._ptotal = _ptotal;
	}

	public void set_qa(float _qa) {
		this._qa = _qa;
	}

	public void set_qb(float _qb) {
		this._qb = _qb;
	}

	public void set_qc(float _qc) {
		this._qc = _qc;
	}

	public void set_qtotal(float _qtotal) {
		this._qtotal = _qtotal;
	}

	public void set_sa(float _sa) {
		this._sa = _sa;
	}

	public void set_sb(float _sb) {
		this._sb = _sb;
	}

	public void set_sc(float _sc) {
		this._sc = _sc;
	}

	public void set_stotal(float _stotal) {
		this._stotal = _stotal;
	}

	public void set_pfa(float _pfa) {
		this._pfa = _pfa;
	}

	public void set_pfb(float _pfb) {
		this._pfb = _pfb;
	}

	public void set_pfc(float _pfc) {
		this._pfc = _pfc;
	}

	public void set_pftotal(float _pftotal) {
		this._pftotal = _pftotal;
	}

	public void set_epi(float _epi) {
		this._epi = _epi;
	}

	public void set_eql(float _eql) {
		this._eql = _eql;
	}

	/**
	 * 以上字段用于存储原始报文信息,对于这些字段，只提供set方法
	 */
  
}
