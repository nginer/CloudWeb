package testweb.controller.construction;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.spi.XmlReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.dao.impl.ServiceDaoImpl;
import testweb.vo.Service;
import testweb.vo.User;

import com.test.file_operation.HandleFile;
import com.test.file_operation.HandleXML;

import edu.muc.db.hbase.HBaseCommon;
import edu.muc.db.hbase.HBaseVO;

@Controller
public class W2XML_reflectDController extends AbstractController {

	@Override
	@RequestMapping("/W2XML_reflectD")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//获取session对象
		HttpSession session = request.getSession();
		String tableName = request.getParameter("tableName");
		//对应列族
		String[] S_family = request.getParameterValues("S_family");
		//对应列
		String[] S_column = request.getParameterValues("S_column");
		//列族，列     这里没有用到
		String[] FC = request.getParameterValues("FC");
		//最终展示的显示名，存储在hbaseVO的value中，即那个family+qualifier+value中
		String[] itemName = request.getParameterValues("itemName");
		//列族的个数
		int FamilyCount = S_family.length;
		System.out.println("-----------------对象-------------------------");
		System.out.println("1列族名组成的数组"+S_family);
		System.out.println("2列名组成的数组"+S_column);
		System.out.println("3列族和列的映射组合"+FC);
		System.out.println("4在页面上显示的值"+itemName);
		System.out.println("-----------------值-------------------------");
		System.out.println("1列族名组成的数组"+Arrays.toString(S_family));
		System.out.println("2列名组成的数组"+Arrays.toString(S_column));
		System.out.println("3列族和列的映射组合"+Arrays.toString(FC));
		System.out.println("4在页面上显示的值"+Arrays.toString(itemName));
		
	/*	//列族，列，值
		HashMap<String, String> hmc = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> hm = new HashMap<String, HashMap<String,String>>();
		List<HBaseVO> lHBvo = null ;
		HBaseVO HBvo = null;
		
		
		hmF就是指hashmap的family
		
		
		*/
		String rowKey = "testRowKey1";
		HashMap<String, HashMap<String, String>> hmF= new HashMap<String, HashMap<String,String>>();
		
		for(int i=0;i<FamilyCount;i++){
			HashMap<String,String> hm = new HashMap<String, String>();
			hm.put(S_column[i], itemName[i]);
			hmF.put(S_family[i], hm);
		}
		
