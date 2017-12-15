<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta charset="UTF-8">
	<title>添加宴会厅</title>
	<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="/css/taotao.css" />
	<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/js/easyui/ext/jquery.cookie.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<script>
	function returnList(){
		location.href="/pages/base/hall";
	}
		$(function(){
			// 先将body隐藏，再显示，不会出现页面刷新效果
			$("body").css({visibility:"visible"});
		
		});
	</script>
	</head>
<body style="visibility:hidden;">
<div style="padding:10px 10px 10px 10px">
<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="back" icon="icon-back" href="javascript:returnList()" class="easyui-linkbutton" plain="true">返回列表</a>
			</div>
		</div>
	<form id="hallAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	    <tr>
			<td>酒店名称</td>
			<td>
				 <input type="text" id="operatingId" name="hotelid" class="easyui-combobox" data-options="required:true,valueField:'hotelId',textField:'name',url:'/hotel_pageQuery'"/> 
				
			</td>
		</tr>
	        <tr>
	            <td>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</td>
	            <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;层:</td>
	            <td><input class="easyui-textbox" type="text" name="floorNum" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>桌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:</td>
	            <td><input class="easyui-textbox" type="text" name="tableNum" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>层&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高:</td>
	            <td><input class="easyui-numberbox" type="text" name="floorHeight" data-options="required:true" style="width: 280px;"/> </td>
	        </tr>
	        <tr>
	            <td>面&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;积:</td>
	            <td><input class="easyui-numberbox" type="text" name="area" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	        <tr>
	            <td>最大桌数:</td>
	            <td><input class="easyui-textbox" type="text" name="minTable" data-options="required:true" /></td>
	        </tr>
	        <tr>
	            <td>最大桌数:</td>
	            <td><input class="easyui-textbox" type="text" name="maxTable" data-options="required:true" /></td>
	        </tr>
	        <tr>
	            <td>图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</td>
	            <td style="line-height: 52px">
	            	 <a style="margin-top: 15px;" href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" id="image" name="img"/>
	            </td>
	        </tr>
	         <tr>
	            <td>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
	            <td><textarea name="standby" style="resize: none;height: 80px" rows="20"></textarea></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		$('#operatingId').combobox({    
		    onLoadSuccess : function() {  
		       // $("#operatingId").combobox("select", "CMCC");  
		        $("#operatingId").combobox("setValue", "-请选择-");  
		    }  
		});
		//创建富文本编辑器,在商品描述那个文本域中添加一个富文本编辑器
		//itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		//初始化类目选择和图片上传器，这里就会加载init属性只想属性里面的方法，在间接的执行了其他的属性里的方法，比如商品类目和图片上传
		YEPAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#hallAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return;
		}
		
		var hotelName=$("#operatingId").combobox('getValue');
		if(hotelName=="-请选择-"){
			
			$.messager.alert("警告","请选择酒店名称","warning");
			return;
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
