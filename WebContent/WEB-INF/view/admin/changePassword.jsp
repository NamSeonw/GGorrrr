<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="../css/adminChangePassword.css" rel="stylesheet" type="text/css">
<script src="/js/adminPwd.js"></script>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<!------------------------- ㅡheader끝 main시작 ------------------------------------>
	<main id="main">
		<div id="div">
			<h2 id="h2"><img id="img" src="/images/ggorrrrlogo.png" width="50" height="50"> 관리자 페이지</h2>
		</div>

	<div id="middlebox">
		<form action="" method="post">
			<section>
				<h1>관리자 비밀번호 변경페이지</h1>
				<div id="nicknameDiv">
					<h3>
						<img id="img" src="/images/profile.png" width="50" height="50">
						${sessionScope.sessionadmin.name}
					</h3>
				</div>
				<dl id="change-pwd">
					<dt>현재비밀번호</dt>
					<dd>
						<input class="now-pwd" type="password" name="nowPwd"> <input
							class="now-pwd" type="hidden" name="nowPwdCheck"
							value="${sessionScope.sessionadmin.pwd }">
					</dd>
				</dl>
				<label class="now-pwd-check-text"></label>
				<dl id="new-pwd">
					<dt>새 비밀번호:</dt>
					<dd>
						<input class="new-pwd" type="password" name="newPwd">
					</dd>

					<dt>새 비밀번호 확인:</dt>
					<dd>
						<input class="new-pwd" type="password" name="newPwdCheck">
					</dd>
				</dl>
				<label class="new-pwd-check-text"></label>
				<div id="pageSection">
					<a href="page"><input type="button" name="commit" value="취소"></a> <input type="submit" name="commit" value="저장">
				</div>
			</section>
		</form>
	</div>
	</main>
	<!------------------------- ㅡmain끝 ------------------------------------>
	<!-- ================================footer시작=============================== -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
