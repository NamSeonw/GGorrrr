package com.ggorrrr.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggorrrr.web.controller.entity.Member;
import com.ggorrrr.web.controller.service.MemberService;
import com.ggorrrr.web.controller.service.implement.ImplementMemberService;

@WebServlet("/login/findID")
public class FindIdController extends HttpServlet {

	private MemberService memberService;

	public FindIdController() {
		memberService = new ImplementMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login/findID.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = "";
		String email = "";

		String name_ = request.getParameter("name");
		String email_ = request.getParameter("email");

		if (!name_.equals("") && name_ != null)
			name = name_;
		if (!email_.equals("") && email_ != null)
			email = email_;

		boolean isValid = false;

		isValid = memberService.isFindId(name, email); // 입력받은 name 에 대한 이메일 정보가 맞는지 확인

		if (isValid) {
			request.getRequestDispatcher("/WEB-INF/view/login/findID.jsp").forward(request, response);
			request.setAttribute("findId", memberService.findId(name));
			request.getRequestDispatcher("/WEB-INF/view/login/findID.jsp").forward(request, response);
		} else
			response.sendRedirect("findID?error=1");
	}
}
