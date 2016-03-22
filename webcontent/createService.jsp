<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <title>创建服务——服务描述</title>
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
    <title>创建服务——服务描述</title>
  </head>
  <body>
 
    <div class="container">
	<!-- form中使用name，option中使用value -->
	<form action='W2XML_describe.do' method="post">
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
	<%-- 测试数据（没用  ，删掉）${user.getUser_name()}
	用户名：<%User user=(User)session.getAttribute("user");%><%=user.getUser_name()%><br /> --%>
	<%  %>
	<div class="col-md-3">
		
	</div>
	<div id="formDiv" class="col-md-6">
      <h5>请输入您对服务的描述信息</h5> 
       <br /><br />
		
    
       <h6>服务名称：</h6>  <input type="text" class="form-control" id="inputSuccess" name="serviceName" /><br />
       <h6>服务描述：</h6>  <input type="text" class="form-control" id="inputSuccess" name="seviceDescription" /><br />
       <h6>关键字 :  </h6>  <input type="text" class="form-control" id="inputSuccess" name="keywords" value="请以逗号分隔" onblur="if(this.value==''){this.value='请以逗号分隔';}" onfocus="if(this.value==this.defaultValue){this.value='';}">
       <h6>处理方式：</h6> 
       			<select data-toggle="select" class="form-control select select-primary mrs mbm"  id="processType" name= "type">
        		<c:forEach items="${types}" var="type" varStatus="status">
						<option value="${type}">${type}</option>
						</c:forEach>
    		 	</select > 
    	<h6>领     域：</h6>
				<select data-toggle="select" class="form-control select select-primary mrs mbm" name="domain">
					<option value="domain">Domain</option>
					<c:forEach items="${domains}" var="domain" varStatus="status">
						<option value="${domain}">${domain}</option>
					</c:forEach>
				</select>    		
       <br />     
            <button class="btn btn-primary" type="submit">提交服务描述</button>
     </div>  
    </form>

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