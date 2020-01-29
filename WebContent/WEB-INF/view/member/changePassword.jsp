<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/changePassword.css" rel="stylesheet" type="text/css">
<script src="/js/pwd.js"></script>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<!------------------------- ㅡheader끝 main시작 ------------------------------------>
	<main id="main">
	<div>
		<section>
		<h2 id="h2"><img id="img" src="/images/ggorrrrlogo.png" width="50" height="50"> MY그먹</h2>
		</section>
	</div>

	<form action="" method="post">
		<section id="middlebox">
			<h1>마이페이지비밀번호변경프로필</h1>
			<div id="nicknameDiv">
			 <input type="hidden" name="id" value="${member.id}">
			 <input type="hidden" name="agreement" value="${member.location_agree}">
			<input type="hidden" name="nickname" value="${member.nickname}">
				 <h3><img id="img" src="/images/profile.png" width="35" height="35"> ${member.nickname}</h3>
			</div>
			
			<div id="inMiddlebox">
			<dl id="change-pwd">
				<dt>현재비밀번호</dt>
				<dd>
					<input class="now-pwd" type="hidden" name="pwd" value="${pwd}">
				</dd>
				<dd>
					<input class="now-pwd2" type="password" name="nowPwd" value="">
					<input style="width:30px; height: 24px;" class="now-check-button" type="button" name="nowPwdbutton"
						value="확인">
				</dd>
				<!--<dd><input class="now-check-text" type="text" name="nowPwdText" value=""></dd>-->
				<dd><label class="now-check-text"></label></dd>

			<!--<dd>${nows}</dd>-->
			
				<dt>새 비밀번호</dt>
				<dd>
					<input class="new-pwd" type="password" name="newPwd" value="">
				</dd>

				<dt>새 비밀번호 확인</dt>
				<dd>
					<input class="new-pwd2" type="password" name="newPwd2" value="">
					<input style="width:30px; height: 24px;" class="new-check-button" type="button" name="newPwdsubmit"
						value="확인">
				</dd>
				<!--<dd><input class="new-check-text" type="text" name="newPwdText" value=""></dd>-->
				<dd><label class="new-check-text"></label></dd>
			</dl>
			</div>

			<div id="button">
				<a href="mypage"><input style="width:110px; height: 50px;" type="button" name="취소"
					value="취소"></a> <a href="./categori.html"><input style="width:110px; height: 50px;"
					type="submit" name="save" value="저장"></a>
			</div>
		</section>
	</form>
	</main>
	<!------------------------- ㅡmain끝 ------------------------------------>
	<jsp:include page="../inc/sadari.jsp" />
	<!-- ================================footer시작=============================== -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
