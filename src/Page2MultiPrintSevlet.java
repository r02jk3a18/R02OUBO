

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
@WebServlet("/Page2MultiPrint")
public class Page2MultiPrintSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page2MultiPrintSevlet() {
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
		String sNumC = (String)request.getAttribute("numc");
		String sNumD = (String)request.getAttribute("numd");
		String sNumE = (String)request.getAttribute("nume");
		String sNumF = (String)request.getAttribute("numf");
		String sNumG = (String)request.getAttribute("numg");
		String sNumH = (String)request.getAttribute("numh");
		String sNumI = (String)request.getAttribute("numi");
		String sNumJ = (String)request.getAttribute("numj");
		
		request.setAttribute("email", sEname);
		request.setAttribute("numa", sNumA);
		request.setAttribute("numb", sNumB);
		request.setAttribute("numc", sNumC);
		request.setAttribute("numd", sNumD);
		request.setAttribute("nume", sNumE);
		request.setAttribute("numf", sNumF);
		request.setAttribute("numg", sNumG);
		request.setAttribute("numh", sNumH);
		request.setAttribute("numi", sNumI);
		request.setAttribute("numj", sNumJ);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/page2MultiPrint.jsp");
		rd.forward(request, response);
	}

}
