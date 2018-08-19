package com.heshun.dsm.handler.strategy.yht2tr;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class YHT2TRPacket extends DefaultDevicePacket {
	// 触头
	public short aUp;
	public short bUp;
	public short cUp;
	public short aDown;
	public short bDown;
	public short cDown;
	// 母排
	public short aPUp;
	public short bPUp;
	public short cPUp;
	public short aPDown;
	public short bPDown;
	public short cPDown;

	public YHT2TRPacket(int address) {
		super(address);
	}
}
