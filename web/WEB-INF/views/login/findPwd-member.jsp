<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>findPwdMember</title>
    <link rel="icon" type="image/x-icon" href="${ pageContext.servletContext.contextPath }/resources/image/favi.png" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="${ pageContext.servletContext.contextPath }/resources/css/find-pwd.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
  <jsp:include page="../common/menubar.jsp"/>
<body>
	<div class="main-container">
		<div class="main-wrap">
		
		<form class="login-input-section-wrap" method="POST" action="${ pageContext.servletContext.contextPath }/user/findpwduser">
            <div class="login-title1">
                <h2 class="login-title2">비밀번호 찾기</h2>
            </div>
        
           <div class="type1">
        
              <div class="type2">
                <div  class="login-input-wrap">   
                    <input name="id" placeholder="아이디" id="id" type="text" class="input" required="required"><br>
                </div>
              
            <div class="type2">
                <div class="login-input-wrap"> 
                    <input name="email"  placeholder="이메일" id="email" type="text" class="input2" data-type="password" required="required"><br>
                </div>
            </div>
 
              </div>     
              <div class="login-button-wrap">
				<button name="findPwd" type="submit" > 확인 </button>
			</div>
    
            <div class="empty">
             <br>
            </div>
        </div>
        </form>
    </div>

		</div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
 <jsp:include page="../common/footer.jsp"/>
</html>