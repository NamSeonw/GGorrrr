package com.ggorrrr.web.controller.dao;

import java.util.List;

import com.ggorrrr.web.controller.entity.Food;

public interface FoodDao {
	
	List<Food> getFoodList(); // 기본 리스트
	
	List<Food> getFoodList(String category); // 카테고리만 출력

	List<Food> getFoodThemaList(String thema, int page, String field, String query, String category); // 카테고리만 출력

	List<Food> getFoodList(String category, int page);

	List<Food> getFoodList(String category, int page, String field, String query);

	List<Food> getFoodList(String category, int page, String field, String query, String soCategory);

	List<Food> getFoodList(String category, String query);

	Food get(int id); // 음식 디테일

	int insert(Food food); // 음식 넣기

	int update(Food food); // 음식 수정

	int delete(int id); // 삭제

	int getListCount(String category, String field, String query); // 전체 수 확인 후 페이지 번호 매기기

	List<Food> getFoodListAll();

	Food getFoodRownum(int rownum);
}
