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
					违规记录</li>
				
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
									class="table table-striped table-bordered table-hover  onestudentbreakcase_table_info">
									<thead>
										<tr>
											
											<th>序号</th>
											<th>学号</th>
											<th>姓名</th>
											<th>宿舍</th>
											<th>违规时间</th>
											<th>违规情况</th>
											
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
	<script type="text/javascript" >
	$
	.post(
			'/ssglxt/Break/Break_getBreakListBysearchPage',
			{'breakVO.break_studentId':$('#input_PoliceSearchText').val(),"breakVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_breakList;
				var str = '';
				var count =0;
				for (var len = 0; len < data_list.length; len++) {
					if(data_list[len].break_studentId==<s:property value="#session.loginResult.obj.student_studentId"/>){
						count++;
						str += '<tr>';
						
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
						
						
							str += '</tr>';	
					}
					
				}
				// 加载案件列表到表格中
				$('.onestudentbreakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')

	
	</script>
</body>
</html>