package com.heshun.dsm.handler.strategy.bg5485;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class BG5485Convert extends AbsJsonConvert<BG5485Packet> {
	public BG5485Convert(BG5485Packet packet) {
		super(packet);
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject json = super.toJsonObj(ip);
		json.put("temp", getTemp());
		json.put("humidity", getWet());
		json.put("address", mPacket.address);
		json.put("deviceStatus", 1);
		return json;
	}

	public float getWet() {
		return ((float) (mPacket.wet)) / 10;
	}

	public float getTemp() {
		return ((float) (mPacket.temp)) / 10;
	}

	@Override
	public String getType() {
		return "BG5485";
	}

}
