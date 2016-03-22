<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文件上传</title>
</head>

<body>
<h2 align="center">文件上传</h2>
<p>&nbsp;</p>
<form action="UpFileController" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <p>文件描述：
    <label for="describ"></label>
    <input type="text" name="describ" id="describ" />
  </p>
  <p>
    <label for="file">请选择文件：</label>
 	
    <input type="file" name="file2" id="file2" />
  </p>
  <p>
    <input type="submit" name="submit" id="submit" value="提交" />
  </p>
  <p>
    <input name="reset" type="reset" id="reset" value="重置" />
  </p>
</form>

<form action="UpFileReturn.do" method="post" enctype="multipart/form-data" name="form1" id="form1">
   <input type="submit" name="submit" id="submit" value="返回" />
 </form>
	<%
		if (request.getAttribute("msg") != null)
			out.println("<script>alert(' " + request.getAttribute("msg")
					+ " ' )</script>");
	%>

</body>
</html>