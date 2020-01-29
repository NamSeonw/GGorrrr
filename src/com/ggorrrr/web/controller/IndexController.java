package com.ggorrrr.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ggorrrr.web.controller.entity.Food;
import com.ggorrrr.web.controller.service.FoodService;
import com.ggorrrr.web.controller.service.implement.ImplementFoodService;

@WebServlet("/index")
public class IndexController extends HttpServlet {

	private FoodService foodService;

	public IndexController() {
		foodService = new ImplementFoodService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Food> list = foodService.getFoodListAll();

		List<Food> best = new ArrayList<Food>();
		int checkDup[] = new int[5];
		for (int i = 0; i < checkDup.length; i++) {
			int rand = (int) (Math.random() * (list.size() + 1));
			boolean check = true;
			for (int j = 0; j < i; j++) {
				if (checkDup[j] == rand) {
					check = false;
					i--;
					break;
				}
			}

			if (check) {
				best.add(foodService.getFoodRownum(rand));
				checkDup[i] = rand;
			}
		}
		
		request.setAttribute("best", best);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}
}
