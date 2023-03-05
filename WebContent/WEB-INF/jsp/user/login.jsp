<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=basePath%>css/style.css"/>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css"/>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.css"/>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"/>
</head>
<style type="text/css">
body{
	background: #e6e6fa;//设置背景色为紫色
}
.nav{
	background: #ececfc;
}
.duyi{
	background: #ececfc;
}
input{
	margin-bottom: 10px;
	margin-top: 10px
}
.duyi a,a:hover,a:active{text-decoration: none}
</style>
<body>
<h1 align="center">
	欢迎用户登录
</h1>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="user/login" method="post">
				<div class="form-group" align="center">
					<table>
						<tr>
							<td>
								<label for="exampleInputEmail1">
									用户名：
								</label>
							</td>
							<td>
								<input type="test" class="form-control" id="exampleInputEmail1" name="uname" required="required"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="exampleInputPassword1">
									密码：
								</label>
							</td>
							<td>
								<input type="password" class="form-control" id="exampleInputPassword1" name="password"  required="required"/>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<select name="usertype" style="margin-bottom: 10px">
									<option value="1" selected>学生</option>
									<option value="0">老师</option>
									<option value="2">管理员</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="submit" class="btn btn-primary">
									登录
								</button>
								<a href="${pageContext.request.contextPath}/user/registered">
									<button type="button" class="btn btn-primary">
										注册
									</button></a>
								</td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>