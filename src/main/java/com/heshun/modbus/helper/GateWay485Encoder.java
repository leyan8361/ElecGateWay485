package com.heshun.modbus.helper;

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
public class GateWay485Encoder implements ProtocolEncoder {

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

	// ResultLock 存放请求ID与对应的返回结果
	public class ResultLock {

		private String id;
		private Object message;

		public ResultLock(String id) {
			this.id = id;
		}

		public Object getMessage() {
			return message;
		}

		public void setMessage(Object message) {
			this.message = message;
		}
	}

}
