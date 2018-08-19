package com.heshun.dsm.handler.helper;

/**
 * 针对仪表数据没有正确采集，全是0，抛出的异常
 * 
 * @author huangxz
 *
 */
public class PacketInCorrectException extends Exception {

	private static final long serialVersionUID = 1L;

	public PacketInCorrectException() {
		super("仪表数据采集异常");
	}
}
