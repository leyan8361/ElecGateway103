package com.heshun.dsm.handler.strategy.h2o;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class H2oPacket extends DefaultDevicePacket {

	public short level;

	public H2oPacket(int address) {
		super(address);
	}

}
