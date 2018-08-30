<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>参数信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

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
					    	<h1 class="col-md-3">参数管理</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="selectParameter" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入名称" name="findByName">
									<span class="input-group-addon btn" id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='parameterAdd'">
								添加参数信息
								<sapn class="glyphicon glyphicon-plus"/>
							</button>

						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>参数编号</th>
									<th>参数名称</th>
									<th>参数内容</th>
									<th>参数关联的参数</th>
									<th>参数描述</th>
									<th>创建人名</th>
									<th>创建日期</th>
									<th>操&nbsp;作</th>
								</tr>
					        </thead>
					        <tbody>
							<c:forEach items="${parameters }" var="parameter">
								<tr>
									<td>${parameter.parameterId}</td>
									<td>${parameter.parameterName}</td>	
									<td>${parameter.parameterConent}</td>		
									<td>${parameter.parameterSpuelid}</td>		
									<td>${parameter.parameterComment}</td>	
									<td>${parameter.parameterCreatedName}</td>	
									<td>${parameter.parameterCreatedDatetime}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='findParameterById?parameterId=${parameter.parameterId}'">修改</button>
										<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='deleteParameter?parameterId=${parameter.parameterId}'">删除</button>
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
									<li><a href="parameterList?page=1">首页</a></li>
									<li><a href="parameterList?page=${pagingVO.upPage}">&laquo;上一页</a></li>
									<li class="active"><a href="">${pagingVO.currentPage}</a></li>
									<c:if
										test="${pagingVO.currentPage+1 <= pagingVO.totalCountPage}">
										<li><a href="parameterList?page=${pagingVO.currentPage+1}">${pagingVO.totalCountPage}</a></li>
									</c:if>
									<li><a href="parameterList?page=${pagingVO.nextPage}">下一页&raquo;</a></li>
									<li><a href="parameterList?page=${pagingVO.totalCountPage}">尾页</a></li>
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
		return confirm("是否确认删除参数信息?")
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