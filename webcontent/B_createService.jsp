<%@page import="testweb.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>创建服务——服务描述</title>
</head>
<body>
	用戶名：${userInfo.user_name}<br>
	<!-- form中使用name，option中使用value -->
	<form action='W2XML_describe.do' method="post">
	<br>
	测试数据（没用  ，删掉）${user.getUser_name()}
	<br>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
	<%-- 用户名：<%User user=(User)session.getAttribute("user");%><%=user.getUser_name()%><br /> --%>
	<%  %>
       请输入您对服务的描述信息<br />
       <br /><br /><br /><br /><br />
        服务名称： <input type="text" name="serviceName" />
        服务描述： <input type="text" name="seviceDescription" /><br />
        关键字 :	  <input type="text" name="keywords" value="请以逗号分隔"/>
        处理方式： <select id="processType" name= "type" >
        				<c:forEach items="${types}" var="type" varStatus="status">
						<option value="${type}">${type}</option>
						</c:forEach>
        	  </select>
       <br />
       <input type="submit" name="SD_done" value="提交服务描述"  />
    </form>
</body>
</html>