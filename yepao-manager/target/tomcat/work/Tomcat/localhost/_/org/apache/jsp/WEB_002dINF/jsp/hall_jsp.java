/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-12-01 01:43:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hall_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>宴会厅信息设置</title>\r\n");
      out.write("\t\t<!-- 导入jquery核心类库 -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("\t\t<!-- 导入ocupload -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/ocupload/jquery.ocupload-1.1.2.js\" ></script>\r\n");
      out.write("\t\t<!-- 导入easyui类库 -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/easyui/themes/bootstrap/easyui.css\">\r\n");
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
      out.write("\t\t//将查询表单中的数据转换成json数据-start\r\n");
      out.write("\t\t$.fn.serializeJson=function(){  \r\n");
      out.write("            var serializeObj={};  \r\n");
      out.write("            var array=this.serializeArray();  \r\n");
      out.write("            var str=this.serialize();  \r\n");
      out.write("            $(array).each(function(){  \r\n");
      out.write("                if(serializeObj[this.name]){  \r\n");
      out.write("                    if($.isArray(serializeObj[this.name])){  \r\n");
      out.write("                        serializeObj[this.name].push(this.value);  \r\n");
      out.write("                    }else{  \r\n");
      out.write("                        serializeObj[this.name]=[serializeObj[this.name],this.value];\r\n");
      out.write("                    }  \r\n");
      out.write("                }else{  \r\n");
      out.write("                    serializeObj[this.name]=this.value;   \r\n");
      out.write("                }  \r\n");
      out.write("            });  \r\n");
      out.write("            return serializeObj;  \r\n");
      out.write("        }; \r\n");
      out.write("        //将查询表单中的数据转换成json数据-end\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tfunction doAdd(){\r\n");
      out.write("        \t\tlocation.href=\"/pages/base/hall-add\";\r\n");
      out.write("\t\t\t\t//$('#addWindow').window(\"open\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction doView(){\r\n");
      out.write("\t\t\t\t// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了\r\n");
      out.write("\t\t\t\tvar rows = $(\"#grid\").datagrid('getSelections');\r\n");
      out.write("\t\t\t\tif(rows.length == 0){\r\n");
      out.write("\t\t\t\t\t// 没选 或 多选 \r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示信息\",\"请选择您要修改的行\",\"warning\");\r\n");
      out.write("\t\t\t\t}else if(rows.length != 1){\r\n");
      out.write("\t\t\t\t\t// 没选 或 多选 \r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示信息\",\"修改数据时，只能选中一行\",\"warning\")\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t// 只选中一行 \r\n");
      out.write("\t\t\t\t\tvar row = rows[0]; \r\n");
      out.write("\t\t\t\t\t// 进行表单回显操作 ，只要使用了它就能将本行的数据加载打表单中去\r\n");
      out.write("\t\t\t\t\t$(\"#eidtorWindow\").form('load',row);\r\n");
      out.write("\t\t\t\t\t// 显示窗口\r\n");
      out.write("\t\t\t\t\t$(\"#eidtorWindow\").window('open');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction doDelete(){\r\n");
      out.write("\t\t\t\tvar rows = $(\"#grid\").datagrid('getSelections');\r\n");
      out.write("\t\t\t\tif(rows.length == 0){\r\n");
      out.write("\t\t\t\t\t// 没选 或 多选 \r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示信息\",\"请选择您要修改的行\",\"warning\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.messager.confirm(\"提示\", \"删除之后不可恢复,确定要删除吗？\",function(data){\r\n");
      out.write("\t\t\t\t\t\tif(data){\r\n");
      out.write("\t\t\t\t\tvar arr = new Array();\r\n");
      out.write("\t\t\t\t\tfor(var i=0;i<rows.length;i++){\r\n");
      out.write("\t\t\t\t\t\tarr.push(rows[i].banquetHallId);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t//生成字符串\r\n");
      out.write("\t\t\t\t\tvar ids = arr.join(\",\");\r\n");
      out.write("\t\t\t\t\twindow.location.href = \"/hall/delete?ids=\"+ids;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction checkComment(){\r\n");
      out.write("\t\t\t\t// 获取当前datagrid选中数据 ，就是前面那个框框打对勾就算是选中了\r\n");
      out.write("\t\t\t\tvar rows = $(\"#grid\").datagrid('getSelections');\r\n");
      out.write("\t\t\t\tif(rows.length == 0){\r\n");
      out.write("\t\t\t\t\t// 没选 或 多选 \r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示信息\",\"请选择您要查看的宴会厅\",\"warning\");\r\n");
      out.write("\t\t\t\t}else if(rows.length != 1){\r\n");
      out.write("\t\t\t\t\t// 没选 或 多选 \r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示信息\",\"查看作品时，只能选中一行\",\"warning\")\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t// 只选中一行 \r\n");
      out.write("\t\t\t\t\tvar row = rows[0]; \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$.cookie(\"checkHallId\", row.banquetHallId, {path: '/',expires: 1});\r\n");
      out.write("\t\t\t\t\tlocation.href=\"/pages/base/hall_comment\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//工具栏\r\n");
      out.write("\t\t\tvar toolbar = [{\r\n");
      out.write("\t\t\t\tid : 'button-add',\r\n");
      out.write("\t\t\t\ttext : '增加宴会厅',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-add',\r\n");
      out.write("\t\t\t\thandler : doAdd\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tid : 'button-delete',\r\n");
      out.write("\t\t\t\ttext : '删除',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-cancel',\r\n");
      out.write("\t\t\t\thandler : doDelete\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tid : 'button-upload',\r\n");
      out.write("\t\t\t\ttext : '查看评论',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-search',\r\n");
      out.write("\t\t\t\thandler : checkComment\r\n");
      out.write("\t\t\t}];\r\n");
      out.write("\t\t\t// 定义列\r\n");
      out.write("\t\t\tvar columns = [ [ {\r\n");
      out.write("\t\t\t\tfield : 'banquetHallId',\r\n");
      out.write("\t\t\t\tcheckbox : true,\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'name',\r\n");
      out.write("\t\t\t\ttitle : '宴会厅名称',\r\n");
      out.write("\t\t\t\twidth : 80,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tfield : 'floorNum',\r\n");
      out.write("\t\t\t\ttitle : '楼层',\r\n");
      out.write("\t\t\t\twidth : 50,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'minTable',\r\n");
      out.write("\t\t\t\ttitle : '最少桌数',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'maxTable',\r\n");
      out.write("\t\t\t\ttitle : '最大桌数',\r\n");
      out.write("\t\t\t\twidth : 60,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tfield : 'floorHeight',\r\n");
      out.write("\t\t\t\ttitle : '层高',\r\n");
      out.write("\t\t\t\twidth : 50,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'area',\r\n");
      out.write("\t\t\t\ttitle : '面积',\r\n");
      out.write("\t\t\t\twidth : 50,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'images',\r\n");
      out.write("\t\t\t\ttitle : '图片',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\tformatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\treturn \"<img src='\"+value[0]+\"' width='100' height='100'/>\";//在这个区域直接显示出图片\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'created',\r\n");
      out.write("\t\t\t\ttitle : '创建时间',\r\n");
      out.write("\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\tformatter: function (value,row,index) {\r\n");
      out.write("\t\t\t\t\t var now = new Date(value);\r\n");
      out.write("\t\t\t\t    \treturn now.format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("                 }\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'updated',\r\n");
      out.write("\t\t\t\ttitle : '更新时间',\r\n");
      out.write("\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\talign : 'center',\r\n");
      out.write("\t\t\t\tformatter: function (value,row,index) {\r\n");
      out.write("\t\t\t\t\t var now = new Date(value);\r\n");
      out.write("\t\t\t\t    \treturn now.format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("                 }\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tfield : 'standby',\r\n");
      out.write("\t\t\t\ttitle : '备注',\r\n");
      out.write("\t\t\t\twidth : 200,\r\n");
      out.write("\t\t\t\talign : 'center'\r\n");
      out.write("\t\t\t}] ];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(function(){\r\n");
      out.write("\t\t\t\t// 先将body隐藏，再显示，不会出现页面刷新效果\r\n");
      out.write("\t\t\t\t$(\"body\").css({visibility:\"visible\"});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 宴会厅管理数据表格\r\n");
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
      out.write("\t\t\t\t\turl : \"/hall_pageQuery\",\r\n");
      out.write("\t\t\t\t\tidField : 'banquetHallId',//这里的字段一定与表格里的id字段对应\r\n");
      out.write("\t\t\t\t\tcolumns : columns\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body class=\"easyui-layout\" style=\"visibility:hidden;\">\r\n");
      out.write("\t\t<div region=\"center\" border=\"false\">\r\n");
      out.write("\t\t\t<table id=\"grid\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
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
