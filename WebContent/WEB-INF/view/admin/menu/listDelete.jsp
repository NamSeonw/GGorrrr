<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/foodListDelete.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- ====header========================= -->
	<jsp:include page="../../inc/header.jsp" />
	<!-- ======main===================== -->
	<main>
	<h1 class="d-none">관리자 메뉴</h1>
	<section id="page-top">
		<img src="../../images/profile.png">
		<h1>관리자</h1>
	</section>

	<hr>
	<div id="middle-box">
		<section id="page-middle">
			<img src="../../images/menuManage.png">
			<form action="adminlist">
				<select id="select-category" name="category">
					<option value="한식">한식</option>
					<option value="양식">양식</option>
					<option value="중식">중식</option>
					<option value="일식">일식</option>
					<option value="분식">분식</option>
					<option value="테마별">테마별</option>
					<option value="기타">기타</option>
					<option value="채식">채식</option>
				</select> <label>음식이름</label> <input type="text" name="menuName"> <input
					type="submit" name="search" value="검색">
			</form>
		</section>
		<hr style="margin-left:-245px;">
	
		<form id="page-middle2" action="adminlist" method="post">
			<div id="tableDiv">
			<table border="1">
				<thead>
					<tr>
						<td class="table-category1">카테고리</td>
						<td class="table-name1">이름</td>
						<td class="table-delete1">삭제</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="list">
						<tr>
							<td class="table-category">${list.category }</td>
							<td class="table-name"><a href="update?id=${list.id}">${list.korname }</a></td>
							<td class="table-delete"><input type="checkbox" name="del"
								value="${list.id }"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			<div class="button">
				<input type="submit" value="일괄삭제" name="cmd"> <a href="reg">메뉴등록</a>
			</div>
		</form>

	</div>
	</main>
	<!-- ======footer===================== -->
	<jsp:include page="../../inc/footer.jsp" />
</body>
</html>
