<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Detail</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="${ pageContext.servletContext.contextPath }/resources/css/menubar.css" rel="stylesheet" type="text/css">
       <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
	<styles>	
	.outer {
		width : 1000px;
		margin : auto;
	}
	
	.wrap {
		width : 900px;
		
	}
	
	ul, li {
		margin :0;
		padding : 0;
	}
	
	.notice_title {
		border-bottom : 1px solid #282A35;
	}
	
	.notice_list {
		margin : 20px 30px;
		min-height : 540px;
	}
	
	.notice_list > ul {
		border-bottom : 1px solid #f3f5f7;
		height : 50px;
		line-height: 50px;
		display : flex;
		justify-content: space-around;
		list-style : none;
	}
	
	.notice_list > ul.last {
		border : 0;
	}
	
	.notice_list > ul > li {
		text-align:center;
	}
	
	.notice_list .no {
		width:30px;
	}
	
	.notice_list .title {
		width:520px;
		text-align: left;
		overflow: hidden;
    	text-overflow: ellipsis;
    	white-space: nowrap;
	}
	
	
	.notice_list .date {
		width:100px;
	}
	
	.onmouseover {
		background:#f3f5f7;
		cursor:pointer;
	}
	
	.search_area {
		text-align:center;
		padding : 30px;
	}
	
	.search_area select {
		width : 150px;
		height : 30px;
		border: 0px;
	}
	
	.input_area {
	    border: solid 1px #dadada;
	    padding : 10px 10px 14px 10px;
	    margin-right : 20px;
	    background : white;
	}
	
	.input_area input {
		width : 250px;
		height : 30px;
		border: 0px;
	}
	
	.input_area input:focus,
	.search_area select:focus{
		outline:none;
	}
	</styles>
</head>
<body>
 <jsp:include page="../common/menubar.jsp"/>
 <div class="outer">
		<div class="wrap">
			<div class="notice_area">
				<div class="notice_title">
					<br><br>
					<h4>공지사항</h4>
				</div>
				<div class="notice_content">
					<div class="subject">
						<span> 글번호 : ${ notice.no } </span> <span> 작성일 : ${ notice.createDate }
						</span>
					</div>
					<div>
						<h4>
							<span class="title_span">&nbsp;</span> 제목
						</h4>
						<p>${ notice.title }</p>

						<h4>
							<span class="title_span">&nbsp;</span> 내용
						</h4>
						<pre class="content">${ notice.content }</pre>
					</div>
					<div class="btn_area">
						<button type="button" id="listBtn"
							onclick="location.href='${ pageContext.servletContext.contextPath }/notice/list'">목록으로</button>
						
							<button type="button" onclick="updateNoticeView(${ notice.no })">수정하기</button>
							<button type="button" onclick="deleteNotice()">삭제하기</button>
							<!-- form 태그를 post 방식으로 제출 -->
							<form name="noticeForm" method="post">
								<input type="hidden" name="no" value="${ notice.no }">
							</form>
							<script>
							function updateNoticeView(no){
								location.href = "${ pageContext.servletContext.contextPath }/notice/update?no="+no;
							}
							function deleteNotice(){
								if(confirm('이 게시글을 삭제하시겠습니까?')){
									document.forms.noticeForm.action = "${ pageContext.servletContext.contextPath }/notice/delete";
									document.forms.noticeForm.submit();
								}
							}
						</script>
						
					</div>
				</div>
			</div>
		</div>
	</div>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
</body>
</html>