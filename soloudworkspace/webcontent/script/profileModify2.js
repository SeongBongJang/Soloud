$(document).ready(function(){
	$("#cancel_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/profileModify/cancel.jpg");
	});
	$("#cancel_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/profileModify/cancel2.jpg");
	});
	$("#save_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/profileModify/save.jpg");
	});
	$("#save_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/profileModify/save2.jpg");
	});
	

	
	$("#save_button").click(function(){

		if(document.getElementById("first_name").value == "") {
			alert("�̸��� �Է����ּ���");
			return;
		}
		if(document.getElementById("last_name").value == ""){
			alert("�̸��� �Է����ּ���");
			return;
		}
		if(document.getElementById("password").value == "") {
			alert("��й�ȣ�� �Է����ּ���");
			return;
		}
		if(document.getElementById("password_validate").value == ""){
			alert("��й�ȣ Ȯ���� ���ּ���");
			return;
		}
		if(document.getElementById("password_validate").value != document.getElementById("password").value){
			alert("��й�ȣ�� ��й�ȣ Ȯ���� ���� �ʽ��ϴ�.Ȯ�����ּ���");
			return;
		}
		
		alert("����±��");
		//document.getElementById("profileModifyForm").action="/Soloud/profileModify.do";
		//document.getElementById("profileModifyForm").submit();
		
	//	var formData = $("#profileModifyForm").serialize();
		var firstName=$("#first_name").val();
		var lastName=$("#last_name").val();
		var password=$("#password").val();
		var rePassword=$("#password_validate").val();
		
	//	alert(firstName + lastName + password+ rePassword);
		
		$.ajax({
			type: "post",
			url: "/Soloud/profileModify.do",	//profileModify.do
			data: {first:firstName, last:lastName, pass:password, rePass:rePassword},
			dataType: "json",
			success: function (data1) {
				alert(data1.isSuccess);
				if(data1.isSuccess == true) 
				{
					alert("������ �����߽��ϴ�");
					document.getElementById("profileModifyForm").action="/Soloud/profileModifyResult.do";
					document.getElementById("profileModifyForm").submit();
				}
				else 
				{
					alert("�߸��� �������Դϴ�. �ٽ� �Է����ּ���");
				}
			}
		});

	});
});


