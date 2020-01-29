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

@WebServlet("/member/mypage")
public class MypageController extends HttpServlet {

	private MemberService memberService;

	public MypageController() {
		memberService = new ImplementMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionuser");

		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 변경을 눌렀을때 닉네임과 위치정보가 변경됨
		// 멤버서비스에 업데이트를 가져와야함
		Member member = (Member) session.getAttribute("sessionuser");
		int id = member.getId();

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "이동":
			response.sendRedirect("/member/changePassword?id=" + id);
			break;
		case "변경":
			String pwd = request.getParameter("pwd");
			String nickname = request.getParameter("닉네임수정");
			String agreement = request.getParameter("agreement");
			String agree = "";
			if (agreement.equals("동의"))
				agree = "1";
			else
				agree = "0";

			Member newmember = new Member(id, pwd, agree, nickname);
			memberService.update(newmember);
			session.setAttribute("sessionuser", newmember);
			response.sendRedirect("/mypage?id=" + id); // 페이지요청
			break;
		}
	}
}
