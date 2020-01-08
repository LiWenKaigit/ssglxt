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
					修改密码</li>
				
			</ul>
			<!-- /.breadcrumb -->
            			
			
		</div>

		<div class="page-content" style="margin-left: 200px;">
			<div class="page-content-area">
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<form class="form-horizontal" role="form" id="addStudent">
							<!-- #section:elements.form -->
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 原密码：</label>

								<div class="col-sm-9">
									<input type="text" id="passwordOld" placeholder="输入原密码"
										class="col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">新密码： </label>

								<div class="col-sm-9">
									<input type="text" id="passwordNew" placeholder="输入新密码"
										class=" col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">确认密码： </label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text"  id="passwordNewAgain" placeholder="重新输入新密码"
										class=" col-xs-10 col-sm-5"/>
									</div>
								</div>
							</div>

							<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button" onclick="updatePassword()">
										<i class="ace-icon fa fa-check bigger-110"></i> 确定
									</button>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> 重置
									</button>
								</div>
						
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	<script type="text/javascript">
	function updatePassword(){
	 if(check()){
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		var oldPassword = document.getElementById("passwordOld").value;
		var newPassword = document.getElementById("passwordNew").value;
		var fromDate = new FormData();
		if(<s:property value="#session.loginResultRose"/>=="1"){
			fromDate.append("id","<s:property value="#session.loginResult.obj.student_id"/>");
			fromDate.append("rose","<s:property value="#session.loginResult.obj.student_role"/>");
			fromDate.append("oldPassword",oldPassword);
			fromDate.append("newPassword",newPassword);
		}
		if(<s:property value="#session.loginResultRose"/>=="2"){
			fromDate.append("id","<s:property value="#session.loginResult.obj.admin_id"/>");
			fromDate.append("rose","<s:property value="#session.loginResult.obj.admin_role"/>");
			fromDate.append("oldPassword",oldPassword);
			fromDate.append("newPassword",newPassword);
		}
		if(<s:property value="#session.loginResultRose"/>=="3"){
			fromDate.append("id","<s:property value="#session.loginResult.obj.superAdmin_id"/>");
			fromDate.append("rose","<s:property value="#session.loginResult.obj.superAdmin_role"/>");
			fromDate.append("oldPassword",oldPassword);
			fromDate.append("newPassword",newPassword);
		}
		xmlhttp.open("post","/ssglxt/LoginOrout/LoginOrout_updatePassword",true);
		xmlhttp.send(fromDate);
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		    var xhr=xmlhttp.responseText;
		    if(xhr=="1"){
		    	toastr.success("密码修改成功")
		    	}else{
		    		toastr.warning("原密码错误");
		    	}
		    }
		    }
	}
	function check(){
		var oldPassword = document.getElementById("passwordOld").value;
		var newPassword = document.getElementById("passwordNew").value;
		var passwordNewAgain = document.getElementById("passwordNewAgain").value;
		if(oldPassword==''){
			toastr.warning("原密码为空");
			return false;
		}
		if(newPassword==''){
			toastr.warning("新密码为空");
			return false;
		}
		if(passwordNewAgain==''){
			toastr.warning("确认密码为空");
			return false;
		}
		if(newPassword!=passwordNewAgain){
			toastr.warning("新密码与确认密码不一致");
			return false;
		}
		return true;
	}
}
	</script>
</body>
</html>