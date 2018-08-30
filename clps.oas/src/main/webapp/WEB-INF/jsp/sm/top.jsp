<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 顶栏 -->
<div class="container" id="top">
	<div class="row">
		<div class="col-md-12">
			<!--加入导航条标题-->
			<div class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<a href="#" class="navbar-brand">拍卖管理系统</a>
				</div>
				<form action="" class="navbar-form navbar-right" role="search">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown"
							style="margin-right: 20px;">
							<%--登录用户名--%>
							<span class="glyphicon glyphicon-user"></span> <span
								class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="${pageContext.request.contextPath}/sm/accountList"> <span
									class="glyphicon glyphicon-cog pull-right"></span> 所有账户信息
							</a></li>
							<!-- 分割线 -->
							<li role="presentation" class="divider"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="../index.jsp"> <span
									class="glyphicon glyphicon-off pull-right"></span> 注销
							</a></li>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
