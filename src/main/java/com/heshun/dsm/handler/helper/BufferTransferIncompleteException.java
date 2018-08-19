package com.heshun.dsm.handler.helper;

/**
 * 报文传输不完整异常
 * 
 * @author huangxz
 *
 */
public class BufferTransferIncompleteException extends Exception {
	private static final long serialVersionUID = 1L;

	public BufferTransferIncompleteException(Exception e) {
		super("报文传输不完整", e);
	}
}