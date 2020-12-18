

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
@WebServlet("/page2MultiInsert")
public class Page2MultiInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page2MultiInsertServlet() {
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
		
		String sEname = (String)request.getAttribute("email");
		String sNumA = (String)request.getAttribute("numa");
		String sNumB = (String)request.getAttribute("numb");
		String sNumC = (String)request.getAttribute("numc");
		String sNumD = (String)request.getAttribute("numd");
		String sNumE = (String)request.getAttribute("nume");
		String sNumF = (String)request.getAttribute("numf");
		String sNumG = (String)request.getAttribute("numg");
		String sNumH = (String)request.getAttribute("numh");
		String sNumI = (String)request.getAttribute("numi");
		String sNumJ = (String)request.getAttribute("numj");
		try {
			
			Class.forName(driverName);
			Connection connection=DriverManager.getConnection(url,id,pass);
			PreparedStatement st = 
					connection.prepareStatement(
							"Insert into OUBO(EMAIL,NUMA,NUMB,CREATED) Values(?,?,?,SYSDATE)"
						);
			st.setString(1, sEname);
			st.setString(2, sNumA);
			st.setString(3, sNumB);
			st.executeUpdate();
			
			st.setString(1, sEname);
			st.setString(2, sNumC);
			st.setString(3, sNumD);
			st.executeUpdate();
			
			st.setString(1, sEname);
			st.setString(2, sNumE);
			st.setString(3, sNumF);
			st.executeUpdate();
			
			st.setString(1, sEname);
			st.setString(2, sNumG);
			st.setString(3, sNumH);
			st.executeUpdate();
			
			st.setString(1, sEname);
			st.setString(2, sNumI);
			st.setString(3, sNumJ);
			st.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/page2.jsp");
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
