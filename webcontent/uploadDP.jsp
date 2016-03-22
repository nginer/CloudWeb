<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传数据和程序（支持大文件）</title>
</head>
<body>
<form action="uploadData.do" enctype="multipart/form-data" method="post">
	<!-- 数据名称：<input type="text" name="dataName"><br> 以用户上传数据的名称为准-->
	描述信息：<input type="text" name="dataDescribe"><br>
	关键词    ：<input type="text" name="dataKeyword"><br>
	文件压缩包：<input type="file" name="file_data"><br>
	<input type="reset" value="清空">
	<input type="submit" value="点击上传">
</form>
<br>
<br>
<form action="uploadProgram.do" enctype="multipart/form-data" method="post">
	
	描述信息：<input type="text" name="programDescribe"><br>
	关键词    ：<input type="text" name="programKeyword"><br>
	程序压缩包：<input type="file" name="file_program"><br>
	<input type="reset" value="清空">
	<input type="submit" value="点击上传">
</form>

<form action="UpFileReturn.do" method="post" >
   <input type="submit" name="submit" id="submit" value="返回" />
 </form>
	<%
		if (request.getAttribute("message_data")!=null){
			
			out.println("<script>alert(' " + request.getAttribute("message_data")
					+ " ' )</script>");
			System.out.println(request.getAttribute("message_data")+"&&&&&&&&&&####");
		request.setAttribute("message", null);}

		if (request.getAttribute("message_program")!=null){
		
			out.println("<script>alert(' " + request.getAttribute("message_program")
					+ " ' )</script>");
		System.out.println(request.getAttribute("message_program")+"&&&&&&&&&&");
		request.setAttribute("message_program", null);}
	%>
</body>
</html>