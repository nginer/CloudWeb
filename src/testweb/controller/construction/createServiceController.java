package testweb.controller.construction;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.dao.impl.UserDaoImpl;
import testweb.vo.User;


@Controller
public class createServiceController extends AbstractController {

	@Override
	@RequestMapping("/createService")

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String proPath = "service.properties";
		Properties ps = new Properties();
		InputStream in = createServiceController.class.getClassLoader().getResourceAsStream(proPath);
		ps.load(in);
		String typesStr = ps.getProperty("processType");
		String domainStr = ps.getProperty("domain");
		String[] domains = domainStr.split(",");
		String[] types = typesStr.split(",");
		
		Map<String , Object> model = new HashMap<String, Object>();
		User user = new User();
		UserDaoImpl userInfo =new UserDaoImpl();
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//user = userInfo.getUserByID(id);
		//model.put("userInfo", user);
		user = (User) request.getSession().getAttribute("user");
		model.put("user",user);
		model.put("types", types);
		model.put("domains", domains);
		System.out.println("读取的领域数据信息@@@@@@@@@@@@@@@@@@@@@@"+domains[2]);
		System.out.println("这里"+model+"!!!!!!!!!!!!");
		ModelAndView modelAndview = new ModelAndView("createService",model);
		return modelAndview;
		
	}



}
