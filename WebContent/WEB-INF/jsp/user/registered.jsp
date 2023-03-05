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
<title>注册</title>
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
	用户注册
</h1>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="${pageContext.request.contextPath}/addUser" method="post" enctype="multipart/form-data">
				<div class="form-group" align="center">
					<table>
						<tr>
							<td>
								<label for="exampleInputEmail1">
									用户名：
								</label>
							</td>
							<td>
								<input type="text" class="form-control" id="exampleInputText1" name="uname" required="required"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="exampleInputPassword1">
									密码：
								</label>
							</td>
							<td>
								<input type="password" class="form-control" id="exampleInputPassword1" name="password" required="required"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="exampleInputPassword1">
									性别：
								</label>
							</td>
							<td>
								<div align="center">
									<input type="radio" class="form-radio" name="gender" value="0"/>
									<label for="exampleInputPassword1">
										男
									</label>
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<input type="radio" class="form-radio" name="gender" value="1" />
									<label for="exampleInputPassword1">
										女	
									</label>
								</div>
							</td>

						</tr>

						<tr>
							<td>
								<label for="exampleInputPassword1">
									类型：
								</label>
							</td>
							<td align="center">
								<select style="margin-top:10px;margin-bottom: 10px" name="usertype" >
									<option value ="0">学生</option>
									<option value ="1">老师</option>
								</select>
							</td>
						</tr>

						<tr>
							<td>
								<label for="exampleInputPassword1">
									头像：
								</label>
							</td>
							<td align="center">
								<input type="file"  class="form-file" name="pic"/>
							</td>
						</tr>

						<tr>
							<td colspan="2" align="center">
								<button type="submit" class="btn btn-primary">
									提交
								</button>
								<input type="reset" class="btn btn-primary" value="重置">
								<a href="javascript:history.go(-1)">
									<button type="button" class="btn btn-primary">
										返回
									</button>
								</a>

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