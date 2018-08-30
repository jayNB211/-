<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath() %>/js/bootstrap-treeview.min.js"></script>
</head>

<div class="col-md-2">
<div id="tree">
</div>
<script>
$(document).ready(function(){
	$.ajax({  
		  type: "POST",
         url: '<%=request.getContextPath() %>/sm/queryNav',  
         dataType: "json",
         success: function (data) {  
        	 console.log(data);
        		$('#tree').treeview({
        			data:data,
        			enableLinks:true
        			});
         },  
         error: function () {  
             alert("error");  
         }  
     }); 
	
});

</script>
</div>