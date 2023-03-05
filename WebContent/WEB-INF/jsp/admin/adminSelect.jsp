<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="row">
	<div class="col-md-2 col-sm-2">
		<ul class="nav nav-list well">
			<li class="nav-header">
				用户
			</li>
			<li >
				<a href="${pageContext.request.contextPath}/admin/selectStudent">学生列表</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectTeacher">教师列表</a>
			</li>
			<li class="nav-header">
				评论
			</li>
			<li >
				<a href="${pageContext.request.contextPath}/admin/selectComments">课程评论</a>
			</li>
			<li class="nav-header">
				课程
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectVideo">查看课程</a>
			</li>
			<li class="nav-header">
				笔记
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectNotes">查看笔记</a>
			</li>
			<li class="nav-header">
				试题
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectQuestion">查看试题</a>
			</li>
			<li class="nav-header">
				班级
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/admin/selectClass">查看班级</a>
			</li>
		</ul>
	</div>
	<div class="col-md-8 col-sm-8">
	
		<c:if test="${student != null}">
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
										用户名
									</th>
									<th>
										密码
									</th>
									<th>
										性别
									</th>
									<th>
										照片
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<c:forEach items="${student}" var="s" varStatus="st">
								<tr>
									<td>${st.count }</td>
									<td>${s.s_name }</td>
									<td>${s.s_password }</td>
									<td>${s.s_gender }</td>
									<td><img src="${pageContext.request.contextPath}/image/${s.s_pic }" width='80px' height='80px' /></td>
									<td><a href='${pageContext.request.contextPath}/admin/deleteStudent?id=${s.s_id }'>删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${teacher != null}">
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
										用户名
									</th>
									<th>
										密码
									</th>
									<th>
										性别
									</th>
									<th>
										介绍
									</th>
									<th>
										照片
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<c:forEach items="${teacher}" var="t" varStatus="st">
								<tr>
									<td>${st.count }</td>
									<td>${t.te_name }</td>
									<td>${t.te_password }</td>
									<td>${t.te_gender }</td>
									<td>${t.te_intro }</td>
									<td><img src="${pageContext.request.contextPath}/image/${t.te_pic }" width='80px' height='80px' /></td>
									<td><a href='${pageContext.request.contextPath}/admin/deleteTeacher?id=${t.te_id }'>删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${comments != null}">
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
										评论内容
									</th>
									<th>
										学生
									</th>
									<th>
										视频
									</th>
									<th>
										评论时间
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<c:forEach items="${comments}" var="c" varStatus="st">
								<tr>
									<td>${st.count }</td>
									<td>${c.co_content }</td>
									<td>${c.s_name }</td>
									<td>${c.v_name }</td>
									<td>${c.co_time }</td>
									<td><a href='${pageContext.request.contextPath}/admin/deleteComments?id=${c.co_id }'>删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${video != null}">
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
										视频名字
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
									<td><a href='${pageContext.request.contextPath}/admin/deleteVideo?id=${v.v_id }'>删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${notes != null}">
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
									<td><a href='${pageContext.request.contextPath}/admin/deleteNotes?id=${n.n_id }'>删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${question != null}">
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
									<td><a href='${pageContext.request.contextPath}/admin/deleteQuestion?id=${q.q_id }'>删除</a></td>
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
							<c:forEach items="${cclass}" var="c" varStatus="st">
								<tr>
									<td>${st.count }</td>
									<td>${c.cl_name }</td>
									<td>${c.te_name }</td>
									<td>${c.v_name }</td>
									<td><a href='${pageContext.request.contextPath}/admin/deleteClass?id=${c.cl_id }'>删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<div class="col-md-2 col-sm-2">
	</div>
</div>
<%@include  file="../tail.jsp"%>