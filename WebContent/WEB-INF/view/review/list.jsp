<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${empty p ? 1 : p}" />
<c:set var="startNum" value="${page - (page-1)%3}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹지?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/reviewList.css" type="text/css" rel="stylesheet" />
<script src="/js/sadariFix.js"></script>
<script src="/js/riviewList.js"></script>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<!-- =========================================================================== -->
	<main>
	<div id="sori-title">
		<h1>
			<img src="/images/sori.png" width="265" height="70">
		</h1>
	</div>

	<form id="search" action="" method="post">
		<input type="text" name="q" placeholder="search..." /> <input
			onclick="submit();"
			style="cursor: pointer; background: url('../images/search3.png') no-repeat center;"
			type="button" name="cmd" />
	</form>
	<br>

	<nav id="review">
		<h1 class="d-none">고객의 소리 리스트</h1>
		<div class="topvisual">
			<a href="reg">글쓰기</a>
		</div>

		<div id="order">
			<a href="list?order=regdate">최신순</a> <a href="list?order=rating">평점순</a><br>
		</div>

		<div id="ppp">
			<div id="middlebox">
				<div id="content_main">
					<c:forEach var="n" items="${list}">
						<form action="../member/review/listDelete" method="post">
							<div id="review-title">
								<span id="span">ㆍ ${n.address}</span>
								<span>${n.regdate}</span>
							</div>
							<br>
							<div id="review-content">
								<span>${n.content}</span> <span><img alt="" src="/upload/${n.photo}" width="150" height="150"><br></span>
							</div>
						</form>
					</c:forEach>
				</div>
				<div class="aaa"></div>
				<div id="more-more">
					<a href=""><input type="hidden" name="p" value="${page}">더보기</a>
				</div>
			</div>
		</div>
	</nav>
	</main>
	<jsp:include page="../inc/sadari.jsp" />
	<!-- ================================footer시작=============================== -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
