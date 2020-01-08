<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<!--------------------------------------------------------------------------------->
<script src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script src="<%=basePath%>js/bootstrap-select.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/ace.min.css">
<link rel="stylesheet" href="<%=basePath%>css/ace-skins.min.css">
<link rel="stylesheet" href="<%=basePath%>css/ace-rtl.min.css">
<script src="<%=basePath%>js/jquery-ui.custom.min.js"></script>
<script src="<%=basePath%>js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=basePath%>js/ace-elements.min.js"></script>
<script src="<%=basePath%>js/ace.min.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/chartist-custom.css">

<link rel="stylesheet"
	href="<%=basePath%>css/navbar/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css">
<link rel="stylesheet" href="<%=basePath%>css/table.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script src="<%=basePath%>js/toastr.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery-confirm.css" />
<script src="<%=basePath%>js/jquery-confirm.js"></script>
<!--------------------------------------------------------------------------------->
<script src="<%=basePath%>js/jquery.bootstrap.wizard.js"></script>
<script src="<%=basePath%>js/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>js/klorofil-common.js"></script>

<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery.datetimepicker.full.js"></script>
<!--------------------------------------------------------------------------------->

<link rel="stylesheet" href="<%=basePath%>css/jquery.datetimepicker.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.datetimepicker.full.js"></script>
<!------------------------------时间样式--------------------------------------------------->
<link rel="stylesheet" href="css/laydate.css" />
<script src="js/laydate.js"></script>
<!--------------------------------------------------------------------------------->
<!---页面公用------------------------------------------------------------------------------>
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<title>宿舍管理系统</title>

</head>
<body class="no-skin">
		<div id="navbar" class="navbar navbar-default">
			<div class="navbar-container" id="navbar-container">

				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="index.html" class="navbar-brand">
						<small>
							<h7>宿舍管理系统</h7>
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation" >
					<ul class="nav ace-nav">

						

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="img/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									欢迎您<br />
								<s:property value="#session.loginResultName"/>
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								

								<li>
									<a href="password.jsp" >
										<i class="ace-icon fa fa-user"></i>
										修改密码
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a  onclick="outDefine()">
										<i class="ace-icon fa fa-power-off"></i>
										登出
									</a>
								</li>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">

			<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar responsive">


				<ul class="nav nav-list">
					
					
					<s:if test="#session.loginResult.role==3">
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 宿舍信息管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="list_dormitoryBuilding.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									宿舍楼管理
								</a>

								<b class="arrow"></b>
							</li>
                            <li class="">
								<a href="list_dormitory.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									宿舍房间管理
								</a>

								<b class="arrow"></b>
							</li>       
							
							 <li class="">
								<a href="list_bed.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									宿舍床位管理
								</a>

								<b class="arrow"></b>
							</li>       
							
							
							
						</ul>
					</li>
					</s:if>
				 <s:if test="#session.loginResult.role==2">
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 学生管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>
                   
						<ul class="submenu">
						
							<li class="">
								<a href="list_student.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									基本资料
								</a>

								<b class="arrow"></b>
							</li>
                            <li class="">
								<a href="add_student.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									入住登记
								</a>

								<b class="arrow"></b>
							</li>       
							
							 <li class="">
								<a href="list_break.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									违规记录
								</a>

								<b class="arrow"></b>
							</li>       
							
							 <li class="">
								<a href="add_break.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									违规登记
								</a>

								<b class="arrow"></b>
							</li> 
							
						</ul>
				   
					</li>
				</s:if>
				
						 <s:if test="#session.loginResult.role==3">
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 学生管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>
                   
						<ul class="submenu">
						
							<li class="">
								<a href="Superlist_student.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									基本资料
								</a>

								<b class="arrow"></b>
							</li>
                            <li class="">
								<a href="Superadd_student.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									入住登记
								</a>

								<b class="arrow"></b>
							</li>       
							
							 <li class="">
								<a href="Superlist_break.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									违规记录
								</a>

								<b class="arrow"></b>
							</li>       
							
							 <li class="">
								<a href="Superadd_break.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									违规登记
								</a>

								<b class="arrow"></b>
							</li> 
							
						</ul>
				   
					</li>
				</s:if>
				
				<s:if test="#session.loginResult.role==3||#session.loginResult.role==2">
						<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 物品维修管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
						<s:if test="#session.loginResult.role==3">
							<li class="">
								<a href="add_repair.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									维修物品上报
								</a>

								<b class="arrow"></b>
							</li>
						</s:if>
						<s:if test="#session.loginResult.role==2">
                            <li class="">
								<a href="list_repair.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									维修物品信息管理
								</a>

								<b class="arrow"></b>
							</li>  
					    </s:if>    
					    <s:if test="#session.loginResult.role==3">
                            <li class="">
								<a href="Superlist_repair.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									维修物品信息管理
								</a>

								<b class="arrow"></b>
							</li>  
					    </s:if>      
						</ul>
					</li>
					</s:if>
					<s:if test="#session.loginResult.role==3">
					 <li class="">
						<a href="list_admin.jsp" >
							<i class="menu-icon fa fa-list"></i>
							 宿舍管理员管理 
						</a>
					</li>
                   </s:if>
                   	<s:if test="#session.loginResult.role==1">
				    <li class="">
						<a href="studentInformation.jsp">
							<i class="menu-icon fa fa-user-circle "></i>
							 个人信息
						</a>
					</li>
					</s:if>
					<s:if test="#session.loginResult.role==1">
					 <li class="">
						<a href="studentlist_break.jsp" >
							<i class="menu-icon fa fa-exclamation-triangle "></i>
							 违规记录
						</a>
					</li>
					</s:if>
					<s:if test="#session.loginResult.role==1">
					 <li class="">
						<a href="studentadd_repair.jsp" >
							<i class="menu-icon fa fa-send "></i>
							 维修物品上报
						</a>
					</li>
					</s:if>
				    <s:if test="#session.loginResult.role==1">
					<li class="">
						<a href="studentlist_repair.jsp" >
							<i class="menu-icon fa fa-thumb-tack"></i>
							 维修物品查看
						</a>
					</li>
				    </s:if>
				</ul><!-- /.nav-list -->

				
			</div>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<!-- #section:basics/content.breadcrumbs -->
				

				
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span class="bigger-120">
							 宿舍管理系统 &copy; 2019 
						</span>
					</div>

					<!-- /section:basics/footer -->
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>
		<script type="text/javascript" src="<%=basePath%>js/superAdmin/login.js"></script>
		</body>
</html>