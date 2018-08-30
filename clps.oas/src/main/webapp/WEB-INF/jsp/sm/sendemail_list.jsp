<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>邮件信息显示</title>

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
			<jsp:include page="menu.jsp"></jsp:include> 
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 class="col-md-5">邮件管理</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="queryMailByName" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入收件人姓名" name="emailRecipient">
									<span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='toAddEmail'">
								新增邮件信息
								<sapn class="glyphicon glyphicon-plus"/>
							<tton>

						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>序号</th>
									<th>邮件主题</th>
									<th>收件人</th>
									<th>邮件内容</th>
									<th>操  作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach items="${requestScope.sendemails}" var="sendemail" varStatus="stauts">
								<tr>
									<td>${stauts.count}</td> 
									<td>${sendemail.emailSubject}</td>
									<td>${sendemail.emailRecipient}</td>
									<td>${sendemail.emailContent}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='getEmail?emailId=${sendemail.emailId}'">编辑<tton>
										<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='delEmail?emailId=${sendemail.emailId}'">删除<tton>
									</td>
								</tr>
							</c:forEach>
					        </tbody>
				    </table>

					<div class="panel-footer">
						<c:if test="${pagingVO != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="sendemailList?page=${pagingVO.upPage}">&laquo;上一页</a></li>
									<li class="active"><a href="">${pagingVO.currentPage}</a></li>
									<c:if
										test="${pagingVO.currentPage+1 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+1}">${pagingVO.currentPage+1}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+2 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+2}">${pagingVO.currentPage+2}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+3 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+3}">${pagingVO.currentPage+3}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+4 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+4}">${pagingVO.currentPage+4}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+5 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+5}">${pagingVO.currentPage+5}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+6 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+6}">${pagingVO.currentPage+6}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+7 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+7}">${pagingVO.currentPage+7}</a></li>
									</c:if>
									<c:if
										test="${pagingVO.currentPage+8 <= pagingVO.totalCountPage}">
										<li><a href="sendemailList?page=${pagingVO.currentPage+8}">${pagingVO.currentPage+8}</a></li>
									</c:if>
									<li><a href="sendemailList?page=${pagingVO.totalCountPage}">最后一页&raquo;</a></li>
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

</script>
</html>