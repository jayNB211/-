<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<title>角色信息显示</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.min.js"></script>


</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">角色名单管理</h1>
							<form class="bs-example bs-example-form col-md-5" role="form"
								style="margin: 20px 0 10px 0;" action="roleSelectByName?name="
								id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入角色名称"
										name="findByName"> <span class="input-group-addon btn"
										id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px"
								onClick="location.href='<%=basePath%>/sm/showAddRole'">
								添加职位信息
								<span class="glyphicon glyphicon-plus" />
							</button>
						</div>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>编号</th>
								<th>名字</th>
								<th>描述</th>
								<th>等级</th>
								<th >创建日期</th>
								<th>创建人名</th>
								<th>操 作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.roles}" var="role">
								<tr>
									<td>${role.roleId}</td>
									<td>${role.roleName}</td>
									<td>${role.roleComment}</td>
									<td>${role.roleLevel}</td>
									<td>${role.roleCreatedDatetime}</td>
									<td>${role.roleCreatedName}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info"
											onClick="location.href='<%=basePath%>/sm/showUpdateRole'">修改</button>
										<button class="btn btn-default btn-xs btn-danger btn-primary"
											onClick="location.href='delRole?roleId=${role.roleId}'">删除</button>
										<!--弹出框-->
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="panel-footer">
						<c:if test="${pagingVO != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="roleList?page=${pagingVO.upPage}">&laquo;上一页</a></li>
									<li class="active"><a href="">${pagingVO.currentPage}</a></li>
									<c:if
										test="${pagingVO.currentPage+1 <= pagingVO.totalCountPage}">
										<li><a href="roleList?page=${pagingVO.currentPage+1}">${pagingVO.currentPage+1}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+2 <= pagingVO.totalCountPage}">
										<li><a href="roleList?page=${pagingVO.currentPage+2}">${pagingVO.currentPage+2}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+3 <= pagingVO.totalCountPage}">
										<li><a href="roleList?page=${pagingVO.currentPage+3}">${pagingVO.currentPage+3}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+4 <= pagingVO.totalCountPage}">
										<li><a href="roleList?page=${pagingVO.currentPage+4}">${pagingVO.currentPage+4}</a></li>
									</c:if>
									<li><a href="roleList?page=${pagingVO.totalCountPage}">最后一页&raquo;</a></li>
								</ul>
							</nav>
						</c:if>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
		$("#nav li:nth-child(2)").addClass("active");

        function confirmd() {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        };

        $("#sub").click(function () {
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
