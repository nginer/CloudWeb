<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>

<style type="text/css">

.input_fram{
	border:2px soild #a4a4a4;
	width:210px;
	height:33px;
	padding:px 5px 2px 5px;
	color:;
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
<!---->
<table width="1360" height="766" border="80" cellspacing="1" align="center" bordercolorlight=  bordercolordark=>
<thead bgcolor=>
	<tr height="90" >
		<td > </td>
	</tr>
</thead>

<tbody>
	<tr valign="top" height="600">
		<td width="100" align="center" bgcolor=>
		</td>
		<td width="1100"  bgcolor=>
			<table width="650" height="450" border="1" cellspacing="0"  align="center"  valign="middle" bgcolor=>
				<tr  width="650"height="100" border="1" cellspacing="0" align="center">
					<td><h2 style=font-size:40>&nbsp;&nbsp;文&nbsp;件&nbsp;上&nbsp;传&nbsp;&nbsp;></hr></td>
				</tr>
				<tr  height="600" border="1" cellspacing="0"  valign="top">
					<td>
						
						
						<form action="UpLoad.do" method="post" enctype="multipart/form-data">
						<!--action:form表单 action 属性需要设置为提交到后台处理文件上传的jsp文件地址。例如 uploadFile.jsp 程序文件用来处理上传的文件。-->
							<br/><br/><br/><br/>
							<label for="filename"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文件名称:</span ></label><input size="50" name="filename" class="input_fram" >
							<br/><br/><br/>
							<--<label for="filelocation"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文件位置&nbsp;&nbsp;:</span></label><input  type="file" name="filelocation" class="input_fram">-->
							<br/><br/><br/>
							
							<label for="filelocation"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文件位置&nbsp;&nbsp;:</span></label><input  type="file" name="myfiles" class="input_fram">
							<label for="competence"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权限设置:</span></label>
							<select name = "registerway">
							<option value = "open" selected="selected">公开</option>
							<option value = "close" >不公开</option>
							</select>
							
							<p>文件描述.</p>
							<textarea rows="10" cols="60">请输入描述信息</textarea>
							<input type="submit" value="完成">
							</form>
							<br/>
							<br/>
							<br/>
						<form action="fileSubmit.do" method="post" >
								<input type="submit" value="返回" />
						</form>>
					</td>
				</tr>
			</table>
		</td>
</tbody>
<tfoot bgcolor="#66FFFF">
	<tr align="center">
	<td height="30" colspan="2"><font bgcolor=#F5F5DC>版权信息</font></td>
	</tr>
</tfoot>
</body>
</html>