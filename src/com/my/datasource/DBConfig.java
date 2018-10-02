package com.my.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
	private static String db_config = "F:\\EclipseSpace\\EclipseSpace\\DBTest00\\src\\com\\db1\\dbconfig.properties";
	public static String DRIVERS = null;
	public static String URL = null;
	public static String USER = null;
	public static String PASSWORD = null;
	static  //声明静态代码块
	{
		Properties props = new Properties();
		InputStream ips = null;
		try {
			//读取属性文件
			ips = new FileInputStream(db_config);
			props.load(ips);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DRIVERS = props.getProperty("drivers");
		URL = props.getProperty("url");
		USER = props.getProperty("user");
		PASSWORD = props.getProperty("pwd");
	}

}
