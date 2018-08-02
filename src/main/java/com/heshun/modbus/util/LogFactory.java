package com.heshun.modbus.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heshun.modbus.common.Config;
import com.heshun.modbus.common.Constants;

public class LogFactory {
	public static Logger getLogger(String gid) {
		try {
			Properties pro = new Properties();
			FileInputStream istream = null;

			if (Config.isDebug) {
				istream = new FileInputStream(new File("src/main/resource/" + Constants.LOG_PATH));
			} else {
				istream = new FileInputStream(
						new File(LogFactory.class.getResource("/" + Constants.LOG_PATH).getPath()));
			}
			pro.load(istream);// 从输入流中读取属性列表
			pro.put("log4j.rootLogger", "info,Console,dsm");
			pro.put("log4j.appender.dsm", "org.apache.log4j.RollingFileAppender");
//			pro.put("log4j.appender.dsm.File", "D:\\heshundsm\\dtulog\\" + gid + ".log");
			pro.put("log4j.appender.dsm.File", String.format("%s%s.log", Constants.LOG_OUT_PATH, gid));
			pro.put("log4j.appender.dsm.MaxFileSize", "15MB");
			pro.put("log4j.appender.dsm.MaxBackupIndex", "30");
			// pro.put("log4j.appender.pile.DatePattern", "'.'yyyy-MM-dd-HH");
			pro.put("log4j.appender.dsm.layout", "org.apache.log4j.PatternLayout");
			pro.put("log4j.appender.dsm.layout.ConversionPattern", "%p %d %t %c - %m%n");
			PropertyConfigurator.configure(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return LoggerFactory.getLogger("dsm");
	}
}
