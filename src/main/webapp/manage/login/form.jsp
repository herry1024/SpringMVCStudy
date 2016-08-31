<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
	prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title> <script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/user.js"></script>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%>

</head>
<body>
	查询数据
	<br />
	<form action="/SpringMVCStudy/manage/login/checkLogin1.do"
		method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" /></td>
				<td>密码：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="login" /></td>
			</tr>
		</table>
	</form>

	更新数据
	<br />
	<form action="/SpringMVCStudy/manage/login/addUser.do"
		method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" /></td>
				<td>密码：</td>
				<td><input type="password" name="password" /></td>
				<td>年龄：</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="login" /></td>
			</tr>
		</table>
	</form>




</body>
</html>