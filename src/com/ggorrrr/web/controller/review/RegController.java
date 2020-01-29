package com.ggorrrr.web.controller.review;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ggorrrr.web.controller.entity.Member;
import com.ggorrrr.web.controller.entity.Review;
import com.ggorrrr.web.controller.service.ReviewService;
import com.ggorrrr.web.controller.service.implement.ImplementReviewService;

@WebServlet("/review/reg")
@MultipartConfig(
	      fileSizeThreshold = 1024*1024,
	      maxFileSize = 1024*1024*100,
	      maxRequestSize = 1024*1024*100*5
	)
public class RegController extends HttpServlet {

	private ReviewService reviewService;

	public RegController() {
		reviewService = new ImplementReviewService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/review/reg.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionuser");
		if (member == null)
			response.sendRedirect("list");
		int id = -9;
		int member_id = member.getId();
		String foodType = "";
		String foodName = "";
		Date eating_date = null;
		String address = "";
		String content = "";
		String cmd = "";
		int rating = Integer.parseInt(request.getParameter("star"));

		System.out.println(rating);

		Collection<Part> parts = request.getParts();

		String fileNames = "";

		for (Part p : parts) {
			if (!p.getName().equals("file"))
				continue;

			Part filePart = p;
			String fileName = filePart.getSubmittedFileName(); // 전송한 파일명
			fileNames += fileName + ",";

			ServletContext application = request.getServletContext();
			String urlPath = "/upload";
			String realPath = application.getRealPath(urlPath);

			File file = new File(realPath);
			if (!file.exists())
				file.mkdir();

			InputStream fis = filePart.getInputStream(); // 전송한 파일의 스트림
			OutputStream fos = new FileOutputStream(realPath + File.separator + fileName);

			byte[] buf = new byte[1024];
			int size = 0;
			while ((size = fis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
		}

		fileNames = fileNames.substring(0, fileNames.length() - 1);

		String foodType_ = request.getParameter("food_type");
		if (foodType_ != null && !foodType_.equals(""))
			foodType = foodType_;

		String foodName_ = request.getParameter("food_name");
		if (foodName_ != null && !foodName_.equals(""))
			foodName = foodName_;
		String eating_date_ = request.getParameter("eating_date");
		if (eating_date_ != null && !eating_date_.equals(""))
			eating_date = Date.valueOf(eating_date_);

		String address_ = request.getParameter("address");
		if (address_ != null && !address_.equals(""))
			address = address_;
		String content_ = request.getParameter("content");
		if (content_ != null && !content_.equals(""))
			content = content_;

		String cmd_ = request.getParameter("commit");
		if (cmd_ != null && !cmd_.equals(""))
			cmd = cmd_;

		switch (cmd) {
		case "확인":
			int result = reviewService.insert(
					new Review(id, member_id, address, content, eating_date, fileNames, rating, foodName, foodType));

			if (result == 0)
				response.sendRedirect("/error?code=2");
			else
				response.sendRedirect("list");
			break;
		}
	}
}
