package com.heshun.dsm.handler.strategy.pd204.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.ResultWrapper;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.util.Utils;

public class PD204EUnpStrategy extends AbsDeviceUnpackStrategy<PD204EConvert, PD204EPacket> {

	private Method[] methods;

	public PD204EUnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
		methods = new Method[24];
		try {
			methods[0] = PD204EPacket.class.getMethod("set_ua", float.class);
			methods[1] = PD204EPacket.class.getMethod("set_ub", float.class);
			methods[2] = PD204EPacket.class.getMethod("set_uc", float.class);
			methods[3] = PD204EPacket.class.getMethod("set_uab", float.class);
			methods[4] = PD204EPacket.class.getMethod("set_ubc", float.class);
			methods[5] = PD204EPacket.class.getMethod("set_uca", float.class);
			methods[6] = PD204EPacket.class.getMethod("set_ia", float.class);
			methods[7] = PD204EPacket.class.getMethod("set_ib", float.class);
			methods[8] = PD204EPacket.class.getMethod("set_ic", float.class);
			methods[9] = PD204EPacket.class.getMethod("set_pa", float.class);
			methods[10] = PD204EPacket.class.getMethod("set_pb", float.class);
			methods[11] = PD204EPacket.class.getMethod("set_pc", float.class);
			methods[12] = PD204EPacket.class.getMethod("set_ptotal", float.class);
			methods[13] = PD204EPacket.class.getMethod("set_qa", float.class);
			methods[14] = PD204EPacket.class.getMethod("set_qb", float.class);
			methods[15] = PD204EPacket.class.getMethod("set_qc", float.class);
			methods[16] = PD204EPacket.class.getMethod("set_qtotal", float.class);
			methods[17] = PD204EPacket.class.getMethod("set_stotal", float.class);
			methods[18] = PD204EPacket.class.getMethod("set_pf", float.class);
			methods[19] = PD204EPacket.class.getMethod("set_hertz", float.class);
			methods[20] = PD204EPacket.class.getMethod("set_forward_KA", long.class);
			methods[21] = PD204EPacket.class.getMethod("set_backward_KA", long.class);
			methods[22] = PD204EPacket.class.getMethod("set_forward_KR", long.class);
			methods[23] = PD204EPacket.class.getMethod("set_backward_KR", long.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private void setParam2(int i, byte[] data, PD204EPacket packet) {
		try {
			if (i >= 20) {// 后四位为long类型
				methods[i].invoke(packet, (long) (Utils.byteArrayToInt(data, 0)));
				return;
			}
			methods[i].invoke(packet, Float.intBitsToFloat(Utils.byteArrayToInt(data, 0)));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getDeviceType() {
		return "PD204E";
	}

	@Override
	public PD204EConvert getConvert(PD204EPacket packet) {
		PD204EConvert pd204eConvert = new PD204EConvert(packet);
		return pd204eConvert;
	}

	@Override
	protected PD204EPacket handleTotalQuery(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData) throws PacketInCorrectException,
			UnRegistSupervisorException {
		PD204EPacket packet = new PD204EPacket(mDevice.vCpu);
		try {
			for (int i = 0; i < 24; i++) {
				// 开始截取数据
				byte[] _singleData = ymData.get(i + 1).getOriginData();
				byte[] data = new byte[] { _singleData[3], _singleData[2], _singleData[1], _singleData[0] };
				setParam2(i, data, packet);
			}
		} catch (NullPointerException e) {
			throw new PacketInCorrectException();
		}
		return packet;
	}

}
