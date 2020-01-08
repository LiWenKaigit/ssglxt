$(function(){
	document.getElementById("updatestudent_studentId").disabled="disabled";
	document.getElementById("updatestudent_name").disabled="disabled";
	document.getElementById("updatestudent_sex").disabled="disabled";
	document.getElementById("updatestudent_IDNUMBER").disabled="disabled";
	document.getElementById("updatestudent_faculty").disabled="disabled";
	document.getElementById("updatestudent_major").disabled="disabled";
	document.getElementById("updatestudent_class").disabled="disabled";
	document.getElementById("updatestudent_phone").disabled="disabled";
	document.getElementById("updatestudent_address").disabled="disabled";
	document.getElementById("updatestudent_buildingName").disabled="disabled";
	document.getElementById("updatestudent_dormitoryName").disabled="disabled";
	document.getElementById("updatestudent_bedName").disabled="disabled";
	document.getElementById("laydateInput").disabled="disabled";
	document.getElementById("editStudentInformation").disabled="disabled";
})
function changeEdit(){
	document.getElementById("updatestudent_studentId").disabled=false;
	document.getElementById("updatestudent_name").disabled=false;
	document.getElementById("updatestudent_sex").disabled=false;
	document.getElementById("updatestudent_IDNUMBER").disabled=false;
	document.getElementById("updatestudent_faculty").disabled=false;
	document.getElementById("updatestudent_major").disabled=false;
	document.getElementById("updatestudent_class").disabled=false;
	document.getElementById("updatestudent_phone").disabled=false;
	document.getElementById("updatestudent_address").disabled=false;
	document.getElementById("updatestudent_buildingName").disabled=false;
	document.getElementById("updatestudent_dormitoryName").disabled=false;
	document.getElementById("updatestudent_bedName").disabled=false;
	document.getElementById("laydateInput").disabled=false;
	document.getElementById("editStudentInformation").disabled=false;
}

//function editstu(){
//		var xmlhttp;
//		if (window.XMLHttpRequest)
//		  {// code for IE7+, Firefox, Chrome, Opera, Safari
//		  xmlhttp=new XMLHttpRequest();
//		  }
//		else
//		  {// code for IE6, IE5
//		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//		  }
//		var updatestudent_studentId = document.getElementById("updatestudent_studentId").value;
//		var updatestudent_name = document.getElementById("updatestudent_name").value;
//		var updatestudent_sex = document.getElementById("updatestudent_sex").value;
//		var updatestudent_IDNUMBER = document.getElementById("updatestudent_IDNUMBER").value;
//		var updatestudent_faculty = document.getElementById("updatestudent_faculty").value;
//		var updatestudent_major = document.getElementById("updatestudent_major").value;
//		var updatestudent_class = document.getElementById("updatestudent_class").value;
//		var updatestudent_phone = document.getElementById("updatestudent_phone").value;
//		var updatestudent_address = document.getElementById("updatestudent_address").value;
//		var updatestudent_buildingName = document.getElementById("updatestudent_buildingName").value;
//		var updatestudent_dormitoryName = document.getElementById("updatestudent_dormitoryName").value;
//		var updatestudent_bedName = document.getElementById("updatestudent_bedName").value;
//		var updatestudent_checkIn_time = document.getElementById("updatestudent_checkIn_time").value;
//		
//		var updatestudent_id = document.getElementById("updatestudent_id").value;
//		var fromDate = new FormData();	
//		fromDate.append("student.student_id",updatestudent_id);
//		fromDate.append("student.student_studentId",updatestudent_studentId);
//		fromDate.append("student.student_name",updatestudent_name);
//		fromDate.append("student.student_sex",updatestudent_sex);
//		fromDate.append("student.student_IDNUMBER",updatestudent_IDNUMBER);
//		fromDate.append("student.student_faculty",updatestudent_faculty);
//		fromDate.append("student.student_major",updatestudent_major);
//		fromDate.append("student.student_class",updatestudent_class);
//		fromDate.append("student.student_phone",updatestudent_phone);
//		fromDate.append("student.student_address",updatestudent_address);
//		fromDate.append("student.student_buildingName",updatestudent_buildingName);
//		fromDate.append("student.student_dormitoryName",updatestudent_dormitoryName);
//		fromDate.append("student.student_bedName",updatestudent_bedName);
//		fromDate.append("student.student_checkIn_time",updatestudent_checkIn_time);
//		xmlhttp.open("post","/ssglxt/Student/Student_updateStudent",true);
//		xmlhttp.send(fromDate);
//		xmlhttp.onreadystatechange=function()
//		  {
//		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
//		    {
//		    var xhr=xmlhttp.responseText;
//			if (xhr == 1) {
//				toastr.success('修改成功!');
//				window.location.href="studentInformation.jsp"
//			} else {
//				toastr.error('修改失败!');
//				return false;
//			}
//		    }
//		  }
//}