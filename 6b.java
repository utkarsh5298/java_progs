//html
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

//servlet

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@WebServlet("/Empdeets")
public class Empdeets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Empdeets() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String add = request.getParameter("add");
		String dob = request.getParameter("dob");
		
		try
		{

Class.forName("com.mysql.jdbc.Driver");
Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","");
PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("insert into Employee values(?,?,?,?)");
			pstmt.setInt(1,id);
			pstmt.setString(2, name);
			pstmt.setString(3, add);
			pstmt.setString(4, dob);
			pstmt.execute();
out.print("Successfully inserted the values");

Statement st = (Statement) conn.createStatement();
ResultSet rs = st.executeQuery("select * from Employee");
out.print("<table> <tr> <th>Name</th> <th>Id</th> <th>Address</th> <th>DOB</th> </tr>");

while(rs.next()) 
{
	name = rs.getString("employee_name");
	id =rs.getInt("empid");
	add =rs.getString("address");
	dob =rs.getString("date_of_birth");
out.println("<tr> <th> "+ name +" </th> <th> "+id +" </th><th> "+add+" </th> <th> "+dob+" </th></tr> ");
}
out.println("</table>");
}
		
catch(Exception e)
{out.print("ERROR");}
}
	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{ 
doGet(request, response);
}

}
