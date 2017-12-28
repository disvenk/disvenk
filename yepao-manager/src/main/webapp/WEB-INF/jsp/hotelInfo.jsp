<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>酒店信息设置</title>
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
					$.messager.confirm("提示", "删除之后不可恢复,确定要删除吗？",function(data){
						if(data){
							var arr = new Array();
							for(var i=0;i<rows.length;i++){
								arr.push(rows[i].id);
							}
							//生成字符串
							var ids = arr.join(",");
							window.location.href = "/hotel/delete?ids="+ids;
						}
						
					})
					
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
				field : 'hotelId',
				title : '商家账号',
				width : 130,
				align : 'center'
			},{
				field : 'password',
				title : '商家密码',
				width : 120,
				align : 'center'
			},{
				field : 'name',
				title : '酒店名称',
				width : 120,
				align : 'center'
			}, {
				field : 'address',
				title : '酒店地址',
				width : 120,
				align : 'center'
			}, {
				field : 'descreption',
				title : '酒店描述',
				width : 120,
				align : 'center'
			}, {
				field : 'tel',
				title : '酒店电话',
				width : 120,
				align : 'center'
			}, {
				field : 'img',
				title : '酒店图片',
				width : 100,
				align : 'center',
				formatter:function(value,row,index){
					return "<img src='"+value+"' width='100' height='100'/>";//在这个区域直接显示出图片
				}
			}, {
				field : 'reputationLevel',
				title : '酒店星级',
				width : 80,
				align : 'center'
			} ,{
				field : 'commentCount',
				title : '评价次数',
				width : 120,
				align : 'center'
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
				
				// 酒店管理数据表格
				$('#grid').datagrid( {
					iconCls : 'icon-forward',
					fit : true,
					//fitColumns:true,
					border : false,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : toolbar,
					url : "/hotel_pageQuery",
					idField : 'hotelId',//这里的字段一定与表格里的id字段对应
					columns : columns
				});
				
				// 添加酒店窗口
				$('#addWindow').window({
			        title: '添加酒店信息',
			        width: 400,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 400,
			        resizable:false
			    });
				
				//修改酒店窗口
				$('#eidtorWindow').window({
			        title: '修改酒店信息',
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
						// 通过校验 
						$("#addForm").submit();
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
					}
				});
			    
				  // 对修改酒店的 save按钮，添加click事件
				$("#update").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#updateForm").form('validate')){//这个方法是内置的
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
		<div class="easyui-window" title="酒店添加修改" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="addForm" action="/hotel/add" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">酒店信息</td>
						</tr>
						<tr style="color:red">
							<td>提示：</td>
							<td>
								商家账号为11位数的手机号码*
							</td>
						</tr>
							<tr>
							<td>商家账号</td>
							<td>
								<input type="text" name="hotelId"  data-options="validType:'length[0,11]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>商家密码</td>
							<td>
								<input type="text" name="password" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>酒店名称</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" />
							</td>
						</tr>
						<tr>
							<td>酒店地址</td>
							<td>
								<input type="text" name="address" class="easyui-validatebox"/>
							</td>
						</tr>
						<tr>
							<td>酒店描述</td>
							<td>
								<!-- <input type=" name="city" style="width:80%" class="easyui-validatebox" required="true" /> -->
								<textarea class="easyui-validatebox" name="descreption" style="resize: none;width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>酒店电话</td>
							<td>
								<input type="text" name="tel" class="easyui-validatebox" />
							</td>
						</tr>
						<tr>
							<td>酒店图片</td>
							<td>
								<input type="file" style="width:200px" name="uploadFile" class="easyui-validatebox" />
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
		
		<div class="easyui-window" title="酒店添加修改" id="eidtorWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="update" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">更改</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="updateForm" action="/hotel/update" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">酒店信息</td>
							<input type="hidden" name="id"/>
						</tr>
						<tr style="color:red">
							<td>提示：</td>
							<td>
								如果不修改图片将使用原有图片*
							</td>
						</tr>
						<tr>
							<td>商家账号</td>
							<td>
								<input type="text" name="hotelId"  data-options="validType:'length[0,15]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>商家密码</td>
							<td>
								<input type="text" name="password" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>酒店名称</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>酒店地址</td>
							<td>
								<input type="text" name="address" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>酒店描述</td>
							<td>
								<!-- <input type=" name="city" style="width:80%" class="easyui-validatebox" required="true" /> -->
								<textarea class="easyui-validatebox" name="descreption" style="resize: none;width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>酒店电话</td>
							<td>
								<input type="text" name="tel" class="easyui-validatebox" required="true"/>
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
						<tr>
							<td>
								<input type="hidden" name="insertDate" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</body>

</html>