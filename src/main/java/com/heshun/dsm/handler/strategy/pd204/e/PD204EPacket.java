package com.heshun.dsm.handler.strategy.pd204.e;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class PD204EPacket extends DefaultDevicePacket {
	public float _ua;
	public float _ub;
	public float _uc;
	public float _uab;
	public float _ubc;
	public float _uca;
	public float _ia;
	public float _ib;
	public float _ic;
	public float _pa;
	public float _pb;
	public float _pc;
	public float _ptotal;// 总有功功率
	public float _qa;
	public float _qb;
	public float _qc;
	public float _qtotal;// 总无功功率
	public float _stotal;// 总视在功率
	public float _pf;// 功率因数
	public float _hertz;// 赫兹
	public long _forward_KA = 0l;// 正有功电度
	public long _backward_KA = 0l;// 负有功电度
	public long _forward_KR = 0l;// 正无功电度
	public long _backward_KR = 0l;// 负无功电度

	public PD204EPacket(int address) {
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

	public void set_stotal(float _stotal) {
		this._stotal = _stotal;
	}

	public void set_pf(float _pf) {
		this._pf = _pf;
	}

	public void set_hertz(float _hertz) {
		this._hertz = _hertz;
	}

	public void set_forward_KA(long _forward_KA) {
		this._forward_KA = _forward_KA;
	}

	public void set_backward_KA(long _backward_KA) {
		this._backward_KA = _backward_KA;
	}

	public void set_forward_KR(long _forward_KR) {
		this._forward_KR = _forward_KR;
	}

	public void set_backward_KR(long _backward_KR) {
		this._backward_KR = _backward_KR;
	}

	public void setAddress(int address) {
		this.address = address;
	}
}
