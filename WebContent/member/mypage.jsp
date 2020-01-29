<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet">
<style>

#sadari {
	float: right;
	position: fixed;
	bottom: 50px;
	right: 50px;
}

h1 {
	width: 0px;
	height: 0px;
	font-size: 0px;
	line-height: 0px;
	position: absolute;
	overflow: hidden;
}

main>#img{
	text-align: center;
	margin-top: 30px;
}

main>div:nth-child(2) {
	width: 400px;
	margin-left: auto;
	margin-right: auto;
	min-height: 300px;
	border: 2px solid black;
	margin-bottom: 20px;
}
section div{
	border-bottom: 2px solid black;
	text-align: center;
}
section dt,dd{
	display: inline-block;
	margin-top: 20px;
}
section dl,dt,dd{
	font-size:14px;
	margin-left: 30px;
}

</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/inc/header.jsp" />
	<!------------------------- ㅡheader끝 main시작 ------------------------------------>
	<main>
		<div id="img">
			<h1>My그먹</h1>
			<img src="/images/my그먹.png" width="170" height="50">
		</div>
		<div>
			<form action="/member/mypage" method="post">
				<section>
					<!--<h1>마이페이지사용자프로필</h1>-->
					<div>
						<img src="../images/profile.png" width="50" height="50">
						<h2>${member.nickname}</h2>
					</div>
					<input type="hidden" name="id" value="${member.id}">
					<dl>
						<dt>아이디:</dt>
						<dd>${member.user_id}</dd> 
						<br>
						<dt>비밀번호:</dt>
						<dd>
							<input type="password" name="pwd" value="${member.pwd}"
								readonly="readonly"><input type="submit" name="cmd"
								value="이동">
						</dd>
						<br>
						<dt>닉네임:</dt>
						<dd>
							<input type="text" name="닉네임수정" value="${member.nickname}">
							<input type="submit" name="cmd" value="변경">
						</dd>
						<br>
						<dt>생년월일:</dt>
						<dd>${member.birthday}</dd>
						<br>
						<dt>전화번호:</dt>
						<dd>${member.phone}</dd>
						<br>
						<dt>위치정보:</dt>
						<dd>
							<input type="hidden" name="위치정보동의"
								value="${member.location_agree}">
							<c:if test="${member.location_agree!=1}">
					동의<input type="radio" name="agreement" value="동의">
							</c:if>
							<c:if test="${member.location_agree==1}">
				동의<input type="radio" name="agreement" value="동의" checked="checked">
							</c:if>

							<c:if test="${member.location_agree!=0}">
					비동의<input type="radio" name="agreement" value="비동의">
							</c:if>
							<c:if test="${member.location_agree==0}">
				비동의<input type="radio" name="agreement" value="비동의"
									checked="checked">
							</c:if>
							<input type="submit" name="cmd" value="변경">
						</dd>
						<br>
						<dt>
							<a href="mybookmarklist?id=${member.id}">My메뉴관리</a>
						</dt>
						<dt>
							<a href="">내가 쓴 소리 관리</a>
						</dt>
					</dl>
					<br><br>
				</section>
			</form>
		</div>
	</main>

	<!------------------------- ㅡmain끝 ------------------------------------>
	<aside id="sadari">
		<h1>사다리게임</h1>
		<nav>
			<h1>사다리이미지</h1>
			<a href=""><img src="../images/sadari.png" width="100"
				height="100"></a>
		</nav>
	</aside>
	<!-- ================================footer시작=============================== -->
	<jsp:include page="/WEB-INF/view/inc/footer.jsp" />
</body>
</html>
