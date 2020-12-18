

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
@WebServlet("/KanriTousen2")
public class KanriTousen2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KanriTousen2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@192.168.54.226:1521/orcl";
		final String id = "OUBO";
		final String pass = "TOUSEN";
		
	    request.setCharacterEncoding("UTF-8");

		String sNumA = request.getParameter("numa");
		String sNumB = request.getParameter("numb");
		String sText = request.getParameter("text");

		try {
			Class.forName(driverName);
			Connection connection=DriverManager.getConnection(url,id,pass);
			PreparedStatement st = 
					connection.prepareStatement(
							"Insert into TOUSEN Values(?,?,?)"
						);
			
			st.setString(1, sNumA);
			st.setString(2, sNumB);
			st.setString(3, sText);
			
			st.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/KanriTousen2.jsp");
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

}
