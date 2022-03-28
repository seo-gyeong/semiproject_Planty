<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- ress.css (https://github.com/filipelinhares/ress) -->
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<!-- css -->
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/inquiry.css"
	rel="stylesheet" type="text/css">
<!-- bootstrap -->

<!-- Roboto -->
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<!-- noto sans KR-->
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;700&display=swap"
	rel="stylesheet">

<style>
.order-status {
	border: 1px solid #4C5B5D;
	justify-content: center;
}
</style>

</head>
<body>
	<!-- header -->
	<header class="menu1">
		<div class="back">
			<div class="nav-bar">
				<div class="navbar-left">

					<div class="dropdown">
						<a href="../page/ABOUT US.html" class="dropbtn">ABOUT US</a>
					</div>

					<div class="dropdown">
						<button class="dropbtn">SHOP</button>
						<div class="dropdown-content">
							<a href="#">ALL</a> <a href="#">FUNCTION</a> <a href="#">PLACE</a>
							<a href="#">FOR ANIMALS</a>
						</div>
					</div>

					<div class="dropdown">
						<button class="dropbtn">CUSTOMER</button>
						<div class="dropdown-content">
							<a href="#">NOTICE</a> <a href="../page/FAQ.html">FAQ</a>
						</div>
					</div>

				</div>
				<div class="navbar-center">
					<a href="../page/ABOUT US.html"><img class="image"
						src="${ pageContext.servletContext.contextPath }/resources/image/planty_logo.png"></a>
				</div>

				<div class="navbar-right">
					<ul>
						<li><a
							href="${ pageContext.servletContext.contextPath }/user/regist">
								<img class="icon" onClick="mypage_check();"
								src="${ pageContext.servletContext.contextPath }/resources/image/my.png">
						</a></li>
						<li><a
							href="${ pageContext.servletContext.contextPath }/user/regist">
								<img class="icon" onClick="mypage_check();"
								src="${ pageContext.servletContext.contextPath }/resources/image/cart.png">
						</a></li>
					</ul>


				</div>
			</div>
		</div>
		<script>
			function mypage() {
				let signIn = ""
				if (signIn == "") {
					alert("해당 페이지는 로그인 후 사용하실 수 있습니다.");
					location.href = "LOG IN.html";
				} else {
					location.href = "mypage.html";
				}
			}

			function cart() {
				let signIn = ""
				if (signIn == "") {
					alert("해당 페이지는 로그인 후 사용하실 수 있습니다.");
					location.href = "LOG IN.html";
				} else {
					location.href = "cart.html";
				}
			}
		</script>
	</header>
	<div class="title-ar">상품 하단 리뷰 조회</div>
	<div class="subtitle">
		<p></p>
	</div>

	<!-- content -->
	<div class="order-page wrapper">

		<div class="order-list">
			<div class="board_list">
				<ul class="board_header">
					<li class="rev-img">리뷰이미지</li>
					<li class="rev-score">별점</li>
					<li class="rev-title">제목</li>
					<li class="date">작성일</li>
				</ul>

				<c:forEach var="review" items="${ reviewList }">
					<ul class="board_ul" id="toc-toggle" onclick="openCloseToc()">
						<li class="rev-img">
							<div class="rev-thumb">
								<a href="#"> <img
									src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }"
									alt="review_thumb" width="100%" height="100%"
									class="thumb-ctrl">
								</a>
							</div>
						</li>
						<li class="rev-score">${ review.score }</li>
						<li class="rev-title">${ review.title }</li>
						<li class="date">${ review.date }</li>

					</ul>
					<div id="toc-content">
						<div class="content">
							<div class="image_area">
								<c:forEach items="${ thumbnail.attachmentList }"
									var="attachment">
									<div class="photoList">
										<img
											src="${ pageContext.servletContext.contextPath }${ attachment.savePath }${ attachment.savedName }">
										<p>${ attachment.originalName }</p>
									</div>
								</c:forEach>
							</div>
							<div class="rev-content">${ review.content }</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

		<script>
			function openCloseToc() {
				if (document.getElementById('toc-content').style.display === 'block') {
					document.getElementById('toc-content').style.display = 'none';
				} else {
					document.getElementById('toc-content').style.display = 'block';
				}
			}
		</script>

		<jsp:include page="../common/paging.jsp" />

		<div class="quickmenu">
			<ul>
				<li id="quickmenu"><a style="color: white;">퀵메뉴</a></li>
				<li><a href="my-page-order.html">주문조회</a></li>
				<li><a href="my-page-wish.html">찜한상품</a></li>
				<li><a href="JOIN-modify.html">회원정보</a></li>
				<li><a href="my-page-qna.html">상품문의</a></li>
				<li><a href="my-page-review.html">리뷰조회</a></li>
				<li><a href="my-page-coupon.html">쿠폰조회</a></li>
			</ul>
		</div>
		<script>
			//     $(document).ready(function(){
			//     var currentPosition = parseInt($(".quickmenu").css("top"));

			//     $(window).scroll(function() {
			//         var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
			//         $(".quickmenu").stop().animate({"top":position+currentPosition+"px"},1000);
			//     });
			// });
		</script>

		<footer>
			<p>
				<span>상호: PLANTY | 대표: 김플랜 | 개인정보관리책임자: 김플랜 | 전화:
					070-1234-5678 | 이메일: planty00@naver.com</span><br /> <span>주소:
					서울특별시 플랜구 식물동 159-2 | 사업자등록번호: 151-15-15151 | 통신판매: 2022-서울강남-0000
					| 호스팅제공자: (주)식물샵</span><br />
			</p>
			<nav>
				<a href='../page/policy.html'>이용약관</a> | <a
					href='../page/policy.html'>개인정보처리방침</a>
			</nav>
		</footer>
	</div>




</body>
</html>