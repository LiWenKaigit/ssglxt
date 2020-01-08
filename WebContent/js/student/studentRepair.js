
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
		window.location.href="studentlist_repair.jsp";
	} else {
		alert(xhr);
		toastr.error('添加失败!');
		return false;
	}
	    }
	  }
}



