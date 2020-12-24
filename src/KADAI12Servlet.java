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
* Servlet implementation class Page1Servlet
*/
@WebServlet("/KADAI12Servlet")
public class KADAI12Servlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KADAI12Servlet() {
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
                        PreparedStatement st;
                        st = connection.prepareStatement(
                                        "select email ,count(*) from oubo group by email order by count(*) desc"
                                        );
                
                        ResultSet rs = st.executeQuery();
                                      
                        ArrayList<String[]> list = new ArrayList<String[]>();
                        int count = 0;
                        
                        while(rs.next() != false && count < 10) {
                                count++;
                                String[] s = new String[1];
                                s[0] = rs.getString("EMAIL");
                                list.add(s);
                        }
                        
                        
                        request.setAttribute("result", list);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/Kadai12.jsp");
                        rd.forward(request, response);
                        
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }

}