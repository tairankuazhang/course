<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
	<ul class="nav nav-list well">
		<c:forEach items="${listType }" var="list" varStatus="st">
			<li >
				<a href="${pageContext.request.contextPath}/type?tyid=${list.ty_id }&name=${list.ty_name}">${list.ty_name }</a>
			</li>
		</c:forEach>
	</ul>
</div>
<div class="col-md-8 col-sm-8">
<div class="container-fluid">
	<div class="carousel slide" id="carousel-210314" data-ride="carousel" data-interval="2000">
		<ol class="carousel-indicators">
			<li class="active" data-slide-to="0" data-target="#carousel-210314">
			</li>
			<li data-slide-to="1" data-target="#carousel-210314">
			</li>
			<li data-slide-to="2" data-target="#carousel-210314">
			</li>
		</ol>
		<div class="carousel-inner"  align="center">
			<div class="item active">
				<img alt="" src="${pageContext.request.contextPath}/image/cover1.png" style="height: 450px"/>

			</div>
			<div class="item">
				<img alt="" src="${pageContext.request.contextPath}/image/cover2.png"  style="height: 450px"/>

			</div>
			<div class="item">
				<img alt="" src="${pageContext.request.contextPath}/image/cover3.png"  style="height: 450px"/>
			</div>
		</div> 
		<a class="left carousel-control" href="#carousel-210314" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a> 
		<a class="right carousel-control" href="#carousel-210314" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
	<div style="width: 100%;margin-top:10px" >

		<div class="col-md-12" style="height:60px;margin-left: 0px;padding-left:0px ">
	<c:set var="falg" value="1"></c:set>
	<c:set var="add" value="1"></c:set>
	<c:set var="type" value="0"></c:set>
			<c:forEach items="${listVideo }" var="l" varStatus="st">
				<c:if test="${type !=l.v_tyid }">
					<c:if test="${falg!=1 }">
						<div style="clear:both;"></div>
					</div>
					</c:if>
				
				<div style="background-color:#FFf">
					<a href="${pageContext.request.contextPath}/type?tyid=${l.v_tyid }&name=${l.ty_name}"><h3 align="center" style="padding-top:5px">${l.ty_name }</h3></a>
					<c:set var="type" value="${l.v_tyid }"></c:set>
				</c:if>
				<c:set var="falg" value="${add+falg }"></c:set>
				
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

</div>
</div>
</div>

<div class="col-md-2 col-sm-2">
	<div align="center" >
		<form class="navbar-form navbar-left" action="../search" role="search" method="post">
			<div class="form-group" style="width: 65%" >
				<input type="text"  name="name" class="form-control" placeholder="查找名称" style="width: 100%" />
			</div>
			<button type="submit" class="btn btn-primary">查找</button>
		</form>
	</div>
	<div style="clear:both;"></div>
	<div style="background-color:#FFf">
		<h3 align="center" style="padding-top:5px">观看最多</h3>
			<c:forEach items="${listVideoSort }" var="li" varStatus="st">
				<div class="col-md-6" style="padding: 5px;"  align="center">
					<a href="${pageContext.request.contextPath}/video/details?vid=${li.v_id }" style="padding-bottom: 5px;">
						<img src="${pageContext.request.contextPath}/image/${li.v_pic }" style="width: 105px;height:150px" >
						<h4 align="center">${li.v_name }</h4>
					</a>
				</div>
			</c:forEach>
		<div style="clear:both;"></div>
	</div>
</div>
<%@include  file="../tail.jsp"%>