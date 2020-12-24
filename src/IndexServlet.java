

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page1Servlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
							"Select ceil(KAISI-SYSDATE) as DIFF From Kigen"
						);
			ResultSet rs = st.executeQuery();
			rs.next();
			String diff = rs.getString("DIFF");
			if(diff.charAt(0)!='-'&&diff.charAt(0)!='0') {
				request.setAttribute("sDiff", diff);
				RequestDispatcher rd = request.getRequestDispatcher("/Page1_kuri");
				rd.forward(request, response);
				
			}else {
				
				try {
					Class.forName(driverName);
					Connection connection2=DriverManager.getConnection(url,id,pass);
					PreparedStatement st2 = 
							connection2.prepareStatement(
									"Select ceil(KIGEN-SYSDATE) as DIFF From Kigen"
								);
					ResultSet rs2 = st2.executeQuery();
					rs2.next();
					String diff2 = rs2.getString("DIFF");
					if(diff2.charAt(0)!='-'&&diff2.charAt(0)!='0') {
						request.setAttribute("sDiff", diff2);
						RequestDispatcher rd = request.getRequestDispatcher("/page1");
						rd.forward(request, response);
						
					}else {
						RequestDispatcher rd = request.getRequestDispatcher("/page3");
						rd.forward(request, response);
						
					}
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

}

