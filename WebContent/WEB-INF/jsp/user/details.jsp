<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
	<div style="background-color: #fff;width: 100%;margin-top: 30px" align="center">
		<h3 align="center" style="padding-top: 10px">用户详情</h3>
		<c:if test="${usertype == 'student'}">
			<table class="table table-hover" style="margin-top:5px">
				<tbody>
					<tr>
						<td>
							用户名
						</td>
						<td>
							${student.s_name }
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td>
							密码
						</td>
						<td>
							${student.s_password }
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td>
							性别
						</td>
						<td>
							${student.s_gender }
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td>
							头像
						</td>
						<td>
							<img src="${pageContext.request.contextPath}/image/${student.s_pic }" width='80px' height='80px' />
						</td>
					</tr>
				</tbody>
			</table>
			<div style="clear:both;"></div>
			<div align="right">
				<button class="btn btn-primary" data-toggle="modal" data-target="#updateStudent">修改</button>
			</div>
		</c:if>
		<c:if test="${usertype == 'teacher'}">
			<table class="table table-hover" style="margin-top:5px">
				<tbody>
					<tr>
						<td>
							用户名
						</td>
						<td>
							${teacher.te_name }
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td>
							密码
						</td>
						<td>
							${teacher.te_password }
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td>
							性别
						</td>
						<td>
							${teacher.te_gender }
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td>
							介绍
						</td>
						<td>
							${teacher.te_intro }
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td>
							头像
						</td>
						<td>
							<img src="${pageContext.request.contextPath}/image/${teacher.te_pic }" width='80px' height='80px' />
						</td>
					</tr>
				</tbody>
			</table>
			<div style="clear:both;"></div>
			<div align="right">
				<button class="btn btn-primary" data-toggle="modal" data-target="#updateTeacher">修改</button>
			</div>
		</c:if>
		
		<div class="modal fade" id="updateStudent" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h3 class="modal-title" id="exampleModalLabel">修改信息</h3>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <form role="form" action="../student/update?sid=${student.s_id }" method="post" enctype="multipart/form-data">
		      <div class="modal-body  row">
			      <div class="col-md-3">
					<label for="exampleInputEmail1">
						用户名：
					</label>
				  </div>
			      <div class="col-md-9">
			      	<input type="test" class="form-control" id="exampleInputEmail1" name="name" value="${student.s_name }"/>
			      </div>
		      </div>
		      <div class="modal-body  row">
			      <div class="col-md-3">
					<label for="exampleInputEmail1">
						密码：
					</label>
				  </div>
			      <div class="col-md-9">
			      	<input type="test" class="form-control" id="exampleInputEmail1" name="name" value="${student.s_password }"/>
			      </div>
		      </div>
		      <div class="modal-body  row">
			      <div class="col-md-3">
					<label for="exampleInputEmail1">
						性别：
					</label>
				  </div>
			      <div class="col-md-9">
			      	<input type="test" class="form-control" id="exampleInputEmail1" name="gender" value="${student.s_gender }"/>
			      </div>
		      </div>
		      <div class="modal-body  row">
			      <div class="col-md-3">
			      	<label for="exampleInputEmail1">
						头像：
					</label>
			      </div>
			      <div class="col-md-9">
			      	<img src="${pageContext.request.contextPath}/image/${student.s_pic }" width='80px' height='80px' />
			      	<input type="file"  style="margin-top:10px;margin-bottom: 10px" name="pic" />
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
		<div class="modal fade" id="updateTeacher" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h3 class="modal-title" id="exampleModalLabel">修改信息</h3>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <form role="form" action="../teacher/update?tid=${teacher.te_id }" method="post" enctype="multipart/form-data">
		      <div class="modal-body  row">
			      <div class="col-md-3">
					<label for="exampleInputEmail1">
						用户名：
					</label>
				  </div>
			      <div class="col-md-9">
			      	<input type="test" class="form-control" id="exampleInputEmail1" name="name" value="${teacher.te_name }"/>
			      </div>
		      </div>
		      <div class="modal-body  row">
			      <div class="col-md-3">
					<label for="exampleInputEmail1">
						密码：
					</label>
				  </div>
			      <div class="col-md-9">
			      	<input type="test" class="form-control" id="exampleInputEmail1" name="name" value="${teacher.te_password }"/>
			      </div>
		      </div>
		      <div class="modal-body  row">
			      <div class="col-md-3">
					<label for="exampleInputEmail1">
						性别：
					</label>
				  </div>
			      <div class="col-md-9">
			      	<input type="test" class="form-control" id="exampleInputEmail1" name="gender" value="${teacher.te_gender }"/>
			      </div>
		      </div>
		      <div class="modal-body  row">
			      <div class="col-md-3">
					<label for="exampleInputEmail1">
						个人介绍：
					</label>
				  </div>
			      <div class="col-md-9">
			      	<textarea style="width:300px;height:100px;margin-top:10px;margin-bottom: 10px" name="intro">${teacher.te_intro }</textarea>
			      </div>
		      </div>
		      <div class="modal-body  row">
			      <div class="col-md-3">
			      	<label for="exampleInputEmail1">
						头像：
					</label>
			      </div>
			      <div class="col-md-9">
			      	<img src="${pageContext.request.contextPath}/image/${teacher.te_pic }" width='80px' height='80px' />
			      	<input type="file"  style="margin-top:10px;margin-bottom: 10px" name="pic" />
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
	</div>
</div>
<div class="col-md-2 col-sm-2">
</div>
<%@include  file="../tail.jsp"%>