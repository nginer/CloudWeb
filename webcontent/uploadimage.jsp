<%@ page contentType="text/html;charset=GBK" language="java" 
	import="java.io.*,java.awt.Image,java.awt.image.*,com.sun.image.codec.jpeg.*,java.sql.*,com.jspsmart.upload.*,java.util.*"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% 

	SmartUpload mySmartUpload =new SmartUpload();//�������󣬴˶����Զ���ô�������в��� 
	long file_size_max=4000000; 
	String fileName2="",ext="",testvar=""; 
	String url="UploadFile\\"; //Ӧ��֤�ڸ�Ŀ¼���д�Ŀ¼�Ĵ��ڣ�Ҳ����˵��Ҫ�Լ�������Ӧ���ļ��У� 
	//��ʼ�� 
	mySmartUpload.initialize(pageContext);
	//ֻ�������ش����ļ� 
	try { 
		mySmartUpload.setAllowedFilesList("jpg,gif");//�˴����ļ���ʽ���Ը�����Ҫ�Լ��޸� 
		//�����ļ� 
		mySmartUpload.upload(); 
		} catch (Exception e){ 
%> 
	<SCRIPT language=javascript> 
	
		alert("ֻ�����ϴ�.jpg��.gif����ͼƬ�ļ�"); 
		window.location='upload.jsp'; 
		
	</script> 
<% 
} 

	try{ 
	//��ȡ
	String state = mySmartUpload.getRequest().getParameter("state");
	System.out.println(state);
	//��ȡ�ύ��file
	com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0); 
	
	if (myFile.isMissing()){%> 
	
	<SCRIPT language=javascript> 
	
	alert("����ѡ��Ҫ�ϴ����ļ�"); 
	
	window.location='upload.jsp'; 
	
	</script> 
	
	<%} 
	
	else{ 
	
	//String myFileName=myFile.getFileName(); //ȡ�����ص��ļ����ļ��� 
	
	ext= myFile.getFileExt(); //ȡ�ú�׺�� 
	
	int file_size=myFile.getSize(); //ȡ���ļ��Ĵ�С 
	
	String saveurl=""; 
	
	if(file_size<file_size_max){ 
	
	//�����ļ�����ȡ�õ�ǰ�ϴ�ʱ��ĺ�����ֵ 
	
	Calendar calendar = Calendar.getInstance(); 
	
	String filename = String.valueOf(calendar.getTimeInMillis()); 
	
	saveurl=application.getRealPath("/")+url;   //����·��
	//System.out.println(saveurl);
	
	
	
	saveurl+=filename+"."+ext; //����·�� 
	System.out.println(saveurl);
	
	myFile.saveAs(saveurl,SmartUpload.SAVE_PHYSICAL); 
	
	out.print(saveurl); 
	
	String ret = "window.opener.document.form1.pic.focus();"; 
	
	ret += "var range = parent.HtmlEdit.document.selection.createRange();" ; 
	
	ret += "range.pasteHTML('<img src=\"" + request.getContextPath() + "/UploadFile/" + filename + "." + ext + "\">');" ; 
	
	ret += "alert('�ϴ��ɹ���');"; 
	
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
