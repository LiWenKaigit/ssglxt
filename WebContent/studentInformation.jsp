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
					个人信息</li>
<!-- 				<button style="margin-left:20px;" class="btn btn-minier btn-white btn-primary btn-bold "  onclick="changeEdit()" > -->
<!--                  <i class="fa fa-pencil" aria-hidden="true"></i> -->
<!-- 									编辑个人信息 -->
<!-- 									</button> -->
			</ul>
			<!-- /.breadcrumb -->
            			
			
		</div>

		<div class="page-content" style="margin-left: 200px;">
			<div class="page-content-area">
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<form class="form-horizontal" role="form" id="StudentInformation">
							<!-- #section:elements.form -->
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 学号：</label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_studentId" placeholder="输入学号"
										class="col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">姓名： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_name" placeholder="输入姓名"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">性别： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_sex" placeholder="输入性别"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">身份证号： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_IDNUMBER" placeholder="输入身份证号"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">院系： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_faculty" placeholder="输入院系"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">专业： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_major" placeholder="输入专业"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">班级： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_class" placeholder="输入班级"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">电话： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_phone" placeholder="输入电话"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">家庭住址： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_address" placeholder="输入家庭住址"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">楼名称： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_buildingName" placeholder="输入楼名称"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">宿舍名称： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_dormitoryName" placeholder="输入宿舍名称"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">床位名称： </label>

								<div class="col-sm-9">
									<input type="text" id="updatestudent_bedName" placeholder="输入床位名称"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">入住时间： </label>

								<!-- 								<div class="col-sm-9"> -->
								<!-- 									<input type="text" id="updatestudent_checkIn_time" placeholder="输入入住时间" -->
								<!-- 										class=" col-xs-10 col-sm-5" /> -->
								<!-- 								    <input type="hidden" id="updatestudent_id" >		 -->
								<!-- 								</div> -->
								<!-- ---------------------------- -->
								<div class="col-sm-9 ">
									<input type="text" id="laydateInput"
										name="updatestudent_checkIn_time" />
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
								<input type="hidden" id="updatestudent_id">
							</div>

							<div class="col-md-offset-3 col-md-9">
<!-- 									<button class="btn btn-info" type="button" id="editStudentInformation" onclick="editstu()"> -->
<!-- 										<i class="ace-icon fa fa-check bigger-110"></i> 立即提交 -->
<!-- 									</button> -->

								</div>
						
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	var fromDate = new FormData();	
	fromDate.append("student.student_id","<s:property value="#session.loginResult.obj.student_id"/>");
	xmlhttp.open("post","/ssglxt/Student/Student_getStudentById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		 
	    var student=xmlhttp.responseText;
	    student = JSON.parse(student);
	    $('#updatestudent_studentId').val(student.student_studentId);//学号
	    $('#updatestudent_name').val(student.student_name);//姓名
	    $('#updatestudent_sex').val(student.student_sex);//性别
	    $('#updatestudent_IDNUMBER').val(student.student_IDNUMBER);//身份证号
	    $('#updatestudent_faculty').val(student.student_faculty);//院系
	    $('#updatestudent_major').val(student.student_major);//专业
	    $('#updatestudent_class').val(student.student_class);//班级
	    $('#updatestudent_phone').val(student.student_phone);//电话
	    $('#updatestudent_address').val(student.student_address);//家庭住址
	    $('#updatestudent_buildingName').val(student.student_buildingName);//楼名称
	    $('#updatestudent_dormitoryName').val(student.student_dormitoryName);//宿舍名称
 	    $('#updatestudent_bedName').val(student.student_bedName);//床位名称
	    $('#laydateInput').val(student.student_checkIn_time);//入住时间
	  
	    $('#updatestudent_id').val(student.student_id);
	    }
 }
	</script>
	<script type="text/javascript" src="js/student/studentInformation.js"></script>
	<script type="text/javascript">
	function editstu(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		var updatestudent_studentId = document.getElementById("updatestudent_studentId").value;
		var updatestudent_name = document.getElementById("updatestudent_name").value;
		var updatestudent_sex = document.getElementById("updatestudent_sex").value;
		var updatestudent_IDNUMBER = document.getElementById("updatestudent_IDNUMBER").value;
		var updatestudent_faculty = document.getElementById("updatestudent_faculty").value;
		var updatestudent_major = document.getElementById("updatestudent_major").value;
		var updatestudent_class = document.getElementById("updatestudent_class").value;
		var updatestudent_phone = document.getElementById("updatestudent_phone").value;
		var updatestudent_address = document.getElementById("updatestudent_address").value;
		var updatestudent_buildingName = document.getElementById("updatestudent_buildingName").value;
		var updatestudent_dormitoryName = document.getElementById("updatestudent_dormitoryName").value;
		var updatestudent_bedName = document.getElementById("updatestudent_bedName").value;
		var updatestudent_checkIn_time = document.getElementById("laydateInput").value;
		
		var updatestudent_id = document.getElementById("updatestudent_id").value;
		var fromDate = new FormData();	
		fromDate.append("student.student_id",updatestudent_id);
		fromDate.append("student.student_studentId",updatestudent_studentId);
		fromDate.append("student.student_name",updatestudent_name);
		fromDate.append("student.student_sex",updatestudent_sex);
		fromDate.append("student.student_IDNUMBER",updatestudent_IDNUMBER);
		fromDate.append("student.student_faculty",updatestudent_faculty);
		fromDate.append("student.student_major",updatestudent_major);
		fromDate.append("student.student_class",updatestudent_class);
		fromDate.append("student.student_phone",updatestudent_phone);
		fromDate.append("student.student_address",updatestudent_address);
		fromDate.append("student.student_buildingName",updatestudent_buildingName);
		fromDate.append("student.student_dormitoryName",updatestudent_dormitoryName);
		fromDate.append("student.student_bedName",updatestudent_bedName);
		fromDate.append("student.student_checkIn_time",updatestudent_checkIn_time);
		xmlhttp.open("post","/ssglxt/Student/Student_updateStudent",true);
		xmlhttp.send(fromDate);
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		    var xhr=xmlhttp.responseText;
			if (xhr == 1) {
				toastr.success('修改成功!');
				window.location.href="studentInformation.jsp"
			} else {
				toastr.error('修改失败!');
				return false;
			}
		    }
		  }
}
	</script>
</body>
</html>