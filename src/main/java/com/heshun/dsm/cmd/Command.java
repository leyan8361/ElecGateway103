package com.heshun.dsm.cmd;

/**
 * 主机请求报文管理类
 */
public class Command {

	/**
	 * 标识报文
	 */
	public static byte[] getLogoTypeCommand() {
		return new byte[] { 0x14, (byte) 0x81, 0x05, 0x01, (byte) 0xfe, 0x01, 0x01, 0x00 };

	}

	/**
	 * 总查询，总召唤报文
	 */
	public static byte[] getTotalQueryCommand(int cpuId) {
		byte[] pack = new byte[] { 0x07, (byte) 0x81, 0x09, (byte) ((byte) cpuId & 0xff), (byte) 0xFE, 0x00, 0x04 };
		return pack;
	}

	/**
	 * 心跳UDP报文
	 */
	public static byte[] getHeartBreakCommand() {
		return new byte[] { (byte) 0xff, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xcc, (byte) 0xec,
				(byte) 0xd5, (byte) 0xfd, (byte) 0xc3, (byte) 0xf7, (byte) 0xc8, (byte) 0xd5, 0x31, 0x00, 0x00, 0x00,
				0x00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00 };
	}

	/**
	 * 控制报文
	 */
	public static byte[] getControlCommand(int cpu, int commandIndex, boolean open) {
		return new byte[] { 0x0a, (byte) 0x81, 0x28, (byte) cpu, (byte) 0xff, (byte) 0xfa, 0x00, 0x01, 0x0b,
				(byte) commandIndex, 0x01, 0x09, 0x01, 0x01, (byte) (open ? 02 : 01) };
	}

	public static byte[]  getControlCommand(byte[] commandParams) {
		byte cpu = commandParams[0];
		byte commandIndex = commandParams[1];
		byte open = commandParams[2];
		return new byte[] { 0x0a, (byte) 0x81, 0x28, cpu, (byte) 0xff, (byte) 0xfa, 0x00, 0x01, 0x0b, commandIndex,
				0x01, 0x09, 0x01, 0x01, open };
	}

}
