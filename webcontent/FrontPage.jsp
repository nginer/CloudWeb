<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>云平台首页</title>
<!-- 引入bootstrap -->
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
<!-- 引入bootstrap -->
<link rel="stylesheet" href="<%=path%>/css/main.css">
<script src="<%=path%>/js/jquery-1.11.3.js"></script>
<!-- 引入unslider插件 -->
<script type="text/javascript" src="<%=path%>/js/unslider.js"></script>
<link rel="stylesheet" href="<%=path%>/css/UnsliderStyle.css">
 	<script type="text/javascript">
 	$(function() {
 		$('.banner').unslider({
 			speed: 500,               //  The speed to animate each slide (in milliseconds)
 			delay: 2500,              //  The delay between slide animations (in milliseconds)
 			complete: function() {},  //  A function that gets called after every slide animation
 			keys: true,               //  Enable keyboard (left, right) arrow shortcuts
 			dots: true,               //  Display dot navigation
 			fluid: false              //  Support responsive design. May break non-responsive designs
 		});
 	});
 	</script>
 	
 <!-- 引入unslider插件完毕 -->
 
</head>
<body style="padding-top:0px;">
		<div class="banner" id="b04" >
			<ul>
				<li style="background-image: url('<%=path%>/img/yuanyang.png');">
					<div class="inner">
						<h1>元阳梯田</h1>
						<p>就是这个不到3kb的插件！没有奇特的特效或无用的标签。</p>

						<a class="btn" href="#download">关注详情</a>
					</div>
				</li>

				<li style="background-image: url('<%=path%>/img/shilin.png');">
					<div class="inner">
						<h1>石林</h1>
						<p>Use any HTML in your slides, extend with CSS. You have full control.</p>

						<a class="btn" href="#download">关注详情</a>
					</div>
				</li>

				<li style="background-image: url('<%=path%>/img/poshui.png');">
					<div class="inner">
						<h1>泼水节</h1>
						<p>Unslider的所有源码都托管在GitHub上。</p>

						<a class="btn" href="//github.com/idiot/unslider">关注详情</a>
					</div>
				</li>

				<li style="background-image: url('<%=path%>/img/menggu.png');">
					<div class="inner">
						<h1>蒙古草原</h1>
						<p>I just wanted to show you another slide.</p>
						<a class="btn" href="#download">关注详情</a>
					</div>
				</li>
			</ul>
		</div>
		<br>
<br>
<div style="text-align: right;padding-right:15px;"><button type="button" class="btn btn-success" onclick="window.location='<%=path%>/login.jsp'">用户中心</button></div>

<div class="container">
	<!-- 几排图标~~~~~ -->
	
<!-- 第一行~~~ -->
      <div class="row demo-tiles">
        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/Aesthetic.png">
            <h3 class="tile-title">美学Aesthetic</h3>
            <p><br>100% convertable to HTML/CSS layout.100% conve </p>
            <a class="btn btn-primary btn-large btn-block" href="Aesthetic.do">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/AncientLiterature.png" >
            <h3 class="tile-title">古籍文献AncientLiterature</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="AncientLiterature.do">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/Architecture.png">
            <h3 class="tile-title">建筑Architecture</h3>
            <p><br>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="Architecture.do">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile tile-hot">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/ArtAndAestheticValue.png">
            <h3 class="tile-title">村寨建筑艺术与美学价值ArtAndAestheticValue</h3>
            <p>Your likes, shares and comments helps us.</p>
            <a class="btn btn-primary btn-large btn-block" href="ArtAndAestheticValue.do">查看本领域相关服务</a>
          </div>

        </div>
      </div> <!-- /tiles -->
      
<!-- 第二行~~~ -->

      <div class="row demo-tiles">
        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/Ecosystem.png">
            <h3 class="tile-title">村寨与自然生态和谐Ecosystem</h3>
            <p>100% convertable to HTML/CSS layout.</p>
            <a class="btn btn-primary btn-large btn-block" href="Ecosystem.do">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/ShapeAndStyle.png">
            <h3 class="tile-title">村寨形态与营建工艺特色ShapeAndStyle</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="ShapeAndStyle.do">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/sports.png">
            <h3 class="tile-title">体育Sports</h3>
            <p><br>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="Sports.do">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile tile-hot">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/VillageArchitecturalCulture.png">
            <h3 class="tile-title">村寨建筑文化VillageArchitecturalCulture</h3>
            <p>Your likes, shares and comments helps us.</p>
            <a class="btn btn-primary btn-large btn-block" href="VillageArchitecturalCulture.do">查看本领域相关服务</a>
          </div>

        </div>
      </div> <!-- /tiles -->
      
<!-- 第三行~~~ -->
      <div class="row demo-tiles">
        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/compass.png">
            <h3 class="tile-title">村寨建筑文化VillageArchitecturalCulture</h3>
            <p>100% convertable to</p>
            <a class="btn btn-primary btn-large btn-block" href="VillageArchitecturalCulture.do">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/infinity.png">
            <h3 class="tile-title">Easy to Customize</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.muc.edu.cn/">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile">
            <img class="tile-image" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/colors.png">
            <h3 class="tile-title">Color Swatches</h3>
            <p>Vector-based shapes and minimum of layer styles.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.muc.edu.cn/">查看本领域相关服务</a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="tile tile-hot">
            <img class="tile-image big-illustration" alt="" src="<%=path%>/bootstrap/Flat-UI-master/img/HomePage/share.png">
            <h3 class="tile-title">Free for Share</h3>
            <p>Your likes, shares and comments helps us.</p>
            <a class="btn btn-primary btn-large btn-block" href="http://www.muc.edu.cn/">查看本领域相关服务</a>
          </div>

        </div>
      </div> <!-- /tiles -->
		<!-- 几排图标~~~~~ -->
</div>	
<!-- bootstrap页面下部的文件 -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   <%-- Jquery文件冲突，版本不兼容
    <script src="<%=path%>/bootstrap/Flat-UI-master/dist/js/vendor/jquery.min.js"></script>   
    --%>
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
<!-- bootstrap页面下部的文件结束 -->
</body>
</html>