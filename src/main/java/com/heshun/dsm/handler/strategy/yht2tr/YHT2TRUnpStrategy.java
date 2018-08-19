package com.heshun.dsm.handler.strategy.yht2tr;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.util.Utils;

/**
 * 无线测温模块
 * 
 * @author huangxz
 * 
 */
public class YHT2TRUnpStrategy extends AbsDeviceUnpackStrategy<YHT2TRConvert, YHT2TRPacket> {

	public YHT2TRUnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public String getDeviceType() {
		return "YHT2_TR";
	}

	@Override
	public YHT2TRConvert getConvert(YHT2TRPacket packet) {
		return new YHT2TRConvert(packet);
	}

	@Override
	protected YHT2TRPacket handleTotalQuery(int size, Map<Integer, byte[]> ycData, Map<Integer, byte[]> yxData,
			Map<Integer, byte[]> ymData) throws PacketInCorrectException {
		YHT2TRPacket packet = new YHT2TRPacket(mDevice.vCpu);

		packet.aUp = (short) (Utils.bytes2Short(ycData.get(1)) & 0xFFFF);

		packet.bUp = (short) (Utils.bytes2Short(ycData.get(2)) & 0xFFFF);

		packet.cUp = (short) (Utils.bytes2Short(ycData.get(3)) & 0xFFFF);

		packet.aDown = (short) (Utils.bytes2Short(ycData.get(4)) & 0xFFFF);

		packet.bDown = (short) (Utils.bytes2Short(ycData.get(5)) & 0xFFFF);

		packet.cDown = (short) (Utils.bytes2Short(ycData.get(6)) & 0xFFFF);

		// 母排
		packet.aPUp = (short) (Utils.bytes2Short(ycData.get(7)) & 0xFFFF);

		packet.bPUp = (short) (Utils.bytes2Short(ycData.get(8)) & 0xFFFF);

		packet.cPUp = (short) (Utils.bytes2Short(ycData.get(9)) & 0xFFFF);

		packet.aPDown = (short) (Utils.bytes2Short(ycData.get(10)) & 0xFFFF);

		packet.bPDown = (short) (Utils.bytes2Short(ycData.get(11)) & 0xFFFF);

		packet.cPDown = (short) (Utils.bytes2Short(ycData.get(12)) & 0xFFFF);

		return packet;

	}

}
