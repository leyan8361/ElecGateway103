package com.heshun.dsm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.common.Constants;
import com.heshun.dsm.common.http.HttpUtils;
import com.heshun.dsm.service.SystemHelper;

public class FixDatabyLogs {

	private final static String END_FIX = "====|";
	private static boolean gotData;

	public static void main(String[] args) {
		fix2();
	}

	private static void fix2() {
		File dir = new File("F://logs");
		File[] files = dir.listFiles();
		BufferedReader reader = null;
		for (File file : files) {
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
				for (;;) {
					String lineStr = reader.readLine();
					if (lineStr != null) {
						System.out.println(lineStr);
						if (gotData || lineStr.startsWith("{")) {
							doupdate(lineStr);
						}
						if (lineStr.endsWith(END_FIX)) {
							gotData = true;
						}
					} else {
						reader.close();
						file.delete();
						gotData = false;
						break;
					}
				}
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void fix1() {
		File dir = new File("F://logs");
		File[] logs = dir.listFiles();
		BufferedReader in = null;
		for (File file : logs) {
			try {
				in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
				String _line;
				for (;;) {
					_line = in.readLine();
					if (_line == null) {
						in.close();
						file.delete();
						break;
					} else {
						System.out.println(_line);
						if (_line.endsWith("====|")) {
							StringBuffer sb = new StringBuffer();
							for (;;) {
								_line = in.readLine();
								if (_line == null) {
									in.close();
									file.delete();
									break;
								}
								if (_line.startsWith("INFO") || _line.startsWith("WARN")) {
									try {
										doupdate(sb);
									} catch (Exception e) {
										e.printStackTrace();
										continue;
									}
									sb.setLength(0);
									break;
								}
								sb.append(_line);
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void doupdate(final String sb) {
		System.out.println("=====================正在上报数据=======================\r\n");

		gotData = false;

		SystemHelper.mHttpRequestThreadPool.schedule(new Runnable() {

			@Override
			public void run() {
				String result = HttpUtils.post(Constants.getBathUrl(), JSON.parseObject(sb));
				ELog.getInstance().simplelog(result, 99999);

			}
		}, 500, TimeUnit.MILLISECONDS);

	}

	private static void doupdate(StringBuffer sb) {
		System.out
				.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\r\n");
		System.out.println(HttpUtils.post(Constants.getBathUrl(), JSON.parseObject(sb.toString())));
	}
}
