<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
<html>  
  <head>  
    <title>验证码校验</title>  
  </head>  
     
  <body>  
    <%  
        String checkcode=request.getParameter("checkCode");  
        if(checkcode.equals("")||checkcode==null){  
            out.print("<script>alert('请输入验证码');window.location.href('index.jsp')</script>");  
        }else{  
            if(!checkcode.equalsIgnoreCase((String)session.getAttribute("randCheckCode"))){  
                out.print("<script>alert('验证码不正确,请重新输入');history.back(-1);</script>");  
            }else{  
                out.print("登录成功");  
            }  
        }  
     %>  
  </body>  
</html>