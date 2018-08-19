package com.heshun.dsm.handler.strategy.sfo2;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class SFO2Convert extends AbsJsonConvert<SFO2Packet> {
	public SFO2Convert(SFO2Packet packet) {
		super(packet);
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject jo = super.toJsonObj(ip);
		jo.put("SF", getSF());
		jo.put("O2", getO2());
		jo.put("address", mPacket.address);
		jo.put("type", "SFO2");
		jo.put("deviceStatus", "1");
		return jo;
	}

	private float getO2() {
		return ((float) mPacket.sf) / 100 * 0.1f;
	}

	private float getSF() {
		return ((float) mPacket.o2) / 100 * 0.1f;
	}

	@Override
	public String getType() {
		return "SFO2";
	}

}
