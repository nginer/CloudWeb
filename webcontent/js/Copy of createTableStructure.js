
	var i=1;
	$(function(){
		addBtnFamilyEvent("b_addFamily");
		addBtnColumnEvent("b_addColumn0");
		});
	//为新添加的属于类classname的按钮添加响应事件
	function addBtnFamilyEvent(className){
		$("."+className).bind('click',function(){
			$("#submit").before("<div  class='h_family'>列族：<input type='text' name='cluster'  /><br />列  ：<input type='text' name='b_addColumn"+i+"' /><input type='button' class='b_addColumn' id='b_addColumn"+i+"' value='再添一列' /> <br /><input type='button' class='b_addFamily' value='再添加一个列族' /><br /></div>");
			$(this).hide();
			//给before中的相应的id的按钮添加相应事件
			addBtnFamilyEvent("b_addFamily");
			addBtnColumnEvent("b_addColumn"+i++);
			console.log("添加列族%%%%的按钮~~~~~~~~~~~~~~~~"+i);
			return;
		});
	}
	//为id为columnName的按钮添加响应事件
	function addBtnColumnEvent(columnIdName){
		$("#"+columnIdName).bind('click',function(){
			$(this).before("<input type='text' class='h_column' value='再添一列' name='"+columnIdName+"'/>");
			//$(this).hide();
			console.log("添加列的按钮~~~~~~~~~~~~~~~~"+i);
		});
	}
