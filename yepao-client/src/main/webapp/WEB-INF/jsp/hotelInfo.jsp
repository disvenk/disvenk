<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>酒店信息设置</title>
		<!-- 导入jquery核心类库 -->
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		
		<!-- 导入easyui类库 -->
		<link rel="stylesheet" type="text/css" href="/js/easyui/themes/bootstrap/easyui.css">
		<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="/js/easyui/ext/portal.css">
		<link rel="stylesheet" type="text/css" href="/css/default.css">
		<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="/js/easyui/ext/jquery.portal.js"></script>
		<script type="text/javascript" src="/js/easyui/ext/jquery.cookie.js"></script>
		<script src="/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript">
			
			$(function(){
			    // 对添加酒店的 save按钮，添加click事件
				$("#save").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#addForm").form('validate')){//这个方法是内置的
						// 通过校验 
						$("#addForm").submit();
						$.messager.alert("提示","提交成功","warning")
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
					}
				});
	
				  
		
			}); 
			
		
		</script>
	</head>

	<body>

			<div region="center" style="height:31px;overflow:hidden;" split="false" border="false">
				<div class="datagrid-toolbar">
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">提交</a>
				</div>
			</div>

		
				<form id="addForm" action="/hotel/complete" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td >酒店信息</td><td style="color: red;">*请输入您的酒店信息,第一次提交将为您注册酒店信息,重复提交作修改处理</td>
							<input type="hidden" name="hotelId" value="${cookie.yonghuming.value}">
						</tr>
						<tr>
							<td>酒店名称</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>酒店地址</td>
							<td>
								<input type="text" name="address" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>酒店描述</td>
							<td>
								<!-- <input type=" name="city" style="width:80%" class="easyui-validatebox" required="true" /> -->
								<textarea class="easyui-validatebox" required="true" name="descreption" style="resize: none;width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>酒店电话</td>
							<td>
								<input type="text" name="tel"  data-options="validType:'length[0,11]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>酒店图片</td>
							<td>
								<input type="file" style="width:200px" name="uploadFile" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>备注</td>
							<td>
								<textarea name="standby" style="resize: none;width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
					</table>
				</form>
			
	</body>

</html>