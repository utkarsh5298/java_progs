<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Police Station </title>
</head>
<body>
    <form action = "Police" method = "post" >
        <input type = "radio" name = "n" value = 1 > Area <br>
        <input type = "radio" name = "n" value = 2 > Phone Number  <br>
        Enter area/phone number  : <input type = "text" name = "ap" > <br>
        <button type = "Submit"  > Submit </button>
        <button type  = "Reset"> Cancel </button>
    </form> 
</body>
</html>

//Police.java
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Police")
public class Police extends HttpServlet {   
	
	public Police() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "") ;
			Statement st = con.createStatement();
			String sql="";
			boolean flag=true;
			int n = Integer.parseInt(request.getParameter("n"));
			String val = request.getParameter("ap");
			switch (n) { 
				case 1:	
						sql="select area,phone from police where area="+val;
						break;

				case 2:
						sql="select area,phone from police where phone="+val;
						break;

				default:
						flag=false;
						out.println("Information does not exist");
			}
			if(flag) {
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					out.println("Area: "+rs.getString("area"));
					out.println("Phone: "+rs.getString("phone"));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
