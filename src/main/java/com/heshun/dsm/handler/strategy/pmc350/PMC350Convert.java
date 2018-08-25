package com.heshun.dsm.handler.strategy.pmc350;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class PMC350Convert extends AbsJsonConvert<PMC350Packet> {

	public PMC350Convert(PMC350Packet packet) {
		super(packet);
	}

	/**
	 * 获取虚拟cpu
	 */
	public int getAddress() {
		return mPacket.address;
	}

	@Override
	public JSONObject toJsonObj(String ip) {

		JSONObject _json = super.toJsonObj(ip);

		_json.put("pid", 0);
		_json.put("control", 1);
		_json.put("version", 0);
		_json.put("ua", mPacket._ua);
		_json.put("ub", mPacket._ub);
		_json.put("uc", mPacket._uc);
		_json.put("uab", mPacket._uab);
		_json.put("ubc", mPacket._ubc);
		_json.put("uca", mPacket._uca);
		_json.put("ia", mPacket._ia);
		_json.put("ib", mPacket._ib);
		_json.put("ic", mPacket._ic);
		// ADD
		_json.put("freq", mPacket._freq);

		_json.put("pa", mPacket._pa);
		_json.put("pb", mPacket._pb);
		_json.put("pc", mPacket._pc);
		_json.put("pt", mPacket._ptotal);
		// ADD
		_json.put("qa", mPacket._qa);
		_json.put("qb", mPacket._qb);
		_json.put("qc", mPacket._qc);
		_json.put("qt", mPacket._qtotal);
		// ADD
		_json.put("sa", mPacket._pa);
		_json.put("sb", mPacket._pb);
		_json.put("sc", mPacket._pc);
		_json.put("st", mPacket._ptotal);
		// ADD
		_json.put("pfa", mPacket._pfa);
		_json.put("pfb", mPacket._pfb);
		_json.put("pfc", mPacket._pfc);
		_json.put("pft", mPacket._pftotal);
		_json.put("epi", mPacket.epi);
		_json.put("eql", mPacket.eql);
		return _json;
	}

	@Override
	public String getType() {
		return "eqa300";
	}

}