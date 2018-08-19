package com.heshun.dsm.handler.strategy.bg5485;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class BG5485Packet extends DefaultDevicePacket {
	
	public short wet;
	public short temp = 4800;

	public BG5485Packet(int address) {
		super(address);
	}

}
