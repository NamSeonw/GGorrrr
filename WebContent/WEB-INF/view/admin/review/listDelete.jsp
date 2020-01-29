<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/admin_reviewManage.css" type="text/css"
	rel="stylesheet" />
<script src="/js/riviewList.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp" />
	<!------------------------- ㅡheader끝 main시작 ------------------------------------>
	<main id="main">
	<div id="title">
		<h2 id="h2">
			<img id="img" src="../../images/ggorrrrlogo.png" width="50"
				height="50"> 고객이 쓴 소리 리스트
		</h2>
		<hr id="hr">
	</div>

	<div id="div">
		<form id="search" action="">
			<input type="text" name="q" placeholder="search..." /> <input
				onclick="submit();" style="cursor: pointer;" type="button"
				name="검색버튼" />
		</form>
		<br>
		<section class="reviewList">
			<div>
				<div id="order">
					<a href="list?order=regdate">최신순</a> <a href="list?order=rating">평점순</a><br>
				</div>

				<div id="ppp">
					<div id="middlebox">
						<div id="content_main">
							<c:forEach var="n" items="${list}" begin="0" end="3">
								<form action="listDelete" method="post">
									<div id="review-title">
										<input type="hidden" name="del_id" value="${n.id}">
										<span id="span">ㆍ ${n.address} <span id="regdate">${n.regdate}</span>
											<input id="deleteBtn" type="submit" name="del" value="삭제"
											width="50px" height="20px"></span>
									</div>
									<br>
									<div id="review-content">
										<!-- id를 번호로 부여해서 style을 건들이면 되겟다. -->
										<span>${n.content}</span><span id="content_expand"
											style="cursor: pointer;"> </span> <span id="content_fold"
											style="display: none; cursor: pointer;"> </span><br> <span><img
											id="photo" alt="" src="/upload/${n.photo}" width="150"
											height="150"><br></span>
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
			</div>
		</div>
	</section>
	<a href="../page">뒤로</a> </main>
	<!-- ======================footer========================================== -->
	<jsp:include page="../../inc/footer.jsp" />
</body>
</html>
