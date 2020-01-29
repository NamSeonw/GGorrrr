package com.ggorrrr.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggorrrr.web.controller.entity.Member;
import com.ggorrrr.web.controller.entity.Review;
import com.ggorrrr.web.controller.service.ReviewService;
import com.ggorrrr.web.controller.service.implement.ImplementReviewService;
import com.google.gson.Gson;

@WebServlet("/member/review/listDelete-json")
public class MyReviewListDeleteJSONController extends HttpServlet {

	private ReviewService reviewService;

	public MyReviewListDeleteJSONController() {
		reviewService = new ImplementReviewService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionuser");

		String order = "regdate";
		String field = "address";
		String query = "";
		int page = 1;

		String order_ = request.getParameter("order");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("page");

		if (field_ != null && !field_.equals(""))
			field = field_;

		if (query_ != null && !query_.equals(""))
			query = query_;

		if (order_ != null && !order_.equals(""))
			order = order_;

		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		List<Review> aList = reviewService.getListById(member.getId(), page, field, query);

		Gson gson = new Gson();
		String json = gson.toJson(aList);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
