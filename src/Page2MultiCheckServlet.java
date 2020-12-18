
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.CHAR_ARRAY;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page1CheckServlet
 */
@WebServlet("/Page2MultiCheck")
public class Page2MultiCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Page2MultiCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@192.168.54.226:1521/orcl";
		final String id = "OUBO";
		final String pass = "TOUSEN";

		String sEmail = request.getParameter("email");
		String sNumA = request.getParameter("numa");
		String sNumB = request.getParameter("numb");
		String sNumC = request.getParameter("numc");
		String sNumD = request.getParameter("numd");// 2PAIR
		String sNumE = request.getParameter("nume");
		String sNumF = request.getParameter("numf");// 3PAIR
		String sNumG = request.getParameter("numg");
		String sNumH = request.getParameter("numh");// 4PAIR
		String sNumI = request.getParameter("numi");
		String sNumJ = request.getParameter("numj");// 5PAIR
		String sError = null;
		
		
		boolean InsertSame = true;

		boolean SamePair1 = true;
		boolean SamePair2 = true;
		boolean SamePair3 = true;
		boolean SamePair4 = true;
		boolean SamePair5 = true;
		

		boolean NumCheck1 = true;
		boolean NumCheck2 = true;
		boolean NumCheck3 = true;
		boolean NumCheck4 = true;
		boolean NumCheck5 = true;
		
		

		NumCheck1 = Num(sNumA);
		NumCheck2 = Num(sNumC);
		NumCheck3 = Num(sNumE);
		NumCheck4 = Num(sNumG);
		NumCheck5 = Num(sNumI);
		
		if (NumCheck1 == true && NumCheck2 == true && NumCheck3 == true && NumCheck4 == true && NumCheck5 == true) {
			try {

				Class.forName(driverName);
				Connection connection = DriverManager.getConnection(url, id, pass);
				PreparedStatement st = connection.prepareStatement("Select email From OUBO where  numa=? and numb=?");
				st.setString(1, sNumA);
				st.setString(2, sNumB);

				ResultSet rs = st.executeQuery();
				if (rs.next() == true) {
					SamePair1 = false;
				}

				st.setString(1, sNumC);
				st.setString(2, sNumD);

				rs = st.executeQuery();
				if (rs.next() == true) {
					SamePair2 = false;
				}

				st.setString(1, sNumE);
				st.setString(2, sNumF);

				rs = st.executeQuery();
				if (rs.next() == true) {
					SamePair3 = false;
				}

				st.setString(1, sNumG);
				st.setString(2, sNumH);

				rs = st.executeQuery();
				if (rs.next() == true) {
					SamePair4 = false;
				}
				st.setString(1, sNumI);
				st.setString(2, sNumJ);

				rs = st.executeQuery();
				if (rs.next() == true) {
					SamePair5 = false;
				}
				String[] insertcheck = {sNumA,sNumB,sNumC,sNumD,sNumE,sNumF,sNumG,sNumH,sNumI,sNumJ};
				InsertSame=Same(insertcheck);
				
				if (SamePair1==false||SamePair2==false||SamePair3==false||SamePair4==false||SamePair5==false||InsertSame==false) {
					sError = "Same";
					request.setAttribute("Error", sError);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/page1Multi.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("email", sEmail);
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
					RequestDispatcher rd = request.getRequestDispatcher("/Page2MultiPrint");
					rd.forward(request, response);
				}

			} catch (SQLException e) {
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
		} else {
			sError = "Num";
			request.setAttribute("Error", sError);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/page1Multi.jsp");
			rd.forward(request, response);
		}

	}

	public boolean Num(String sNum) {
		char[] Change = new char[7];
		int Num = 0;
		boolean Ans =false;
		for (int a = 0; a < Change.length; a++) {
			Change[a] = sNum.charAt(a);
		}
		for (int b = 0; b < Change.length; b++) {
			Num += Character.getNumericValue(Change[b]);
		}
		if (Num % 9 == 0) {
			Ans = true;
		}
		return Ans;
	}
	public boolean Same(String[] InsertCheck ) {
		boolean Same =true;
		String[] Check=InsertCheck;
		String A,B;
		for(int a=0;a<Check.length;a+=2) {
			A=Check[a];
			B=Check[a+1];
			
			for(int s=a+2;s<Check.length;s+=2) {
				if(A.equals(Check[s])&&B.equals(Check[s+1])) {
					Same=false;
				}
			}
		}
		
		
		return Same;
	}

}
