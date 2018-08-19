package com.heshun.dsm.handler.strategy.bg5485;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.util.Utils;

/**
 * 温湿度传感器解包策略
 * 
 * @author huangxz
 *
 */
public class BG5485UnpStrategy extends AbsDeviceUnpackStrategy<BG5485Convert, BG5485Packet> {

	public BG5485UnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public String getDeviceType() {
		return "BG5485";
	}

	@Override
	public BG5485Convert getConvert(BG5485Packet packet) {
		return new BG5485Convert(packet);
	}

	@Override
	protected BG5485Packet handleTotalQuery(int size, Map<Integer, byte[]> ycData, Map<Integer, byte[]> yxData,
			Map<Integer, byte[]> ymData) {
		BG5485Packet packet = new BG5485Packet(mDevice.vCpu);

		packet.wet = (short) (Utils.bytes2Short(ycData.get(1)) & 0xFFFF);

		packet.temp = (short) (Utils.bytes2Short(ycData.get(2)) & 0xFFFF);
		return packet;

	}

}
