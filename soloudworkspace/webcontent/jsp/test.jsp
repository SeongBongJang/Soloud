
<?xml version="1.0" encoding="UTF-8" ?>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
  <script type="text/javascript" src="/Soloud/tree/dftree.js"></script>
	<link rel="stylesheet" type="text/css" href="/Soloud/tree/dftree.css">
	<style>
  .toggler { width: 500px; height: 200px; }
  #button { padding: .5em 1em; text-decoration: none; }
  #effect { width: 240px; height: 135px; padding: 0.4em; position: relative; }
  #effect h3 { margin: 0; padding: 0.4em; text-align: center; }
    </style>
<style type="text/css">
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
  </style>
  
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	</style>  
  <script>
  var list_data = [];
  window.onload = function() {
		document.getElementById("file_search").style.display = "none"
  };
  $(document).ready(function(){
		$(".list_table").hover(
			function(){
				$(this).css("background", "pink");}, function(){
					$(this).css("background", "none");
		});
	});
  $(document).ready(function(){
	  $(".list_table").on("click", 
				function(){
		  				$(this.childNodes).css("background", "pink");
		  				list_data.push($(this.childNodes));
		  				alert($(this.childNodes)[0].val);
			});	
	});
 	

  $(function() {
	    // run the currently selected effect
	    function runEffect() {
	      // get effect type from
	      var selectedEffect = $( "#effectTypes" ).val();
	 
	      // most effect types need no options passed by default
	      var options = {};
	      // some effects have required parameters
	      if ( selectedEffect === "scale" ) {
	        options = { percent: 100 };
	      } else if ( selectedEffect === "size" ) {
	        options = { to: { width: 280, height: 185 } };
	      }
	 
	      // run the effect
	      $( "#effect" ).show( selectedEffect, options, 500, callback );
	    };
	 
	    //callback function to bring a hidden box back
	    function callback() {
	      setTimeout(function() {
	        $( "#effect:visible" ).removeAttr( "style" ).fadeOut();
	      }, 1000 );
	    };
	 
	    // set effect from select menu value
	   $( "#search" ).button().on( "click", function() {
		   if(document.getElementById("file_search").style.display=="none"){
			   document.getElementById("file_search").style.display = "inline"
		   }
		   else{
			   document.getElementById("file_search").style.display = "none"
		   }
		});
	 
	    $( "#effect" ).hide();
	  });
    
  </script>
  <style>
    body { font-size: 62.5%;  }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  </style>
  <script>
  $(function() {
	    var dialog, form,
	 
	      emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
	      name = $( "#name" ),
	      email = $( "#email" ),
	      password = $( "#password" ),
	      allFields = $( [] ).add( name ).add( email ).add( password ),
	      tips = $( ".validateTips" );
	 
	    function updateTips( t ) {
	      tips
	        .text( t )
	        .addClass( "ui-state-highlight" );
	      setTimeout(function() {
	        tips.removeClass( "ui-state-highlight", 1500 );
	      }, 500 );
	    }
	 
	    function checkLength( o, n, min, max ) {
	      if ( o.val().length > max || o.val().length < min ) {
	        o.addClass( "ui-state-error" );
	        updateTips( "Length of " + n + " must be between " +
	          min + " and " + max + "." );
	        return false;
	      } else {
	        return true;
	      }
	    }
	 
	    function checkRegexp( o, regexp, n ) {
	      if ( !( regexp.test( o.val() ) ) ) {
	        o.addClass( "ui-state-error" );
	        updateTips( n );
	        return false;
	      } else {
	        return true;
	      }
	    }
		
	    function addUser() {
	      var valid = true;
	      allFields.removeClass( "ui-state-error" );
	 
	      valid = valid && checkLength( name, "username", 3, 16 );
	      valid = valid && checkLength( email, "email", 6, 80 );
	      valid = valid && checkLength( password, "password", 5, 16 );
	 
	      valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
	      valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
	      valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
	 
	      if ( valid ) {
	      
	        dialog.dialog( "close" );
	      }
	      return valid;
	    }
	 
	    dialog = $( "#dialog-form" ).dialog({
	      autoOpen: false,
	      height: 570,
	      width: 500,
	      modal: true,
	      buttons: {
	        "전송": addUser,
	        "취소": function() {
	          dialog.dialog( "close" );
	        }
	      },
	      close: function() {
	        form[ 0 ].reset();
	        allFields.removeClass( "ui-state-error" );
	      }
	    });
	 
	    form = dialog.find( "form" ).on( "submit", function( event ) {
	      event.preventDefault();
	      addUser();
	    });
	 
	    $( "#upload" ).button().on( "click", function() {
	      dialog.dialog( "open" );
	    });
	    
	    $( "#download" ).button().on( "click", function() {
		      dialog.dialog( "open" );
		});
	    
	    $( "#friend" ).button().on( "click", function() {
		      dialog.dialog( "open" );
		});
	    
	    $( "#play" ).button().on( "click", function() {
		      dialog.dialog( "open" );
		});
	    
	    
	  });
  </script>
