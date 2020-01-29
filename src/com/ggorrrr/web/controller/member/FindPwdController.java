package com.ggorrrr.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ggorrrr.web.controller.entity.Member;
import com.ggorrrr.web.controller.service.MemberService;
import com.ggorrrr.web.controller.service.implement.ImplementMemberService;

@WebServlet("/login/findPwd")
public class FindPwdController extends HttpServlet {
	MemberService memberService;

	public FindPwdController() {
		memberService = new ImplementMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login/findPwd.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = "";
		String email = "";
		// 메일로 비밀번호 부르기.
		String id_ = request.getParameter("user-id");
		String email_ = request.getParameter("user-email");

		boolean isValid = false;

		if (id_ != null && !id_.equals(""))
			id = id_;
		if (email_ != null && !email_.equals(""))
			email = email_;

		Member m = memberService.get(id);

		if (m != null)
			isValid = (m.getUser_id().equals(id)) && (m.getEmail().equals(email));

		if (isValid) {
			request.setAttribute("messege", "메일이 발송 되었습니다.");
			request.removeAttribute("errorMsg");
		} else {
			request.setAttribute("errorMsg", "입력하신 아이디와 이메일을 확인해주세요");
		}

		request.getRequestDispatcher("/WEB-INF/view/login/findPwd.jsp").forward(request, response);
	}
}
