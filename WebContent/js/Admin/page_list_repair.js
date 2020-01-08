var query_data = {
	"repairVO.pageIndex" : "1",
};
$(function(){
	get_ListBreakecaseInformationByPageAndSearch(query_data);
})
//当前页面分页信息
var page_infomantion = {
	pageIndex : 1,
	totalRecords : 1,
	pageSize : 20,
	totalPages : 1,
	HavePrePage : false,
	HaveNextPage : false,
}
/*
 *查询列表
 */
function get_ListBreakecaseInformationByPageAndSearch(query_data){
	$
	.post(
			'/ssglxt/Repair/Repair_getRepairOkListBysearchPage',
			{'repairVO.repair_name':$('#input_PoliceSearchText').val(),"repairVO.pageIndex" : query_data},
			function(xhr) {
				var data_list = xhr.ssglxt_repairList;
				var str = '';
				var count =0 ;
				for (var len = 0; len < data_list.length; len++) {
				
					count++;
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].repair_id
						+ '" >'
						+ '</td>';
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
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].repair_id
						+ '" onclick=getRepairChange("'+data_list[len].repair_id+'") class="ace-icon fa fa-check bigger-120" ></i>'
						+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].repair_id
						+ '" data-toggle="modal" data-target="#updateRepair" onclick=getRepair("'+data_list[len].repair_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
				//分页信息存入page_infomantion中
				page_infomantion.pageIndex = xhr.pageIndex; //当前页数
				page_infomantion.totalRecords = xhr.totalRecords; //总页数
				page_infomantion.pageSize = xhr.pageSize; //每页记录数
				page_infomantion.totalPages = xhr.totalPages; //总记录数
				page_infomantion.HavePrePage = xhr.HavePrePage; //是否有上一页
				page_infomantion.HaveNextPage = xhr.HaveNextPage; //是否有下一页
				$('.info').html('共 ' + xhr.totalRecords + '条信息 当前' + xhr.pageIndex + '/' + xhr.totalPages + '页 ' + xhr.pageSize + '条信息/页&nbsp&nbsp转到第'
						+ '<select onchange="toPage(this)">' + opt + '</select> 页');
			}, 'json')
}
//$("select#passed").change(
//		function() {
//		
//
//			$.post('/ssglxt/Repair/Repair_getRepairListBysearchPage', {'repairVO.repair_status':$('#passed').val() ,'repairVO.currPage' : 1 },
//				function(xhr) {
//					var data_list = xhr.ssglxt_repairList;
//					var str = '';
//					for (var len = 0; len < data_list.length; len++) {
//						str += '<tr>';
//						str += '<td>'
//							+ '<input  type="checkbox" class="checkbox_select" value="'
//							+ data_list[len].repair_id
//							+ '" >'
//							+ '</td>';
//						str += '<td>' + (len + 1) + '</td>';// 序号
//						str += '<td>' + data_list[len].repair_studentId//学号
//								+ '</td>';
//						str += '<td>' + data_list[len].repair_name//报修物品名
//						+ '</td>';
//						str += '<td>' + data_list[len].repair_remarks//报修物品备注
//						+ '</td>';
//						str += '<td>' + data_list[len].repair_status//物品维修状态
//						+ '</td>';
//						if(data_list[len].repair_status=="待处理"){
//							str += '<td>'
//								+ '<i id="'
//								+ data_list[len].repair_id
//								+ '" onclick=getRepairChange("'+data_list[len].repair_id+'") class="ace-icon fa fa-check bigger-120" ></i>'
//								+ '</td>';
//						}
//						if(data_list[len].repair_status=="已处理"){
//							str += '<td>'
//								+ '<i id="'
//								+ data_list[len].repair_id
//								+ '"  class="ce-icon fa fa-flag bigger-120 " ></i>'
//								+ '</td>';
//						}
//						
//						
//						str += '<td>'
//							+ '<i id="'
//							+ data_list[len].repair_id
//							+ '" data-toggle="modal" data-target="#updateRepair" onclick=getRepair("'+data_list[len].repair_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
//							+ '</td>';
//							str += '</tr>';
//					}
//					// 加载案件列表到表格中
//					$('.breakcase_table_info tbody').html(str); // 操作点击事件
//			}, 'json')
//		})
/*
 * 修改维修物品信息
 */
