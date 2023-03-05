<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
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
								笔记内容
							</th>
							<th>
								学生
							</th>
							<th>
								笔记时间
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<c:forEach items="${notes}" var="n" varStatus="st">
						<tr>
							<td>${st.count }</td>
							<td>${n.n_content }</td>
							<td>${n.s_name }</td>
							<td>${n.n_time }</td>
							<td>
								<button type="button" class="btn btn-link" data-toggle="modal" data-target="#updateNotes${n.n_id }">
								  修改
								</button>&nbsp&nbsp&nbsp&nbsp
								<a href='${pageContext.request.contextPath}/admin/deleteNotes?id=${n.n_id }'>删除</a>
							</td>
						</tr>
						<div class="modal fade" id="updateNotes${n.n_id }" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h3 class="modal-title" id="exampleModalLabel">修改笔记</h3>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <form role="form" action="../notes/update" method="post">
						      <div class="modal-body  row">
							      <div class="col-md-3">
									<label for="exampleInputEmail1">
										笔记内容：
									</label>
								  </div>
							      <div class="col-md-9">
							      	<textarea style="width:300px;height:100px;margin-top:10px;margin-bottom: 10px" name="context">${n.n_content }</textarea>
							      	<input type="hidden"  name="nid" value="${n.n_id }" />
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