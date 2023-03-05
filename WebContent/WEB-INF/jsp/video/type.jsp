<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<% 
        String name = request.getParameter("name");
%> 
<div class="col-md-8 col-sm-8">
	<div style="background-color: #fff ;width: 100% ;"align="center">
	
		<h3 style="padding-left: 60px;padding-top: 15px  " align="left"><%=name %></h3>
	
		<c:forEach  items="${listVideo }" var="l" varStatus="st">
			<div class="col-md-2" style="padding: 5px;" align="center">
				<a href="${pageContext.request.contextPath}/video/details?vid=${l.v_id }" style="padding-bottom: 5px;">
					<img src="${pageContext.request.contextPath}/image/${l.v_pic }" style="width: 105px;height:150px" >
					<h4 align="center">${l.v_name }</h4>
				</a>
			</div>
		</c:forEach>
		<div style="clear:both;"></div>
	</div>
</div>
<div class="col-md-2 col-sm-2">
</div>
<%@include  file="../tail.jsp"%>