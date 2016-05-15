<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 회원관리 페이지</title>
<!-- 스크립트 플러그인 -->
<script src="/Soloud/script/jquery/jquery.js"></script>
<script src="/Soloud/script/jquery/jquery-ui.js"></script>
<script src='/Soloud/script/context/jquery.contextmenu.js' type='text/javascript'></script>
<script src='/Soloud/script/admin.js/adminMember2.js' type='text/javascript'></script>

<!-- css 파일 -->
<link href="/Soloud/css/admin/jquery-ui.css" type='text/css' rel='stylesheet'/>
<link href='/Soloud/css/jquery.contextmenu.css' type='text/css' rel='stylesheet' />
<link href='/Soloud/css/titleBar.css' type='text/css' rel='stylesheet'/>
<link href='/Soloud/css/adminTable.css' type='text/css' rel='stylesheet'/>
<link href="/Soloud/css/table.css" type="text/css" rel="stylesheet"/>
<style type="text/css">@import url(/Soloud/css/nanum.css);</style>
</head>
<body>
<!-- 상단 바 -->
<div id="top">
<form id="fileForm" action='reEnter.do'>
	<img src="/Soloud/image/titleBar/newTitleBar.png" alt="mark" width="426" height="43" align="left" id="refresh" style="cursor: pointer;"/></form>
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
	<!-- 검색조건 div -->
	<div id='searchCondition'>
	<form id='searchForm' action='*.do' method='post'>
	<table style="margin:0 auto;">
		<tr>
			<td>
				<select id='select' name="selectType" style="width:66px;font-family: 'Nanum Gothic', sans-serif;"  >
					<option  class='searchOption' style="size: 50;font-family: 'Nanum Gothic', sans-serif;" value='all'>전체</option>
					<option  class='searchOption' style="size: 50;font-family: 'Nanum Gothic', sans-serif;" value='id'>아이디</option>
					<option  class='searchOption' style="size: 50;font-family: 'Nanum Gothic', sans-serif;" value='name'>이름</option>
				</select>
			</td>
			<td style="width:250px"><input id='text' type='text' style="width:90%"name="inputType"/></td>
			<td style="width:50px;"><img src='/Soloud/image/admin/searchButton.png' id='searchButton' style='cursor:pointer;'onclick='searchMember()'/></td>
		</tr>
	</table>
	</form>
	</div>
	<!-- 검색결과 div -->
	<div id="resultDiv">
		<table id='resultTable'>
    		<tr>
        		<th width="30" style="border-bottom-style:solid;height: 40px; " scope="col">&nbsp;No</th>
	        	<th width="200" style="border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;아이디</th>
	            <th width="100" style="border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;이름</th>
	            <th width="100" style="border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;비밀번호</th>
	            <th width="100" style="border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;용량제한</th>
	            <th width="100" style="border-left-style:solid; border-top-style:none; border-right-style:none; border-bottom-style:solid; height: 40px;" scope="col">&nbsp;현재사용량</th>
            </tr>
        </table>
	</div>
</div>
<div id="dropConfirm" title="회원탈퇴시키기" style="display:none"> 
<br>
<fieldset>
	<table>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>정말로 탈퇴시키겠습니까?</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
	</table>
</fieldset>
</div>
<div id="modifyMemberInfo" title="회원정보변경" style="display:none"> 
<br>
<fieldset>
	<table>
		<tr>
			<td>ID</td><td colspan='2'><input id='memberId' type='text' name='memberId' disabled="disabled"></td>
		</tr>
		<tr>
			<td>이름</td><td colspan='2'><input type='text' name='memberName' id='memberName'></td>
		</tr>
		<tr>
			<td>비밀번호</td><td colspan='2'><input type='text' name='memberPassword' id='memberPassword'></td>
		</tr>
		<tr>
			<td>현재용량</td><td colspan='2'><input type='text' name='memberUsedCapacity' disabled="disabled" id='memberUsedCapacity'></td>
		</tr>
		<tr>
			<td>최대용량</td><td colspan='2'><input style="width:100px"type='number' name='memberLimitCapacity' id='memberLimitCapacity'></td>
			<td>MB</td>
		</tr>
	</table>
</fieldset>
</div>
</body>
</html>


