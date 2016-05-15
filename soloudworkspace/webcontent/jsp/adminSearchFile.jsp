<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 파일 관리 페이지</title>

<!-- 스크립트 플러그인 -->
<script src="/Soloud/script/jquery/jquery.js"></script>
<script src="/Soloud/script/jquery/jquery-ui.js"></script>
<script src='/Soloud/script/context/jquery.contextmenu.js' type='text/javascript'></script>
<script src='/Soloud/script/admin.js/adminFile.js' type='text/javascript'></script>
<!-- css 파일 -->
<link href="/Soloud/css/table.css" type="text/css" rel="stylesheet"/>
<link href="/Soloud/css/admin/jquery-ui.css" type='text/css' rel='stylesheet'/>
<link href='/Soloud/css/jquery.contextmenu.css' type='text/css' rel='stylesheet' />
<link href='/Soloud/css/titleBar.css' type='text/css' rel='stylesheet'/>
<link href='/Soloud/css/adminTable.css' type='text/css' rel='stylesheet'/>
<style type="text/css">@import url(/Soloud/css/nanum.css);</style> 

</head>
<body>
<!-- 상단 바 -->
<div id="top">
		<form id="fileForm" action='reEnter.do'>
	<img src="/Soloud/image/titleBar/newTitleBar.png" alt="마크" width="426" height="43" align="left" id="refresh" style="cursor: pointer;"/></form>
	</form>
	<div align="right">
		<div align="right">
			<div id="profile2"></div>
			<img src="/Soloud/image/titleBar/profile2.png" alt="프로필2" width="164" height="39" align="right" style="cursor: pointer;"/>
		</div>
		<div id='logManage'>
			<a href="/Soloud/logout.do"><img id='logManageButton' alt='접속관리'align='right' src="/Soloud/image/admin/keyhole.png" width="27" height="39" style="cursor: pointer;"/></a>
		</div>
		<div id="fileManage" style="display:inline">
			<form id="fileForm" action='reEnter.do'><img id='fileManageButton' alt='파일관리' align="right" src="/Soloud/image/admin/adminFile.png" width="45" height="50" alt="알림" style="cursor: pointer;"/></form>
		</div>
		<div id="memberManage" style="display:inline">
			<form id="memberForm" action='adminSearchMember.do'><img id='memberManageButton' alt='회원관리' align="right" src="/Soloud/image/admin/adminMember.png" width="55" height="50" alt="친구" style="cursor: pointer;"/></form>
		</div>
	</div>
</div>
<br><br><br><br>
<div id='center'>
<!-- 검색조건 -->
<div id='searchCondition'>
<form id='searchForm' method='post' action='adminSearchFile.do'>
	<table style="margin:0 auto;">
		<tr>
			<td>파일유형</td>
			<td>
			<select id='selectFormat' name='selectType'>
				<option value='all'>전체</option>
				<option value='document'>문서</option>
				<option value='music'>음악</option>
				<option value='image'>이미지</option>
				<option value='video'>비디오</option>
				<option value='etc'>기타</option>
			</select>
			</td>
			
			<td>파일명</td>
			<td style="width:250px"><input id='text' style="width:90%"name='fileName' type='text'/></td>
			<td><img src='/Soloud/image/admin/searchButton.png' id='searchButton' style='cursor:pointer;width:30;height:30;'onclick='searchFile()'/></td>
		</tr>
	</table>
</form>		
</div>	
<!-- 검색결과 리스트 -->
<div id='resultDiv'>
	<table id='resultTable'>
		<tr>
			<th width="40" style="border-width:2px; border-left-style:none; border-right-style:none; border-top-style:none; border-bottom-style:solid; height: 40px; " scope="col"><input id='allSelect' type="checkbox" onclick="checkFunction()"/></th>
			<th width="40" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;번호</th>
			<th width="40" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;code</th>
   		    <th width="100" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;종류</th>
			<th width="100" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;파일명</th>
			<th width="100" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;업로드날짜</th>
			<th width="100" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;이름</th>
			<th width="200" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;이메일</th>
			<th width="200" style="border-width:2px; border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;용량</th>
			</tr>
		</table>
	</div>
</div>
<div id="fileNameModify" title="파일이름변경" style="font-size:x-small;display:none"> 
<fieldset>
	<table>
		<tr>
			<td style="font-size:x-small;">파일이름 : </td><td><input type="text" id='beforeName'></td>
		</tr>
	</table>
</fieldset>
</div>
</body>
</html>


