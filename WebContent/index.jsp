<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="./WEB-INF/jsp/head.jsp"%>
<h2></h2>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-5 col-sm-5">
<img src="${pageContext.request.contextPath}/image/home-left-1.png" alt>
</div>
<div class="col-md-4 col-sm-4">
<h2 style="margin-bottom: 40px">欢迎来到网上学习平台</h2>
<p style="margin-bottom: 40px">您想随时随地都能学习吗，您想随时随地都能锻炼自己的技能吗，如果您想，请来网上学习平台，这儿有最好的学习资源，您还等什么，快来看看吧！</p>
<a href="${pageContext.request.contextPath}/student/home"><button class="btn btn-success" type="button">进入首页</button></a>
</div>
<div class="col-md-1 col-sm-1"></div>
<%@include  file="./WEB-INF/jsp/tail.jsp"%>