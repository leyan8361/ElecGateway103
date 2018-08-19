package com.heshun.dsm.handler.strategy.eqa300.abt;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

/**
 * 带无功、视在功率的EQA300
 * 
 * @author huangxz
 * 
 */
public class EQA300TPacket extends DefaultDevicePacket {

	public short _pid;
	public short _port = 4800;
	public short _wireType;
	public short _version;
	/*
	 * 电压小数点标定
	 */
	public short _dpt;
	/*
	 * 电流小数点标定
	 */
	public short _dct;
	/*
	 * 功率小数点标定
	 */
	public short _dqt;

	public short _ua;
	public short _ub;
	public short _uc;

	public short _uab;
	public short _ubc;
	public short _uca;

	public short _ia;
	public short _ib;
	public short _ic;

	// ADD
	public short _freq;

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

	public byte[] _epiHigh;
	public byte[] _epiLow;

	// ADD
	public byte[] _eqlHigh;
	public byte[] _eqlLow;

	public EQA300TPacket(int address) {
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

	public void set_dpt(short _dpt) {
		this._dpt = _dpt;
	}

	public void set_dct(short _dct) {
		this._dct = _dct;
	}

	public void set_dqt(short _dqt) {
		this._dqt = _dqt;
	}

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

	public void set_ubc(short _ubc) {
		this._ubc = _ubc;
	}

	public void set_uca(short _uca) {
		this._uca = _uca;
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

	public void setEpiHigh(byte[] eh) {
		this._epiHigh = eh;
	}

	public void setEpiLow(byte[] el) {
		this._epiLow = el;
	}

	// ADD
	public void set_freq(short _freq) {
		this._freq = _freq;
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

	public void set_eqlHigh(byte[] _eqlHigh) {
		this._eqlHigh = _eqlHigh;
	}

	public void set_eqlLow(byte[] _eqlLow) {
		this._eqlLow = _eqlLow;
	}

}
