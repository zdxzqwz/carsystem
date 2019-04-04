package com.it.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: JDBCUtils.java
* @Description: 数据库工具类
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月12日 上午11:03:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月12日     Only soul           v1.0.0               修改原因
 */
public class JDBCUtils {
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * 生成datasource
	 */
	static BasicDataSource dataSource = new BasicDataSource();
	
	/**
	 * 静态块
	 */
	static {
		try {
			readConfig();
			//加载驱动
			dataSource.setDriverClassName(driverClassName);
			//设置url
			dataSource.setUrl(url);
			//账户名
			dataSource.setUsername(username);
			//密码
			dataSource.setPassword(password);
			//初始化
			dataSource.setInitialSize(10);
			//最大连接数
			dataSource.setMaxActive(8);
			//最大空闲数
			dataSource.setMaxIdle(5);
			//最小空闲数
			dataSource.setMinIdle(3);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void readConfig()throws Exception{
		InputStream in = JDBCUtils .class.getClassLoader().getResourceAsStream("db.properties");

		Properties pro = new Properties();
		 pro.load(in);
		 driverClassName =pro.getProperty("driverClass");
		 url = pro.getProperty("url");
		 username = pro.getProperty("username");
		 password = pro.getProperty("password");
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnections(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