</head>
<body>
<div id="top">
	    <img src="image/titleBar/마크.png" alt="마크" width="426" height="43" align="left" />
	    <div align="right">
	      	<img src="image/titleBar/프로필2.png" alt="프로필2" width="164" height="39" align="right" />
	        <img align="right" src="image/titleBar/프로필.png" width="27" height="39" alt="프로필" />
	        <img align="right" src="image/titleBar/말풍선2.png" width="57" height="50" alt="알림" />
	   		<img align="right" src="image/titleBar/친구신청2.png" width="60" height="44" alt="친구" />    
	   	</div>
    </div>
  	<div style="position: absolute; width: 368px; height: 686px; border: 2px; border-color: #999; border-style: solid; left: 57px; top: 161px;">
	  
  	  <div style="position: absolute; left: -12px; top: -71px;">
        <div style="position: absolute; left: 10px; top: 18px; width: 336px; height: 64px;">
       	  <div style="margin-bottom:2px; ">
            	<div id="leftPro" style="display:inline;">
                    1.45GB&nbsp/&nbsp
           		</div>
         		<div id="rightPro" style="display:inline;">
                    2.5GB
                </div>
          </div>
	  	  <div style="float:left; margin-top:2px; ">
       	  		<progress id="pro" value="65" max="100"></progress>
          </div>
          <div >
               &nbsp;&nbsp;&nbsp;<img src="image/main/플러스.png" width="17" height="18" alt="더보기1" />
          </div>
        </div>
      </div>
	    <div style="position: absolute; border: 2px; border-color: #999; border-bottom-style: solid; width: 368px; height: 333px;">    
	
	     	<span style="position: absolute; left: 13px; top: 13px;"><img src="image/main/내트리구조.png" width="193" height="32" alt="내트리" /></span>
	      
	      	<span style="position: absolute; left: 9px; top: 352px;"><img src="image/main/공유폴더.png" width="196" height="39" alt="공유트리" /></span>      	
	        <div id="내트리" style="position: absolute; width: 330px; height: 266px; left: 18px; top: 51px;">
	
			  <script language="javascript">
				    <!--
				    tree = new dFTree({name: 'tree',useIcons:true, icondir:'tree'});
				    
				    tree.add(new dNode({id: '0',caption: 'Catalogues', url: 'http://dftree.sourceforge.net/'}),-1); //root node
				    
				    tree.add(new dNode({id: '1',caption: 'My folder1'}),0);
				    tree.add(new dNode({id: '2',caption: 'My folder2'}),0);
				    tree.add(new dNode({id: '3',caption: 'My folder2'}),2);
				    tree.add(new dNode({id: '4',caption: 'My folder2'}),2);
				    tree.add(new dNode({id: '5',caption: 'My folder2'}),4);
				    tree.add(new dNode({id: '6',caption: 'My folder2'}),4);
				    tree.add(new dNode({id: '7',caption: 'My folder2'}),6);
				    tree.add(new dNode({id: '8',caption: 'My folder2'}),7);
				    tree.add(new dNode({id: '9',caption: 'My folder2'}),8);
				    tree.add(new dNode({id: '10',caption: 'My folder2'}),9);
				    
				    tree.draw();
				    -->
			    </script>
		  	</div> 
	    </div>
	    <div id="공유트리" style="position: absolute; width: 330px; height: 267px; left: 20px; top: 404px;">
		  <script language="javascript">
			    <!--
			    tree2 = new dFTree({name: 'tree2',useIcons:true, icondir:'tree'});
			    
			    tree2.add(new dNode({id: '100',caption: 'Catalogues', url: 'http://dftree.sourceforge.net/'}),-1); //root node
			    
			    tree2.add(new dNode({id: '101',caption: 'My folder1'}),100);
			    tree2.add(new dNode({id: '102',caption: 'My folder2'}),100);
			    tree2.add(new dNode({id: '103',caption: 'My folder2'}),102);
			    tree2.add(new dNode({id: '104',caption: 'My folder2'}),102);
			    tree2.add(new dNode({id: '105',caption: 'My folder2'}),104);
			    tree2.add(new dNode({id: '106',caption: 'My folder2'}),104);
			    tree2.add(new dNode({id: '107',caption: 'My folder2'}),106);
			    tree2.add(new dNode({id: '108',caption: 'My folder2'}),107);
			    tree2.add(new dNode({id: '109',caption: 'My folder2'}),108);
			    tree2.add(new dNode({id: '110',caption: 'My folder2'}),109);
			    
			    
			    tree2.draw();
			    -->
			</script>
	    </div>
	</div>
	<div id="menu" align="center" style="position: absolute; width: 645px; height: 753px; z-index: 1; border-width: 2px; border-color: #E6E6E6; border-left-style: solid; border-right-style: solid"  >
		
	  <img id="upload" src="image/main/업로드.png" width="100" height="54" alt="업로드" />
	  <img id="download" src="image/main/다운로드.png" width="99" height="54" alt="다운로드" />
	  <img id="search" src="image/main/검색.png" width="100" height="54" alt="검색" />
	  <img id="friend" src="image/main/친구.png" width="100" height="54" alt="친구" />
	  <img id="play" src="image/main/플레이.png" width="100" height="54" alt="플레이" />
	  <div id="fileDiv">
	  <div id='file_search' >
			<select style="font-family: 'Nanum Gothic', sans-serif;">
			    <option>파일명</option>
			    <option>업로더 이름</option>
			    <option>업로더 이메일</option>
			</select>
			
			<select style="font-family: 'Nanum Gothic', sans-serif;">
				<option>파일전체</option>
			    <option>비디오</option>
			    <option>오디오</option>
			    <option>이미지</option>
			    <option>문서</option>
			    <option>기타</option>
			</select>
			
			<input type="text" id="search_text" style="display:inline; font-family: 'Nanum Gothic', sans-serif;" placeholder="검색 내용"/>
			<input type="button" id="search_button" style="display:inline; font-family: 'Nanum Gothic', sans-serif;" value='검색'/>
			<br><br><br>
		</div>
		<table width="511" border="1" id='fileTable'>
		  <tbody>
		    <tr>
		      <th width="156" style="border-style:none; height: 40px; "; scope="col">&nbsp;이름</th>
		      <th width="87" style="border-top-style:none; border-right-style:none; border-bottom-style:none; height: 40px;"; scope="col">&nbsp;유형</th>
		      <th width="246" style="border-top-style:none; border-right-style:none; border-bottom-style:none; height: 40px;"; scope="col">&nbsp;마지막 수정날짜</th>
		    </tr>
		    <tr class="list_table" id="바보">
		      <td class="이름">&nbsp;유다.uml</td>
		      <td class="유형">&nbsp;기타</td>
		      <td class="시간">&nbsp;2014/07/14 am 10:34</td>
		    </tr>
		    <tr class="list_table">
		      <td class="이름">&nbsp;키추출.xls</td>
		      <td class="유형">&nbsp;문서</td>
		      <td class="시간">&nbsp;2014/07/14 am 10:42</td>
		    </tr>
		    <tr class="list_table">
		      <td class="이름">&nbsp;Main.jpg</td>
		      <td class="유형">&nbsp;이미지</td>
		      <td class="시간">&nbsp;2014/07/14 pm 02:34</td>
		    </tr>
		    <tr class="list_table">
		      <td class="이름">&nbsp;후보군.docx</td>
		      <td class="유형">&nbsp;문서</td>
		      <td class="시간">&nbsp;2014/07/14 pm 04:40</td>
		    </tr>
		    <tr class="list_table">
		      <td class="이름">&nbsp;유다.uml</td>
		      <td class="유형">&nbsp;기타</td>
		      <td class="시간">&nbsp;2014/07/14 am 10:34</td>
		    </tr>
		    <tr class="list_table">
		      <td class="이름">&nbsp;키추출.xls</td>
		      <td class="유형">&nbsp;문서</td>
		      <td class="시간">&nbsp;2014/07/14 am 10:42</td>
		    </tr>
		    <tr class="list_table">
		      <td class="이름">&nbsp;Main.jpg</td>
		      <td class="유형">&nbsp;이미지</td>
		      <td class="시간">&nbsp;2014/07/14 pm 02:34</td>
		    </tr>
		    <tr class="list_table">
		      <td class="이름">&nbsp;후보군.docx</td>
		      <td class="유형">&nbsp;문서</td>
		      <td class="시간">&nbsp;2014/07/14 pm 04:40</td>
		    </tr>
		</table>
	
		<div id="dialog-form" title="업로드">
			 <form><br>
				업로드 할 파일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" style="display:inline;"><br><br>
				권한 범위&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select id='scope'>
						  <option>나만보기</option>
				          <option>절친</option>
				          <option>친구</option>
				          <option>어색한 친구</option>
				    </select><br><br>
				파일 설명<br><textarea cols="60" rows="20" draggable="false" > </textarea><br></br>
				태그 <input type="text" style="display:inline; width:355px"></input>
			</form>
		</div>
		<div class="toggler">
		  <div id="effect" class="ui-widget-content ui-corner-all">
		    <h3 class="ui-widget-header ui-corner-all">Show</h3>
		    <p>
		      Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
		    </p>
		  </div>
		</div>
	</div>
</body>
</html>
