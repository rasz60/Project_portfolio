package com.edt.dynamic.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "scott";
	String pwd = "tiger";
	
	public static Connection DBConn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
		} catch(Exception e1) {
			e1.printStackTrace();
		} 
		return conn;
	}
}
