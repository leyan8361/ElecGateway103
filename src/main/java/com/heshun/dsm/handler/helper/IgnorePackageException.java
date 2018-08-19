package com.heshun.dsm.handler.helper;

import com.heshun.dsm.handler.strategy.Abs103Unpacker.PackageType;

public class IgnorePackageException extends Exception {
	private static final long serialVersionUID = 1L;

	public IgnorePackageException(PackageType type) {
		super("忽略此类报文" + type);
		
	}
	

}
