<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<title>修改部门</title>
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
							<h1 style="text-align: center;">修改部门信息</h1>
						</div>
					</div>
					<div id="content" class="panel-body">
						<form
							action="updateDepartment?depaNumber=${department.depaNumber}"
							name="myDepartmentUpadate" method="post" class="form-horizontal">
							<table>
								<tr>
									<td>部门名称：</td>
									<td><input type="text" name="depaName"
										value="${department.depaName}"><font color="red">*</font></td>
								</tr>
								<tr>
									<td>上级部门编号：</td>
									<td><input type="text" name="depaFatherNumber"
										value="${department.depaFatherNumber}"><font
										color="red">*</font></td>
								</tr>
								<tr>
									<td>下级部门编号：</td>
									<td><input type="text" name="depaChildNumber"
										value="${department.depaChildNumber}"><font
										color="red">*</font></td>
								</tr>
								<tr>
									<td>部门等级：</td>
									<td><input type="text" name="depaLevel"
										value="${department.depaLevel}"><font color="red">*</font></td>
								</tr>
								<tr>
									<td>部门邮箱：</td>
									<td><input type="text" name="depaEmail"
										value="${requestScope.department.depaEmail}"><font
										color="red">*</font></td>
								</tr>
								<tr>
									<td>部门描述:</td>
									<td><textarea rows="10" cols="30" name="depaComment"
											value="${department.depaComment}"></textarea></td>
								</tr>
								<tr>
									<td>部门创建人名：</td>
									<td><input type="text" name="depaCreateName"
										value="${department.depaCreateName}"><font color="red">*</font></td>
								</tr>
								<tr>
									<td>部门修改人名：</td>
									<td><input type="text" name="depaUpdatedName"
										value="${department.depaName}"><font color="red">*</font></td>
								</tr>
								<tr>
									<td><input type="submit" value="提交" name="submit"></td>
									<td><input type="reset" value="重置" name="reset"></td>
								</tr>
							</table>
						</form>
						<p>Tip：点击"提交"按钮.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>