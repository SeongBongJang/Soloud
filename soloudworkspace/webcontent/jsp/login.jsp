<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript" src="/Soloud/script/login.js"></script>
<script src="/Soloud/script/jquery.js"></script>
<script>
$(document).ready(function(){
	 //암호 확인 기능 구현
	document.getElementById("input_password").onkeydown = function(e){
		if(e.keyCode == 13)
		{
			if(document.getElementById("input_id").value == "") {
				alert("아이디를 입력해주세요");
				return;
			}
			if(document.getElementById("input_password").value == ""){
				alert("비밀번호를 입력해주세요");
				return;
			}
			
			var formData = $("#loginForm").serialize();
			$.ajax({
				type: "post",
				url: "loginTry.do",
				data: formData,
				dataType: "json",
				success: function (data) 
				{
					if(data.isLogin)//로그인 된 상태라면..?
					{
						alert(data.resultMsg);
					}
					else if(!data.isLogin)	 //로그인 된 상태가 아니라면
					{
						if(data.isSuccess)	//로그인에 성공하나요?
						{
							//성공했다면 관리자인지 ? 일반 사용자인지??
							if(data.isAdmin)	//관리자라면
							{
								document.getElementById("loginForm").action="loginAdmin.do";
								document.getElementById("loginForm").submit();
							}
							else				//일반 사용자라면
							{
								document.getElementById("loginForm").action="loginComplete.do";
								document.getElementById("loginForm").submit();
							}
						}
					}
					else
					{
						alert("서버 장애입니다.. 잠시후 다시 시도해주세요");	
						alert(data.resultMsg);
					}
				
				}
			});
		}
	};
	
	
	$("#login_button").click(function(){
		if(document.getElementById("input_id").value == "") {
			alert("아이디를 입력해주세요");
			return;
		}
		if(document.getElementById("input_password").value == ""){
			alert("비밀번호를 입력해주세요");
			return;
		}
		var formData = $("#loginForm").serialize();
		$.ajax({
			type: "post",
			url: "loginTry.do",
			data: formData,
			dataType: "json",
			success: function (data) 
			{
				//alert(data.isLogin);
				if(data.isLogin)//로그인 된 상태라면..?
				{
					alert(data.resultMsg);
				}
				else if(!data.isLogin)	//로그인 된 상태가 아니라면
				{
					//alert(data.isSuccess);
					if(data.isSuccess)	//로그인에 성공하나요?
					{
						//alert(data.isAdmin);
						//성공했다면 관리자인지 ? 일반 사용자인지??
						if(data.isAdmin)	//관리자라면
						{
							document.getElementById("loginForm").action="loginAdmin.do";
							document.getElementById("loginForm").submit();
						}
						else				//일반 사용자라면
						{
							document.getElementById("loginForm").action="loginComplete.do";
							document.getElementById("loginForm").submit();
						}
					}
				}
				else
				{
					alert("서버 장애입니다.. 잠시후 다시 시도해주세요");	
					alert(data.resultMsg);
				}
					
			}
		});
	});
	
});
</script>
<style type="text/css">@import url(/Soloud/css/login.css);</style>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
</head>
<body>
<div class="section">
<form method="post" action="login.do" id='loginForm' name='loginForm'>
	<input type="text" class="id_textField" id="input_id" placeholder=" Soloud계정(E-mail)" name="input_id" required/>
	<input type="password" class="pwd_textField" id="input_password" placeholder=" 비밀번호" name="input_password" required/>
	<img src="/Soloud/image/login/login_button.png" id="login_button" title="로그인 시도" style="cursor: pointer;"> 
</form>
</div>
	<p><a href="join_first">회원가입</a>&nbsp;&nbsp;&nbsp; 
	<a href="#"> Soloud 계정 찾기 </a> 
	<a href="#"> 비밀번호 찾기</a></p>
</body>
</body>
</html>