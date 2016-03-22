
package testweb.controller.user_center;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.entity.*;

@Controller
public class AddController extends AbstractController{
	@RequestMapping("/add")
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//ModelAndView modelAndView = new ModelAndView();	
		//modelAndView.setViewName("showAccount");
		//Regist regist1 =getRegist(username,password);
		//Table table = getTable(username,password);
		
		
		Map<String ,Object> model=new HashMap<String,Object>();
			//model.put("table", table);
			//System.out.println("zhengque快快快");
			//return new ModelAndView("showAccount",model);
			//return new ModelAndView("showAccount",model);
			//modelAndView.addObject(model);
			//System.out.println("zhengque快111");
			ModelAndView modelAndView2 =new ModelAndView("fileSubmit",model);
			//System.out.println("zhengque快快8888");
			return  modelAndView2;
			//return modelAndView;
			

	}
	/*public Table getTable(String username,String password){
		if(username.equals("123")&&password.equals("123")){
			/*Account account =new Account();
			account.setUsername(username);
			account.setBalance(88.8f);
			return account;
			*/
			//ServiceInfo si =new ServiceInfo();
			//Table table = new Table();
			//读数据库
			//si.setID("01");
			//si.setName("少数民族村寨");
			//table.add(si);
			//serviceinfo.setName("少数民族村寨");
}
