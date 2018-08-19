package com.heshun.dsm.handler.strategy.sfo2;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

/**
 * 六氟化硫
 * 
 * @author huangxz
 * 
 */
public class SFO2Packet extends DefaultDevicePacket {
	public SFO2Packet(int address) {
		super(address);
	}

	public short sf;
	public short o2;

}
