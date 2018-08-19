package com.heshun.dsm.handler.transfer;

import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.entity.pack.DefaultDevicePacket;

public interface ItfTransferHandler {
	void transfer(IoSession session, AbsJsonConvert<? extends DefaultDevicePacket> message);
}
