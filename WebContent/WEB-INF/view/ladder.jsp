<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/sadari_main.css" type="text/css" rel="stylesheet" />
<link href="/css/sadariGame.css" type="text/css" rel="stylesheet" />
<script src="/js/sadari.js"></script>
</head>
<body>
	<jsp:include page="./inc/header.jsp" />
	<!-- =========================================================================== -->
	<main id="main">
	<div>
		<section id="sadari-main">
			<h1>음식 사다리 타기 게임 페이지</h1>
			<div id="bookmark">
				<section>
					<h1 class="d-none">즐겨찾기한 목록</h1>
					<ul>
						<c:forEach items="${list }" var="bm">
							<li><a href="./menu/detail?id=${bm.id }"><img
									alt="${bm.korname }" src="/upload/${bm.photo }"></a></li>
						</c:forEach>
					</ul>
				</section>
			</div>
			<div id="sadari-game">
				<section>
					<h1 class="d-none">사다리 게임</h1>
					<div
						style="width: 720px; height: 500px; border: 1px solid #CCCCCC; position: relative;">
						<div id="div_body" style="width: 720px; height: 500px;">
							<div id="step1">
								<div>
									<label>항목의 개수를 정해주세요.</label>
								</div>
								<div class="count-ctrl">
									<div>
										<img class="minus" src="/images/minus.png" alt="minus"
											width="50px" style="cursor: pointer;">
									</div>
									<div style="display: inline-block;">
										<label class="sadari-count">2</label>
									</div>
									<div>
										<img class="plus" src="/images/plus.png" alt="plus"
											width="50px" style="cursor: pointer;">
									</div>
								</div>
								<div>
									<label>사다리 만들기</label>
								</div>
							</div>
						</div>
						<div id="step2" style="display: none;"></div>
					</div>
				</section>
			</div>
		</section>
	</div>
	</main>
	<!-- ============================================================================== -->
	<jsp:include page="./inc/footer.jsp" />
</body>
</html>
