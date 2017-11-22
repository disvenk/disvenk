<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,innitial-scale=1">  
		<title>酒店后台管理系统 登陆页面</title>
		<script src="/js/jquery-1.8.3.js" type="text/javascript"></script>
		<link href="/images/icon.ico" rel="icon" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="/css/login.css">
		<script type="text/javascript">
		 function login() {
			$.post("/login", $("#loginform").serialize(),function(data){
				if ($("#idInput").val() == "") {
					//alert("用户名不能为空");
					$("#alert").html("用户名不能为空");
					$("#idInput").focus();
					return false;
				}
				if ($("#password").val() == "") {
					//alert("密码不能为空");
					$("#alert").html("密码不能为空");
					$("#password").focus();
					return false;
				}
				if ($("#inputaccount").val() == "") {
					//alert("请输入验证码");
					$("#alert").html("请输入验证码");
					$("#inputaccount").focus();
					return false;
				}
				
				if (data.status == 200) {
						location.href = "/pages/base/index";
					
				} else {
					//alert("登录失败，原因是：" + data.msg);
					if(data.msg=="验证码错误"){
						inputaccount
						$("#inputaccount").select();
						$("#alert").html(data.msg);
						$("#loginformvCode").click();
					}else{
						$("#alert").html(data.msg);
						$("#idInput").select();
						$("#loginformvCode").click();
					}
					
				}
			});
		}
		</script>
	</head>
	
	<body>
		<div class="loginbox">
		<div class="loginnav">
			<nav class="navbar navbar-default">
						<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><img src="/images/home.png"></a>
					</div>
				</div>
				
			</nav>
		</div>
		
		<section class="mainlogin">
			<div class="container">
				<div class="col-md-4 col-md-offset-7 logincontent">
					<h4 style="display: inline;">管理员登录</h4><h5 id="alert" style="padding-left:35px;display: inline;color: red;"></h5>
					<form class="form-horizontal" id="loginform" name="loginform" 
						method="post" action="/login">
						<div class="form-group" id="idInputLine">
							<label for="inputPassword3" class="col-sm-3 control-label">账&nbsp&nbsp&nbsp号</label>
							<div class="col-sm-8">
								<input id="idInput" type="text" name="username" value="${cookie.username.value}" class="form-control" onkeydown="javascript:if(event.keyCode==13) login();" placeholder="请输入手机号/邮箱/用户名">
							</div>
						</div>
						<div class="form-group" id="pwdInputLine">
							<label id="loginform:pwdInput" class="col-sm-3 control-label">密&nbsp&nbsp&nbsp码</label>
							<div class="col-sm-8">
								<input id="password" for="pwdInput" type="password" name="password" class="form-control" id="inputaccount" onkeydown="javascript:if(event.keyCode==13) login();" placeholder="请输入您的密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputvalidate" class="col-sm-3 control-label">验证码</label>
							<div class="col-sm-4">
								<input type="text" name="validateCode" class="form-control" id="inputaccount" onkeydown="javascript:if(event.keyCode==13) login();" placeholder="请输入验证码">
							</div>
							<div class="col-sm-4">
								<img id="loginformvCode" src="/pages/base/validatecode"  onclick="javascript:document.getElementById('loginformvCode'). src='validatecode?'+Math.random();" />
							</div>
						</div>
						<div class="form-group">
							
							<div class="col-sm-offset-3 col-sm-4">
								<input type="checkbox" name="remeber" value="remeber"><span class="size12">　记住用户名</span>
							</div>
				<!-- 			<div class="col-sm-4">
								<a href="#"><span class="size12 forget">忘记密码</span></a>
							</div> -->
						</div>
						<div class="col-md-offset-3 col-md-8">
							<a  href="javascript:login();" id="loginform:j_id19" name="loginform:j_id19"
								 class="btn btn-danger">立即登录</a>
			
						</div>
					</form>
				</div>
			</div>
		</section>

		<footer class="clearfix">
			<div class="container">
			<p class="text-center">地址：成都市武侯区洗面桥街33号1栋1单元12楼1206号 邮编：610000 电话：02885532625</p>
<p  class="text-center">川ICP备08001421号川公网安备110108007702</p>
</div>
		</footer>
		</div>
	</body>
</html>