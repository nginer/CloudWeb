<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这个页面乱，改掉！</title>
</head>
<body>
	管理用户<br>
		<form action="adshowAccount.do" method="post">
		<input type="submit" value="修改信息" />
		</form>	
		<form action="adshowAccount1.do" method="post">
		<input type="submit" value="上传文件" />
		</form>	
		<form action="service.do?type=s" method="post">
		<input type="submit" value="个人中心" />
		</form>		
		<form action="adwithdraw.do" method="post">
		<input type="submit" value="退出登录" />
		</form>		
</body>
</html>