<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>消息推送设置</title>
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
				$('#operatingId').combobox({    
				    onLoadSuccess : function() {  
				       // $("#operatingId").combobox("select", "CMCC");  
				        $("#operatingId").combobox("setValue", "-请选择-");  
				    }  
				});
			}
			
			
			function doDelete(){
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要删除的行","warning");
				}else{
					var arr = new Array();
					for(var i=0;i<rows.length;i++){
						arr.push(rows[i].messageId);
					}
					//生成字符串
					var ids = arr.join(",");
					window.location.href = "/masseger/delete?ids="+ids;
				}
			}
			
			//工具栏
			var toolbar = [ {
				id : 'button-add',
				text : '创建消息',
				iconCls : 'icon-add',
				handler : doAdd
			}, {
				id : 'button-delete',
				text : '删除消息',
				iconCls : 'icon-cancel',
				handler : doDelete
			}];
			// 定义列
			var columns = [ [ {
				field : 'messageId',
				checkbox : true,
			},{
				field : 'title',
				title : '标题',
				width : 120,
				align : 'center'
			}, {
				field : 'commentContent',
				title : '消息内容',
				width : 200,
				align : 'center'
			},{
				field : 'img',
				title : '消息配图',
				width : 120,
				align : 'center',
				formatter:function(value,row,index){
					return "<img src='"+value+"' width='100' height='100'/>";//在这个区域直接显示出图片
				}
			},{
				field : 'insertDate',
				title : '创建时间',
				width : 200,
				align : 'center',
				 formatter: function (value,row,index) {
					 var now = new Date(value);
				    	return now.format("yyyy-MM-dd hh:mm:ss");
                 }
			},{
				field : 'updateDate',
				title : '更新时间',
				width : 200,
				align : 'center',
				 formatter: function (value,row,index) {
					 var now = new Date(value);
				    	return now.format("yyyy-MM-dd hh:mm:ss");
                 }
			},{
				field : 'standby',
				title : '备注',
				width : 200,
				align : 'center'
			}] ];
			
			$(function(){
				// 先将body隐藏，再显示，不会出现页面刷新效果
				$("body").css({visibility:"visible"});
				
				$('#operatingId').combobox({    
				    onLoadSuccess : function() {  
				       // $("#operatingId").combobox("select", "CMCC");  
				        $("#operatingId").combobox("setValue", "-请选择-");  
				    }  
				});
				
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
					url : "/messager_pageQuery",
					idField : 'messageId',//这里的字段一定与表格里的id字段对应
					columns : columns
				});
				
				// 添加消息窗口
				$('#addWindow').window({
			        title: '添加消息',
			        width: 400,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 400,
			        resizable:false
			    });
			    
			    // 对添加酒店的 save按钮，添加click事件
				$("#save").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#addForm").form('validate')){//这个方法是内置的
						var hotelName=$("#operatingId").combobox('getValue');
						if(hotelName=="-请选择-"){
							
							$.messager.alert("警告","请选择酒店名称","warning");
							return;
						}
						// 通过校验 
						$("#addForm").submit();
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
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
		<div class="easyui-window" title="消息添加" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">添加</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="addForm" action="/message/add" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">消息信息</td>
							<input type="hidden" name="hotelId"/>
						</tr>
						<tr>
						<td>酒店名称</td>
						<td>
							 <input type="text" id="operatingId" name="hotelid" class="easyui-combobox" data-options="required:true,valueField:'hotelId',textField:'name',url:'/hotel_pageQuery'"/> 
						</td>
						</tr>
						<tr>
							<td>消息标题:</td>
							<td>
								<textarea class="easyui-validatebox" required="true" name="title" style="resize: none;width:80%;height:50px" rows="20"></textarea> 
								
							</td>
						</tr>
						<tr>
							<td>消息内容</td>
							<td>
								<textarea class="easyui-validatebox" required="true" name="commentContent" style="resize: none;width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>消息配图</td>
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
			</div>
		</div>
		
	</body>

</html>