<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<!-- 폰트(나눔고딕) -->	
<style type="text/css">
		@import url(/Soloud/css/nanum.css);</style>  

</head>
<style>
#accept_dialog{
	display: none;
}
.accept_dialog{
	margin : 0 auto;
	font-size: 16px;
}
</style>
<body>
	<!-- ----------------------------------dialog----------------------------------------------------------------- -->
	<div style="display:none" id="accept_dialog" title ="친구 수락">
		<fieldset>
				<table class="accept_dialog">
					<tr>
						<td style=font-family: Nanum Gothic, sans-serif;'>이름  : </td>
						<td style=font-family: Nanum Gothic, sans-serif;'><p id = "name2"></p><td>
					</tr>
					<tr>
						<td style=font-family: Nanum Gothic, sans-serif;'>아이디  : </td>
						<td style=font-family: Nanum Gothic, sans-serif;'><p id = "id2"></p><td>
					</tr>
				</table>
		</fieldset>
	</div>
</body>
</html>