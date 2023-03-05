<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>网上学习平台</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=basePath%>css/style.css"/>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css"/>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.css"/>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"/>

</head>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootstrap-modal.js"></script>
<meta charset="UTF-8">
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
<body >
	
	<div class="row">
		<div class="col-md-12 col-sm-12 duyi">
			<div class="page-header" align="right">
				<a href="${pageContext.request.contextPath}/student/home"><h1 align="center">
					网上学习<small>平台</small>
				</h1></a>
				<c:if test="${username != null}">
					<c:if test="${usertype == 'teacher'}">
						<a href="${pageContext.request.contextPath}/teacher/selectClassByTeid">我的班级</a>&nbsp&nbsp&nbsp&nbsp
						<a href="${pageContext.request.contextPath}/teacher/selectQuestionByTeid">我的试题</a>&nbsp&nbsp&nbsp&nbsp
						<a href="${pageContext.request.contextPath}/teacher/selectVideoByTeid">我的课程</a>&nbsp&nbsp&nbsp&nbsp
					</c:if>
					<c:if test="${usertype == 'student'}">
						<a href="${pageContext.request.contextPath}/student/class">我的班级</a>&nbsp&nbsp&nbsp&nbsp
						<button type="button" class="btn btn-link" data-toggle="modal" data-target="#insertNotes">
						  添加笔记
						</button>&nbsp&nbsp&nbsp&nbsp
						<a href="${pageContext.request.contextPath}/student/notes">我的笔记</a>&nbsp&nbsp&nbsp&nbsp
					</c:if>
				   	您好
				   	<c:if test="${usertype == 'student'}">
				   		学生:&nbsp&nbsp<a href="${pageContext.request.contextPath}/user/userDetails">${username }</a>
				   	</c:if>
				   	<c:if test="${usertype == 'teacher'}">
				   		教师:&nbsp&nbsp<a href="${pageContext.request.contextPath}/user/userDetails">${username }</a>
				   	</c:if>
				   	<c:if test="${usertype == 'admin'}">
				   		管理员:&nbsp&nbsp<a href="${pageContext.request.contextPath}/admin/index">${username }</a>
				   	</c:if>
				,欢迎您！&nbsp&nbsp&nbsp&nbsp&nbsp<a href='${pageContext.request.contextPath}/logout' >注销</a>&nbsp&nbsp
				</c:if>
				<c:if test="${username == null}">
					<a href='${pageContext.request.contextPath}/login'>登录</a>&nbsp&nbsp|&nbsp&nbsp
					<a href='${pageContext.request.contextPath}/user/registered' >注册</a>
				</c:if>
				
			</div>
		</div>
	</div>
<div class="modal fade" id="insertNotes" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">添加笔记</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form role="form" action="../notes/insertNotes" method="post">
      <div class="modal-body">
        <textarea rows="2" style="margin-top:10px;margin-bottom: 10px ;width:100%" name="context"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">返回</button>
        <button type="submit" class="btn btn-primary" >保存</button>
      </div>
      </form>
    </div>
  </div>
</div>
