
	var i=1;
	$(function(){
		addBtnFamilyEvent("b_addFamily");
		addBtnColumnEvent("b_addColumn0");
		});
	//为新添加的属于类classname的按钮添加响应事件
	function addBtnFamilyEvent(className){
		$("."+className).bind('click',function(){
			$("#submit").before("<div  class='h_family'>列族：<input type='text' class='form-control' name='cluster' />列  ：<input type='text' class='form-control' name='b_addColumn"+i+"' /><button type='button' class='b_addColumn btn btn-primary btn-sm' id='b_addColumn"+i+"'>再添一列</button> <button type='button' class='b_addFamily btn btn-primary btn-sm' >再添加一个列族</button><br /></div><br />");
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
			$(this).before("<input type='text' class='h_column' name='"+columnIdName+"'/>");
			//$(this).hide();
			console.log("添加列的按钮~~~~~~~~~~~~~~~~"+i);
		});
	}
