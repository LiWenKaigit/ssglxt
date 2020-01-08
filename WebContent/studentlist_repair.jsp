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
					物品维修查看</li>
			</ul>
			<!-- /.breadcrumb -->
									
									
									
								
			<!-- #section:basics/content.searchbox -->
		
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
											
											<th>序号</th>
											<th>学号</th>
											<th>姓名</th>
											<th>宿舍</th>
											<th>报修物品名</th>
											<th>报修物品备注</th>
											<th><select id="passed">
													<option value="待处理" selected = "selected">待处理</option>
													<option value="已处理">已处理</option>
											</select></th>
											<th>上报时间</th>
											<th id="operation">操作</th>
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
	
	
	<!-------------------------------------------修改报修物品信息的模态框--------------------------------------------------------->
	<div class="modal fade" id="updateRepair" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header widget-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">修改报修物品信息</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">学号</span>
										<span style="float:left;margin:0 0 0 86px;"><input style="witdh: 80%;" class="form-control"
										id="updaterepair_studentId"	name="repair.repair_studentId" type="text"></span>
										<input type="hidden"  name="repair.repair_id" id ="updaterepair_id">
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">报修物品名</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updaterepair_name"	name="repair.repair_name" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">报修物品备注</span>
										<span style="float:left;margin:0 0 0 38px;"><input style="witdh: 80%;" class="form-control"
										id="updaterepair_remarks"	name="repair.repair_remarks" type="text"></span>
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
	
	
	<script type="text/javascript" >
	$
	.post(
			'/ssglxt/Repair/Repair_getRepairOkListBysearchPage',
			{'repairVO.repair_name':$('#input_PoliceSearchText').val(),"repairVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_repairList;
				var str = '';
				var count=0;
				for (var len = 0; len < data_list.length; len++) {
					if(data_list[len].repair_studentId==<s:property value="#session.loginResult.obj.student_studentId"/>){
						count++;
					
					str += '<tr>';
					
					str += '<td>' + (count) + '</td>';// 序号
					str += '<td>' + data_list[len].repair_studentId//学号
							+ '</td>';
					str += '<td>' + xhr.ssglxt_studentList[len].student_name//姓名
							+ '</td>';		
					str += '<td>' + xhr.ssglxt_studentList[len].student_buildingName + xhr.ssglxt_studentList[len].student_dormitoryName//宿舍
							+ '</td>';		
					str += '<td>' + data_list[len].repair_name//报修物品名
					+ '</td>';
					str += '<td>' + data_list[len].repair_remarks//报修物品备注
					+ '</td>';
					str += '<td>' + data_list[len].repair_status//物品维修状态
					+ '</td>';
					str += '<td>' + data_list[len].repair_modify_time//上报时间
					+ '</td>';
					
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].repair_id
						+ '" data-toggle="modal" data-target="#updateRepair" onclick=getRepair("'+data_list[len].repair_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
					}
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
	
	</script>
	<script type="text/javascript">
	$("select#passed").change(
			function() {
			

				$.post('/ssglxt/Repair/Repair_getRepairListBysearchPage', {'repairVO.repair_status':$('#passed').val() ,'repairVO.currPage' : 1 },
					function(xhr) {
						var data_list = xhr.ssglxt_repairList;
						var str = '';
						var count = 0;
						for (var len = 0; len < data_list.length; len++) {
							if(data_list[len].repair_studentId==<s:property value="#session.loginResult.obj.student_studentId"/>){
							count++;	
							
							str += '<tr>';
							
							str += '<td>' + (count) + '</td>';// 序号
							str += '<td>' + data_list[len].repair_studentId//学号
									+ '</td>';
						    str += '<td>' + xhr.ssglxt_studentList[len].student_name//姓名
									+ '</td>';		
							str += '<td>' + xhr.ssglxt_studentList[len].student_buildingName + xhr.ssglxt_studentList[len].student_dormitoryName//宿舍
									+ '</td>';	
							str += '<td>' + data_list[len].repair_name//报修物品名
							+ '</td>';
							str += '<td>' + data_list[len].repair_remarks//报修物品备注
							+ '</td>';
							str += '<td>' + data_list[len].repair_status//物品维修状态
							+ '</td>';
							str += '<td>' + data_list[len].repair_modify_time//上报时间
							+ '</td>';
							
							
							if(data_list[len].repair_status=="待处理"){
								$("#operation").show();
								str += '<td>'
									+ '<i id="'
									+ data_list[len].repair_id
									+ '" data-toggle="modal" data-target="#updateRepair" onclick=getRepair("'+data_list[len].repair_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
									+ '</td>';
							}
							if(data_list[len].repair_status=="已处理"){
								$("#operation").hide();
							}
							
								str += '</tr>';
						}
						}
						// 加载案件列表到表格中
						$('.breakcase_table_info tbody').html(str); // 操作点击事件
				}, 'json')
			})
	
	</script>
	<script type="text/javascript" src="js/student/studentpage_list_repair.js"></script>
</body>
</html>