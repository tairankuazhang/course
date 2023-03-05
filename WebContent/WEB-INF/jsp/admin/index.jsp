<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="row">
	<div class="col-md-2 col-sm-2">
		<ul class="nav nav-list well">
			<li class="nav-header">
				用户
			</li>
			<li >
				<a href="${pageContext.request.contextPath}/admin/selectStudent">学生列表</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectTeacher">教师列表</a>
			</li>
			<li class="nav-header">
				评论
			</li>
			<li >
				<a href="${pageContext.request.contextPath}/admin/selectComments">视频评论</a>
			</li>
			<li class="nav-header">
				视频
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectVideo">查看视频</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectVideoType">视频类型</a>
			</li>
			<li class="nav-header">
				笔记
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectNotes">查看笔记</a>
			</li>
			<li class="nav-header">
				试题
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectQuestion">查看试题</a>
			</li>
			<li class="nav-header">
				班级
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectClass">查看班级</a>
			</li>
		</ul>
	</div>
	<div class="col-md-8 col-sm-8">
		<h2 align="center">欢迎管理员</h2>
	</div>
	<div class="col-md-2 col-sm-2">
	</div>
</div>
<%@include  file="../tail.jsp"%>