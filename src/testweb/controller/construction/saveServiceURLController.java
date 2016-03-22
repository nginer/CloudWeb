package testweb.controller.construction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;








import testweb.mysql.DBConnection;
import testweb.vo.Service;

/**
 * Servlet implementation class saveServiceURLController
 */
@WebServlet("/saveServiceURL")
public class saveServiceURLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveServiceURLController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String urlGIS = request.getParameter("urlGIS");
		HttpSession session = request.getSession();
		Service service = (Service) session.getAttribute("service");
		String serviceID = service.getService_ID();
		String sql = "update service set url='www.shabi.com',domain='ninininnininini' where service_ID='2';";
		Connection con = DBConnection.getInstance().getConnection();
		int row=0;
		try {
			Statement sta = con.createStatement();
			row = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("将URL和DOMAIN写入数据库时出错了！！！");
			e.printStackTrace();
		}
		if(row>0){
			System.out.println("成功将URL和DOMAIN写入了，影响了"+row+"条记录~~~~~~~~");
		}
		System.out.println("获取urlGIS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+urlGIS);
		
	}

}
