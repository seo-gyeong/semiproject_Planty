<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<style>

	* {
		color: #4C5B5D;
	}
	.outer{
		width:90%;
		min-width : 450px;
		margin:auto;
	}
	
	.outer h1 {
		text-align:center;
	}
	
	#updatePwdForm {
		width : 300px;
		margin: 40px auto 0 auto;
	}
	
	.input_area {
	    border: solid 1px #dadada;
	    padding : 10px 10px 14px 10px;
	    background : white;
	}
	
	.input_area input:focus {
		outline: none;
	}
	
	.input_area input{
		width : 270px;
		height : 30px;
		border: 0px;
	}
	
	.btnArea {
		text-align:center;
		padding : 30px;
	}
	
	button:hover {
		cursor:pointer
	}
	
	button {
		width: 100px;
		height: 35px;
		border: 0px;
		color: white;
		background: #249698;
		margin: 5px;
		cursor: pointer;
}
	}
</style>
</head>
<body>
	<div class="outer">
	<br>
	<h1>비밀번호 변경</h1>
	
	<form id="updatePwdForm" action="${ pageContext.servletContext.contextPath }/user/modifyPwd"
	method="post" onsubmit="return checkPassword();">
				<h4>현재 비밀번호</h4>
				<span class="input_area">
				<input type="password" name="checkPwd" id="checkPwd" maxlength="30">
				</span>
				<h4>변경할 비밀번호</h4>
				<span class="input_area">
				<input type="password" name="pwd" id="memberPwd" maxlength="30" plcaeholder="영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~30자">
				</span>
				<h4>변경할 비밀번호 확인</h4>
				<span class="input_area">
				<input type="password" name="pwd2" id="memberPwd2" maxlength="30">
				</span>
			<div class="btnArea">
				<button id="updatePwdBtn">변경하기</button>
			</div>
	</form>
	</div>
	<script>
	
		function checkPassword(){
			const checkPwd = document.getElementById('checkPwd');
			const memberPwd = document.getElementById('memberPwd');
			const memberPwd2 = document.getElementById('memberPwd2');
			
			if(checkPwd.value == "" || memberPwd.value == "" || memberPwd2.value == ""){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			if(memberPwd.value != memberPwd2.value){
				alert("비밀번호가 다릅니다.");
				memberPwd2.select();
				return false;
			}
			
			return true;
		}
	</script>
	
</body>
</html>