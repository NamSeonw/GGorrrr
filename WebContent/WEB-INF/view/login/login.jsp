<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/loginLogin.css" type="text/css" rel="stylesheet" />

</head>
<body>
	<!-- =================HEADER================ -->
	<jsp:include page="../inc/header.jsp" />
	<!-- =================MAIN================ -->
	<div class="headerBmain"></div>

	<main>
	<div class="middlebox">
		<section>
			<h1>로그인</h1>
			<div class="img">
				<img src="../images/login.png">
			</div>

			<div id="smallbox">
				<form action="" method="post">
					<div>ID</div>
					<input type="text" name="id">
					<div>PASSWORD</div>
					<input type="password" name="pwd"> <input type="submit"
						name="login" value="로그인">
					<c:if test="${not empty param.error }">
						<input type="hidden" name="error" value="${param.error }">
						<div
							style="color: red; font-weight: bold; font-size: 15px; text-align: center;">아이디
							또는 비밀번호가 올바르지 않습니다.</div>
					</c:if>
					<input type="hidden" name="return-url" value="${param.returnUrl}" />
				</form>

				<h1>로그인 도움 메뉴</h1>
				<ul>
					<li><a href="/signUp/signUpAgree">회원가입</a></li>
					<li><a href="/login/findID">아이디 찾기</a></li>
					<li><a href="/login/findPwd">비밀번호 찾기</a></li>
				</ul>
			</div>
		</section>
	</div>
	</main>


	<div class="mainBfooter"></div>
	<!--=================FOOTER================ -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
