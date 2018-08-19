package com.heshun.dsm.handler.strategy.h2o;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.ResultWrapper;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.util.Utils;

/**
 * 水位传感器解包策略
 * 
 * @author huangxz
 * 
 */
public class H2oUnpStrategy extends AbsDeviceUnpackStrategy<H2oConvert, H2oPacket> {

	public H2oUnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public String getDeviceType() {
		return "waterLevel";
	}

	@Override
	public H2oConvert getConvert(H2oPacket packet) {
		return new H2oConvert(packet);
	}

	@Override
	protected H2oPacket handleTotalQuery(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData) throws PacketInCorrectException,
			UnRegistSupervisorException {
		H2oPacket packet = new H2oPacket(mDevice.vCpu);

		packet.level = (short) (Utils.bytes2Short(ycData.get(1).getOriginData()) & 0xFFFF);

		return packet;
	}

}
