<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!--  구글 웹폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Festive&family=Noto+Sans+KR&family=Roboto&display=swap" rel="stylesheet">
    <!--  외부 스타일 시트 -->
    <link href="${ pageContext.servletContext.contextPath }/resources/css/style_pro_regiModi.css" rel="stylesheet" type="text/css" ></head>

<body>
    <header id="main_header">
        <a href="#"><img class="logo" src="${ pageContext.servletContext.contextPath }/resources/image/planty_logo.png" alt="logo">    
            <nav id="main_gnb"></nav>
    </header>
    
    <div id="wrap">
        <nav id="main_lnb">
            <h4><a href="${ pageContext.servletContext.contextPath }/partner/mypage">MY PAGE</a></h4>
            <ul>
                <li class="menu"><a href="${ pageContext.servletContext.contextPath }/product/regist">상품 관리</a>
                    <ul class="submenu">
                        <li><a href="${ pageContext.servletContext.contextPath }/product/regist">상품 등록</a></li>
                        <li><a href="${ pageContext.servletContext.contextPath }/product/search">상품 조회</a></li>
                    </ul>
                </li>
                <li class="menu"><a href="${ pageContext.servletContext.contextPath }/qna/list">Q&A 관리</a></li>
                <li class="menu"><a href="./mp_qna_searchAll.html">Logout</a></li>
            </ul>
        </nav>
        <!-- 내용 -->
    	<div id="content_wrap">
	        <div id="content">
	        <form id="modifyForm" name="modifyForm" action="${ pageContext.servletContext.contextPath }/product/regist" method="post" 
	        encType="multipart/form-data">
	            <div class="cate-title" >
                <div class="col">
                    <p>상품 등록</p>
                </div>
            </div>            
            <table class="table">
                <!-- 테이블 제목 -->
                <thead>
                </thead>
                <tbody>
                    <tr>
                        <th>대표사진</th>
                        <td>
                        	<div class="image_area">
                        	
                        	<img src="" class="img-thumbnail" alt="">
                        	</div>
                        
                        </td>
                        <td>
                            <input type="file" id="thumbnail" name="thumbnail" accept="image/*" onchange="img_upload(this)" required >                                                       
                        </td>
                    </tr>
                    <tr>
                        <th>카테고리</th>
                        <td>
                            <div>
                                <select class="form-select form-select-sm" aria-label="form-select" name="category">
                                    <option value="1">Air purification</option>
                                    <option value="2">Living room</option>
                                    <option value="3">Bedroom</option>
                                    <option value="4">Veranda</option>
                                    <option value="5">Cats</option>
                                    <option value="6">Dogs</option>
                                    <option value="7">Others</option>
                                </select>
                            </div>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>상품명</th>
                        <td><input class="form-control" type="text" placeholder="상품명" aria-label="input pro_name" name="proName"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td><input class="form-control" type="text" placeholder="가격" aria-label="input pro_price" name="proPrice"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>상품설명</th>
                        <td>
                        	<input type="file" id="proImg" name="proImg" accept="image/*" onchange="img_upload(this)" required >                           
                        </td>
                        <td></td>
                    </tr>
                    
                </tbody>
            </table>
            <button type="submit" class="btn-modify">등록하기</button>
            </form>
        </div>
    </div>
    </div>
<footer>
    <p>
        <span>상호: PLANTY | 대표: 김플랜 | 개인정보관리책임자: 김플랜 | 전화: 070-1234-5678 | 이메일: planty00@naver.com</span><br/>
        <span>주소: 서울특별시 플랜구 식물동 159-2 | 사업자등록번호: 151-15-15151 | 통신판매: 2022-서울강남-0000 | 호스팅제공자: (주)식물샵</span><br/>
    </p>
    <nav>
        <a href='policy.html'>이용약관</a> |
        <a href='policy.html'>개인정보처리방침</a>
    </nav>
</footer>
	<script src="${ pageContext.servletContext.contextPath }/resources/js/imagePreview.js"></script>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->    
</body>
</html>







