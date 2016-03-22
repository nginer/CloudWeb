<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="<%=path%>/bootstrap/Flat-UI-master/dist/img/myFavicon.ico">
<!-- 引入自定义的css文件 -->
<link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/vendor/bootstrap.min.css" rel="stylesheet">
 <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/css/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<link href="<%=path%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<title>修改信息</title>
</head>
<body>
<a>head：<jsp:include  page="head.jsp"/></a>
<div class="container">
<form action="regestModify.do">
<div class="col-md-3"></div>
<div id="formDiv" class="col-md-6">
<h4>修改信息</h4>
<br/><br/>
<h5>用户名：</h5><p>${sessionScope.user.user_name}</p>
<h5>原密码：</h5>  <input type="password" class="form-control" id="inputSuccess" name="originpassword" size="20" maxlength="8" /><br />
<h5>E-mail:</h5>  <input type="text" class="form-control" id="inputSuccess" name="email" /><br />
<h5>新密码：</h5>  <input type="password" class="form-control" id="inputSuccess" name="newpassword" size="20" maxlength="8"/><br />
<h5>确认新密码：</h5>  <input type="password" class="form-control" id="inputSuccess" name="qupassword" size="20" maxlength="8" /><br />
<h5>手机号码：</h5>  <input type="text" class="form-control" id="inputSuccess" name="mobilephone" /><br />
</div>
<input type="submit" class="btn btn-primary"value="提交">
</form>
<form action="regestturn.do" method="post">
						
<input type="submit"class="btn btn-primary" value="返回">
</form>
</div>

</body>
</html>