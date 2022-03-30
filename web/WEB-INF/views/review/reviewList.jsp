<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 조회</title>
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
	<div class="title-ar">리뷰 조회</div>
	<div class="subtitle">
		<p></p>
	</div>

	<!-- content -->
	<div class="order-page wrapper">
		<input type="hidden" name="id" value="${ loginUser.id }">
		<!-- ------ 리뷰 조회 섹션 ------- -->
		<div class="order-list">
			<div class="board_list">
				<ul class="board_header">
					<li class="rev-img">리뷰이미지</li>
					<li class="rev-proinfo">상품정보</li>
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
						<li class="rev-proinfo">
							<!-- <p>
                                <a class="big-cate" href="">허브  ${ category.cate_a }</a>
                            </p> --> 
                            <p>
                                <a class="pro-name" href="">잉글리시 라벤더 ${ product.pro_name }</a>
                            </p> 
						</li>
						<li class="rev-score"><c:forEach var="score" items="${ ratingOptions }" varStatus="status" begin="0" end="${ review.score }">★</c:forEach></li>
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
		<br>
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
		<br><br><br><br>

		<!-- ------미작성 리뷰 조회 섹션 ------- -->
        <div class="title-ar">
        미작성 리뷰 조회
        </div>
        <!-- <div class="selection-area">
            <fieldset id="order-selection-f">
                <legend>검색 기간 설정</legend>
                <div class="box-ele">
                    <span class="order-selection">
                        <select class="order-sel" id="s-order" onchange="location.href=this.value">
                            <option value="all" disabled selected>전체 주문처리상태</option>
                            <option value="shipped-before">입금전</option>
                            <option value="shipped-standby">배송준비중</option>
                            <option value="shipped-standby">배송중</option>
                            <option value="shipped-complete">배송완료</option>

                        </select>
                    </span>
                    <span class="period">
                        <button class="btn-date" days="00" formaction="">오늘</button>
                        <button class="btn-date" days="07" formaction="">1주일</button>
                        <button class="btn-date" days="30" formaction="">1개월</button>
                        <button class="btn-date" days="90" formaction="">3개월</button>
                        <button class="btn-date" days="180" formaction="">6개월</button>
                    </span>
                    <div class="history-date"> -->
                    <!-- <input type="date" id="start-date">
                    &nbsp;-&nbsp;
                    <input type="date" id="end-date">
                    <button class="btn-submit" formaction="">조회</button>

                     </div> -->
                <!-- </div>
            </fieldset>
        </div> -->
        
            <table class="order-table" summary>
                <!-- <div>주문 상품 정보</div> -->
                <colgroup>
                    <col style="width:150px">
                    <col style="width:150px">
                    <col style="width:125px">
                    <col style="width:auto">
                    <col style="width:135px">
                    <col style="width:200px">
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">주문번호</th>
                        <th scope="col">주문일자</th>
                        <th scope="col">이미지</th>
                        <th scope="col">상품정보</th>
                        <th scope="col">주문금액(수량)</th>
                        <th scope="col">선택</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="no">
                            <a href="" class="line">${ review.orderNo }</a>
                        </td>
                        <td class="date">
                            <p>
                            <p>2022-03-14</p>
                            </p>
                        </td>
                        <td>
                            <div class="thumb">
                                <a href="">
                                    <img src="../mystyle/image/josephine-lityo-unsplash-lavender_proIMG.jpg"
                                        alt="product_thumbnail" width="100%" height="100%">
                                </a>
                            </div>
                        </td>
                        <td class="product left">
                            <p>
                                <a class="pro-name" href="">잉글리쉬 라벤더
                                ${ product.pro_name }</a>
                            </p>
                            <!-- <p class="option">
                                    옵션:<a class="option" href=""></a>
                                </p> -->
                        </td>
                        <td>
                            <p class="amount">2,500원</p>
                            <p class="number">1개</p>
                        </td>
                        <td class="rev-option2">
                            <div>
                            <form method="get" action="${ pageContext.servletContext.contextPath }/review/insert">
                            	<button type="submit" class="order-btn">작성</button>
                            </form>
                            </div>
                        </td>

                    </tr>

                </tbody>
            </table>

        
        <jsp:include page="../common/paging.jsp"/>
		
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