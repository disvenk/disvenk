<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>宴会庆典评价</title>
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
		<script type="text/javascript">
		
		Date.prototype.format = function(format){ 
		    var o =  { 
		    "M+" : this.getMonth()+1, //month 
		    "d+" : this.getDate(), //day 
		    "h+" : this.getHours(), //hour 
		    "m+" : this.getMinutes(), //minute 
		    "s+" : this.getSeconds(), //second 
		    "q+" : Math.floor((this.getMonth()+3)/3), //quarter 
		    "S" : this.getMilliseconds() //millisecond 
		    };
		    if(/(y+)/.test(format)){ 
		    	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
		    }
		    for(var k in o)  { 
			    if(new RegExp("("+ k +")").test(format)){ 
			    	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
			    } 
		    } 
		    return format; 
		};
			
			function doDelete(){
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要删除的行","warning");
				}else{
					var arr = new Array();
					for(var i=0;i<rows.length;i++){
						arr.push(rows[i].talentId);
					}
					//生成字符串
					var ids = arr.join(",");
					window.location.href = "/celebration_comment/delete?ids="+ids;
				}
			}
			
			//工具栏
			var toolbar = [{
				id : 'button-delete',
				text : '删除',
				iconCls : 'icon-cancel',
				handler : doDelete
			}];
			// 定义列
			var columns = [ [ {
				field : 'talentId',
				checkbox : true,
			},{
				field : 'customerId',
				title : '客户微信标识',
				width : 120,
				align : 'center'
			}, {
				field : 'commentContent',
				title : '评价内容',
				width : 120,
				align : 'center'
			}, {
				field : 'compLevel',
				title : '评分星数',
				width : 120,
				align : 'center'
			},{
				field : 'created',
				title : '创建时间',
				width : 200,
				align : 'center',
				 formatter: function (value,row,index) {
					 var now = new Date(value);
				    	return now.format("yyyy-MM-dd hh:mm:ss");
                 }
			}] ];
			
			$(function(){
				// 先将body隐藏，再显示，不会出现页面刷新效果
				$("body").css({visibility:"visible"});
				
				// 酒店管理数据表格
				$('#grid').datagrid( {
					iconCls : 'icon-forward',
					fit : true,
					fitColumns:true,
					border : false,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : toolbar,
					url : "/celebrationComment_pageQuery",
					idField : 'talentId',//这里的字段一定与表格里的id字段对应
					columns : columns
				});
				
				  
			});
			
		
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
	</body>

</html>