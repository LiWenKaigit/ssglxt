var query_data = {
	"dormitoryBuildingVO.currPage" : "1",
};
$(function(){
	get_ListBreakecaseInformationByPageAndSearch();
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
			'/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingListBysearchPage',
			{'dormitoryBuildingVO.dormitoryBuilding_buildingName':$('#input_PoliceSearchText').val(),"dormitoryBuildingVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_dormitoryBuildingList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].dormitoryBuilding_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].dormitoryBuilding_buildingName
							+ '</td>';
					str += '<td>' + data_list[len].dormitoryBuilding_roomNumber
					+ '</td>';
					str += '<td>' + data_list[len].dormitoryBuilding_liveSex
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].dormitoryBuilding_id
						+ '" data-toggle="modal" data-target="#updateDormitoryBuilding" onclick=getDormitoryBuilding("'+data_list[len].dormitoryBuilding_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
}
/*
 * 添加宿舍楼
 */
$('.input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/DormitoryBuilding/DormitoryBuilding_addDormitoryBuilding',
					$('#addDormitoryBuilding form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('添加成功!');
							$('#addDormitoryBuilding').modal('hide');
							$('#addDormitoryBuilding input').val("");
							window.location.reload();
						} else {
							toastr.error('添加失败!');
							return false;
						}
					}, 'text')
		});

/*
 * 修改宿舍楼信息
 */
$('.update_input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/DormitoryBuilding/DormitoryBuilding_updateDormitoryBuilding',
					$('#updateDormitoryBuilding form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('修改成功!');
							$('#updateDormitoryBuilding').modal('hide');
							$('#updateDormitoryBuilding input').val("");
							window.location.reload();
						} else {
							toastr.error('修改失败!');
							return false;
						}
					}, 'text')
		});
/*
 * 得到宿舍楼信息
 */

function getDormitoryBuilding(id){
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
	fromDate.append("dormitoryBuilding.dormitoryBuilding_id",id);
	xmlhttp.open("post","/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var dormitoryBuilding=xmlhttp.responseText;
	    dormitoryBuilding = JSON.parse(dormitoryBuilding);
	    $('#updatedormitoryBuilding_buildingName').val(dormitoryBuilding.dormitoryBuilding_buildingName);
	    $('#updatedormitoryBuilding_roomNumber').val(dormitoryBuilding.dormitoryBuilding_roomNumber);
	    $('#updatedormitoryBuilding_liveSex').val(dormitoryBuilding.dormitoryBuilding_liveSex);
	    $('#updatedormitoryBuilding_id').val(dormitoryBuilding.dormitoryBuilding_id);
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
 * 删除宿舍楼
 */  
function deleteDormitoryBuilding(){
	$.confirm({
		smoothContent : false,
		title : '删除宿舍楼',
		content : '此操作将删除所有所选的宿舍楼',
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
					formData.append("DormitoryBuildingAll",str);

					xhr.open("POST", "/ssglxt/DormitoryBuilding/DormitoryBuilding_deleteDormitoryBuilding");
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
			'/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingListBysearchPage',
			{'dormitoryBuildingVO.dormitoryBuilding_buildingName':$('#input_PoliceSearchText').val(),"dormitoryBuildingVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_dormitoryBuildingList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].dormitoryBuilding_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].dormitoryBuilding_buildingName
							+ '</td>';
					str += '<td>' + data_list[len].dormitoryBuilding_roomNumber
					+ '</td>';
					str += '<td>' + data_list[len].dormitoryBuilding_liveSex
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].dormitoryBuilding_id
						+ '" data-toggle="modal" data-target="#updateDormitoryBuilding" onclick=getDormitoryBuilding("'+data_list[len].dormitoryBuilding_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
}


