

<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8"">

<title>�û���¼</title>

			<script language="javascript"> 
					function loadimage(){ 
					document.getElementById("randImage").src = "image.jsp?"+Math.random(); 
					} 
			</script> 
			
<style type="text/css">

.position1{
		width:686px;
		height:281px;
		border:6px  solid;
		position:absolute;
		left:296px;
		top:191px;
		border-color=#000000;
		}

span{
	font-family:"����";
 	font-size:100px;	
    }
</style>

</head>
<body>
<!---->
<a>head��<jsp:include  page="head.jsp"/></a>

${error }
<table width="1360" height="766" border="10"  cellspacing="1" align="center">
	<tr height="144" width="1360" align="center">
		<td style="font-color:#E9967A;font-size:50px;">��¼����</td>
	</tr>
	<tr height="582" width="1360">
	<td>
			<table width="686" height="281" border="3"   class="position1" >
				<tr>
					<td width="248" height="281" >
							˵��
					</td>
					<td width="438" height="281" >
							<form action="login.do" method="post">
								<p style="font-size:20px;">&nbsp;&nbsp;�û���: <input type="text" name="username" /></p>
								<a href="regest.jsp">����ע��</a>
								<p style="font-size:20px;">&nbsp;&nbsp;��&nbsp;&nbsp;��: <input type="text" name="password" /></p>	
								<a href="forgetPassword.jsp">��������</a>
								
								<p><input type="text" name="rand" size="15"></p> 
								
								<p width="138" valign="middle" align="center"><img alt="code..." name="randImage" id="randImage" src="image.jsp" width="60" height="20" border="1" align="absmiddle"></p> 
								<p height="36" colspan="2" align="center" valign="middle"><a href="javascript:loadimage();"><font class=pt95>���������</font></a></p> 	
															
								</p>
								<!-- <img src=${sessionScope.code.sb1} width="85" height="29" /> -->
								<select name = "loginway">
								<option value = "individual_user" selected="selected">�����û�</option>
								<option value = "organization_user">��֯�û�</option>
								<option value = "administrator">����Ա</option>				
								</select>
								<input type="submit" value="Submit" /></input>
						</form>

   
					</td>
				</tr>
			</table>	
	</td>
	</tr>
	
	<tr height="40" width="1360" align="center">
		<td style="font-color:#696969">��Ȩ��Ϣ</td>
	</tr>



</table>
</body>
</html>