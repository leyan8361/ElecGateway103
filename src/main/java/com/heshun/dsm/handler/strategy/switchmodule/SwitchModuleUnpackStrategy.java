package com.heshun.dsm.handler.strategy.switchmodule;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.entity.global.DataBuffer;
import com.heshun.dsm.handler.helper.IgnorePackageException;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.service.SystemHelper;

public class SwitchModuleUnpackStrategy extends AbsDeviceUnpackStrategy<SwitchModuleConvert, SwitchModulePacket> {
	SwitchModuleProxy proxy;

	public SwitchModuleUnpackStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
		proxy = new SwitchModuleProxy();
		dealChange = true;
		SystemHelper.loadSwitchConfig(session, mDevice.vCpu);
	}

	@Override
	protected SwitchModulePacket handleTotalQuery(int size, Map<Integer, byte[]> ycData, Map<Integer, byte[]> yxData,
			Map<Integer, byte[]> ymData) throws PacketInCorrectException, UnRegistSupervisorException {
		SwitchModulePacket packet = new SwitchModulePacket(mDevice.vCpu);
		for (Entry<Integer, byte[]> entry : yxData.entrySet()) {
			packet.mFlags.put(String.valueOf(entry.getKey()), entry.getValue()[0] == 1 ? false : true);
		}
		return packet;

	}

	@Override
	public SwitchModuleConvert getConvert(SwitchModulePacket packet) {
		return new SwitchModuleConvert(packet);
	}

	@Override
	protected SwitchModulePacket handleChange(int size, Map<Integer, byte[]> ycData, Map<Integer, byte[]> yxData,
			Map<Integer, byte[]> ymData) throws IgnorePackageException, PacketInCorrectException {

		AbsJsonConvert<?> c = null;

		if (DataBuffer.getInstance().getBuffer() == null
				|| DataBuffer.getInstance().getBuffer().get(getLogotype()) == null
				|| DataBuffer.getInstance().getBuffer().get(getLogotype()).get(mDevice.vCpu) == null) {
			c = new SwitchModuleConvert(new SwitchModulePacket(mDevice.vCpu));
		} else {
			c = DataBuffer.getInstance().getBuffer().get(getLogotype()).get(mDevice.vCpu);
		}

		SwitchModuleConvert orignal = (SwitchModuleConvert) c;
		SwitchModulePacket packet = orignal.getOriginal();
		packet.notify = true;
		for (Entry<Integer, byte[]> entry : yxData.entrySet()) {
			packet.mFlags.put(String.valueOf(entry.getKey()), entry.getValue()[0] == 1 ? false : true);
		}

		proxy.handleControl(session, ycData, yxData, ymData);
		return packet;
	}

	@Override
	public String getDeviceType() {
		return "switch";
	}

}
