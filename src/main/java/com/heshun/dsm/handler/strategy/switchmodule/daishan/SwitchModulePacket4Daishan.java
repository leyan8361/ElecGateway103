package com.heshun.dsm.handler.strategy.switchmodule.daishan;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class SwitchModulePacket4Daishan extends DefaultDevicePacket {

	public SwitchModulePacket4Daishan(int address) {
		super(address);
	}
	public boolean hasSmoke1;
	public boolean hasSmoke2;
	
	public boolean hasVisitor1;
	public boolean hasVisitor2;

	
	public boolean hasWater;
	
}
