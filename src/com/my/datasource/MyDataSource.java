package com.my.datasource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义连接池
 * @author Administrator
 *
 */
public class MyDataSource {
	//定义一个池，用于存放连接
	private static List<Connection> pool = Collections.synchronizedList(new ArrayList<>());
	//使用静态代码块给池中加入连接
	static {
		for(int i = 0; i < 10; i++) {
			Connection conn = Utils.GetConnection();
			pool.add(conn);
		}
	}
	/**
	 * 获取一个连接
	 * @return
	 */
	public static Connection removeConnection() {
		Connection conn =  pool.remove(0);
		//创建代理对象
		Connection proxyConn = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(),
				conn.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO 自动生成的方法存根
						Object rtValue = null;
						if("close".equals(method.getName())) {
							//还回池中
							pool.add(conn);
						}
						else {
							rtValue = method.invoke(conn, args);
						}
						return rtValue;
					}
			
		});
		return proxyConn;
	}
	// 获取池中的连接数
	public static int getPoolSize() {
		return pool.size();
	}
}
