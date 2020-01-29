package com.ggorrrr.web.controller.service;

import java.util.List;

import com.ggorrrr.web.controller.entity.Food;

public interface FoodService {

	List<Food> getFoodList();
	
	List<Food> getFoodList(String category);
	
	List<Food> getFoodThemaList(String thema,int page, String field, String query, String category);

	List<Food> getFoodList(String category, int page);
	
	List<Food> getFoodList(String category, String query);

	List<Food> getFoodList(String category, int page, String field, String query);
	
	List<Food> getFoodList(String category, int page, String field, String query, String soCategory);

	Food get(int id);

	int insert(Food food);

	int update(Food food);

	int delete(int id);

	int deletes(int[] ids);

	int getFoodCount(String category, String field, String query);

	List<Food> getFoodListAll();

	Food getFoodRownum(int rownum);
}
