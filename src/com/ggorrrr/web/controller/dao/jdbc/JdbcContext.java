package com.ggorrrr.web.controller.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcContext {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "GGORRRR", "0112");
		return con;
	}

	public static Statement getStatement() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		return st;
	}

	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		return st;
	}

	public static void delCon() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		if (con != null)
			con.close();
	}
}