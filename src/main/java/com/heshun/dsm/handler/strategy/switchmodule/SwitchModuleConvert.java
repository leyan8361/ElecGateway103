package com.heshun.dsm.handler.strategy.switchmodule;

import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class SwitchModuleConvert extends AbsJsonConvert<SwitchModulePacket> {

	public SwitchModuleConvert(SwitchModulePacket packet) {
		super(packet);
	}

	@Override
	public String getType() {
		return "switch";
	}

	@Override
	public JSONObject toJsonObj(String ip) {
		JSONObject jo = super.toJsonObj(ip);

		for (Entry<String, Boolean> flag : mPacket.mFlags.entrySet()) {
			jo.put(flag.getKey(), flag.getValue());
		}
		return jo;
	}

}
