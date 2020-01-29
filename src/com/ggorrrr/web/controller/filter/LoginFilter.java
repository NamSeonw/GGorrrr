package com.ggorrrr.web.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggorrrr.web.controller.dao.MemberDao;
import com.ggorrrr.web.controller.dao.jdbc.JdbcMemberDao;

@WebFilter("/*") // 패턴 맵핑
public class LoginFilter implements Filter {

	private static final String[] noAuthenticUris = { /**/
			"/upload/*", /**/
			"/index", /**/
			"/images/*", /**/
			"/css/*", /**/
			"/js/*", /**/
			"/signUp/*", /**/
			"/login/*", /**/
			"/member/logout",
			"/menu/*", /**/
			"/review/list", /**/
			"/admin/review/list-json",
			"/review/list-json" };

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;

		String requestUri = request.getRequestURI();
		HttpSession session = request.getSession();
		// default : 인증 안댐 -> true.)
		boolean isAuthenticated = session.getAttribute("username") == null;
		// default: 필요함
		boolean isAuthRequiredUri = true;
		// 요청된 페이지가 인증이 필요한지 판별.
		for (String uri : noAuthenticUris) {
			// 내가 설정한 인증이 필요한 페이지 중 *을 포함하는 페이지일 경우
			if (uri.endsWith("*")) {
				// *을 짤라낸 경로만 저장
				String path = uri.substring(0, uri.length() - 2);
				// 사용자가 요청한 페이지의 앞부분을 path와 비교하여
				// 일치하면 인증이 필요 없는 페이지
				if (requestUri.startsWith(path)) {
					isAuthRequiredUri = false;
					break;
				}
			} else {
				// 내가 설정한 인증이 필요한 페이지 중 *을 포함하지 않는 페이지일 경우
				// 전체 경로를 비교.
				if (requestUri.equals(uri)) {
					isAuthRequiredUri = false;
					break;
				}
			}
		}

		// 권한이 필요한 페이지이고, 인증을 하지 않았다면,
		if (isAuthRequiredUri && isAuthenticated) {
			// 인증을 하고 오세요
			HttpServletResponse response = (HttpServletResponse) resp;
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.sendRedirect("/login/login?returnUrl=.." + requestUri);
		} else {
			chain.doFilter(req, resp);
		}
	}
}
