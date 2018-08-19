package com.heshun.dsm.handler.strategy.switchmodule.hz;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class SwitchModulePacket4HZ extends DefaultDevicePacket {

	public SwitchModulePacket4HZ(int address) {
		super(address);
	}

	public boolean hasVisitor;
	public boolean hasWater;
	public boolean hasSmoke;
}
