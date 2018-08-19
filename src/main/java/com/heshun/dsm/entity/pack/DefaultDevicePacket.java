package com.heshun.dsm.entity.pack;

/**
 * 预留，提供公用属性
 * 
 * @author huangxz
 * 
 */
public class DefaultDevicePacket {
	public int address = 0;

	public boolean notify = false;

	public DefaultDevicePacket(int address) {
		this.address = address;
	}
}
