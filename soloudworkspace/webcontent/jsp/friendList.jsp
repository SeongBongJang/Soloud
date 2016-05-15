<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<!-- 폰트(나눔고딕) -->
<style type="text/css">
		@import url(/Soloud/css/nanum.css);</style>
	<script src="/Soloud/script/jquery.js"></script>
<script src='/Soloud/script/friendList.js' type='text/javascript'></script>

<meta charset="utf-8">
<title>무제 문서</title>
</head>
<style>

table.friend_main_table{
	font-family: 'Nanum Gothic', sans-serif;
	display:block;
	margin: auto;
	width:800px;
	text-align: center;
	padding-left : 30px;
	padding-right : 30px;
	border-width:2px;
	border-color: #E6E6E6;
	border-left-style: solid; 
	border-right-style: solid;	
}
#friend_form{
	
}

a{
	font-size: 17px; 
	text-decoration: none;
	color: gray;
}
a:HOVER {
	color: red;
}
.name_field{
	width: 100px;
	height: 20px;
	margin: auto;
	font-size: 13px;

}
p{
	display : inline;
	font-size: 15px;
	color: gray;
}

</style>
<!-- body -->
<body>

<div id="friend_form">
<c:import url="titleBar.jsp"/>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<table class="friend_main_table">
		<!-- 상단 ---------------------------------------------------------------- -->
		<tr>
			<td><img src="/Soloud/image/friends/people.jpg" /></td>
			<td colspan="2">

				<h1>${member.name}</h1> <!-- 여기에 이름을 넣는다. --> <br>
				<h2>
					<strong>${member.id }</strong>
					<!-- 여기에 아이디를 넣는다. -->
				</h2>
			</td>
		</tr>
		<tr>
			<td colspan="2"><a href="loadFriendList.do">내 친구 </a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendReceive.do">받은 제안</a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendSend.do">보낸 제안</a>&nbsp;
				<p>|</p>&nbsp; <a href="searchFriend.do">친구 신청</a>&nbsp;
				<p>|</p>&nbsp;</td>
			<td>
				<input type="text" name="name" class="name_field"  placeholder="아이디 or 이름" />&nbsp;&nbsp;&nbsp;
				<img src="/Soloud/image/friends/search2.png" height="30px" 	width="60px" align="top" class="friend_search_button3" />
			</td>
		</tr>
		<!-- 하단------------------------------------------------------------------------ -->
		<c:forEach var = "MEMBER" items="${friendProposalList}">
		<tr class="Requestlist_tr" id="${friendProposal.receiverId}">
			<td><img src="/Soloud/image/friends/people.jpg" width="50px"/></td>
			<td class="my_proposal_info">
					<span class="friend_name">${friendProposal.receiverName}</span>(${friendProposal.receiverId})
			</td>
			<td><img src="/Soloud/image/friends/rquestCancel2.png" height="30px" width="100px" class="friend_requestCancel_button"></td>
		</tr>
	</c:forEach>
	</table>
</div>
</body>
</html>