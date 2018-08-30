<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>文件上传</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<jsp:include page="../../sm/top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<!--左边框 -->
			<jsp:include page="../../sm/menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 style="text-align: center;">文件上传</h1>
						</div>
					</div>
					<div id="content" class="panel-body">
						<form action="doUpload" name="doUpload" class="form-horizontal"
							enctype="multipart/form-data" method="post">

							<table>
								<tr>
									<td class="font3 fftd">文档标题：<input type="text"
										name="documentTitle" size="30" id="title" /></td>
								</tr>
								<tr>
									<td class="main_tdbor"></td>
								</tr>
								<tr>
									<td class="font3 fftd">文档描述：<br /> <textarea
											name="documentComment" cols="88" rows="11" id="content"></textarea>
									</td>
								</tr>
								<tr>
									<td class="main_tdbor"></td>
								</tr>

								<tr>
									<td class="font3 fftd">文档：<br /> <input type="file"
										name="file" id="file" size="30" />
									</td>
								</tr>
								<tr>
									<td class="font3 fftd">
										<button type="submit">上传</button> <input type="reset"
										value="重置">
									</td>
								</tr>
							</table>
						</form>
						<p>Tip：点击"上传"按钮.</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>