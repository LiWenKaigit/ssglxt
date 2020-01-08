var query_data = {
	"studentVO.pageIndex" : "1",
};
//$(function(){
//	get_ListBreakecaseInformationByPageAndSearch(query_data);
//})
//当前页面分页信息
//var page_infomantion = {
//	currPage : 1,
//	countRecords : 1,
//	pageSize : 10,
//	totalPages : 1,
//	havePrePage : false,
//	haveNexPage : false,
//}
/*
 *查询列表
 */
//function get_ListBreakecaseInformationByPageAndSearch(){
//	$
//	.post(
//			'/ssglxt/Student/Student_getStudentListBysearchPage',
//			{'studentVO.student_name':$('#input_PoliceSearchText').val(),"studentVO.currPage" : "1"},
//			function(xhr) {
//				var data_list = xhr.ssglxt_studentList;
//				var str = '';
//				var count =0 ;
//				for (var len = 0; len < data_list.length; len++) {
//					count++;
//					str += '<tr>';
//					str += '<td>'
//						+ '<input  type="checkbox" class="checkbox_select" value="'
//						+ data_list[len].student_id
//						+ '" >'
//						+ '</td>';
//					str += '<td>' + (count) + '</td>';// 序号
//					str += '<td>' + data_list[len].student_studentId//学号
//							+ '</td>';
//					str += '<td>' + data_list[len].student_name//姓名
//					+ '</td>';
//					str += '<td>' + data_list[len].student_sex//性别
//					+ '</td>';
//					str += '<td>' + data_list[len].student_IDNUMBER//身份证号
//					+ '</td>';
//					str += '<td>' + data_list[len].student_faculty//院系
//					+ '</td>';
//					str += '<td>' + data_list[len].student_major//专业
//					+ '</td>';
//					str += '<td>' + data_list[len].student_class//班级
//					+ '</td>';
//					str += '<td>' + data_list[len].student_phone//电话
//					+ '</td>';
//					str += '<td>' + data_list[len].student_address//家庭住址
//					+ '</td>';
//					str += '<td>' + data_list[len].student_buildingName//居住楼名称
//					+ '</td>';
//					str += '<td>' + data_list[len].student_dormitoryName//居住宿舍名称
//					+ '</td>';
//					str += '<td>' + data_list[len].student_bedName//居住床位名称
//					+ '</td>';
//					str += '<td>' + data_list[len].student_checkIn_time//入住时间
//					+ '</td>';
//					
//					str += '<td>'
//						+ '<i id="'
//						+ data_list[len].student_id
//						+ '" data-toggle="modal" data-target="#updateStudent" onclick=getStudent("'+data_list[len].student_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
//						+ '</td>';
//						str += '</tr>';
//					
//				
//				}
//				// 加载案件列表到表格中
//				$('.breakcase_table_info tbody').html(str); // 操作点击事件
//				//分页信息存入page_infomantion中
//				page_infomantion.pageIndex = xhr.pageIndex; //当前页数
//				page_infomantion.totalRecords = xhr.totalRecords; //总页数
//				page_infomantion.pageSize = xhr.pageSize; //每页记录数
//				page_infomantion.totalPages = xhr.totalPages; //总记录数
//				page_infomantion.HavePrePage = xhr.HavePrePage; //是否有上一页
//				page_infomantion.HaveNextPage = xhr.HaveNextPage; //是否有下一页
//				$('.info').html('共 ' + xhr.totalRecords + '条信息 当前' + xhr.pageIndex + '/' + xhr.totalPages + '页 ' + xhr.pageSize + '条信息/页&nbsp&nbsp转到第'
//						+ '<select onchange="toPage(this)">' + opt + '</select> 页');
//			}, 'json')
//}
/*
 * 添加学生
 */
$('.input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/Student/Student_addStudent',
					$('#addStudent form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('添加成功!');
							$('#addStudent').modal('hide');
							$('#addStudent input').val("");
							window.location.reload();
						} else {
							toastr.error('添加失败!');
							return false;
						}
					}, 'text')
		});

/*
 * 修改学生信息
 */
