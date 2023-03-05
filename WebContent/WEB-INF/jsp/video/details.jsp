<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
	<div style="background-color: #fff;width: 100%">
		<div class="col-md-3" style="margin-top:5px">
			<img src="${pageContext.request.contextPath}/image/${video.v_pic }" style="width: 210px;height:300px">
			<h3 align="center">${video.v_name }</h3>
			<h4 align="center">综合评分：${score }</h4>
		</div>
		<div class="col-md-9" align="center">
			<h3>视频</h3>
			<video src="${pageContext.request.contextPath}/videos/${vc[0].vc_address }" controls preload id="video" style="width: 640px;height:360px"></video>

		</div>
		<div style="clear:both;"></div>
	</div>
	<div style="background-color: #fff;width: 100%;margin-top: 30px" align="center">
		<h3 align="center" style="padding-top: 10px">视频详情</h3>
		<table class="table table-hover" style="margin-top:5px">
			
			<tbody>
				<tr>
					<td>
						类型
					</td>
					<td>
						${video.ty_name }
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>
						点击量
					</td>
					<td>
						${video.v_views }
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>
						上传人
					</td>
					<td>
						${video.te_name }
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td>
						评分
					</td>
					<td>
						<c:if test="${username == null || usertype=='teacher' || usertype=='admin'}">
							<a href="${pageContext.request.contextPath}/login">登录</a>后评分
						</c:if>
						<c:if test="${username != null && usertype=='student'}">
							<form action="userScore?vid=${video.v_id }" method="post">
								<input type="text" name="score" class="form-control" id="exampleInputEmail1" oninput="value=value.replace(/[^\d.]/g,'')" style="width: 160px">
								<button type="submit" class="btn btn-primary">打分</button>
							</form>
						</c:if>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="clear:both;"></div>
	</div>
	
	<div style="background-color: #fff;width: 100%;margin-top: 30px">
		<div class="col-md-12">
			<h3 align="center">视频简介</h3>
			<h4>${video.v_intro }</h4>
		</div>

		<div style="clear:both;"></div>
	</div>
	
	<c:if test="${question != null}">
		<div style="background-color: #fff;width: 100%;margin-top: 30px;padding-bottom:15px">
			<div class="col-md-12">
				<h3 align="center">试题</h3>
				<c:forEach items="${question }" var="q" varStatus="st">
					<h5>${st.count }.${q.q_topic }</h5><font style="display:none;color:red" id="font${st.count-1 }">${q.q_answer }</font>
					<input type="text" />
				</c:forEach>
				<br/>
				<button onclick="select(${question.size()})">显示答案</button>
			</div>
	
			<div style="clear:both;"></div>
		</div>
	</c:if>
	<c:if test="${question == null}">本课程没有试题</c:if>
	
	<div style="background-color: #fff;width: 100%;margin-top: 30px">
		<div class="col-md-12">
			<h3 align="center">评论</h3>
			<table class="table table-hover" >
				<thead>
					<tr>
						<td>
							序号
						</td>
						<td>
							内容
						</td>
						<td>
							评论人
						</td>
						<td>
							评论时间
						</td>
						<td>
							操作
						</td>
					</tr>
				</thead>
				<c:forEach items="${comments }" var="c" varStatus="st">
					<tr>
						<td>${st.count }</td>
						<td>${c.co_content }</td>
						<td>${c.s_name }</td>
						<td>${c.co_time }</td>
						<td>
							<c:if test="${usertype=='student'&&c.co_sid == userid}">
								<a href="${pageContext.request.contextPath}/admin/deleteComments?id=${c.co_id}&vid=${video.v_id}">删除</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="clear:both;"></div>
	</div>

	<div style="background-color: #fff;width: 100%;margin-top: 30px" align="center">

		<c:if test="${username == null || usertype=='teacher' || usertype=='admin'}">
			<a href="${pageContext.request.contextPath}/login">登录</a>后评论
		</c:if>
		<c:if test="${username != null && usertype=='student'}">
			<div class="col-md-12" align="right">
				<form action="userComment?vid=${video.v_id }" method="post">
					<textarea rows="2" style="margin-top:10px;margin-bottom: 10px ;width:100%" name="context"></textarea>
					<div></div>
					<button type="submit" class="btn btn-primary">评论</button>
				</form>
			</div>
		</c:if>
		<div style="clear:both;"></div>
	</div>
</div>
<div class="col-md-2 col-sm-2">
	<c:if test="${vc != null}">
		<div style="background-color: #fff;width: 100%;margin-top: 0px;padding:5px">
			<c:forEach items="${vc}" var="v" varStatus="st">
      			<div style="margin:5px"><button onclick="setSrc('${v.vc_address}')" style="width: 100%;">${v.vc_name }</button></div>
      		</c:forEach>
		</div>
	</c:if>
	<c:if test="${vc == null}">视频出现错误,建议刷新</c:if>
</div>
<script type="text/javascript">
function setSrc(src){
	var s="${pageContext.request.contextPath}/videos/" + src;
	var video=document.getElementById("video");
	video.play();
	video.src = s;
}
function select(num){
	for(var i=0;i<num;i++){
		var font=document.getElementById("font"+i);
		font.style.display="block";
	}
}
</script>
<%@include  file="../tail.jsp"%>