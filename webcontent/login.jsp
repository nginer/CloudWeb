<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="<%=path%>/bootstrap/Flat-UI-master/dist/img/myFavicon.ico">
	<!-- 引入自定义的css文件 -->
	<link rel="stylesheet" href="<%=path%>/css/main.css">
	<script language="javascript"> 
					function loadimage(){ 
					document.getElementById("randImage").src = "image.jsp?"+Math.random(); 
					} 
	</script> 
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/html5shiv.js"></script>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

    <div class="container" >
      <div class="login col-md-offset-1" style="">
        <div class="login-screen" style="width:89.2%;color:black;padding-top:5%;">
          <div class="login-icon">
          	<br><br>
            <img src="<%=path%>/bootstrap/Flat-UI-master/img/login/QB.gif" alt="Welcome to Mail App">
            <h4>欢迎来到 <small>908</small></h4>
          </div>

          <div class="login-form" style="margin-top:5px;" >
          <form action="login.do" method="post">
          	<input type="text" class="form-control" id="inputSuccess" name="username"  placeholder="用户名"/>
          	<input type="password" style="margin-top:5px;" class="form-control" id="inputSuccess" name="password"  placeholder="密码"/>
          	 <!-- 验证码输入 -->
          	 <div class="col-md-offset-6" style="margin-top:5px;">
          	 <input type="text" name="rand" class="form-control " id="inputSuccess"  placeholder="验证码">
          	  </div>
          	  <!-- 验证图片 -->
          	  	<div style="text-align:right;font-size:60%;margin-top:5px;">
          	  		<img name="randImage" id="randImage" src="image.jsp" width="60" height="20" border="1" >
					<a href="javascript:loadimage();" >换一张</a>
				</div>
          	  	<div style="text-align:right;">
          			 <a href="forgetPassword.jsp" style="margin-right=0;">忘记密码</a>&nbsp;&nbsp;<a href="regest.jsp" style="margin-right=0;">进入注册</a>
            	</div>
           		<select name = "loginway" style="" data-toggle="select" class=" col-md-6 select-primary mrs mbm col-md-offset-6">
					<option value = "individual_user" selected="selected">个人用户</option>
					<option value = "organization_user">组织用户</option>
					<option value = "administrator">管理员</option>				
				</select>
            <button class="btn btn-primary col-md-offset-9" type="submit">Login</button>
            <a class="login-link" href="http://www.bootcss.com/p/flat-ui/#">Lost your password?</a>
          </form>
          </div>
          	<!-- 提示信息 -->
          	<div style="color:red;"><h5>${error}</h5></div>
        </div>
      </div>
    </div> <!-- /container -->
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