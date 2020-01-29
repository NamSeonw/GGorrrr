<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet">
<link href="/css/signUp.css" type="text/css" rel="stylesheet">
</head>
<body bgcolor="#f5f6f7">
	<!-- ====header====================== -->
	<header id="header">
		<h1>회원가입페이지</h1>
		<nav>
			<a href="../index"><h3><img id="img" width="50px" height="50px"
				src="../images/ggorrrrlogo.png"> 그래서뭐먹어?</h3></a>
		</nav>
	</header>

	<!-- ====main====================== -->
	<main>
	<div id=middlebox>
		<section>
			<h1>입력</h1>
			<form action="signUp" method="post">
			<div>
			<input type="hidden" name="location_chk" value="${location_chk}">
			</div>
				<div>
					<label>아이디</label><br><input class="id" type="text"
						name="signupId"><br>
				</div>
				<div>
					<label>비밀번호</label><br> <input class="pw" type="password"
						name="signupPw">
				</div>
				<div>
					<label>비밀번호확인</label><br> <input class="pwcf" type="password"
						name="signupPwCf">
				</div>
				<div>
					<label>이름</label><br> <input class="name" type="text"
						name="signupname">
				</div>
				<div>
					<label>닉네임</label><br> <input class="name" type="text"
						name="nickname">
				</div>
				<div id="genAndphon">
					<label>성별</label><br> <select class="gender" name="gender">
						<option value="남">남</option>
						<option value="여">여</option>
					</select>
				</div>
				<div id="select-birthday">
					<label>생년월일</label><br> <select class="year" name="year">
						<%
							for (int i = 0; i < 70; i++) {
						%>
						<%int year=(i + 1950);%>
						<option value="<%=year%>"><%=year%></option>
						<%
							}
						%><!-- <!--<!sdasdhfkjsfhkajsdfhkajsdhfkjsdhfjkhfsadjkksafhksajdfsdfhjkshfkjsadhjkhsk -->

					</select> <select class="month" name="month">
						<%
							for (int i = 0; i < 12; i++) {
						%>
						<%int month=(i + 1);%>
						<option value="<%=month%>"><%=month%></option>
						<%
							}
						%>
					</select> <select class="day" name="day">
						<%
							for (int i = 0; i < 31; i++) {
						%>
						<%int day=(i + 1);%>
						<option value="<%=day%>"><%=(i + 1)%></option>
						<%
							}
						%>
					</select>
				</div>
				<div id="genAndphon">
					<label>전화번호</label> <br> <input size="10"
						type="text" name="phone">
						<span>연결자(-)를 사용하여 입력하세요</span>
				</div>
				<div id="select-email">
					<label>이메일</label> <br> <label><input class="email" size="10"
						type="text" name="email">@ <select name="emailadress">
						<option value="naver.com">naver.com
						<option value="daum.net">daum.net
						<option value="gmail.com">gmail.com
					</select></label>
				</div>
				<div class="singup">
					<input type="submit" name="signUp" value="가입하기">
				</div>
			</form>
		</section>
	</div>

	</main>

	<!-- ======footer===================== -->
	<jsp:include page="../inc/footer.jsp"/>
</body>
</html>
