<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>product</title>  
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 
    <link href="${ pageContext.servletContext.contextPath}/resources/css/aboutUs.css" rel="stylesheet">
    <link href="${ pageContext.servletContext.contextPath}/resources/css/product.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
    .box:hover {
		cursor : pointer;
		transform:scale(1.05);
	}
    </style>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>

<body>
    <div class="container product-container">

        <h2 id=product-category> ALL </h2>
    
        <div class="row">
        <c:forEach var="product" items="${ productList }">
          <div class="col-md-4 product-div box" onclick="detailView(${ product.pro_no });">
          	<img class="product-img rounded-2" src="${ pageContext.servletContext.contextPath }${ product.attachmentList[0].p_path }/${ product.attachmentList[0].file_name }">
         	<p>${ product.pro_name }</p>
         	<p>가격 : ${product.pro_price }
          </div>
		</c:forEach>

    
        
        <nav aria-label="Page navigation example" class="product-nav">
          <ul class="pagination justify-content-center">
            <li class="page-item disabled">
              <a class="page-link">Prev</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
              <a class="page-link" href="#">Next</a>
            </li>
          </ul>
        </nav>
    </div>
    
    <script>
			function detailView(pro_no){
				location.href = '${ pageContext.servletContext.contextPath }/product/detail?pro_no=' + pro_no;
			}
	</script>
    
    <footer>
        <p>
            <span>상호: PLANTY | 대표: 김플랜 | 개인정보관리책임자: 김플랜 | 전화: 070-1234-5678 | 이메일: planty00@naver.com</span><br/>
            <span>주소: 서울특별시 플랜구 식물동 159-2 | 사업자등록번호: 151-15-15151 | 통신판매: 2022-서울강남-0000 | 호스팅제공자: (주)식물샵</span><br/>
        </p>
        <nav>
            <a href='#' target='_blank'>이용약관</a> |
            <a href='#' target='_blank'>개인정보처리방침</a>|
            <a href='#' target='_blank'>사업자정보확인</a>
        </nav>
    </footer>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


</body>
<footer>
    <p>
        <span>상호: PLANTY | 대표: 김플랜 | 개인정보관리책임자: 김플랜 | 전화: 070-1234-5678 | 이메일: planty00@naver.com</span><br/>
        <span>주소: 서울특별시 플랜구 식물동 159-2 | 사업자등록번호: 151-15-15151 | 통신판매: 2022-서울강남-0000 | 호스팅제공자: (주)식물샵</span><br/>
    </p>
    <nav>
        <a href='#' target='_blank'>이용약관</a> |
        <a href='#' target='_blank'>개인정보처리방침</a>|
        <a href='#' target='_blank'>사업자정보확인</a>
    </nav>
</footer>
</html>