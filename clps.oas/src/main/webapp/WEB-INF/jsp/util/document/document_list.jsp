<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>网上拍卖系统 ——文件信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body>
	<!-- 顶栏 -->
	<jsp:include page="../../sm/top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<!--左边框 -->
			<jsp:include page="../../sm/menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">文件信息</h1>
							<form class="bs-example bs-example-form col-md-5" role="form"
								style="margin: 20px 0 10px 0;" action="queryDocumentLikeTitle"
								id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入文件标题"
										name="patternTitle"> <span
										class="input-group-addon btn"
										onclick="document.getElementById('form1').submit" id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px"
								onClick="location.href='documentUpload'">
								上传文件
								<sapn class="glyphicon glyphicon-plus" />
							</button>
						</div>
						<div class="row">
							&nbsp;&nbsp;
							<button class="btn btn-default btn-info " style="margin-top: 8px"
								onClick="location.href='<%=request.getContextPath()%>/sm/importDocumentVoFromExcel'">
								excel信息导入</button>
							&nbsp;&nbsp;

							<button class="btn btn-default btn-info " style="margin-top: 8px"
								onClick="location.href='<%=request.getContextPath()%>/sm/exportDocumentVoToExcel'">
								信息导出到excel</button>

						</div>
					</div>



					<table class="table table-bordered">
						<thead>
							<tr>
								<!-- 查询所有显示file  -->
								<th>序号</th>
								<th>文件标题</th>
								<th>文件描述</th>
								<th>创建时间</th>
								<th>创建人</th>
								<th>修改时间</th>
								<th>修改人</th>
								<th>操作</th>
								<th>下载</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.documents}" var="document"
								varStatus="stauts">
								<tr>
									<td>${stauts.count}</td>
									<td>${document.documentTitle }</td>
									<td>${document.documentComment}</td>
									<td><fmt:formatDate
											value="${document.documentCreatedDatetime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${document.documentCreatedName}</td>
									<td><fmt:formatDate
											value="${document.documentUpdatedDatetime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${document.documentUpdatedName}</td>
									<td><a
										href="documentUpdate?documentId=
									${document.documentId}"
										class="btn btn-default btn-xs btn-info"
										onclick="javascript:void(0);">编辑</a> <a
										href="documentDelete?documentId=
									${document.documentId}"
										class="btn btn-default btn-xs btn-danger btn-primary"
										onclick="javascript:void(0);">删除</a></td>
									<td><a
										href="documentDownload?documentId=
									${document.documentId}"
										class="btn btn-default btn-xs btn-info"
										onclick="javascript:void(0);">下载</a></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
					<div class="panel-footer">
						<c:if test="${pagingVO != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="documentList?page=1">首页</a></li>
									<li><a href="documentList?page=${pagingVO.upPage}">&laquo;上一页</a></li>
									<li class="active"><a href="">${pagingVO.currentPage}</a></li>
									<c:if
										test="${pagingVO.currentPage+1 <= pagingVO.totalCountPage}">
										<li><a href="documentList?page=${pagingVO.currentPage+1}">${pagingVO.totalCountPage}</a></li>
									</c:if>
									<li><a href="documentList?page=${pagingVO.nextPage}">下一页&raquo;</a></li>
									<li><a href="documentList?page=${pagingVO.totalCountPage}">尾页</a></li>
								</ul>
							</nav>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#nav li:nth-child(2)").addClass("active");

	$("#sub").click(function() {
		$("#form1").submit();
	});
	
	<c:if test="${pagingVO != null}">
	if (${pagingVO.currentPage} == ${pagingVO.totalCountPage}) {
		$(".pagination li:last-child").addClass("disabled")
	};

	if (${pagingVO.currentPage} == ${1}) {
		$(".pagination li:nth-child(1)").addClass("disabled")
	};
    </c:if>
</script>
</html>