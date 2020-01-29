package com.ggorrrr.web.controller.entity;

import java.sql.Date;

public class Review {
	private int id;
	private int member_id;
	private String address;
	private String content;
	private Date eating_date;
	private String photo;
	private Date regdate;
	private int rating;
	private String foodName;
	private String foodType;

	public Review() {

	}

	public Review(int id, int member_id, String address, String content, Date eating_date, String photo, Date regdate,
			int rating, String foodName, String foodType) {
		this.id = id;
		this.member_id = member_id;
		this.address = address;
		this.content = content;
		this.eating_date = eating_date;
		this.photo = photo;
		this.regdate = regdate;
		this.rating = rating;
		this.foodName = foodName;
		this.foodType = foodType;
	}

	public Review(int id, int member_id, String address, String content, Date eating_date, String photo,
			int rating, String foodName, String foodType) {
		this.id = id;
		this.member_id = member_id;
		this.address = address;
		this.content = content;
		this.eating_date = eating_date;
		this.photo = photo;
		this.rating = rating;
		this.foodName = foodName;
		this.foodType = foodType;
	}

	public Review(int id, int member_id, String address, String content, Date eating_date, String photo,
			String foodName, String foodType) {
		this.id = id;
		this.member_id = member_id;
		this.address = address;
		this.content = content;
		this.eating_date = eating_date;
		this.photo = photo;
		this.foodName = foodName;
		this.foodType = foodType;
	}

	public int getMember_id() {
		return member_id;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEating_date() {
		return eating_date;
	}

	public void setEating_date(Date eating_date) {
		this.eating_date = eating_date;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFoodName() {
		return foodName;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", member_id=" + member_id + ", address=" + address + ", content=" + content
				+ ", eating_date=" + eating_date + ", photo=" + photo + ", rating=" + rating + ", regdate=" + regdate
				+ ", foodName=" + foodName + "]";
	}
}
