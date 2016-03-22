<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <title>Flat UI Free</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="<%=path%>/bootstrap/Flat-UI-master/dist/img/favicon.ico">
	<!-- 引入自定义的css文件 -->
	<link rel="stylesheet" href="<%=path%>/css/main.css">
	<script src="<%=path%>/js/jquery-1.11.3.js"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/html5shiv.js"></script>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <style>
      body {
        padding-bottom: 200px;
        padding-top:50px;
      }
    </style>
    <div class="container">
    <!--示例
     <div class="container">
	 <div class="row">
	 <div class="col-md-4">
	 示例-->
     <h6>在这个div里搞你想搞的！！！！！！！！！！！</h6>

      <select data-toggle="select" class="form-control select select-danger mrs mbm">
        <option value="0">My Profile here is</option>
        <option value="1">My Friends</option>
        <option value="2">My Profile</option>
        <option value="3">My Friends</option>
      </select>

    </div><!-- /.container -->

   <%-- 已引入，无需再引
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/jquery.min.js"></script>--%>
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