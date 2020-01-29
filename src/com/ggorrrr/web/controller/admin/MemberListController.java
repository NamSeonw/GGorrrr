package com.ggorrrr.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggorrrr.web.controller.service.MemberService;
import com.ggorrrr.web.controller.service.implement.ImplementMemberService;
import com.sun.org.apache.bcel.internal.classfile.InnerClass;

@WebServlet("/admin/member/memberlist")
public class MemberListController extends HttpServlet {
	private MemberService memberService;

	public MemberListController() {
		memberService = new ImplementMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", memberService.getMemberList());
		request.getRequestDispatcher("/WEB-INF/view/admin/member/listDelete.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		memberService.delete(id);
		response.sendRedirect("/admin/member/memberlist");
	}
}
