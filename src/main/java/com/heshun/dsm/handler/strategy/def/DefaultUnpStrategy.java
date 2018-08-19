package com.heshun.dsm.handler.strategy.def;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.entity.pack.DefaultDevicePacket;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.handler.strategy.def.DefaultUnpStrategy.DefaultConvert;

public class DefaultUnpStrategy extends AbsDeviceUnpackStrategy<DefaultConvert, DefaultDevicePacket> {

	public DefaultUnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	protected DefaultDevicePacket handleTotalQuery(int size, Map<Integer, byte[]> ycData, Map<Integer, byte[]> yxData,
			Map<Integer, byte[]> ymData) throws UnRegistSupervisorException {
		throw new UnRegistSupervisorException();
	}

	public class DefaultConvert extends AbsJsonConvert<DefaultDevicePacket> {

		public DefaultConvert(DefaultDevicePacket packet) {
			super(packet);
		}

		@Override
		public String getType() {
			return "unknown device type";
		}

	}

	@Override
	public DefaultConvert getConvert(DefaultDevicePacket packet) {
		return new DefaultConvert(new DefaultDevicePacket(0));
	}

	@Override
	public String getDeviceType() {
		return "unknown device type";
	}

}
