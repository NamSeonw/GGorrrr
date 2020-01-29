package com.ggorrrr.web.controller.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ggorrrr.web.controller.dao.AdminDao;
import com.ggorrrr.web.controller.entity.Admin;

public class JdbcAdminDao implements AdminDao {

	@Override
	public int insert(int memberId) {
		int result = 0;
		String sql = "INSERT INTO manager (member_id) VALUES(?)";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, memberId);
			result = st.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int delete(int memberId) {
		int result = 0;
		String sql = "delete manager where member_id=?";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, memberId);
			result = st.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Admin get(String id) {
		Admin admin = null;
		String sql = "select * from admin where user_id = ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();

			while (rs.next()) {
				admin = new Admin(/**/
						rs.getInt("member_id"), /**/
						id, /**/
						rs.getString("pwd"), /**/
						rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}
}
