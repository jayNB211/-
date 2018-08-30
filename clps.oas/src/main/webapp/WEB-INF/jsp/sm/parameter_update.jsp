<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 顶栏 -->
	
	<!-- 中间主体 -->
		<div class="container" id="content">
		<div class="row">
			
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 style="text-align: center;">修改参数信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="updateParameter" id="editfrom" method="post">
							  
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">参数名称:</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputPassword3" name="parameterName" value="${parameter.parameterName}" />
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">参数内容:</label>
							    <div class="col-sm-10">
								   <input style="width:150px;height:50px" name="parameterConent"  value="${parameter.parameterConent }" />
							    </div>
							  </div>
							<div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">关联参数:</label>
							    <div class="col-sm-10">
								    <input type="text" class="form-control" id="inputPassword3" name="parameterSpuelid" value="${parameter.parameterSpuelid }"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">参数描述:</label>
							    <div class="col-sm-10">
								    <input style="width:250px;height:100px;"  name="parameterComment"  value="${parameter.parameterComment }"/>
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
</html>