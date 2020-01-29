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

@WebServlet("/member/changePassword")
public class ChangePasswordController extends HttpServlet {

	private MemberService memberService;

	public ChangePasswordController() {
		memberService = new ImplementMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionuser");

		request.setAttribute("member", member);
		request.setAttribute("pwd", member.getPwd());
		request.getRequestDispatcher("/WEB-INF/view/member/changePassword.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member = null;
		int id = Integer.parseInt(request.getParameter("id"));
		String newpwd = request.getParameter("newPwd2");
		String nickname = request.getParameter("nickname");
		String agreement = request.getParameter("agreement");
		String save = request.getParameter("save");

		if (save.equals("저장")) {
			member = new Member(id, newpwd, agreement, nickname);
			memberService.update(member);
			response.sendRedirect("/member/mypage?id=" + id);
		}

	}
}
