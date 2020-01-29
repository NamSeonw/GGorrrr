package com.ggorrrr.web.controller.service;

import java.util.List;

import com.ggorrrr.web.controller.entity.Review;

public interface ReviewService {
	List<Review> getList();

	List<Review> getList(int page, String field, String query);

	List<Review> getListByOrder(int page, String order, String field, String query);

	List<Review> getListById(int member_id, int page, String field, String query);

	int insert(Review review);

	int update(Review review);

	int delete(int id);

	Review get(int review_id);
}
