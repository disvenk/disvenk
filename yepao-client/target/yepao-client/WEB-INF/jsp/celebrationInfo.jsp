<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>宴会庆典信息设置</title>
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
			
			function doEditor(){
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
					$("#editorWindow").form('load',row);
					//加载其它
					var stageHolographicH=$("#stageHolographicH").val();
					var arr1=stageHolographicH.split(",");
					for(var i=0;i<arr1.length;i++){
						var option=$("<option value='"+arr1[i]+"'>"+arr1[i]+"</option>")
						$("#EstageHolographicSelect").append(option);
					}
					//加载迎宾
					var welcomeH=$("#welcomeH").val();
					var arr2=welcomeH.split(",");
					for(var i=0;i<arr2.length;i++){
						var option=$("<option value='"+arr2[i]+"'>"+arr2[i]+"</option>")
						$("#EwelcomeSelect").append(option);
					}
					//加载仪式
					var ceremonyH=$("#ceremonyH").val();
					var arr3=ceremonyH.split(",");
					for(var i=0;i<arr3.length;i++){
						var option=$("<option value='"+arr3[i]+"'>"+arr3[i]+"</option>")
						$("#EceremonySelect").append(option);
					}
					//加载婚宴区
					var weddingH=$("#weddingH").val();
					var arr4=weddingH.split(",");
					for(var i=0;i<arr4.length;i++){
						var option=$("<option value='"+arr4[i]+"'>"+arr4[i]+"</option>")
						$("#EweddingSelect").append(option);
					}
					//加载舞台灯光
					var deskLightH=$("#deskLightH").val();
					var arr5=deskLightH.split(",");
					for(var i=0;i<arr5.length;i++){
						var option=$("<option value='"+arr5[i]+"'>"+arr5[i]+"</option>")
						$("#EdeskLightSelect").append(option);
					}
					// 显示窗口
					$("#editorWindow").window('open');
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
					window.location.href = "/celebration/delete?ids="+ids;
				}
			}
			
			function doUploadImg(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要上传的宴会庆典","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","上传数据时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$.cookie("celebrationId", row.id+","+row.name, {path: '/',expires: 1});
					$.cookie("celebrationImg",row.img,{path: '/',expires: 1});
					$.cookie("celebrationName",row.name,{path: '/',expires: 1});
					location.href="/pages/base/celebrationUploadImg";
					
				}
			}
			
			
			function checkImgWorks(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要查看的宴会庆典","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","查看图片时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去
					$.cookie("checkCelebrationId", row.id, {path: '/',expires: 1});
					location.href="/pages/base/celebrationImgWorks";
					
				}
			}
			
			function checkComment(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要查看的宴会庆典","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","查看作品时，只能选中一行","warning")
				}else{
					// 只选中一行 
					var row = rows[0]; 
					
					$.cookie("checkCelebrationId", row.id, {path: '/',expires: 1});
					location.href="/pages/base/celebration_comment";
					
				}
			}
			
			//工具栏
			var toolbar = [ {
				id : 'button-edit',	
				text : '修改',
				iconCls : 'icon-edit',
				handler : doEditor
			}, {
				id : 'button-add',
				text : '增加',
				iconCls : 'icon-add',
				handler : doAdd
			},{
				id : 'button-delete',
				text : '删除',
				iconCls : 'icon-cancel',
				handler : doDelete
			},{
				id : 'button-upload',
				text : '上传庆典图片',
				iconCls : 'icon-redo',
				handler : doUploadImg
			},{
				id : 'button-check',
				text : '查看庆典图片',
				iconCls : 'icon-search',
				handler : checkImgWorks
			},{
				id : 'button-upload',
				text : '查看评论',
				iconCls : 'icon-search',
				handler : checkComment
			}];
			// 定义列
			var columns = [ [ {
				field : 'id',
				checkbox : true,
			},{
				field : 'name',
				title : '庆典名称',
				width : 120,
				align : 'center'
			},{
				field : 'style',
				title : '风格',
				width : 120,
				align : 'center'
			},{
				field : 'theme',
				title : '主题',
				width : 120,
				align : 'center'
			},{
				field : 'basename',
				title : '基础套餐名',
				width : 120,
				align : 'center'
			},{
				field : 'preprice',
				title : '基础套餐价格',
				width : 120,
				align : 'center'
			},{
				field : 'img',
				title : '大图',
				width : 200,
				align : 'center',
				formatter:function(value,row,index){
					var arr=value.split(",");
					return "<img src='"+arr[0]+"' width='100' height='100'/>";//在这个区域直接显示出图片
				}
			},{
				field : 'comboname',
				title : '豪华套餐名',
				width : 120,
				align : 'center'
			},{
				field : 'price',
				title : '豪华套餐价',
				width : 120,
				align : 'center'
			},{
				field : 'stagePrice',
				title : '舞台全息价',
				width : 120,
				align : 'center'
			},{
				field : 'stageHolographic',
				title : '舞台全息',
				width : 120,
				align : 'center' ,
				formatter: function (value,row,index) {
					var arr = value.split(",");
					var str="";
					for(var i=0;i<arr.length;i++){
						
						if(i==arr.length-1){
							str=str.concat(arr[i]);
						}else{
							str=str.concat(arr[i]+"</br>");
						}
						
					}
					return str;
                } 
			},{
				field : 'welcome',
				title : '迎宾区',
				width : 200,
				align : 'center',
				formatter: function (value,row,index) {
					var arr = value.split(",");
					var str="";
					for(var i=0;i<arr.length;i++){
						
						if(i==arr.length-1){
							str=str.concat(arr[i]);
						}else{
							str=str.concat(arr[i]+"</br>");
						}
						
					}
					return str;
                } 
			},{
				field : 'ceremony',
				title : '仪式区',
				width : 200,
				align : 'center',
				formatter: function (value,row,index) {
					var arr = value.split(",");
					var str="";
					for(var i=0;i<arr.length;i++){
						
						if(i==arr.length-1){
							str=str.concat(arr[i]);
						}else{
							str=str.concat(arr[i]+"</br>");
						}
						
					}
					return str;
                } 
			},{
				field : 'weddingplace',
				title : '婚宴区',
				width : 200,
				align : 'center',
				formatter: function (value,row,index) {
					var arr = value.split(",");
					var str="";
					for(var i=0;i<arr.length;i++){
						
						if(i==arr.length-1){
							str=str.concat(arr[i]);
						}else{
							str=str.concat(arr[i]+"</br>");
						}
						
					}
					return str;
                } 
			},{
				field : 'desklight',
				title : '舞台灯光',
				width : 200,
				align : 'center',
				formatter: function (value,row,index) {
					var arr = value.split(",");
					var str="";
					for(var i=0;i<arr.length;i++){
						
						if(i==arr.length-1){
							str=str.concat(arr[i]);
						}else{
							str=str.concat(arr[i]+"</br>");
						}
						
					}
					return str;
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
					//fitColumns:true,
					border : false,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : toolbar,
					url : "/celebration_pageQuery?hotelId="+$.cookie("yonghuming"),
					idField : 'id',//这里的字段一定与表格里的id字段对应
					columns : columns
				});
				
				// 添加庆典窗口
				$('#addWindow').window({
			        title: '添加宴会庆典信息',
			        width: 800,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 500,
			        resizable:false
			    });
				
				//修改庆典窗口
				$('#editorWindow').window({
			        title: '修改宴会庆典信息',
			        width: 800,
			        modal: true,
			        shadow: true,
			        closed: true,
			        height: 500,
			        resizable:false
			    });
			    
			    // 对添加庆典的 save按钮，添加click事件
				$("#save").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#addForm").form('validate')){//这个方法是内置的
						var stageHolographic=$("#stageHolographicSelect").html();
						var web=$("#welcomeSelect").html()
						var cere=$("#ceremonySelect").html();
						var wed=$("#weddingSelect").html();
						var light=$("#deskLightSelect").html();
						if(stageHolographic&&web&&cere&&wed&&light){
							$("#stageHolographicSelect option").attr("selected","selected");
							$("#welcomeSelect option").attr("selected","selected");
							$("#ceremonySelect option").attr("selected","selected");
							$("#weddingSelect option").attr("selected","selected");
							$("#deskLightSelect option").attr("selected","selsected");
							// 通过校验 
							$("#addForm").submit();
						}else{
							$.messager.alert("警告","插入框的内容还未填写完","warning");
						}
						
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
					}
				});
			    
				  // 对修改菜肴的 save按钮，添加click事件
				$("#update").click(function(){
					// 判断是否form中所有表单对象 都是通过校验 
					if($("#updateForm").form('validate')){//这个方法是内置的
						var stageHolographic=$("#EstageHolographicSelect").html();
						var web=$("#EwelcomeSelect").html()
						var cere=$("#EceremonySelect").html();
						var wed=$("#EweddingSelect").html();
						var light=$("#EdeskLightSelect").html();
						if(stageHolographic&&web&&cere&&wed&&light){
							$("#EstageHolographicSelect option").attr("selected","selected");
							$("#EwelcomeSelect option").attr("selected","selected");
							$("#EceremonySelect option").attr("selected","selected");
							$("#EweddingSelect option").attr("selected","selected");
							$("#EdeskLightSelect option").attr("selected","selsected");
						// 通过校验 
						$("#updateForm").submit();
					}else{
						$.messager.alert("警告","表单中还存在一些非法内容","warning");						
					}
						};
				});
				  
				//窗口关闭时触发的事件
			 	$("#editorWindow").window({
	                onBeforeClose: function () {
	                	$("#editorForm").form("reset");
	                	
	                }
	                }); 
	                
				$("#addWindow").window({
	                onBeforeClose: function () {
	                	//当面板关闭之前触发的事件
	                	$("#addForm").form("reset");
	                	$("#welcomeSelect").html("");
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
		
			//其它插入按钮
			function stageHolographicF(){
				var stageHolographic=$("#stageHolographic").val().trim();
				if(stageHolographic!=""){
					var option = $("<option value='"+stageHolographic+"'>"+stageHolographic+"</option>");
					$("#stageHolographicSelect").append(option);
					$("#stageHolographicSelect").val("");
					$("#stageHolographicSelect").focus();
				}
			}
			//其它移除按钮
			function stageHolographicFF(){
					$("#stageHolographicSelect option:selected").remove();	
			}
			//其它清空按钮
			function stageHolographicFFF(){
				$("#stageHolographicSelect").html("");
			}
			
			//迎宾插入按钮
			function welcomeF(){
				var wel=$("#welcome").val().trim();
				if(wel!=""){
					var option = $("<option value='"+wel+"'>"+wel+"</option>");
					$("#welcomeSelect").append(option);	
					$("#welcome").val("");
					$("#welcome").focus();
				}
			}
			//迎宾移除按钮
			function welcomeFF(){
					$("#welcomeSelect option:selected").remove();	
			}
			//迎宾清空按钮
			function welcomeFFF(){
				$("#welcomeSelect").html("");
			}
		
			//仪式插入按钮
			function ceremonyF(){
				var cere=$("#ceremony").val().trim();
				if(cere!=""){
					var option = $("<option value='"+cere+"'>"+cere+"</option>");
					$("#ceremonySelect").append(option);
					$("#ceremony").val("");
					$("#ceremony").focus();
				}
			}
			//仪式移除按钮
			function ceremonyFF(){
					$("#ceremonySelect option:selected").remove();	
			}
			//仪式清空按钮
			function ceremonyFFF(){
				$("#ceremonySelect").html("");
			}
			
			//婚宴插入按钮
			function weddingF(){
				var wed=$("#wedding").val().trim();
				if(wed!=""){
					var option = $("<option value='"+wed+"'>"+wed+"</option>");
					$("#weddingSelect").append(option);	
					$("#wedding").val("");
					$("#wedding").focus();
				}
			}
			//婚宴移除按钮
			function weddingFF(){
					$("#weddingSelect option:selected").remove();	
			}
			//婚宴清空按钮
			function weddingFFF(){
				$("#weddingSelect").html("");
			}
			
			//舞台灯光插入按钮
			function deskLightF(){
				var light=$("#deskLight").val().trim();
				if(light!=""){
					var option = $("<option value='"+light+"'>"+light+"</option>");
					$("#deskLightSelect").append(option);
					$("#deskLight").val("");
					$("#deskLight").focus();
				}
			}
			//舞台灯光移除按钮
			function deskLightFF(){
					$("#deskLightSelect option:selected").remove();	
			}
			//舞台灯光清空按钮
			function deskLightFFF(){
				$("#deskLightSelect").html("");
			}
			
/* ------------------------------------------------------------------------------------------------------------------------------------------- */
			
			//其它插入按钮
			function stageHolographicEF(){
				var stageHolographic=$("#EstageHolographic").val().trim();
				if(stageHolographic!=""){
					var option = $("<option value='"+stageHolographic+"'>"+stageHolographic+"</option>");
					$("#EstageHolographicSelect").append(option);
					$("#EstageHolographic").val("");
					$("#EstageHolographic").focus();
				}
			}
			//其它移除按钮
			function stageHolographicEFF(){
					$("#EstageHolographicSelect option:selected").remove();	
			}
			//其它清空按钮
			function stageHolographicEFF(){
				$("#EstageHolographicSelect").html("");
			}
			
			//迎宾插入按钮
			function welcomeEF(){
				var wel=$("#Ewelcome").val().trim();
				if(wel!=""){
					var option = $("<option value='"+wel+"'>"+wel+"</option>");
					$("#EwelcomeSelect").append(option);	
					$("#Ewelcome").val("");
					$("#Ewelcome").focus();
				}
			}
			//迎宾移除按钮
			function welcomeEFF(){
					$("#EwelcomeSelect option:selected").remove();	
			}
			//迎宾清空按钮
			function welcomeEFFF(){
				$("#EwelcomeSelect").html("");
			}
		
			//仪式插入按钮
			function ceremonyEF(){
				var cere=$("#Eceremony").val().trim();
				if(cere!=""){
					var option = $("<option value='"+cere+"'>"+cere+"</option>");
					$("#EceremonySelect").append(option);
					$("#Eceremony").val("");
					$("#Eceremony").focus();
				}
			}
			//仪式移除按钮
			function ceremonyEFF(){
					$("#EceremonySelect option:selected").remove();	
			}
			//仪式清空按钮
			function ceremonyEFFF(){
				$("#EceremonySelect").html("");
			}
			
			//婚宴插入按钮
			function weddingEF(){
				var wed=$("#Ewedding").val().trim();
				if(wed!=""){
					var option = $("<option value='"+wed+"'>"+wed+"</option>");
					$("#EweddingSelect").append(option);	
					$("#Ewedding").val("");
					$("#Ewedding").focus();
				}
			}
			//婚宴移除按钮
			function weddingEFF(){
					$("#EweddingSelect option:selected").remove();	
			}
			//婚宴清空按钮
			function weddingEFFF(){
				$("#EweddingSelect").html("");
			}
			
			//舞台灯光插入按钮
			function deskLightEF(){
				var light=$("#EdeskLight").val().trim();
				if(light!=""){
					var option = $("<option value='"+light+"'>"+light+"</option>");
					$("#EdeskLightSelect").append(option);
					$("#EdeskLight").val("");
					$("#EdeskLight").focus();
				}
			}
			//舞台灯光移除按钮
			function deskLightEFF(){
					$("#EdeskLightSelect option:selected").remove();	
			}
			//舞台灯光清空按钮
			function deskLightEFFF(){
				$("#EdeskLightSelect").html("");
			}
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
		<div class="easyui-window" title="庆典添加" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="addForm" action="/celebration/add" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">宴会庆典信息</td>
						</tr>
						<tr>
							<td style="width: 60px">庆典名称:</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
								<input type="hidden" name="hotelid" value="${cookie.yonghuming.value}"/>
							</td>
						</tr>
						<tr>
							<td>风格:</td>
							<td>
								<input type="text" name="style" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>主题:</td>
							<td>
								<textarea name="theme" class="easyui-validatebox" required="true" style="resize: none;width:40%;height:60px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>基础套餐名:</td>
							<td>
								<input type="text" name="basename" class="easyui-validatebox" required="true" /> 
							</td>
						</tr>
						<tr>
							<td>基础套餐价:</td>
							<td>
								<input type="text" data-options="validType:'length[0,8]'" name="preprice" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>大图一:</td>
							<td>
								<input type="file" accept="image/png,image/jpeg" style="width:200px" name="uploadFile" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>大图二:</td>
							<td>
								<input type="file" accept="image/png,image/jpeg" style="width:200px" name="uploadFile" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
						<tr>
							<td>豪华套餐名:</td>
							<td>
								<input type="text" name="comboname" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>豪华套餐价:</td>
							<td>
								<input type="text" data-options="validType:'length[0,8]'" name="price" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>舞台全息价:</td>
							<td>
								<input type="text" data-options="validType:'length[0,8]'" name="stagePrice" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>		
						<tr>
							<td>迎宾区:</td>
							<td>
								<input type="text" id="welcome" onkeydown="javascript:if(event.keyCode==13) welcomeF();"/>
								<input type="button" onclick="welcomeF()" value="插入" />
								<input type="button" onclick="welcomeFF()" value="移除" />
								<input type="button" onclick="welcomeFFF()" value="清空" />
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="welcomeSelect" name="welcomes" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
						<tr>
							<td>仪式区:</td>
							<td>
								<input type="text" id="ceremony" onkeydown="javascript:if(event.keyCode==13) ceremonyF();"/>
								<input type="button" onclick="ceremonyF()" value="插入" />
								<input type="button" onclick="ceremonyFF()" value="移除" />
								<input type="button" onclick="ceremonyFFF()" value="清空" />
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="ceremonySelect" name="ceremonys" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
						<tr>
							<td>婚宴区:</td>
							<td>
								<input type="text" id="wedding" onkeydown="javascript:if(event.keyCode==13) weddingF();"/>
								<input type="button" onclick="weddingF()" value="插入" />
								<input type="button" onclick="weddingFF()" value="移除" />
								<input type="button" onclick="weddingFFF()" value="清空" />
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="weddingSelect" name="weddings" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
						<tr>
							<td>舞台灯光:</td>
							<td>
								<input type="text" id="deskLight" onkeydown="javascript:if(event.keyCode==13) deskLightF();"/>
								<input type="button" onclick="deskLightF()" value="插入" />
								<input type="button" onclick="deskLightFF()" value="移除" />
								<input type="button" onclick="deskLightFFF()" value="清空" />
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="deskLightSelect" name="deskLights" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
						<tr>
							<td>舞台全息:</td>
							<td>
								<input type="text" id="stageHolographic" onkeydown="javascript:if(event.keyCode==13) stageHolographicF();" />
								<input type="button" onclick="stageHolographicF()" value="插入" />
								<input type="button" onclick="stageHolographicFF()" value="移除" />
								<input type="button" onclick="stageHolographicFFF()" value="清空" />
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="stageHolographicSelect" name="stageHolographics" size="10" multiple="true" style="width:150px;"></select>
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

		<div class="easyui-window" title="庆典修改" id="editorWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<!--<div class="datagrid-toolbar">-->
					<a id="update" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">更改</a>
				<!--</div>-->
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="updateForm" action="/celebration/update" method="post" enctype="multipart/form-data">
					<table class="table-edit" width="80%" height="80%" align="center">
						<tr class="title">
							<td colspan="2">宴会庆典信息</td>
							<input type="hidden" name="id"/>
							<input type="hidden" name="hotelid" value="${cookie.yonghuming.value}"/>
						</tr>
						<tr>
							<td style="width: 60px">庆典名称:</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>风格:</td>
							<td>
								<input type="text" name="style" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>主题:</td>
							<td>
								<textarea name="theme" class="easyui-validatebox" required="true" style="resize: none;width:40%;height:60px" rows="20"></textarea> 
							</td>
						</tr>
						<tr>
							<td>基础套餐名:</td>
							<td>
								<input type="text" name="basename" class="easyui-validatebox" required="true" /> 
							</td>
						</tr>
						<tr>
							<td>基础套餐价:</td>
							<td>
								<input type="text" data-options="validType:'length[0,8]'" name="preprice" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>大图一:</td>
							<td>
								<input type="file" accept="image/png,image/jpeg" style="width:200px" name="uploadFile"/><span style="color: red;">*注意：两个都不选或者只选一个将使用原来的图片</span>
							</td>
						</tr>
						<tr>
							<td>大图二:</td>
							<td>
								<input type="file" accept="image/png,image/jpeg" style="width:200px" name="uploadFile"/>
							</td>
						</tr>
						<tr>
							<td>豪华套餐名:</td>
							<td>
								<input type="text" name="comboname" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>豪华套餐价:</td>
							<td>
								<input type="text" data-options="validType:'length[0,8]'" name="price" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>舞台全息价:</td>
							<td>
								<input type="text" data-options="validType:'length[0,8]'" name="stagePrice" class="easyui-validatebox easyui-numberbox" required="true" />
							</td>
						</tr>
						<tr>
							<td>迎宾区:</td>
							<td>
								<input type="text" id="Ewelcome" />
								<input type="button" onclick="welcomeEF()" value="插入" />
								<input type="button" onclick="welcomeEFF()" value="移除" />
								<input type="button" onclick="welcomeEFFF()" value="清空" />
								<input type="hidden" id="welcomeH" name="welcome" disabled="disabled"/>
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="EwelcomeSelect" name="Ewelcomes" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
						<tr>
							<td>仪式区:</td>
							<td>
								<input type="text" id="Eceremony" />
								<input type="button" onclick="ceremonyEF()" value="插入" />
								<input type="button" onclick="ceremonyEFF()" value="移除" />
								<input type="button" onclick="ceremonyEFFF()" value="清空" />
								<input type="hidden" id="ceremonyH" name="ceremony" disabled="disabled"/>
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="EceremonySelect" name="Eceremonys" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
						<tr>
							<td>婚宴区:</td>
							<td>
								<input type="text" id="Ewedding" />
								<input type="button" onclick="weddingEF()" value="插入" />
								<input type="button" onclick="weddingEFF()" value="移除" />
								<input type="button" onclick="weddingEFFF()" value="清空" />
								<input type="hidden" id="weddingH" name="weddingplace" disabled="disabled"/>
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="EweddingSelect" name="Eweddings" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
						<tr>
							<td>舞台灯光:</td>
							<td>
								<input type="text" id="EdeskLight" />
								<input type="button" onclick="deskLightEF()" value="插入" />
								<input type="button" onclick="deskLightEFF()" value="移除" />
								<input type="button" onclick="deskLightEFFF()" value="清空" />
								<input type="hidden" id="deskLightH" name="desklight" disabled="disabled"/>
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="EdeskLightSelect" name="EdeskLights" size="10" multiple="true" style="width:150px;"></select>
							</td>
						</tr>
							<tr>
							<td>舞台全息:</td>
							<td>
								<input type="text" id="EstageHolographic" />
								<input type="button" onclick="stageHolographicEF()" value="插入" />
								<input type="button" onclick="stageHolographicEFF()" value="移除" />
								<input type="button" onclick="stageHolographicEFFF()" value="清空" />
								<input type="hidden" id="stageHolographicH" name="stageHolographic" disabled="disabled"/>
							</td>
						</tr>
						<tr>
						<td></td>
							<td>
								<select id="EstageHolographicSelect" name="EstageHolographics" size="10" multiple="true" style="width:250px;"></select>
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