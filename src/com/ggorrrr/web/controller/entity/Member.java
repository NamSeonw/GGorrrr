package com.ggorrrr.web.controller.entity;

public class Member {
	
	private int id;
	private String user_id;
	private String pwd;
	private String name;
	private String birthday;
	private String email;
	private String gender;
	private String phone;
	private String location_agree;
	private String nickname;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	//전체
	public Member(int id, String user_id, String pwd, String name, String birthday, String email, String gender,
			String phone, String location_agree, String nickname) {
		this.id = id;
		this.user_id = user_id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.location_agree = location_agree;
		this.nickname = nickname;
	}
	
	
	public Member(int id, String pwd, String location_agree, String nickname) {
		this.id = id;
		this.pwd=pwd;
		this.location_agree = location_agree;
		this.nickname = nickname;
	}

	
	//위치동의 없는것
	public Member(int id, String user_id, String pwd, String name, String birthday, String email, String gender,
			String phone, String nickname) {
		this.id = id;
		this.user_id = user_id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation_agree() {
		return location_agree;
	}

	public void setLocation_agree(String location_agree) {
		this.location_agree = location_agree;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", user_id=" + user_id + ", pwd=" + pwd + ", name=" + name + ", birthday="
				+ birthday + ", email=" + email + ", gender=" + gender + ", phone=" + phone + ", location_agree="
				+ location_agree + ", nickname=" + nickname + "]";
	}
	
	

}
