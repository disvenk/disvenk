<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<!-- 导入ocupload -->
<script type="text/javascript" src="/js/ocupload/jquery.ocupload-1.1.2.js" ></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css" href="/js/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css" href="/css/default.css">
<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript" src="/js/easyui/ext/jquery.cookie.js"></script>
<script src="/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>

</head>
<body>
<div style="padding:10px;">
	<div style="margin-bottom:8px;">您的意见会让系统做得更好
		<br />
	</div>
	<form id="bug_form" method="post" enctype="application/x-www-form-urlencoded">
		<textarea name="bug_c" id="bug_c" cols="50" rows="7" style=" border:solid 3px #E2E2E2;line-height:16px; padding:5px;"></textarea>
		<br />
		<div style="margin-top:8px;"><a href="javascript:void(0);" onclick="$('#bug_form').submit();" id="bug_form_but" class="easyui-linkbutton">提交</a></div>
	</form>
</div>
<script>
	//功能相对独立，应该单独放置
	$('#bug_form').form({  
		url:"post.html",  
		onSubmit: function(){  
			if($('#bug_c').val()==""){
				$.messager.alert('Warning',"内容太少");	
				return false;
			}
		}, 
		success:function(data){  
			$.messager.alert('Warning',"提交成功"); 
			$('#bug_c').val("");
		}  
	});
</script>
 </body>
</html>