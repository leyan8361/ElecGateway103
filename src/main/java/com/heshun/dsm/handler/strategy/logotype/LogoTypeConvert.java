package com.heshun.dsm.handler.strategy.logotype;

import com.heshun.dsm.entity.convert.AbsJsonConvert;

public class LogoTypeConvert extends AbsJsonConvert<LogoTypePacket> {
	public LogoTypeConvert(LogoTypePacket packet) {
		super(packet);
		this.logotype = packet.logotype;
	}

	public int logotype = 10000;

	@Override
	public String getType() {
		return "logotype";
	}

}
