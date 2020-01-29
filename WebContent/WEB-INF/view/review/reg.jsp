<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그래서 뭐먹어?</title>
<link href="/css/default.css" type="text/css" rel="stylesheet" />
<link href="../css/reviewReg.css" rel="stylesheet" type="text/css">
<script src="/js/reviewReg.js"></script>
<!-- <style>
.star-rating { width:205px; }
.star-rating,.star-rating span { display:inline-block; height:39px; overflow:hidden; background:url(../images/star.png)no-repeat; }
.star-rating span{ background-position:left bottom; line-height:0; vertical-align:top; } -->
<!-- </style> -->

</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<!-- =========================================================================== -->
	<main id="main">
	<div id="div">
		<h2 id="h2">
			<img id="img" src="/images/ggorrrrlogo.png" width="50" height="50">
			고객의 소리 등록
		</h2>
	</div>
	<div id="middlebox">
		<form action="/review/reg" method="post" enctype="multipart/form-data">
			<div id="middlebox-inbox">
				<div class="div">
					<h4>
						카테고리 선택 <select
							style="width: 100px; height: 25px; margin-left: 49px;"
							id="select" name="food_type">
							<option value="한식">한식</option>
							<option value="증식">중식</option>
							<option value="일식">일식</option>
							<option value="분식">분식</option>
							<option value="테마별">테마별</option>
							<option value="기타">기타</option>
							<option value="채식">채식</option>
						</select>
					</h4>
				</div>
				<div>
					<h4>
						음식 이름 <input type="text" name="food_name" value="">
					</h4>
				</div>
				<div> 
					<h4>
						먹은 날짜 <input type="date" name="eating_date" value="">
					</h4>
				</div>
				<div>
					<h4>
						먹은 장소 <input type="text" name="address" value="">
					</h4>
				</div>
				<div>
					<h4 id="h4">상세 내용</h4>
					<textarea name="content"></textarea>
				</div>
				<div>
					<h4>첨부 사진 <input type="file" name="file" value="첨부사진"></h4>
				</div>
				<div> 
					<h4>
						별점
						<div id="star-rating">
						<input type="hidden" name="star" value="0">
						<img name="star1" src="../images/binstar2.png">
						<img name="star2" src="../images/binstar2.png">
						<img name="star3" src="../images/binstar2.png">
						<img name="star4" src="../images/binstar2.png">
						<img name="star5" src="../images/binstar2.png">
<!-- 						<input id="star-rating-button" type="button" name="star" value="1">
						<input id="star-rating-button" type="button" name="star" value="2">
						<input id="star-rating-button" type="button" name="star" value="3">
						<input id="star-rating-button" type="button" name="star" value="4">
						<input id="star-rating-button" type="button" name="star" value="5"> -->
							<!-- <span style="width: 50%"></span> -->
						</div>
					</h4>
				</div>
				<div id="button">
					<a href="listDelete"><input id="input" type="button" name="commit"
						value="취소"></a> <input type="submit" name="commit" value="확인">
				</div>
			</div>
		</form>
	</div>
	</main>
	<!-- =========================================================================== -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
