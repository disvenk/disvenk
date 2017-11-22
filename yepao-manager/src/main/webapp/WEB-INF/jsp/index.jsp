<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理系统 首页</title>
		<!-- <link href="" rel="icon" type="image/x-icon" /> -->
		<!-- 导入jquery核心类库 -->
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
		<script type="text/javascript" src='/js/layer.js'></script>
		<!-- 导入easyui类库 -->
		<link id="easyuiTheme" rel="stylesheet" type="text/css" href="/js/easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
		<link href="/images/icon.ico" rel="icon" type="image/x-icon" />
		<!-- <link rel="stylesheet" type="text/css" href="/css/default.css"> -->
		<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
		<!-- 导入ztree类库 -->
		<link rel="stylesheet" href="/js/ztree/zTreeStyle.css" type="text/css" />
		<script src="/js/ztree/jquery.ztree.all-3.5.js" type="text/javascript"></script>
		<script src="/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="/js/easyui/ext/jquery.cookie.js"></script>
		<script type="text/javascript">
		var ws = null;
			$(function() {
				
				var basePath = "ws://localhost:9001/";
			    if ('WebSocket' in window) {
			         ws = new WebSocket('ws://localhost:9001/webSocketServer'); 
			         console.log("连接成功");
			    }
			    else if ('MozWebSocket' in window) {
			        ws = new MozWebSocket("ws://localhost:9001/webSocketServer");
			    }
			    else {
			        ws = new SockJS("ws://localhost:9001/webSocketServer");
			    }
			    ws.onopen = function () {

			    };
			    ws.onmessage = function (event) {
			    	 pop(event.data);
			    };
			    ws.onclose = function (event) {
			    	 ws.close();
			    };
				
				
				var userName=unescape($.cookie("userName"));
				$("#userToken").html(userName);
			
				/** 
				   Ztree菜单通用配置 
				*/
				var setting = {
					data : {
						simpleData : { // 简单数据 
							enable : true//支持json数据
						}
					},
					callback : {
						onClick : onClick//对应下面的唯一的标记
					}
				};
				
				
				
				// 基本功能折叠板下面的菜单加载
				$.post("/data/menu",function(data){
					console.log(data);
					$.fn.zTree.init($("#treeMenu"), setting, data);
				},"json");
				
				
				// 页面加载后 右下角 弹出窗口
				window.setTimeout(function(){
					$.messager.show({
						title:"消息提示",
						msg:'欢迎登录，'+userName+'！ <a href="javascript:void" onclick="top.showAbout();">联系管理员</a>',
						timeout:5000
					});
				},3000);
				
				//修改密码的窗口
				$("#btnCancel").click(function(){
					$('#editPwdWindow').window('close');
				});
				
				
				// 设置全局变量 保存当前正在右键的tabs 标题 
				var currentRightTitle  ;
				
				// 为选项卡，添加右键菜单 
				$('#tabs').tabs({
					onContextMenu : function(e,title,index){
						currentRightTitle = title ; 
						$('#mm').menu('show', { 
							left: e.pageX,
							top: e.pageY 
						});
						e.preventDefault(); // 禁用原来的右键效果 
					}
				});
				
				//这里控制的在选项卡上面点右键的时候，显示关闭菜单
				$('#mm').menu({ 
					onClick:function(item){ 
						if(item.name==='Close'){
							$('#tabs').tabs('close',currentRightTitle);
						}else if(item.name === 'CloseOthers'){
							var tabs = $('#tabs').tabs('tabs');
							$(tabs).each(function(){
								if($(this).panel('options').title != '消息中心' && $(this).panel('options').title != currentRightTitle){
									$('#tabs').tabs('close',$(this).panel('options').title);
								}
							});
						}else if(item.name === 'CloseAll'){
							var tabs = $('#tabs').tabs('tabs');
							$(tabs).each(function(){
								if($(this).panel('options').title != '消息中心'){
									$('#tabs').tabs('close',$(this).panel('options').title);
								}
							});
						}
					} 
				}); 
				
				var contents = '<div style="width:100%;height:100%;overflow:hidden;">'
					+ '<iframe src="'
					+ "/pages/base/home"
					+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
				
				$('#tabs').tabs('add', {
					title : "消息中心",
					content : contents,
					closable : false,
					tools:[{ 
						iconCls:'icon-reload', // 刷新按钮
						handler : function(){
							var tab = $('#tabs').tabs('getTab',"消息中心");
							$("iframe[src='"+"/pages/base/home"+"']").get(0).contentWindow.location.reload(true);
						}
					}] 
				});
			});
			
			
			//这里是控制选型卡面板的添加和切换，对应着setting里面的onclick
			function onClick(event, treeId, treeNode, clickFlag) {
				// 判断树菜单节点是否含有 page属性
				if (treeNode.page!=undefined && treeNode.page!= "") {
					if ($("#tabs").tabs('exists', treeNode.name)) {// 判断tab是否存在
						$('#tabs').tabs('select', treeNode.name); // 切换tab
					} else {
						// 开启一个新的tab页面
						var content = '<div style="width:100%;height:100%;overflow:hidden;">'
								+ '<iframe src="'
								//+"/pages/base/hotelInfo"
								+ treeNode.page
								+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
		
						$('#tabs').tabs('add', {
							title : treeNode.name,
							content : content,
							closable : true,
							tools:[{ 
								iconCls:'icon-reload', // 刷新按钮
								handler : function(){
									var tab = $('#tabs').tabs('getTab',treeNode.name);
									$("iframe[src='"+treeNode.page+"']").get(0).contentWindow.location.reload(true);
								}
							}] 
						});
					}
				}
			}
		
			/*******顶部特效 *******/
			/**
			 * 更换EasyUI主题的方法
			 * @param themeName
			 * 主题名称
			 */
			changeTheme = function(themeName) {
				var $easyuiTheme = $('#easyuiTheme');
				var url = $easyuiTheme.attr('href');
				var href = url.substring(0, url.indexOf('themes')) + 'themes/'
						+ themeName + '/easyui.css';
				$easyuiTheme.attr('href', href);
				var $iframe = $('iframe');
				if ($iframe.length > 0) {
					for ( var i = 0; i < $iframe.length; i++) {
						var ifr = $iframe[i];
						$(ifr).contents().find('#easyuiTheme').attr('href', href);
					}
				}
			};
			// 退出登录
			function logoutFun() {
				$.messager
				.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {
					if (isConfirm) {
						location.href = '/logout';
					}
				});
			}
			// 修改密码
			function editPassword() {
				$("#editorForm").form("reset");
				$("#alert").html("");
				$('#editPwdWindow').window('open');
			}
			// 版权信息
			function showAbout(){
				$.messager.alert("酒店后台管理平台","设计: 苏州也跑信息科技发展有限公司<br/> 管理员邮箱: 13477058114@163.com <br/>设计者联系方式：13477058114");
			}
			
			function editorPass() {
				if ($("#txtNewPass").val() == "") {
					//alert("密码不能为空");
					$("#alert").html("新密码不能为空");
					$("#password").focus();
					return false;
				}
				if ($("#txtRePass").val() == "") {
					//alert("确认密码不能为空");
					$("#alert").html("确认密码不能为空")
					$("#inputaccount").focus();
					return false;
				}
				
				if($("#txtNewPass").val()!=$("#txtRePass").val()){
					$("#alert").html("两次密码不一致")
					return false;
				}
				
				$.post("/editorPass", $("#editorForm").serialize(),function(data){
					if(data.status==200){
						alert("密码修改成功")
						location.href = "http://localhost:9001/pages/base/login";
					}else{
					    alert("密码修改失败，请重试");	
					}	
					});
				};
			
				
				function pop(message){
					speckText();
				    layer.alert("您有新的订单，请及时处理");
				    //提示消息后加载订单
				    $("iframe[src='"+"/pages/base/home"+"']").get(0).contentWindow.location.reload(true);
				}

				function speckText(){

				var url ="/js/notify.mp3";

				var n = new Audio(url);

				 n.src = url;

				 n.play();

				}
		</script>
	</head>

	<body class="easyui-layout">
		<div data-options="region:'north',border:false" style="height:70px;padding:10px;">
			<div>
				<img src="/images/index.png" border="0">
			</div>
			<div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">
				[<strong id="userToken"></strong>]，欢迎你！您使用[<strong><%=request.getRemoteAddr()%></strong>]IP登录！
			</div>
			<div style="position: absolute; right: 5px; bottom: 10px; ">
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
			</div>
			<div id="layout_north_pfMenu" style="width: 120px; display: none;">
				<div onclick="changeTheme('default');">default</div>
				<div onclick="changeTheme('gray');">gray</div>
				<div onclick="changeTheme('black');">black</div>
				<div onclick="changeTheme('bootstrap');">bootstrap</div>
				<div onclick="changeTheme('metro');">metro</div>
			</div>
			<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
				<div onclick="editPassword();">修改密码</div>
				<div onclick="showAbout();">联系管理员</div>
				<div class="menu-sep"></div>
				<div onclick="logoutFun();">退出系统</div>
			</div>
		</div>
		<div data-options="region:'west',split:true,title:'菜单导航'" style="width:200px">
			<div class="easyui-accordion" fit="true" border="true">
				<div title="基本功能" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
					<ul id="treeMenu" class="ztree"></ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center'">
			<div id="tabs" fit="true" class="easyui-tabs" border="false">
			</div>
		</div>
		<div data-options="region:'south',border:false" style="height:50px;padding:10px;">
			<table style="width: 100%;">
				<tbody>
					<tr>
						<td style="width: 400px;">
							<div style="color: #999; font-size: 8pt;">
								酒店后台管理平台 | Powered by <a href="http://www.china.cn/">苏州也跑</a>
							</div>
						</td>
						<td style="width: *;" class="co1"><span id="online" style="background: url(./images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:8pt;color:#005590;">在线人数:1</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!--修改密码窗口-->
		<div id="editPwdWindow" class="easyui-window" title="修改密码" collapsible="false" minimizable="false" modal="true" closed="true" resizable="false" maximizable="false" icon="icon-save" style="width: 300px; height: 160px; padding: 5px;
        background: #fafafa">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
					<form id="editorForm">
					<table cellpadding=3>
						<tr>
							<td>新密码：</td>
							<td>
								<input type="hidden" name="userId" value="${cookie.userId.value}"/>
								<input id="txtNewPass" name="newPass" type="Password" class="txt01" />
							</td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td>
								<input id="txtRePass" name="comfirmPass" type="Password" class="txt01" />
							</td>
						</tr>
					</table>
					</form>
				</div>
				<div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
				<h5 id="alert" style="display: inline;color: red;"></h5>
					<a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:editorPass()">确定</a>
					<a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
				</div>
			</div>
		</div>

		<!--这里的代码是在选项卡面板之后要显示的关闭菜单及选项-->
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div data-options="name:'Close'">关闭当前窗口</div>
			<div data-options="name:'CloseOthers'">关闭其它窗口</div>
			<div class="menu-sep"></div>
			<div data-options="iconCls:'icon-cancel',name:'CloseAll'">关闭全部窗口</div>
		</div>

	</body>

</html>