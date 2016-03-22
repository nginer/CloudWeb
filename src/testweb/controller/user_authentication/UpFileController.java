package testweb.controller.user_authentication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 
 * @param tableNameInDB 数据库表名
 * @param uid  用户ID
 * @return 一个Table对象
 */
public class UpFileController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletConfig config;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);// 初始化servlet，主要目的是得到初始化信息

		// 将得到的config保存为成员变量，目的是下一步使用

		this.config = config;

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String msg = "";
		SmartUpload uploader = new SmartUpload();
		try {
			uploader.initialize(config, request, response);// 初始化上载器
			uploader.upload(); // 上载表单数据
			// 此时才能读取表单数据
			Enumeration<?> e = uploader.getRequest().getParameterNames();
			while (e.hasMoreElements()) { // 遍历所有表单参数(不包括文件)
				String key = (String) e.nextElement();
				if ("name".equals(key)) { // 找到需要的参数
					// 不能用request.getParameter()，只能用下列语句获取参数值
					String name = uploader.getRequest().getParameterValues(key)[0];
				}
			}

			for (int i = 0; i < uploader.getFiles().getCount(); i++) {
				com.jspsmart.upload.File myFile = uploader.getFiles()
						.getFile(i);
		
				if (!myFile.isMissing()) { // 文件上传成功
					String fileName = "/upload/"
							+ new SimpleDateFormat("yyyyMMdd")
									.format(new Date()) +

							(int) (Math.random() * 90 + 10) + "."
							+ myFile.getFileExt();
					System.out.println(fileName);
					myFile.saveAs(fileName, uploader.SAVE_VIRTUAL);

				} // 上一行为提示信息
			}
			msg = "上传成功,共上传" + uploader.getFiles().getCount() + "个文件.";
		} catch (SmartUploadException e) {
			msg = e.getMessage(); // 将出错信息以提示信息形式显示
			e.printStackTrace();
		}

		request.setAttribute("msg", msg); // 存储提示信息
		request.getRequestDispatcher("sFileup.jsp").forward(request, response);
	    //下面是参数写入数据库中


}
}
