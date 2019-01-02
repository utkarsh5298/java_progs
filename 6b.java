//html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "Empdeets" method = post >
		Enter Employee Id : <input type ="text" name = "id" > <br>
		Enter Employee Name :  <input type ="text" name = "name" > <br>
		Enter Address : <input type ="text" name = "add" > <br>
		Enter DOB (yyyy-mm-dd):  <input type ="text" name = "dob" > <br>
		<button type = "Submit"> Submit </button>
		<button type = "Reset"> Cancel </button>
	</form> 
</body>
</html>

//servlet.java

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Empdeets")
public class Empdeets extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Empdeets() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String add = request.getParameter("add");
		String dob = request.getParameter("dob");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","");
			PreparedStatement ps =  conn.prepareStatement("insert into Employee values(?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, add);
			ps.setString(4, dob);
			ps.execute();
			out.print("Successfully inserted the values");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Employee");
			out.print("<table border='1'> <tr> <th>Name</th> <th>Id</th> <th>Address</th> <th>DOB</th> </tr>");

			while(rs.next()) {
				name = rs.getString("employee_name");
				id =rs.getInt("empid");
				add =rs.getString("address");
				dob =rs.getString("date_of_birth");
				out.println("<tr> <td> "+ name +" </td> <td> "+id +" </td><td> "+add+" </td> <td> "+dob+" </td></tr> ");
			}
			out.println("</table>");
		}
		
		catch(Exception e) {
			out.print("ERROR");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
