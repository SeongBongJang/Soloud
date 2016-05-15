<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<style type="text/css">@import url(/Soloud/css/join.css);</style>
<script src="/Soloud/script/jquery.js"></script>
<script type="text/javascript" src="/Soloud/script/join.js"></script>
<script type="text/javascript" src="/Soloud/script/join2.js"></script>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
</head>
<body>
	<c:import url="joinTitleBar.jsp"/>
	<input type="hidden"  id="check_result" value="false"/>
	<table class="table_step">
			<tr>
				<td><img src="/Soloud/image/join/infoinput_.jpg" /></td>
				<td><img src="/Soloud/image/join/joinEnd.jpg"/></td>
			</tr>
	</table>
	<br><br>	
	<div class="section">	
		<h4>솔라우드계정 정보입력</h4>
		<hr>
		<form id="create-form"  name="myForm" method="post" >
			<fieldset>
				<table class="info">
					<tr>
						<th>솔라우드계정(이메일)</th>
						<td><input type="text"  id='id' name="id" style="width: 161px;">@<input id='domain' type="text"  name="domain" style="width: 118px;"/> 
						<select class="chosen-select" style="width: 150px;" tabindex="-1" name="domain2" id="domain2">
								<option>도메인 선택</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.net">daum.net</option>
								<option value="hotmail.com">hotmail.com</option>
								<option value="lycos.co.kr">lycos.co.kr</option>
								<option value="korea.com">korea.com</option>
								<option value="empal.com">empal.com</option>
								<option value="dreamwiz.com">dreamwiz.com</option>
								<option value="yahoo.com">yahoo.com</option>
								<option value="ymail.com">ymail.com</option>
								<option value="live.com">live.com</option>
								<option value="aol.com">aol.com</option>
								<option value="msn.com">msn.com</option>
								<option value="me.com">me.com</option>
								<option value="icloud.com">icloud.com</option>
								<option value="rocketmail.com">rocketmail.com</option>
								<option value="qq.com">qq.com</option>
								<option value="link.com">link.com</option>
								<option value="">직접입력</option>
						</select></td>
						<td>
								<img src="/Soloud/image/join/vaildation_button.jpg" class="button" id="vaildation_button" style="cursor: pointer"onclick="mySubmit(1)"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><p class="desc">실제 사용 중인 이메일 주소가 아니면 비밀번호를 분실 시 찾을 수 없습니다.</p></td>
					</tr>
					<tr>
						<th>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</th>
						<td><input type="text" id="name" name="name" style="width: 161px;"	placeholder="영문 또는 한글 2자리" /></td>
					</tr>
					<tr>
						<th>비밀번호(4~16자리)</th>
						<td><input type="password" id="password" name="password" style="width: 161px;" placeholder=" 4 - 16자" /></td>
					</tr>
					<tr>
						<th>비밀번호 재입력</th>
						<td><input type="password" id="confirm_password" name="confirm_password" style="width: 161px;"></td>
					</tr>
				</table>
			</fieldset>
		<br><br>
		<div class="btn-group">
			<img src="/Soloud/image/join/next_button.jpg" class="button" id="next_button" style="cursor: pointer" onclick="mySubmit(2)"/>
		</div>
		</form>
	</div>
</body>
</html>