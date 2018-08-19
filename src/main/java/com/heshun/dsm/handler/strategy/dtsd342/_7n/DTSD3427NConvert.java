package com.heshun.dsm.handler.strategy.dtsd342._7n;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.util.Utils;

public class DTSD3427NConvert extends AbsJsonConvert<DTSD3427NPacket> {

	public DTSD3427NConvert(DTSD3427NPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "eqa300";
	}

	private float getU(short o) {
		return ((float) ((short) o & 0xFFFF)) / 100;
	}

	private float getI(short o) {
		return ((float) ((short) o & 0xFFFF)) / 1000;
	}

	public String getEpi() {
		return String.valueOf(Utils.bytes2Long(mPacket._epiHigh, mPacket._epiLow));
	}

	public String getEql() {
		return String.valueOf(Utils.bytes2Long(mPacket._eqlHigh, mPacket._eqlLow));
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject _json = super.toJsonObj(ip);
		_json.put("ua", getU(mPacket._ua));
		_json.put("ub", getU(mPacket._ub));
		_json.put("uc", getU(mPacket._uc));

		_json.put("uab", getU(mPacket._uab));
		_json.put("ubc", getU(mPacket._ubc));
		_json.put("uca", getU(mPacket._uca));

		_json.put("ia", getI(mPacket._ia));
		_json.put("ib", getI(mPacket._ib));
		_json.put("ic", getI(mPacket._ic));

		_json.put("freq", getU(mPacket._freq));

		_json.put("pa", mPacket._pa);
		_json.put("pb", mPacket._pb);
		_json.put("pc", mPacket._pc);
		_json.put("pt", mPacket._ptotal);

		_json.put("qa", mPacket._qa);
		_json.put("qb", mPacket._qb);
		_json.put("qc", mPacket._qc);
		_json.put("qt", mPacket._qtotal);
		// ADD
		_json.put("sa", mPacket._sa);
		_json.put("sb", mPacket._sb);
		_json.put("sc", mPacket._sc);
		_json.put("st", mPacket._stotal);

		_json.put("pfa", getI(mPacket._pfa));
		_json.put("pfb", getI(mPacket._pfb));
		_json.put("pfc", getI(mPacket._pfc));
		_json.put("pft", getI(mPacket._pftotal));
		_json.put("epi", getEpi());
		_json.put("eql", getEql());

		return _json;
	}

}
