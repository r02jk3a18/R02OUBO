

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageTousenServlet
 */
@WebServlet("/PageTousen")
public class PageTousenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageTousenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@192.168.54.226:1521/orcl";
		final String id = "OUBO";
		final String pass = "TOUSEN";
		
		
		try {
			Class.forName(driverName);
			Connection connection=DriverManager.getConnection(url,id,pass);
			PreparedStatement st = 
					connection.prepareStatement(
							"select NVL ( SUBSTR ( email,0,INSTR ( email,'@' ) -1 ) ,email )  as ADDRESS , SYOUHIN from oubo "
							+ "join Tousen on OUBO.numa = TOUSEN.numa and OUBO.numb = TOUSEN.numb group by email , syouhin"
						);
			
			ResultSet rs = st.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			while(rs.next() != false) {
				String[] s=new String[4];
				s[0]=rs.getString("ADDRESS");
				s[1]=rs.getString("SYOUHIN");
				list.add(s);
			}
			request.setAttribute("Tousen", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/pageTousen.jsp");
			rd.forward(request, response);	
		}catch(SQLException e) {
			System.out.println("SQLException");
			response.getWriter().println("SQLException");
			e.printStackTrace();
			e.printStackTrace(response.getWriter());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			response.getWriter().println("ClassNotFoundException");
			e.printStackTrace();
			e.printStackTrace(response.getWriter());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
