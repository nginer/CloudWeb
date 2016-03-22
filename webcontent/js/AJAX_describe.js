	//主要用于测试ajax及其学习，暂存
	//未做其他处理，是错误的。
	//暂且放一下。。。测试完成封装成JS文件保存并引入
	//创建ajax引擎
function getXmlHttpObject(){
	var xmlHttpRequest;
	xmlHttpRequest = new XMLHttpRequest(); 
	return xmlHttpRequest;
}
var myXmlHttpRequest = "";
var get = false;
function getProcessType(){
	//（1）创建XMLHttp对象。（2）设置请求方式。（3）调用回调函数。（4）发送请求。
		//得到引擎
	myXmlHttpRequest = getXmlHttpObject();
	console.log("dada");
		//设置第二条线的数据和参数
	if(myXmlHttpRequest){
		var url = "showCities.do";
		var data = "processType="+$('processType').value;
		console.log(data);
		//设置请求方式
		myXmlHttpRequest.open("post", url, true);
		myXmlHttpRequest.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded" );
		//指定回调函数
		//前后要不要加括号？？？！！！左边函数加括号会报错！！！
		myXmlHttpRequest.onreadystatechange=chuli;
		myXmlHttpRequest.send(data);
		
		
	}
}
	//第四条线的回调函数
	
function chuli(){
	if(get==true){
		return;}else{
		//判断是否取回数据，服务器controller那里给回的数据
		if(myXmlHttpRequest.readyState==4){
			if(myXmlHttpRequest.status==200){
				//取回数据，利用response。。。
					var aa = myXmlHttpRequest.responseText;
					var bb=aa.split(",");
				document.getElementById("test").innerText=aa+bb[2];
				
				//alert(bb.length);
				var select = document.getElementById("processType");
				//alert(select); 
				console.log(bb[0]);
			    select.length=0;
				for(var i=0;i<bb.length;i++){
					var option=document.createElement("option");
					//alert(option);
					//option.value=bb[i];
					option.innerText=bb[i];
					//select.options.add(option);
					select.appendChild(option);
					}
				get=true;
			}
		}
		}
	}
	

function $(id){
	return document.getElementById(id);
}
