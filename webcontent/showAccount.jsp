<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>显示账户信息，这怎么又一个</title>
</head>
<body>
	个人信息<br>
		<form action="showAccount.do" method="post">
		<input type="submit" value="修改信息" />
		</form>	
		<form action="showAccount1.do" method="post">
		<input type="submit" value="上传文件" />
		</form>	
		<form action="service.do?type=s" method="post">
		<input type="submit" value="个人中心" />
		</form>		
		<form action="withdraw.do" method="post">
		<input type="submit" value="退出登录" />
		</form>		
</body>
</html>