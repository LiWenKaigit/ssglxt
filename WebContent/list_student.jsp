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
					学生管理</li>
				<li style="color:#4c8fbd;">基本资料</li>
			</ul>
			<!-- /.breadcrumb -->
									
									<button style="margin-left:20px;" class="btn btn-minier btn-white btn-warning btn-bold " data-toggle="modal" onclick="deleteStudent()" >
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
											<th>学号</th>
											<th>姓名</th>
											<th>性别</th>
											<th>身份证号</th>
											<th>院系</th>
											<th>专业</th>
											<th>班级</th>
											<th>电话</th>
											<th>家庭住址</th>
											<th>楼号名称</th>
											<th>宿舍名称</th>
											<th>床位名称</th>
											<th>入住时间</th>
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
	
	
	<!-------------------------------------------修改学生信息的模态框--------------------------------------------------------->
	<div class="modal fade" id="updateStudent" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header widget-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">修改学生信息</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">学号</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_studentId"	name="student.student_studentId" type="text"></span>
										<input type="hidden"  name="student.student_id" id ="updatestudent_id">
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">姓名</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_name"	name="student.student_name" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">性别</span>
										<span style="float:left;margin:0 0 0 50px;width:159px;"><select  style="witdh: 80%;" class="form-control"
										id="updatestudent_sex"	name="student.student_sex" >
										<option value="男">男</option>
										<option value="女">女</option>
										</select>
										</span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">身份证号</span>
										<span style="float:left;margin:0 0 0 26px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_IDNUMBER"	name="student.student_IDNUMBER" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">院系</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_faculty"	name="student.student_faculty" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">专业</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_major"	name="student.student_major" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">班级</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_class"	name="student.student_class" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">电话</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_phone"	name="student.student_phone" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">家庭住址</span>
										<span style="float:left;margin:0 0 0 26px;"><input style="witdh: 80%;" class="form-control"
										id="updatestudent_address"	name="student.student_address" type="text"></span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">楼名称</span>
										<span style="float:left;margin:0 0 0 38px;width:159px;"><select  style="witdh: 80%;" class="form-control"
										id="updatestudent_buildingName"	name="student.student_buildingName" type="text">
										</select>
										</span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">宿舍名称</span>
										<span style="float:left;margin:0 0 0 26px;width:159px;"><select style="witdh: 80%;" class="form-control"
										id="updatestudent_dormitoryName"	name="student.student_dormitoryName" type="text">
										</select>
										</span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">床位名称</span>
										<span style="float:left;margin:0 0 0 26px;width:159px;"><select style="witdh: 80%;" class="form-control"
										id="updatestudent_bedName"	name="student.student_bedName" type="text">
										</select>
										</span>
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">入住时间</span>
<%-- 										<span style="float:left;margin:0 0 0 26px;"><input style="witdh: 80%;" class="form-control" --%>
<%-- 										id="updatestudent_checkIn_time"	name="student.student_checkIn_time" type="text"></span> --%>
						<div class="col-sm-9 " style="float:left;margin:0 0 0 10px;">
									<input type="text" id="laydateInput"
											name="student.student_checkIn_time" />
									<div class="select-date">
										<div class=" select-date-header">
											<ul class="heade-ul">
												<li class="header-item header-item-one"><select name=""
													id="yearList"></select></li>
												<li class="header-item header-item-two"
													onselectstart="return false"><select name=""
													id="monthList"></select></li>
												<li class="header-item header-item-three"
													onselectstart="return false"><span class="reback">回到今天</span>
												</li>
											</ul>
										</div>
										<div class="select-date-body">
											<ul class="week-list">
												<li>日</li>
												<li>一</li>
												<li>二</li>
												<li>三</li>
												<li>四</li>
												<li>五</li>
												<li>六</li>
											</ul>
											<ul class="day-tabel"></ul>
										</div>
									</div>
								</div>
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
	
	
	<script type="text/javascript" src="js/Admin/page_list_student2.js"></script>
	<script type="text/javascript">
	$
	.post(
			'/ssglxt/Student/Student_getStudentListBysearchPage',
			{'studentVO.student_name':$('#input_PoliceSearchText').val(),"studentVO.pageIndex" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_studentList;
				var str = '';
				var count =0 ;
				for (var len = 0; len < data_list.length; len++) {
				if(data_list[len].student_buildingName=="<s:property value="#session.loginResult.obj.admin_jobBuilding"/>"){			
					count++;
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].student_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (count) + '</td>';// 序号
					str += '<td>' + data_list[len].student_studentId//学号
							+ '</td>';
					str += '<td>' + data_list[len].student_name//姓名
					+ '</td>';
					str += '<td>' + data_list[len].student_sex//性别
					+ '</td>';
					str += '<td>' + data_list[len].student_IDNUMBER//身份证号
					+ '</td>';
					str += '<td>' + data_list[len].student_faculty//院系
					+ '</td>';
					str += '<td>' + data_list[len].student_major//专业
					+ '</td>';
					str += '<td>' + data_list[len].student_class//班级
					+ '</td>';
					str += '<td>' + data_list[len].student_phone//电话
					+ '</td>';
					str += '<td>' + data_list[len].student_address//家庭住址
					+ '</td>';
					str += '<td>' + data_list[len].student_buildingName//居住楼名称
					+ '</td>';
					str += '<td>' + data_list[len].student_dormitoryName//居住宿舍名称
					+ '</td>';
					str += '<td>' + data_list[len].student_bedName//居住床位名称
					+ '</td>';
					str += '<td>' + data_list[len].student_checkIn_time//入住时间
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].student_id
						+ '" data-toggle="modal" data-target="#updateStudent" onclick=getStudent("'+data_list[len].student_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				}
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
	</script>
	<script type="text/javascript">
	/*
	 * 搜索
	 */
	function searchUsername(query_data){
		$
		.post(
				'/ssglxt/Student/Student_getStudentListBysearchPage',
				{'studentVO.student_name':$('#input_PoliceSearchText').val(),"studentVO.pageIndex" : "1"},
				function(xhr) {
					var data_list = xhr.ssglxt_studentList;
					var str = '';
					var count = 0 ;
					for (var len = 0; len < data_list.length; len++) {
						if(data_list[len].student_buildingName=="<s:property value="#session.loginResult.obj.admin_jobBuilding"/>"){				
						count++;
						str += '<tr>';
						str += '<td>'
							+ '<input  type="checkbox" class="checkbox_select" value="'
							+ data_list[len].student_id
							+ '" >'
							+ '</td>';
						str += '<td>' + (count) + '</td>';// 序号
						str += '<td>' + data_list[len].student_studentId//学号
								+ '</td>';
						str += '<td>' + data_list[len].student_name//姓名
						+ '</td>';
						str += '<td>' + data_list[len].student_sex//性别
						+ '</td>';
						str += '<td>' + data_list[len].student_IDNUMBER//身份证号
						+ '</td>';
						str += '<td>' + data_list[len].student_faculty//院系
						+ '</td>';
						str += '<td>' + data_list[len].student_major//专业
						+ '</td>';
						str += '<td>' + data_list[len].student_class//班级
						+ '</td>';
						str += '<td>' + data_list[len].student_phone//电话
						+ '</td>';
						str += '<td>' + data_list[len].student_address//家庭住址
						+ '</td>';
						str += '<td>' + data_list[len].student_buildingName//居住楼名称
						+ '</td>';
						str += '<td>' + data_list[len].student_dormitoryName//居住宿舍名称
						+ '</td>';
						str += '<td>' + data_list[len].student_bedName//居住床位名称
						+ '</td>';
						str += '<td>' + data_list[len].student_checkIn_time//入住时间
						+ '</td>';
						
						str += '<td>'
							+ '<i id="'
							+ data_list[len].student_id
							+ '" data-toggle="modal" data-target="#updateStudent" onclick=getStudent("'+data_list[len].student_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
							+ '</td>';
							str += '</tr>';
						
					}
					}
					// 加载案件列表到表格中
					$('.breakcase_table_info tbody').html(str); // 操作点击事件
				}, 'json')
	}
	</script>
</body>
</html>