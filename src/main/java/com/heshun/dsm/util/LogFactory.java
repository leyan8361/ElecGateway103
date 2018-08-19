package com.heshun.dsm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heshun.dsm.common.Config;
import com.heshun.dsm.common.Constants;

public class LogFactory {
	private static LogFactory instance;
	private static Properties pro;

	private LogFactory() {
		pro = new Properties();
		FileInputStream istream = null;

		try {
			if (Config.isDebug) {
				istream = new FileInputStream(new File("src/main/resource/" + Constants.LOG_PATH));
			} else {
				istream = new FileInputStream(
						new File(LogFactory.class.getResource("/" + Constants.LOG_PATH).getPath()));
			}
			pro.load(istream);// 从输入流中读取属性列表
			pro.put("log4j.appender.dsm", "org.apache.log4j.RollingFileAppender");
			pro.put("log4j.appender.dsm.MaxFileSize", "15MB");
			pro.put("log4j.appender.dsm.MaxBackupIndex", "20");
			pro.put("log4j.appender.dsm.layout", "org.apache.log4j.PatternLayout");
			pro.put("log4j.appender.dsm.layout.ConversionPattern", "%p %d %t %c - %m%n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Logger getLogger(String gid) {
		synchronized (LogFactory.class) {
			if (null == instance) {
				instance = new LogFactory();
			}
			// "D:\\heshundsm\\managerlog\\" + gid + ".log"
			pro.put("log4j.appender.dsm.File", String.format("%s%s.log", Constants.LOG_OUT_PATH, gid));
			PropertyConfigurator.configure(pro);
			return LoggerFactory.getLogger("dsm");
		}
	}
	/*
	 * public static Logger getLogger(String gid) { try { Properties pro = new
	 * Properties(); FileInputStream istream = null;
	 * 
	 * if (Config.isDebug) { istream = new FileInputStream(new
	 * File("src/main/resource/" + Constants.LOG_PATH)); } else { istream = new
	 * FileInputStream( new File(LogFactory.class.getResource("/" +
	 * Constants.LOG_PATH).getPath())); } pro.load(istream);// 从输入流中读取属性列表 //
	 * pro.put("log4j.rootLogger", "info,pile"); pro.put("log4j.appender.dsm",
	 * "org.apache.log4j.RollingFileAppender");
	 * pro.put("log4j.appender.dsm.File", "D:\\heshundsm\\managerlog\\" + gid +
	 * ".log"); pro.put("log4j.appender.dsm.MaxFileSize", "15MB");
	 * pro.put("log4j.appender.dsm.MaxBackupIndex", "20"); //
	 * pro.put("log4j.appender.pile.DatePattern", "'.'yyyy-MM-dd-HH");
	 * pro.put("log4j.appender.dsm.layout", "org.apache.log4j.PatternLayout");
	 * pro.put("log4j.appender.dsm.layout.ConversionPattern",
	 * "%p %d %t %c - %m%n"); // // pro.put("log4j.appender.dsm.ImmediateFlush",
	 * false); // pro.put("log4j.appender.dsm.bufferedIO", true); //
	 * pro.put("log4j.appender.dsm.bufferSize", 81920);
	 * 
	 * PropertyConfigurator.configure(pro); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return LoggerFactory.getLogger("dsm"); }
	 */
}
