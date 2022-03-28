<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABOUT US</title>
    <link rel="icon" type="image/x-icon" href="${ pageContext.servletContext.contextPath }/resources/image/favi.png" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="${ pageContext.servletContext.contextPath }/resources/css/aboutUs.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
 
  <jsp:include page="../common/menubar.jsp"/>
  
<body>
  
    <div class="title">
        <h1>ABOUT US</h1>
    </div>
    <div class="subtitle">
        <p> </p>
    </div>
    <div id='wrap'>
    	<section class="content wrapper">
            <div class="about1"> 
                <img class="about-img" src="${ pageContext.servletContext.contextPath }/resources/image/about1.png" >
                <div><h1 id="content-title">개성을 드러내는 건강한 방법!</h1>
                    <h1 id="content-subtitle">PLANTY</h1>
                </div>
                <p>
                    식물을 뜻하는 Plant와 풍부함, 방대함을 뜻하는 Plenty를 사용하여 지은 합성어
                </p>
               <p>
                플랜테리어를 위한 인테리어 식물과 관련된 
                여러 정보를 한 곳에서 제공하겠다는 의미를 담고있습니다.
                정보의 홍수 속에서 살고 있지만 정작 걸려져 선별된 지식을 얻기 힘든 
                현대 사회에서, 질 좋은 엄선된 정보만을 제공하겠습니다.
               </p>
            </div>

            <div class="about2"> 
                <img class="about-img" src="${ pageContext.servletContext.contextPath }/resources/image/about2.png" >
                <div>
                    <h1 id="content-subtitle">트렌드, 세분화된 정보 </h1>
                </div>
               <p>
                MZ세대의 감성에 걸맞는 식물 인테리어를 위해 
                장소별, 용도별 구분과 정보를 제공하여,쉽고 빠르게 구매해볼수있습니다.
               </p>
            </div>
          
            <div class="about3"> 
                <img class="about-img" src="${ pageContext.servletContext.contextPath }/resources/image/about3.png" >
                <div>
                    <h1 id="content-subtitle">반려동물의 안전을 고려한 제품 </h1>
                </div>
               <p>
                반려 동물을 키우는 가구를 위한 카테고리를 별도로 추가함으로써 
                함께 생활하는 동물에게도 안전한 플랜테리어가 되도록 돕겠습니다!
               </p>
            </div>
          
        </section>

    </div>
   
</body>
<footer>
    <p>
        <span>상호: PLANTY | 대표: 김플랜 | 개인정보관리책임자: 김플랜 | 전화: 070-1234-5678 | 이메일: planty00@naver.com</span><br/>
        <span>주소: 서울특별시 플랜구 식물동 159-2 | 사업자등록번호: 151-15-15151 | 통신판매: 2022-서울강남-0000 | 호스팅제공자: (주)식물샵</span><br/>
    </p>
    <nav>
        <a href="${ pageContext.servletContext.contextPath }/main/policy">이용약관</a> |
        <a href="${ pageContext.servletContext.contextPath }/main/policy">개인정보처리방침</a>
    </nav>
</footer>
</html>