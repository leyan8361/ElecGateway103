package com.heshun.dsm.handler.strategy.eqa300.harmonic;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.ResultWrapper;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;

public class EQA300HUnpStrategy extends AbsDeviceUnpackStrategy<EQA300HConvert, EQA300HPacket> {

	public EQA300HUnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public EQA300HConvert getConvert(EQA300HPacket packet) {
		return new EQA300HConvert(packet);
	}

	@Override
	public String getDeviceType() {
		return "eqa300h";
	}

	@Override
	protected EQA300HPacket handleTotalQuery(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData) throws PacketInCorrectException,
			UnRegistSupervisorException {
		EQA300HPacket packet = new EQA300HPacket(mDevice.vCpu);

		return packet;
	}

}
