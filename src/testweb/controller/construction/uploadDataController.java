package testweb.controller.construction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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

import testweb.dao.impl.DataDaoImpl;
import testweb.vo.Data;
import testweb.vo.User;

/**
 * Servlet implementation class uploadDataController
 */
@Controller
public class uploadDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String nameFORdata;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping("/uploadData")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文件上传目录
		System.out.println("进来了上传   数据   ！！！￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		String data_ID,data_name,data_describe = null,time_upload,time_lastModify,owner_ID,service_ID;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//工程根目录！！！ D:/908/workspace_eclipse/cloudWeb/users
		//nativePath到了用户名一级
		System.out.println(session.getAttribute("pathFORupload"));
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
			return;
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
					if(name.equals("dataDescribe"))
						data_describe = value;
				}else{
					//文件类型表项
					String filename = item.getName();
					filename=filename.substring(filename.lastIndexOf("\\")+1);
					System.out.println("文件名：      "+filename);
					
					if(filename==null||filename.trim().equals("")){
						continue;
					}
					nameFORdata = filename;
					InputStream in = item.getInputStream();
					//路径格式username/data
					FileOutputStream out = new FileOutputStream(nativePath+"/data/"+filename);
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
			System.out.println("错啦############################################");
			System.out.println("错啦############################################");
		}
		
		//response.getWriter().write("<script language=\"JavaScript\" type=\"text/JavaScript\"> alert(\"上传成功\");return true;</script>"); 
		//response.getWriter().write("00000000000000000000000000000");
		
		DataDaoImpl ddi = new DataDaoImpl();
		data_ID = ddi.createDataID();
		//data_name = request.getParameter("dataName");
		data_name = nameFORdata;
		//data_describe = request.getParameter("dataDescribe");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time_upload = sdf.format(new Date()).toString();		
		time_lastModify = time_upload;
		//User user = (User) session.getAttribute("user");
		owner_ID = user.getUser_ID();
		service_ID = "undetermined";
		Data data = new Data(data_ID, data_name, data_describe, time_upload, time_lastModify, owner_ID, service_ID);
		//将上传的数据信息写入数据库
		ddi.addData(data);
		request.setAttribute("message_data", "success");
		request.getRequestDispatcher("uploadDP.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
