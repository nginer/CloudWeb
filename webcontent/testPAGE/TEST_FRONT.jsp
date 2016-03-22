<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <title>首页！！！</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="<%=path%>/bootstrap/Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="<%=path%>/bootstrap/Flat-UI-master/dist/img/favicon.ico">
	<!-- 引入自定义的css文件 -->
	<link rel="stylesheet" href="<%=path%>/css/main.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/html5shiv.js"></script>
      <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/respond.min.js"></script>
    <![endif]-->
    
    <!-- 引入unslider插件 -->
    <script type="text/javascript" src="<%=path%>/js/unslider.js"></script>
	<link rel="stylesheet" href="<%=path%>/css/UnsliderStyle.css">
 	<script type="text/javascript">
 		$(function() {
 			$('.banner').unslider({
 				speed: 500,               //  The speed to animate each slide (in milliseconds)
 				delay: 3000,              //  The delay between slide animations (in milliseconds)
 				complete: function() {},  //  A function that gets called after every slide animation
 				keys: true,               //  Enable keyboard (left, right) arrow shortcuts
 				dots: true,               //  Display dot navigation
 				fluid: false              //  Support responsive design. May break non-responsive designs
 			});
 		});
 	</script>
  </head>
  <body>
  	<!-- unslider -->
  

      <div class="container">
      
      <div class="demo-headline">
        <h1 class="demo-logo">
          <div class="logo"></div>
          Flat UI
          <small>免费的WEB界面工具组件库</small>
        </h1>
      </div> <!-- /demo-headline -->


<!-- 第一行~~~ -->
      <div class="row demo-tiles">
        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/compass.png">
            <h3 class="tile-title">Web Oriented</h3>
            <p>100% convertable to HTML/CSS layout.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/infinity.png">
            <h3 class="tile-title">Easy to Customize</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/colors.png">
            <h3 class="tile-title">Color Swatches</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile tile-hot">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/share.png">
            <h3 class="tile-title">Free for Share</h3>
            <p>Your likes, shares and comments helps us.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>

        </div>
      </div> <!-- /tiles -->
      
<!-- 第二行~~~ -->

      <div class="row demo-tiles">
        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/compass.png">
            <h3 class="tile-title">Web Oriented</h3>
            <p>100% convertable to HTML/CSS layout.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/infinity.png">
            <h3 class="tile-title">Easy to Customize</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/colors.png">
            <h3 class="tile-title">Color Swatches</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile tile-hot">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/share.png">
            <h3 class="tile-title">Free for Share</h3>
            <p>Your likes, shares and comments helps us.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>

        </div>
      </div> <!-- /tiles -->
      
<!-- 第三行~~~ -->
      <div class="row demo-tiles">
        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/compass.png">
            <h3 class="tile-title">Web Oriented</h3>
            <p>100% convertable to HTML/CSS layout.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/infinity.png">
            <h3 class="tile-title">Easy to Customize</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/colors.png">
            <h3 class="tile-title">Color Swatches</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile tile-hot">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/share.png">
            <h3 class="tile-title">Free for Share</h3>
            <p>Your likes, shares and comments helps us.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.bootcss.com/p/flat-ui/#">Get Pro</a>
          </div>

        </div>
      </div> <!-- /tiles -->



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