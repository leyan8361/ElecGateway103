package com.heshun.dsm.handler.strategy.entech.disd687;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

/**
 * 带无功、视在功率的EQA300
 * 
 * @author huangxz
 * 
 */
public class DISD687Packet extends DefaultDevicePacket {

	public short _pid;
	public short _port = 4800;
	public short _wireType;
	public short _version;
	/*
	 * 电压小数点标定
	 */
	public float _dpt;
	/*
	 * 电流小数点标定
	 */
	public float _dct;
	/*
	 * 功率小数点标定
	 */
	public float _dqt;

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

	public long epi;
	public long eql;

	public DISD687Packet(int address) {
		super(address);
	}

	/**
	 * 以上字段用于存储原始报文信息,对于这些字段，只提供set方法
	 */

	public void set_pid(short _pid) {
		this._pid = _pid;
	}

	public void set_port(short _port) {
		this._port = _port;
	}

	public void set_wireType(short _wireType) {
		this._wireType = _wireType;
	}

	public void set_version(short _version) {
		this._version = _version;
	}

	public void set_dpt(float _dpt) {
		this._dpt = _dpt;
	}

	public void set_dct(float _dct) {
		this._dct = _dct;
	}

	public void set_dqt(float _dqt) {
		this._dqt = _dqt;
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
 

	// ADD
	public void set_freq(float _freq) {
		this._freq = _freq;
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

	public void setEpi(long epi) {
		this.epi = epi;
	}

	public void setEql(long eql) {
		this.eql = eql;
	}

	 

}