$('.update_input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/Repair/Repair_updateRepair',
					$('#updateRepair form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('修改成功!');
							$('#updateRepair').modal('hide');
							$('#updateRepair input').val("");
							window.location.reload();
						} else {
							toastr.error('修改失败!');
							return false;
						}
					}, 'text')
		});
/*
 * 处理维修物品
 */
function getRepairChange(id){
	var formData = new FormData();
	formData.append('repair.repair_id', id);
	formData.append('repair.repair_status', "已处理");
	$.confirm({
		title : '确定处理吗?',
		smoothContent : false,
		content : false,
		autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-danger',
				text : '确认',
				action : function() {
					$.ajax({
						url : '/ssglxt/Repair/Repair_updateRepairChange',
						type : 'post',
						data : formData,
						processData : false,
						contentType : false,
						dataType : 'text',
						success : function(data) {

							if (data == "1") {
								toastr.success("操作成功！");
								// 获取对应option中的value值
								window.location.reload();
								// get_ListBreakecaseInformationByPageAndSearch(query_data);
							} else {
								toastr.error("操作失败！");
							}
						}
					});
				}
			},
			cancelAction : {
				btnClass : 'btn-blue',
				text : '取消',
			}
		}
		});
}
/*
 * 得到维修物品信息
 */

function getRepair(id){
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
	fromDate.append("repair.repair_id",id);
	xmlhttp.open("post","/ssglxt/Repair/Repair_getRepairById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var repair=xmlhttp.responseText;
	    repair = JSON.parse(repair);
	    $('#updaterepair_studentId').val(repair.repair_studentId);//学号
	    $('#updaterepair_name').val(repair.repair_name);//维修物品名
	    $('#updaterepair_remarks').val(repair.repair_remarks);//维修物品备注
	    $('#updaterepair_status').val(repair.repair_status);//维修物品状态
	    
	    $('#updaterepair_id').val(repair.repair_id);
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
 * 删除维修物品信息
 */  
function deleteRepair(){
	$.confirm({
		smoothContent : false,
		title : '删除维修物品信息',
		content : '此操作将删除所有所选的维修物品信息',
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
					formData.append("repairIDAll",str);

					xhr.open("POST", "/ssglxt/Repair/Repair_deleteRepair");
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
//	$.post('/ssglxt/Repair/Repair_getRepairListBysearchPage', {'repairVO.repair_status':$('#passed').val() ,'repairVO.currPage' : 1 ,'repairVO.repair_name':$('#input_PoliceSearchText').val()},
//			function(xhr) {
//				var data_list = xhr.ssglxt_repairList;
//				var str = '';
//				for (var len = 0; len < data_list.length; len++) {
//					str += '<tr>';
//					str += '<td>'
//						+ '<input  type="checkbox" class="checkbox_select" value="'
//						+ data_list[len].repair_id
//						+ '" >'
//						+ '</td>';
//					str += '<td>' + (len + 1) + '</td>';// 序号
//					str += '<td>' + data_list[len].repair_studentId//学号
//							+ '</td>';
//					str += '<td>' + data_list[len].repair_name//报修物品名
//					+ '</td>';
//					str += '<td>' + data_list[len].repair_remarks//报修物品备注
//					+ '</td>';
//					str += '<td>' + data_list[len].repair_status//物品维修状态
//					+ '</td>';
//					
//					if(data_list[len].repair_status=="待处理"){
//						str += '<td>'
//							+ '<i id="'
//							+ data_list[len].repair_id
//							+ '" onclick=getRepairChange("'+data_list[len].repair_id+'") class="ace-icon fa fa-check bigger-120" ></i>'
//							+ '</td>';
//					}
//					if(data_list[len].repair_status=="已处理"){
//						str += '<td>'
//							+ '<i id="'
//							+ data_list[len].repair_id
//							+ '"  class="ce-icon fa fa-flag bigger-120 " ></i>'
//							+ '</td>';
//					}
//					
//					str += '<td>'
//						+ '<i id="'
//						+ data_list[len].repair_id
//						+ '" data-toggle="modal" data-target="#updateRepair" onclick=getRepair("'+data_list[len].repair_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
//						+ '</td>';
//						str += '</tr>';
//				}
//				// 加载案件列表到表格中
//				$('.breakcase_table_info tbody').html(str); // 操作点击事件
//		}, 'json')
//}

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
