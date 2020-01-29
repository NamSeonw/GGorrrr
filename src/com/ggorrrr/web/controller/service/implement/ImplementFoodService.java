package com.ggorrrr.web.controller.service.implement;

import java.util.List;

import com.ggorrrr.web.controller.dao.FoodDao;
import com.ggorrrr.web.controller.dao.jdbc.JdbcFoodDao;
import com.ggorrrr.web.controller.entity.Food;
import com.ggorrrr.web.controller.service.FoodService;

public class ImplementFoodService implements FoodService {

	FoodDao foodDao;

	public ImplementFoodService() {
		foodDao = new JdbcFoodDao();
	}

	@Override
	public List<Food> getFoodList() {
		return foodDao.getFoodList();
	}

	@Override
	public List<Food> getFoodList(String category) {
		return foodDao.getFoodList(category);
	}

	@Override
	public List<Food> getFoodList(String category, int page) {
		return foodDao.getFoodList(category, page);
	}

	@Override
	public List<Food> getFoodList(String category, String query) {
		return foodDao.getFoodList(category, query);
	}

	@Override
	public List<Food> getFoodList(String category, int page, String field, String query) {
		return foodDao.getFoodList(category, page, field, query);
	}

	@Override
	public Food get(int id) {
		return foodDao.get(id);
	}

	@Override
	public int insert(Food food) {
		return foodDao.insert(food);
	}

	@Override
	public int update(Food food) {
		return foodDao.update(food);
	}

	@Override
	public int delete(int id) {
		return foodDao.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		int i = 0;
		for (; i < ids.length; i++)
			foodDao.delete(ids[i]);
		return i;
	}

	@Override
	public int getFoodCount(String category, String field, String query) {
		return foodDao.getListCount(category, field, query);
	}

	@Override
	public List<Food> getFoodListAll() {
		
		return foodDao.getFoodListAll();
	}

	@Override
	public Food getFoodRownum(int rownum) {
		
		return foodDao.getFoodRownum(rownum);
	}

	@Override
	public List<Food> getFoodThemaList(String thema, int page, String field, String query, String category) {
		return foodDao.getFoodThemaList(thema, page, field, query, category);
	}

	@Override
	public List<Food> getFoodList(String category, int page, String field, String query, String soCategory) {
		return foodDao.getFoodList(category, page, field, query, soCategory);
	}
}
