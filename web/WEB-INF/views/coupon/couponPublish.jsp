<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰</title>

    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/styles2.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>

<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-light bg-light">
        <!-- Navbar Brand-->
        <div class="planty_logo">
            <img src="planty_logo.png">
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
            <h4>쿠폰 발급</h4>
            <hr>
            <fieldset>
                <form>
                    <label>이름 : </label>
                    <input type="text">
                    <br><br><br>

                    <label>자동 지급 :</label>
                    <select name="provide-method">
                        <option value="o">사용</option>
                        <option value="x">사용 안함</option>
                    </select>
                    <br><br><br>
                    <label>지급 조건 :</label>
                    <select name="provide-method">
                        <option value="join">신규가입</option>
                        <option value="download">이벤트 창에서 다운로드</option>
                    </select>
                    <br><br><br>

                    <label>유효기간 : </label>
                    <input type="number" width="40px">일
                    <input type="date" name="dateIn"><br>

                </form>
                <br>
                <button type="button" class="btn btn-success">쿠폰 등록</button>
            </fieldset>

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