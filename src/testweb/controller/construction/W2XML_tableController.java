package testweb.controller.construction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.dao.impl.DataDaoImpl;
import testweb.dao.impl.ProgramDaoImpl;
import testweb.vo.Data;
import testweb.vo.Program;
import testweb.vo.User;

import com.test.file_operation.HandleFile;
import com.test.file_operation.HandleXML;

import edu.muc.db.hbase.HBaseCommon;
import edu.muc.db.hbase.HBaseVO;

@Controller
public class W2XML_tableController extends AbstractController{

	@Override
	@RequestMapping("/W2XML_table")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//字符串数组family存储用户填写的表结构中 的所有列族名字
		HttpSession session = request.getSession();
		String[] family = request.getParameterValues("cluster");
		String tableName = request.getParameter("tableName");
		int familyCount = family.length;
		//String[][] column = null;
		//List中的column按照下标存储着对应列族中各个列。即，数组column.get(i)的各项，为列族family[i]的各个列。
		List<String[]> column =new ArrayList<String[]>();
		for(int i=0;i<familyCount;i++){
			//String[][] column[][] = request.getParameterValues("");
			column.add(request.getParameterValues("b_addColumn"+i));
		}
		System.out.println("列族的数组为"+family+"    大小为"+familyCount+"    "+Arrays.toString(family));
		System.out.println("列的个数"+column.size());
		for(int i=0;i<column.size();i++){
			String[] a = column.get(i);
			System.out.println("第"+i+"个列族下面有"+column.get(i).length+"个列!!!!"+Arrays.toString(a));
		}
		//这里获取xml文件的路径信息
		String proPath = "service.properties";
		Properties ps = new Properties();
		InputStream in = createServiceController.class.getClassLoader().getResourceAsStream(proPath);
		ps.load(in);
		/*String path = ps.getProperty("path");
		String nativePath = ps.getProperty("nativePath");*/
		String path = (String) session.getAttribute("serviceXMLpath");
		//这里用作作为json数据传递
		JSONArray jsonColumn = JSONArray.fromObject(column);
		System.out.println("88888888888888888888888"+jsonColumn);
		String data = jsonColumn.toString();
		System.out.println("9999999999999999999999"+data);
		JSONArray jsonFamily = JSONArray.fromObject(family);
		String dataF = jsonFamily.toString();
		
		//这里写入xml的操作等后续进行！！！！！！！！！！！！！！！！！
		//通过hbase中提供的API构造xml中的元素
		/*HBaseCommon hbc=new HBaseCommon();
		HBaseVO HBvo = new HBaseVO();*/
		String rowKey = "testRowKey" ;
		//构造HBaseVO中的各个参数，tableName、rowkey、HashMap<String, HashMap<String, String>>
		//hmF即，hashmapfamily
		//构造一个列族下的列和列值
		//第一个列族
		HashMap<String, HashMap<String, String>> hmF= new HashMap<String, HashMap<String,String>>();
		//HashMap< String, String> hmC = new HashMap<String, String>();
		for(int i=0;i<familyCount;i++){
			HashMap< String, String> hmC = new HashMap<String, String>();
			int k=column.get(i).length;
			System.out.println("第"+i+"个列族下"+"    有"+k+"个列·············");
			//if(k==1&&column.get(i)[0]==null) continue;
			//System.out.println("第1个列族下的那些个列~~~~~~~~~~~"+column.get(1)[0]+column.get(1)[1]+column.get(1)[2]+"~~~~~~~~~~~~~~！！！！！！！！！！！！！！！！！！！！！！！");
			for(int j=0;j<k;j++){
				String[] colTemp = column.get(i);
				System.out.println("测试数据是不是正确取出~~~~~~~~~~~~~~~~~~~"+"第"+i+"个列族下的第"+j+"列·············"+colTemp[j]);
				if(colTemp[0]==""||colTemp[0]==null||colTemp[0]==" ") {
					System.out.println("列里面有的值为空，跳出hmC的PUT值循环");
					break;
				}
				hmC.put(colTemp[j],"");
			}
			System.out.println("列和值的hashmap@@@@@@@@@@@@@@@@@@@@@@@@"+hmC);
			//一个列族及其下面包含的列+值，也就是一行中第i个列族+列+值
			hmF.put(family[i], hmC);
			
			System.out.println("列族和列的hashmap%%%%%%%%%%%%%%%%%%%%%%%"+hmF);
			
		}
		System.out.println("最终的那个大大大大大大大大大大大阿达的HASHMAP"+hmF);
		HBaseVO HBvo = new HBaseVO(tableName, rowKey, hmF);
		List<HBaseVO> listHBvo = new ArrayList<HBaseVO>();
		listHBvo.add(HBvo);
		HBaseCommon HBcommon = new HBaseCommon();
		Document docVO = HBcommon.getXMLDocumentForVOs(listHBvo);
		//接下来的这些可以封装成一个函数，在handleXML中定义、、、、、、、、、、、、、、、、、、、、、、、、
		
