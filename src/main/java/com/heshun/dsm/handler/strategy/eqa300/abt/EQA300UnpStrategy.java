package com.heshun.dsm.handler.strategy.eqa300.abt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.util.Utils;

/**
 * 智瀚EQA300解包策略
 * 
 * @author huangxz
 * 
 */
public class EQA300UnpStrategy extends AbsDeviceUnpackStrategy<EQA300Convert, EQA300Packet> {
	Method[] methods;

	public EQA300UnpStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
		methods = new Method[26];
		try {
			methods[0] = EQA300Packet.class.getMethod("set_pid", short.class);
			methods[1] = EQA300Packet.class.getMethod("set_port", short.class);
			methods[2] = EQA300Packet.class.getMethod("set_wireType", short.class);
			methods[3] = EQA300Packet.class.getMethod("set_version", short.class);
			methods[4] = EQA300Packet.class.getMethod("set_dpt", short.class);
			methods[5] = EQA300Packet.class.getMethod("set_dct", short.class);
			methods[6] = EQA300Packet.class.getMethod("set_dqt", short.class);
			methods[7] = EQA300Packet.class.getMethod("set_ua", short.class);
			methods[8] = EQA300Packet.class.getMethod("set_ub", short.class);
			methods[9] = EQA300Packet.class.getMethod("set_uc", short.class);
			methods[10] = EQA300Packet.class.getMethod("set_uab", short.class);
			methods[11] = EQA300Packet.class.getMethod("set_ubc", short.class);
			methods[12] = EQA300Packet.class.getMethod("set_uca", short.class);
			methods[13] = EQA300Packet.class.getMethod("set_ia", short.class);
			methods[14] = EQA300Packet.class.getMethod("set_ib", short.class);
			methods[15] = EQA300Packet.class.getMethod("set_ic", short.class);
			methods[16] = EQA300Packet.class.getMethod("set_pa", short.class);
			methods[17] = EQA300Packet.class.getMethod("set_pb", short.class);
			methods[18] = EQA300Packet.class.getMethod("set_pc", short.class);
			methods[19] = EQA300Packet.class.getMethod("set_ptotal", short.class);
			methods[20] = EQA300Packet.class.getMethod("set_pfa", short.class);
			methods[21] = EQA300Packet.class.getMethod("set_pfb", short.class);
			methods[22] = EQA300Packet.class.getMethod("set_pfc", short.class);
			methods[23] = EQA300Packet.class.getMethod("set_pftotal", short.class);
			methods[24] = EQA300Packet.class.getMethod("setEpiHigh", byte[].class);
			methods[25] = EQA300Packet.class.getMethod("setEpiLow", byte[].class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private void setParam(int index, byte high, byte low, EQA300Packet pack) {

		try {
			if (index < methods.length) {
				if (index == methods.length - 2 || index == methods.length - 1) {
					methods[index].invoke(pack, new byte[] { high, low });
					return;
				}
				methods[index].invoke(pack, (short) (Utils.bytes2Short(high, low) & 0xFFFF));
			}
		} catch (SecurityException e) {
			e.printStackTrace();
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
		return "eqa300";
	}

	@Override
	public EQA300Convert getConvert(EQA300Packet packet) {
		return new EQA300Convert(packet);
	}

	@Override
	protected EQA300Packet handleTotalQuery(int size, Map<Integer, byte[]> ycData, Map<Integer, byte[]> yxData,
			Map<Integer, byte[]> ymData) throws PacketInCorrectException {
		EQA300Packet packet = new EQA300Packet(mDevice.vCpu);
		try {
			for (int i = 0; i < 26; i++) {
				byte high, low;
				byte[] _singleData = ycData.get(i + 1);
				high = _singleData[0];
				low = _singleData[1];
				setParam(i, high, low, packet);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new PacketInCorrectException();
		}

		return packet;
	}

}
