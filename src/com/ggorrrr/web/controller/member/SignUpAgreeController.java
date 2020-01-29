package com.ggorrrr.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ggorrrr.web.controller.service.MemberService;
import com.ggorrrr.web.controller.service.implement.ImplementMemberService;

@WebServlet("/signUp/signUpAgree")
public class SignUpAgreeController extends HttpServlet {

	MemberService memberService;

	public SignUpAgreeController() {
		memberService = new ImplementMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/signUp/signUpAgree.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String check1 = "0";
		String check2 = "0";

		String check1_ = request.getParameter("termsService");
		String check2_ = request.getParameter("termsLocation");

		if (check1_ != null)
			check1 = check1_;
		if (check2_ != null)
			check2 = check2_;

		String yesButton = request.getParameter("yes");
		String noButton = request.getParameter("no");
		
		response.setContentType("text/html; charset=UTF-8");

		if (yesButton.equals("확인")) {
			if (check1.equals("0")) {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('개인정보동의는 필수사항입니다.'); location.href='/signUp/signUpAgree';</script>");
				return;
			}
			response.sendRedirect("/signUp/signUp?location_chk=" + check2);
		}

		else if (noButton.equals("취소")) {
			response.sendRedirect("/index");
		}

	};

}
