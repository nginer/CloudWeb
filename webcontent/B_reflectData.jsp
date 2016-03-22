<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=path%>/js/jquery-1.4.3.js"></script>
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
			
			//这里写bind还是直接.change()?????
			addRefelectEvent(i);
			/* $("#"+i).children().eq(0).change(function(){
				var s_family=$("#"+i).children().eq(0).val();
				var s_index=$("#"+i).children().eq(0).get(0).selectedIndex;
				if(s_index==0){
					$("#"+i).children().eq(1).empty();
					 return;
				}
				var temp = ${Jcolumn};
				var list_column=eval(temp);
				console.log(i+"``````````````````````");
				console.log(s_index+"------------");
				console.log(s_family+"------------");
				var stringA=list_column[s_index-1];
				console.log("``````````这里是对新加入的div进行事件绑定！！！");
				$("#"+i).children().eq(1).empty();
				$.each(stringA,function(index,val){
					console.log('对应的索引：'+index+'对应的值：'+val+'~~~~~~~~');
					$("#"+i).children().eq(1).append("<option value='"+val+"'>"+val+"</option>");
				});
				}); */
			});
		addRefelectEvent(0);
		
	/* 	$("#S_family").change(
			function(){
				//命名：s_代表select选择的
				var s_family=$("#S_family").val();
				var s_index=$("#S_family").get(0).selectedIndex;
				//判断语句：判断s_family的值来指定后面列下拉框的内容,选中的第s_index个
				//family的值对应list的column数组集的第s_index个数组
				//因为第一个option设定的为一个类似注释的词，选定这个不需要有响应,直接返回
				//另外，增加这一项后，后面的对应index需要减一
				if(s_index==0){ 
					$("#S_column").empty();
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
				$("#S_column").empty();
				//遍历数组，向后面的下拉框中追加值
				
				$.each(stringA,function(index,val){
					console.log('对应的索引：'+index+'对应的值：'+val+'~~~~~~~~');
					$("#S_column").append("<option value='"+val+"'>"+val+"</option>");
				});
			
				console.log("选择的列族是"+s_family);
				console.log("选定列族的下标是"+s_index);
				//console.log("fffffffffffffffffffff"+${familyName});
				}
		); */
		});
		
		function addRefelectEvent(divID){
			$("#"+divID).children().eq(1).change(function(){
				//格式：列族名，列名
				var text1=$("#"+divID).children().eq(0).val()+","+ $("#"+divID).children().eq(1).val();
				//alert(text1);
			
				$("#"+divID).children().eq(2).val(text1);
				//alert($("#"+divID).children().eq(2).val());
				//$("#"+divID).children().eq(2).hide();
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
*********************************本页面暂且搁置，等数据录入端完成后继续整合（将数据录入端的url放入iframe中即可）***********************************
来自W2DB_data的数据：${third}<br>
JSON的family${Jfamily} <br>
JSON的column ${Jcolumn}<br>
here~~~~~~~~~~~~~~~~~~~~~~${familyName}<br>
there~~~~~~~~~~~~~~~~~~~~~~${columnName}<br>
<!-- 创建一个iframe，用于显示数据录入端 -->
<iframe id="dataInput" src="//www.baidu.com" frameborder="1" width="1100" height="800"></iframe><br>
<input type="button" id ="it" value="更改iframe中内容"/><br>
	进行列和最终显示条目的映射<br />
    <form action="W2XML_reflectD.do" method="post">
    	<div id="0">
    	<select name="S_family" id="S_family">
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
        <input type="button" id="btnReflect" value="下一组映射关系"/>
    <br /><br /><br />
    
    进行服务与程序的映射
    <select id="programReflection" name="programReflection">
    	<c:forEach items="${programList}" var="type" varStatus="status" >
    		<option value="${type.getProgram_name()},${type.getProgram_ID()}">${type.getProgram_name()}</option>
    	</c:forEach>
    </select>	<br />
    进行服务于数据的映射
    <select id="programReflection" name="dataReflection">
    	<c:forEach items="${dataList}" var="type" varStatus="status" >
    		<option value="${type.getData_name()},${type.getData_ID()}">${type.getData_name()}</option>
    	</c:forEach>
    </select>	<br />
    <input type="hidden" name="tableName" value="${tableName}">
    <input type="submit" value="映射完毕" />
    </form>
    
    <!--这些数据来自XML文件-->
</body>
</html>