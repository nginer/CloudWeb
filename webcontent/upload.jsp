<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>��ѡ���ϴ���ͼƬ</title>
</head> 
<body>
<table border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="45" align="center" valign="middle">
    	<form action="uploadimage.jsp" method="post" enctype="multipart/form-data" name="myform">
			��ѡ���ϴ���ͼƬ:
    		<input type="file" name="file"/>
    		<br/>
    		�ڴ���������Ҫ���뵽��̨�����֣�<br/>
    		<input type="text" name="state"/>
    		<input type="submit" name="Submit" value="�ϴ�"/>
   	 	</form>
    </td>
  </tr>
</table>
</body>
</html>