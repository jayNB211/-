<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>show_accounts</title>
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
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<!--左边框 -->
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">账户信息管理</h1>
							<form class="bs-example bs-example-form col-md-5" role="form"
								style="margin: 20px 0 10px 0;" action="selectAccount" id="form1"
								method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入账户名"
										name="accountName"><span class="input-group-addon btn"
										id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px"
								onClick="location.href='account_addView'">
								新增账户信息
								<div class="glyphicon glyphicon-plus"></div>
							</button>
						</div>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>账号</th>
								<th>姓名</th>
								<th>邮箱</th>
								<th>地址</th>
								<th>电话</th>
								<th>角色</th>
								<th>职位</th>
								<th>部门</th>
								<th>公司</th>
								<th>创建日期</th>
								<th>创建人名</th>
								<th>修改日期</th>
								<th>修改人名</th>
								<th>操&nbsp;&nbsp;作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.accounts}" var="account"
								varStatus="i">
								<tr>
									<td>${i.count}</td>
									<td>${account.accountName}</td>
									<td>${account.accountRealName}</td>
									<td>${account.accountMail}</td>
									<td>${account.accountAddress}</td>
									<td>${account.accountPhone}</td>
									<td>${account.accountRoleName}</td>
									<td>${account.accountPositionName}</td>
									<td>${account.accountDepartmentName}</td>
									<td>${account.accountCompanyId}</td>
									<td><fmt:formatDate
											value="${account.accountCreatedDatetime}" type="both" /></td>
									<td>${account.accountCreatedName}</td>
									<td><fmt:formatDate
											value="${account.accountUpdatedDatetime}" type="both" /></td>
									<td>${account.accountUpdatedName}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info"
											onClick="location.href='account_updateView?accountId=${account.accountId}'">修改</button>
										<a href="logicDelAccount?accountId=${account.accountId}"
										class="btn btn-default btn-xs btn-danger btn-primary"
										onclick="javascript:return del_confirm();">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="panel-footer">
						<c:if test="${pagingVO != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="accountList?page=1">首页</a></li>
									<li><a href="accountList?page=${pagingVO.upPage}">&laquo;上一页</a></li>
									<li class="active"><a href="">${pagingVO.currentPage}</a></li>
									<c:if
										test="${pagingVO.currentPage+1 <= pagingVO.totalCountPage}">
										<li><a href="accountList?page=${pagingVO.currentPage+1}">${pagingVO.totalCountPage}</a></li>
									</c:if>
									<li><a href="accountList?page=${pagingVO.nextPage}">下一页&raquo;</a></li>
									<li><a href="accountList?page=${pagingVO.totalCountPage}">尾页</a></li>
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
	function del_confirm() {
		return confirm("是否确认删除账户信息?")
	};

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