//var query_data = {
//	"repairVO.currPage" : "1",
//};
//$(function(){
//	get_ListBreakecaseInformationByPageAndSearch();
//})
////当前页面分页信息
//var page_infomantion = {
//	currPage : 1,
//	countRecords : 1,
//	pageSize : 10,
//	totalPages : 1,
//	havePrePage : false,
//	haveNexPage : false,
//}
$(function(){
	
	
})

/*
 * 修改维修物品信息
 */
$('.update_input_sure').click(
		function() {
			
			var this_modal = $(this);
			var xmlhttp;
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  xmlhttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			var updaterepair_id = document.getElementById("updaterepair_id").value;
			var updaterepair_studentId = document.getElementById("updaterepair_studentId").value;
			var updaterepair_name = document.getElementById("updaterepair_name").value;
			var updaterepair_remarks = document.getElementById("updaterepair_remarks").value;
			
			var fromDate = new FormData();	
			
			fromDate.append("repair.repair_id",updaterepair_id);
			fromDate.append("repair.repair_studentId",updaterepair_studentId);
			fromDate.append("repair.repair_name",updaterepair_name);
			fromDate.append("repair.repair_remarks",updaterepair_remarks);
			fromDate.append("repair.repair_status","待处理");
			xmlhttp.open("post","/ssglxt/Repair/Repair_updateRepair",true);
			xmlhttp.send(fromDate);
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
			    var xhr=xmlhttp.responseText;
			    if (xhr == 1){
			    	toastr.success('修改成功!');
			    	$('#updateRepair').modal('hide');
			    	$('#updateRepair input').val("");
			    	window.location.reload();
			    }else{
			    	toastr.error('修改失败!');
			    	return false;
			    }
			    }
			  }

			
		});

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
	    //$('#updaterepair_status').val(repair.repair_status);//维修物品状态
	    
	    $('#updaterepair_id').val(repair.repair_id);
	    }
	  }
}




