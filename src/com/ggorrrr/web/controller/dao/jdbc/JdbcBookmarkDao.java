package com.ggorrrr.web.controller.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ggorrrr.web.controller.dao.BookmarkDao;
import com.ggorrrr.web.controller.entity.BookmarkMenu;

public class JdbcBookmarkDao implements BookmarkDao {

	// 즐겨찾기 등록
	@Override
	public int insert(BookmarkMenu bookmarkMenu) {
		int result = 0;
		String sql = "INSERT INTO BOOKMARK (MEMBER_ID,FOOD_ID) VALUES (?,?)";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, bookmarkMenu.getMember_id());
			st.setInt(2, bookmarkMenu.getId());
			result = st.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	// 즐겨찾기 삭제
	@Override
	public int delete(int member_id,int food_id) {
		int result = 0;
		String sql = "DELETE FROM BOOKMARK WHERE FOOD_ID=? AND MEMBER_ID=?";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, food_id);
			st.setInt(2, member_id);
			result = st.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	// 즐겨찾기 목록 가져오기
	@Override
	public List<BookmarkMenu> getList(int member_id) {
		List<BookmarkMenu> list = new ArrayList<BookmarkMenu>();
		String sql = "SELECT FOOD_ID, KORNAME, PHOTO FROM BOOKMARK_VIEW WHERE member_ID = ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, member_id);
			rs = st.executeQuery();

			while (rs.next()) {
				BookmarkMenu bookmarkView = new BookmarkMenu(/**/
						rs.getInt("food_id"), /**/
						rs.getString("photo"), /**/
						rs.getString("korname"), /**/
						member_id);
				list.add(bookmarkView);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return list;
	}
}
