<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>请选择上传的图片</title>
</head> 
<body>
<table border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="45" align="center" valign="middle">
    	<form action="uploadimage.jsp" method="post" enctype="multipart/form-data" name="myform">
			请选择上传的图片:
    		<input type="file" name="file"/>
    		<br/>
    		在此输入你想要传入到后台的文字：<br/>
    		<input type="text" name="state"/>
    		<input type="submit" name="Submit" value="上传"/>
   	 	</form>
    </td>
  </tr>
</table>
</body>
</html>