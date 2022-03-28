<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>failed</title>
<style>
	#imageArea{
		width : 500px;
		height : 300px;
		margin : 100px auto;
		display : flex;
		justify-content : center;
		align-items : center;
	}
	#imageArea img {
		width : auto;
		height : 100%;
	}
	
	h1 {
		margin: -80px;
	}
	
	#bttmArea {
		margin : 100px;
		display : flex;
		justify-content : center;
		align-items : center;
	}
	
	#error-bttm {
		width : 700px;
		height: 113px;
	
	}

</style>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- css -->
    <link href="${ pageContext.servletContext.contextPath }/resources/css/member.css" rel="stylesheet" type="text/css">
    <!-- bootstrap -->

    <!-- Roboto -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <!-- noto sans KR-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;700&display=swap" rel="stylesheet">


</head>
<body>
<<<<<<< sg

=======
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
                            <a href="../page/FAQ.html">FAQ</a>
                        </div>
                    </div>
    
                </div>
                <div class="navbar-center">
                    <a href="../page/ABOUT US.html"><img class="image" src="${ pageContext.servletContext.contextPath }/resources/image/planty_logo.png"></a>
                </div>
    
                <div class="navbar-right">
                    <ul>
                        <li><a href="${ pageContext.servletContext.contextPath }/user/regist"> <img class="icon" onClick="mypage_check();"
                                    src="${ pageContext.servletContext.contextPath }/resources/image/my.png"></a></li>
                        <li><a href="${ pageContext.servletContext.contextPath }/user/regist"> <img class="icon" onClick="mypage_check();"
                                    src="${ pageContext.servletContext.contextPath }/resources/image/cart.png"></a></li>
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
	
>>>>>>> master
	<div id="imageArea">
		<img id="errorImage" src="${ pageContext.servletContext.contextPath }/resources/image/error-cloud.png" alt="error">
	</div>
	<h1 align="center">${ requestScope.message }</h1>
	<div id="bttmArea">
		<img id="error-bttm" src="${ pageContext.servletContext.contextPath }/resources/image/error-bttm.png" alt="error">
	</div>

</body>
</html>