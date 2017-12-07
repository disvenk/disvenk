<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户列表页面</title>
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
		<script type="text/javascript">
			// 工具栏
			var toolbar = [{
				id : 'button-add',
				text : '新增',
				iconCls : 'icon-add',
				handler : doAdd
			}, {
				id : 'button-delete',
				text : '删除',
				iconCls : 'icon-cancel',
				handler : doDelete
			}];
			//定义冻结列
			var frozenColumns = [ [ {
				field : 'id',
				checkbox : true,
			}, {
				field : 'username',
				title : '名称',
				width : 120,
				align : 'center'
			} ] ];
		
		
			// 定义标题栏
			var columns = [ [ {
				field : 'id',
				checkbox : true,
			},{
				field : 'username',
				title : '用户名',
				width : 120,
				align : 'center'
			},{
				field : 'name',
				title : '真实姓名',
				width : 120,
				align : 'center'
			},{
				field : 'gender',
				title : '性别',
				width : 60,
				align : 'center'
			}, {
				field : 'department',
				title : '部门',
				width : 120,
				align : 'center'
			}, {
				field:'other',
				title : '其他信息',
				width : 120,
				align : 'center'
			}, {
				field : 'tel',
				title : '电话',
				width : 120,
				align : 'center'
			},{
				field : 'standby',
				title : '备注',
				width : 120,
				align : 'center'
			}]];
			$(function(){
				// 初始化 datagrid
				// 创建grid
				$('#grid').datagrid( {
					iconCls : 'icon-forward',
					fit : true,
					border : false,
					rownumbers : true,
					striped : true,
					toolbar : toolbar,
					url : "/user_list",
					idField : 'id', 
					columns : columns
				});
				
				$("body").css({visibility:"visible"});
				
			});
			
			
			function doAdd() {
				location.href="/pages/base/user_add";
			}
		
			
			function doDelete(){
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要删除的行","warning");
				}else{
					var arr = new Array();
					for(var i=0;i<rows.length;i++){
						arr.push(rows[i].id);
					}
					//生成字符串
					var ids = arr.join(",");
					window.location.href = "/user/delete?ids="+ids;
				}
			}
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
	</body>

</html>