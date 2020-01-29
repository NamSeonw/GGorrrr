<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/foodReg.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../../inc/header.jsp" />
	<!-- =========================================================================== -->
	<main>
	<section>
		<h1 class="d-none">관리자 메뉴</h1>
		<section id="page-top">
			<img src="../../images/profile.png">
			<h1>관리자</h1>
		</section>

		<section id="middle-box">
			<h1>메뉴 등록</h1>
			<form action="update" method="post" enctype="multipart/form-data">
				<!-- 목록 펼치기. -->
				<div id="content-first">
					<select name="category">
						<option value="1">한식</option>
						<option value="2">양식</option>
						<option value="3">중식</option>
						<option value="4">일식</option>
						<option value="5">분식</option>
						<option>테마별</option>
						<option value="6">기타</option>
						<option>채식</option>
					</select> <select name="vegetarian">
						<option value="0">채식아님</option>
						<option value="1">채식임</option>
						<input type="hidden" name="food-id" value="${f.id }">
					</select><span>음식 이름</span> <input id="foodtxt" type="text" name="food_name"
						value="${f.korname }">
				</div>
				<div>
					<span id="food-price">가격</span> <input type="text" name="price"
						value="${f.price }"><span id="won">원</span>
				</div>
				<div>
					<span id="food-ingridients">주 재료</span> <input type="text"
						name="main_ingridients" value="${f.ingridients }">
				</div>
				<div>
					<span id="food-eat">음식 설명</span> <input type="text"
						name="how_to_eat" value="${f.explain }">
				</div>
				<div>
					<span id="food-thema">테마</span><input type="text" name="thema"
						value="${f.thema }">
				</div>
				<div>
					<span id="food-recipe">레시피</span> <input type="text" name="recipe"
						value="${f.recipe }">
				</div>
				<div>
					<span id="food-img">첨부 사진</span>
					<!--  -->
					<input type="file" name="files" value="내PC" multiple="multiple">
				</div>
				<!--  -->
				<div id="content-last">
					<input type="submit" name="commit" value="확인">
					<!--  -->
					<a href="adminlist">취소</a>
				</div>
			</form>
		</section>
	</section>
	</main>
	<hr>
	<!-- =========================================================================== -->
	<jsp:include page="../../inc/footer.jsp" />
</body>
</html>
