package com.ggorrrr.web.controller.entity;

public class BookmarkMenu extends Food {
	private int member_id;

	public BookmarkMenu() {
	}

	// insert, delete
	public BookmarkMenu(int member_id, int food_id) {
		this.member_id = member_id;
		this.setId(food_id);
	}

	// selectList
	public BookmarkMenu(int food_id, String photo, String korname, int member_id) {
		super(korname, photo);
		this.setId(food_id);
		this.member_id = member_id;
	}

	// selectDetail
	public BookmarkMenu(int food_id, String korname, String engname, String photo, String ingridients, String explain,
			int managerId, boolean vegetarian, String thema, String recipe, String category, int price, int member_id) {
		super(food_id, korname, engname, photo, ingridients, explain, managerId, vegetarian, thema, recipe, category,
				price);
		this.member_id = member_id;
		this.setId(food_id);
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "BookmarkMenu [member_id=" + member_id + ", getMember_id()=" + getMember_id() + ", getRecipe()="
				+ getRecipe() + ", getId()=" + getId() + ", getKorname()=" + getKorname() + ", getEngname()="
				+ getEngname() + ", getPhoto()=" + getPhoto() + ", getIngridients()=" + getIngridients()
				+ ", getExplain()=" + getExplain() + ", getManagerId()=" + getManagerId() + ", isVegetarian()="
				+ isVegetarian() + ", getThema()=" + getThema() + ", getCategory()=" + getCategory() + ", getPrice()="
				+ getPrice() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
