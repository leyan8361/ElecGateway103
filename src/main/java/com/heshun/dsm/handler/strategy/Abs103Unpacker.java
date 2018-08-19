package com.heshun.dsm.handler.strategy;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.entity.pack.DefaultDevicePacket;
import com.heshun.dsm.handler.helper.BufferTransferIncompleteException;
import com.heshun.dsm.handler.helper.IgnorePackageException;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.util.ELog;
import com.heshun.dsm.util.SessionUtils;

/**
 * 103解码器顶级抽象父类
 * 
 * @author huangxz
 * 
 */
public abstract class Abs103Unpacker<T extends AbsJsonConvert<V>, V extends DefaultDevicePacket> {

	/**
	 * socket通道
	 */
	protected IoSession session;
	/**
	 * 103报文输入流
	 */
	protected IoBuffer in;

	/**
	 * 报文针对的设备
	 */
	protected Device mDevice;

	/**
	 * 构造子
	 */
	public Abs103Unpacker(IoSession session, IoBuffer in, Device d) {
		this.session = session;
		this.in = in;
		this.mDevice = d;
	}

	public T doUnPack() throws BufferTransferIncompleteException, PacketInCorrectException, IgnorePackageException,
			UnRegistSupervisorException {
		printOrignalPack();
		return getConvert(unpack());
	}

	protected abstract V unpack() throws BufferTransferIncompleteException, PacketInCorrectException,
			IgnorePackageException, UnRegistSupervisorException;

	public abstract T getConvert(V packet);

	/**
	 * 输出原始报文
	 */
	public void printOrignalPack() {
		ELog.getInstance().log(
				String.format("[#######%s-原始报文---->%s:%s]\r\n%s\r\n", getDeviceType(),
						SessionUtils.getIpFromSession(session), SessionUtils.getLogoType(session), in.getHexDump()),
				session);
	}

	public abstract String getDeviceType();

	public enum PackageType {
		TOTAL_QUERY, ACTIVE_NOTIF, CHANGE_NOTIF, REMOTE_CONTROL;

	}

	protected int getLogotype() {

		return SessionUtils.getLogoType(session);
	}
}
