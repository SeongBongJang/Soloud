<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>알림목록보기</title>
<style type="text/css">@import url(/Soloud/css/alramList.css);</style>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
</head>

<body>
	<div id="alram_list" style ="position:absolute; top: 70px; right: 30px;">
	<table class="alram_table" id="alram_table" style='position: absolute; z-index: 1000; right:60px'>
		<thead>
		<tr>
			<td>최근 알림</td>
		</tr>
		</thead>
	</table>
	</div>
</body>
</html>