$(document).ready(function(){
	var send_str_docVO = ${send_str_docVO};
	$.ajax({
		type:"POST",
		async:true,
		url:"http://10.10.167.146:8080/WebGIS/Service",
		data:send_str_docVO,
		success:function(urlGIS){
			/* 来自成杰的urlGIS */
			alert("fuck");
			$.post(
				"/cloudWeb/saveServiceURL",{urlGIS:urlGIS}
			);
			//将这个url写入到数据库webservice表项中
			$("#showGIS").attr("src",urlGIS);
		}
	});
	
});
