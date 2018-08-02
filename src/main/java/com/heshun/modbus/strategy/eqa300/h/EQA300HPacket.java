package com.heshun.modbus.strategy.eqa300.h;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class EQA300HPacket extends DefaultDevicePacket {
	public EQA300HPacket(int address) {
		super(address);
	}

	// command 1
	// 脉冲常数
	// public short mccl;
	// 额定电压
	public short eddy;
	// 额定电流
	public short eddl;
	public short dpt;
	public short dct;
	public short dqt;

	public short ua;
	public short ub;
	public short uc;

	public short uab;
	public short ubc;
	public short uca;

	public short ia;
	public short ib;
	public short ic;
	public short in;
	public short freq;
	// command 2
	public short pa;
	public short pb;
	public short pc;
	public short pTotal;

	public short qa;
	public short qb;
	public short qc;
	public short qTotal;

	public short sa;
	public short sb;
	public short sc;
	public short sTotal;

	public short pfa;
	public short pfb;
	public short pfc;
	public short pfTotal;
	// command 3
	public long epi;
	public long epe;
	public long eql;
	public long eqc;

	// command 4
	public short[] hdva = new short[30];
	// command 5
	public short[] hdvb = new short[30];
	// command 6
	public short[] hdvc = new short[30];
	// command 7
	public short[] hdia = new short[30];
	// command 8
	public short[] hdib = new short[30];
	// command 9
	public short[] hdic = new short[30];
	// command 10
	public short thdva;
	public short thdvb;
	public short thdvc;

	public short thdia;
	public short thdib;
	public short thdic;

	public short u_nbl;
	public short i_nbl;

	public short kf_a;
	public short kf_b;
	public short kf_c;

	public short cf_a;
	public short cf_b;
	public short cf_c;
	// command 11
	public long en2_a_Y_;

	public long en2_a_W_;

	public long en2_a_S_;

	public long en2_b_Y_;

	public long en2_b_W_;

	public long en2_b_S_;

	public long en2_c_Y_;

	public long en2_c_W_;

	public long en2_c_S_;

	// public void setMcch(short mcch) {
	// this.mccl = mcch;
	// }

	public void setEddy(short eddy) {
		this.eddy = eddy;
	}

	public void setEddl(short eddl) {
		this.eddl = eddl;
	}

	public void setDpt(short dpt) {
		this.dpt = dpt;
	}

	public void setDct(short dct) {
		this.dct = dct;
	}

	public void setDqt(short dqt) {
		this.dqt = dqt;
	}

	public void setUa(short ua) {
		this.ua = ua;
	}

	public void setUb(short ub) {
		this.ub = ub;
	}

	public void setUc(short uc) {
		this.uc = uc;
	}

	public void setUab(short uab) {
		this.uab = uab;
	}

	public void setUbc(short ubc) {
		this.ubc = ubc;
	}

	public void setUca(short uca) {
		this.uca = uca;
	}

	public void setIa(short ia) {
		this.ia = ia;
	}

	public void setIb(short ib) {
		this.ib = ib;
	}

	public void setIc(short ic) {
		this.ic = ic;
	}

	public void setIn(short in) {
		this.in = in;
	}

	public void setFreq(short freq) {
		this.freq = freq;
	}

	public void setPa(short pa) {
		this.pa = pa;
	}

	public void setPb(short pb) {
		this.pb = pb;
	}

	public void setPc(short pc) {
		this.pc = pc;
	}

	public void setpTotal(short pTotal) {
		this.pTotal = pTotal;
	}

	public void setQa(short qa) {
		this.qa = qa;
	}

	public void setQb(short qb) {
		this.qb = qb;
	}

	public void setQc(short qc) {
		this.qc = qc;
	}

	public void setqTotal(short qTotal) {
		this.qTotal = qTotal;
	}

	public void setSa(short sa) {
		this.sa = sa;
	}

	public void setSb(short sb) {
		this.sb = sb;
	}

	public void setSc(short sc) {
		this.sc = sc;
	}

	public void setsTotal(short sTotal) {
		this.sTotal = sTotal;
	}

	public void setPfa(short pfa) {
		this.pfa = pfa;
	}

	public void setPfb(short pfb) {
		this.pfb = pfb;
	}

	public void setPfc(short pfc) {
		this.pfc = pfc;
	}

	public void setPfTotal(short pfTotal) {
		this.pfTotal = pfTotal;
	}

	public void setEpi(long epi) {
		this.epi = epi;
	}

	public void setEpe(long epe) {
		this.epe = epe;
	}

	public void setEql(long eql) {
		this.eql = eql;
	}

	public void setEqc(long eqc) {
		this.eqc = eqc;
	}

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

	public void setThdva(short thdva) {
		this.thdva = thdva;
	}

	public void setThdvb(short thdvb) {
		this.thdvb = thdvb;
	}

	public void setThdvc(short thdvc) {
		this.thdvc = thdvc;
	}

	public void setThdia(short thdia) {
		this.thdia = thdia;
	}

	public void setThdib(short thdib) {
		this.thdib = thdib;
	}

	public void setThdic(short thdic) {
		this.thdic = thdic;
	}

	public void setU_nbl(short u_nbl) {
		this.u_nbl = u_nbl;
	}

	public void setI_nbl(short i_nbl) {
		this.i_nbl = i_nbl;
	}

	public void setKf_a(short kf_a) {
		this.kf_a = kf_a;
	}

	public void setKf_b(short kf_b) {
		this.kf_b = kf_b;
	}

	public void setKf_c(short kf_c) {
		this.kf_c = kf_c;
	}

	public void setCf_a(short cf_a) {
		this.cf_a = cf_a;
	}

	public void setCf_b(short cf_b) {
		this.cf_b = cf_b;
	}

	public void setCf_c(short cf_c) {
		this.cf_c = cf_c;
	}

	public void setEn2_a_Y_(long en2_a_Y_) {
		this.en2_a_Y_ = en2_a_Y_;
	}

	public void setEn2_a_W_(long en2_a_W_) {
		this.en2_a_W_ = en2_a_W_;
	}

	public void setEn2_a_S_(long en2_a_S) {
		this.en2_a_S_ = en2_a_S;
	}

	public void setEn2_b_Y_(long en2_b_Y_) {
		this.en2_b_Y_ = en2_b_Y_;
	}

	public void setEn2_b_W_(long en2_b_W_) {
		this.en2_b_W_ = en2_b_W_;
	}

	public void setEn2_b_S_(long en2_b_S) {
		this.en2_b_S_ = en2_b_S;
	}

	public void setEn2_c_Y_(long en2_c_Y_) {
		this.en2_c_Y_ = en2_c_Y_;
	}

	public void setEn2_c_W_(long en2_c_W_) {
		this.en2_c_W_ = en2_c_W_;
	}

	public void setEn2_c_S_(long en2_c_S) {
		this.en2_c_S_ = en2_c_S;
	}

}
