package com.heshun.dsm.util;

public class Utils_ {
	/*
	 * 字节转二进制字符串
	 */
	public static String byte2bits(byte b) {
		int z = b;
		z |= 256;
		String str = Integer.toBinaryString(z);
		int len = str.length();
		return str.substring(len - 8, len);
	}

	/*
	 * 将二进制字符串转换回字节
	 */
	public static byte bit2byte(String bString) {
		byte result = 0;
		for (int i = bString.length() - 1, j = 0; i >= 0; i--, j++) {
			result += (Byte.parseByte(bString.charAt(i) + "") * Math.pow(2, j));
		}
		return result;
	}

	/*
	 * char转byte数组
	 */
	public static byte[] charToByte(char c) {
		byte[] b = new byte[2];
		b[0] = (byte) ((c & 0xFF00) >> 8);
		b[1] = (byte) (c & 0xFF);
		return b;
	}

	/*
	 * byte数组转char
	 */
	public static char byteToChar(byte[] b) {
		char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
		return c;
	}

	public static String char2BitsString(char c) {
		byte[] arr = new byte[2];
		arr[0] = (byte) ((int) (c >> 0 * 8 & 0xff));
		arr[1] = (byte) ((int) (c >> 1 * 8 & 0xff));
		return byte2bits(arr[0]) + "" + byte2bits(arr[1]);
	}
}
