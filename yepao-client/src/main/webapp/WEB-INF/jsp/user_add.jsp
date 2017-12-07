<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户添加页码</title>
		<!-- 导入jquery核心类库 -->
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<!-- 导入easyui类库 -->
		<link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="/js/easyui/ext/portal.css">
		<link rel="stylesheet" type="text/css" href="/css/default.css">
		<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="/js/easyui/ext/jquery.portal.js"></script>
		<script type="text/javascript" src="/js/easyui/ext/jquery.cookie.js"></script>
		<script src="/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<!-- 导入ztree类库 -->
		<link rel="stylesheet" href="/js/ztree/zTreeStyle.css" type="text/css" />
		<script src="/js/ztree/jquery.ztree.all-3.5.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$("body").css({visibility:"visible"});
				// 授权树初始化
				var setting = {
					data : {
						key : {
							title : "t"
						},
						simpleData : {
							enable : true
						}
					},
					check : {
						enable : true,//让树形菜单前可以显示CheckBox
					}
				};
				
				$.ajax({
					url : '/menu_list',
					type : 'POST',
					dataType : 'text',
					success : function(data) {
						var zNodes = eval("(" + data + ")");
						$.fn.zTree.init($("#menuTree"), setting, zNodes);
					},
					error : function(msg) {
						alert('树加载异常!');
					}
				});
				
				
				// 点击保存
				$('#save').click(function(){
					//获取ztree勾选的节点
					//先获得所有的菜单节点
					var treeObj=$.fn.zTree.getZTreeObj("menuTree");
					//再获得已勾选的节点，勾选一个子节点，父节点会自动勾选
					var nodes=treeObj.getCheckedNodes(true);
					//获取所有节点的id
					var array = new Array();
					for(var i=0;i<nodes.length;i++){
						array.push(nodes[i].id);
					}
					var menuIds=array.join(",");
					//把勾选节点中所有子节点的id用逗号分隔成字符串自后，然后赋给隐藏域
					$("input[name='menu']").val(menuIds);
					
					//提交form表单
					if($("#userform").form("validate")){
						$("#username").blur();
						var gender=$("#gender option:selected").attr("value");
						if(gender==""){
							$.messager.alert("提示信息","请选择性别","warning");
							return;
						}
						
						$("#userform").submit();
					}else{
						$.messager.alert("提示信息","表单中存在非法数据","warning");
					}
					
				});
				
				
				$("#username").blur(function(){
					var name = $("#username").val().trim();
					if(name==""){
						return;
					}
					$.post("/checkUsername",{username:name},function(data){
						if(data.status==200){
							$("#msg").css("color","green");
							$("#msg").html("用户名可用");
						}else{
							$("#msg").css("color","red");
							$("#msg").html("用户已存在");
							return;
						}
					})
				});
			});
			
		function returnList(){
			location.href="/pages/base/userInfo";
		}
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<a id="back" icon="icon-back" href="javascript:returnList()" class="easyui-linkbutton" plain="true">返回列表</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="userform" method="post" action="/add/user">
				<table class="table-edit" width="95%" align="center">
					<tr class="title">
						<td colspan="4">基本信息</td>
					</tr>
					<tr>
						<td>用户名:</td>
						<td>
							<input type="text" name="username" id="username" class="easyui-validatebox" required="true" /><span id="msg"></span>
						</td>
						<td>口令:</td>
						<td>
							<input type="text" name="password" id="password" class="easyui-validatebox" required="true" validType="minLength[5]" />
						</td>
					</tr>
					<tr>
						<td>真实姓名:</td>
						<td colspan="3">
							<input type="text" name="name" id="name" class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>其它:</td>
						<td colspan="3">
							<input type="text" name="other" id="other" />
						</td>
					</tr>
					<tr class="title">
						<td colspan="4">其他信息</td>
					</tr>
					<tr>
						<td>性别:</td>
						<td>
							<select name="gender" id="gender" style="width: 150px;">
								<option value="">-请选择-</option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</td>
						<td>部门:</td>
						<td>
							<input type="text" name="department" id="department" class="easyui-validatebox " required="true" />
						</td>
					</tr>
					<tr>
						<td>菜单授权</td>
						<td>
							<input type="hidden" name="menu"/>
							<ul id="menuTree" class="ztree"></ul>
						</td>
					</tr>
					<tr>
						<td>联系电话</td>
						<td colspan="3">
							<input type="text" name="tel" data-options="validType:'length[0,8]'" id="telephone" class="easyui-validatebox easyui-numberbox" required="true" />
						</td>
					</tr>
					<tr>
						<td>备注:</td>
						<td colspan="3">
							<textarea name="standby" style="width:80%"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>

</html>