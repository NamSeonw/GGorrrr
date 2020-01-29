<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/reviewReg.css" rel="stylesheet" type="text/css">
<script src="/js/reviewReg.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp" />
	<!-- =========================================================================== -->
	<main id="main">
	<div id="div">
		<h2 id="h2">
			<img id="img" src="/images/ggorrrrlogo.png" width="50" height="50">
			고객의 소리 수정
		</h2>
	</div>
	<div id="middlebox">
		<form action="edit" method="post" enctype="multipart/form-data">
			<div id="middlebox-inbox">
				<div class="div">
					<h4>
						카테고리 선택 <select
							style="width: 100px; height: 25px; margin-left: 49px;"
							id="select" name="food_type">
							<option value="한식">한식</option>
							<option value="증식">중식</option>
							<option value="일식">일식</option>
							<option value="분식">분식</option>
							<option value="테마별">테마별</option>
							<option value="기타">기타</option>
							<option value="채식">채식</option>
						</select>
					</h4>
				</div>
				<div>
					<h4>
						음식 이름 <input type="text" name="food_name"
							value="${edit.foodName }">
					</h4>
				</div>
				<div>
					<h4>
						먹은 날짜 <input type="date" name="eating_date"
							value="${edit.eating_date }">
					</h4>
				</div>
				<div>
					<h4>
						먹은 장소 <input type="text" name="address" value="${edit.address }">
					</h4>
				</div>
				<div>
					<h4 id="h4">상세 내용</h4>
					<textarea name="content">${edit.content }</textarea>
				</div>
				<div>
					<h4>
						첨부 사진 <input type="file" name="file"  value="${edit.photo }">
					</h4>
				</div>
				<div>
					<h4>
						별점
						<div id="star-rating">
							<input type="hidden" name="star" value="0"> <img
								name="star1" src="/images/binstar2.png"> <img name="star2"
								src="/images/binstar2.png"> <img name="star3"
								src="/images/binstar2.png"> <img name="star4"
								src="/images/binstar2.png"> <img name="star5"
								src="/images/binstar2.png">
						</div>
					</h4>
				</div>
				<div id="button">
					<a href="listDelete"><input id="input" type="button"
						name="commit" value="취소"></a> <input type="submit"
						name="commit" value="확인">
				</div>
			</div>
		</form>
	</div>
	</main>
	<hr>
	<!-- =========================================================================== -->
	<jsp:include page="../../inc/footer.jsp" />
</body>
</html>
