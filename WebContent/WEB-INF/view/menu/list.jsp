<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page - (page-1)%5}" />
<c:set var="lastNum"
	value="${fn:substringBefore(Math.ceil(listCount / 10) , '.')}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/menuList.css" type="text/css" rel="stylesheet" />
<script src="/js/sadariFix.js"></script>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<!------------------------- ㅡheader끝 main시작 ------------------------------------>
	<main id="main">
	<div class="socategori">
		<section id="socategori">
			<h2>
				<img id="main-logo" src="./../images/ggorrrrlogo.png" width="50"
					height="50"> <span>${param.category }</span>
			</h2>
			<form>
				<div class="search">
					<input type="hidden" name="category" value=${param.category }>
					<input type="hidden" name="p" value="${param.p}"> <select
						name="f">
						<option value="korname">이름</option>
						<option value="ingridients">주재료</option>
					</select>
					<div class=searchhap>
						<input type="text" placeholder="search.. " name="q"
							value="${param.q}"> <input type="submit" value="" />
					</div>
				</div>
			</form>
			<!-- 여기 까지 검색 폼이야~ -->
		</section>
	</div>

	<div id="menulist">
		<ul>

			<c:forEach var="food" items="${list}" varStatus="status"> 


				<li><form method="post" action="/bookmarkReg">
						<a href="detail?id=${food.id }">
						 <img src="/upload/${food.photo }"><br> 
						 <span>${food.korname }</span>
						 </a>
							
							<input name="member-id" type="hidden" value="${sessionScope.sessionuser.id}"> 
							<input name="food-id" type="hidden" value="${food.id }"> 
							<input name="category" type="hidden" value="${param.category }">
							<c:if test="${sessionScope.sessionuser == null }">
								<input id="star" type="submit" value="">
							</c:if> 
							<c:if test="${sessionScope.sessionuser!=null && !check[status.index] }">
								<input id="star" type="submit" value="">
							</c:if> 
							<c:if test="${sessionScope.sessionuser!=null && check[status.index] }">
								<input id="star2" type="submit" name="bookmark" value="">
							</c:if>
						
							
							
					</form> <br> <span>${food.price } 원</span> </li>
			</c:forEach>
		</ul>
	</div>

	<div class="margin-top align-center pager">
		<div id="pre">
			<c:if test="${startNum-5 < 1 }">
				<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
			</c:if>
			<c:if test="${startNum-5 >= 1 }">
				<a class="btn btn-prev"
					href="list?category=${param.category }&p=${startNum-5}&f=${param.f}&q=${param.q}">이전</a>
			</c:if>
		</div>
		<ul>
			<c:forEach var="i" begin="0" end="4">
				<c:if test="${startNum+i <= lastNum }">
					<li><c:if test="${ startNum+i == page }">
							<c:set var="currentStyle" value="orange bold" />
						</c:if> <c:if test="${ startNum+i != page}">
							<c:set var="currentStyle" value="" />
						</c:if> <a class="-text- ${currentStyle}"
						href="list?category=${param.category }&p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i }</a>
					</li>
				</c:if>
			</c:forEach>
		</ul>
		<div id="next">
			<c:if test="${startNum+5 > lastNum }">
				<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
			</c:if>
			<c:if test="${startNum+5 <= lastNum }">
				<a class="btn btn-next"
					href="list?category=${param.category }&p=${startNum+5}&f=${param.f}&q=${param.q}">다음</a>
			</c:if>
		</div>
	</div>
	</main>
	<!------------------------- ㅡmain끝 ------------------------------------>
	<jsp:include page="../inc/sadari.jsp" />
	<!-- ================================footer시작=============================== -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
