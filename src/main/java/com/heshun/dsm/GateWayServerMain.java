package com.heshun.dsm;

import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.alibaba.fastjson.JSONException;
import com.heshun.dsm.common.Constants;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.entity.global.DataBuffer;
import com.heshun.dsm.service.SystemHelper;
import com.heshun.dsm.ui.ControlPanel;
import com.heshun.dsm.ui.ControlPanel.OnClickListener;
import com.heshun.dsm.ui.ControlPanel.OnStatusChangeListener;
import com.heshun.dsm.ui.ListPanel;
import com.heshun.dsm.util.ELog;

public class GateWayServerMain {

	public static void main(String[] args) {

		ControlPanel panel = new ControlPanel(new OnClickListener() {

			@Override
			public void onInit(TextArea contentText, final Label countLabel, final TextArea tvDatas,
					final TextField tfPort, final JList<String> mJList) {
				ELog.getInstance().setOutputSource(contentText);
				final ListPanel listPanel = new ListPanel(mJList);

				// listPanel.initJListPanel();
				/*
				 * 初始化监听程序
				 */
				try {
					/*
					 * 初始化服务地址
					 */
					SystemHelper.loadSystemConfig();
					SystemHelper.initMessageListener(new OnStatusChangeListener() {

						@Override
						public void onConnectChange() {
							countLabel.setText(String.format("online:%s", SystemHelper.minaAcceptor
									.getManagedSessions().size()));
							listPanel.upData();
						}

						@Override
						public void onDataChanged() {
							SwingUtilities.invokeLater(new Runnable() {

								@Override
								public void run() {
									tvDatas.setText("");
									StringBuffer sb = new StringBuffer("缓冲区数据:");

									Map<Integer, Map<Integer, AbsJsonConvert<?>>> mBuffer = DataBuffer.getInstance()
											.getBuffer();
									sb.append(mBuffer.size()).append("\r\n");
									for (Entry<Integer, Map<Integer, AbsJsonConvert<?>>> entry : mBuffer.entrySet()) {
										sb.append(entry.getKey()).append(":").append(entry.getValue().size())
												.append("\r\n");
									}
									tvDatas.setText(sb.toString());

								}
							});
						}

					});
				} catch (IOException e) {
					String errorMessage = String.format("开启Tcp监听失败，请检查%s端口是否被占用", Constants.TCP_ACCEPTOR_PORT);
					ELog.getInstance().err(errorMessage);
					e.printStackTrace();
					return;
				} catch (JSONException e) {
					String errorMessage = String.format("json解析错误，请检查配置文件格式是否正确", Constants.TCP_ACCEPTOR_PORT);
					ELog.getInstance().err(errorMessage);
					e.printStackTrace();
				}
			}

			/*
			 * 启动按钮
			 */
			@Override
			public void onStart() {

				/*
				 * 开启udp广播自身ip,等待从机的tcp连接
				 */
				SystemHelper.start();
			}

			/*
			 * 停止按钮
			 */
			@Override
			public void onStop() {
				System.exit(0);
			}

			/*
			 * 清空缓存按钮
			 */
			@Override
			public void onFlush() {
				SystemHelper.mQueryTask.flush();
			}

			@Override
			public void onReset() {
			}

		});

		panel.open();

	}

}
