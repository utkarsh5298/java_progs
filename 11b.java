import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Q11b")
public class Q11b extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Q11b() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","");
    		Statement st = con.createStatement();
    		ResultSet rs=st.executeQuery("select * from subjects");
    		
    		while(rs.next()) {
    			int fid=rs.getInt("FacID");
    			String sub=rs.getString("SubName");
    			out.println("FacID "+fid+" SubName "+sub);
    			out.println("<br>");
    		}			
    		PreparedStatement ps= con.prepareStatement("update subjects set SubName='java' where FacID=1");
    		int n = ps.executeUpdate();
    		out.println("Number of Rows Updated "+n );
    		out.println("<br>");	
    	}
    	catch(Exception e) {
    		out.println(e);
    	}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
