package com.ggorrrr.web.controller.member;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ggorrrr.web.controller.entity.BookmarkMenu;
import com.ggorrrr.web.controller.entity.Food;
import com.ggorrrr.web.controller.entity.Member;
import com.ggorrrr.web.controller.service.BookmarkService;
import com.ggorrrr.web.controller.service.FoodService;
import com.ggorrrr.web.controller.service.implement.ImplementBookmarkService;
import com.ggorrrr.web.controller.service.implement.ImplementFoodService;

@WebServlet("/bookmarkReg")
public class BookmarkRegController extends HttpServlet {

	BookmarkService bookmarkService;
	FoodService foodService;
	public BookmarkRegController() {
		bookmarkService = new ImplementBookmarkService();
		foodService = new ImplementFoodService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String category = (String) session.getAttribute("category");
		category = URLEncoder.encode(category, "UTF-8");
		resp.sendRedirect("/menu/list?category=" + category);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionuser");
		String category = request.getParameter("category");
		if (member == null) {
			category = URLEncoder.encode(category, "UTF-8");
			response.sendRedirect("/menu/list?category=" + category);
			return;
		}

		int foodId = Integer.parseInt(request.getParameter("food-id"));

		int page = 1;
		String field = "ingridients";
		String query = ""; // 기본값

		String page_ = null; // 페이징
		String field_ = null; // 검색 소 카테고리
		String query_ = null; // 검색어

		page_ = request.getParameter("p");
		field_ = request.getParameter("f");
		query_ = request.getParameter("q");

		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		if (field_ != null && !field_.equals(""))
			field = field_;

		if (query_ != null && !query_.equals(""))
			query = query_;

		List<BookmarkMenu> myBookList = bookmarkService.getList(member.getId());
		boolean done = false;
		for (BookmarkMenu b : myBookList) {
			if (b.getId() == foodId) {
				done = true;
				break;
			}
		}

		if (done) {
			bookmarkService.delete(member.getId(), foodId);
		} else {
			bookmarkService.insert(new BookmarkMenu(member.getId(), foodId));
		}

		List<Food> foodList = foodService.getFoodList(category, page, field, query);
		List<BookmarkMenu> bookList = bookmarkService.getList(member.getId());
		boolean[] check = new boolean[foodList.size()];
		int index = 0;
		for (Food f : foodList) {

			boolean search = false;
			for (BookmarkMenu b : bookList) {
				if (b.getId() == f.getId()) {
					search = true;
				}
			}

			if (search)
				check[index] = true;
			else
				check[index] = false;
			index++;
		}
		request.setAttribute("check", check);
		category = URLEncoder.encode(category, "UTF-8");

		response.sendRedirect("/menu/list?category=" + category);
	}
}
