package com.my.datasource;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
		int size = MyDataSource.getPoolSize();
		System.out.println("使用连接之前" + size);
		for(int i = 0; i < 10; i ++) {
		Connection conn = MyDataSource.removeConnection();
		System.out.println(conn);
		try {
			//不应该关闭，应放入池中。
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}
		
		int size1 = MyDataSource.getPoolSize();
		System.out.println("使用连接之后" + size1);
	}

}
