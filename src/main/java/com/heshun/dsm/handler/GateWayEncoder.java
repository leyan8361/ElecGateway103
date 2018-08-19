package com.heshun.dsm.handler;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * 发送报文转码器
 * 
 * @author huangxz
 *
 */
public class GateWayEncoder implements ProtocolEncoder {

	@Override
	public void dispose(IoSession arg0) throws Exception {

	}

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		if (message instanceof byte[]) {
			byte[] _out = (byte[]) message;
			IoBuffer outBuffer = IoBuffer.allocate(_out.length);
			outBuffer.put(_out);
			outBuffer.setAutoExpand(true);
			out.write(outBuffer.flip());
		}
	}

}
