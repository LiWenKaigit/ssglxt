<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css" />
		<link rel="stylesheet" href="<%=basePath%>css/ace-fonts.css" />
		<link rel="stylesheet" href="<%=basePath%>css/ace.min.css" id="main-ace-style" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
	<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>
<title>登录</title>
</head>
<body  class="login-layout blur-login">
<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<span class="white">宿舍管理系统</span>
								</h1>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
											
												输入登录信息
											</h4>

											<div class="space-6"></div>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="userName" class="form-control" placeholder="用户名" />
															
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="password" class="form-control" placeholder="密码" />
															
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right" >
															<select class="form-control"  id="shenfen">
															<option value="1" >学生</option>
															<option value="2">宿舍管理员</option>
															<option value="3">超级管理员</option>
															</select>
															
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														
														<button onclick="login()" type="button" class="width-35  btn btn-sm btn-primary">
														
															<span class="bigger-110" >登录</span>
														</button>
														
														<button type="reset" style = "margin-left:20px;" class="width-35  pull-right btn btn-sm btn-primary">
														
															<span class="bigger-110">重置</span>
														</button>
														
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

										</div><!-- /.widget-main -->

										
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->

				

							</div><!-- /.position-relative -->

						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->
<script type="text/javascript" src="<%=basePath%>js/superAdmin/login.js"></script>
</body>
</html>