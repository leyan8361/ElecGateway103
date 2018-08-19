package com.heshun.dsm.handler.strategy.logotype;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class LogoTypePacket extends DefaultDevicePacket {

	public LogoTypePacket(int address) {
		super(address);
	}

	public int logotype;

}
