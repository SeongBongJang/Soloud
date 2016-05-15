<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="/Soloud/script/jquery.js"></script>
<script src='/Soloud/script/friendListRecommendTable.js'
	type='text/javascript'></script>
</head>
<style>
a {
	font-size: 17px;
	text-decoration: none;
	color: gray;
}

a:HOVER {
	color: red;
}

.name_field {
	width: 100px;
	height: 20px;
	margin: auto;
	font-size: 13px;
}

p {
	display: inline;
	font-size: 15px;
	color: gray;
}
</style>
<style>

body {
	font-family: 'Nanum Gothic', sans-serif;
	margin: 0px auto;
}

table.friend_recommend_table {
	margin: auto;
	width: 800px;
	color:black;
	padding-left: 30px;
	padding-right: 30px;
	border-width: 2px;
	border-color: #E6E6E6;
	border-left-style: solid;
	border-right-style: solid;
}
table.title_table {
	margin: auto;
	width: 800px;
	text-align: center;
	padding-left: 30px;
	padding-right: 30px;
	border-width: 2px;
	border-color: #E6E6E6;
	border-left-style: solid;
	border-right-style: solid;
}

table tr td.proposal_info {
	text-align: left;
	color: gray;
}

img{cursor: pointer;}

#recommend_dialog{
	display: none;
}
#refuse_check_dialog{
	display: none;
}


</style>
<body>


	<c:import url="titleBar.jsp" />
<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<table class="title_table">
		<tr>
			<td></td>
			<td><img src="/Soloud/image/icon/people23.png" /></td>
			<td></td>
			<td>

				<h1>${member.name}</h1> <!-- 여기에 이름을 넣는다. --> <br>
				<h2>
					<strong>${member.id }</strong>
					<!-- 여기에 아이디를 넣는다. -->
				</h2>
			</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"><a href="loadFriendList.do">내 친구 </a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendReceive.do"  style="color: orange;"><span>받은 제안</span></a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendSend.do">보낸 제안</a>&nbsp;
				<p>|</p>&nbsp; <a href="searchMemberPage.do">친구 찾기</a>&nbsp;
				<p>|</p>&nbsp;</td>
			<td>
				<input type="text" name="name" class="name_field" id="recommend_search_field" width="400px" placeholder="아이디 or 이름" value =""/>&nbsp;&nbsp;&nbsp;
				<img src="/Soloud/image/friends/search2.png" height="30px" 	width="60px" align="top" class="friend_search_button2" />
			</td>
		</tr>
	</table>
	<table class ="friend_recommend_table" id = "friend_recommend_table">
	<tr></tr>
		<c:forEach var="friendProposal" items="${friendProposalList}">
			<tr class="proposallist_tr" id="${friendProposal.senderId}">
				<td id="${friendProposal.senderName}" style="width: 210px">
					<img src="/Soloud/image/icon/people22.png" width="80px" /></td>
				<td class="proposal_info" id="${friendProposal.senderName}" style="width: 245px">
				<p class="friend_name">${friendProposal.senderName}&nbsp;&nbsp;</p><br>
					(${friendProposal.senderId})</td>
				<td style ="text-align: center;">
					<img src="/Soloud/image/friends/accept2.png" height="30px"align="bottom" class="accept2_button" id="accept2_button"> 
					<img src="/Soloud/image/friends/refuse2.png" height="30px" align="top"  class="refuse2_button" id="refuse2_button">
				</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
	<!-- 다이얼 로그 -->
	
	<div id="recommend_dialog" title ="친구 제안" >
		<fieldset>
				<table class="group_modify_table">
					<tr>
						<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;" >친구 아이디 (E-mail) :<p id="friendIdInfo"></p></td>
					</tr>
					<tr>
						<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;" >친구 이름 :<p id="friendNameInfo"></td>
					</tr>
				</table>
		</fieldset>
	
	</div>
	
</body>
</html>