<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>策划师信息设置</title>
		<!-- 导入jquery核心类库 -->
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<!-- 导入ocupload -->
		<script type="text/javascript" src="/js/ocupload/jquery.ocupload-1.1.2.js" ></script>
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
				$('#operatingId').combobox({    
				    onLoadSuccess : function() {  
				       // $("#operatingId").combobox("select", "CMCC");  
				        $("#operatingId").combobox("setValue", "-请选择-");  
				    }  
				});
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
					// 没选  
					$.messager.alert("提示信息","请选择您要删除的行","warning");
				}else{
					var arr = new Array();
					for(var i=0;i<rows.length;i++){
						arr.push(rows[i].weddingTalentId);
					}
					//生成字符串
					var ids = arr.join(",");
					window.location.href = "/talent/delete?talent=planner&ids="+ids;
				}
			}
			
			function doUploadImg(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要上传的策划师","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","上传数据时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$.cookie("plannerId", row.weddingTalentId+","+row.name, {path: '/',expires: 1});
					$.cookie("plannerImg",row.headImg,{path: '/',expires: 1});
					$.cookie("plannerName",row.name,{path: '/',expires: 1});
					location.href="/pages/base/plannerUploadImg";
					
				}
			}
			
			function doUploadMedia(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要上传的策划师","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","上传数据时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$.cookie("plannerId", row.weddingTalentId+","+row.name, {path: '/',expires: 1});
					$.cookie("plannerImg",row.headImg,{path: '/',expires: 1});
					$.cookie("plannerName",row.name,{path: '/',expires: 1});
					location.href="/pages/base/plannerUploadMedia";
					
				}
			}
			
			function checkImgWorks(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要查看的策划师","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","查看作品时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$.cookie("checkPlannerId", row.weddingTalentId, {path: '/',expires: 1});
					location.href="/pages/base/plannerImgWorks";
					
				}
			}
			
			function checkMediaWorks(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要查看的策划师","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","查看作品时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$.cookie("checkPlannerId", row.weddingTalentId, {path: '/',expires: 1});
					location.href="/pages/base/plannerMediaWorks";
					
				}
			}
			
			function checkComment(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要查看的主持人","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","查看作品时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$.cookie("checkPlannerId", row.weddingTalentId, {path: '/',expires: 1});
					location.href="/pages/base/planner_comment";
					
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
			}, {
				id : 'button-upload',
				text : '上传图片',
				iconCls : 'icon-redo',
				handler : doUploadImg
			}, {
				id : 'button-upload',
				text : '上传视频',
				iconCls : 'icon-redo',
				handler : doUploadMedia
			}, {
				id : 'button-upload',
				text : '查看图片作品',
				iconCls : 'icon-search',
				handler : checkImgWorks
			}, {
				id : 'button-upload',
				text : '查看视频作品',
				iconCls : 'icon-search',
				handler : checkMediaWorks
			},{
				id : 'button-upload',
				text : '查看评论',
				iconCls : 'icon-search',
				handler : checkComment
			}];
			// 定义列
			var columns = [ [ {
				field : 'weddingTalentId',
				checkbox : true,
			},{
				field : 'headImg',
				title : '头像',
				width : 120,
				align : 'center',
				formatter:function(value,row,index){
					return "<img src='"+value+"' width='100' height='100'/>";//在这个区域直接显示出图片
				}
			}, {
				field : 'name',
				title : '姓名',
				width : 120,
				align : 'center'
			}, {
				field : 'occupation',
				title : '职业',
				width : 120,
				align : 'center'
			}, {
				field : 'experience',
				title : '工作经验',
				width : 120,
				align : 'center'
			}, {
				field : 'tel',
				title : '联系方式',
				width : 200,
				align : 'center'
			}, {
				field : 'price',
				title : '雇佣价格',
				width : 80,
				align : 'center'
			} ,{
				field : 'introduction',
				title : '简介',
				width : 120,
				align : 'center'
			},{
				field : 'style',
				title : '风格',
				width : 120,
				align : 'center'
			},{
				field : 'goodReputation',
				title : '好评率',
				width : 120,
				align : 'center'
			},{
				field : 'comprehensive',
				title : '综合评价星级',
				width : 120,
				align : 'center'
			},{
				field : 'chosenCount',
				title : '交易次数',
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
					//fitColumns:true,
					border : false,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : toolbar,
					url : "/talent_pageQuery?name=策划师",
					idField : 'weddingTalentId',//这里的字段一定与表格里的id字段对应
					columns : columns
					
				});
				
				// 添加酒店窗口
				$('#addWindow').window({
			        title: '添加策划师信息',
			        width: 400,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 400,
			        resizable:false
			    });
				
				//修改酒店窗口
				$('#eidtorWindow').window({
			        title: '修改策划师信息',
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
		<div class="easyui-window" title="策划师添加" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="addForm" action="/talent/add?talent=planner" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">人才信息</td>
						</tr>
						<tr>
						<td>酒店名称</td>
						<td>
							 <input type="text" id="operatingId" name="hotelid" class="easyui-combobox" data-options="required:true,valueField:'hotelId',textField:'name',url:'/hotel_pageQuery'"/> 
							
						</td>
						</tr>
						<tr>
							<td>人才头像</td>
							<td>
								<input type="file" style="width:200px" name="uploadFile" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>人才姓名</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
								<input type="hidden" value="策划师"  name="occupation"/>
							</td>
						</tr>
								 
						<tr>
							<td>工作经验</td>
							<td>
								<input type="text" name="experience" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>联系方式</td>
							<td>
								<input type="text" name="tel"  data-options="validType:'length[0,11]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>雇佣价格</td>
							<td>
								<input type="text" style="width:200px" name="price" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>人才简介</td>
							<td>
								<textarea name="introduction" style="resize: none;width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>风格</td>
							<td>
								<input type="checkbox" name="styles" value="童话"/>童话
								<input type="checkbox" name="styles" value="优雅"/>优雅
								<input type="checkbox" name="styles" value="奢华"/>奢华
								<input type="checkbox" name="styles" value="豪华"/>豪华
								<!-- <input type="text" style="width:200px" name="style" class="easyui-validatebox" required="true"/> -->
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
		
		<div class="easyui-window" title="策划师修改" id="eidtorWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="update" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">更改</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
					<form id="updateForm" action="/talent/update?talent=planner" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">人才信息</td>
							<input type="hidden" name="weddingTalentId"/>
							<input type="hidden" name="created"/>
							<input type="hidden" name="hotelid"/>
						</tr>
						<tr style="color:red">
							<td>提示：</td>
							<td>
								如果不修改头像将使用原有头像*
							</td>
						</tr>
						<tr>
							<td>人才头像</td>
							<td>
								<input type="file" style="width:200px" name="uploadFile"/>
							</td>
						</tr>
						<tr>
							<td>人才姓名</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
								<input type="hidden" value="策划师"  name="occupation"/>
							</td>
						</tr>
						<tr>
							<td>工作经验</td>
							<td>
								<input type="text" name="experience" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>联系方式</td>
							<td>
								<input type="text" name="tel"  data-options="validType:'length[0,11]'" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>雇佣价格</td>
							<td>
								<input type="text" style="width:200px" name="price" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>人才简介</td>
							<td>
								<textarea name="introduction" style="width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>风格</td>
							<td>
								<input type="checkbox" name="styles" value="童话"/>童话
								<input type="checkbox" name="styles" value="优雅"/>优雅
								<input type="checkbox" name="styles" value="奢华"/>奢华
								<input type="checkbox" name="styles" value="豪华"/>豪华
								<!-- <input type="text" style="width:200px" name="style" class="easyui-validatebox" required="true"/> -->
							</td>
						</tr>
						<tr>
							<td>备注</td>
							<td>
								<textarea name="standby" style="width:80%;height:80px" rows="20"></textarea> 
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</body>

</html>