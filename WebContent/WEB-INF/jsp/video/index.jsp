<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
	<div align="right">
		<button class="btn btn-primary"  data-toggle="modal" data-target="#insertVideo">添加课程</button>
	</div>
	<div class="modal fade" id="insertVideo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="exampleModalLabel">添加课程</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form role="form" action="../video/insert" method="post"  enctype="multipart/form-data">
	      <div class="modal-body  row">
		      <div class="col-md-3">
				<label for="exampleInputEmail1">
					课程名字：
				</label>
			  </div>
		      <div class="col-md-9">
		      	<input type="test" class="form-control" id="exampleInputEmail1" name="name"/>
		      </div>
	      </div>
	      <div class="modal-body  row">
		      <div class="col-md-3">
				<label for="exampleInputEmail1">
					类型：
				</label>
			  </div>
		      <div class="col-md-9">
		      	<select  style="margin-top:10px;margin-bottom: 10px;" name="tyId">
		      		<option value="">--请选择类型--</option>
		      		<c:forEach items="${listType}" var="li" varStatus="st">
		      			<option value ="${li.ty_id }"  >${li.ty_name }</option>
		      		</c:forEach>
		      	</select>
		      </div>
	      </div>
	      <div class="modal-body  row">
		      <div class="col-md-3">
		      	<label for="exampleInputEmail1">
					图片：
				</label>
		      </div>
		      <div class="col-md-9">
		      	<input type="file"  style="margin-top:10px;margin-bottom: 10px" name="pic" />
		      </div>
		  </div>
		  <div class="modal-body  row">
		      <div class="col-md-3">
		      	<label for="exampleInputEmail1">
					介绍：
				</label>
		      </div>
		      <div class="col-md-9">
		      	<textarea style="width:300px;height:100px;margin-top:10px;margin-bottom: 10px" name="intro"></textarea>
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
								课程名字
							</th>
							<th>
								教师
							</th>
							<th>
								类型
							</th>
							<th>
								海报
							</th>
							<th>
								介绍
							</th>
							<th>
								观看量
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<c:forEach items="${video}" var="v" varStatus="st">
						<tr>
							<td>${st.count }</td>
							<td>${v.v_name }</td>
							<td>${v.te_name }</td>
							<td>${v.ty_name }</td>
							<td><img src="${pageContext.request.contextPath}/image/${v.v_pic }" width='80px' height='80px' /></td>
							<td>${v.v_intro }</td>
							<td>${v.v_views }</td>
							<td>
								<button type="button" class="btn btn-link" data-toggle="modal" data-target="#updateVideo${v.v_id }">
								  修改课程
								</button>&nbsp&nbsp&nbsp&nbsp
								<a href='${pageContext.request.contextPath}/admin/deleteVideo?id=${v.v_id }'>删除</a>&nbsp&nbsp&nbsp&nbsp
								<a href='${pageContext.request.contextPath}/teacher/selectConnectionByid?id=${v.v_id }'>查看视频</a>
							</td>
						</tr>
						<div class="modal fade" id="updateVideo${v.v_id }" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h3 class="modal-title" id="exampleModalLabel">修改课程</h3>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <form role="form" action="../video/update" method="post"  enctype="multipart/form-data">
						      <div class="modal-body  row">
							      <div class="col-md-3">
									<label for="exampleInputEmail1">
										课程名字：
									</label>
								  </div>
							      <div class="col-md-9">
							      	<input type="test" class="form-control" id="exampleInputEmail1" name="name" value="${v.v_name }"/>
							      </div>
						      </div>
						      <div class="modal-body  row">
							      <div class="col-md-3">
									<label for="exampleInputEmail1">
										类型：
									</label>
								  </div>
							      <div class="col-md-9">
							      	<select  style="margin-top:10px;margin-bottom: 10px;" name="tyId">
							      		<c:forEach items="${listType}" var="li" varStatus="st">
							      			<option value ="${li.ty_id }" <c:if test="${li.ty_id == v.v_tyid}">selected</c:if> >${li.ty_name }</option>
							      		</c:forEach>
							      	</select>
							      </div>
						      </div>
						      <div class="modal-body  row">
							      <div class="col-md-3">
							      	<label for="exampleInputEmail1">
										图片：
									</label>
							      </div>
							      <div class="col-md-9">
							      	<img src="${pageContext.request.contextPath}/image/${v.v_pic }" width='80px' height='80px' />
							      	<input type="file"  style="margin-top:10px;margin-bottom: 10px" name="pic" />
							      </div>
							  </div>
							  <div class="modal-body  row">
							      <div class="col-md-3">
							      	<label for="exampleInputEmail1">
										介绍：
									</label>
							      </div>
							      <div class="col-md-9">
							      	<textarea style="width:300px;height:100px;margin-top:10px;margin-bottom: 10px" name="intro">${v.v_intro }</textarea>
							      	<input type="hidden"  name="vid" value="${v.v_id }" />
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