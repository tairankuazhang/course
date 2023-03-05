<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
	<div align="right">
		<button class="btn btn-primary" data-toggle="modal" data-target="#insertClass">添加班级</button>
	</div>
	<div class="modal fade" id="insertClass" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="exampleModalLabel">添加班级</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form role="form" action="../class/insert" method="post">
	      <div class="modal-body  row">
		      <div class="col-md-3">
				<label for="exampleInputEmail1">
					班级名称：
				</label>
			  </div>
		      <div class="col-md-9">
		      	<input type="test" class="form-control" id="exampleInputEmail1" name="name"/>
		      </div>
		  </div>
		  <div class="modal-body  row">
		      <div class="col-md-3">
		      	<label for="exampleInputEmail1">
					课程：
				</label>
		      </div>
		      <div class="col-md-9">
		      	<select  style="margin-top:10px;margin-bottom: 10px;" name="classId">
		      		<option value="">--请选择班级--</option>
		      		<c:forEach items="${video}" var="v" varStatus="st">
		      			<option value ="${v.v_id }" >${v.v_name }</option>
		      		</c:forEach>
		      	</select>
		      </div>
		  </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">返回</button>
	        <button type="submit" class="btn btn-primary" >保存</button>
	      </div>
	      </form>
	    </div>
	  </div>
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
								课程
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<c:forEach items="${cclass}" var="c" varStatus="st">
						<tr>
							<td>${st.count }</td>
							<td>${c.cl_name }</td>
							<td>${c.te_name }</td>
							<td>${c.v_name }</td>
							<td>
								<button type="button" class="btn btn-link" data-toggle="modal" data-target="#updateClass${c.cl_id }">
								  修改班级
								</button>&nbsp&nbsp&nbsp&nbsp
								<a href='${pageContext.request.contextPath}/admin/deleteClass?id=${c.cl_id }'>删除</a>
							</td>
						</tr>
						<div class="modal fade" id="updateClass${c.cl_id }" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h3 class="modal-title" id="exampleModalLabel">修改班级</h3>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <form role="form" action="../class/update" method="post">
						      <div class="modal-body  row">
							      <div class="col-md-3">
									<label for="exampleInputEmail1">
										班级名称：
									</label>
								  </div>
							      <div class="col-md-9">
							      	<input type="test" class="form-control" id="exampleInputEmail1" name="name" value="${c.cl_name }"/>
							      	<input type="hidden"  name="clid" value="${c.cl_id }" />
							      </div>
						      </div>
						      <div class="modal-body  row">
							      <div class="col-md-3">
							      	<label for="exampleInputEmail1">
										课程：
									</label>
							      </div>
							      <div class="col-md-9">
							      	<select  style="margin-top:10px;margin-bottom: 10px;" name="classId">
							      		<c:forEach items="${video}" var="v" varStatus="st">
							      			<option value ="${v.v_id }" <c:if test="${c.cl_vid == v.v_id}">selected</c:if> >${v.v_name }</option>
							      		</c:forEach>
							      	</select>
							      </div>
							  </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-dismiss="modal">返回</button>
						        <button type="submit" class="btn btn-primary" >保存</button>
						      </div>
						      </form>
						    </div>
						  </div>
						</div>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<div class="col-md-2 col-sm-2">
</div>
<%@include  file="../tail.jsp"%>