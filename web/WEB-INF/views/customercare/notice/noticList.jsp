<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link href="${ pageContext.servletContext.contextPath }/resources/css/admin-styles.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="../../common/admin-menubar.jsp"/>
	<div id="layoutSidenav_content">
            <main id="cst-table">
                <h4>공지사항</h4>
                <hr>
                <table class="table">


                    <tr>
                        <th scope="col"><input type="checkbox" name="nb[]" value="01">#</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성일</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">
                                <p><label><input type="checkbox" name="nb[]" value="01">1</label></p>
                            </th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </td>

                    </tbody>

                </table>
                <div class="search_area">
                    <form>

                        <select id="searchCondition" name="searchCondition">
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                        </select>

                        <span class="input_area">
                            <input type="search" name="searchValue">
                            <button type="button" class="btn btn-secondary">검색</button>
                            <button type="button" class="btn btn-secondary">작성하기</button>
                        </span>


                    </form>
                </div>
            </main>
</body>
</html>