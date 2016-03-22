
package testweb.controller.user_authentication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.dao.impl.UserDaoImpl;
import testweb.vo.User;

@Controller
public class registModifyController extends AbstractController{

	//修改信息控制
	@RequestMapping("/regestModify")
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response){
		
		//这里的（）中的名字就是从jsp页面传过来的参数
		
		String originpassword=request.getParameter("originpassword");
		
		String email=request.getParameter("email");
		
		String newpassword=request.getParameter("newpassword");
		
		String qupassword=request.getParameter("qupassword");
		
		String mobilephone=request.getParameter("mobilephone");
		
		String message1 = "";
		
		String registerid = "";
		Map<String ,Object> model=new HashMap<String,Object>();
		
		UserDaoImpl impl1 = new UserDaoImpl();
		
		User user1 = new User();
		
		//获取session
		HttpSession session1 = request.getSession();
		
		user1 = (User) session1.getAttribute("user");
		
		//user1是session中的
		
		
		ModelAndView modelAndView = new ModelAndView();
		//如果用户注册成功，则跳转到个人中心。
		//如果原密码与session中密码一样                                          &&    不存在email                                                   &&  密码一样                                                      &&  手机号不为空 
		if (!originpassword.equals(user1.getPassword())  ||   email == null ||email.equals("")  ||  newpassword == null || newpassword.equals("")  ||
				mobilephone == null || mobilephone.equals("")   ||   !impl1.SearchEmail(email)  ||  !newpassword.equals(qupassword)  ||  !checkMobileNumber(mobilephone) ||!checkEmail(email))
			{
				 if(!newpassword.equals(qupassword))
				{
					
				model.put("error", "确认密码与原密码不相同！");	
				
				message1 = "确认密码与原密码不相同";
				}	
				 
				 else if(!originpassword.equals(user1.getPassword()))
				 {
					 model.put("error", "新密码与原密码不一致！！");
					 	
					message1 = "新密码与原密码不一致！！";
				 }
				 else  if(email == null || email.equals(""))
				{			
					model.put("error", "email不能为空");	
					
					message1 = "email不能为空";

				}
				 //判断用户名是否为空
				 else if(newpassword == null || newpassword.equals(""))
				{			
					model.put("error", "password不能为空");	
					
					message1 = "密码不能为空";

				}
				 //判断用户名是否为空
				 else if(mobilephone == null || mobilephone.equals(""))
				{			
					model.put("error", "mobilephone不能为空");	
					
					message1 = "手机号码不能为空";

				}
			
				 //如果邮箱存在提示
				 else if(!impl1.SearchEmail(email))
				{		
					
					model.put("error", "邮箱已注册！");	
					
					message1 = "邮箱已注册！";
				}	
			 
				 else if(!checkEmail(email))
				{
					 model.put("error", "邮箱格式不正确");	
				
					 message1 = "邮箱格式不正确";							
				
				}

				 else if(!checkMobileNumber(mobilephone))
				 {
				model.put("error", "手机号码不正确！！！");	
			
				message1 = "手机号码不正确！！！";							
			
			}
			
			request.setAttribute("message1", message1);
			
			modelAndView = new ModelAndView("regestModify1",model);	
			
			
		}
		
		 //如果用户名存在提示
			else if(originpassword.equals(user1.getPassword()) && newpassword.equals(qupassword) && impl1.SearchEmail(email) &&  newpassword.equals(qupassword) && !mobilephone.equals(null) && checkMobileNumber(mobilephone) && checkEmail(email))
			{


				UserDaoImpl impl = new UserDaoImpl();
		
				User user = new User();
		
				user.setUser_name(user1.getUser_name());
		
				user.setEmail(email);
				
				user.setPassword(newpassword);
		
				user.setTel(mobilephone);
				
				 impl.UpdateUser(user); 

					//添加session 
					HttpSession session = request.getSession();

					session.setAttribute("user", user);

					message1 = "用户信息修改成功！！！你好"+user1.getUser_name();
		
					request.setAttribute("message1", message1);
		
					modelAndView =new ModelAndView("regestModify1",model);
			}
		
			return  modelAndView;

		}

		/**
		 * 验证邮箱
		 * @param email
		 * @return
		 */
		public static boolean checkEmail(String email){
			boolean flag = false;
			try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
			return flag;
		}
     
		/**
		 * 验证手机号码
		 * @param mobiles
		 * @return
		 */
		public static boolean checkMobileNumber(String mobileNumber){
			boolean flag = false;
			try{
                Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
                Matcher matcher = regex.matcher(mobileNumber);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
			return flag;
		}
}









	