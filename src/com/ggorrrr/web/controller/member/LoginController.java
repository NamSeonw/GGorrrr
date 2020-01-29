package com.ggorrrr.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ggorrrr.web.controller.entity.Admin;
import com.ggorrrr.web.controller.service.AdminService;
import com.ggorrrr.web.controller.service.MemberService;
import com.ggorrrr.web.controller.service.implement.ImplementAdminService;
import com.ggorrrr.web.controller.service.implement.ImplementMemberService;

@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	private AdminService adminService;

	public LoginController() {
		memberService = new ImplementMemberService();
		adminService = new ImplementAdminService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnUrl = request.getParameter("returnUrl");

		request.setAttribute("return-url", returnUrl);
		request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = "";
		String pwd = "";

		String id_ = request.getParameter("id");
		String pwd_ = request.getParameter("pwd");
		String returnUrl = request.getParameter("return-url");

		if (id_ != null && !id_.equals(""))
			id = id_;
		if (pwd_ != null && !pwd_.equals(""))
			pwd = pwd_;

		boolean isValidMember = memberService.isValidMember(id, pwd);
		boolean isValidAdmin = adminService.isValidAdmin(id, pwd);

		if (!isValidMember) {
			response.sendRedirect("/login/login?error=1&returnUrl="+returnUrl);
		} else {
			if (isValidAdmin) {
				request.getSession().setAttribute("username", id);
				request.getSession().setAttribute("sessionadmin", adminService.get(id));
				response.sendRedirect("/admin/page");
				return;
			} else {
				request.getSession().setAttribute("username", id);
				request.getSession().setAttribute("sessionuser", memberService.get(id));
			}
			if (!returnUrl.equals(""))
				response.sendRedirect(returnUrl);
			else
				response.sendRedirect("/index");
		}

	}

}
