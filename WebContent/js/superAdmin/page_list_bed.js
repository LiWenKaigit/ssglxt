var query_data = {
	"bedVO.pageIndex" : "1",
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
												option += ' value="'
														+ xhr[len].dormitory_name + '">'
														+ xhr[len].dormitory_name + '</option>';
											}
											$('.selectpicker1').html(option).selectpicker('refresh');
											// 除去加载提示
											$('.load_remind').remove();
										}, 'json');
						}
						option += ' value="'
								+ data_list[len].dormitoryBuilding_buildingName + '">'
								+ data_list[len].dormitoryBuilding_buildingName + '</option>';
					}
					$('.selectpicker').html(option).selectpicker('refresh');
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
}); 
/*
 *查询列表
 */
function get_ListBreakecaseInformationByPageAndSearch(query_data){
	$
	.post(
			'/ssglxt/Bed/Bed_getBedListBysearchPage',
			{'bedVO.bed_buildingName':$('#input_PoliceSearchText').val(),"bedVO.pageIndex" : query_data},
			function(xhr) {
				var data_list = xhr.ssglxt_bedList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].bed_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].bed_buildingName//楼名称
							+ '</td>';
					str += '<td>' + data_list[len].bed_dormitoryName//宿舍名称
					+ '</td>';
					str += '<td>' + data_list[len].bed_name//床位名称
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].bed_id
						+ '" data-toggle="modal" data-target="#updateBed" onclick=getBed("'+data_list[len].bed_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
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
/*
 * 添加床位
 */
$('.input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/Bed/Bed_addBed',
					$('#addBed form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('添加成功!');
							$('#addBed').modal('hide');
							$('#addBed input').val("");
							window.location.reload();
						} else {
							toastr.error('添加失败!');
							return false;
						}
					}, 'text')
		});

/*
 * 修改床位信息
 */
$('.update_input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/ssglxt/Bed/Bed_updateBed',
					$('#updateBed form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('修改成功!');
							$('#updateBed').modal('hide');
							$('#updateBed input').val("");
							window.location.reload();
						} else {
							toastr.error('修改失败!');
							return false;
						}
					}, 'text')
		});
/*
 * 得到床位信息
 */

function getBed(id){
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
	fromDate.append("bed.bed_id",id);
	xmlhttp.open("post","/ssglxt/Bed/Bed_getBedById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var bed=xmlhttp.responseText;
	    bed = JSON.parse(bed);
	    $('#updatebed_name').val(bed.bed_name);
	    //$('#updatebed_buildingName').val(bed.bed_buildingName);
	   // $('#updatebed_dormitoryName').val(bed.bed_dormitoryName);
	    $('#updatebed_id').val(bed.bed_id);
	    $.post('/ssglxt/DormitoryBuilding/DormitoryBuilding_getDormitoryBuildingListBysearchPage',
				{"dormitoryBuildingVO.currPage" : "1"},
				function(xhr) {
					var data_list = xhr.ssglxt_dormitoryBuildingList;
					var option = '';
					for (var len = 0; len < data_list.length; len++) {
						option += '<option ';
						if (bed.bed_buildingName == data_list[len].dormitoryBuilding_buildingName) {
							option += 'selected';
						}
						option += ' value="'
								+ data_list[len].dormitoryBuilding_buildingName + '">'
								+ data_list[len].dormitoryBuilding_buildingName + '</option>';
					}
					$('.selectpicker').html(option).selectpicker('refresh');
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
	    $.post('/ssglxt/Dormitory/Dormitory_getDormitoryByDormitoryBuildingName',
				{"dormitory.dormitory_buildingName" : bed.bed_buildingName },
				function(xhr) {
					var option = '';
					for (var len = 0; len < xhr.length; len++) {
						option += '<option ';
						if (bed.bed_dormitoryName == xhr[len].dormitory_name) {
							option += 'selected';
						}
						option += ' value="'
								+ xhr[len].dormitory_name + '">'
								+ xhr[len].dormitory_name + '</option>';
					}
					$('.selectpicker1').html(option).selectpicker('refresh');
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
 * 删除宿舍床位信息
 */  
function deleteBed(){
	$.confirm({
		smoothContent : false,
		title : '删除床位',
		content : '此操作将删除所有所选的床位',
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
					formData.append("bedIDAll",str);

					xhr.open("POST", "/ssglxt/Bed/Bed_deleteBed");
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
			'/ssglxt/Bed/Bed_getBedListBysearchPage',
			{'bedVO.bed_buildingName':$('#input_PoliceSearchText').val(),"bedVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_bedList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].bed_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].bed_name//床位名称
							+ '</td>';
					str += '<td>' + data_list[len].bed_buildingName//楼名称
					+ '</td>';
					str += '<td>' + data_list[len].bed_dormitoryName//宿舍房间名称
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].bed_id
						+ '" data-toggle="modal" data-target="#updateBed" onclick=getBed("'+data_list[len].bed_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
}
/**
 * 根据宿舍楼得到宿舍房间
 */
$("#bed_buildingName1").change(function(){
	 $.post('/ssglxt/Dormitory/Dormitory_getDormitoryByDormitoryBuildingName',
				{"dormitory.dormitory_buildingName" : $('#bed_buildingName1').val()},
				function(xhr) {
					var option = '';
					for (var len = 0; len < xhr.length; len++) {
						option += '<option ';
						
						option += ' value="'
								+ xhr[len].dormitory_name + '">'
								+ xhr[len].dormitory_name + '</option>';
					}
					$('.selectpicker1').html(option).selectpicker('refresh');
					// 除去加载提示
					$('.load_remind').remove();
				}, 'json');
});
	
/**
 * 根据宿舍楼得到宿舍房间（修改时）
 */
$("#updatebed_buildingName").change(function(){
	 $.post('/ssglxt/Dormitory/Dormitory_getDormitoryByDormitoryBuildingName',
				{"dormitory.dormitory_buildingName" : $('#updatebed_buildingName').val()},
				function(xhr) {
					var option = '';
					for (var len = 0; len < xhr.length; len++) {
						option += '<option ';
						
						option += ' value="'
								+ xhr[len].dormitory_name + '">'
								+ xhr[len].dormitory_name + '</option>';
					}
					$('.selectpicker1').html(option).selectpicker('refresh');
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