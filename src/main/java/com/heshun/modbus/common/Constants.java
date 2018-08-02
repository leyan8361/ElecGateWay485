package com.heshun.modbus.common;

public class Constants {
	public static String LOG_OUT_PATH = "D:\\heshundsm\\dtulog\\";
	/**
	 * 广播地址
	 */
	public static String BROADCAST_ADDR = "255.255.255.255";
	/**
	 * 广播收取心跳的时间频率
	 */
	public static int BORADCAST_TIME_GAP = 30 * 1000;
	/**
	 * 发起遥测频率
	 */
	public static int REMOTE_SENSING_GAP = 5 * 60 * 1000;

	public static int COMMAND_TIME_GAP_IN_SESSION = 1300;

	public static int FEED_BACK_DELAY = 20;

	public static String GATEWAY_VERSION = "1.0-beta";
	/**
	 * 远端接收广播的端口号，向这个端口循环发送广播
	 */
	public static int BROADCAST_PORT = 1032;
	/**
	 * Tcp监听端口，收取客户端传送的报文
	 */
	public static int TCP_ACCEPTOR_PORT = 9021;
	/**
	 * 进入空闲状态的时间间隔，单位s
	 */
	public static int TCP_IDLE_TIME = 30;
	/**
	 * 遥测数据头
	 */
	public final static byte HEAD_CODE_YC = 7;
	/**
	 * 遥信数据头
	 */
	public final static byte HEAD_CODE_YX = 8;
	/**
	 * 配置文件地址
	 */
	public final static String SERVER_PATH = "server.cfg";
	/**
	 * 配置文件地址
	 */
	public final static String CONFIG_PATH = "config.cfg";

	public final static String LOG_PATH = "log4j.properties";
	/**
	 * socket缓冲最小缓冲大小
	 */
	public final static int MIN_READBUFFER_SIZE = 20 * 2048;

	// public static String SERVER_ = "http://test.jsclp.cn/";
	// public static String SERVER_ = "http://172.31.59.62:9004/";
	public static String SERVER_ = "http://dsm.gate.jsclp.cn/";
	/**
	 * 配电，环境监控后台domain
	 */
	public static String ENVIRO_SERVER_PRFIX = "http://pd.jsclp.cn/";
	// public static String TEMP_ACTION =
	// "http://172.31.59.62:9000/dsm/api/front/insertTempedata";
	private static String ELEC_ACTION = "dsm/api/front/insertdata";
	private static String TEMP_ACTION = "dsm/api/front/insertTempedata";
	// private static String ENVIRO_ACTION =
	// "dsm/api/front/insertEnvironmentData";
	private static String ENVIRO_SERVER_ACTION = "pd/api/front/insertEnvironmentData";
	private static String BATCH_ACTION = "dsm/api/front/insertDataBach";

	// private static String BATCH_ACTION = "dsmV2/api/front/insertDataBach";

	public static String getBathUrl() {
		return SERVER_ + BATCH_ACTION;
	}

	public static String getTempUrl() {
		return SERVER_ + TEMP_ACTION;
	}

	public static String getElecUrl() {

		return SERVER_ + ELEC_ACTION;
	}

	public static String getEnviroUrl() {

		return SERVER_ + ENVIRO_SERVER_ACTION;
	}

}