$('.update_input_sure').click(
	
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/Student/Student_updateStudent',
					$('#updateStudent form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('修改成功!');
							$('#updateStudent').modal('hide');
							$('#updateStudent input').val("");
							window.location.reload();
						} else {
							toastr.error('修改失败!');
							return false;
						}
					}, 'text')
		});
/*
 * 得到学生信息
 */

function getStudent(id){
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
	fromDate.append("student.student_id",id);
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
	    
	    $.post('/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingListBysearchPage',
				{"dormitoryBuildingVO.currPage" : "1"},
				function(xhr) {
					var data_list = xhr.ssglxt_dormitoryBuildingList;
					var option = '';
					for (var len = 0; len < data_list.length; len++) {
						option += '<option ';
						if (student.student_buildingName == data_list[len].dormitoryBuilding_buildingName) {
							option += 'selected';
						    $.post('/ssglxt/Dormitory/Dormitory_getDormitoryByDormitoryBuildingName',
									{"dormitory.dormitory_buildingName" : student.student_buildingName},
									function(xhr) {
										var data_list = xhr;
										var option = '';
										for (var len = 0; len < data_list.length; len++) {
											option += '<option ';
											if (student.student_dormitoryName == data_list[len].dormitory_name) {
												option += 'selected';
												$.post('/ssglxt/Bed/Bed_getBedByDormitoryAndDormitoryBuilding',
														{"bed.bed_buildingName" : student.student_buildingName,"bed.bed_dormitoryName" : student.student_dormitoryName},
														function(bed) {
															var option = '';
															for (var len = 0; len < bed.length; len++) {
																option += '<option ';
																if (student.student_bedName == bed[len].bed_name) {
																	option += 'selected';
																}
																
																option += ' value="'
																		+ bed[len].bed_name + '">'
																		+ bed[len].bed_name + '</option>';
															}
															$('#updatestudent_bedName').html(option);
															// 除去加载提示
															$('.load_remind').remove();
														}, 'json');
											}
											option += ' value="'
													+ data_list[len].dormitory_name + '">'
													+ data_list[len].dormitory_name + '</option>';
										}
										$('#updatestudent_dormitoryName').html(option);
										// 除去加载提示
										$('.load_remind').remove();
									}, 'json');
						}
						option += ' value="'
								+ data_list[len].dormitoryBuilding_buildingName + '">'
								+ data_list[len].dormitoryBuilding_buildingName + '</option>';
					}
					$('#updatestudent_buildingName').html(option);
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
	    

	    
	    }
	  }
}
/*
 * 选中所有复选框
 */
function all_select(){
	 var checkbox_all_select = document.getElementById("checkbox_all_select")
	   var checkbox_select = document.getElementsByClassName("checkbox_select");
	 if (checkbox_all_select.checked){
	     //循环设置所有复选框为选中状态
	     for(var i = 0; i < checkbox_select.length; i++)
	    	 checkbox_select[i].checked = true;
	  }else{//取消obj选中状态，则全不选
	     //循环设置所有复选框为未选中状态
	     for(var i = 0; i < checkbox_select.length; i++)
	    	 checkbox_select[i].checked = false;
	  }
}
/*
 * 删除学生信息
 */  
function deleteStudent(){
	$.confirm({
		smoothContent : false,
		title : '删除学生',
		content : '此操作将删除所有所选的学生',
		type : 'red',
		autoClose : '取消|5000',// 自动关闭
		buttons : {
			删除 : {
				btnClass : 'btn-red',
				action : function() {
					var xhr = false;
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								if (xhr.responseText == "1") {
									toastr.success("删除成功");
									window.location.reload();
								} else {
									toastr.error("删除失败");
								}
							} else {
								toastr.error(xhr.status);
							}
						}
					}
					var checkbox_select = document
							.getElementsByClassName("checkbox_select");
					

					var formData = new FormData();
					var arr=new Array();
					var str=null;
					for (var num = 0; num < checkbox_select.length; num++) {
						if (checkbox_select[num].checked) {
							arr.push(checkbox_select[num].value);
							str=arr.join(",")
						}
					}
					formData.append("studentIDAll",str);

					xhr.open("POST", "/ssglxt/Student/Student_deleteStudent");
					xhr.send(formData);
				}
			},
			取消 : function() {
			}
		}
	});

}
/*
 * 搜索
 */
