<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>菜肴套餐信息设置</title>
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
					window.location.href = "/combo/delete?ids="+ids;
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
			},{
				id : 'button-association',
				text : '关联菜品',
				iconCls : 'icon-sum',
				handler : doAssociations
			}];
			// 定义列
			var columns = [ [ {
				field : 'id',
				checkbox : true,
			},{
				field : 'name',
				title : '套餐名称',
				width : 120,
				align : 'center'
			}, {
				field : 'price',
				title : '套餐价格',
				width : 120,
				align : 'center'
			},{
				field : 'img',
				title : '套餐大图',
				width : 200,
				align : 'center',
				formatter:function(value,row,index){
					return "<img src='"+value+"' width='100' height='100'/>";//在这个区域直接显示出图片
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
			},{
				field : 'updated',
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
				
				// 菜品管理数据表格
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
					url : "/combo_pageQuery",
					idField : 'id',//这里的字段一定与表格里的id字段对应
					columns : columns
				});
				
				// 添加菜品窗口
				$('#addWindow').window({
			        title: '添加菜肴套餐信息',
			        width: 400,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 400,
			        resizable:false
			    });
				
				//修改菜品窗口
				$('#eidtorWindow').window({
			        title: '修改菜肴套餐信息',
			        width: 400,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 400,
			        resizable:false
			    });
			    
			    // 对添加菜肴的 save按钮，添加click事件
				$("#save").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#addForm").form('validate')){//这个方法是内置的
						// 通过校验 
						$("#addForm").submit();
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
					}
				});
			    
				  // 对修改菜肴的 save按钮，添加click事件
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
				
				/*向左向右功能-start*/
				// 向右移动按钮 
					$("#toRight").click(function(){
						var op=$("#associationSelect").find("option");
						var nop=$("#noassociationSelect option:selected");
						var flag = true;
						$(op).each(function(e,i){
							if($(i).attr("value")==nop.attr("value")){
								flag=false;
							}
						})
						if(flag){
							$("#associationSelect").append($("#noassociationSelect option:selected"));
						}
						
					});
					
					// 向左移动按钮
					$("#toLeft").click(function(){
						var op=$("#noassociationSelect").find("option");
						var nop=$("#associationSelect option:selected");
						var flag = true;
						$(op).each(function(e,i){
							if($(i).attr("value")==nop.attr("value")){
								flag=false;
							}
						})
						if(flag){
							$("#noassociationSelect").append($("#associationSelect option:selected"));
						}else{
							$("#associationSelect option:selected").remove();
						}
						
					});
				/*向左向右功能-end*/
				
					/*为关联菜品按钮，添加click事件-start*/
					$("#associationBtn").click(function(){
						// 我们只提交已关联定区的客户，所以提交时，选中所有 已关联定区客户select中选项 ,只要选中的才能提交
						//因为每个option中都有value值，value值是可以提交的，而我们在动态添加option的时候就已经
						//用this.id添加进去了
						$("#associationSelect option").attr("selected","selected");
						// 提交表单
						$("#comboForm").submit();
					});
					/*为关联客户按钮，添加click事件-end*/
			});
			
			/*套餐关联菜品的方法-start*/
			function doAssociations(){
					// 判定用户是否只选择了一个定区 
				var rows = $("#grid").datagrid('getSelections');
				// 只选择了一行 
				if(rows.length == 1){
					// 将选中定区id，设置到form的隐藏域 
					$("#comboId").val(rows[0].id);
					
					// 显示进度条
					$.messager.progress({
						interval :500 // 每0.5秒加载10%, 5秒加载完，显示进度条后本行代码执行完毕，接着执行下面的代码，里面的进度条还是显示百分比
					});
					
					// 发起Ajax请求 
					$.post("/dishStyle_pageQuery", function(data){
							// 清空列表
							$("#noassociationSelect").empty();
						// 查询所有 已经存在的菜品列表
						$(data).each(function(){
							//这里感觉用不用$()都一样
							var option = /*$(*/"<option value='"+this.id+"'>"+this.name+"("+this.price+"元/份)</option>"/*)*/;
							$("#noassociationSelect").append(option);
						});
						
						// 请求不结束进度条就一直显示，请求结束后，关闭进度条
						$.messager.progress('close');
						// 弹出关联窗口 
						$('#customerWindow').window('open');
					});
					$.post("/findDishStyle_combo",{"id":rows[0].id} , function(data){
						// 清空列表
						$("#associationSelect").empty();
						// 查询所有 关联当前选中套餐列表
						$(data).each(function(){
							var option = $("<option value='"+this.id+"'>"+this.name+"("+this.price+"元/份)</option>");
							$("#associationSelect").append(option);
						});
					});
					
				}else{
					// 没有选 或者 选了多个定区 
					$.messager.alert('警告','套餐关联菜品必须（只能）选择一个套餐','warning');
				}
			}
			/*定区关联客户的方法-end*/
		
		
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
		<div class="easyui-window" title="菜品添加" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="addForm" action="/combo/add" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">菜肴套餐信息</td>
						</tr>
						<tr>
							<td>套餐名称</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>套餐价格</td>
							<td>
								<input type="text" data-options="validType:'length[0,8]'" name="price" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>套餐图片</td>
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
		
		<div class="easyui-window" title="菜品修改" id="eidtorWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="update" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">更改</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="updateForm" action="/combo/update" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">菜肴套餐信息</td>
							<input type="hidden" name="id"/>
						</tr>
						<tr style="color:red">
							<td>提示：</td>
							<td>
								如果不修改图片将使用原有图片*
							</td>
						</tr>
						<tr>
							<td>套餐名称</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
					
					
						<tr>
							<td>套餐价格</td>
							<td>
								<input type="text" name="price"  data-options="validType:'length[0,8]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>套餐图片</td>
							<td>
								<input type="file" style="width:200px" name="uploadFile" />
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
								<input type="hidden" name="created" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
		
		<!-- 关联客户窗口-start -->
		<div class="easyui-window" title="关联菜品窗口" id="customerWindow" modal="true" collapsible="false" closed="true" minimizable="false" maximizable="false" style="top:20px;left:200px;width: 600px;height: 300px;">
			<div style="overflow:auto;padding:5px;" border="false">
				<form id="comboForm" action="/combo_dishStyle" method="post">
					<table class="table-edit" width="80%" align="center">
						<tr class="title">
							<td colspan="3">关联菜品</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="id" id="comboId" />
								<span style="color: green;">酒店已有的菜品列表</span> <br />
								<!--这个操作与对指定的元素执行appendChild方法，将它们添加到文档中的情况类似。
									也就是说如果append("param")中的参数param是文档中已存在的对象，那么执行xx.append("param"),是移动了param
								-->
								<select id="noassociationSelect" size="10" style="width:200px;"></select>
							</td>
							<td>
								<input type="button" value="》》" id="toRight">
								<br/>
								<input type="button" value="《《" id="toLeft">
							</td>
							<td>
								<span style="color: green;">该套餐已关联菜品列表</span> <br />
								<select id="associationSelect" name="dishStyleIds" multiple="true" size="10" style="width:200px;"></select>
							</td>
						</tr>
						<tr>
							<td colspan="3"><a id="associationBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">关联菜品</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<!-- 关联客户窗口-end -->
	</body>

</html>