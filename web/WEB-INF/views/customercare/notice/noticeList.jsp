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
<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-light bg-light">
        <!-- Navbar Brand-->
        <div class="planty_logo">
            <img src="${ pageContext.servletContext.contextPath }/resources/image/planty_logo.png">
        </div>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">ADMIN PAGE</div>
                        <a class="nav-link collapsed" href="#">
                            회원관리
                        </a>
                        <a class="nav-link collapsed" href="#">
                            쿠폰
                        </a>
                        <a class="nav-link collapsed" href="#">
                            매출
                        </a>
                        <a class="nav-link collapsed" href="#">
                            리뷰
                        </a>
                        <a class="nav-link collapsed" href="#">
                            고객센터
                        </a>

                    </div>
                </div>

                <div class="sb-sidenav-footer">
                    <div class="small">Logged in as:</div>
                    관리자
                    <button type="button" class="btn btn-light" id="logout_bt">Logout</button>
                </div>
            </nav>
        </div>
        <div id="layoutSidenav_content">
            <main id="cst-table">
                <h4>공지사항</h4>
                <hr>
                <table class="table">

					<thead>
                    <tr>
                        <th scope="col"><input type="checkbox" name="nb[]" value="01">#</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성일</th>
                    </tr>
                    </thead>
                    <c:forEach var="n" items="${ noticeList }">
                    <tbody>
                        <tr>
                            <th scope="row">
                                <p><label><input type="checkbox" name="nb[]" value="01">${ n.no }</label></p>
                            </th>
                            <td>${ n.title }</td>
                            <td>${ n.createDate }</td>

                    </tbody>
                    </c:forEach>                   
                </table>
                
                <div class="search_area" action="${ pageContext.servletContext.contextPath }/notice/list" method="get">
                    <form action="${ pageContext.servletContext.contextPath }/notice/list" method="get">

                        <select id="searchCondition" name="searchCondition">
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                        </select>

                        <span class="input_area">
                            <input type="search" name="searchValue">
                            <button type="submit" class="btn btn-secondary">검색</button>
                           <button id="noticeInsert"class="btn btn-secondary"  type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/notice/insert'">작성하기</button>
                        </span>


                    </form>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid px-4">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Planty 2022</div>

                    </div>
                </div>
            </footer>


        </div>

    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
</body>
</html>