<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>职位显示</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">职位信息</h1>
							<form class="bs-example bs-example-form col-md-5" role="form"
								style="margin: 20px 0 10px 0;"
								action="positionSelectByName?name=" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入职位名称"
										name="findByName"> <span class="input-group-addon btn"
										id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px"
								onClick="location.href='positionAdd?positionId=${requestScope.position.positionId}'">
								添加职位信息
								<sapn class="glyphicon glyphicon-plus" />
							</button>

						</div>
					</div>
					<table class="table table-bordered">
						<tr>
							<th><nobr>列表序号</nobr></th>
							<th><nobr>职位名称</nobr></th>
							<th><nobr>职位等级</nobr></th>
							<th><nobr>所属部门</nobr></th>
							<th><nobr>职位描述</nobr></th>
							<th><nobr>创建时间</nobr></th>
							<th><nobr>创建人</nobr></th>
							<th><nobr>操 作</nobr></th>
						</tr>
						<%
							int i = 0;
						%>
						<c:forEach items="${requestScope.positions}" var="position">
							<%
								i = i + 1;
							%>
							<tr>
								<td><%=i%></td>
								<td>${position.positionName}</td>
								<td>${position.positionLevel}</td>
								<td>${position.department.depaName}</td>
								<td>${position.positionDescription}</td>
								<td><nobr>
										<fmt:formatDate value="${position.positionCreatedDatetime}"
											type="both" />
									</nobr></td>
								<td>${position.department.account.accountName}</td>
								<td>
									<button class="btn btn-default btn-xs btn-info"
										onClick="location.href='positionUpdate?positionId=${position.positionId}'">修改</button>
									<button class="btn btn-default btn-xs btn-danger btn-primary"
										onClick="location.href='positionDel?positionId=${position.positionId}'">删除</button>
									<!--弹出框-->
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="panel-footer">
						<c:if test="${pagingVO != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="positionList?page=${pagingVO.upPage}">&laquo;上一页</a></li>
									<li class="active"><a href="">${pagingVO.currentPage}</a></li>
									<c:if
										test="${pagingVO.currentPage+1 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+1}">${pagingVO.currentPage+1}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+2 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+2}">${pagingVO.currentPage+2}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+3 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+3}">${pagingVO.currentPage+3}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+4 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+4}">${pagingVO.currentPage+4}</a></li>
									</c:if>
									<li><a href="positionList?page=${pagingVO.totalCountPage}">最后一页&raquo;</a></li>
									<c:if
										test="${pagingVO.currentPage+5 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+5}">${pagingVO.currentPage+5}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+6 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+6}">${pagingVO.currentPage+6}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+7 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+7}">${pagingVO.currentPage+7}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+8 <= pagingVO.totalCountPage}">
										<li><a href="positionList?page=${pagingVO.currentPage+8}">${pagingVO.currentPage+8}</a></li>
									</c:if>
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