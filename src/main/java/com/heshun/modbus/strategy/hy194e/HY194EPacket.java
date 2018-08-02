package com.heshun.modbus.strategy.hy194e;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class HY194EPacket extends DefaultDevicePacket{

	public HY194EPacket(int address) {
		super(address);
	}
	//各相电压
	public short _ua;
	public short _ub;
	public short _uc;
	//各相线电压
	public short _uab;
	public short _uca;
	public short _ubc;
	//各相电流
	public short _ia;
	public short _ib;
	public short _ic;
	//功率、功率因数符号位0 high 1 low
	public byte[] _pdp;
	
	
	//各相有功功率
	public short _pa;
	public short _pb;
	public short _pc;
	public short _ptotal;
	//各相无功功率
	public short _qa;
	public short _qb;
	public short _qc;
	public short _qtotal;
	//各相视在功率
	public short _sa;
	public short _sb;
	public short _sc;
	public short _stotal;
	//各相功率因数
	public short _pfa;
	public short _pfb;
	public short _pfc;
	public short _pftotal;
	//频率
	public short _hz;
	
	
	
	//正有功 整数4byte 小数2byte
	public float _pp;
	//（保留）负有功 整数4byte 小数2byte
	public float _mp;
	//感性无功 整数4byte 小数2byte
	public float _iq;
	
	
	public void set_ua(short _ua) {
		this._ua = _ua;
	}
	public void set_ub(short _ub) {
		this._ub = _ub;
	}
	public void set_uc(short _uc) {
		this._uc = _uc;
	}
	public void set_uab(short _uab) {
		this._uab = _uab;
	}
	public void set_uca(short _uca) {
		this._uca = _uca;
	}
	public void set_ubc(short _ubc) {
		this._ubc = _ubc;
	}
	public void set_ia(short _ia) {
		this._ia = _ia;
	}
	public void set_ib(short _ib) {
		this._ib = _ib;
	}
	public void set_ic(short _ic) {
		this._ic = _ic;
	}
	public void set_pdp(byte[] _pdp) {
		this._pdp = _pdp;
	}
	public void set_pa(short _pa) {
		this._pa = _pa;
	}
	public void set_pb(short _pb) {
		this._pb = _pb;
	}
	public void set_pc(short _pc) {
		this._pc = _pc;
	}
	public void set_ptotal(short _ptotal) {
		this._ptotal = _ptotal;
	}
	public void set_qa(short _qa) {
		this._qa = _qa;
	}
	public void set_qb(short _qb) {
		this._qb = _qb;
	}
	public void set_qc(short _qc) {
		this._qc = _qc;
	}
	public void set_qtotal(short _qtotal) {
		this._qtotal = _qtotal;
	}
	public void set_sa(short _sa) {
		this._sa = _sa;
	}
	public void set_sb(short _sb) {
		this._sb = _sb;
	}
	public void set_sc(short _sc) {
		this._sc = _sc;
	}
	public void set_stotal(short _stotal) {
		this._stotal = _stotal;
	}
	public void set_pfa(short _pfa) {
		this._pfa = _pfa;
	}
	public void set_pfb(short _pfb) {
		this._pfb = _pfb;
	}
	public void set_pfc(short _pfc) {
		this._pfc = _pfc;
	}
	public void set_pftotal(short _pftotal) {
		this._pftotal = _pftotal;
	}
	public void set_hz(short _hz) {
		this._hz = _hz;
	}
	public void set_pp(float _pp) {
		this._pp = _pp;
	}
	public void set_mp(float _mp) {
		this._mp = _mp;
	}
	public void set_iq(float _iq) {
		this._iq = _iq;
	}
}
