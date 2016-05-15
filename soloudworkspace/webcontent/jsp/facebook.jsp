<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
	function test()
	{
		$.ajax({
			type: "post",
			url: "/Soloud/encFolderLink.do",
			data:{password : $("#folder_password").val(), folderCode : selectedFolder},
			//data: formData,
			dataType: "json",
			success: function (data) {
				if(data.result)
				{
					alert(data.encryptedFolderCode);
					callFaceBook(data.encryptedFolderCode);
				}
				else
				{
					alert(data.resultMsg);
				}
			}
		});
	}
		
	function callFaceBook(encFolderCode)
	{
		alert("들어옴?!");
		alert(encFolderCode);
		FB.ui(
	    		  {
	    		   method: 'feed',
	    		   message: 'Soloud',
	    		   name: '폴더링크 공유',
	    		   link: 'http://192.168.145.1:8089/Soloud/decFolderLink.do/link' + encFolderCode,
	    		   //link: 'http://www.abcdefg.com/abcde/efgh/abcde',
	    		   user_message_prompt: 'Share your thoughts about naver'
	    		  },
	    		  function(response) {
	    		    if (response && response.post_id) {
	    		      alert(response.post_id);
	    		    } else {
	    		      alert('Post was not published.');
	    		    }
	    		  }
	    		);
	}
	
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '535526033236883', // App ID
      channelUrl : 'http://192.168.145.1/', // Channel File
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the session
      xfbml      : true  // parse XFBML
    });
   
    
  };

  // Load the SDK Asynchronously
  (function(d){
     var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement('script'); js.id = id; js.async = true;
     js.src = "//connect.facebook.net/en_US/all.js";
     ref.parentNode.insertBefore(js, ref);
   }(document));
	
  
  
  $(document).ready(function(){
	  $(function() {
			$("#facebook_dialog").dialog({
				autoOpen : false,
				width : 300,
				height : 150,
				show: 
				{
			        effect: "blind",
			        duration: 200
			    },
			    hide:
			    {
			        effect: "explode",
			        duration: 200
			    },
				buttons :
				{
					"공유" : function() 
					{
						test();
						$(this).dialog("close");
				
					},
					"취소" : function() 
					{
						$(this).dialog("close");
					}
				},
				close : function() 
				{
					$(this).dialog("close");
				}
			});
		
	  });

  
  $("#facebook").click(function() {
	  	if(selectedFolder ==='폴더를 선택해주세요')
	  	{
	  		alert("내 웹하드에서 링크를 공유하고자 하는 폴더를 선택해주세요!!");
	  	}
	  	else
	  	{
	  		$("#facebook_dialog").dialog("open");
	  	}
	});
  });
</script>
<style>
#facebook
{
	position:relative;
	z-index:100;
	

	width:25px;
	height:25px;
	cursor: pointer;
}
</style>
</head>
<body>
<div id="fb-root"></div>

<div id="facebook_dialog" title="폴더 비밀번호 설정" style='display: none; '>
	<fieldset>
		<table class="share_facebook_table">
			<tr>
				<td>비밀번호 : </td><td><input id='folder_password' type="text"></td>
			</tr>
		</table>
	</fieldset>
</div>
</body>
</html>