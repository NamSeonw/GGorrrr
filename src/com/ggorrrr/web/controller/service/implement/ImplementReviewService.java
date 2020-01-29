package com.ggorrrr.web.controller.service.implement;

import java.util.List;

import com.ggorrrr.web.controller.dao.ReviewDao;
import com.ggorrrr.web.controller.dao.jdbc.JdbcReviewDao;
import com.ggorrrr.web.controller.entity.Review;
import com.ggorrrr.web.controller.service.ReviewService;

public class ImplementReviewService implements ReviewService {

	private ReviewDao reviewDao;

	public ImplementReviewService() {
		reviewDao = new JdbcReviewDao();
	}

	@Override
	public List<Review> getList() {
		return getList(1, "content", "");
	}

	@Override
	public List<Review> getList(int page, String field, String query) {
		return reviewDao.getList(page, field, query);
	}

	@Override
	public List<Review> getListByOrder(int page, String order, String field, String query) {
		return reviewDao.getListByOrder(page, order, field, query);
	}

	@Override
	public List<Review> getListById(int member_id, int page, String field, String query) {
		return reviewDao.getListById(member_id, page, field, query);
	}

	@Override
	public int insert(Review review) {
		return reviewDao.insert(review);
	}

	@Override
	public int update(Review review) {
		return reviewDao.update(review);
	}

	@Override
	public int delete(int id) {
		return reviewDao.delete(id);
	}

	@Override
	public Review get(int review_id) {
		return reviewDao.get(review_id);
	}

}
