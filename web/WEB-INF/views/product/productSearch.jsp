<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 게시판</title>
</head>
<body>
	<div class="outer">
		<div class="wrap">
			<div class="board_area">
				<div class="board_title">
					<h1>사진 게시판</h1>
				</div>
				<div class="list_div">
					<ul class="board_list">
						<c:forEach var="thumbnail" items="${ thumbnailList }">
						<li>
						<div class="box" onclick="detailView(${ thumbnail.no });">
							<img src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }">
							<p class="category">[ ${ thumbnail.category.name } ]</p>
							<p class="title">${ thumbnail.title }</p>
							<p class="writer">${ thumbnail.writer.nickname } | 조회수 : ${ thumbnail.count }</p>
						</div>
						</li>
						</c:forEach>
					</ul>
				</div>
				
				<c:if test="${ !empty loginMember }">
				<div class="btn_area">
					<button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/product/insert'">작성하기</button>
				</div>
				</c:if>
			</div>
		</div>
	</div>
	

	<script>
			function detailView(no){
				location.href = '${ pageContext.servletContext.contextPath }/thumbnail/detail?no=' + no;
			}
	</script>
</body>
</html>