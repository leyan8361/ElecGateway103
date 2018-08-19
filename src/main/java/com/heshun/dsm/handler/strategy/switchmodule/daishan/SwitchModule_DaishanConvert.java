package com.heshun.dsm.handler.strategy.switchmodule.daishan;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class SwitchModule_DaishanConvert extends AbsJsonConvert<SwitchModulePacket4Daishan> {
	public SwitchModule_DaishanConvert(SwitchModulePacket4Daishan packet) {
		super(packet);
	}

	@Override
	public JSONObject toJsonObj(String ip) {

		JSONObject jo = super.toJsonObj(ip);
		jo.put("address", mPacket.address);
		jo.put("smoke1", mPacket.hasSmoke1);
		jo.put("smoke2", mPacket.hasSmoke2);
		jo.put("visitor1", mPacket.hasVisitor1);
		jo.put("visitor2", mPacket.hasVisitor2);
		jo.put("water", mPacket.hasWater);
		return jo;
	}

	@Override
	public String getType() {
		return "SwitchModule_DS";
	}

}
