package com.ggorrrr.web.controller.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ggorrrr.web.controller.entity.Review;
import com.ggorrrr.web.controller.service.ReviewService;
import com.ggorrrr.web.controller.service.implement.ImplementReviewService;

@WebServlet("/review/list")
public class ListController extends HttpServlet {
	private ReviewService reviewService;

	public ListController() {
		reviewService = new ImplementReviewService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Review> aList = reviewService.getListByOrder(1, "regdate", "address", "");

		request.setAttribute("list", aList);
		request.getRequestDispatcher("/WEB-INF/view/review/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String order = "regdate";
		String field = "address";
		String query = "";
		int page = 1;

		String order_ = request.getParameter("order");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");

		if (field_ != null && !field_.equals(""))
			field = field_;

		if (query_ != null && !query_.equals(""))
			query = query_;

		if (order_ != null && !order_.equals(""))
			order = order_;

		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		List<Review> aList = reviewService.getListByOrder(page, order, field, query);

		request.setAttribute("list", aList);
		request.getRequestDispatcher("/WEB-INF/view/review/list.jsp").forward(request, response);
	}
}
