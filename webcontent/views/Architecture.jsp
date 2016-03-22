<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <title>建筑Architecture 领域服务</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="<%=path%>/bootstrap/Flat-UI-master/dist/img/myFavicon.ico">
	<!-- 引入自定义的css文件 -->
	<link rel="stylesheet" href="<%=path%>/css/main.css">
	<!-- 引入jquery -->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.js"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/html5shiv.js"></script>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/respond.min.js"></script>
    <![endif]-->
    <!-- 引入tablecloth -->
    <link href="<%=path%>/bootstrap/tablecloth/tablecloth_colorful.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="<%=path%>/bootstrap/tablecloth/tablecloth.js"></script>
    <!-- 引入tablecloth结束 -->

  </head>
  <body>
 
	<h6>建筑Architecture 领域服务信息：</h6>
	<table cellspacing="0" cellpadding="0">
		<tr><th>service_ID</th><th>service_name</th><th>service_keywords</th><th>service_describe</th><th>owner_ID</th><th>owner_name</th><th>data_ID</th><th>data_name</th><th>program_ID</th><th>program_name</th><th>status</th><th>processType</th><th>time_construct</th><th>url</th><th>domain</th></tr>
		<c:forEach var="item" items="${Slist}">
			<tr>
				<td>${item.service_ID}</td>
				<td>${item.service_name}</td>
				<td>${item.service_keywords}</td>
				<td>${item.service_describe}</td>
				<td>${item.owner_ID}</td>
				<td>${item.owner_name}</td>
				<td>${item.data_ID}</td>
				<td>${item.data_name}</td>
				<td>${item.program_ID}</td>
				<td>${item.program_name}</td>
				<td>${item.status}</td>
				<td>${item.processType}</td>
				<td>${item.time_construct}</td>
				<td><a href="${item.url}">${item.url}</a></td>
				<td>${item.domain}</td>
			</tr>
		</c:forEach>
	</table>

  <!-- /.container -->

  <%--   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/jquery.min.js"></script> --%>
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