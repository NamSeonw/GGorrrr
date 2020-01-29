package com.ggorrrr.web.controller.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggorrrr.web.controller.entity.Member;
import com.ggorrrr.web.controller.entity.Review;
import com.ggorrrr.web.controller.service.ReviewService;
import com.ggorrrr.web.controller.service.implement.ImplementReviewService;

/*
 * 로그인 상태에서 자신의 리뷰를 수정하는 컨트롤러
 * 자신의 리뷰리스트에서 수정버튼을 누르면 실행
 */
@WebServlet("/member/review/edit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024 * 100
		* 5)
public class MyReviewEditController extends HttpServlet {

	private ReviewService reviewService;

	public MyReviewEditController() {
		reviewService = new ImplementReviewService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// review 테이블의 식별자인 id를 선언
		int review_id = 0;

		// 페이지에서 review_id를 불러와 Int타입으로 저장
		String review_id_ = request.getParameter("review_id");
		if (review_id_ != null && !review_id_.equals(""))
			review_id = Integer.parseInt(review_id_);

		// 식별자를 매개변수로 주어 Review객체를 불러와 "edit"으로 설정
		request.setAttribute("edit", reviewService.get(review_id));
		request.getRequestDispatcher("/WEB-INF/view/member/review/edit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionuser");
		// 수정된 리뷰를 가져오기 위한 리뷰필드 선언
		int id = 0;
		String foodType = "";
		String foodName = "";
		Date eating_date = null;
		String address = "";
		String content = "";
		String photo = "";

		// 리뷰 기본키인 id를 받아와서 수정해야할 리뷰 id저장
		String review_id = request.getParameter("review");

		if (review_id != null && !review_id.equals(""))
			id = Integer.parseInt(review_id);

		// 수정해야할 항목들을 모두 받아옴
		String foodType_ = request.getParameter("food_type");
		if (foodType_ != null && !foodType_.equals(""))
			foodType = foodType_;

		String foodName_ = request.getParameter("food_name");
		if (foodName_ != null && !foodName_.equals(""))
			foodName = foodName_;

		String eating_date_ = request.getParameter("eating_date");
		if (eating_date_ != null && !eating_date_.equals(""))
			eating_date = Date.valueOf(eating_date_);

		String address_ = request.getParameter("address");
		if (address_ != null && !address_.equals(""))
			address = address_;

		String content_ = request.getParameter("content");
		if (content_ != null && !content_.equals(""))
			content = content_;

		String photo_ = request.getParameter("photo");
		if (photo_ != null && !photo_.equals(""))
			photo = photo_;

		// id를 이용해 리뷰객체를 저장
		Review review = new Review(id, member.getId(), address, content, eating_date, photo, foodName, foodType);

		// id와 멤버id는 수정이 안되므로 나머지 값들만 불러온 값으로 업데이트
		int result = reviewService.update(review);

		// 실패시 에러페이지
		if (result == 0)
			response.sendRedirect("/error?code=2");

		// 성공시 리스트페이지
		else
		response.sendRedirect("listDelete");

	}
}
