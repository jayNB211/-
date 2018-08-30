<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<!-- 引入JQuery  bootstrap.js-->
	<script src="<%=request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	
<title>Insert title here</title>
</head>
<body >
<jsp:include page="top.jsp"></jsp:include>
	<div class="container" id="content">
		<div class="row">
		<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading" >
						<div class="row">
					    	<h2 class="col-md-3">菜单信息</h2>
					    	<button class="btn btn-default btn-xs btn-info col-md-2" style="margin-top: 30px" 
							onClick="location.href='<%=request.getContextPath() %>/sm/menu_add'">
								新增菜单信息
								<span class="glyphicon glyphicon-plus"/>
							</button>			
						<form class="bs-example bs-example-form col-md-7" role="form" style="margin: 20px 0 10px 0;" action="<%=request.getContextPath() %>/sm/menu_list" id="form1" method="post">
								<div class="input-group">
												<select name="date" class="form-control" style="width:100px">
										<option value="0">全部</option>
										<option value="7">近七天</option>
										<option value="30">近三十天</option>
					
									</select>
									<input type="text" class="form-control" style="width:200px" placeholder="请输入关键字" name="keyWord"></input>
									<button type="sumbit" class="btn btn-default  btn-info">查询</span>
								</div>
								</form>
						</div>
				    </div>
		<table class="table table-bordered">
			<tr>
			<th>序号</th>
			<th>名称</th>
			<th>排序号</th>
			<th>状态</th>
			<th>URL</th>
			<th>创建日期</th>
			<th>创建人名</th>
			<th  width="150px">操作</th>
			</tr>
	<c:forEach items="${listMenu}" var="menu">
 	<tr>
		<td>${menu.menuId}</td>
		<td>${menu.menuName}</td>
		<td>${menu.menuSortId}</td>
		<td>${menu.menuIsvariable}</td>
		<td>${menu.menuUrl}</td>
		<td><fmt:formatDate value="${menu.menuCreatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		<td>${menu.menuCreatedName}</td>
		
		<td>
	<button class="btn btn-default btn-xs btn-info" onClick="location.href='<%=request.getContextPath() %>/sm/findMenuById?menuId=${menu.menuId}&menuParentid=${menu.menuParentid}'">修改</button>
	<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='<%=request.getContextPath() %>/sm/changeMenuState?menuId=${menu.menuId}'">启用</button>

		</td>
	</tr>
	</c:forEach>
</table>
	   
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

</script>
</html>