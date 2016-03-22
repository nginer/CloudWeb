
package testweb.controller.user_authentication;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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

import com.test.file_operation.HandleFile;

import testweb.controller.construction.createServiceController;
import testweb.dao.impl.UserDaoImpl;
import testweb.vo.User;

@Controller
public class RegisterController extends AbstractController{

	@RequestMapping("/regest")
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response){
		
				//这里的（）中的名字就是从jsp页面传过来的参数
				String username=request.getParameter("username");
		
				String email=request.getParameter("email");
		
				String password=request.getParameter("password");
		
				String qupassword=request.getParameter("qupassword");
				
				String mobilephone=request.getParameter("mobilephone");
		
				String registerway=request.getParameter("registerway");
		
				String registerid = "";
		
				String registertime="";
				
				String message = "";
		
				Map<String ,Object> model=new HashMap<String,Object>();
		
				UserDaoImpl impl1 = new UserDaoImpl();
				
				ModelAndView modelAndView = new ModelAndView();
		
				
			if (username == null || username.equals("")||email == null ||
						email.equals("")||password == null || password.equals("")||
						mobilephone == null || mobilephone.equals("")||
						!impl1.SearchUsername(username)||!impl1.SearchEmail(email)||
						!password.equals(qupassword) || !checkMobileNumber(mobilephone) ||
						!checkEmail(email))
			{
					//判断用户名是否为空
					if(username == null || username.equals(""))
						{			
							model.put("error", "用户名不能为空");
							
							message = "用户名不能为空";
						}
					//判断用户名是否为空
					else if(email == null || email.equals(""))
						{			
							model.put("error", "email不能为空");	
							
							message = "email不能为空";
			
						}
					//判断用户名是否为空
					else if(password == null || password.equals(""))
						{			
							model.put("error", "password不能为空");	
							
							message = "密码不能为空";
			
						}
					//判断用户名是否为空
					else if(mobilephone == null || mobilephone.equals(""))
						{			
							model.put("error", "mobilephone不能为空");	
							
							message = "手机号码不能为空";
			
						}
					//如果用户名存在提示
					else if(!impl1.SearchUsername(username))
						{					
				
							model.put("error","用户名已存在，请使用其他！");
							
							message = "用户名已存在，请使用其他！";
						}			
					//如果邮箱存在提示
					else if(!impl1.SearchEmail(email))
						{		
							
							model.put("error", "邮箱已注册！");	
							
							message = "邮箱已注册！";
						}				
					else if(!password.equals(qupassword))
						{
						model.put("error", "确认密码与原密码不相同！");	
						
						message = "确认密码与原密码不相同！";
						}		
			
					else if(!checkEmail(email))
						{
						model.put("error", "邮箱格式不正确");	
						
						message = "邮箱格式不正确";							
						
						}

					else if(!checkMobileNumber(mobilephone))
					{
					model.put("error", "手机号码不正确！！！");	
					
					message = "手机号码不正确！！！";							
					
					}
					
					request.setAttribute("message", message);
					
					modelAndView =new ModelAndView("regest",model);	
					
				}
		
					else if(impl1.SearchUsername(username) && impl1.SearchEmail(email) &&  password.equals(qupassword) && !mobilephone.equals(null) && !registerway.equals(null) && checkMobileNumber(mobilephone) && checkEmail(email))
						{
			
							UserDaoImpl impl = new UserDaoImpl();
			
							User user = new User();
			
							user.setEmail(email);
			
							user.setGroup(registerway);
			
							user.setPassword(password);
			
							user.setUser_name(username);
			
							user.setTel(mobilephone);
			
							//设置用户id并写入数据库
			
							registerid ="user:"+UUID.randomUUID().toString();//用来生成数据库的主键id非常不错。。
			
							user.setUser_ID(registerid);
						//	System.out.println("用户id~~~~~~~~~~ ~"+registerid+registerid.length());
							
			
							//设置数据库当前时间
							
							//获取系统当前时间
			
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
							registertime = df.format(new Date());//new Date()为获取当前系统时间
							
							user.setTime_regist(registertime);
			
							user.setTime_login(registertime);
			
					//		System.out.println("获取到的时间是：：：：：：：：：：：：：：：：："+registertime);
					//		System.out.println("时间的长度是：：：：：：：：：：：：：：："+registertime.length());
			
			
							//添加session 
							HttpSession session = request.getSession();
			
							session.setAttribute("user", user);
			
					//		System.out.println("user="+user);
			
							//id 要有是主键
							impl.addUser(user);
							
	
							
							message = "用户注册成功！！！你好"+username;
							
							request.setAttribute("message", message);
							
							modelAndView =new ModelAndView("regest",model);
							//为每个注册成功的用户分配本地文件夹,格式    username/service/**.xml或username/data/**.zip
							//首先获取本地路径
							String proPath = "service.properties";
							Properties ps = new Properties();
							InputStream in = createServiceController.class.getClassLoader().getResourceAsStream(proPath);
							try {
								ps.load(in);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out.println("加载properties文件失败！！！");
							}
							
							//设置上传文件的路径
							String pathFORupload = user.getClass().getClassLoader().getResource("").getPath().toString();
							pathFORupload = pathFORupload.substring(1,pathFORupload.length()-15)+"/users";
							session.setAttribute("pathFORupload",pathFORupload);
							
							//String nativePath = ps.getProperty("nativePath");
							String nativePath = pathFORupload;
							System.out.println(nativePath+"***********到users目录的路径");
							String userFolder = nativePath+"/"+username;
							String userFolderService = userFolder+"/service";
							String userFolderProgram = userFolder+"/program";
							String userFolderData = userFolder+"/data";
							String userFolderOther = userFolder+"/other";
							HandleFile handlefile = new HandleFile();
							//创建用户文件夹
							handlefile.createFolder(userFolder);
							handlefile.createFolder(userFolderService);
							handlefile.createFolder(userFolderProgram);
							handlefile.createFolder(userFolderData);
							handlefile.createFolder(userFolderOther);
							//创建用户文件，由用户每次创建服务时产生文件
							//测试用handlefile.createFile1(userFolderService, "1111111service222222.xml");
							
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











