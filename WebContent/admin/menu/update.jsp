<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
</head>
<body>
	<header>
		<h1>그래서 뭐먹어?</h1>
		<nav>
			<h1>회원메뉴</h1>
			<ul>
				<li><a href="">home</a></li>
				<li><a href="">로그인</a></li>
				<li><a href="">회원가입</a></li>
				<li><a href="">마이페이지</a></li>
				<li><a href="">고객의 소리</a></li>
			</ul>
		</nav>

		<section>
			<h1>검색창</h1>
			<form>
				<input type="text" name="검색창" value="검색어"> <input
					type="submit" value="검색">
			</form>
		</section>

		<nav>
			<h1>인기검색어</h1>
			<ul>
				<li>1.&nbsp;&nbsp;<a href="">엽기떡볶이</a>
					<ul>
						<li>2.&nbsp;&nbsp;<a href="">갈비탕</a></li>
						<li>3.&nbsp;&nbsp;<a href="">김치찌개</a></li>
					</ul>
				</li>
			</ul>
		</nav>
		<hr>
		<nav>
			<h1>메뉴</h1>
			<ul>
				<li>한식</li>
				<li>양식</li>
				<li>중식</li>
				<li>일식</li>
				<li>분식</li>
				<li>테마별</li>
				<li>기타</li>
				<li>채식</li>
			</ul>
		</nav>
	</header>
	<hr>
	<!-- =========================================================================== -->
	<main>
	<section>
		<img src="./images/profile.png">
		<h1>관리자</h1>
		<hr>
		<section>
			<h1>메뉴 등록</h1>
			<form action="reg" method="post" enctype="multipart/form-data">
				<table>
					<tbody>
						<tr>
							<th>카테고리</th>
							<td>
								<!-- 목록 펼치기. --> <select name="category">
									<option value="1">한식</option>
									<option value="2">양식</option>
									<option value="3">중식</option>
									<option value="4">일식</option>
									<option value="5">분식</option>
									<option>테마별</option>
									<option value="6">기타</option>
									<option>채식</option>
							</select> <select name="vegetarian">
									<option value = "0">채식아님</option>
									<option value = "1">채식임</option>
							</select> 
							</td>
							<th>음식 이름</th>
							<td><input type="text" name="food_name" value="음식이름"></td>
						</tr>
						<tr>
							<th>주 재료</th>
							<td><input type="text" name="main_ingredents" value="주재료"></td>
						</tr>
						<tr>
							<th>먹는 방법</th>
							<td><input type="text" name="how_to_eat" value="먹는 방법"></td>
						</tr>
						<tr>
							<th>테마</th>
							<td><input type="text" name="thema" value="테마"></td>
						</tr>
						<tr>
							<th>레시피</th>
							<td><input type="text" name="recipe" value="레시피"></td>
						</tr>
						<tr>
							<th>첨부 사진</th>
							<td colspan="3"><input type="file" name="files" value="내PC"
								multiple="multiple"></td>

						</tr>
					</tbody>
				</table>
				<div>
					<a href="">취소</a>&nbsp;
					<!--  -->
					<input type="submit" name="commit" value="확인">
				</div>
			</form>
		</section>
	</section>
	</main>
	<hr>
	<!-- =========================================================================== -->
	<footer>
		<section>
			<h1>회사소개</h1>
		</section>

		<section>
			<h1>이용약관</h1>
		</section>
	</footer>
</body>
</html>