		XMLWriter writer = new XMLWriter();
		System.out.println("输出从hbasevommon中获得的document！！！！！！！！！！！！！！！！！！");
		writer.write(docVO);
		
		
		Element rootVO = docVO.getRootElement();
		rootVO.setName("tableStructure");
		HandleFile hf = new HandleFile();
		HandleXML hx = new HandleXML();
		hf.createFile("E://TEST","service.xml");
		
		Document docService = hx.getDocument(path);
		Element rootService = docService.getRootElement();
		System.out.println("没加vo节点的的SERVICE的root节点！！！！！！！！！！！！！！！！！！"+rootService);
		/*//首先将包括tablestructure在内的子节点删掉，再写入，避免重复
		hx.DeleteAll(path,"tableStructure"); 写的这个deleteall函数怎么不能用啊。。。*/
		Element tableStructure=rootService.element("tableStructure");
		hx.DeleteChild(path,"tableStructure");
		rootService.remove(tableStructure);
		rootService.add(rootVO);
		System.out.println("VO的root节点！！！！！！！！！！！！！！！！！！"+rootVO);
		System.out.println("加节点之后的SERVICE的root节点！！！！！！！！！！！！！！！！！！"+rootService);
		System.out.println("输出从绑定docVO后的docService！！！！！！！！！！！！！！！！！！");
		writer.write(docService);
		hx.writeDoc(path, docService);
		
		
		
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("familyName",family);
		model.put("columnName",column);
		
		model.put("Jcolumn",data);
		model.put("Jfamily", dataF);
		
		model.put("second", "来了？");
		model.put("tableName", tableName);
		//将docVO转换成字符串传递到前台页面，运用到AJAX中交换得到URL
		String str_docVO = docVO.asXML();
		System.out.println();
		System.out.println("~~~~~~~~~~~~~**************************************************~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println(str_docVO);
		System.out.println();
		System.out.println("~~~~~~~~~~~~~**************************************************~~~~~~~~~~~~~~~~~~");
		//后面做的这一堆处理都是为了将字符串改成js可处理的串
		//换单引号
		String send_str_docVO=str_docVO.replaceAll("\"","'");
		//去掉第一个<>后的换行符
		//查找第二个<
		int index=send_str_docVO.indexOf("<",2);
		send_str_docVO=send_str_docVO.substring(index);
		send_str_docVO="<?xml version='1.0' encoding='UTF-8'?>"+send_str_docVO;
		int index1 = str_docVO.indexOf("<", 2);
		str_docVO = str_docVO.substring(index1);
		str_docVO = "<?xml version='1.0' encoding='UTF-8'?>"+str_docVO;
		
		System.out.println("这里输出send_str_docVO的值~~~~~~~~~~~~~~~~~~~~~~~~~~"+send_str_docVO);
		//加引号，让js识别字符串
		model.put("send_str_docVO", "\""+send_str_docVO+"\"");
		
		//send_str_docVO是给JS处理的，str_docVO是给jsp处理的
		model.put("str_docVO", str_docVO);
		
		//这里暂且跳转到数据映射那里~~~~~
		//本来是跳转到数据上传那里。uploadData那里。
		
		//获取用户的数据信息，作reflectData页面中下拉选项的数据源。
		User user = (User) session.getAttribute("user");
		String user_ID = user.getUser_ID();
		DataDaoImpl ddi = new DataDaoImpl();
		ProgramDaoImpl pdi = new ProgramDaoImpl();
		List<Data> dataList = ddi.getDataByOwnerID(user_ID);
		List<Program> programList = pdi.getProgramByOwnerID(user_ID);
		model.put("dataList", dataList);
		model.put("programList",programList);
		
		ModelAndView modelAndview = new ModelAndView("reflectData", model);
		return modelAndview;
	}
}
