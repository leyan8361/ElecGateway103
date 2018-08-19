package com.heshun.dsm.handler.strategy.eqa300.harmonic;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class EQA300HConvert extends AbsJsonConvert<EQA300HPacket> {

	public EQA300HConvert(EQA300HPacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "eqa300";
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		return super.toJsonObj(ip);
	}

}
