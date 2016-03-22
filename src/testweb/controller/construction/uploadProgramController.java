package testweb.controller.construction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.dao.impl.DataDaoImpl;
import testweb.dao.impl.ProgramDaoImpl;
import testweb.vo.Data;
import testweb.vo.Program;
import testweb.vo.User;

@Controller
public class uploadProgramController extends AbstractController{

	@Override
	@RequestMapping("/uploadProgram")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String nameFORprogram = null;
		String program_ID,program_name,program_describe = null,time_upload,time_lastModify,owner_ID,service_ID;
		System.out.println("进来了上传  程序   ！！！￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//工程根目录！！！ D:/908/workspace_eclipse/cloudWeb/users
				//nativePath到了用户名一级
				String nativePath = (String) session.getAttribute("pathFORupload")+"/"+user.getUser_name();
				//临时文件目录
				String tempPath = nativePath+"/temp";
		File tempFolder = new File(tempPath);
		if(!tempFolder.exists()){
			tempFolder.mkdirs();
		}
		//1.创建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置缓冲区大小，当超过缓冲区大小(默认10k)，temp目录下生成临时文件
		factory.setSizeThreshold(1024*100);
		//临时文件保存目录
		factory.setRepository(tempFolder);
		//2.创建文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//监听上传进度
		upload.setProgressListener(new ProgressListener() {
			
			@Override
			public void update(long readbytes, long contentlength, int arg2) {
				// TODO Auto-generated method stub
				System.out.println("文件大小："+contentlength+",当前已处理："+readbytes);
			}
		});
		upload.setHeaderEncoding("utf-8");
		//3.判断提交上来的数据是否是上传表单的数据
		if(!ServletFileUpload.isMultipartContent(request)){
			return null;
		}
		//设置单个上传文件的大小的最大值,1M
		upload.setFileSizeMax(1024*1024*512);
		//4.使用servletfileupload解析器上传数据，返回一个list<fileitem>
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					//普通的文本表项
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name+"      =        "+value);
					if(name.equals("programDescribe"))
						program_describe = value;
				}else{
					//文件类型表项
					String filename = item.getName();
					filename=filename.substring(filename.lastIndexOf("\\")+1);
					System.out.println("程序文件名：      "+filename);
					
					if(filename==null||filename.trim().equals("")){
						continue;
					}
					nameFORprogram = filename;
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(nativePath+"/program/"+filename);
					//缓冲区
					byte buffer[] = new byte[1024];
					int len = 0;//>0表示in中还有数据
					while((len=in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上传程序错啦############################################");
			System.out.println("错啦############################################");
		}
		
		//response.getWriter().write("<script language=\"JavaScript\" type=\"text/JavaScript\"> alert(\"上传成功\");return true;</script>"); 
		//response.getWriter().write("00000000000000000000000000000");
		
		ProgramDaoImpl pdi = new ProgramDaoImpl();
		program_ID = pdi.createProgramID();
		//data_name = request.getParameter("dataName");
		program_name = nameFORprogram;
		//program_describe = request.getParameter("programDescribe");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time_upload = sdf.format(new Date()).toString();		
		time_lastModify = time_upload;
		//User user = (User) session.getAttribute("user");
		owner_ID = user.getUser_ID();
		service_ID = "undetermined";
		Program program = new Program(program_ID, program_name, program_describe, time_upload, owner_ID, service_ID);
		//将上传的数据信息写入数据库
		pdi.addProgram(program);
		request.setAttribute("message_program", "success");
		//request.getRequestDispatcher("uploadDP.jsp").forward(request, response);
		
		
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("third", "我就说吧！！！");
		ModelAndView modelAndview = new ModelAndView("uploadDP",model);
		
		return modelAndview;
	}
	
}
