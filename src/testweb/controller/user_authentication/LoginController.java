package testweb.controller.user_authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;

import testweb.dao.impl.UserDaoImpl;
import testweb.vo.User;

@Controller
public class LoginController extends AbstractController {

	

	@RequestMapping("/login")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		//从html获取数据
		String username=request.getParameter("username");	
		
		String password=request.getParameter("password");
		
		String loginway=request.getParameter("loginway");
		
		String captcha=request.getParameter("rand");
		
		String DBcaptcha = "aaa";
		
		HttpSession session1 = request.getSession();
		
		DBcaptcha = (String) session1.getAttribute("rand");
		
		Map<String ,Object> model=new HashMap<String,Object>();
		
		
		if(!captcha.equals(DBcaptcha)){
			
			model.put("error", "验证码错误！！！");
			
			ModelAndView modelAndView =new ModelAndView("login",model);
		
			return  modelAndView;
		
			
		}
		
		else{
			//连接数据库
			UserDaoImpl impl1 = new UserDaoImpl();
		
			User user = new User();
				
			user = impl1.getUserByName(username);
				
			String DBpassword = user.getPassword();
		
			String DBloginway = user.getGroup();
		
			// 数据库存在该用户名                                     &&      密码正确              &&   验证码正确
			 if(!impl1.SearchUsername(username) && password.equals(DBpassword) && loginway.equals(DBloginway)){

				 
				 if(loginway.equals("individual_user"))
				 {
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(60*60*2);
						session.setAttribute("user", user);
						String pathFORupload = user.getClass().getClassLoader().getResource("").getPath().toString();
						pathFORupload = pathFORupload.substring(1,pathFORupload.length()-15)+"/users";
						System.out.println(pathFORupload+"***********到users目录的路径");
						session.setAttribute("pathFORupload",pathFORupload);
						ModelAndView modelAndView =new ModelAndView("service1",model);
				 
						return  modelAndView;
				 }
				 else if(loginway.equals("organization_user"))
				 {
						HttpSession session = request.getSession();
						
						session.setAttribute("user", user);
						
						ModelAndView modelAndView =new ModelAndView("Organizationcenter",model);
				 
						return  modelAndView;
				 }				 
				 else if(loginway.equals("administrator") )
				 {
					 System.out.println("44333333333334");
						HttpSession session = request.getSession();
						
						session.setAttribute("user", user);
						
						ModelAndView modelAndView =new ModelAndView("admin",model);
				 
						return  modelAndView;
				 }				 
				 else 
				 {
						
					 	System.out.println("4444444444444");
					 
						ModelAndView modelAndView =new ModelAndView("admin",model);
				 
						return  modelAndView;
				 }				 			 

			}
	
			else if(impl1.SearchUsername(username))
			{					
			
				model.put("error","用户名不存在！");	
			
				ModelAndView modelAndView =new ModelAndView("login",model);
			
				return  modelAndView;
			}	
			
			else if(!password.equals(DBpassword))
			{
			
				model.put("error", "密码错误");
			
				ModelAndView modelAndView =new ModelAndView("login",model);
			
				return  modelAndView;
			}
		
			else if(!loginway.equals(DBloginway))
			{
		
				model.put("error", "登录方式错误！！");
			
				ModelAndView modelAndView =new ModelAndView("login",model);
			
				return  modelAndView;
			}
		
			else
			{
			
			model.put("error", "登录失败！！！");
			
			ModelAndView modelAndView =new ModelAndView("login",model);
			
			return  modelAndView;
			
			}
		}
		
	}
	
}


