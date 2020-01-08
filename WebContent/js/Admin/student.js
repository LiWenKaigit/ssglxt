$(function(){
	 $.post('/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingListBysearchPage',
				{"dormitoryBuildingVO.currPage" : "1"},
				function(xhr) {
					var data_list = xhr.ssglxt_dormitoryBuildingList;
					var option = '';
					for (var len = 0; len < data_list.length; len++) {
						option += '<option ';
						if (len==0) {
							option += 'selected';
							 $.post('/ssglxt/Dormitory/Dormitory_getDormitoryByDormitoryBuildingName',
										{"dormitory.dormitory_buildingName" : data_list[0].dormitoryBuilding_buildingName},
										function(xhr) {
											var option = '';
											for (var len = 0; len < xhr.length; len++) {
												option += '<option ';
												if (len==0) {
													option += 'selected';
												}
												 $.post('/ssglxt/Bed/Bed_getBedByDormitoryAndDormitoryBuilding',
															{"bed.bed_buildingName" : data_list[0].dormitoryBuilding_buildingName,"bed.bed_dormitoryName" : xhr[0].dormitory_name},
															function(bed) {
																var option = '';
																for (var len = 0; len < bed.length; len++) {
																	option += '<option ';
																	if (len==0) {
																		option += 'selected';
																	}
																	
																	option += ' value="'
																			+ bed[len].bed_name + '">'
																			+ bed[len].bed_name + '</option>';
																}
																$('#student_bedName').html(option);
																// 除去加载提示
																$('.load_remind').remove();
															}, 'json');
												option += ' value="'
														+ xhr[len].dormitory_name + '">'
														+ xhr[len].dormitory_name + '</option>';
											}
											$('#student_dormitoryName').html(option);
											// 除去加载提示
											$('.load_remind').remove();
										}, 'json');
						}
						option += ' value="'
								+ data_list[len].dormitoryBuilding_buildingName + '">'
								+ data_list[len].dormitoryBuilding_buildingName + '</option>';
					}
					$('#student_buildingName').html(option);
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
});

/*
 * 学生入住
 */
function add_student(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	var student_studentId = document.getElementById("student_studentId").value;//学号
	var student_name = document.getElementById("student_name").value;//姓名
	var student_sex = document.getElementById("student_sex").value;//性别
	var student_IDNUMBER = document.getElementById("student_IDNUMBER").value;//身份证号
	var student_faculty = document.getElementById("student_faculty").value;//院系
	var student_major = document.getElementById("student_major").value;//专业
	var student_class = document.getElementById("student_class").value;//班级
	var student_phone = document.getElementById("student_phone").value;//电话
	var student_address = document.getElementById("student_address").value;//家庭住址
	var student_buildingName = document.getElementById("student_buildingName").value;//楼号
	var student_dormitoryName = document.getElementById("student_dormitoryName").value;//宿舍号
	var student_bedName = document.getElementById("student_bedName").value;//床位号
	var student_checkIn_time = document.getElementById("laydateInput").value;//入住时间
	var fromDate = new FormData();	
	fromDate.append("student.student_studentId",student_studentId);

	fromDate.append("student.student_name",student_name);
	fromDate.append("student.student_sex",student_sex);
	fromDate.append("student.student_IDNUMBER",student_IDNUMBER);
	fromDate.append("student.student_faculty",student_faculty);
	fromDate.append("student.student_major",student_major);
	fromDate.append("student.student_class",student_class);
	fromDate.append("student.student_phone",student_phone);
	fromDate.append("student.student_address",student_address);
	fromDate.append("student.student_buildingName",student_buildingName);
	fromDate.append("student.student_dormitoryName",student_dormitoryName);
	fromDate.append("student.student_bedName",student_bedName);
	fromDate.append("student.student_checkIn_time",student_checkIn_time);
	xmlhttp.open("post","/ssglxt/Student/Student_addStudent",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var xhr=xmlhttp.responseText;
	if (xhr == 1) {
		toastr.success('添加成功!');
		window.location.href="list_student.jsp";
	} else {
		alert(xhr);
		toastr.error('添加失败!');
		return false;
	}
	    }
	  }

}

/*
 * 违规登记
 */
function add_break(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	var break_studentId = document.getElementById("break_studentId").value;//学号
	var break_time = document.getElementById("laydateInput").value;//违规时间
	var break_reason = document.getElementById("break_reason").value;//违规原因
	
	var fromDate = new FormData();	
	fromDate.append("break1.break_studentId",break_studentId);
	fromDate.append("break1.break_time",break_time);
	fromDate.append("break1.break_reason",break_reason);
	
	xmlhttp.open("post","/ssglxt/Break/Break_addBreak",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var xhr=xmlhttp.responseText;
	if (xhr == 1) {
		toastr.success('添加成功!');
		window.location.href="list_break.jsp";
	} else {
		alert(xhr);
		toastr.error('添加失败!');
		return false;
	}
	    }
	  }

}
/*
 * 维修物品上报
 */
function add_repair(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	var repair_studentId = document.getElementById("repair_studentId").value;//学号
	var repair_name = document.getElementById("repair_name").value;//维修物品名
	var repair_remarks = document.getElementById("repair_remarks").value;//报修备注
	
	var fromDate = new FormData();	
	fromDate.append("repair.repair_studentId",repair_studentId);
	fromDate.append("repair.repair_name",repair_name);
	fromDate.append("repair.repair_remarks",repair_remarks);
	
	xmlhttp.open("post","/ssglxt/Repair/Repair_addRepair",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var xhr=xmlhttp.responseText;
	if (xhr == 1) {
		toastr.success('添加成功!');
		window.location.href="list_repair.jsp";
	} else {
		alert(xhr);
		toastr.error('添加失败!');
		return false;
	}
	    }
	  }
}
/**
 * 根据宿舍楼得到宿舍房间
 */
$("#student_buildingName").change(function(){
	 $.post('/ssglxt/Dormitory/Dormitory_getDormitoryByDormitoryBuildingName',
				{"dormitory.dormitory_buildingName" : $('#student_buildingName').val()},
				function(xhr) {
					var option = '';
					for (var len = 0; len < xhr.length; len++) {
						option += '<option ';
						if(len==0){
							option += 'selected';
						}
						option += ' value="'
								+ xhr[len].dormitory_name + '">'
								+ xhr[len].dormitory_name + '</option>';
					}
					$('#student_dormitoryName').html(option);
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
});

/**
 * 根据宿舍楼和房间得到床位
 */
$("#student_dormitoryName").change(function(){
	 $.post('/ssglxt/Bed/Bed_getBedByDormitoryAndDormitoryBuilding',
				{"bed.bed_buildingName" : $('#student_buildingName').val(),"bed.bed_dormitoryName" : $('#student_dormitoryName').val()},
				function(bed) {
					var option = '';
					for (var len = 0; len < bed.length; len++) {
						option += '<option ';
						if (len==0) {
							option += 'selected';
						}
						
						option += ' value="'
								+ bed[len].bed_name + '">'
								+ bed[len].bed_name + '</option>';
					}
					$('#student_bedName').html(option);
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
});


