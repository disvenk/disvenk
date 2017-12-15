<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

</head>
<body>
<div style="padding:10px;">
	<table class="easyui-datagrid" id="itemList" style="height:auto;overflow:auto" data-options="singleSelect:false,collapsible:true,url:'/pay/orderAlert',method:'post',toolbar:toolbar">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'status',align:'center'">状态</th>
				<th data-options="field:'oid',align:'center'">订单号</th>
				<th data-options="field:'customerName',align:'center'">客户姓名</th>
				<th data-options="field:'tel',align:'center'">联系方式</th>
				<th data-options="field:'payed',align:'center',formatter:TAOTAO.formatDateTime">付款时间</th>
				<th data-options="field:'checked',align:'center'">状态</th>
			</tr>
		</thead>
	</table>
</div>
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

var TT = TAOTAO = {
		// 格式化时间
		formatDateTime : function(val,row){
			var now = new Date(val);
	    	return now.format("yyyy-MM-dd hh:mm:ss");
		}
}

function getSelectionsIds(){
	var itemList = $("#itemList");
	var sels = itemList.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}

var toolbar = [{
    text:'确认已查看',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','必须选择一个订单才能确认!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个订单!');
    		return ;
    	}
    	$.messager.defaults = { ok: "是", cancel: "否" };
    	$.messager.confirm("确认提示","确认后您将不在看到这条订单记录,只能在订单管理中查看,是否确认?", function(r){
    		if(r){
    			$.post("/editor/checked",{ids:ids},function(data){
    				if(data.status==200){
    					location.href="/pages/base/home";
    				}else{
    					$.messager.alert('提示','确认失败!');
    				}
    			})
    		}
    	})
    }
    }]
</script>
 </body>
</html>