package com.heshun.dsm.handler.transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.common.Constants;
import com.heshun.dsm.common.http.HttpUtils;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.service.SystemHelper;
import com.heshun.dsm.service.TotalQueryTask.QueryLoopFinishListener;
import com.heshun.dsm.ui.ControlPanel.OnStatusChangeListener;
import com.heshun.dsm.util.ELog;

/**
 * 批量传输
 * 
 * @author huangxz
 * 
 */
public class BatchTransferHandler implements ItfTransferHandler, QueryLoopFinishListener {

	// 数据缓冲
	private Map<Integer, List<Object>> mBuffer;

	private OnStatusChangeListener mListener;

	public BatchTransferHandler(OnStatusChangeListener mListener) {
		this.mListener = mListener;
		mBuffer = new HashMap<Integer, List<Object>>();
	}

	@Override
	public void transfer(IoSession session, AbsJsonConvert message) {

		int logotype = (int) session.getAttribute("logotype");

		List<Object> datas = mBuffer.get(logotype);
		if (datas == null) {
			datas = new ArrayList<Object>();
			mBuffer.put(logotype, datas);
		}

		datas.add(message.toJsonObj(String.valueOf(logotype)));
//		mListener.onDataChanged(mBuffer);

	}

	@Override
	public void onFinishLoop() {

		final Map<Integer, List<Object>> _copy = new HashMap<Integer, List<Object>>();
		_copy.putAll(mBuffer);
		mBuffer.clear();
//		mListener.onDataChanged(mBuffer);
		for (final Entry<Integer, List<Object>> entry : _copy.entrySet()) {
			final int logotype = entry.getKey();
			SystemHelper.mHttpRequestThreadPool.schedule(new Runnable() {

				@Override
				public void run() {
					List<Object> datas = entry.getValue();
					ELog.getInstance().log(String.format("%s-周期结束，组包发送，共%s", logotype, datas.size()), logotype);
					final JSONObject jo = new JSONObject();
					jo.put("ip", logotype);
					jo.put("data", datas);
					ELog.getInstance().log(
							String.format("%s周期组包数据====|\r\n %s", logotype, JSONObject.toJSONString(jo)), logotype);
					ELog.getInstance().log(HttpUtils.post(Constants.getBathUrl(), jo), logotype);
				}
			}, 500, TimeUnit.MILLISECONDS);
		}
	}

}
