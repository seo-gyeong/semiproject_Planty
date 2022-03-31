<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<style>
.outer {
		width : 1000px;
		margin : auto;
	}
	
	.wrap {
		width : 900px;
		margin-left : 150px;
	}

.notice_title {
	border-bottom: 1px solid #282A35;
}

.notice_content {
	padding: 0px 20px;
}

.notice_content .subject {
	height: 55px;
	line-height: 55px;
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid #f3f5f7;
}

.notice_content .content {
	margin-bottom: 30px;
}

.input_area {
	border: solid 1px #dadada;
	padding: 10px 10px 14px 10px;
	background: white;
}

.input_area input {
	width: 800px;
	height: 30px;
	border: 0px;
}

.input_area input:focus {
	outline: none;
}

.textarea {
	resize: none;
	border: solid 1px #dadada;
	width: 830px;
}

.textarea:focus {
	outline: none;
}

.title_span {
	background-color: #282A35;
}

.notice_area button {
	width: 100px;
	height: 35px;
	border: 0px;
	color: white;
	background: #282A35;
	margin: 5px;
	cursor: pointer;
}

.btn_area {
	text-align: center;
	border-top: 1px solid #282A35;
	padding: 30px;
}
</style>
</head>
<body>
	<jsp:include page="../../common/admin-menubar.jsp" />

	<div class="outer">
		<div class="wrap">
			<div class="notice_area">
				<div class="notice_title">
					<br><br>
					<h1>공지사항 수정</h1>
				</div>
				<div class="notice_content">
					<div class="subject">
						<span> 글번호 : ${ notice.no } </span> <span> 작성일 : ${ notice.createDate }
						</span>
					</div>
					<form action="${ pageContext.servletContext.contextPath }/notice/update" method="post">
						<input type="hidden" name="no" value="${ notice.no }">
						<div class="content">
							<h4>
								<span class="title_span">&nbsp;</span> 제목
							</h4>
							<span class="input_area"> <input type="text" name="title"
								value="${ notice.title }" required>
							</span>
							<br><br><br>
							<h4>
								<span class="title_span">&nbsp;</span> 내용
							</h4>
							<textarea class="textarea" rows="20" cols="100" name="content"
								required>${ notice.content }</textarea>
						</div>
						<div class="btn_area">
							<button type="button"
								onclick="location.href='${ pageContext.servletContext.contextPath }/notice/list'">목록으로</button>
							<button type="submit">수정하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
