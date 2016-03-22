package testweb.controller.construction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.vo.User;

import com.test.file_operation.HandleFile;
import com.test.file_operation.HandleXML;

@Controller

public class W2XML_describeController extends AbstractController{

	@Override
	@RequestMapping("/W2XML_describe")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//获取登录的用户对象，进而获取用户信息。
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//将服务描述信息写入到一个本地的xml当中
	
		String proPath = "service.properties";
		Properties ps = new Properties();
		InputStream in = createServiceController.class.getClassLoader().getResourceAsStream(proPath);
		ps.load(in);
		//String nativePath = ps.getProperty("nativePath");
		//到users一级！！！！！！！
		String nativePath = (String) session.getAttribute("pathFORupload");
		//String path = "E://TEST//service.xml";
		String serviceName = request.getParameter("serviceName");
		String seviceDescription = request.getParameter("seviceDescription");
		String keywords = request.getParameter("keywords");
		String type = request.getParameter("type");
		String domain= request.getParameter("domain");
		System.out.println(request.getParameter("serviceName")+seviceDescription+keywords+type+"8888888888888888888888888888888888888888");
		//写入到一个XML文件中进行保存,文件路径格式    username/service/servicename.xml
		String path = nativePath+"//"+user.getUser_name()+"//service//"+serviceName+".xml";
		System.out.println("！！！！！！！！！！服务的描述信息需要写入的serviceName.xml路径！！！！！！！！！\n\n\n\n"+path);
		//目录到username那一级
		String path_toUsername = nativePath+"//"+user.getUser_name();
		//目录到service文件夹
		String path_folder = nativePath+"//"+user.getUser_name()+"//service";
		//xml文件的名字，关键在于使用了用户自起的服务名称
		String path_file = serviceName+".xml";
		HandleFile hf = new HandleFile();
		hf.createFile1(path_folder,path_file);
		ArrayList<HashMap<String,String>> al = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> hm1 = new HashMap<String, String>() ;
		HashMap<String,String> hm2 = new HashMap<String, String>() ;
		HashMap<String,String> hm3 = new HashMap<String, String>() ;
		HashMap<String,String> hm4 = new HashMap<String, String>() ;
		HashMap<String,String> hm5 = new HashMap<String, String>() ;
		hm1.put("serviceName", serviceName);
		al.add(hm1);
		hm2.put("description", seviceDescription);
		al.add(hm2);
		hm3.put("keywords", keywords);
		al.add(hm3);
		hm4.put("processType", type);
		al.add(hm4);
		hm5.put("domain",domain);
		al.add(hm5);
		System.out.println(al);
		HandleXML hx = new HandleXML();
		hx.DeleteChild(path, "describe");
		hx.write2XML(path, "describe", al);
		//用session存储当前的描述信息al，然后在W2XML_reflectDController.java中（将服务信息写入到数据库）调用\
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		session.setAttribute("serviceINFO", al);
		//设置serviceName.xml的路径，用于后期的读写xml操作
		session.setAttribute("serviceXMLpath", path);
		session.setAttribute("path_toUsername", path_toUsername);
		
		//跳转到另外一个页面中
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("first", "懂個球");
		model.put("serviceName", serviceName);
		model.put("serviceDescription", seviceDescription);
		model.put("keywords", keywords);
		model.put("type", type);
		
		ModelAndView modelAndview = new ModelAndView("createTableStructure",model);
		return modelAndview;
	}
}
