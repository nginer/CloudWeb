<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <title>创建服务——构建表结构</title>
    <!-- 引入 -->
     <script src="<%=path%>/js/jquery-1.4.3.js"></script> 
	<script src="<%=path %>/js/createTableStructure.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">
    <link rel="shortcut icon" href="<%=path%>/bootstrap/Flat-UI-master/dist/img/myFavicon.ico">
	<!-- 引入自定义的css文件 -->
	<link rel="stylesheet" href="<%=path%>/css/main.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/html5shiv.js"></script>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
    <div class="container">
      
    <%--来自W2XML_describeController的数据：${first}
	 <table>
	<tr><td>服务名称：${serviceName}</td><td>服务描述：${serviceDescription}</td></tr>
    <tr><td>  关键字：${keywords}</td><td>处理类型：${type}</td></tr>
	</table>
	<div id="test">this is it!!!!!!!!!</div> --%>
	<div class="col-md-3"></div>
	<div id="formDiv" class="col-md-6" >
	<h5>构建表结构</h5>
	<br /><br />
     <form action="W2XML_table.do" method="post">
       <h6>表名：</h6> <input type="text" class="form-control" id="inputSuccess" name="tableName" />
         <div  class="h_family">
            <h6>列族：</h6><input type="text" class="form-control"  name="cluster"  />
           <h6>列  ：</h6>	<input type="text" class="form-control"  name="b_addColumn0" />
           <br>
           		<button type="button" class="b_addColumn btn btn-primary btn-sm" id="b_addColumn0">再添一列</button>
               	<button type="button" class="b_addFamily btn btn-primary btn-sm" >再添加一个列族</button>
     	 </div>
     	 <br>
     	  <button class="btn btn-primary" type="submit" id="submit">信息写入XML跳向上传数据</button>
       
            
    </form>
    </div>
    </div><!-- /.container -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/flat-ui.min.js"></script>

    <script src="<%=path%>/bootstrap/Flat-UI-master/docs/assets/js/application.js"></script>

    <script>
      $(document).ready(function(){
        $('select[name="inverse-dropdown"], select[name="inverse-dropdown-optgroup"], select[name="inverse-dropdown-disabled"]').select2({dropdownCssClass: 'select-inverse-dropdown'});

        $('select[name="searchfield"]').select2({dropdownCssClass: 'show-select-search'});
        $('select[name="inverse-dropdown-searchfield"]').select2({dropdownCssClass: 'select-inverse-dropdown show-select-search'});
      });
    </script>

  </body>
</html>