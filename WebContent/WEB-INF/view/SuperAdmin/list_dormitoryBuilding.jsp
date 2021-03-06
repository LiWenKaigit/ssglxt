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
					宿舍信息管理</li>
				<li style="color:#4c8fbd;">宿舍楼管理</li>
			</ul>
			<!-- /.breadcrumb -->
            
									<button class="btn  btn-minier btn-white btn-info btn-bold " data-toggle="modal" data-target="#addDormitoryBuilding" >
										<i class="fa fa-plus-square"></i> 添加宿舍楼
									</button>
									
									<button style="margin-left:20px;" class="btn btn-minier btn-white btn-warning btn-bold " data-toggle="modal" onclick="deleteDormitoryBuilding()" >
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
											<th>楼名称</th>
											<th>房间数</th>
											<th>居住性别</th>
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
	
	<!-------------------------------------------添加宿舍楼的模态框--------------------------------------------------------->
	<div class="modal fade" id="addDormitoryBuilding" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header widget-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">添加宿舍楼</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">楼名称</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
											name="dormitoryBuilding.dormitoryBuilding_buildingName" type="text"></span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">房间数</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
											name="dormitoryBuilding.dormitoryBuilding_roomNumber" type="text"></span>
										<input type="hidden"  >
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">居住性别</span>
										<span style="float:left;margin:0 0 0 38px;"><input style="witdh: 80%;" class="form-control"
											name="dormitoryBuilding.dormitoryBuilding_liveSex" type="text"></span>
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
	
	
	<!-------------------------------------------修改宿舍楼的模态框--------------------------------------------------------->
	<div class="modal fade" id="updateDormitoryBuilding" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header widget-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">修改宿舍楼信息</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">楼名称</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatedormitoryBuilding_buildingName"	name="dormitoryBuilding.dormitoryBuilding_buildingName" type="text"></span>
										<input type="hidden"  name="dormitoryBuilding.dormitoryBuilding_id" id ="updatedormitoryBuilding_id">
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">房间数</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatedormitoryBuilding_roomNumber"	name="dormitoryBuilding.dormitoryBuilding_roomNumber" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">居住性别</span>
										<span style="float:left;margin:0 0 0 38px;"><input style="witdh: 80%;" class="form-control"
										id="updatedormitoryBuilding_liveSex"	name="dormitoryBuilding.dormitoryBuilding_liveSex" type="text"></span>
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
	
	
	<script type="text/javascript" src="js/superAdmin/page_list_dormitoryBuilding.js"></script>
</body>
</html>