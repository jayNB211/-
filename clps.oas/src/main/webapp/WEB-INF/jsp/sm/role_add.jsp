<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
	<title>添加角色信息</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
	<script src="<%=basePath%>/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 中间主体 -->
<div class="container" id="content">
	<div class="row">
		<div class="col-md-10">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<h1 style="text-align: center;">添加角色信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="<%=basePath%>/sm/addRole" id="addRole" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">角色号</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="inputEmail3" name="roleId" placeholder="请输入角色号">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">角色名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputPassword3" name="roleName" placeholder="请输入角色名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">角色描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="roleComment" placeholder="请输入角色描述">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">角色等级</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" name="roleLevel" placeholder="请输入角色等级">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">角色创建日期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="roleCreatedDatetime" placeholder="请输入角色创建日期">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">角色创建人名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="roleCreatedName" placeholder="请输入角色创建人名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">角色更新日期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="roleUpdatedDatetime" placeholder="请输入角色更新日期">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">角色更新人名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="roleUpdatedName" placeholder="请输入角色更新人名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">备注1</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="roleDefault1" placeholder="请输入备注1">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">备注2</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="roleDefault2" placeholder="请输入备注2">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">是否有效</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" name="roleIsvaild" placeholder="请输入是否有效">
							</div>
						</div>
						<div class="form-group" style="text-align: center">
							<button class="btn btn-default" type="submit">提交</button>
							<button class="btn btn-default" type="reset">重置</button>
						</div>
					</form>
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
    $("#nav li:nth-child(1)").addRole("active")
</script>
</html>