package com.heshun.dsm.handler.transfer;

import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.convert.AbsJsonConvert;

/**
 * 单个传输
 * 
 * @author huangxz
 *
 */
public class SingleTransferHandler implements ItfTransferHandler {

	@Override
	public void transfer(IoSession session, AbsJsonConvert message) {
		/*if (message instanceof EQA300_Packet) {// 电能采集表
			int logotype = (int) session.getAttribute("logotype");
			EQA300_Packet p = (EQA300_Packet) message;
			EQA300Convert convert = new EQA300Convert(p);
			JSONObject _json = convert.toJsonObj(String.valueOf(logotype));
			ELog.getInstance().log(String.format("【####### 解析结果】\r\n %s", JSONObject.toJSONString(_json, true)),
					session);
			// ELog.getInstance().log(HttpUtils.post(Constants.ELEC_ACTION,
			// _json), session);

		} else if (message instanceof BG5485_Packet) {// 温湿度表
			int logotype = (int) session.getAttribute("logotype");
			BG5485_Packet pack = (BG5485_Packet) message;
			BG5485Convert convert = new BG5485Convert(pack);
			JSONObject _json = convert.toJsonObj(String.valueOf(logotype));
			ELog.getInstance().log(String.format("【####### 解析结果】\r\n %s", JSONObject.toJSONString(_json, true)),
					session);
			ELog.getInstance().log(HttpUtils.post(Constants.getTempUrl(), _json), session);
		} else if (message instanceof SFO2_Packet) {
			int logotype = (int) session.getAttribute("logotype");
			SFO2_Packet pack = (SFO2_Packet) message;
			SFO2Convert convert = new SFO2Convert(pack);
			JSONObject _json = convert.toJsonObj(String.valueOf(logotype));
			ELog.getInstance().log(String.format("【####### 解析结果】\r\n %s", JSONObject.toJSONString(_json, true)),
					session);
			ELog.getInstance().log(HttpUtils.post(Constants.getEnviroUrl(), _json), session);
		} else if (message instanceof YHT2_TR_Packet) {
			int logotype = (int) session.getAttribute("logotype");
			YHT2_TR_Packet pack = (YHT2_TR_Packet) message;
			YHT2_TRConvert convert = new YHT2_TRConvert(pack);
			JSONObject _json = convert.toJsonObj(String.valueOf(logotype));
			ELog.getInstance().log(String.format("【####### 解析结果】\r\n %s", JSONObject.toJSONString(_json, true)),
					session);
			ELog.getInstance().log(HttpUtils.post(Constants.getEnviroUrl(), _json), session);
		}
*/
	}

}
