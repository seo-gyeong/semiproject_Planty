<jsp:directive.page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
.outer {
	width: 800px;
	margin: auto;
}

.wrap {
	width: 780px;
	margin: 100px auto;
}

ul, li {
	margin: 0;
	padding: 0;
}

.board_title {
	border-bottom: 1px solid #282A35;
}

.board_list {
	margin: 20px 30px;
	min-height: 565px;
}

.board_list>ul {
	border-bottom: 1px solid #f3f5f7;
	height: 50px;
	line-height: 50px;
	display: flex;
	justify-content: space-around;
	list-style: none;
}

.board_list>ul.last {
	border: 0;
}

.board_list>ul>li {
	text-align: center;
}

.board_header {
	background: #282A35;
	color: white;
	font-weight: bold;
}

.board_list .id {
	width: 60px;
}

.board_list .category {
	width: 60px;
}

.board_list .title {
	width: 350px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.board_list .writer {
	width: 80px;
}

.board_list .count {
	width: 60px;
}

.board_list .date {
	width: 100px;
}

.onmouseover {
	background: #f3f5f7;
	cursor: pointer;
}


.paging_area button {
	color: #282A35;
	width: 40px;
	height : 40px;
	border : 0;
	outline : 0;
	background : white;
	cursor : pointer;
}

.paging_area .currentPage {
	border-bottom : 2px solid #282A35;
	font-weight : bold;
}

.search_area {
	text-align: center;
	padding: 30px;
}

.search_area select {
	width: 150px;
	height: 30px;
	border: 0px;
}

.input_area {
	border: solid 1px #dadada;
	padding: 10px 10px 14px 10px;
	margin-right: 20px;
	background: white;
}

.input_area input {
	width: 250px;
	height: 30px;
	border: 0px;
}

.input_area input:focus, .search_area select:focus {
	outline: none;
}

.search_area button {
	width: 100px;
	height: 35px;
	border: 0px;
	color: white;
	background: #282A35;
	margin: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<div class="outer">
		<div class="wrap">
			<div class="board_area">
				<div class="board_title">
					<h1>게시판</h1>
				</div>
				<div class="board_list">
					<ul class="board_header">
						<li class="id">글번호</li>
						<li class="category">분류</li>
						<li class="title">제목</li>
						<li class="writer">작성자</li>
						<li class="count">조회수</li>
						<li class="date">작성일</li>
					</ul>
					<c:forEach var="board" items="${ boardList }">
						<ul class="board_ul" onclick="detailView(${board.no})">
							<li class="id">${ board.no }</li>
							<li class="category">${ board.category.name }</li>
							<li class="title">${ board.title }</li>
							<li class="writer">${ board.writer.nickname }</li>
							<li class="count">${ board.count }</li>
							<li class="date">${ board.createdDate }</li>
						</ul>
					</c:forEach>
				</div>
				
			<jsp:include page="../common/paging.jsp"/>
				
			<div class="search_area">
				<form method="get" action="${ pageContext.servletContext.contextPath }/board/list">
					<select id="searchCondition" name="searchCondition">
						<option value="category"
							${ param.searchCondition == 'category' ? "selected" : ""}>카테고리</option>
						<option value="title"
							${ param.searchCondition == 'title' ? "selected" : ""}>제목</option>
						<option value="content"
							${ param.searchCondition == 'content' ? "selected" : ""}>내용</option>
						<option value="writer"
							${ param.searchCondition == 'writer' ? "selected" : ""}>작성자</option>
					</select> <span class="input_area"> <input type="search"
						name="searchValue" value="${ param.searchValue }">
					</span>
					<button type="submit">검색하기</button>
					<c:if test="${ !empty loginMember }">
						<button type="button"
							onclick="location.href='${ pageContext.servletContext.contextPath }/board/insert'">작성하기</button>
					</c:if>
				</form>
			</div>
		</div>
	</div>
	</div>

	<script>
		// 1. 상세 페이지 조회
		const boardList = document.querySelector(".board_list");
		
		boardList.addEventListener('mouseover', function() {
			if(event.target.classList.contains('board_ul'))
				event.target.classList.add('onmouseover');
			else if(event.target.parentNode.classList.contains('board_ul'))
				event.target.parentNode.classList.add('onmouseover');
		});
		
		boardList.addEventListener('mouseout', function() {
			if(event.target.classList.contains('board_ul'))
				event.target.classList.remove('onmouseover');
			else if(event.target.parentNode.classList.contains('board_ul'))
				event.target.parentNode.classList.remove('onmouseover');
		});
		
		function detailView(no){
			location.href = '${ pageContext.servletContext.contextPath }/board/detail?no=' + no;
		}
	</script>
</body>
</html>