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
				<li style="color:#4c8fbd;">违规记录</li>
			</ul>
			<!-- /.breadcrumb -->
									
									<button style="margin-left:20px;" class="btn btn-minier btn-white btn-warning btn-bold " data-toggle="modal" onclick="deleteBreak()" >
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
											<th>宿舍</th>
											<th>违规时间</th>
											<th>违规情况</th>
											<th>操作</th>
										</tr>
									</thead>

									<tbody>
									
									</tbody>
									<tfoot>
									<tr>
										<td colspan="8" style="font-size: 12px;" class="page_info"><a
											onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i>
										</a>&nbsp&nbsp<a onclick="prePage()"><i
												class="fa fa-angle-left"></i>上一页 </a>&nbsp&nbsp<a
											onclick="nextPage()">下一页<i class="fa fa-angle-right"></i>
										</a>&nbsp&nbsp <a onclick="lastPage()">尾页<i
												class="fa fa-angle-double-right"></i>
										</a> <br />
											<p class='info'></p></td>
									</tr>
								</tfoot>
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
	
	
	<!-------------------------------------------修改违规信息的模态框--------------------------------------------------------->
	<div class="modal fade" id="updateBreak" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header widget-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">修改学生违规信息</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">学号</span>
										<span style="float:left;margin:0 0 0 62px;"><input style="witdh: 80%;" class="form-control"
										id="updatebreak_studentId"	name="break1.break_studentId" type="text"></span>
										<input type="hidden"  name="break1.break_id" id ="updatebreak_id">
						</div>
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">违规时间</span>
<%-- 										<span style="float:left;margin:0 0 0 38px;"><input style="witdh: 80%;" class="form-control" --%>
<%-- 										id="updatebreak_time"	name="break1.break_time" type="text"></span> --%>
							<div class="col-sm-9 " style="float:left;margin:0 0 0 20px;">
								<input type="text" id="laydateInput" name="break1.break_time" />
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
						
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">违规情况</span>
										<span style="float:left;margin:0 0 0 38px;"><input style="witdh: 80%;" class="form-control"
										id="updatebreak_reason"	name="break1.break_reason" type="text"></span>
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
	
	
	<script type="text/javascript" src="js/Admin/page_list_break.js"></script>
	
	<script type="text/javascript">
	/*
	 * 搜索
	 */
	function searchUsername(query_data){
		$
		.post(
				'/ssglxt/Break/Break_getBreakListBysearchPage',
				{'breakVO.break_studentId':$('#input_PoliceSearchText').val(),"breakVO.currPage" : "1"},
				function(xhr) {
					var data_list = xhr.ssglxt_breakList;
					var str = '';
					var count = 0;
					for (var len = 0; len < data_list.length; len++) {
						
						count++;
						str += '<tr>';
						str += '<td>'
							+ '<input  type="checkbox" class="checkbox_select" value="'
							+ data_list[len].break_id
							+ '" >'
							+ '</td>';
						str += '<td>' + (count) + '</td>';// 序号
						str += '<td>' + data_list[len].break_studentId//学号
								+ '</td>';
						str += '<td>' + xhr.ssglxt_studentList[len].student_name//姓名
						+ '</td>';
						str += '<td>' + xhr.ssglxt_studentList[len].student_buildingName + xhr.ssglxt_studentList[len].student_dormitoryName//宿舍
						+ '</td>';
						str += '<td>' + data_list[len].break_time//违规时间
						+ '</td>';
						str += '<td>' + data_list[len].break_reason//违规情况
						+ '</td>';
						
						str += '<td>'
							+ '<i id="'
							+ data_list[len].break_id
							+ '" data-toggle="modal" data-target="#updateBreak" onclick=getBreak("'+data_list[len].break_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
							+ '</td>';
							str += '</tr>';
						
					
					}
					// 加载案件列表到表格中
					$('.breakcase_table_info tbody').html(str); // 操作点击事件
				}, 'json')
	}
	
	
	
	</script>
</body>
</html>