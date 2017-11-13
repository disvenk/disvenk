<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta charset="UTF-8">
	<title>酒店信息设置</title>
	<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="/css/taotao.css" />
	<link rel="stylesheet" type="text/css" href="/css/uploadify.css" />
	<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/js/easyui/ext/jquery.cookie.js"></script>
	<script type="text/javascript" src="/js/jquery.uploadify.js"></script>
	<script type="text/javascript" src="/js/lang.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<script>
	function returnList(){
		$.cookie("plannerId", null,{path:'/'});
		$.cookie("plannerImg",null,{path:'/'});
		location.href="/pages/base/plannerInfo";
	}
		$(function(){
			
			// 先将body隐藏，再显示，不会出现页面刷新效果
			$("body").css({visibility:"visible"});
			 $('#projectfile').uploadify({
				    'auto'	   : true,
				 	'multi'    : true,
	                'swf'      : '/js/uploadify.swf',  
	                'uploader' : '/media/upload?token=plannerId',  
	                //'formData': {'projectid': '${project.id}'},  
	                'fileObjName' : 'uploadFile',  
	                'fileSizeLimit' : '0',
	                'fileTypeExts': '*.mp4',
	                'removeTimeout' : 0,  //上传后的提示在几秒后消失
	                'onUploadSuccess':function(file, data, response){ //上传成功后执行的操作函数
                        alert(data);
                 }
	       });
			 
			 var img = $.cookie("plannerImg");
			 $("#plannerImg").attr('src',unescape(img));
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
	            <td style="line-height: 52px">
	            <img id="plannerImg" src=""/>
	            <h5 style="color: red;margin: 0;padding: 0;">提示:只支持MP4格式,上传成功时进度显示为'上传成功'*</h5>
	                 <input id="projectfile" type="file" name="goods_video">
	            </td>
	        </tr>
	    </table>
	</form>
</div>
</body>
</html>
