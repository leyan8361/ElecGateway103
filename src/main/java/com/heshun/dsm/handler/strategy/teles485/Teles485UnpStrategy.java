package com.heshun.dsm.handler.strategy.teles485;

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
 * 温湿度传感器解包策略
 * 
 * @author huangxz
 * 
 */
public class Teles485UnpStrategy extends AbsDeviceUnpackStrategy<Teles485Convert, Teles485Packet> {

	public Teles485UnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public String getDeviceType() {
		return "Teles485";
	}

	@Override
	public Teles485Convert getConvert(Teles485Packet packet) {
		return new Teles485Convert(packet);
	}

	@Override
	protected Teles485Packet handleTotalQuery(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData) throws PacketInCorrectException,
			UnRegistSupervisorException {
		Teles485Packet packet = new Teles485Packet(mDevice.vCpu);

		packet.wet = (short) (Utils.bytes2Short(ycData.get(1).getOriginData()) & 0xFFFF);

		packet.temp = (short) (Utils.bytes2Short(ycData.get(2).getOriginData()) & 0xFFFF);
		return packet;
	}

}
