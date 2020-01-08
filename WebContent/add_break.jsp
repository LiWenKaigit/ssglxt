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
					学生管理</li>
				<li style="color:#4c8fbd;">违规登记</li>
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
									for="form-field-1"> 学号：</label>

								<div class="col-sm-9">
									<input type="text" id="break_studentId" placeholder="输入学号"
										class="col-xs-10 col-sm-5" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">违规时间： </label>

<!-- 								<div class="col-sm-9"> -->
<!-- 									<input type="text" id="break_time" placeholder="输入违规时间" -->
<!-- 										class=" col-xs-10 col-sm-5" /> -->
<!-- 								</div> -->
								<div class="col-sm-9 ">
									<input type="text" id="laydateInput" 
										name="break_time" />
									<div class="select-date">
										<div class=" select-date-header">
											<ul class="heade-ul">
												<li class="header-item header-item-one"><select name=""
													id="yearList"></select></li>
												<li class="header-item header-item-two"
													onselectstart="return false"><select name=""
													id="monthList"></select></li>
												<li class="header-item header-item-three"
													onselectstart="return false"><span class="reback">回到今天</span>
												</li>
											</ul>
										</div>
										<div class="select-date-body">
											<ul class="week-list">
												<li>日</li>
												<li>一</li>
												<li>二</li>
												<li>三</li>
												<li>四</li>
												<li>五</li>
												<li>六</li>
											</ul>
											<ul class="day-tabel"></ul>
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1-1">违规情况： </label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<textarea class="input-xlarge" name="comment" id="break_reason" placeholder="输入违规情况"></textarea>
									</div>
								</div>
							</div>

							<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button" onclick="add_break()">
										<i class="ace-icon fa fa-check bigger-110"></i> 立即提交
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
	
	<script type="text/javascript" src="js/Admin/student.js"></script>
</body>
</html>