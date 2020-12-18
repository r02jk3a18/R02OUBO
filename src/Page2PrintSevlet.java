

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page2PrintSevlet
 */
@WebServlet("/Page2Print")
public class Page2PrintSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page2PrintSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sEname = (String)request.getAttribute("email");
		String sNumA = (String)request.getAttribute("numa");
		String sNumB = (String)request.getAttribute("numb");
		
		request.setAttribute("email", sEname);
		request.setAttribute("numa", sNumA);
		request.setAttribute("numb", sNumB);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/page2Print.jsp");
		rd.forward(request, response);
	}

}
