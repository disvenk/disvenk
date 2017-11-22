<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>预约信息设置</title>
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

		
		//将查询表单中的数据转换成json数据-start
		$.fn.serializeJson=function(){  
            var serializeObj={};  
            var array=this.serializeArray();  
            var str=this.serialize();  
            $(array).each(function(){  
                if(serializeObj[this.name]){  
                    if($.isArray(serializeObj[this.name])){  
                        serializeObj[this.name].push(this.value);  
                    }else{  
                        serializeObj[this.name]=[serializeObj[this.name],this.value];
                    }  
                }else{  
                    serializeObj[this.name]=this.value;   
                }  
            });  
            return serializeObj;  
        }; 
        //将查询表单中的数据转换成json数据-end
		
			function doAdd(){
        		
				$('#addWindow').window("open");
			}
			
			function doView(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要修改的行","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","修改数据时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$("#eidtorWindow").form('load',row);
					// 显示窗口
					$("#eidtorWindow").window('open');
				}
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
					window.location.href = "/appointment/delete?ids="+ids;
				}
			}
			
			//工具栏
			var toolbar = [ {
				id : 'button-edit',	
				text : '修改',
				iconCls : 'icon-edit',
				handler : doView
			}, {
				id : 'button-add',
				text : '增加',
				iconCls : 'icon-add',
				handler : doAdd
			}, {
				id : 'button-delete',
				text : '删除',
				iconCls : 'icon-cancel',
				handler : doDelete
			}];
			// 定义列
			var columns = [ [ {
				field : 'id',
				checkbox : true,
			},{
				field : 'name',
				title : '宴会厅名称',
				width : 120,
				align : 'center'
			}, {
				field : 'customer',
				title : '客户名称',
				width : 120,
				align : 'center'
			},{
				field : 'tel',
				title : '联系方式',
				width : 120,
				align : 'center'
			},{
				field : 'status',
				title : '状态',
				width : 120,
				align : 'center'
			},{
				field : 'timepoint',
				title : '时间段',
				width : 120,
				align : 'center'
			},{
				field : 'time',
				title : '预约看场时间',
				width : 200,
				align : 'center',
				 formatter: function (value,row,index) {
					 var now = new Date(value);
				    	return now.format("yyyy-MM-dd");
                 }
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
				
				// 预约管理数据表格
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
					url : "/appointment_pageQuery",
					idField : 'id',//这里的字段一定与表格里的id字段对应
					columns : columns
				});
				
				// 添加预约窗口
				$('#addWindow').window({
			        title: '添加预约信息',
			        width: 400,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 400,
			        resizable:false
			    });
				
				//修改预约窗口
				$('#eidtorWindow').window({
			        title: '修改预约信息',
			        width: 400,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 400,
			        resizable:false
			    });
			    
			    // 对添加预约的 save按钮，添加click事件
				$("#save").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#addForm").form('validate')){//这个方法是内置的
						var time = $("#times").datebox('getValue')
						alert(time);
						if(time==""){
							$.messager.alert("警告","请选择看场时间","warning");
							return;
						}
						if(!/^(\d{4})\-(\d{2})\-(\d{2})$/.test(time)){
							$.messager.alert("警告","看场时间格式错误","warning");
							return;
						}
						
					var timePoint=$("#timepoint option:selected").attr("value");
					if(timePoint==""){
						$.messager.alert("警告","请选择时间段","warning");
						return;
					}
						// 通过校验 
						$("#addForm").submit();
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
					}
				});
			    
				  // 对修改预约的 save按钮，添加click事件
				$("#update").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#updateForm").form('validate')){//这个方法是内置的
						
						var times = $("#timess").datebox('getValue')
						alert(times);
						if(times==""){
							$.messager.alert("警告","请选择看场时间","warning");
							return;
						}
						if(!/^(\d{4})\-(\d{2})\-(\d{2})$/.test(times)){
							$.messager.alert("警告","看场时间格式错误","warning");
							return;
						}
						var timePoint=$("#timepoint option:selected").attr("value");
						if(timePoint=="-请选择-"){
							$.messager.alert("警告","请选择时间段","warning");
							return;
						}
						var status=$("#status option:selected").attr("value");
						if(status=="-请选择-"){
							$.messager.alert("警告","请选择状态","warning");
							return;
						}
						// 通过校验 
						$("#updateForm").submit();
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
					}
				});
				  
				//窗口关闭时触发的事件
			 	$("#eidtorWindow").window({
	                onBeforeClose: function () {
	                	$("#editorForm").form("reset");
	                }
	                }); 
	                
				$("#addWindow").window({
	                onBeforeClose: function () {
	                	//当面板关闭之前触发的事件
	                	$("#addForm").form("reset");
	                	}
	         
	                });
			});
			
		
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
	</body>
<div class="easyui-window" title="预约添加" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="addForm" action="/appointment/add" method="post" >
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">预约信息</td>
						</tr>
						<tr>
							<td>宴会厅名称:</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>客户名称:</td>
							<td>
								<input type="text" name="customer" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>联系方式:</td>
							<td>
								<input type="text" name="tel"  data-options="validType:'length[0,11]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>看场时间:</td>
						<td>
							<input type="text" name="times" id="times" class="easyui-datebox easyui-validatebox"/>
						</td>
					</tr>
					<tr>
						<td>时间段:</td>
						<td>
							<select name="timepoint" id="timepoint" style="width: 150px;">
								<option value="">-请选择-</option>
								<option value="上午">上午</option>
								<option value="下午">下午</option>
							</select>
						</td>
					</tr>
					</table>
				</form>
			</div>
		</div>
		
		<div class="easyui-window" title="预约修改" id="eidtorWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="update" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">更改</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="updateForm" action="/appointment/update" method="post" >
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">预约信息</td>
							<input type="hidden" name="id"/>
						</tr>
						<tr>
							<td>宴会厅名称:</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>客户名称:</td>
							<td>
								<input type="text" name="customer" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>联系方式:</td>
							<td>
								<input type="text" name="tel"  data-options="validType:'length[0,11]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>看场时间:</td>
						<td>
							<input type="text" name="timess" id="timess" class="easyui-datebox easyui-validatebox" />
						</td>
					</tr>
					<tr>
						<td>时间段:</td>
						<td>
							<select name="timepoint" id="timepoint" style="width: 150px;">
								<option value="">-请选择-</option>
								<option value="上午">上午</option>
								<option value="下午">下午</option>
							</select>
						</td>
					</tr>
						<tr>
						<td>状态:</td>
						<td>
							<select name="status" id="status" style="width: 150px;">
								<option value="">-请选择-</option>
								<option value="有效">有效</option>
								<option value="失效">失效</option>
							</select>
						</td>
					</tr>
					</table>
				</form>
			</div>
		</div>
</html>