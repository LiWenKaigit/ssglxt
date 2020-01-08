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
				<li style="color:#4c8fbd;">入住登记</li>
			</ul>
			<!-- /.breadcrumb -->
            			
			
		</div>

		<div class="page-content" style="margin-left: 200px;">
			<div class="page-content-area">
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<form class="form-horizontal" role="form" id="addStudent">
							<!-- #section:elements.form -->
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 学号：</label>

								<div class="col-sm-9">
									<input type="text" id="student_studentId" placeholder="输入学号"
										class="col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">姓名： </label>

								<div class="col-sm-9">
									<input type="text" id="student_name" placeholder="输入姓名"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">性别： </label>

								<div class="col-sm-9">
									<select  id="student_sex" style="list-style:none;padding:0;margin:0;" type="text"
										class=" col-xs-10 col-sm-5" >
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">身份证号： </label>

								<div class="col-sm-9">
									<input type="text" id="student_IDNUMBER" placeholder="输入身份证号"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">院系： </label>

								<div class="col-sm-9">
									<input type="text" id="student_faculty" placeholder="输入院系"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">专业： </label>

								<div class="col-sm-9">
									<input type="text" id="student_major" placeholder="输入专业"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">班级： </label>

								<div class="col-sm-9">
									<input type="text" id="student_class" placeholder="输入班级"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">电话： </label>

								<div class="col-sm-9">
									<input type="text" id="student_phone" placeholder="输入电话"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">家庭住址： </label>

								<div class="col-sm-9">
									<input type="text" id="student_address" placeholder="输入家庭住址"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">楼名称： </label>

								<div class="col-sm-9">
									<select type="text" id="student_buildingName" style="list-style:none;padding:0;margin:0;"
										class=" col-xs-10 col-sm-5" >
										</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">宿舍名称： </label>

								<div class="col-sm-9">
									<select type="text" id="student_dormitoryName" style="list-style:none;padding:0;margin:0;"
										class=" col-xs-10 col-sm-5" >
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">床位名称： </label>

								<div class="col-sm-9">
									<select type="text" id="student_bedName" style="list-style:none;padding:0;margin:0;"
										class=" col-xs-10 col-sm-5" >
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">入住时间： </label>

<!-- 								<div class="col-sm-9"> -->
<!-- 									<input type="text" id="student_checkIn_time" placeholder="输入入住时间" -->
<!-- 										class=" col-xs-10 col-sm-5" /> -->
<!-- 								</div> -->
								<div class="col-sm-9 ">
									<input type="text" id="laydateInput"
										name="student_checkIn_time" />
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
						
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button" onclick="add_student()">
										<i class="ace-icon fa fa-check bigger-110"></i> 立即提交
									</button>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> 重置
									</button>
								</div>
						
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	<script type="text/javascript" src="js/Admin/student.js"></script>
</body>
</html>