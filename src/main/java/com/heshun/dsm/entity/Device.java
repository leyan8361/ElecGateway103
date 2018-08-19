package com.heshun.dsm.entity;

import java.util.List;

public class Device {
	public String model;
	public int vCpu;
	public int length;
	public List<byte[]> requestPack;
	/**
	 * 偏移量
	 */
	public int offset = 0;

	public Device(int vCpu, String type, int length) {
		this.vCpu = vCpu;
		this.model = type;
		this.length = length;
	}

	public Device(String type, int length) {
		this(1, type, length);
	}
}