//function searchUsername(query_data){
//	$
//	.post(
//			'/ssglxt/Student/Student_getStudentListBysearchPage',
//			{'studentVO.student_name':$('#input_PoliceSearchText').val(),"studentVO.currPage" : "1"},
//			function(xhr) {
//				var data_list = xhr.ssglxt_studentList;
//				var str = '';
//				for (var len = 0; len < data_list.length; len++) {
//					
//					str += '<tr>';
//					str += '<td>'
//						+ '<input  type="checkbox" class="checkbox_select" value="'
//						+ data_list[len].student_id
//						+ '" >'
//						+ '</td>';
//					str += '<td>' + (len + 1) + '</td>';// 序号
//					str += '<td>' + data_list[len].student_studentId//学号
//							+ '</td>';
//					str += '<td>' + data_list[len].student_name//姓名
//					+ '</td>';
//					str += '<td>' + data_list[len].student_sex//性别
//					+ '</td>';
//					str += '<td>' + data_list[len].student_IDNUMBER//身份证号
//					+ '</td>';
//					str += '<td>' + data_list[len].student_faculty//院系
//					+ '</td>';
//					str += '<td>' + data_list[len].student_major//专业
//					+ '</td>';
//					str += '<td>' + data_list[len].student_class//班级
//					+ '</td>';
//					str += '<td>' + data_list[len].student_phone//电话
//					+ '</td>';
//					str += '<td>' + data_list[len].student_address//家庭住址
//					+ '</td>';
//					str += '<td>' + data_list[len].student_buildingName//居住楼名称
//					+ '</td>';
//					str += '<td>' + data_list[len].student_dormitoryName//居住宿舍名称
//					+ '</td>';
//					str += '<td>' + data_list[len].student_bedName//居住床位名称
//					+ '</td>';
//					str += '<td>' + data_list[len].student_checkIn_time//入住时间
//					+ '</td>';
//					
//					str += '<td>'
//						+ '<i id="'
//						+ data_list[len].student_id
//						+ '" data-toggle="modal" data-target="#updateStudent" onclick=getStudent("'+data_list[len].student_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
//						+ '</td>';
//						str += '</tr>';
//					
//				}
//				// 加载案件列表到表格中
//				$('.breakcase_table_info tbody').html(str); // 操作点击事件
//			}, 'json')
//}
/**
 * 根据宿舍楼得到宿舍房间
 */
$("#updatestudent_buildingName").change(function(){
	 $.post('/ssglxt/Dormitory/Dormitory_getDormitoryByDormitoryBuildingName',
				{"dormitory.dormitory_buildingName" : $('#updatestudent_buildingName').val()},
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
					$('#updatestudent_dormitoryName').html(option);
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
});

/**
 * 根据宿舍楼和房间得到床位
 */
$("#updatestudent_dormitoryName").change(function(){
	 $.post('/ssglxt/Bed/Bed_getBedByDormitoryAndDormitoryBuilding',
				{"bed.bed_buildingName" : $('#updatestudent_buildingName').val(),"bed.bed_dormitoryName" : $('#updatestudent_dormitoryName').val()},
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
					$('#updatestudent_bedName').html(option);
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
});
//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
//query_data['dormitoryVO.pageIndex'] = ;
	get_ListBreakecaseInformationByPageAndSearch(1);
}
//上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 < 1) {
		toastr.error('已经是第一页！');
		return;
	}
	//query_data['dormitoryVO.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListBreakecaseInformationByPageAndSearch(page_infomantion.pageIndex - 1);
}
//下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 > page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	//query_data['dormitoryVO.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListBreakecaseInformationByPageAndSearch(page_infomantion.pageIndex + 1);
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	//query_data['dormitoryVO.pageIndex'] = page_infomantion.totalPages;
	//alert(page_infomantion.totalPages);
get_ListBreakecaseInformationByPageAndSearch(page_infomantion.totalPages);
}