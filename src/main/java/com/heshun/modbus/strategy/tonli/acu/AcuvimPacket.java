package com.heshun.modbus.strategy.tonli.acu;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class AcuvimPacket extends DefaultDevicePacket {

	public int pt1;
	public int pt2;
	public int ct;
 

	public int _ua;
	public int _ub;
	public int _uc;

	public int _uab;
	public int _ubc;
	public int _uca;

	public int _ia;
	public int _ib;
	public int _ic;

	// ADD
	public int _freq;

	public int _pa;
	public int _pb;
	public int _pc;
	public int _ptotal;

	// ADD
	public int _qa;
	public int _qb;
	public int _qc;
	public int _qtotal;

	// ADD
	public int _sa;
	public int _sb;
	public int _sc;
	public int _stotal;

	public int _pfa;
	public int _pfb;
	public int _pfc;
	public int _pftotal;

	public long _epi;

	// ADD
	public long _eql;

	public AcuvimPacket(int address) {
		super(address);
	}

	/**
	 * 以上字段用于存储原始报文信息,对于这些字段，只提供set方法
	 */

	public void setPt1(long pt1) {
		this.pt1 = (int)pt1;
	}

	public void setPt2(int pt2) {
		this.pt2 = pt2;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	public void set_ua(int _ua) {
		this._ua = _ua;
	}



	public void set_ub(int _ub) {
		this._ub = _ub;
	}

	public void set_uc(int _uc) {
		this._uc = _uc;
	}

	public void set_uab(int _uab) {
		this._uab = _uab;
	}

	public void set_ubc(int _ubc) {
		this._ubc = _ubc;
	}

	public void set_uca(int _uca) {
		this._uca = _uca;
	}

	public void set_ia(int _ia) {
		this._ia = _ia;
	}

	public void set_ib(int _ib) {
		this._ib = _ib;
	}

	public void set_ic(int _ic) {
		this._ic = _ic;
	}

	public void set_pa(int _pa) {
		this._pa = _pa;
	}

	public void set_pb(int _pb) {
		this._pb = _pb;
	}

	public void set_pc(int _pc) {
		this._pc = _pc;
	}

	public void set_ptotal(int _ptotal) {
		this._ptotal = _ptotal;
	}

	public void set_pfa(int _pfa) {
		this._pfa = _pfa;
	}

	public void set_pfb(int _pfb) {
		this._pfb = _pfb;
	}

	public void set_pfc(int _pfc) {
		this._pfc = _pfc;
	}

	public void set_pftotal(int _pftotal) {
		this._pftotal = _pftotal;
	}

	// ADD
	public void set_freq(int _freq) {
		this._freq = _freq;
	}

	public void set_qa(int _qa) {
		this._qa = _qa;
	}

	public void set_qb(int _qb) {
		this._qb = _qb;
	}

	public void set_qc(int _qc) {
		this._qc = _qc;
	}

	public void set_qtotal(int _qtotal) {
		this._qtotal = _qtotal;
	}

	public void set_sa(int _sa) {
		this._sa = _sa;
	}

	public void set_sb(int _sb) {
		this._sb = _sb;
	}

	public void set_sc(int _sc) {
		this._sc = _sc;
	}

	public void set_stotal(int _stotal) {
		this._stotal = _stotal;
	}

	public void set_epi(long _epi) {
		this._epi = _epi;
	}

	public void set_eql(long _eql) {
		this._eql = _eql;
	}

}
