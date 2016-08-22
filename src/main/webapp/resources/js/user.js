var username = $("#username").val();
var password = $("#password").val();

function SendXHT() {
	alert('123123123');
};

window.onload = function() {
//	document.getElementById("btsave").onclick = SendXHT;
	$("#btsave").click(function() {
		$.ajax({
			type:"GET",
//			url:"http://localhost:8080/SpringMVCStudy/test/getUserById.do",
			url:"/SpringMVCStudy/manage/login/checkLogin.do",
			data:{
				"name":"marry",
				"password":"appadmin",
			},
			success:function(result){
				console.log(result);
			}
		})
		alert('点击登录按钮');
	});
	alert('初始化加载页面');
}