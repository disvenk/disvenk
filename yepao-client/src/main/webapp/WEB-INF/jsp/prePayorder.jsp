<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>未付款订单信息</title>
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
		
        $(function(){
        	/*js对有条件查询定区的设置-start*/
			$('#searchWindow').window({
		        title: '查询订单',
		        width: 400,
		        modal: true,
		        shadow: true,
		        closed: true,
		        height: 200,
		        resizable:false
		   });
		   /*js对有条件查询定区的设置-end*/
        });
        
        /*订单有条件查询的方法-start*/
		function doSearch(){
			$('#searchWindow').window("open");
			 $("#searchBtn").click(function(){
				var params = $("#searchForm").serializeJson() ;
				// 将json对象 绑定datagrid上，完成带有条件 查询请求 
				//这里是将查询form表单的数据绑定到快递员表格当中，然后表单具有自动提交向后台按此条件查询的功能
				$("#grid").datagrid('load',params); 
				// 关闭查询窗口 
				$("#searchWindow").window('close');
			});
		}
		/*订单有条件查询的方法-end*/
	
			function doEdit(){
				// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length == 0){
					// 没选 或 多选 
					$.messager.alert("提示信息","请选择您要标记的订单","warning");
				}else if(rows.length != 1){
					// 没选 或 多选 
					$.messager.alert("提示信息","标记支付状态是时，只能选中一行","warning")
				}else{
					
					$.messager.confirm("提示信息","是否确认标记",function(r){
						if(r){
							// 只选中一行 
							var row = rows[0]; 
							$.post("/signOrderPREtoP",{id:row.id},function(data){
								if(data.status==200){
									location.href="/pages/base/prePayorder"
								}
							})
							
						}
					});
					
				}
			}
		
			var toolbar = [ {
				id : 'button-search',	
				text : '查询',
				iconCls : 'icon-search',
				handler : doSearch
			},{
				id : 'button-edit',	
				text : '标记为已付全款',
				iconCls : 'icon-edit',
				handler : doEdit
			}];
		
			// 定义列
			var columns = [ [ {
				field : 'id',
				checkbox : true,
			},{
				field : 'customerName',
				title : '客户姓名',
				width : 120,
				align : 'center'
			},{
				field : 'tel',
				title : '联系方式',
				width : 120,
				align : 'center'
			},{
				field : 'gender',
				title : '称谓',
				width : 120,
				align : 'center'
			},{
				field : 'reservedDate',
				title : '预定日期',
				width : 120,
				align : 'center',
				 formatter: function (value,row,index) {
					 
					 var now = new Date(value);
				    	return now.format("yyyy-MM-dd");
                 }
			},{
				field : 'hall',
				title : '宴会大厅',
				width : 120,
				align : 'center' ,
				formatter: function (value,row,index) {
					if(value!="" && value!=null && value!=undefined){
					var val=eval(value);
					return val[0].itemName[0].name+"x"+val[0].num+"桌";
					}
					return "";
				}  
			}, {
				field : 'combo',
				title : '菜品',
				width : 120,
				align : 'center',
				formatter: function (value,row,index) {
					if(value!="" && value!=null && value!=undefined){
					var val=eval(value);
					return val[0].itemName[0].name+"x"+val[0].num+"桌";
					}
					return "";
				}  
			},{
				field : 'celebration',
				title : '宴会庆典',
				width : 120,
				align : 'center',
				formatter: function (value,row,index) {
					 if(value!="" && value!=null && value!=undefined){
					var val=eval(value);
					var str=val[0].itemName[0].name+"</br>"+"("+val[0].comboName+")";
					if(val[0].stage){
						str=str.concat("</br>"+"含舞台全息");
					}else{
						str=str.concat("</br>"+"不含舞台全息");
					}
					return str;
					}
					return ""; 
				}  
			},{
				field : 'talent',
				title : '婚礼人才',
				width : 120,
				align : 'center',
				formatter: function (value,row,index) {
					if(value!="" && value!=null && value!=undefined){
					var val=eval(value);
					var str="";
					for(var index in val){
						str=str.concat(val[index].occupation+"-"+val[index].name+"</br>")
					}
					return str;
					}
					return "";
				}  
			},{
				field : 'prepay',
				title : '定金',
				width : 120,
				align : 'center'
			},{
				field : 'obligation',
				title : '待付尾款',
				width : 120,
				align : 'center'
			},{
				field : 'count',
				title : '总金额',
				width : 120,
				align : 'center'
			},{
				field : 'status',
				title : '状态',
				width : 120,
				align : 'center'
			},{
				field : 'created',
				title : '订单创建时间',
				width : 200,
				align : 'center',
				 formatter: function (value,row,index) {
					 var now = new Date(value);
				    	return now.format("yyyy-MM-dd hh:mm:ss");
                 }
			},{
				field : 'prepayed',
				title : '付定金时间',
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
					//fitColumns:true,
					border : false,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : toolbar,
					url : "/prePayOrder?hotelId="+$.cookie("yonghuming"),
					idField : 'id',//这里的字段一定与表格里的id字段对应
					columns : columns
				});
				
			});
			
		
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
		
		<div class="easyui-window" title="查询定区窗口" id="searchWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div style="overflow:auto;padding:5px;" border="false">
				<form id="searchForm">
					<table class="table-edit" width="80%" align="center">
						<tr class="title">
							<td colspan="2">查询条件</td>
						</tr>
						<tr>
							<td>8位数验证码</td>
							<td>
								<input type="text" name="vaidateCode" class="easyui-validatebox" />
							</td>
						</tr>
						<tr>
							<td>订单号</td>
							<td>
								<input type="text" name="id" class="easyui-validatebox" />
							</td>
						</tr>
						<tr>
							<td colspan="2"><a id="searchBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>

</html>