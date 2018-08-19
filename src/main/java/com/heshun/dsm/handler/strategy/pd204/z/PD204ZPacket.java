package com.heshun.dsm.handler.strategy.pd204.z;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class PD204ZPacket extends DefaultDevicePacket {
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
	public float _sa;
	public float _sb;
	public float _sc;
	public float _stotal;// 总视在功率
	public float _pfa;
	public float _pfb;
	public float _pfc;
	public float _pftotal;
	public float _freq;
	//
	public long epi;// 正向有功电度
	public long epe;// 负向有功电度
	public long eql;// 正向无功电度
	public long eqc;// 负向无功电度

	public PD204ZPacket(int address) {
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

	public void set_freq(float _freq) {
		this._freq = _freq;
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

	public void setAddress(int address) {
		this.address = address;
	}

}
