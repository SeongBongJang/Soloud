$(document).ready(function() {
    
    $('#confirm_password').blur(function() {
        if ($('#password').val() != $('#confirm_password').val()) {
        	alert("비밀번호와 비밀번호 확인을 같게 입력해주세요!");
        }
        else {
           
        }
    });
});
function mySubmit(n) {
	if (n == 1) {
		$.ajax({
			url:"join_check", type:"POST", dataType:"json", data:{id:$("#id").val(), domain:$("#domain").val(), state: $("#check_result").attr("value")}, timeout:5000,
			success:function(data){
				//alert(data.result);
				if(data.result)
				{
					document.getElementById("check_result").setAttribute("value", "true");
					alert("중복되지 않는 아이디입니다! 나머지 정보를 입력해주세요!");
					$("#id").attr('disabled',"disabled");
					$("#domain").attr('disabled',"disabled");
					alert(data.resultMsg);
				}
				else
				{
					alert(data.resultMsg);
				}
			}
		});		
	} else if (n == 2) {
		if(document.getElementById("check_result").value=="true"){
			$.ajax({
    			url:"join_complete", type:"POST", dataType:"json", data:$("form").serializeArray(), timeout:5000,
    			success:function(response){
    				if(JSON.stringify(response.result) != "true"){
    					alert(response.result);
    				}
    				else{
            			document.myForm.action = "join_completion";
                    	document.myForm.submit();
    				}
    			}
    		});		
		}
		else{
			alert("안녕?");
		}
	} 
}
$(document).ready(function(){
	$("#domain2").change(function(){
		if(this.selectedIndex==1){
			document.getElementById("domain").value = "naver.com";
		}
		else if(this.selectedIndex==2){
			document.getElementById("domain").value = "hanmail.net";
		}
		else if(this.selectedIndex==3){
			document.getElementById("domain").value = "nate.com";
		}
		else if(this.selectedIndex==4){
			document.getElementById("domain").value = "gmail.com";
		}
		else if(this.selectedIndex==5){
			document.getElementById("domain").value = "daum.net";
		}
		else if(this.selectedIndex==6){
			document.getElementById("domain").value = "hotmail.com";
		}
		else if(this.selectedIndex==7){
			document.getElementById("domain").value = "lycos.co.kr";
		}
		else if(this.selectedIndex==8){
			document.getElementById("domain").value = "korea.com";
		}
		else if(this.selectedIndex==9){
			document.getElementById("domain").value = "empal.com";
		}
		else if(this.selectedIndex==10){
			document.getElementById("domain").value = "dreamwiz.com";
		}
		else if(this.selectedIndex==11){
			document.getElementById("domain").value = "yahoo.com";
		}
		else if(this.selectedIndex==12){
			document.getElementById("domain").value = "ymail.com";
		}
		else if(this.selectedIndex==13){
			document.getElementById("domain").value = "live.com";
		}
		else if(this.selectedIndex==14){
			document.getElementById("domain").value = "aol.com";
		}
		else if(this.selectedIndex==15){
			document.getElementById("domain").value = "msn.com";
		}
		else if(this.selectedIndex==16){
			document.getElementById("domain").value = "me.com";
		}
		else if(this.selectedIndex==17){
			document.getElementById("domain").value = "icloud.com";
		}
		else if(this.selectedIndex==18){
			document.getElementById("domain").value = "rocketmail.com";
		}
		else if(this.selectedIndex==19){
			document.getElementById("domain").value = "qq.com";
		}
		else if(this.selectedIndex==20){
			document.getElementById("domain").value = "link.com";
		}
		else if(this.selectedIndex==21){
			document.getElementById("domain").value = "";
		}
	});
});