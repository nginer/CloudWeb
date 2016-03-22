<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = "file://E://temp";
//String path = "temp";

//String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form id="form1" name="form1" method="post" target="_self">
<tr>
      <td bgcolor="#FFFFFF">缩略图片：</td>
      <td bgcolor="#FFFFFF"><input name="picurl" type="text" id="picurl" size="50" />
      <input type="button" name="Submit2" value="打开上传页面" onClick="window.open('upload.jsp','','status=no,scrollbars=no,top=20,left=110,width=420,height=165')"/></td>
    </tr>
    <tr>
      <td bgcolor="#FFFFFF">缩略图预览：</td>
      <td bgcolor="#FFFFFF"><img name="pic" src="" width="80" height="80" alt="" /></td>
    </tr>
<tr>
      <td bgcolor="#FFFFFF">&nbsp;</td>
      <td align="center" bgcolor="#FFFFFF">
      <input type="submit" name="Submit" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" name="Reset" value="重置" /></td>
    </tr>
  </table>
</form>
  </body>
</html>
