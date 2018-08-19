package com.heshun.dsm.handler.strategy.pd204.e;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class PD204EConvert extends AbsJsonConvert<PD204EPacket> {

	public PD204EConvert(PD204EPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "PD204E";
	}

	public float get_ua() {
		return mPacket._ua;
	}

	public float get_ub() {
		return mPacket._ub;
	}

	public float get_uc() {
		return mPacket._uc;
	}

	public float get_uab() {
		return mPacket._uab;
	}

	public float get_ubc() {
		return mPacket._ubc;
	}

	public float get_uca() {
		return mPacket._uca;
	}

	public float get_ia() {
		return mPacket._ia;
	}

	public float get_ib() {
		return mPacket._ib;
	}

	public float get_ic() {
		return mPacket._ic;
	}

	public float get_pa() {
		return mPacket._pa;
	}

	public float get_pb() {
		return mPacket._pb;
	}

	public float get_pc() {
		return mPacket._pc;
	}

	public float get_ptotal() {
		return mPacket._ptotal;
	}

	public float get_qa() {
		return mPacket._qa;
	}

	public float get_qb() {
		return mPacket._qb;
	}

	public float get_qc() {
		return mPacket._qc;
	}

	public float get_qtotal() {
		return mPacket._qtotal;
	}

	public float get_stotal() {
		return mPacket._stotal;
	}

	public float get_pf() {
		return mPacket._pf;
	}

	public float get_hertz() {
		return mPacket._hertz;
	}

	public long get_forward_KA() {
		return mPacket._forward_KA;
	}

	public long get_backward_KA() {
		return mPacket._backward_KA;
	}

	public long get_forward_KR() {
		return mPacket._forward_KR;
	}

	public long get_backward_KR() {
		return mPacket._backward_KR;
	}

	public int getAddress() {
		return mPacket.address;
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject _json = super.toJsonObj(ip);
		_json.put("address", getAddress());
		_json.put("ua", get_ua());
		_json.put("ub", get_ub());
		_json.put("uc", get_uc());
		_json.put("uab", get_uab());
		_json.put("ubc", get_ubc());
		_json.put("uca", get_uca());
		_json.put("ia", get_ia());
		_json.put("ib", get_ib());
		_json.put("ic", get_ic());
		_json.put("pa", get_pa());
		_json.put("pb", get_pb());
		_json.put("pc", get_pc());
		_json.put("pt", get_ptotal());
		_json.put("qa", get_qa());
		_json.put("qb", get_qb());
		_json.put("qc", get_qc());
		_json.put("qt", get_qtotal());
		_json.put("st", get_stotal());
		_json.put("pft", get_pf());
		_json.put("freq", get_hertz());
		_json.put("epi", get_forward_KA());
		_json.put("epe", get_backward_KA());
		_json.put("eql", get_forward_KR());
		_json.put("eqc", get_backward_KR());
		return _json;
	}

}
