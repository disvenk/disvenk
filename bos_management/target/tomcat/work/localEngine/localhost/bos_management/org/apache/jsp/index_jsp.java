package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title>BOS管理系统 首页</title>\r\n");
      out.write("\t\t<link href=\"favicon.ico\" rel=\"icon\" type=\"image/x-icon\" />\r\n");
      out.write("\t\t<!-- 导入jquery核心类库 -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./js/jquery-1.8.3.js\"></script>\r\n");
      out.write("\t\t<!-- 导入easyui类库 -->\r\n");
      out.write("\t\t<link id=\"easyuiTheme\" rel=\"stylesheet\" type=\"text/css\" href=\"./js/easyui/themes/default/easyui.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"./js/easyui/themes/icon.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/default.css\">\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t\t<!-- 导入ztree类库 -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"./js/ztree/zTreeStyle.css\" type=\"text/css\" />\r\n");
      out.write("\t\t<script src=\"./js/ztree/jquery.ztree.all-3.5.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t\t<script src=\"./js/easyui/locale/easyui-lang-zh_CN.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t$(function() {\r\n");
      out.write("\t\t\t\t/** \r\n");
      out.write("\t\t\t\t   Ztree菜单通用配置 \r\n");
      out.write("\t\t\t\t*/\r\n");
      out.write("\t\t\t\tvar setting = {\r\n");
      out.write("\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\tsimpleData : { // 简单数据 \r\n");
      out.write("\t\t\t\t\t\t\tenable : true\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tcallback : {\r\n");
      out.write("\t\t\t\t\t\tonClick : onClick\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 基本功能菜单加载\r\n");
      out.write("\t\t\t\t$.post(\"./data/menu.json\",function(data){\r\n");
      out.write("\t\t\t\t\t$.fn.zTree.init($(\"#treeMenu\"), setting, data);\r\n");
      out.write("\t\t\t\t},\"json\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 系统管理菜单加载\r\n");
      out.write("\t\t\t\t$.post(\"./data/admin.json\",function(data){\r\n");
      out.write("\t\t\t\t\t$.fn.zTree.init($(\"#adminMenu\"), setting, data);\r\n");
      out.write("\t\t\t\t},\"json\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 页面加载后 右下角 弹出窗口\r\n");
      out.write("\t\t\t\twindow.setTimeout(function(){\r\n");
      out.write("\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\ttitle:\"消息提示\",\r\n");
      out.write("\t\t\t\t\t\tmsg:'欢迎登录，超级管理员！ <a href=\"javascript:void\" onclick=\"top.showAbout();\">联系管理员</a>',\r\n");
      out.write("\t\t\t\t\t\ttimeout:5000\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t},3000);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#btnCancel\").click(function(){\r\n");
      out.write("\t\t\t\t\t$('#editPwdWindow').window('close');\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#btnEp\").click(function(){\r\n");
      out.write("\t\t\t\t\talert(\"修改密码\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 设置全局变量 保存当前正在右键的tabs 标题 \r\n");
      out.write("\t\t\t\tvar currentRightTitle  ;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 为选项卡，添加右键菜单 \r\n");
      out.write("\t\t\t\t$('#tabs').tabs({\r\n");
      out.write("\t\t\t\t\tonContextMenu : function(e,title,index){\r\n");
      out.write("\t\t\t\t\t\tcurrentRightTitle = title ; \r\n");
      out.write("\t\t\t\t\t\t$('#mm').menu('show', { \r\n");
      out.write("\t\t\t\t\t\t\tleft: e.pageX,\r\n");
      out.write("\t\t\t\t\t\t\ttop: e.pageY \r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\te.preventDefault(); // 禁用原来的右键效果 \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$('#mm').menu({ \r\n");
      out.write("\t\t\t\t\tonClick:function(item){ \r\n");
      out.write("\t\t\t\t\t\tif(item.name==='Close'){\r\n");
      out.write("\t\t\t\t\t\t\t$('#tabs').tabs('close',currentRightTitle);\r\n");
      out.write("\t\t\t\t\t\t}else if(item.name === 'CloseOthers'){\r\n");
      out.write("\t\t\t\t\t\t\tvar tabs = $('#tabs').tabs('tabs');\r\n");
      out.write("\t\t\t\t\t\t\t$(tabs).each(function(){\r\n");
      out.write("\t\t\t\t\t\t\t\tif($(this).panel('options').title != '消息中心' && $(this).panel('options').title != currentRightTitle){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#tabs').tabs('close',$(this).panel('options').title);\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}else if(item.name === 'CloseAll'){\r\n");
      out.write("\t\t\t\t\t\t\tvar tabs = $('#tabs').tabs('tabs');\r\n");
      out.write("\t\t\t\t\t\t\t$(tabs).each(function(){\r\n");
      out.write("\t\t\t\t\t\t\t\tif($(this).panel('options').title != '消息中心'){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#tabs').tabs('close',$(this).panel('options').title);\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t}); \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction onClick(event, treeId, treeNode, clickFlag) {\r\n");
      out.write("\t\t\t\t// 判断树菜单节点是否含有 page属性\r\n");
      out.write("\t\t\t\tif (treeNode.page!=undefined && treeNode.page!= \"\") {\r\n");
      out.write("\t\t\t\t\tif ($(\"#tabs\").tabs('exists', treeNode.name)) {// 判断tab是否存在\r\n");
      out.write("\t\t\t\t\t\t$('#tabs').tabs('select', treeNode.name); // 切换tab\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t// 开启一个新的tab页面\r\n");
      out.write("\t\t\t\t\t\tvar content = '<div style=\"width:100%;height:100%;overflow:hidden;\">'\r\n");
      out.write("\t\t\t\t\t\t\t\t+ '<iframe src=\"'\r\n");
      out.write("\t\t\t\t\t\t\t\t+ treeNode.page\r\n");
      out.write("\t\t\t\t\t\t\t\t+ '\" scrolling=\"auto\" style=\"width:100%;height:100%;border:0;\" ></iframe></div>';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t$('#tabs').tabs('add', {\r\n");
      out.write("\t\t\t\t\t\t\ttitle : treeNode.name,\r\n");
      out.write("\t\t\t\t\t\t\tcontent : content,\r\n");
      out.write("\t\t\t\t\t\t\tclosable : true,\r\n");
      out.write("\t\t\t\t\t\t\ttools:[{ \r\n");
      out.write("\t\t\t\t\t\t\t\ticonCls:'icon-reload', // 刷新按钮\r\n");
      out.write("\t\t\t\t\t\t\t\thandler : function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar tab = $('#tabs').tabs('getTab',treeNode.name);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"iframe[src='\"+treeNode.page+\"']\").get(0).contentWindow.location.reload(true);\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}] \r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t/*******顶部特效 *******/\r\n");
      out.write("\t\t\t/**\r\n");
      out.write("\t\t\t * 更换EasyUI主题的方法\r\n");
      out.write("\t\t\t * @param themeName\r\n");
      out.write("\t\t\t * 主题名称\r\n");
      out.write("\t\t\t */\r\n");
      out.write("\t\t\tchangeTheme = function(themeName) {\r\n");
      out.write("\t\t\t\tvar $easyuiTheme = $('#easyuiTheme');\r\n");
      out.write("\t\t\t\tvar url = $easyuiTheme.attr('href');\r\n");
      out.write("\t\t\t\tvar href = url.substring(0, url.indexOf('themes')) + 'themes/'\r\n");
      out.write("\t\t\t\t\t\t+ themeName + '/easyui.css';\r\n");
      out.write("\t\t\t\t$easyuiTheme.attr('href', href);\r\n");
      out.write("\t\t\t\tvar $iframe = $('iframe');\r\n");
      out.write("\t\t\t\tif ($iframe.length > 0) {\r\n");
      out.write("\t\t\t\t\tfor ( var i = 0; i < $iframe.length; i++) {\r\n");
      out.write("\t\t\t\t\t\tvar ifr = $iframe[i];\r\n");
      out.write("\t\t\t\t\t\t$(ifr).contents().find('#easyuiTheme').attr('href', href);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t// 退出登录\r\n");
      out.write("\t\t\tfunction logoutFun() {\r\n");
      out.write("\t\t\t\t$.messager\r\n");
      out.write("\t\t\t\t.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {\r\n");
      out.write("\t\t\t\t\tif (isConfirm) {\r\n");
      out.write("\t\t\t\t\t\tlocation.href = './login.html';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t// 修改密码\r\n");
      out.write("\t\t\tfunction editPassword() {\r\n");
      out.write("\t\t\t\t$('#editPwdWindow').window('open');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t// 版权信息\r\n");
      out.write("\t\t\tfunction showAbout(){\r\n");
      out.write("\t\t\t\t$.messager.alert(\"bos v2.0综合物流管理平台\",\"设计: 传智播客<br/> 管理员邮箱: itcast_search@163.com <br/>\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body class=\"easyui-layout\">\r\n");
      out.write("\t\t<div data-options=\"region:'north',border:false\" style=\"height:70px;padding:10px;\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<img src=\"./images/logo.png\" border=\"0\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"sessionInfoDiv\" style=\"position: absolute;right: 5px;top:10px;\">\r\n");
      out.write("\t\t\t\t[<strong>超级管理员</strong>]，欢迎你！您使用[<strong>192.168.1.100</strong>]IP登录！\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"position: absolute; right: 5px; bottom: 10px; \">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0);\" class=\"easyui-menubutton\" data-options=\"menu:'#layout_north_pfMenu',iconCls:'icon-ok'\">更换皮肤</a>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0);\" class=\"easyui-menubutton\" data-options=\"menu:'#layout_north_kzmbMenu',iconCls:'icon-help'\">控制面板</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"layout_north_pfMenu\" style=\"width: 120px; display: none;\">\r\n");
      out.write("\t\t\t\t<div onclick=\"changeTheme('default');\">default</div>\r\n");
      out.write("\t\t\t\t<div onclick=\"changeTheme('gray');\">gray</div>\r\n");
      out.write("\t\t\t\t<div onclick=\"changeTheme('black');\">black</div>\r\n");
      out.write("\t\t\t\t<div onclick=\"changeTheme('bootstrap');\">bootstrap</div>\r\n");
      out.write("\t\t\t\t<div onclick=\"changeTheme('metro');\">metro</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"layout_north_kzmbMenu\" style=\"width: 100px; display: none;\">\r\n");
      out.write("\t\t\t\t<div onclick=\"editPassword();\">修改密码</div>\r\n");
      out.write("\t\t\t\t<div onclick=\"showAbout();\">联系管理员</div>\r\n");
      out.write("\t\t\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t\t\t<div onclick=\"logoutFun();\">退出系统</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'west',split:true,title:'菜单导航'\" style=\"width:200px\">\r\n");
      out.write("\t\t\t<div class=\"easyui-accordion\" fit=\"true\" border=\"false\">\r\n");
      out.write("\t\t\t\t<div title=\"基本功能\" data-options=\"iconCls:'icon-mini-add'\" style=\"overflow:auto\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"treeMenu\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div title=\"系统管理\" data-options=\"iconCls:'icon-mini-add'\" style=\"overflow:auto\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"adminMenu\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'center'\">\r\n");
      out.write("\t\t\t<div id=\"tabs\" fit=\"true\" class=\"easyui-tabs\" border=\"false\">\r\n");
      out.write("\t\t\t\t<div title=\"消息中心\" id=\"subWarp\" style=\"width:100%;height:100%;overflow:hidden\">\r\n");
      out.write("\t\t\t\t\t<iframe src=\"./home.html\" style=\"width:100%;height:100%;border:0;\"></iframe>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'south',border:false\" style=\"height:50px;padding:10px;\">\r\n");
      out.write("\t\t\t<table style=\"width: 100%;\">\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 400px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div style=\"color: #999; font-size: 8pt;\">\r\n");
      out.write("\t\t\t\t\t\t\t\tBOSv2.0综合物流管理平台 | Powered by <a href=\"http://www.itcast.cn/\">传智播客</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: *;\" class=\"co1\"><span id=\"online\" style=\"background: url(./images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:8pt;color:#005590;\">在线人数:1</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!--修改密码窗口-->\r\n");
      out.write("\t\t<div id=\"editPwdWindow\" class=\"easyui-window\" title=\"修改密码\" collapsible=\"false\" minimizable=\"false\" modal=\"true\" closed=\"true\" resizable=\"false\" maximizable=\"false\" icon=\"icon-save\" style=\"width: 300px; height: 160px; padding: 5px;\r\n");
      out.write("        background: #fafafa\">\r\n");
      out.write("\t\t\t<div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t\t\t\t<div region=\"center\" border=\"false\" style=\"padding: 10px; background: #fff; border: 1px solid #ccc;\">\r\n");
      out.write("\t\t\t\t\t<table cellpadding=3>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>新密码：</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"txtNewPass\" type=\"Password\" class=\"txt01\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>确认密码：</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"txtRePass\" type=\"Password\" class=\"txt01\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div region=\"south\" border=\"false\" style=\"text-align: right; height: 30px; line-height: 30px;\">\r\n");
      out.write("\t\t\t\t\t<a id=\"btnEp\" class=\"easyui-linkbutton\" icon=\"icon-ok\" href=\"javascript:void(0)\">确定</a>\r\n");
      out.write("\t\t\t\t\t<a id=\"btnCancel\" class=\"easyui-linkbutton\" icon=\"icon-cancel\" href=\"javascript:void(0)\">取消</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"mm\" class=\"easyui-menu\" style=\"width:120px;\">\r\n");
      out.write("\t\t\t<div data-options=\"name:'Close'\">关闭当前窗口</div>\r\n");
      out.write("\t\t\t<div data-options=\"name:'CloseOthers'\">关闭其它窗口</div>\r\n");
      out.write("\t\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t\t<div data-options=\"iconCls:'icon-cancel',name:'CloseAll'\">关闭全部窗口</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
