package com.heshun.dsm.handler.strategy.sfo2;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.ResultWrapper;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.util.Utils;

public class SFO2UnpStrategy extends AbsDeviceUnpackStrategy<SFO2Convert, SFO2Packet> {

	public SFO2UnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public String getDeviceType() {
		return "SFO2";
	}

	@Override
	public SFO2Convert getConvert(SFO2Packet packet) {
		return new SFO2Convert(packet);
	}

	@Override
	protected SFO2Packet handleTotalQuery(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData) throws PacketInCorrectException,
			UnRegistSupervisorException {
		SFO2Packet packet = new SFO2Packet(mDevice.vCpu);

		packet.o2 = (short) (Utils.bytes2Short(ycData.get(1).getOriginData()) & 0xFFFF);

		packet.sf = (short) (Utils.bytes2Short(ycData.get(2).getOriginData()) & 0xFFFF);
		return packet;
	}

}
