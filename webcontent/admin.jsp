<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
</head>
<body>
<script type="text/javascript">
function select(){
	
}

</script>
<table width="1350" height="768" border= "1" cellspacing="0"align="center"> 
<thead >
	<tr height="80">
		<th width="300">个人中心</th>
		<th width="1050">${tName }</th>
			
	</tr>
</thead>
<tbody>
	<tr height="620">
		<td width="100" valign="top">
		
			<p>管理员:${sessionScope.user.user_name}</p>
			<p>用户类型：${sessionScope.user.group }</p>

			<p><form action="showAccount.do" method="post">
			<input type="submit" value="修改个人信息" />
			</form>
			<p><form action="showAccount1.do" method="post">
			<input type="submit" value="上传基本文件" />
			</form>		
			<p><form action="withdraw.do" method="post">
			<input type="submit" value="退出用户登录" />
			</form>		
			
		</td>
		<td width="1250" background="lighter blue">
		<form action="add.do" method="post">
		<input type="button" value="添加" onclick="window.location.href='createService.do?'"><br/>
		</form>
		<table align ="center" width="950" border="1"cellspacing="2">
		<c:choose>
		<c:when test="${param.type==\"s\"}">   	
			<tr height="60">
				<td align="center" >服务ID</td>
				<td align="center"> 状态</td>
				<td align="center"> 程序名称</td>
				<td align="center"> 数据名称</td>
				<td align="center"> 上传时间</td>
				<td align="center"> 处理类型</td>
				<td align="center"> 操作</td>
				<td align="center"> <select><option value ="全部">全部</option>
                <option value ="待审核">待审核</option>
                <option value ="待提交">待提交</option>
				<option value="已提交">已提交</option>
                <option value="已发布">已发布</option>
				</select></td>
				<td>
				</td>
			</tr>
			<c:forEach var="si" items="${table.serviceInfos}" >
			<tr height="100">			
				<td align="center" >${si.service_ID}</td>
				<td align="center"> ${si.status}</td>
				<td align="center"> ${si.program_name}</td>
				<td align="center"> ${si.data_name}</td>
				<td align="center"> ${si.time_construct}</td>
				<td align="center"> ${si.processType}</td>
				<td>
				<form action = "service.do?type=s&serviceID=${si.service_ID}" method="post"><input type = "submit" value ="删除"></form>
				<form action =" "method="post"><input type = "submit" value ="修改"></form>
				</td>
				</tr>
			</c:forEach>
			</c:when>
			<c:when test ="${param.type==\"d\"}">
			<tr height="100">
				<td align="center" >数据ID</td>
				<td align="center" >数据名称</td>
				<td align="center"> 数据描述</td>
				<td align="center"> 上传时间</td>
				<td align="center"> 最后修改时间</td>
				<td align="center"> 操作</td>
			</tr>
			<c:forEach var = "k" items = "${table.datas}">
			<tr height="100">		<td align = "center">${k.data_ID }</td>
			<td align = "center">${k.data_name }</td>
			<td align = "center">${k.data_describe }</td>
			<td align = "center">${k.time_upload }</td>
			<td align = "center">${k.time_lastModify }</td>
	
			<td>
			<form action = "service.do?type=d&dataID=${k.data_ID}" method="post"><input type = "submit" value ="删除"></form>
				<form action =" "method="post"><input type = "submit" value ="修改"></form>
			</td>	
			</tr>
			</c:forEach>
			</c:when>
		<c:when test="${param.type==\"p\" }">
			<tr height="100">
				<td align="center" >程序ID</td>
				<td align="center" >程序名称</td>
				<td align="center"> 程序描述</td>
				<td align="center"> 上传时间</td>
				<td align="center"> 操作</td>
			</tr>
			<c:forEach var = "k" items = "${table.programs}">
			<tr height="100">		
			<td align = "center">${k.program_ID }</td>
			<td align = "center">${k.program_name }</td>
			<td align = "center">${k.program_describe }</td>
			<td align = "center">${k.time_upload }</td>
			<td>
			<form action = "service.do?type=p&programID=${k.program_ID}" method="post"><input type = "submit" value ="删除"></form>
				<form action =" "method="post"><input type = "submit" value ="修改"></form>
			</td>	
			</tr>
			</c:forEach>
			</c:when>
			<c:otherwise>
			<p>请选择你要浏览的信息</p>
			<p><form action = "service.do?type=p" method="post">
			<input type= "submit" value = "基本程序信息"></form>
			<p><form action = "service.do?type=s" method="post">
			<input type= "submit" value = "基本服务信息"></form>
			<p><form action = "service.do?type=d" method="post">
			<input type= "submit" value = "基本数据信息"></form>
			
			</c:otherwise>
			</c:choose>
			
	
			<tr height="100">
				
			
			
			
		</table>
		</td>
	</tr>
</tbody>
<tfoot >
		<tr align="center">
			<td height="30" colspan="2">版权信息</td>
		</tr>
</tfoot>
</table>

</body>
</html>
