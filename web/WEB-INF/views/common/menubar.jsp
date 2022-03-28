<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuBar</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="${ pageContext.servletContext.contextPath }/resources/css/menubar.css" rel="stylesheet" type="text/css">

</head>
<body>
 <header id="header" class="menu1"> 
        <div class="back">
        <div class="nav-bar">
            <div class="navbar-left">

                <div class="dropdown">
                    <a href="${ pageContext.servletContext.contextPath }/main/aboutus"  class="dropbtn">ABOUT US</a>
                  </div>
      
                <div class="dropdown">
                    <button class="dropbtn">SHOP</button>
                    <div class="dropdown-content">
                      <a href="#">ALL</a>
                      <a href="#">FUNCTION</a>
                      <a href="#">PLACE</a>
                      <a href="#">FOR ANIMALS</a>
                    </div>
                  </div>

                <div class="dropdown">
                    <button class="dropbtn">CUSTOMER</button>
                    <div class="dropdown-content">
                      <a href="#">NOTICE</a>
                      <a href="${ pageContext.servletContext.contextPath }/main/faq">FAQ</a>
                    </div>
                  </div>

            </div>
            <div class="navbar-center">
                   <a href="${ pageContext.servletContext.contextPath }/main/intro"><img class="image"   src="${ pageContext.servletContext.contextPath }/resources/image/planty_logo.png"></a> 
            </div>

            <div class="navbar-right">
            
              <div>
                <c:if test="${ empty sessionScope.loginMember }">
 			 	<a href="${ pageContext.servletContext.contextPath }/member/login"> <img class="icon"  src="${ pageContext.servletContext.contextPath }/resources/image/my.png"></a></li>
              	<a href="${ pageContext.servletContext.contextPath }/member/login"> <img class="icon" src="${ pageContext.servletContext.contextPath }/resources/image/cart.png"></a></li>
               </c:if>
               
               <c:if test="${ !empty sessionScope.loginMember }">
                <a href="${ pageContext.servletContext.contextPath }/member/logout"> <img class="icon"  src="${ pageContext.servletContext.contextPath }/resources/image/logout.png"></a></li>
			  	<a href="${ pageContext.servletContext.contextPath }/mypage"> <img class="icon"  src="${ pageContext.servletContext.contextPath }/resources/image/my.png"></a></li>
              	<a href="${ pageContext.servletContext.contextPath }/cart"> <img class="icon"  src="${ pageContext.servletContext.contextPath }/resources/image/cart.png"></a></li>
               </c:if>
               
              </div>                     
             
                
            </div>
     </div>            
    </div> 
</header>
</body>
</html>