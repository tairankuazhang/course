<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
	<div style="background-color:#FFf;padding: 5px;margin:5px">
		<h3>班级</h3>
		<c:if test="${listClass != null}">
			<c:forEach items="${listClass }" var="l" varStatus="st">
				<div class="col-md-2" style="padding: 5px;background-color:#ffeeee;margin:5px" align="center" >
					<h3 align="center">${l.cl_name }</h3>
					<div align="left" style="float:left">${l.te_name }</div>
					<div align="right" style="float:right">${l.v_name }</div>
					<div style="clear:both;"></div>
					<c:if test="${usertype == 'student'}">
						<a href="${pageContext.request.contextPath}/video/details?vid=${l.cl_id }" style="padding-bottom: 5px;">
							加入
						</a>
					</c:if>
				</div>
			</c:forEach>
			<div style="clear:both;"></div>
		</c:if>
		<c:if test="${listClass == null}">
			<p align="center">没搜索到该班级</p>
		</c:if>
	</div>
	<div style="background-color:#FFf;padding: 5px;margin:5px">
		<h3>课程</h3>
		<c:if test="${listVideo != null}">
			<c:forEach items="${listVideo }" var="l" varStatus="st">
				<div class="col-md-2" style="padding: 5px;background-color:#ffeeee;margin:5px" align="center">
					<a href="${pageContext.request.contextPath}/video/details?vid=${l.v_id }" style="padding-bottom: 5px;">
						<img src="${pageContext.request.contextPath}/image/${l.v_pic }" style="width: 105px;height:150px" >
						<h4 align="center">${l.v_name }</h4>
					</a>
				</div>
			</c:forEach>
			<div style="clear:both;"></div>
		</c:if>
		<c:if test="${listClass == null}">
			<p align="center">没搜索到该课程</p>
		</c:if>
	</div>
</div>
<div class="col-md-2 col-sm-2">
</div>
<%@include  file="../tail.jsp"%>