<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
<html>  
  <head>  
    <title>��֤��У��</title>  
  </head>  
     
  <body>  
    <%  
        String checkcode=request.getParameter("checkCode");  
        if(checkcode.equals("")||checkcode==null){  
            out.print("<script>alert('��������֤��');window.location.href('index.jsp')</script>");  
        }else{  
            if(!checkcode.equalsIgnoreCase((String)session.getAttribute("randCheckCode"))){  
                out.print("<script>alert('��֤�벻��ȷ,����������');history.back(-1);</script>");  
            }else{  
                out.print("��¼�ɹ�");  
            }  
        }  
     %>  
  </body>  
</html>