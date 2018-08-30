<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增职位</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
	//及时验证职位名称
	function checkPositionname() {
		//在每个函数中定义check变量是为了在表单提交后，能够逐个验证每个函数是否通过，很好很好。（以下同理）
		var check;
		var positionName = document.getElementById("positionName").value;
		if (positionName.length > 18 || positionName.length < 6) {
			alert("职位名输入不合法，请重新输入！");
			//此处甚妙，既然你在此处输入错误，那么按理说当然要在此处继续输入了。（在此处继续获取焦点！）
			document.getElementById("positionName").focus();
			check = false;
		} else {
			document.getElementById("checktext1").innerHTML = "* 职位名由6-18位字符组成 √";
			check = true;
		}
		return check;
	}
//验证部门描述小于150字
	function checkDescription(){
		  var check; 
		  var description = document.getElementById("positionDescription").value; 
		  if (description.length > 150) { 
		   alert("字数超限！"); 
		   check = false; 
		  } else { 
		   document.getElementById("checktext9").innerHTML = "* 限150字内 √";
		   document.getElementById("checktext9").focus();
		   check = true; 
		  } 
		  return check; 
		 } 
		 
	//提交时验证部门号
	 function checkpositionDepartmentId(){
	  var check; 
	  var positionDepartmentId = document.getElementById("positionDepartmentId").value;
	  if(!(positionDepartmentId.length>0))
	   {
	    alert("职位部门不得为空！");
	    document.getElementById("positionDepartmentId").focus();
	    check = false; 
	   }else{
	    document.getElementById("checktext3").innerHTML = "* 请输入职位部门号 √"; 
	    check = true; 
	   }
	  return check; 
	 }
		 
	//提交时验证职位等级
	 function checkpositionLevel(){
	  var check; 
	  var positionLevel = document.getElementById("positionLevel").value;
	  if(!(positionLevel.length>0))
	   {
	    alert("职位等级不得为空！");
	    document.getElementById("positionLevel").focus();
	    check = false; 
	   }else{
	    document.getElementById("checktext4").innerHTML = "* 请输入职位等级 √"; 
	    check = true; 
	   }
	  return check; 
	 }
	/* //提交表单时所有都验证一遍(若任何一个验证不通过，则返回为false，阻止表单提交)
	 function check() { 
		  var check = checkPositionname() && checkDescription() && checkpositionLevel() && checkpositionDepartmentId(); 
		  return check; 
		 }  */
</script>
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
							<h1 style="text-align: center;">添加职位信息</h1>
						</div>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form"
							action="positionAddsuccess" name="myPositionAdd" method="post">
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">职位名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="positionName"
										name="positionName" placeholder="请输入姓名"
										onchange=" checkPositionname()">
								</div>
								<label for="inputPassword3" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<p id="checktext1">* 职位名由6-18位字符组成</p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">职位所属部门</label>
								<div class="col-sm-10">
									<select class="form-control" name="positionDepartmentId" id="positionDepartmentId" onchange="checkpositionDepartmentId()">
										<option value="0">未选择</option>
										<c:forEach items="${departmentLists}" var="department">
											<option value="${department.depaNumber}">${department.depaName}</option>
										</c:forEach>
									</select>
								</div>
								<label for="inputPassword3" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<p id="checktext3">* 请输入职位部门号</p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">职位等级</label>
								<div class="col-sm-10">
									<select class="form-control" id="positionLevel" name="positionLevel" onchange="checkpositionLevel()">
										<option value="0">未选择</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</div>
								<!-- <div class="col-sm-10">
									<input type="number" class="form-control" id="positionLevel"
										name="positionLevel" placeholder="请输入职位等级"
										onchange="checkpositionLevel()">
								</div> -->
								<label for="inputPassword3" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<p id="checktext4">* 请输入职位等级</p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">职位描述</label>
								<div class="col-sm-10">
									<textarea name="positionDescription" class="form-control"
										rows="5" id="positionDescription"
										onchange="checkDescription()" placeholder="请输入部门描述"></textarea>
								</div>
								<label for="inputPassword3" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
									<p id="checktext9">* 限150字内</p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">职位更新人</label>
								<div class="col-sm-10">
									<input readonly="readonly" type="text" class="form-control"
										id="inputPassword3" name="positionCreatedIdName"
										value="${account.accountName}">
								</div>
							</div>
							<!-- 职位更新人仅用来传参并不显示 -->
							<div hidden="hidden">
								<label for="inputEmail3" class="col-sm-2 control-label">职位更新人ID</label>
								<div class="col-sm-10">
									<input readonly="readonly" type="number" class="form-control"
										id="inputEmail3" name="positionCreatedName"
										placeholder="请输入ID号"
										<c:if test='${position!=null}'>
										 value="${position.positionCreatedName}"
								  </c:if>>
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
</body>
</html>