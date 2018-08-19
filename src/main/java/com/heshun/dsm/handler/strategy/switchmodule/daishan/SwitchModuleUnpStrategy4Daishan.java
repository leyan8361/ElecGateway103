package com.heshun.dsm.handler.strategy.switchmodule.daishan;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.ResultWrapper;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.entity.global.DataBuffer;
import com.heshun.dsm.handler.helper.IgnorePackageException;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;

/**
 * 开关量模块
 * 
 * @author huangxz
 * 
 */
public class SwitchModuleUnpStrategy4Daishan extends
		AbsDeviceUnpackStrategy<SwitchModule_DaishanConvert, SwitchModulePacket4Daishan> {

	public SwitchModuleUnpStrategy4Daishan(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
		dealChange = true;
	}

	@Override
	public String getDeviceType() {
		return "SwitchModule_DS";
	}

	@Override
	public SwitchModule_DaishanConvert getConvert(SwitchModulePacket4Daishan packet) {
		return new SwitchModule_DaishanConvert(packet);
	}

	@Override
	protected SwitchModulePacket4Daishan handleTotalQuery(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData) throws PacketInCorrectException {
		SwitchModulePacket4Daishan packet = new SwitchModulePacket4Daishan(mDevice.vCpu);
		packet.hasSmoke1 = yxData.get(1).getOriginData()[0] == 1 ? false : true;
		//
		packet.hasSmoke2 = yxData.get(2).getOriginData()[0] == 1 ? false : true;
		//
		packet.hasVisitor1 = yxData.get(3).getOriginData()[0] == 1 ? false : true;
		packet.hasVisitor2 = yxData.get(4).getOriginData()[0] == 1 ? false : true;
		packet.hasWater = yxData.get(5).getOriginData()[0] == 1 ? false : true;
		return packet;
	}

	@Override
	protected SwitchModulePacket4Daishan handleChange(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData)  throws IgnorePackageException {
		AbsJsonConvert<?> c = null;

		if (DataBuffer.getInstance().getBuffer() == null
				|| DataBuffer.getInstance().getBuffer().get(getLogotype()) == null
				|| DataBuffer.getInstance().getBuffer().get(getLogotype()).get(mDevice.vCpu) == null) {
			c = new SwitchModule_DaishanConvert(new SwitchModulePacket4Daishan(mDevice.vCpu));
		} else {
			c = DataBuffer.getInstance().getBuffer().get(getLogotype()).get(mDevice.vCpu);
		}

		SwitchModule_DaishanConvert orignal = (SwitchModule_DaishanConvert) c;
		SwitchModulePacket4Daishan packet = orignal.getOriginal();

		packet.notify = true;
		try {
			packet.hasSmoke1 = yxData.get(1).getOriginData()[0] == 1 ? false : true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			packet.hasSmoke2 = yxData.get(2).getOriginData()[0] == 1 ? false : true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			packet.hasVisitor1 = yxData.get(3).getOriginData()[0] == 1 ? false : true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			packet.hasVisitor2 = yxData.get(4).getOriginData()[0] == 1 ? false : true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			packet.hasWater = yxData.get(5).getOriginData()[0] == 1 ? false : true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return packet;
	}
}
