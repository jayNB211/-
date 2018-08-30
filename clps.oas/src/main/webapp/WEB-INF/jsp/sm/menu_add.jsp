<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<!-- 引入JQuery  bootstrap.js-->
	<script src="<%=request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap-treeview.min.js"></script>
<title>新增菜单</title>
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
					    	<h1 style="text-align: center;">新增菜单信息</h1>
						</div>
				    </div>
				   <div class="panel-body">
						<form class="form-horizontal"  
						 action="menuAdd"  
								method="post">
						
							  <div class="form-group">
							    <label  class="col-sm-2 control-label"> 菜单名称：</label>
							    <div class="col-sm-10">
									<input class="form-control" placeholder="请输入菜单名称" name="menuName" required></input>
									<font color="red">*</font>
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <label  class="col-sm-2 control-label"> 上级菜单：</label>
							    <div class="col-sm-10">
									<input type="text" readonly id="topMenu" name="topMenu" class="form-control" 
									onclick="$('#treeview').show()" placeholder="上级菜单" required></input>
										<font color="red">*</font>
									<div id="treeview" style="display:none">  </div>
							    </div>
							  </div>
							
							  
							  <div class="form-group">
							    <label  class="col-sm-2 control-label">菜单排序号：</label>
							    <div class="col-sm-10">
							    	<input type="number" class="form-control" name="menuSortId" required></input>
									<font color="red">*</font>
							    </div>
							  </div>
							  
							    <div class="form-group">
							    <label  class="col-sm-2 control-label">   菜单URL：</label>
							    <div class="col-sm-10">
							  		<input name="menuUrl"  type="text" class="form-control" required></input>
								
									<font color="red">*</font>
							    </div>
							  </div>
							  
							  
							  
							    <div class="form-group">
							    <label  class="col-sm-2 control-label">   菜单状态：</label>
							    <div class="col-sm-10">
							  		  <input type="radio"  name="menuIsvariable"  checked value="1">有效
    									<input type="radio"  name="menuIsvariable"  value="0">无效
							    </div>
							  </div>
							  
					
							   <div class="form-group">
							    <label  class="col-sm-2 control-label">   菜单描述：</label>
							    <div class="col-sm-10">
							  		
								<textarea  name="menuComment" class="form-control"></textarea>
								
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
		<div class="col-md-12">
			
		</div>
	</div>
	</div>
</body>	
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({  
		  type: "POST",
         url: '<%=request.getContextPath() %>/sm/queryNav',  
         dataType: "json",  
         success: function (data) {  
        	 console.log(data);
        		$('#treeview').treeview({
        			data:data,
        			  showIcon: false
        			});
        		$('#treeview').on('nodeSelected', function(event, data) {  
        		
        			if(typeof data.parentId === "undefined"){
        				data.parentId=0;
        				}
        			data.level++;
        				$('#topMenu').val(data.text+"-"+data.id+'-'+data.level);
        	
     
        				$("#treeview").hide();  
        		})
         },  
         error: function () {  
             alert("error");  
         }  
     }); 
	
}); 


</script>
</html>
