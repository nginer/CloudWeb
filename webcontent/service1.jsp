<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<link href="<%=path%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=path%>/css/main.css">
<title>基本信息</title>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-lg-2">
			<dl>
				<dt>
				个人中心
				</dt>
				<dt>
				用户名：
				</dt>
				<dd>
				${sessionScope.user.user_name}
				</dd>
				<dt>
				e-mail:
				</dt>
				<dd>
				${sessionScope.user.email}
				</dd>
				<dt>
				用户类型：
				</dt>
				<dd>
				${sessionScope.user.group}
				</dd>
			</dl>
			<p>
				<form action="showAccount.do" method="post">
				<input type="submit" class="btn btn-primary " value="修改信息" />
				</form>	
			<p>
				<input type="button"  class="btn btn-primary " value="上传数据" onclick="window.location.href='uploadDP.jsp'">
			</p>
			<p>
			<input type="button"  class="btn btn-primary " value="上传程序" onclick="window.location.href='uploadDP.jsp'">
	
			</p>
			<p>
				<form action="withdraw.do" method="post">
				<input type="submit" class="btn btn-primary " value="退出登录" />
				</form>	
		</div>
				<h3 class="text-success text-center">
				${tName }
				</h3>
		<div class="col-lg-10">
				<div class="col-lg-3">
				<form action = "service.do?type=p" method="post">
				<input type= "submit" class="btn btn-primary"value = "基本程序信息"></form>	
				</div>
				<div class="col-lg-3">
				<form action = "service.do?type=s" method="post">
				<input type= "submit" class="btn btn-primary" value = "基本服务信息"></form>
				</div>
				<div class="col-lg-3">
				<form action = "service.do?type=d" method="post">
			<input type= "submit" class="btn btn-primary" value = "基本数据信息"></form>
				</div>
		<table class="table table-stripe">
		<c:choose>
			<c:when test="${param.type==\"s\"}">
				<thead>
					<tr>
						<th>
							服务ID
						</th>
						<th>
							服务名称
						</th>
						<th>
							服务关键字
						</th>
						<th>
							服务描述
						</th>
						<th>
							拥有人名称
						</th>
						<th>
							状态
						</th>
						<th>
							程序名称
						</th>
						<th>
							数据名称
						</th>
						<th>
							上传时间
						</th>
						<th>
							处理类型
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				
				<c:forEach var="si" items="${table.serviceInfos}" >
					<tr class="warning">
						<td>
							${si.service_ID}
						</td>
						<td>
							${si.service_name}
						</td>
						<td>
							${si.service_keywords}
						</td>
						<td>
							${si.service_describe}
						</td>
						<td>
							${si.owner_name}
						</td>
						<td>
							 ${si.status}
						</td>
						<td>
							${si.program_name}
						</td>
						<td>
							${si.data_name}
						</td>
						<td>
							${si.time_construct}
						</td>
						<td>
							 ${si.processType}
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							<form action = "service.do?type=s&serviceID=${si.service_ID}" method="post"><input type = "submit" value ="删除"></form>
						</td>
					</tr>
				</c:forEach>		
			</c:when>
		
	<c:when test ="${param.type==\"d\"}">
				<thead>
					<tr>
						<th>
							数据ID
						</th>
						<th>
							数据名称
						</th>
						<th>
							数据描述
						</th>
						<th>
							上传时间
						</th>
						<th>
							修改时间
						</th>
						<th>
							拥有者
						</th>
						<th>
							对应服务
						</th>
						<th>
							操作类型
						</th>
					</tr>
				</thead>
				
				<c:forEach var = "k" items = "${table.datas}">
					<tr class="warning">
						<td>
							${k.data_ID }
						</td>
						<td>
							${k.data_name }
						</td>
						<td>
							${k.data_describe }
						</td>
						<td>
							${k.time_upload }
						</td>
						<td>
							${k.time_lastModify }
						</td>
						<td>
							${k.owner_ID }
						</td>
						<td>
							${k.service_ID }
						</td>
						<td>
							Default
						</td>
						<td>
			<form action = "service.do?type=d&dataID=${k.data_ID}" method="post"><input type = "submit" value ="删除"></form>
			</td>
			</tr>
		</c:forEach>
	</c:when>

			<c:when test="${param.type==\"p\"}">
				<thead>
					<tr>
						<th>
							程序ID
						</th>
						<th>
							程序名称
						</th>
						<th>
							服务描述
						</th>
						<th>
							上传时间
						</th>
						<th>
							拥有者
						</th>
						<th>
							对应服务
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				
				<c:forEach var = "k" items = "${table.programs}">
					<tr class="warning">	
						<td>${k.program_ID }</td>
						<td>${k.program_name }</td>
						<td>${k.program_describe }</td>
						<td>${k.time_upload }</td>
						<td>${k.owner_ID }</td>
						<td>${k.service_ID }</td>
						<td>
							<form action = "service.do?type=p&programID=${k.program_ID}" method="post"><input type = "submit" value ="删除"></form>
							
						</td>	
					</tr>
				</c:forEach>
			</c:when>
		
		<c:otherwise>
		</c:otherwise>
		</c:choose>
	</table>
</div>
	<form action="add.do" method="post">
		<input type="button" class="btn btn-success" value="添加" onclick="window.location.href='createService.do?'"><br/>
		</form>
			<br>
			<address>
				<div class="row">
        		<div class="col-md-12">
        	  
            	<button type="button" class="btn btn-default btn-lg btn-block">Copyright ©2008 MUC_908 Version 1.0.0</button>
       			 </div>
      				</div>
			
			</address>
		</div>
	</div>
</div>

</body>
</html>