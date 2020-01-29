package com.ggorrrr.web.controller.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ggorrrr.web.controller.dao.ReviewDao;
import com.ggorrrr.web.controller.entity.Review;

public class JdbcReviewDao implements ReviewDao {

	@Override
	public List<Review> getList() {
		return getListByOrder(1, "regdate", "address", "");
	}

	@Override
	public List<Review> getList(int page, String field, String query) {
		return getListByOrder(1, "regdate", "address", "");
	}

	@Override
	public List<Review> getListByOrder(int page, String order, String field, String query) {
		List<Review> list = new ArrayList<Review>();
		String sql = "select * from (select rownum num, n.* from (select * from review where " + field
				+ " like ? order by " + order + " desc) n ) where num between ? and ?";
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, (page - 1) * 3 + 1);
			st.setInt(3, page * 3);
			rs = st.executeQuery();

			while (rs.next()) {
				Review review = new Review(/**/
						rs.getInt("id"), /**/
						rs.getInt("member_id"), /**/
						rs.getString("address"), /**/
						rs.getString("content"), /**/
						rs.getDate("eating_date"), /**/
						rs.getString("photo"), /**/
						rs.getDate("regdate"), /**/
						rs.getInt("rating"), /**/
						rs.getString("foodName"), /**/
						rs.getString("foodType"));
				list.add(review);
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

	@Override
	public List<Review> getListById(int member_id, int page, String field, String query) {
		List<Review> list = new ArrayList<Review>();
		String sql = "select * from (select rownum num, n.* from (select * from review where " + field
				+ " like ? order by regdate desc) n ) where num between ? and ? and member_id = ?";
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, (page - 1) * 3 + 1);
			st.setInt(3, page * 3);
			st.setInt(4, member_id);
			rs = st.executeQuery();

			while (rs.next()) {
				Review review = new Review(/**/
						rs.getInt("id"), /**/
						member_id, /**/
						rs.getString("address"), /**/
						rs.getString("content"), /**/
						rs.getDate("eating_date"), /**/
						rs.getString("photo"), /**/
						rs.getDate("regdate"), /**/
						rs.getInt("rating"), /**/
						rs.getString("foodName"), /**/
						rs.getString("foodType"));
				list.add(review);
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

	@Override
	public int insert(Review review) {
		int result = 0;
		System.out.println(review);
		String sql = "INSERT INTO REVIEW(MEMBER_ID, ADDRESS, CONTENT, EATING_DATE, PHOTO, RATING, FOODNAME, FOODTYPE) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, review.getMember_id());
			st.setString(2, review.getAddress());
			st.setString(3, review.getContent());
			st.setDate(4, review.getEating_date());
			st.setString(5, review.getPhoto());
			st.setInt(6, review.getRating());
			st.setString(7, review.getFoodName());
			st.setString(8, review.getFoodType());
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

	@Override
	public int update(Review review) {
		int result = 0;
		String sql = "UPDATE REVIEW SET ADDRESS=?, CONTENT=?, EATING_DATE=?, PHOTO=?, RATING=? WHERE ID=?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@112.223.37.243.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, review.getAddress());
			st.setString(2, review.getContent());
			st.setDate(3, review.getEating_date());
			st.setString(4, review.getPhoto());
			st.setInt(5, review.getRating());
			st.setInt(6, review.getId());

			result = st.executeUpdate();
			rs = st.executeQuery();
			rs.getDate("regdate"); /**/

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
	public int delete(int id) {
		int result = 0;
		String sql = "DELETE REVIEW WHERE ID=?";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);

			st.setInt(1, id);
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
	public Review get(int review_id) {
		Review review = null;
		String sql = "SELECT * FROM REVIEW WHERE ID=?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@112.223.37.243.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, review_id);

			rs = st.executeQuery();

			if (rs.next()) {
				review = new Review(/**/
						rs.getInt("id"), /**/
						rs.getInt("member_id"), /**/
						rs.getString("address"), /**/
						rs.getString("content"), /**/
						rs.getDate("eating_date"), /**/
						rs.getString("photo"), /**/
						rs.getDate("regdate"), /**/
						rs.getInt("rating"), /**/
						rs.getString("foodName"), /**/
						rs.getString("foodType"));
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
		return review;
	}

}
