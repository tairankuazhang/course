<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
	<div align="right">
		<button class="btn btn-primary"  data-toggle="modal" data-target="#insertQuestion">添加试题</button>
	</div>
	<div class="modal fade" id="insertQuestion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="exampleModalLabel">添加试题</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form role="form" action="../question/insert" method="post">
	      <div class="modal-body  row">
		      <div class="col-md-3">
				<label for="exampleInputEmail1">
					试题题目：
				</label>
			  </div>
		      <div class="col-md-9">
		      	<textarea style="width:300px;height:100px;margin-top:10px;margin-bottom: 10px" name="topic"></textarea>
		      </div>
	      </div>
	      <div class="modal-body  row">
		      <div class="col-md-3">
				<label for="exampleInputEmail1">
					试题答案：
				</label>
			  </div>
		      <div class="col-md-9">
		      	<input type="test" class="form-control" id="exampleInputEmail1" name="answer" />
		      </div>
	      </div>
	      <div class="modal-body  row">
		      <div class="col-md-3">
		      	<label for="exampleInputEmail1">
					课程：
				</label>
		      </div>
		      <div class="col-md-9">
		      	<select  style="margin-top:10px;margin-bottom: 10px;" name="vid">
		      		<option value="">--请选择课程--</option>
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
								题目
							</th>
							<th>
								答案
							</th>
							<th>
								教师
							</th>
							<th>
								视频
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<c:forEach items="${question}" var="q" varStatus="st">
						<tr>
							<td>${st.count }</td>
							<td>${q.q_topic }</td>
							<td>${q.q_answer }</td>
							<td>${q.te_name }</td>
							<td>${q.v_name }</td>
							<td>
								<button type="button" class="btn btn-link" data-toggle="modal" data-target="#updateQuestion${q.q_id }">
								  修改试题
								</button>&nbsp&nbsp&nbsp&nbsp
								<a href='${pageContext.request.contextPath}/admin/deleteQuestion?id=${q.q_id }'>删除</a>
							</td>
						</tr>
						<div class="modal fade" id="updateQuestion${q.q_id }" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h3 class="modal-title" id="exampleModalLabel">修改试题</h3>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <form role="form" action="../question/update" method="post">
						      <div class="modal-body  row">
							      <div class="col-md-3">
									<label for="exampleInputEmail1">
										试题题目：
									</label>
								  </div>
							      <div class="col-md-9">
							      	<textarea style="width:300px;height:100px;margin-top:10px;margin-bottom: 10px" name="topic">${q.q_topic }</textarea>
							      </div>
						      </div>
						      <div class="modal-body  row">
							      <div class="col-md-3">
									<label for="exampleInputEmail1">
										试题答案：
									</label>
								  </div>
							      <div class="col-md-9">
							      	<input type="test" class="form-control" id="exampleInputEmail1" name="answer" value="${q.q_answer }"/>
							      	<input type="hidden"  name="qid" value="${q.q_id }" />
							      </div>
						      </div>
						      <div class="modal-body  row">
							      <div class="col-md-3">
							      	<label for="exampleInputEmail1">
										课程：
									</label>
							      </div>
							      <div class="col-md-9">
							      	<select  style="margin-top:10px;margin-bottom: 10px;" name="vid">
							      		<c:forEach items="${video}" var="v" varStatus="st">
							      			<option value ="${v.v_id }" <c:if test="${q.q_vid == v.v_id}">selected</c:if> >${v.v_name }</option>
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