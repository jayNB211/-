<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>增加邮件</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" id="content">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h3 style="text-align: center;">增加邮件</h3>
						</div>
					</div>
					<div id="content" class="panel-body">
						<form action="addEmail" name="myEmailAdd"
							class="form-horizontal" method="post">
			<table>
				<tr>
					<td>邮件主题：</td>
					<td><input type="text" name="emailSubject" value="">
				</tr>
				<tr>
					<td>收件人：</td>
					<td><input type="text" name="emailRecipient" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>收件人id：</td>
					<td><input type="text" name="emailRecipientId" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>邮件内容:</td>
					<td><textarea rows="10" cols="30" name="emailContent"></textarea></td>
				</tr>
				<tr>
					<td>邮件状态：</td>
					<td><input type="text" name="emailStatus" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td>邮件是否有效：</td>
					<td><input type="text" name="emailIsVisable" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交" name="submit"></td>
					<td><input type="reset" value="重置" name="reset"></td>
				</tr>
			</table>
		</form>
		<p>Tip：点击"提交"按钮.</p>
	</div>
</body>
</html>