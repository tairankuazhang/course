<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="../head.jsp"%>
<div class="col-md-2 col-sm-2">
</div>
<div class="col-md-8 col-sm-8">
<div align="right"><button class="btn btn-primary"  data-toggle="modal" data-target="#insertConnection">添加视频</button></div>
<div class="modal fade" id="insertConnection" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div class="modal-content">
	    <div class="modal-header">
	      <h3 class="modal-title" id="exampleModalLabel">添加视频</h3>
	      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	        <span aria-hidden="true">&times;</span>
	      </button>
	    </div>
	    <form role="form" action="./insertConnection" method="post"  enctype="multipart/form-data">
	    <div class="modal-body  row">
	     <div class="col-md-3">
		<label for="exampleInputEmail1">
			视频名称：
		</label>
	  </div>
	     <div class="col-md-9">
	     	<input type="text" class="form-control" id="exampleInputEmail1" name="name"/>
	     	<input type="hidden" value="${connectionId }" name="vid"/>
	     </div>
	    </div>
	   
	    <div class="modal-body  row">
	     <div class="col-md-3">
	     	<label for="exampleInputEmail1">
				视频：
			</label>
	     </div>
	     <div class="col-md-9">
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
<c:if test="${listConnection != null}">
	<c:forEach items="${listConnection}" var="l" varStatus="st">
		<div class="col-md-6 col-sm-12"  align="center">
			<h3>${l.vc_name }</h3>
			<video src="${pageContext.request.contextPath}/videos/${l.vc_address }" controls preload id="video" style="width: 100%"></video>
			<a href="${pageContext.request.contextPath}/teacher/deleteConnectionByid?id=${l.vc_id }&vid=${connectionId}">删除</a>
		</div>
	</c:forEach>
</c:if>
<c:if test="${listConnection == null}">
没有视频，请添加。
</c:if>
</div>
<div class="col-md-2 col-sm-2">
</div>
<%@include  file="../tail.jsp"%>