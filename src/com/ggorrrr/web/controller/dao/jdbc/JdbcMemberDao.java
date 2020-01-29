package com.ggorrrr.web.controller.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ggorrrr.web.controller.dao.MemberDao;
import com.ggorrrr.web.controller.entity.Member;

public class JdbcMemberDao implements MemberDao {

	// 전체회원관리-전체회원리스트
	@Override
	public List<Member> getMemberList() {
		return getMemberList("user_id", "");
	}

	// 전체회원관리-검색
	// 필드 -> id, user_id
	@Override
	public List<Member> getMemberList(String field, String query) {
		Member member = null;
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member where " + field + " like ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");

			rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String user_name = rs.getString("user_id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String location_agree = rs.getString("location_agree");
				String nickname = rs.getString("nickname");

				member = new Member(id, user_name, pwd, name, birthday, email, gender, phone, location_agree, nickname);
				list.add(member);
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
		return list;
	}

	// 회원가입
	@Override
	public int insert(Member member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER (USER_ID,PWD,NAME,BIRTHDAY,EMAIL,GENDER,PHONE,LOCATION_AGREE,NICKNAME) VALUES(?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, member.getUser_id());
			st.setString(2, member.getPwd());
			st.setString(3, member.getName());
			st.setString(4, member.getBirthday());
			st.setString(5, member.getEmail());
			st.setString(6, member.getGender());
			st.setString(7, member.getPhone());
			st.setString(8, member.getLocation_agree());
			st.setString(9, member.getNickname());

			result = st.executeUpdate(); // st실행 //실행되면 1반환

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

	// 비번변경,닉네임변경,위치정보변경
	@Override
	public int update(Member member) {
		int result = 0;
		String sql = "update member set pwd=?, location_agree=?, nickname=?" + "where id=?";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, member.getPwd());
			st.setString(2, member.getLocation_agree());
			st.setString(3, member.getNickname());
			st.setInt(4, member.getId());

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

	// 회원탈퇴
	@Override
	public int delete(int id) {
		int result = 0;
		String sql = "delete member where id=?";
		Connection con = null;
		PreparedStatement st = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
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

	// my그먹,로그인인증,비번찾기
	@Override
	public Member get(int id) {
		Member member = null;
		String sql = "select * from member where id= ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setInt(1, id);

			rs = st.executeQuery();

			while (rs.next()) {

				String user_name = rs.getString("user_id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String location_agree = rs.getString("location_agree");
				String nickname = rs.getString("nickname");

				member = new Member(id, user_name, pwd, name, birthday, email, gender, phone, location_agree, nickname);
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
		return member;
	}

	@Override
	public Member get(String id) {
		Member member = null;
		String sql = "select * from member where user_id = ?";
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
				int id_ = rs.getInt("id");
				String user_name = id;
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String location_agree = rs.getString("location_agree");
				String nickname = rs.getString("nickname");

				member = new Member(id_, user_name, pwd, name, birthday, email, gender, phone, location_agree,
						nickname);
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
		return member;
	}

	@Override
	public Member findId(String name) {
		Member member = null;
		String sql = "select * from member where name = ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "GGORRRR", "0112");
			st = con.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();

			while (rs.next()) {
				int id_ = rs.getInt("id");
				String user_name = rs.getString("user_id");
				String pwd = rs.getString("pwd");
				String name_ = rs.getString("name");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String location_agree = rs.getString("location_agree");
				String nickname = rs.getString("nickname");

				member = new Member(id_, user_name, pwd, name_, birthday, email, gender, phone, location_agree,
						nickname);
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
		return member;
	}
}
