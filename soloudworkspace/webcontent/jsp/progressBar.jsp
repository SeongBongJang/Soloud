<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.wapforum.org/DTD/xhtml-mobile12.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="minimum-scale=1.0,maximum-scale=1.0,initial-scale=1.0,user-scalable=no" />
<title>FileUpload Test Form</title>
<style type="text/css">
div#viewLoading {text-align:center;padding-top:120px;filter:alpha(opacity=60);opacity: alpha*0.6;background-color:#222222;color:#bcbfc4;}
div#viewLoading div.progressTitle{text-align:left;border:2px solid #111111;border-bottom:1px solid #111111;padding:15px 0 15px 0;width:99.2%;}
div#viewLoading div.progressTitle span{padding-left:3px;padding-bottom:5px;}
div#viewLoading div.progressWrapper{border:1px solid #111111;width:99.2%;text-align:center;}
div#viewLoading div.progressWrapper div.progresspercent{background-color:#1a1a1a;height:40px;border:1px solid #000000;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper{line-height:38px;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper span.pgbar{display:block;float:left;background-color:#fecf23;width:90%;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper span.pgpercent{position:absolute;left:30%;right:30%;color:#c0c0c0;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper span.pgpercent strong{font-weight:bold;}
div#viewLoading div.progressfilereadsize{margin:0 0 5px 0;height:40px;border:1px solid #111111;}
div#viewLoading div.progressfilereadsize span{line-height:40px;}
div#viewLoading div.progressfilereadsize span.divider strong{font-weight:400;}
div#viewLoading div.progressSpeed{margin:0 0 5px 0;height:40px;border:1px solid #111111;text-align:center;}
div#viewLoading div.progressSpeed span.kbps{line-height:40px;}
div#viewLoading div.progressSpeed span.kbps strong{font-weight:400;}
.pgbarbgcolor{background-color:#fecf23;}
</style>
<script type="text/javascript">
$(function(){
	
	//ajax Progress image view Elem
	var viewLoadingImgElem = $("div#viewLoading");
	$(viewLoadingImgElem).hide();	//초기로딩시에는 이미지를 숨긴다.
	
	var intervalID = 0;
	//ajax 요청시작과 완료시의 프로그레스 이미지 element의 동작
	$(viewLoadingImgElem).ajaxStart(function(){
		// 로딩이미지의 위치 및 크기조절	
		$(viewLoadingImgElem).css('position', 'absolute');
		$(viewLoadingImgElem).css('left', $("body").offset().left);
		$(viewLoadingImgElem).css('top', $("body").offset().top);
		$(viewLoadingImgElem).css('width', "100px");
		$(viewLoadingImgElem).css('height', "100px");
				
		intervalID = setInterval(function(){			
			getFileUploadProgress();	//ajax요청중에 파일업로드 상태를 주기적으로 요청한다.	
		},50);
		$(this).fadeIn(250);
	}).ajaxStop(function(){		
		clearInterval(intervalID); //Stop updating		
		$(this).fadeOut(250);
	});					

	//파일업로드 상태를 주기적으로 확인해서 가져온다.
	var getFileUploadProgress = function(){
		$.ajax({
			url : 'uploadStatus.go',
			success : function(jsonData){

				$(viewLoadingImgElem).html(										
						"<div class='progressTitle'>" +
						"	<span><strong>업로드 진행상태</strong></span>" +		
						"</div>" +
						"<div class='progressWrapper'>" +
						"	<div class='progresspercent'>" +
						"		<span class='percentwrapper'>"+
						"			<span class='pgbar'>&nbsp;</span>"+
						"			<span class='pgpercent'><strong>"+ jsonData.percent+"%</strong></span>" +				
						"		</span>" +
						"	</div>"+
						"	<div class='progressfilereadsize'>"+
						"		<span class='readsize'>" + jsonData.bytesread + "<strong> bytes</strong></span>" +
						"		<span class='divider'><strong>/</strong></span>" +
						"		<span class='filelength'>" + jsonData.contentlength + "<strong> bytes</strong></span>" +
						"	</div>" +
						"	<div class='progressSpeed'>" +
						"		<span class='kbps'>" + jsonData.kbps + "<strong> kbps</strong></span>" +
						"	</div>" +								
						"</div>"	);										
				$(viewLoadingImgElem).find("div.progresspercent span.pgbar").width(jsonData.percent+"%").addClass("pgbarbgcolor");				
			}
		});
	};

});
</script>
</head>
<body>
<!-- Ajax Progress Status -->
<div id="viewLoading">
</div>
</body>
</html>