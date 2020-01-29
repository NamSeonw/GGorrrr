package com.ggorrrr.web.controller.member;

/*
 * 로그인 상태에서 자신의 리뷰 리스트를 보고 수정/삭제 할 수 있는 컨트롤러
 */
import java.io.IOException;
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

@WebServlet("/member/review/listDelete")
public class MyReviewListDeleteController extends HttpServlet {

	private ReviewService reviewService;

	public MyReviewListDeleteController() {
		reviewService = new ImplementReviewService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionuser");
		if (member != null)
			request.setAttribute("list", reviewService.getListById(member.getId(), 1, "address", ""));
		request.getRequestDispatcher("/WEB-INF/view/member/review/listDelete.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");

		switch (cmd) {
		case "del":
			int delId = Integer.parseInt(request.getParameter("del-id"));
			int result = reviewService.delete(delId);
			response.sendRedirect("listDelete");
			break;
		case "search":
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
			request.getRequestDispatcher("/WEB-INF/view/member/review/listDelete.jsp").forward(request, response);
			break;
		default:
			response.sendRedirect("listDelete");
			break;
		}
	}
}
