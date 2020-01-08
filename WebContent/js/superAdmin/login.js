function login(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	var obj = $("#shenfen option:selected");
	var  shenfen_val  = obj.val();
	if(userName==''||password == ''){
		toastr.error('含有空信息');
		return ;
	}
	var login = new FormData();
	login.append("loginOroutVO.username",userName);
	login.append("loginOroutVO.password",password);
	login.append("loginOroutVO.role",shenfen_val);
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var login=xmlhttp.responseText;
	    if(login==1){
	    	window.location="navbar.jsp";
	    	
	    }else{
	    	toastr.error('用户名或密码错误！');
	    }
	    }
	  }
	xmlhttp.open("post","/ssglxt/LoginOrout/LoginOrout_login",true);
	xmlhttp.send(login);
}

function shenfen(value){
	var select = document.getElementById("shenfen");
	var option;
	for(i=0;i<select.length;i++){
		if(select[i].selected==true){
			option = select[i].innerText;
		}
	}
	return option;
}
/**
 * 确定退出
 * @returns
 */
function outDefine(){
	$.confirm({
		smoothContent : false,
		title : '退出宿舍管理系统',
		content : '确定退出吗？',
		type : 'blue',
		autoClose : '取消|5000',// 自动关闭
		buttons : {
			确定 : {
				btnClass : 'btn-red',
				action : function(){
					var xmlhttp;
					if (window.XMLHttpRequest)
					  {// code for IE7+, Firefox, Chrome, Opera, Safari
					  xmlhttp=new XMLHttpRequest();
					  }
					else
					  {// code for IE6, IE5
					  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					  }
					  xmlhttp.open("post","/ssglxt/LoginOrout/LoginOrout_loginOut");
					  xmlhttp.send();
					  xmlhttp.onreadystatechange=function()
					  {
					  if (xmlhttp.readyState==4 && xmlhttp.status==200)
						  window.location="login.jsp";
					    }
					  }
			},
			取消 : function() {
			}
		}
	});

}
