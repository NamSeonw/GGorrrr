<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/reviewIndex.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<!------------------------- ㅡheader끝 main시작 ------------------------------------>
	<main>
	<div>
		<section>
			<h1 class="d-none">관리자페이지</h1>
		</section>
	</div>
	<div id="middlebox">
		<section>
			<h1 class="d-none">관리자</h1>
			<div class="profile">
				<img src="/images/profile.png" width="50" height="50">
				<div>
					<h1>${sessionScope.sessionadmin.name }</h1>
				</div>
			</div>
			<br>
			<div id="content">
				<div>
					<a href="changePwd">ㆍ비밀번호 변경</a>
				</div>
				<div>
					<a href="./member/memberlist">ㆍ회원 관리</a>
				</div>
				<div>
					<a href="./review/listDelete">ㆍ고객의소리 관리</a>
				</div>
				<div>
					<a href="./menu/adminlist"> ㆍ메뉴 관리</a>
				</div>
			</div>
		</section>
	</div>
	</main>
	<!------------------------- ㅡmain끝 ------------------------------------>
	<!-- ================================footer시작=============================== -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
