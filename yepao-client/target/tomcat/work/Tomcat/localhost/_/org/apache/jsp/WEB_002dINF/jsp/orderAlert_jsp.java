/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-12-06 12:11:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class orderAlert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<!-- 导入jquery核心类库 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("<!-- 导入ocupload -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/ocupload/jquery.ocupload-1.1.2.js\" ></script>\r\n");
      out.write("<!-- 导入easyui类库 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/bootstrap/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/ext/portal.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/default.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/easyui/ext/jquery.portal.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/easyui/ext/jquery.cookie.js\"></script>\r\n");
      out.write("<script src=\"/js/easyui/locale/easyui-lang-zh_CN.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div style=\"padding:10px;\">\r\n");
      out.write("\t<table class=\"easyui-datagrid\" id=\"itemList\" style=\"height:auto;overflow:auto\" data-options=\"singleSelect:false,collapsible:true,url:'/pay/orderAlert',method:'post',toolbar:toolbar\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'id',checkbox:true\"></th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'status',align:'center'\">状态</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'oid',align:'center'\">订单号</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'customerName',align:'center'\">客户姓名</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'gender',align:'center'\">称谓</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'tel',align:'center'\">联系方式</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'payed',align:'center',formatter:TAOTAO.formatDateTime\">付款时间</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'checked',align:'center'\">状态</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("Date.prototype.format = function(format){ \r\n");
      out.write("    var o =  { \r\n");
      out.write("    \"M+\" : this.getMonth()+1, //month \r\n");
      out.write("    \"d+\" : this.getDate(), //day \r\n");
      out.write("    \"h+\" : this.getHours(), //hour \r\n");
      out.write("    \"m+\" : this.getMinutes(), //minute \r\n");
      out.write("    \"s+\" : this.getSeconds(), //second \r\n");
      out.write("    \"q+\" : Math.floor((this.getMonth()+3)/3), //quarter \r\n");
      out.write("    \"S\" : this.getMilliseconds() //millisecond \r\n");
      out.write("    };\r\n");
      out.write("    if(/(y+)/.test(format)){ \r\n");
      out.write("    \tformat = format.replace(RegExp.$1, (this.getFullYear()+\"\").substr(4 - RegExp.$1.length)); \r\n");
      out.write("    }\r\n");
      out.write("    for(var k in o)  { \r\n");
      out.write("\t    if(new RegExp(\"(\"+ k +\")\").test(format)){ \r\n");
      out.write("\t    \tformat = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : (\"00\"+ o[k]).substr((\"\"+ o[k]).length)); \r\n");
      out.write("\t    } \r\n");
      out.write("    } \r\n");
      out.write("    return format; \r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var TT = TAOTAO = {\r\n");
      out.write("\t\t// 格式化时间\r\n");
      out.write("\t\tformatDateTime : function(val,row){\r\n");
      out.write("\t\t\tvar now = new Date(val);\r\n");
      out.write("\t    \treturn now.format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getSelectionsIds1(){\r\n");
      out.write("\tvar itemList = $(\"#itemList\");\r\n");
      out.write("\tvar sels = itemList.datagrid(\"getSelections\");\r\n");
      out.write("\tvar ids = [];\r\n");
      out.write("\tfor(var i in sels){\r\n");
      out.write("\t\tids.push(sels[i].id);\r\n");
      out.write("\t}\r\n");
      out.write("\tids = ids.join(\",\");\r\n");
      out.write("\treturn ids;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var toolbar = [{\r\n");
      out.write("    text:'确认已查看',\r\n");
      out.write("    iconCls:'icon-edit',\r\n");
      out.write("    handler:function(){\r\n");
      out.write("    \tvar ids = getSelectionsIds1();\r\n");
      out.write("    \tif(ids.length == 0){\r\n");
      out.write("    \t\t$.messager.alert('提示','必须选择一个订单才能确认!');\r\n");
      out.write("    \t\treturn ;\r\n");
      out.write("    \t}\r\n");
      out.write("    \tif(ids.indexOf(',') > 0){\r\n");
      out.write("    \t\t$.messager.alert('提示','只能选择一个订单!');\r\n");
      out.write("    \t\treturn ;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t$.messager.defaults = { ok: \"是\", cancel: \"否\" };\r\n");
      out.write("    \t$.messager.confirm(\"确认提示\",\"确认后您将不在看到这条订单记录,只能在订单管理中查看,是否确认?\", function(r){\r\n");
      out.write("    \t\tif(r){\r\n");
      out.write("    \t\t\t$.post(\"/editor/checked\",{ids:ids},function(data){\r\n");
      out.write("    \t\t\t\tif(data.status==200){\r\n");
      out.write("    \t\t\t\t\tlocation.href=\"/pages/base/home\";\r\n");
      out.write("    \t\t\t\t}else{\r\n");
      out.write("    \t\t\t\t\t$.messager.alert('提示','确认失败!');\r\n");
      out.write("    \t\t\t\t}\r\n");
      out.write("    \t\t\t})\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t})\r\n");
      out.write("    }\r\n");
      out.write("    }]\r\n");
      out.write("</script>\r\n");
      out.write(" </body>\r\n");
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
