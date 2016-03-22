<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户修改信息</title>

<style type="text/css">

.input_fram{
	border:2px soild #a4a4a4;
	width:210px;
	height:33px;
	padding:px 5px 2px 5px;
	color:#FF0000;
}

.item {
    float: left;
    text-align: right;
    width: 179px;
    padding-right: 10px;
    height: 44px;
    padding-top: 6px;
    line-height: 20px;
    font-size: 14px;
}

span{
		font-size:25px;
}
</style>




</head>

<body>

<a>head：<jsp:include  page="head.jsp"/></a>
<!---->
<table width="1360" height="766" border="80" cellspacing="1" align="center" bordercolorlight="#F5F5DC" bordercolordark="#F5F5DC">
<thead bgcolor=>
	<tr height="90" >
		<td > </td>
	</tr>
</thead>

<tbody>
	<tr valign="top" height="600">
		<td width="100" align="center" bgcolor=#F5F5DC>
			<table width="135" height="180" border="1" cellspacing="0" bgcolor=F0F8FF>
				<tr width="100" height="50">
					<td></td>
				</tr>
				<tr width="100" height="50">
					<td></td>
				</tr>
				<tr width="100" height="50">
					<td></td>
				</tr>
				<tr width="100" height="50">
					<td></td>
				</tr>
			</table>
		</td>
		<td width="1100"  bgcolor=#F5F5DC>
			<table width="650" height="450" border="1" cellspacing="0"  align="center"  valign="middle" bgcolor=#CCFFCC>
				<tr  width="650"height="100" border="1" cellspacing="0" align="center">
					<td><h2 style=font-size:40>&nbsp;&nbsp;信&nbsp;息&nbsp;修&nbsp;改&nbsp;&nbsp;></hr></td>
				</tr>
				<tr  height="600" border="1" cellspacing="0"  valign="top">
					<td>
					<${info}>
						<form action="regestModify.do">
							<br/><br/><br/><br/>
							<p>用户名：</p>
							<p>${sessionScope.user.user_name}</p>
							<label for="password"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;原密&nbsp;&nbsp;&nbsp;&nbsp;码:</span></label><input class="input_frame" type="password"class="input_fram" name="originpassword" size="20" maxlength="8">
							<br/><br/><br/>

						
							<label for="email"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email&nbsp;&nbsp;:</span></label><input  type="text" name="email" class="input_fram" placeholder="example@domain.com">
							<br/><br/><br/>
							<label for="password"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新密&nbsp;&nbsp;&nbsp;&nbsp;码:</span></label><input class="input_frame" type="password"class="input_fram" name="newpassword" size="20" maxlength="8">
							<br/><br/><br/>
							<label for="qupassword"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认密码:</span></label><input type="password"class="input_fram" name="qupassword" size="20" maxlength="8">
							<br/><br/><br/>
							<label for="mobilephone"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号码&nbsp;&nbsp;:</span></label><input  type="text" name="mobilephone" class="input_fram" >
							<br/><br/><br/>
						
							<input type="submit" value="提交">
							
						</form>
					
						<form action="regestturn.do" method="post">
						
							<input type="submit" value="返回">
							</select>
						</form>
					</td>
				</tr>
			</table>
		</td>
</tbody>
<tfoot bgcolor="#66FFFF">
	<tr align="center">
	<td height="30" colspan="2"><font bgcolor=#F5F5DC>ѦȨхϢ</font></td>
	</tr>
</tfoot>
</body>
</html>