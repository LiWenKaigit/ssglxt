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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<div style="margin-top: -75px;">
		<div class="breadcrumbs" id="breadcrumbs" style="margin-left: 190px;">
			<ul class="breadcrumb">
				<li style="color:#4c8fbd;"><i class="ace-icon fa fa-home home-icon"></i>
					宿舍管理员管理</li>
			
			</ul>
			<!-- /.breadcrumb -->
            
									<button class="btn  btn-minier btn-white btn-info btn-bold " data-toggle="modal" data-target="#addAdmin" >
										<i class="fa fa-plus-square"></i> 添加宿舍管理员
									</button>
									
									<button style="margin-left:20px;" class="btn btn-minier btn-white btn-warning btn-bold " data-toggle="modal" onclick="deleteAdmin()" >
										<i class="fa fa-plus-square"></i> 删除所选
									</button>
									
								
			<!-- #section:basics/content.searchbox -->
			<div class="nav-search" id="nav-search">
				<form class="form-search">
					<span class="input-icon"> <input type="text"
						placeholder="请输入关键字 ..." class="nav-search-input"
						id="input_PoliceSearchText"  oninput="searchUsername()" autocomplete="off" /> <i
						class="ace-icon fa fa-search nav-search-icon"></i>
					</span>
				</form>
			</div>
			<!-- /.nav-search -->
		</div>

		<div class="page-content" style="margin-left: 200px;">

			<!-- /section:settings.box -->
			<div class="page-content-area">

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="row">
							<div class="col-xs-12">
								<table id="sample-table-1" style="text-align: center;"
									class="table table-striped table-bordered table-hover  breakcase_table_info">
									<thead>
										<tr>
											<th class="center"><label class="position-relative">
													<input type="checkbox" class="ace" id="checkbox_all_select" onclick="all_select()"/> <span class="lbl"></span>
											</label></th>
											<th>序号</th>
											<th>工号</th>
											<th>姓名</th>
											<th>性别</th>
											<th>年龄</th>
											<th>工作楼号</th>
											<th>联系电话</th>
											<th>家庭住址</th>
											<th>操作</th>
										</tr>
									</thead>

									<tbody>
									
									</tbody>
								</table>
							</div>
							<!-- /.span -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content-area -->
		</div>
		<!-- /.page-content -->
	</div>
	
	<!-------------------------------------------添加宿舍管理员的模态框--------------------------------------------------------->
	<div class="modal fade" id="addAdmin" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header widget-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">添加宿舍管理员</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">工号</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
											name="admin.admin_jobNumber" type="text"></span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">姓名</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
											name="admin.admin_name" type="text"></span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">性别</span>
										<span style="float:left;margin:0 0 0 50px;width:159px;"><select style="witdh: 80%;" class="form-control"
											name="admin.admin_sex" type="text">
											<option value="男">男</option>
											<option value="女">女</option>
											</select>
											</span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">年龄</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
											name="admin.admin_age" type="text"></span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">工作楼号</span>
										<span style="float:left;margin:0 0 0 26px;width:159px;"><select style="witdh: 80%;" class="form-control"
										id="admin_jobBuilding"	name="admin.admin_jobBuilding" type="text">
											</select>
											</span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">联系电话</span>
										<span style="float:left;margin:0 0 0 26px;"><input style="witdh: 80%;" class="form-control"
											name="admin.admin_phone" type="text"></span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">家庭住址</span>
										<span style="float:left;margin:0 0 0 26px;"><input style="witdh: 80%;" class="form-control"
											name="admin.admin_address" type="text"></span>
										<input type="hidden"  >
						</div>
						
					
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary input_sure">添加</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	
	<!-------------------------------------------修改宿舍管理员的模态框--------------------------------------------------------->
	<div class="modal fade" id="updateAdmin" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header widget-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">修改宿舍管理员信息</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">工号</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updateadmin_jobNumber"	name="admin.admin_jobNumber" type="text"></span>
										<input type="hidden"  name="admin.admin_id" id ="updateadmin_id">
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">姓名</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updateadmin_name"	name="admin.admin_name" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">性别</span>
										<span style="float:left;margin:0 0 0 50px;width:159px;"><select style="witdh: 80%;" class="form-control"
										id="updateadmin_sex"	name="admin.admin_sex" type="text">
									     <option value="男">男</option>
									     <option value="女">女</option>
										</select>
										</span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">年龄</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updateadmin_age"	name="admin.admin_age" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">工作楼号</span>
										<span style="float:left;margin:0 0 0 26px;width:159px;"><select style="witdh: 80%;" class="form-control"
										id="updateadmin_jobBuilding"	name="admin.admin_jobBuilding" type="text">
										</select>
										</span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">联系电话</span>
										<span style="float:left;margin:0 0 0 26px;"><input style="witdh: 80%;" class="form-control"
										id="updateadmin_phone"	name="admin.admin_phone" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">家庭住址</span>
										<span style="float:left;margin:0 0 0 26px;"><input style="witdh: 80%;" class="form-control"
										id="updateadmin_address"	name="admin.admin_address" type="text"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary update_input_sure">修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	
	<script type="text/javascript" src="js/superAdmin/page_list_admin.js"></script>
</body>
</html>