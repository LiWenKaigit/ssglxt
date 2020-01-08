var query_data = {
	"adminVO.currPage" : "1",
};
$(function(){
	get_ListBreakecaseInformationByPageAndSearch();
	 $.post('/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingListBysearchPage',
				{"dormitoryBuildingVO.currPage" : "1"},
				function(xhr) {
					var data_list = xhr.ssglxt_dormitoryBuildingList;
					var option = '';
					for (var len = 0; len < data_list.length; len++) {
						option += '<option ';
						option += ' value="'
								+ data_list[len].dormitoryBuilding_buildingName + '">'
								+ data_list[len].dormitoryBuilding_buildingName + '</option>';
					}
					$('#admin_jobBuilding').html(option);
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
})
//当前页面分页信息
var page_infomantion = {
	currPage : 1,
	countRecords : 1,
	pageSize : 10,
	totalPages : 1,
	havePrePage : false,
	haveNexPage : false,
}
/*
 *查询列表
 */
function get_ListBreakecaseInformationByPageAndSearch(){
	$
	.post(
			'/ssglxt/Admin/Admin_getAdminListBysearchPage',
			{'adminVO.admin_name':$('#input_PoliceSearchText').val(),"adminVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_adminList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].admin_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].admin_jobNumber//工号
							+ '</td>';
					str += '<td>' + data_list[len].admin_name//姓名
					+ '</td>';
					str += '<td>' + data_list[len].admin_sex//性别
					+ '</td>';
					str += '<td>' + data_list[len].admin_age//年龄
					+ '</td>';
					str += '<td>' + data_list[len].admin_jobBuilding//工作楼号
					+ '</td>';
					str += '<td>' + data_list[len].admin_phone//联系电话
					+ '</td>';
					str += '<td>' + data_list[len].admin_address//家庭住址
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].admin_id
						+ '" data-toggle="modal" data-target="#updateAdmin" onclick=getAdmin("'+data_list[len].admin_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
}
/*
 * 添加宿舍管理员
 */
$('.input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/Admin/Admin_addAdmin',
					$('#addAdmin form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('添加成功!');
							$('#addAdmin').modal('hide');
							$('#addAdmin input').val("");
							window.location.reload();
						} else {
							toastr.error('添加失败!');
							return false;
						}
					}, 'text')
		});

/*
 * 修改宿舍管理员信息
 */
$('.update_input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/Admin/Admin_updateAdmin',
					$('#updateAdmin form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('修改成功!');
							$('#updateAdmin').modal('hide');
							$('#updateAdmin input').val("");
							window.location.reload();
						} else {
							toastr.error('修改失败!');
							return false;
						}
					}, 'text')
		});
/*
 * 得到宿舍管理员信息
 */

function getAdmin(id){
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
	fromDate.append("admin.admin_id",id);
	xmlhttp.open("post","/ssglxt/Admin/Admin_getAdminById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var admin=xmlhttp.responseText;
	    admin = JSON.parse(admin);
	    $('#updateadmin_jobNumber').val(admin.admin_jobNumber);
	    $('#updateadmin_name').val(admin.admin_name);
	    $('#updateadmin_sex').val(admin.admin_sex);
	    $('#updateadmin_age').val(admin.admin_age);
	    $('#updateadmin_jobBuilding').val(admin.admin_jobBuilding);
	    $('#updateadmin_phone').val(admin.admin_phone);
	    $('#updateadmin_address').val(admin.admin_address);
	    $('#updateadmin_id').val(admin.admin_id);
	    
	    $.post('/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingListBysearchPage',
				{"dormitoryBuildingVO.currPage" : "1"},
				function(xhr) {
					var data_list = xhr.ssglxt_dormitoryBuildingList;
					var option = '';
					for (var len = 0; len < data_list.length; len++) {
						option += '<option ';
						if (admin.admin_jobBuilding == data_list[len].dormitoryBuilding_buildingName) {
							option += 'selected';
						}
						option += ' value="'
								+ data_list[len].dormitoryBuilding_buildingName + '">'
								+ data_list[len].dormitoryBuilding_buildingName + '</option>';
					}
					$('#updateadmin_jobBuilding').html(option);
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
 * 删除宿舍管理员信息
 */  
function deleteAdmin(){
	$.confirm({
		smoothContent : false,
		title : '删除宿舍管理员',
		content : '此操作将删除所有所选的宿舍管理员',
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
					formData.append("adminIDAll",str);

					xhr.open("POST", "/ssglxt/Admin/Admin_deleteAdmin");
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
function searchUsername(query_data){
	$
	.post(
			'/ssglxt/Admin/Admin_getAdminListBysearchPage',
			{'adminVO.admin_name':$('#input_PoliceSearchText').val(),"adminVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_adminList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].admin_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].admin_jobNumber//工号
							+ '</td>';
					str += '<td>' + data_list[len].admin_name//姓名
					+ '</td>';
					str += '<td>' + data_list[len].admin_sex//性别
					+ '</td>';
					str += '<td>' + data_list[len].admin_age//年龄
					+ '</td>';
					str += '<td>' + data_list[len].admin_jobBuilding//工作楼号
					+ '</td>';
					str += '<td>' + data_list[len].admin_phone//联系电话
					+ '</td>';
					str += '<td>' + data_list[len].admin_address//家庭住址
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].admin_id
						+ '" data-toggle="modal" data-target="#updateAdmin" onclick=getAdmin("'+data_list[len].admin_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
}


