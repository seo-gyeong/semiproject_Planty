<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
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


    <!-- ------미작성 리뷰 조회 섹션 ------- -->

    <div class="title-ar">미작성 리뷰 조회</div>

        <div class="board_list">
            <ul class="board_header">
                <li class="ord-no">주문번호</li>
                <li class="ord-date">주문일자</li>
                <li class="ord-img">이미지</li>
                <li class="ord-info">상품정보</li>
                <li class="ord-sum">주문금액(수량)</li>
                <li class="ord-selection">선택</li>
            </ul>

            <div class="board_list">
              <c:forEach var="order" items="${ orderList }">
                <ul class="board_ul">
                    <li class="ord-no">
                        <a href="" class="line">${ order.ordNo }</a>
                    </li>
                    <li class="ord-date">
                        ${ order.orderDetail.ordDate }
                    </li>
                    <li class="ord-img">
                        <div class="thumb">
                            <a href=""> <img
                                    src="${ pageContext.servletContext.contextPath }${ order.attachmentList[0].thumPath }"
                                    alt="product_thumbnail" width="100%" height="100%">
                            </a>
                        </div>
                    </li>
                    <li class="ord-info left">
                        <div class="pro-name">${ order.product.pro_name }</div>
                    </li>
                    <li class="ord-sum">
                        <div class="amount">${ order.product.pro_price }</div>
                        <div class="number">${ order.amount }</div>
                    </li>
                    <li class="ord-selection rev-option2">
                        <div>
                            <form method="get" action="${ pageContext.servletContext.contextPath }/review/insert">
                                <button type="submit" class="order-btn">작성</button>
                            </form>
                        </div>
                    </li>


                </ul>
               </c:forEach>
            </div>
        </div>




</body>
</html>