<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="/css/menuDetail.css" type="text/css" rel="stylesheet" />
<script src="/js/sadariFix.js"></script>
</head>
<style>
#map {
	margin-left: 121px;
}
</style>
<body>
	<!-- ==header=========================== -->
	<jsp:include page="../inc/header.jsp" />
	<!-- ===main====================== -->
	<main>
	<div id="middleBox">
		<nav>
			<h1>음식 디테일</h1>
			<ul id="nav">
				<li><a href="#img">사진</a></li>
				<li><a href="#explain">설명</a></li>
				<li><a href="#map">식당위치</a></li>
				<li><a href="#recipe">레시피</a></li>
			</ul>
		</nav>

		<div id="img">
			<h1>음식사진</h1>
			<img id="food-img" src="/upload/${f.photo }">
			<p>(상기 사진은 실물과 다를 수 있습니다.)</p>
		</div>

		<section id="explain">
			<h1>음식설명</h1>
			<dl>
				<dt class="food-name">이름</dt>
				<dd>${f.korname }</dd>
				<br>
				<dt class="food-ingridients">주 재료</dt>
				<dd>${f.ingridients }</dd>
				<br>
				<br>
				<dt class="food-explain">-------------음식
					설명--------------------------------------------------------------------</dt>
				<dd class="food-explain-dd">${f.explain }</dd>
				<br>
			</dl>
		</section><br><br><br><br><br><br><br><br><br>
		<div id="map" style="width: 800px; height: 300px;"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=006573cc443e96a34d94d55754797329"></script>
		<script>
			var container = document.getElementById('map');
			var options = {
				center : new kakao.maps.LatLng(33.450701, 126.570667),
				level : 3
			};

			var map = new kakao.maps.Map(container, options);
		</script>
	</div>
	</main>

	<!-- =====aside======================= -->
	<jsp:include page="../inc/sadari.jsp" />
	<!-- ======footer===================== -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
