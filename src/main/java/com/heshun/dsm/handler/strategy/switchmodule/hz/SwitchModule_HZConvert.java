package com.heshun.dsm.handler.strategy.switchmodule.hz;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class SwitchModule_HZConvert extends AbsJsonConvert<SwitchModulePacket4HZ> {
	public SwitchModule_HZConvert(SwitchModulePacket4HZ packet) {
		super(packet);
	}

	@Override
	public JSONObject toJsonObj(String ip) {

		JSONObject jo = super.toJsonObj(ip);
		jo.put("address", mPacket.address);
		jo.put("smoke", mPacket.hasSmoke);
		jo.put("visitor", mPacket.hasVisitor);
		jo.put("water", mPacket.hasWater);
		return jo;
	}

	@Override
	public String getType() {
		return "SwitchModule_HZ";
	}

}
