package com.heshun.dsm.handler.strategy.h2o;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class H2oConvert extends AbsJsonConvert<H2oPacket> {
	public H2oConvert(H2oPacket packet) {
		super(packet);
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject json = super.toJsonObj(ip);
		json.put("level", getLevel());
		json.put("address", mPacket.address);
		json.put("deviceStatus", 1);
		return json;
	}

	public float getLevel() {
		return ((float) (mPacket.level)) * 5 / 2000;
	}

	@Override
	public String getType() {
		return "waterLevel";
	}

}
