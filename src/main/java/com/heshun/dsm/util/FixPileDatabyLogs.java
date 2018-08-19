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

public class FixPileDatabyLogs {

	public static void main(String[] args) {
		// fix2();
		fix();
	}

	private static void fix() {
		File dir = new File("F://logs");
		File[] files = dir.listFiles();
		BufferedReader reader = null;
		for (File file : files) {
			try {

				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
				for (;;) {
					String lineStr = reader.readLine();
					if (lineStr != null) {
						String _json = lineStr.substring(lineStr.indexOf("{"), lineStr.lastIndexOf("}") + 1);
						System.out.println(_json);
						doupdate(_json);
					} else {
						reader.close();
						file.delete();

						break;
					}
				}
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void doupdate(final String sb) {
		System.out.println("=====================正在上报数据=======================\r\n");

		SystemHelper.mHttpRequestThreadPool.schedule(new Runnable() {

			@Override
			public void run() {
				String result = HttpUtils.post("http://127.0.0.1:9004/cpm/api/front/finish", JSON.parseObject(sb));
				ELog.getInstance().simplelog(result, 99999);

			}
		}, 500, TimeUnit.MILLISECONDS);

	}

}
