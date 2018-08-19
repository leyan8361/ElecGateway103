package com.heshun.dsm.handler.strategy.switchmodule.jingci;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class SwitchModulePacket4JCS extends DefaultDevicePacket {

	public SwitchModulePacket4JCS(int address) {
		super(address);
	}

	public boolean smoke1;
	public boolean smoke2;
}
