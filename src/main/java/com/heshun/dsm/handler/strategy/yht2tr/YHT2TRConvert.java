package com.heshun.dsm.handler.strategy.yht2tr;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class YHT2TRConvert extends AbsJsonConvert<YHT2TRPacket> {
	public YHT2TRConvert(YHT2TRPacket packet) {
		super(packet);
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject jo = super.toJsonObj(ip);
		jo.put("AUp", mPacket.aPUp);
		jo.put("BUp", mPacket.bPUp);
		jo.put("CUp", mPacket.bPUp);
		//
		jo.put("ADown", mPacket.aPDown);
		jo.put("BDown", mPacket.bPDown);
		jo.put("CDown", mPacket.cPDown);
		jo.put("address", mPacket.address);

		jo.put("type", "infrared");
		jo.put("fanStatus", 0);
		jo.put("deviceStatus", "1");
		return jo;
	}

	@Override
	public String getType() {
		return "YHT2_TR";
	}

}
