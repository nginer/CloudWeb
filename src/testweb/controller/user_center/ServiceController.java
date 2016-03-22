package testweb.controller.user_center;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.dao.impl.*;
import testweb.entity.ServiceInfo;
import testweb.entity.Table;
import testweb.vo.Data;
import testweb.vo.Program;
import testweb.vo.Service;
import testweb.vo.User;

@Controller
public class ServiceController extends AbstractController {

	@RequestMapping("/service")
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) {
		String ProgramID = request.getParameter("programID");
		String DataID = request.getParameter("dataID");
		String recordID = request.getParameter("serviceID");
		String showType = request.getParameter("type");
		HttpSession session1 = request.getSession();
		User user1 = new User();
		user1 = (User) session1.getAttribute("user");

		ServiceDaoImpl s = new ServiceDaoImpl();
		DataDaoImpl d = new DataDaoImpl();
		ProgramDaoImpl p = new ProgramDaoImpl();
		Map<String, Object> model = new HashMap<String, Object>();
		Table tb = null;
		switch (showType) {
		case "s":
			model.put("tName", "基本服务描述");//表头
			//model.put("type", 1);
			s.deleteService(recordID);	
			//model.put("type", "s");
			//model.put("uid", userID);
			// Table;-->model;;
			 tb =query_db(user1.getGroup(),user1.getUser_ID());
			break;
		case "d":
			model.put("tName", "基本数据信息");
			//model.put("type", 2);
			d.deleteData(DataID);
			tb =query_db(user1.getGroup(),user1.getUser_ID());
			break;
		case "p":
			model.put("tName", "基本程序描述");
			//model.put("type", 3);
			p.deleteProgram(ProgramID);
			tb =query_db(user1.getGroup(),user1.getUser_ID());
			break;
		}
		model.put("table", tb);
		System.out.println(tb.Datas.size());
		if(user1.getGroup().equals("administrator")){
			ModelAndView modelAndView = new ModelAndView("admin", model);
			return modelAndView;
		}else{
			ModelAndView modelAndView = new ModelAndView("service1", model);
			return modelAndView;
		}
		
	}
/**
 * 
 * @param tableNameInDB 数据库表名
 * @param uid  用户ID
 * @return 一个Table对象
 */
	public Table query_db(String usergroup,String userID) {
		Table table = new Table();
		ServiceDaoImpl s = new ServiceDaoImpl();
		DataDaoImpl d = new DataDaoImpl(); 
		ProgramDaoImpl p = new ProgramDaoImpl();
		if(usergroup.equals("individual_user")){
			//User user = new User();
			List<Service> l1 = s.getServicesByOwnerID(userID);
			List<Data> l2 = d.getDataByOwnerID(userID);
			List<Program> l3 = p.getProgramByOwnerID(userID);
			table.addAllService(l1);
			table.addAllData(l2);
			table.addAllProgram(l3);
			return table;
		}
		else{
			List<Service> l1 = s.getAllService(); //获得用户id为13052032的一条service记录，将次记录放入table中
			List<Data> l2 = d.getAllData();
			List<Program> l3 = p.getAllProgram();
			table.addAllService(l1);
			table.addAllData(l2);
			table.addAllProgram(l3);
			return table;
			
		}
		
	}
}
