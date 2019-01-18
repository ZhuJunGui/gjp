package com.cn.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * 作者：朱俊贵 时间：2019年1月17日下午7:00:24 描述：连接数据库的工具
 */
public class JDBCUtils {
	// 创建BasicDataSource对象
	private static BasicDataSource dataSource = new BasicDataSource();
	//设置静态，实现一些参数
	static{
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setMaxActive(10);
		dataSource.setMaxIdle(5);
		dataSource.setMinIdle(2);
		dataSource.setInitialSize(10);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}

}
