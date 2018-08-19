package com.heshun.dsm.handler.strategy.logotype;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.handler.strategy.Abs103Unpacker;
import com.heshun.dsm.util.Utils;

/**
 * 标识报文解包策略
 * 
 * @author huangxz
 * 
 */
public class LogoTypeUnpStrategy extends Abs103Unpacker<LogoTypeConvert, LogoTypePacket> {

	public LogoTypeUnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public String getDeviceType() {
		return "logotype";
	}

	@Override
	public LogoTypeConvert getConvert(LogoTypePacket packet) {
		return new LogoTypeConvert(packet);
	}

	@Override
	protected LogoTypePacket unpack() {
		byte[] _logoType = new byte[19];
		in.get(_logoType);

		LogoTypePacket packet = new LogoTypePacket(0);
		packet.logotype = (int) (Utils.bytes2Short(_logoType[7], _logoType[8]) & 0xFFFF);
		return packet;
	}

}
