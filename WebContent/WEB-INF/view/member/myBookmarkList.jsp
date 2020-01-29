<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<script>
	window.addEventListener("load", function() {
		var section = document.querySelector("#content");
		var delBtn = section.querySelector(".bm-del");

		section.onclick = function(e) {
			if (e.target.className != "bm-btn")
				return;
			var event = new MouseEvent("click", {
				view : window,
				bubbles : false,
				cancelable : true
			});
			delBtn.dispatchEvent(event);
		};
	});
</script>
<style>
main {
	min-width: 1580px;
}

#bmlist .bm-del {
	visiblity: none;
}
#bmlist .bm-del:hover{
	cursor: pointer;
}

#bmlist .bm-btn {
	cursor: pointer;
}

#profile {
	display: flex;
	margin-left: auto;
	margin-right: auto;
	width: 400px;
	position: relative;
}

#profile img {
	position: absolute;
	left: 100px;
}

#profile section h1 {
	font-size: 27px;
	position: absolute;
	left: 161px;
	top: 4px;
}

#middlebox {
	margin-top: 80px;
	position: relative;
}

#middlebox div>img:first-child {
	width: 25px;
	height: 25px;
	position: absolute;
	left: 10px;
	top: 25px;
}

#bmlist>div>h1 {
	display: flex;
	position: absolute;
	left: 44px;
	top: 20px;
	font-size: 24px;
	font-weight: bold;
}

#middle-top {
	height: 100px;
	width: 1040px;
	position: relative;
	margin-left: auto;
	margin-right: auto;
}

#content {
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
	display: flex;
	min-height: 400px;
	flex-wrap: wrap;
}

#content ul {
	margin-left: 126px;
	display: flex;
	flex-wrap: wrap;
}

#content ul li {
	margin-right: 20px;
	text-align: center;
	font-size: 20px;
}

#font-size1 {
	font-size: 15px;
	margin-top: 3px;
	width: inherit;
}

#content form {
	width: 240px;
	height: 209px;
}

</style>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<!------------------------- ㅡheader끝 main시작 ------------------------------------>
	<main id="main">

	<div id="profile">
		<img src="/images/ggorrrrlogo.png" width="50" height="50">
		<section>
			<h1 id="my-title">MY즐겨찾기관리</h1>
		</section>
	</div>

	<div id="middlebox">
		<nav id="bmlist">
			<div id="middle-top">
				<img src="/images/onimages.png">
				<h1>MY 메뉴 관리</h1>
			</div>
			<div id="content">
				<ul>
					<c:forEach var="bm" items="${bmlist }">
						<form method="post">
							<li>
								<!--  --> <img src="/upload/${bm.photo }" width="150"
								height="150"><br>
								<div
									style="display: flex; width: 200px; margin-left: auto; margin-right: auto;">
									<div id="font-size1">
										<a
											style="display: inline-block; vertical-align: middle; margin-left: auto; margin-right: auto;"
											href="../menu/detail?id=${bm.id }">${bm.korname }</a> <!-- <img
											style="vertical-align: middle;" width="20px" height="25px"
											src="/images/onimages.png" class="bm-btn"> -->
											<input style="border: 0px; outline: none; background: url(/images/onimages1.png) no-repeat; vertical-align: middle; width: 20px; height: 20px" class="bm-del" type="submit" name="del"  value="">
									</div>
								</div> <input type="hidden" name="food-id" value="${bm.id }">
								<input type="hidden" name="id" value="${bm.member_id }">
							</li>
						</form>
					</c:forEach>
				</ul>
			</div>
		</nav>
	</div>
	</main>
	<jsp:include page="../inc/sadari.jsp" />
	<!--  ---------------------------------------------------------------------------------------------- -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
