package com.heshun.dsm.handler.helper;

public class UnRegistSupervisorException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnRegistSupervisorException() {
		super("未知管理机,等待管理机回复自身标识");

	}

	public UnRegistSupervisorException(String msg) {
		super(msg);

	}
}
