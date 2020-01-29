package com.ggorrrr.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggorrrr.web.controller.service.ReviewService;
import com.ggorrrr.web.controller.service.implement.ImplementReviewService;

@WebServlet("/admin/review/listDelete")
public class ReivewListController extends HttpServlet {
	private ReviewService reviewService;

	public ReivewListController() {
		reviewService = new ImplementReviewService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", reviewService.getList());
		request.getRequestDispatcher("/WEB-INF/view/admin/review/listDelete.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		String id_ = request.getParameter("del_id");

		if (id_ != null && !id_.equals(""))
			id = Integer.parseInt(id_);

		reviewService.delete(id);
		response.sendRedirect("listDelete");
	}

}
