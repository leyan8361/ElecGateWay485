package com.heshun.modbus.strategy.pd204.e;

import com.heshun.modbus.entity.DefaultDevicePacket;

public class PD204EPacket extends DefaultDevicePacket{
	private float uan;//相电压
	private float ubn;//相电压
	private float ucn;//相电压
	private float uab;//线电压
	private float ubc;//线电压
	private float uca;//线电压
	private float ia;//电流
	private float ib;//电流
	private float ic;//电流
	
	private float pa;//a相有功功率
	private float pb;//b相有功功率
	private float pc;//c相有功功率
	private float ptotal;//总有功功率
	private float qa;//a相无功功率
	private float qb;//b相无功功率
	private float qc;//c相无功功率
	private float qtotal;//总无功功率
	private float s;//视在功率
	private float pf;//功率因数
	private float hz;//频率
	private int ppd;//正有功电度
	private int mpd;//负有功电度
	private int pqd;//正无功电度
	private int mqd;//负无功电度

	public PD204EPacket(int address) {
		super(address);
		// TODO Auto-generated constructor stub
	}

	public float getUan() {
		return uan;
	}

	public void setUan(float uan) {
		this.uan = uan;
	}

	public float getUbn() {
		return ubn;
	}

	public void setUbn(float ubn) {
		this.ubn = ubn;
	}

	public float getUcn() {
		return ucn;
	}

	public void setUcn(float ucn) {
		this.ucn = ucn;
	}

	public float getUab() {
		return uab;
	}

	public void setUab(float uab) {
		this.uab = uab;
	}

	public float getUbc() {
		return ubc;
	}

	public void setUbc(float ubc) {
		this.ubc = ubc;
	}

	public float getUca() {
		return uca;
	}

	public void setUca(float uca) {
		this.uca = uca;
	}

	public float getIa() {
		return ia;
	}

	public void setIa(float ia) {
		this.ia = ia;
	}

	public float getIb() {
		return ib;
	}

	public void setIb(float ib) {
		this.ib = ib;
	}

	public float getIc() {
		return ic;
	}

	public void setIc(float ic) {
		this.ic = ic;
	}

	public float getPa() {
		return pa;
	}

	public void setPa(float pa) {
		this.pa = pa;
	}

	public float getPb() {
		return pb;
	}

	public void setPb(float pb) {
		this.pb = pb;
	}

	public float getPc() {
		return pc;
	}

	public void setPc(float pc) {
		this.pc = pc;
	}

	public float getPtotal() {
		return ptotal;
	}

	public void setPtotal(float ptotal) {
		this.ptotal = ptotal;
	}

	public float getQa() {
		return qa;
	}

	public void setQa(float qa) {
		this.qa = qa;
	}

	public float getQb() {
		return qb;
	}

	public void setQb(float qb) {
		this.qb = qb;
	}

	public float getQc() {
		return qc;
	}

	public void setQc(float qc) {
		this.qc = qc;
	}

	public float getQtotal() {
		return qtotal;
	}

	public void setQtotal(float qtotal) {
		this.qtotal = qtotal;
	}

	public float getS() {
		return s;
	}

	public void setS(float s) {
		this.s = s;
	}

	public float getPf() {
		return pf;
	}

	public void setPf(float pf) {
		this.pf = pf;
	}

	public float getHz() {
		return hz;
	}

	public void setHz(float hz) {
		this.hz = hz;
	}

	public int getPpd() {
		return ppd;
	}

	public void setPpd(int ppd) {
		this.ppd = ppd;
	}

	public int getMpd() {
		return mpd;
	}

	public void setMpd(int mpd) {
		this.mpd = mpd;
	}

	public int getPqd() {
		return pqd;
	}

	public void setPqd(int pqd) {
		this.pqd = pqd;
	}

	public int getMqd() {
		return mqd;
	}

	public void setMqd(int mqd) {
		this.mqd = mqd;
	}
	
	@Override
	public String toString() {
		return "Bead{" +
				"uan=" + uan +
				", ubn=" + ubn +
				", ucn=" + ucn +
				", uab=" + uab +
				", ubc=" + ubc +
				", uca=" + uca +
				", ia=" + ia +
				", ib=" + ib +
				", ic=" + ic +
				", pa=" + pa +
				", pb=" + pb +
				", pc=" + pc +
				", ptotal=" + ptotal +
				", qa=" + qa +
				", qb=" + qb +
				", qc=" + qc +
				", qtotal=" + qtotal +
				", s=" + s +
				", pf=" + pf +
				", hz=" + hz +
				", ppd=" + ppd +
				", mpd=" + mpd +
				", pqd=" + pqd +
				", mqd=" + mqd +
				'}';
	}

}
