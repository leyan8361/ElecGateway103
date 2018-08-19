package com.heshun.dsm.handler.strategy.switchmodule;

import java.util.HashMap;

import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public class SwitchModulePacket extends DefaultDevicePacket {

	public SwitchModulePacket(int address) {
		super(address);
		mFlags = new HashMap<>();
		for (int i = 0; i < 16; i++) {
			mFlags.put(String.valueOf(++i), false);
		}
	}

	public HashMap<String, Boolean> mFlags;

}
