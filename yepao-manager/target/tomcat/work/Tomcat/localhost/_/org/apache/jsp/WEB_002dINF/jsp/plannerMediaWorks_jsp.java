/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-11-10 11:08:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class plannerMediaWorks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("\t\t<title>策划师视频作品</title>\r\n");
      out.write("\t\t<!-- 导入jquery核心类库 -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("\t\t<!-- 导入ocupload -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/ocupload/jquery.ocupload-1.1.2.js\" ></script>\r\n");
      out.write("\t\t<!-- 导入easyui类库 -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/default/easyui.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/icon.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/ext/portal.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/default.css\">\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/easyui/ext/jquery.portal.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/easyui/ext/jquery.cookie.js\"></script>\r\n");
      out.write("\t\t<script src=\"/js/easyui/locale/easyui-lang-zh_CN.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tDate.prototype.format = function(format){ \r\n");
      out.write("\t\t    var o =  { \r\n");
      out.write("\t\t    \"M+\" : this.getMonth()+1, //month \r\n");
      out.write("\t\t    \"d+\" : this.getDate(), //day \r\n");
      out.write("\t\t    \"h+\" : this.getHours(), //hour \r\n");
      out.write("\t\t    \"m+\" : this.getMinutes(), //minute \r\n");
      out.write("\t\t    \"s+\" : this.getSeconds(), //second \r\n");
      out.write("\t\t    \"q+\" : Math.floor((this.getMonth()+3)/3), //quarter \r\n");
      out.write("\t\t    \"S\" : this.getMilliseconds() //millisecond \r\n");
      out.write("\t\t    };\r\n");
      out.write("\t\t    if(/(y+)/.test(format)){ \r\n");
      out.write("\t\t    \tformat = format.replace(RegExp.$1, (this.getFullYear()+\"\").substr(4 - RegExp.$1.length)); \r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    for(var k in o)  { \r\n");
      out.write("\t\t\t    if(new RegExp(\"(\"+ k +\")\").test(format)){ \r\n");
      out.write("\t\t\t    \tformat = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : (\"00\"+ o[k]).substr((\"\"+ o[k]).length)); \r\n");
      out.write("\t\t\t    } \r\n");
      out.write("\t\t    } \r\n");
      out.write("\t\t    return format; \r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tfunction backList(){\r\n");
      out.write("        \t\t$.cookie(\"checkPlannerId\", null,{path:'/'});\r\n");
      out.write("        \t\tlocation.href=\"/pages/base/plannerInfo\";\r\n");
      out.write("        \t}\r\n");
      out.write("        \r\n");
      out.write("\t\t\tfunction doDelete(){\r\n");
      out.write("\t\t\t\tvar rows = $(\"#grid\").datagrid('getSelections');\r\n");
      out.write("\t\t\t\tif(rows.length == 0){\r\n");
      out.write("\t\t\t\t\t// 没选  \r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示信息\",\"请选择您要删除的行\",\"warning\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tvar arr = new Array();\r\n");
      out.write("\t\t\t\t\tfor(var i=0;i<rows.length;i++){\r\n");
      out.write("\t\t\t\t\t\tarr.push(rows[i].id);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t//生成字符串\r\n");
      out.write("\t\t\t\t\tvar ids = arr.join(\",\");\r\n");
      out.write("\t\t\t\t\twindow.location.href = \"/talentMediaWorks/delete?talent=plannerMedia&ids=\"+ids;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//工具栏\r\n");
      out.write("\t\t\tvar toolbar = [{\r\n");
      out.write("\t\t\t\tid : 'button-delete',\r\n");
      out.write("\t\t\t\ttext : '删除',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-cancel',\r\n");
      out.write("\t\t\t\thandler : doDelete\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tid : 'button-delete',\r\n");
      out.write("\t\t\t\ttext : '返回策划师列表',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-back',\r\n");
      out.write("\t\t\t\thandler : backList\r\n");
      out.write("\t\t\t}];\r\n");
      out.write("\t\t\t// 定义列\r\n");
      out.write("\t\t\tvar columns = [ [ {\r\n");
      out.write("\t\t\t\tfield : 'id',\r\n");
      out.write("\t\t\t\tcheckbox : true,\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'talentName',\r\n");
      out.write("\t\t\t\ttitle : '姓名',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'vediosrc',\r\n");
      out.write("\t\t\t\ttitle : '视频作品',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\tformatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\treturn \"<video src='\"+value+\"' width='100' height='100' controls='controls'/>\";//在这个区域直接显示出图片\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'uptime',\r\n");
      out.write("\t\t\t\ttitle : '创建时间',\r\n");
      out.write("\t\t\t\twidth : 200,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\t formatter: function (value,row,index) {\r\n");
      out.write("\t\t\t\t\t var now = new Date(value);\r\n");
      out.write("\t\t\t\t    \treturn now.format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("                 }\r\n");
      out.write("\t\t\t}] ];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(function(){\r\n");
      out.write("\t\t\t\t// 先将body隐藏，再显示，不会出现页面刷新效果\r\n");
      out.write("\t\t\t\t$(\"body\").css({visibility:\"visible\"});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 酒店管理数据表格\r\n");
      out.write("\t\t\t\t$('#grid').datagrid( {\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-forward',\r\n");
      out.write("\t\t\t\t\tfit : true,\r\n");
      out.write("\t\t\t\t\t//fitColumns:true,\r\n");
      out.write("\t\t\t\t\tborder : false,\r\n");
      out.write("\t\t\t\t\trownumbers : true,\r\n");
      out.write("\t\t\t\t\tstriped : true,\r\n");
      out.write("\t\t\t\t\tpageList: [30,50,100],\r\n");
      out.write("\t\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\t\ttoolbar : toolbar,\r\n");
      out.write("\t\t\t\t\turl : \"/media_pageQuery?name=策划师&id=\"+$.cookie(\"checkPlannerId\"),\r\n");
      out.write("\t\t\t\t\tidField : 'id',//这里的字段一定与表格里的id字段对应\r\n");
      out.write("\t\t\t\t\tcolumns : columns\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body class=\"easyui-layout\" style=\"visibility:hidden;\">\r\n");
      out.write("\t\t<div region=\"center\" border=\"false\">\r\n");
      out.write("\t\t\t<table id=\"grid\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
