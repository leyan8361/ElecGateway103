package com.heshun.dsm.handler.strategy.pd204.z;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class PD204ZConvert extends AbsJsonConvert<PD204ZPacket> {

	public PD204ZConvert(PD204ZPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "PD204Z";
	}

	public float getUa() {
		return mPacket._ua;
	}

	public float getUb() {
		return mPacket._ub;
	}

	public float getUc() {
		return mPacket._uc;
	}

	public float getUab() {
		return mPacket._uab;
	}

	public float getUbc() {
		return mPacket._ubc;
	}

	public float getUca() {
		return mPacket._uca;
	}

	public float getIa() {
		return mPacket._ia;
	}

	public float getIb() {
		return mPacket._ib;
	}

	public float getIc() {
		return mPacket._ic;
	}

	public float getPa() {
		return mPacket._pa;
	}

	public float getPb() {
		return mPacket._pb;
	}

	public float getPc() {
		return mPacket._pc;
	}

	public float getPtotal() {
		return mPacket._ptotal;
	}

	public float getQa() {
		return mPacket._qa;
	}

	public float getQb() {
		return mPacket._qb;
	}

	public float getQc() {
		return mPacket._qc;
	}

	public float getQtotal() {
		return mPacket._qtotal;
	}

	public float getSa() {
		return mPacket._sa;
	}

	public float getSb() {
		return mPacket._sb;
	}

	public float getSc() {
		return mPacket._sc;
	}

	public float getStotal() {
		return mPacket._stotal;
	}

	public float getPfa() {
		return mPacket._pfa;
	}

	public float getPfb() {
		return mPacket._pfb;
	}

	public float getPfc() {
		return mPacket._pfc;
	}

	public float getPftotal() {
		return mPacket._pftotal;
	}

	public float getFreq() {
		return mPacket._freq;
	}

	public long getEPI() {
		return mPacket.epi;
	}

	public long getEPE() {
		return mPacket.epe;
	}

	public long getEQL() {
		return mPacket.eql;
	}

	public long getEQC() {
		return mPacket.eqc;
	}

	public int getAddress() {
		return mPacket.address;
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject _json = super.toJsonObj(ip);
		_json.put("address", getAddress());
		_json.put("ua", getUa());
		_json.put("ub", getUb());
		_json.put("uc", getUc());
		_json.put("uab", getUab());
		_json.put("ubc", getUbc());
		_json.put("uca", getUca());
		_json.put("ia", getIa());
		_json.put("ib", getIb());
		_json.put("ic", getIc());
		_json.put("pa", getPa());
		_json.put("pb", getPb());
		_json.put("pc", getPc());
		_json.put("pt", getPtotal());
		_json.put("qa", getQa());
		_json.put("qb", getQb());
		_json.put("qc", getQc());
		_json.put("qt", getQtotal());
		_json.put("sa", getSa());
		_json.put("sb", getSb());
		_json.put("sc", getSc());
		_json.put("st", getStotal());
		_json.put("pfa", getPfa());
		_json.put("pfb", getPfb());
		_json.put("pfc", getPfc());
		_json.put("pft", getPftotal());
		_json.put("freq", getFreq());
		_json.put("epi", getEPI());
		_json.put("epe", getEPE());
		_json.put("eql", getEQL());
		_json.put("eqc", getEQC());
		return _json;
	}

}
