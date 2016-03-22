<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入bootstrap -->
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
<!-- 引入bootstrap头结束 -->
<script src="<%=path%>/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
//这里其实应该写jquery 的 ajax ，更简洁
	var i=0;
	//文档加载完毕后，执行如下操作。

	$(function(){
		$("#it").bind('click',function(){
			alert("shibabbbbbb");
			$("#dataInput").attr("src","http://www.csdn.net/");
		});
		$("#btnReflect").bind('click',function(){
			console.log("````````````````这可是一开始"+(++i));
			$("#btnReflect").before("<div id='"+i+"'><select name='S_family' id='S_family'><option value='family'>Family</option><c:forEach items='${familyName}' var='familyN' varStatus='status'><option value='${familyN}'>${familyN}</option></c:forEach></select><select id='S_column' name='S_column'><option value='col'>Column</option></select><input type='text' name='FC' readonly/> 《==========》 <input type='text' name='itemName' /></div>");

			addRefelectEvent(i);
			});
		addRefelectEvent(0);
		});
		
		function addRefelectEvent(divID){
			$("#"+divID).children().eq(1).change(function(){
				//格式：列族名，列名
				var text1=$("#"+divID).children().eq(0).val()+","+ $("#"+divID).children().eq(1).val();
			
				$("#"+divID).children().eq(2).val(text1);

			});
			$("#"+divID).children().eq(0).change(
					function(){
						//命名：s_代表select选择的
						var s_family=$("#"+divID).children().eq(0).val();
						var s_index=$("#"+divID).children().eq(0).get(0).selectedIndex;
						//判断语句：判断s_family的值来指定后面列下拉框的内容,选中的第s_index个
						//family的值对应list的column数组集的第s_index个数组
						//因为第一个option设定的为一个类似注释的词，选定这个不需要有响应,直接返回
						//另外，增加这一项后，后面的对应index需要减一
						if(s_index==0){ 
							$("#"+divID).children().eq(1).empty();
							return;
						}
						//得到后台的json串
						var temp = ${Jcolumn};
						//将串转换为数组对象
						//var list_column=eval("("+temp+")");
						var list_column=eval(temp);
						//对数组对象进行操作
						//第s_index个数组
						var stringA = list_column[s_index-1];
						console.log(list_column);
						//首先置空column的下拉框
						$("#"+divID).children().eq(1).empty();
						
						//遍历数组，向后面的下拉框中追加值
						$("#"+divID).children().eq(1).append("<option value='column'>Column</option>");
						$.each(stringA,function(index,val){
							console.log('对应的索引：'+index+'对应的值：'+val+'~~~~~~~~');
							$("#"+divID).children().eq(1).append("<option value='"+val+"'>"+val+"</option>");
						});
					
						console.log("选择的列族是"+s_family);
						console.log("选定列族的下标是"+s_index);
						console.log("传给晓栋大坑的那个xml的串！！！！！\n"+'method=careteTable&ak=admin&xml='+send_str_docVO);
						//console.log("fffffffffffffffffffff"+${familyName});
						}
				);
			}
		$(function(){
			//在这里搞AJAX，发送xml，之后获得返回值url，将url在一个iframe里面显示。
			//数据录入端。
			var send_str_docVO = ${send_str_docVO};
			$.ajax({
				type:"POST",
				async:true,
				url:"http://192.168.100.14:8080/HBaseService/TableOperation1",
				//url:"",
				data:'method=careteTable&ak=admin&xml='+send_str_docVO,
				success:function(urlDataInput){
					alert("sucess！！！！");
					$("#dataInput").attr("src","http://10.10.139.13:8080/DataInput/login.jsp");
					//$("#dataInput").attr("src","http://www.csdn.net/");
				}
			});
		});		
</script>
<title>数据程序映射</title>
</head>
<body>
<div class="container">
<!-- 测试数据 -->
<%-- *********************************本页面暂且搁置，等数据录入端完成后继续整合（将数据录入端的url放入iframe中即可）***********************************
来自W2DB_data的数据：${third}<br>
JSON的family${Jfamily} <br>
JSON的column ${Jcolumn}<br>
here~~~~~~~~~~~~~~~~~~~~~~${familyName}<br>
there~~~~~~~~~~~~~~~~~~~~~~${columnName}<br> --%>
<!-- 创建一个iframe，用于显示数据录入端 -->
<div style="text-align:center;"><h6>数据录入端</h6></div>
<iframe id="dataInput" src="//www.baidu.com" frameborder="1" width="1100" height="800"></iframe><br>
<input type="button" id ="it" value="更改iframe中内容"/><br>
	进行列和最终显示条目的映射<br />
    <form action="W2XML_reflectD.do" method="post">
    	<div id="0">
  
    	<select name="S_family" id="S_family" >
    		<option value="family">Family</option>
    		<c:forEach items="${familyName}" var="familyN" varStatus="status"> 
            	<option value="${familyN}">${familyN}</option>
            </c:forEach>         
    	</select>
        <select  name="S_column" id="S_column">
        	<option value="col">Column</option>
        </select>
        
        <input type="text" name="FC" readonly/> 《==========》 <input type="text" name="itemName" /> 
        </div>
         <button type="button" class="btn btn-primary btn-sm" id="btnReflect">下一组映射关系</button>
        
    <br /><br /><br />
   
    进行服务与程序的映射
    <select id="programReflection" name="programReflection" data-toggle="select" class="form-control select select-primary mrs mbm">
    	<c:forEach items="${programList}" var="type" varStatus="status" >
    		<option value="${type.getProgram_name()},${type.getProgram_ID()}">${type.getProgram_name()}</option>
    	</c:forEach>
    </select>	<br />
    进行服务于数据的映射
    <select id="programReflection" name="dataReflection" data-toggle="select" class="form-control select select-primary mrs mbm">
    	<c:forEach items="${dataList}" var="type" varStatus="status" >
    		<option value="${type.getData_name()},${type.getData_ID()}">${type.getData_name()}</option>
    	</c:forEach>
    </select>	<br />
    <input type="hidden" name="tableName" value="${tableName}">
      <button class="btn btn-primary" type="submit">映射完毕</button>
    </form>  
    <!--这些数据来自XML文件-->
</div>
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