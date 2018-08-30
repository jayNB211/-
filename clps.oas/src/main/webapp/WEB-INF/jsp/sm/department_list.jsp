<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>


<title>部门显示</title>

</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container" id="content">
		<div class="row">
			<!--左边框 -->
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">部门信息表</h1>
							<form action="queryDepartmentById"
								class="bs-example bs-example-form col-md-5" role="form"
								style="margin: 20px 0 10px 0;" method="post">
								<div class="input-group">
									<input type="text" name="depaNumber" class="form-control"
										placeholder="请输入ID号："></input> <span class="input-group-btn">
										<button type="sumbit" class="btn btn-default  btn-info">查询</button>
									</span>
								</div>
							</form>
							<form action="queryDepartmentsByName"
								class="bs-example bs-example-form col-md-5" role="form"
								style="margin: 20px 0 10px 0;" method="post">
								<div class="input-group">
									<input type="text" name="depaName" class="form-control"
										placeholder="请输入部门名称："></input> <span class="input-group-btn">
										<button type="sumbit" class="btn btn-default  btn-info">查询</button>
									</span>
								</div>
							</form>
							<div>
								<button class="btn btn-default col-md-2"
									style="margin-top: 20px"
									onClick="location.href='toAddDepartment'">新增部门</button>
							</div>


						</div>
					<div class="row">
							&nbsp;&nbsp;
							<button class="btn btn-default btn-info " style="margin-top: 8px"
								onClick="location.href='<%=request.getContextPath()%>/sm/importDepartmentVoFromExcel'">
								excel信息导入</button>
							&nbsp;&nbsp;

							<button class="btn btn-default btn-info " style="margin-top: 8px"
								onClick="location.href='<%=request.getContextPath()%>/sm/exportDepartmentVoToExcel'">
								信息导出到excel</button>

						</div>
					</div>



					<table border="1" class="table table-bordered">
						<tr>
							<th>部门编号</th>
							<th>部门名称</th>
							<th>上级部门编号</th>
							<th>下级部门编号</th>
							<th>部门等级</th>
							<th>部门邮箱</th>
							<th>部门描述</th>
							<th>部门创建人名</th>
							<th>部门创建日期</th>
							<th>部门修改人名</th>
							<th>部门修改日期</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${requestScope.departments}" var="department">
							<tr>
								<td>${department.depaNumber}</td>
								<td>${department.depaName}</td>
								<td>${department.depaFatherNumber}</td>
								<td>${department.depaChildNumber}</td>
								<td>${department.depaLevel}</td>
								<td>${department.depaEmail}</td>
								<td>${department.depaComment}</td>
								<td>${department.depaCreateName}</td>
								<td><fmt:formatDate
										value="${department.depaCreateDatetime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>${department.depaUpdatedName}</td>
								<td><fmt:formatDate
										value="${department.depaUpdatedDatetime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>
									<button class="btn btn-default btn-xs btn-info"
										onClick="location.href='updateView?depaNumber=${department.depaNumber}'">修改</button>
									<button class="btn btn-default btn-xs btn-danger btn-primary"
										onClick="location.href='delDepartment?depaNumber=${department.depaNumber}'">删除</button>
							</tr>
						</c:forEach>
					</table>


					<div class="panel-footer">
						<c:if test="${pagingVO != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="departmentList?page=${pagingVO.upPage}">&laquo;上一页</a></li>
									<li class="active"><a href="">${pagingVO.currentPage}</a></li>
									<c:if
										test="${pagingVO.currentPage+1 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+1}">${pagingVO.currentPage+1}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+2 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+2}">${pagingVO.currentPage+2}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+3 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+3}">${pagingVO.currentPage+3}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+4 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+4}">${pagingVO.currentPage+4}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+5 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+5}">${pagingVO.currentPage+5}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+6 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+6}">${pagingVO.currentPage+6}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+7 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+7}">${pagingVO.currentPage+7}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+8 <= pagingVO.totalCountPage}">
										<li><a
											href="departmentList?page=${pagingVO.currentPage+8}">${pagingVO.currentPage+8}</a></li>
									</c:if>
									<li><a
										href="departmentList?page=${pagingVO.totalCountPage}">最后一页&raquo;</a></li>
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