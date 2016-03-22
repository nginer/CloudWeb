<%@ page contentType="text/html;charset=GBK" language="java" 
	import="java.io.*,java.awt.Image,java.awt.image.*,com.sun.image.codec.jpeg.*,java.sql.*,com.jspsmart.upload.*,java.util.*"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% 

	SmartUpload mySmartUpload =new SmartUpload();//创建对象，此对象自动获得传输的所有参数 
	long file_size_max=4000000; 
	String fileName2="",ext="",testvar=""; 
	String url="UploadFile\\"; //应保证在根目录中有此目录的存在（也就是说需要自己建立相应的文件夹） 
	//初始化 
	mySmartUpload.initialize(pageContext);
	//只允许上载此类文件 
	try { 
		mySmartUpload.setAllowedFilesList("jpg,gif");//此处的文件格式可以根据需要自己修改 
		//上载文件 
		mySmartUpload.upload(); 
		} catch (Exception e){ 
%> 
	<SCRIPT language=javascript> 
	
		alert("只允许上传.jpg和.gif类型图片文件"); 
		window.location='upload.jsp'; 
		
	</script> 
<% 
} 

	try{ 
	//获取
	String state = mySmartUpload.getRequest().getParameter("state");
	System.out.println(state);
	//获取提交的file
	com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0); 
	
	if (myFile.isMissing()){%> 
	
	<SCRIPT language=javascript> 
	
	alert("请先选择要上传的文件"); 
	
	window.location='upload.jsp'; 
	
	</script> 
	
	<%} 
	
	else{ 
	
	//String myFileName=myFile.getFileName(); //取得上载的文件的文件名 
	
	ext= myFile.getFileExt(); //取得后缀名 
	
	int file_size=myFile.getSize(); //取得文件的大小 
	
	String saveurl=""; 
	
	if(file_size<file_size_max){ 
	
	//更改文件名，取得当前上传时间的毫秒数值 
	
	Calendar calendar = Calendar.getInstance(); 
	
	String filename = String.valueOf(calendar.getTimeInMillis()); 
	
	saveurl=application.getRealPath("/")+url;   //绝对路径
	//System.out.println(saveurl);
	
	
	
	saveurl+=filename+"."+ext; //保存路径 
	System.out.println(saveurl);
	
	myFile.saveAs(saveurl,SmartUpload.SAVE_PHYSICAL); 
	
	out.print(saveurl); 
	
	String ret = "window.opener.document.form1.pic.focus();"; 
	
	ret += "var range = parent.HtmlEdit.document.selection.createRange();" ; 
	
	ret += "range.pasteHTML('<img src=\"" + request.getContextPath() + "/UploadFile/" + filename + "." + ext + "\">');" ; 
	
	ret += "alert('上传成功！');"; 
	
	ret += "window.location='upload.jsp';"; 
	
	
	out.print("<script language=javascript>window.opener.document.form1.picurl.value='"+"/UploadFile/" + filename + "." + ext+"'</script>"); 
	out.print("<script language=javascript>window.opener.document.form1.pic.src='"+basePath+"UploadFile/" + filename + "." + ext+"'</script>"); 
	out.print("<script language=javascript>window.close();</script>"); 
	} 
	
	} 
	
	}catch (Exception e){ 
	
	out.print(e.toString()); 
	
	} 
%> 
