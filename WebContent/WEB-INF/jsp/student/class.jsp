<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
	<c:if test="${listClass != null}">
		<div class="row-fluid">
			<div class="col-md-4 col-sm-4"></div>
			<div align="center" class="col-md-4 col-sm-4">
				<form class="navbar-form navbar-left" action="../class/searchResult" role="search" method="post">
					<div class="form-group">
						<input type="text"  name="search" class="form-control" placeholder="班级id" />
					</div>
					<button type="submit" class="btn btn-primary">查找</button>
				</form>
			</div>
			<div class="col-md-4 col-sm-4"></div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>
									编号
								</th>
								<th>
									班级名字
								</th>
								<th>
									老师
								</th>
								<th>
									视频
								</th>
								<th>
									操作
								</th>
							</tr>
						</thead>
						<c:forEach items="${listClass}" var="c" varStatus="st">
							<tr>
								<td>${st.count }</td>
								<td>${c.cl_name }</td>
								<td>${c.te_name }</td>
								<td>${c.v_name }</td>
								<td><a href='${pageContext.request.contextPath}/class/deleteClassStudent?id=${c.cs_id }'>退出</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${cclass != null}">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>
									编号
								</th>
								<th>
									班级名字
								</th>
								<th>
									老师
								</th>
								<th>
									视频
								</th>
								<th>
									操作
								</th>
							</tr>
						</thead>
							<tr>
								<td>1</td>
								<td>${cclass.cl_name }</td>
								<td>${cclass.te_name }</td>
								<td>${cclass.v_name }</td>
								<td><a href='${pageContext.request.contextPath}/class/insertClassStudent?id=${cclass.cl_id }'>加入</a></td>
							</tr>
					</table>
				</div>
			</div>
		</div>
	</c:if>
</div>
<div class="col-md-2 col-sm-2">
</div>
<%@include  file="../tail.jsp"%>