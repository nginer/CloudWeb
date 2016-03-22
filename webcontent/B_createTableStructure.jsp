<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=path%>/js/jquery-1.4.3.js"></script>
<script src="<%=path %>/js/createTableStructure.js"></script>

<title>创建服务——构建表结构</title>
</head>
<body>
	来自W2XML_describeController的数据：${first}
	<table>
	<tr><td>服务名称：${serviceName}</td><td>服务描述：${serviceDescription}</td></tr>
    <tr><td>  关键字：${keywords}</td><td>处理类型：${type}</td></tr>
	</table>
	<div id="test">this is it!!!!!!!!!</div>
	<br />构建表结构
    <form action="W2XML_table.do" method="post">
        表名： <input type="text" name="tableName" />
         <div  class="h_family">
            列族：<input type="text" name="cluster"  /><br />
           	列  ：<input type="text" name="b_addColumn0" />
               	 <input type="button" class="b_addColumn" id="b_addColumn0" value="再添一列" /> <br />
                 <input type="button" class="b_addFamily" value="再添加一个列族" /><br />
     	 </div>
         <input type="submit" value="信息写入XML跳向上传数据" id="submit" /> 
            
    </form>
    
</body>
</html>