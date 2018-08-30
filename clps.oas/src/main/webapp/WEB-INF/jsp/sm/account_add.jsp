<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>add_account</title>
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
							<h1 style="text-align: center;">新增账户信息</h1>
						</div>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="addAccount"
							id="editfrom" name="info" method="post">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">账号<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										name="accountName" required="required" placeholder="请输入账号">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">密码<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="accountPwd"
										name="accountPwd" required="required" placeholder="请输入密码">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">确认密码<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="rePwd"
										name="rePwd" required="required" placeholder="请再输入密码">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">姓名<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputPassword3"
										name="accountRealName" required="required" placeholder="请输入姓名">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">邮箱<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="inputEmail3"
										name="accountMail" required="required" placeholder="请输入邮箱">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">地址<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										required="required" name="accountAddress">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">电话<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="inputEmail3"
										name="accountPhone" required="required">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">角色<span
									style="color: red">&nbsp;&nbsp;*</span></label>
								<div class="col-sm-10">
									<select class="form-control" name="accountRoleId"
										required="required">
										<c:forEach items="${roleList}" var="role">
											<option value="${role.roleId}">${role.roleName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">职位<span>&nbsp;&nbsp;&nbsp;</span></label>
								<div class="col-sm-10">
									<select class="form-control" name="accountPositionId">
										<option value="0">未选择</option>
										<c:forEach items="${positionList}" var="position">
											<option value="${position.positionId}">${position.positionName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">公司<span>&nbsp;&nbsp;&nbsp;</span></label>
								<div class="col-sm-10">
									<select class="form-control" name="accountCompanyId">
										<option value="0">未选择</option>
										<option value="1">金陵科技学院1</option>
										<option value="2">金陵科技学院2</option>
										<option value="3">金陵科技学院3</option>
									</select>
								</div>
							</div>
							<div class="form-group" style="text-align: center">
								<button class="btn btn-default" type="reset">重置</button>
								<input type="submit" value="提交" class="btn btn-default"
									onClick="return checkPwd();">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function checkPwd() {

		var accountPwd = document.getElementById("accountPwd").value;
		var rePwd = document.getElementById("rePwd").value;

		if (accountPwd != rePwd) {
			alert("两次密码不一致！");
			return false;
		} else {
			return true;
		}
	}
</script>
</html>