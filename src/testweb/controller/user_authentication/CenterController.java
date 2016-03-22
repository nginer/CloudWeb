package testweb.controller.user_authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.vo.User;

@Controller
public class CenterController extends AbstractController{
	
	
	//从主页面到登陆界面
	@RequestMapping("/captcha")
	public ModelAndView handleRequestInternal5(HttpServletRequest request,
			HttpServletResponse response){
	
			Map<String ,Object> model=new HashMap<String,Object>();
		
			ModelAndView modelAndView2 =new ModelAndView("login",model);
		
			return  modelAndView2;
			
	}
	//从个人中心到修改信息界面
	
	
	@RequestMapping("/showAccount")
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response){
	
			Map<String ,Object> model=new HashMap<String,Object>();
		
			ModelAndView modelAndView2 =new ModelAndView("regestModify1",model);
		
			return  modelAndView2;
			
	}
	
	@RequestMapping("/orshowAccount")
	public ModelAndView handleRequestInternal10(HttpServletRequest request,
			HttpServletResponse response){
	
			Map<String ,Object> model=new HashMap<String,Object>();
		
			ModelAndView modelAndView2 =new ModelAndView("regestModify1",model);
		
			return  modelAndView2;
			
	}
	@RequestMapping("/adshowAccount")
	public ModelAndView handleRequestInternal11(HttpServletRequest request,
			HttpServletResponse response){
	
			Map<String ,Object> model=new HashMap<String,Object>();
		
			ModelAndView modelAndView2 =new ModelAndView("regestModify1",model);
		
			return  modelAndView2;
			
	}


	//从修改界面到个人中心
	@RequestMapping("/regestturn")
	public ModelAndView handleRequestInternal1(HttpServletRequest request,
			HttpServletResponse response){
	
		User user1 = new User();
		
		//获取session
		HttpSession session1 = request.getSession();
		
		user1 = (User) session1.getAttribute("user");
		
		if(user1.getGroup().equals("individual_user"))
		
		{Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("showAccount",model);
		
		return  modelAndView2;
		}
		
		else if(user1.getGroup().equals("organization_user"))
			
		{Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("Organizationcenter",model);
		
		return modelAndView2;
		
		}
		else if(user1.getGroup().equals("administrator"))
			
		{Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("Administratorcenter",model);
		
		return modelAndView2;
		
		}
		return null;
			
	}
	//从个人中心跳转到上传文件
	@RequestMapping("/showAccount1")
	public ModelAndView handleRequestInternal2(HttpServletRequest request,
			HttpServletResponse response){

		Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("sFileup",model);
		
		return  modelAndView2;
		
	}
	
	//从个人中心跳转到上传文件
	@RequestMapping("/orshowAccount1")
	public ModelAndView handleRequestInternal7(HttpServletRequest request,
			HttpServletResponse response){

		Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("sFileup",model);
		
		return  modelAndView2;
		
	}
	
	//从个人中心跳转到上传文件
	@RequestMapping("/adshowAccount1")
	public ModelAndView handleRequestInternal9(HttpServletRequest request,
			HttpServletResponse response){

		Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("sFileup",model);
		
		return  modelAndView2;
		
	}
	
	//从上传文件跳转回来
	@RequestMapping("/UpFileReturn")
	public ModelAndView handleRequestInternal3(HttpServletRequest request,
			HttpServletResponse response){
		
		User user1 = new User();
		
		//获取session
		HttpSession session1 = request.getSession();
		
		user1 = (User) session1.getAttribute("user");
		
		if(user1.getGroup().equals("individual_user"))
		
		{Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("showAccount",model);
		
		return  modelAndView2;
		}
		
		else if(user1.getGroup().equals("organization_user"))
			
		{Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("Organizationcenter",model);
		
		return modelAndView2;
		
		}
		else if(user1.getGroup().equals("administrator"))
			
		{Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("Administratorcenter",model);
		
		return modelAndView2;
		
		}
		return null;
		
		}
	
	@RequestMapping("/withdraw")
	public ModelAndView handleRequestInternal4(HttpServletRequest request,
			HttpServletResponse response){
		Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("login",model);
		
		return  modelAndView2;
		}
	
	@RequestMapping("/orwithdraw")
	public ModelAndView handleRequestInternal14(HttpServletRequest request,
			HttpServletResponse response){
		Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("login",model);
		
		return  modelAndView2;
		}
	
	@RequestMapping("/adwithdraw")
	public ModelAndView handleRequestInternal15(HttpServletRequest request,
			HttpServletResponse response){
		Map<String ,Object> model=new HashMap<String,Object>();
		
		ModelAndView modelAndView2 =new ModelAndView("login",model);
		
		return  modelAndView2;
		}
	
}
