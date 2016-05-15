
<?xml version="1.0" encoding="UTF-8" ?>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

  <script type="text/javascript" src="/Soloud/tree/dftree.js"></script>
	<link rel="stylesheet" type="text/css" href="/Soloud/tree/dftree.css">


	<style type="text/css">
		@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	</style>  
</head>
<script>
jQuery(document).ready(function()
{
	  var password = prompt("Insert this Folder Password");
	    
	    if (password != '') 
	    {
	    	$("#pass").val(password);
	    	document.getElementById("tmpForm").action="file_link";
			document.getElementById("tmpForm").submit();
	    }
	    else if(password=='')
		{
	    	document.getElementById("demo").innerHTML ='비밀번호를 입력하세요';
		}
});
</script>
<div id='demo'></div>

<form id='tmpForm' method="post">
<input type='text' name='password' id='pass' hidden='true'/>
</form>

</body>

</html>
