<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Police Station </title>
</head>
<body>

<form action = "Police" method = post >

<fieldset>
<input type = "radio" name = "n" value = 1 checked > Area <br>
<input type = "radio" name = "n" value = 2 > Phone Number  <br>
Enter area/phone number  : <input type = "text" name = "ap" > <br>
</fieldset>

<button type = "Submit"  > Submit </button>
<button type  = "Reset"> Cancel </button>

</form> 
</body>
</html>

//Servlet
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
/**
 * Servlet implementation class Police
 */
@WebServlet("/Police")
public class Police extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Police() {
		super();
	}
	/*** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "") ;
Statement st = (Statement) conn.createStatement();
ResultSet rs = st.executeQuery("select area,phone from police ");
nt n  = Integer.parseInt(request.getParameter("n"));
int c = 0 ;
switch (n) 
{	case 1 :
	while(rs.next())
	{	String val = request.getParameter("ap");
		if(rs.getString("area").equals(val))
		{
out.println("Area " +val +" Phone " + rs.getString("phone"));
c =1;
break;  }    }   
break;

case 2:
while(rs.next())
{
String val = request.getParameter("ap");				if(rs.getString("phone").equals(val))
{
out.println("Area " +val +" Phone " + rs.getString("phone"));
c = 1;
break;
}			
}
break;

default:
	out.println("Information does not exist");
}

if(c==0)
out.println("Information does not exist");
}
catch(Exception e)
	{
	out.print(e);
	}
}
	/** * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   doGet(request, response);    }

}
