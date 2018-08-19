package com.heshun.dsm.handler.strategy.switchmodule.jingci;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class SwitchModule_JCSConvert extends AbsJsonConvert<SwitchModulePacket4JCS> {
	public SwitchModule_JCSConvert(SwitchModulePacket4JCS packet) {
		super(packet);
	}

	@Override
	public JSONObject toJsonObj(String ip) {

		JSONObject jo = super.toJsonObj(ip);
		jo.put("address", mPacket.address);
		jo.put("smoke1", mPacket.smoke1);
		jo.put("smoke2", mPacket.smoke2);
		return jo;
	}

	@Override
	public String getType() {
		return "SwitchModule_JCS";
	}

}