		HBaseVO HBvo = new HBaseVO(tableName,rowKey,hmF);
		List<HBaseVO> listHBvo = new ArrayList<HBaseVO>();
		listHBvo.add(HBvo);
		HBaseCommon hbc = new HBaseCommon();
		System.out.println("1+++++++++++++++++++++++++++++++++++++");
		System.out.println("listHBvo的大小size"+listHBvo.size());
		System.out.println("输出tablename"+tableName);
		System.out.println("HBvo的tablename"+HBvo.getTableName());
		Document docVO = hbc.getXMLDocumentForVOs(listHBvo);
		System.out.println("1.11111+++++++++++++++++++++++++++++++++++++");
		Element rootVO = docVO.getRootElement();
		//修改根节点的名字为reflect
		System.out.println("显示GIS处的测试数据输出~~~~~~~~~~~~~~~~~~~~~~\n~~~~~~~~~~~~~~~~~~~~~~~~~\n~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~没有修改名字的rootVO（为原来的）~~~~~~~~~~~"+rootVO);
		rootVO.setName("reflect");
		System.out.println("~~~~~~~~~~~~~修改名字之后的rootVO（应该变成reflect）~~~~~~~~~~~"+rootVO);
		//这里获取xml文件的路径信息
		String proPath = "service.properties";
		Properties ps = new Properties();
		InputStream in = createServiceController.class.getClassLoader().getResourceAsStream(proPath);
		ps.load(in);
		String path = (String) session.getAttribute("serviceXMLpath");
		/*String path = ps.getProperty("path");*/
		//获得xml文件的读写
		HandleFile hf = new HandleFile();
		HandleXML hx = new HandleXML();
		//这里是写死了。。。后期需要改！！！！！！！！！！
		/*hf.createFile("E://TEST","service.xml");*/
		Document docService = hx.getDocument(path);
		Element rootService = docService.getRootElement();		
		/*//首先将包括tablestructure在内的子节点删掉，再写入，避免重复
		hx.DeleteAll(path,"tableStructure"); 写的这个deleteall函数怎么不能用啊。。。*/
		Element reflect=rootService.element("reflect");
		System.out.println("查看查找reflect是否成功，输出reflect节点"+reflect);
		hx.DeleteChild(path,"reflect");
		rootService.remove(reflect);
		System.out.println("查看删除reflect是否成功，就是看看还有没有reflect节点存在~~~~~~~~~~~~~~~~~~");
		XMLWriter writer = new XMLWriter();
		writer.write(docService);
		System.out.println("添加rootVO之后！！！！！！！！！！！！！！！！");
		//rootVO就是根节点reflect
		//将映射的程序和数据信息写入到根节点rootVO下，即在rootVO下挂载子节点
		//关于用户上传的程序和数据的信息。
				String program_name_ID = request.getParameter("programReflection");
				String data_name_ID = request.getParameter("dataReflection");
				String[] program_array = program_name_ID.split(",");
				String program_name = program_array[0];
				String program_ID = program_array[1];
				String[] data_array = data_name_ID.split(",");
				String data_name = data_array[0];
				String data_ID = data_array[1];
				System.out.println("^^^^^^^^^^^^^"+program_array.length+"   "+program_array[0]+"二二二"+program_array[1]);
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^"+data_array.length+"     "+data_array[0]+"二二二"+data_array[1]);
		Element ele_program = rootVO.addElement("program");
		ele_program.setText(program_name);
		Element ele_data = rootVO.addElement("data");
		ele_data.setText(data_name);
		rootService.add(rootVO);
		System.out.println("显示GIS处的测试数据输出~~~~~~~~~~~~~~~~~~~~~~\n~~~~~~~~~~~~~~~~~~~~~~~~~\n~~~~~~~~~~~~~~~");
		System.out.println("再次输出一遍rootVO！！！！！！！！！！！！！！！！！！"+rootVO);
		System.out.println("加节点之后的SERVICE的root节点！！！！！！！！！！！！！！！！！！"+rootService);
		System.out.println("再次输出docVO");
		writer.write(docVO);
		System.out.println("输出绑定docVO后的docService！！！！！！！！！！！！！！！！！！");
		//XMLWriter writer = new XMLWriter();
		//writer.write(docVO);
		writer.write(docService);
		hx.writeDoc(path, docService);
		String str_docVO = docVO.asXML();
		//后面做的这一堆处理都是为了将字符串改成js可处理的串
		//换单引号
		String send_str_docVO=str_docVO.replaceAll("\"","'");
		//去掉第一个<>后的换行符
		//查找第二个<
		int index=send_str_docVO.indexOf("<",2);
		send_str_docVO=send_str_docVO.substring(index);
		send_str_docVO="<?xml version='1.0' encoding='UTF-8'?>"+send_str_docVO;		
		System.out.println(send_str_docVO);
		//将用户所创建服务的信息写入到MySQL数据库中，用作个人中心的数据源。包括serviceVO的各个属性都需要列入。addservice
		Service service = new Service();
		//得到属性值
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		//String data_ID = "undetermined";
		//String data_name = "undetermined";
		//通过session向user赋值，获取得到当前登录用户信息
	/*	HttpSession session = request.getSession();*/
		User user=(User) session.getAttribute("user");
		String owner_ID = user.getUser_ID();
		String owner_name = user.getUser_name();
		//通过在W2XML_describeController.java设置session存储服务信息al，在这里获得服务信息
		String processType = "";//应该将处理方式processType存到session中，或者在上一个页面createXX中暂存
		String service_name = "";
		String service_describe = "";//这个也需要从上面的页面或者其他方式如session中传递过来、
		String service_keywords = "";
		ArrayList<HashMap<String, String>> al = (ArrayList<HashMap<String, String>>) session.getAttribute("serviceINFO");
		for(int i=0;i<al.size();i++){
			//注意到时候检查arraylist中的hashmap的顺序！！！要是顺序不对应就会赋值错乱！！！
			HashMap<String, String> hm = al.get(i);
			Iterator it = hm.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry = (Entry) it.next();
				 if(entry.getKey().toString()=="serviceName"){
					 service_name = entry.getValue().toString();
					 }else if(entry.getKey().toString()=="processType"){
						 processType = entry.getValue().toString();
					 }else if(entry.getKey().toString()=="description"){
						 service_describe = entry.getValue().toString();
					 }else if(entry.getKey().toString()=="keywords"){
						 service_keywords = entry.getValue().toString();
					 }
				
			}
		}
		
		/*//关于用户上传的程序和数据的信息。
		String program_name = request.getParameter("programReflection");
		String data_name = request.getParameter("dataReflection");*/
		
		
		
		String status = "";//已提交，待审核！对应数据库中的字段命名
		//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time_construct = sdf.format(new Date()).toString();		
		String service_ID = sdi.createServiceID();
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//设置属性值
		service.setData_ID(data_ID);
		service.setData_name(data_name);
		service.setOwner_ID(owner_ID);
		service.setOwner_name(owner_name);
		service.setProcessType(processType);
		service.setProgram_ID(program_ID);
		service.setProgram_name(program_name);
		service.setService_describe(service_describe);
		service.setService_ID(service_ID);
		service.setService_keywords(service_keywords);
		service.setService_name(service_name);
		service.setStatus(status);
		service.setTime_construct(time_construct);
		
		//将构建的service放入到数据库中
		try{
		sdi.addService(service);
		
		}catch(Exception e){
			System.out.println("在用户完成服务数据的映射之后，将这个服务的信息写入到数据库是发生错误！！！！！！！");
		}
		session.setAttribute("service",service);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fifth", "还不行！！！");
		//加引号，让js识别字符串
		model.put("send_str_docVO", "\""+send_str_docVO+"\"");
		//ModelAndView modelAndview = new ModelAndView("uploadProgram",model);
		ModelAndView modelAndview = new ModelAndView("showGIS",model);
		return modelAndview;

	}
	

}
