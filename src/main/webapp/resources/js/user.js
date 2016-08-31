

function SendXHT() {
	alert('123123123');
};

window.onload = function() {
	// document.getElementById("btsave").onclick = SendXHT;

	$("#btsave").click(function() {
		var username = $("#name").val();
		var password = $("#pwd").val();
//		var password =$(":password").val();
		console.log(username);
		console.log(password);
		$.ajax({
			type : "GET",
			// url:"http://localhost:8080/SpringMVCStudy/test/getUserById.do",
			url : "/SpringMVCStudy/manage/login/checkLogin1.do",
			data : {
				"name" : username,
				"password" : password,
			},
			success : function(result) {
				console.log(result);
//				window.navigate("/manage/report/NewFile.jsp");

			}
		});
		alert('点击登录按钮');
	});
	alert('初始化加载页面');
};