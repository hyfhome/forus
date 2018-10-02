package com.my.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	private static String drivers = DBConfig.DRIVERS;
	private static String url = DBConfig.URL;
	private static String user = DBConfig.USER;
	private static String password = DBConfig.PASSWORD;
	public static Connection GetConnection() { // 获取数据连接
		Connection conn = null;
		try {
			Class.forName(drivers).newInstance(); 
			//
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 
		 try {
			 System.out.println("url------"+url);
			 System.out.println("user------"+user);
			 System.out.println("password------"+password);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
		}
	public static void close(Connection conn)
	{
		try {
			if(conn != null && !conn.isClosed())
			{
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
