<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>宴会厅信息设置</title>
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
        		location.href="/pages/base/hall-add";
				//$('#addWindow').window("open");
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
					$.messager.alert("提示信息","请选择您要修改的行","warning");
				}else{
					var arr = new Array();
					for(var i=0;i<rows.length;i++){
						arr.push(rows[i].hotelId);
					}
					//生成字符串
					var ids = arr.join(",");
					window.location.href = "/hall/delete?ids="+ids;
				}
			}
			
			function doDelete(){
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要修改的行","warning");
				}else{
					var arr = new Array();
					for(var i=0;i<rows.length;i++){
						arr.push(rows[i].hotelId);
					}
					//生成字符串
					var ids = arr.join(",");
					window.location.href = "/hotel/delete?ids="+ids;
				}
			}
			
			//工具栏
			var toolbar = [{
				id : 'button-add',
				text : '增加宴会厅',
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
				field : 'banquetHallId',
				checkbox : true,
			},{
				field : 'name',
				title : '宴会厅名称',
				width : 80,
				align : 'center'
			}, {
				field : 'floorNum',
				title : '楼层',
				width : 50,
				align : 'center'
			}, {
				field : 'tableNum',
				title : '桌数',
				width : 50,
				align : 'center'
			}, {
				field : 'floorHeight',
				title : '层高',
				width : 50,
				align : 'center'
			}, {
				field : 'area',
				title : '面积',
				width : 50,
				align : 'center'
			}, {
				field : 'images',
				title : '图片',
				width : 120,
				align : 'center',
				formatter:function(value,row,index){
					return "<img src='"+value[0]+"' width='100' height='100'/>";//在这个区域直接显示出图片
				}
			} ,{
				field : 'created',
				title : '创建时间',
				width : 150,
				align : 'center',
				formatter: function (value,row,index) {
					 var now = new Date(value);
				    	return now.format("yyyy-MM-dd hh:mm:ss");
                 }
			},{
				field : 'updated',
				title : '更新时间',
				width : 150,
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
					url : "/hall_pageQuery",
					idField : 'banquetHallId',//这里的字段一定与表格里的id字段对应
					columns : columns
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
			 
			});
			
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
		
		<div class="easyui-window" title="酒店添加修改" id="eidtorWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="save" icon="icon-save" href="javascript:submitForm()" class="easyui-linkbutton" plain="true">保存</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="updateForm" action="/hall/update" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">宴会厅信息</td>
							<input type="hidden" name="banquetHallId"/>
						</tr>
					 	<tr>
	           			 	<td>名称:</td>
	            			<td><input class="easyui-validatebox" type="text" name="name" required="true"></input></td>
	        			</tr>
						<tr>
							<td>楼层</td>
							<td>
								<input type="text" name="floorNum" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
	            			<td>桌数:</td>
	            			<td><input class="easyui-numberbox easyui-validatebox" type="text" name="tableNum" required="true"/></td>
	        			</tr>
						<tr>
	            			<td>层高:</td>
	            			<td><input class="easyui-numberbox easyui-validatebox" type="text" name="floorHeight" required="true"/> </td>
	        			</tr>
					 	<tr>
	            			<td>面积:</td>
	           				<td><input class="easyui-numberbox easyui-validatebox" type="text" name="area" required="true" /></td>
	        			</tr>
	        			<tr>
	            			<td>图片:</td>
	            			<td style="line-height: 52px">
	            	 		<a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 		<input type="hidden" id="image" name="img"/>
	           				 </td>
	       				</tr>
						<tr>
	            			<td>备注:</td>
	            			<td><textarea name="standby" style="resize: none;height: 80px" rows="20"></textarea></td>
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
	<script type="text/javascript">
	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器,在商品描述那个文本域中添加一个富文本编辑器
		//itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		//初始化类目选择和图片上传器，这里就会加载init属性只想属性里面的方法，在间接的执行了其他的属性里的方法，比如商品类目和图片上传
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#updateForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("/add/hall",$("#hallAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增宴会厅成功!');
				location.href="/pages/base/hall";
			}else{
				$.messager.alert('提示','新增宴会厅失败!');
			}
		});
	}
	
	function clearForm(){
		$('#hallAddForm').form('reset');
	}
</script>
	</body>

</html>