<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Police Station </title>
</head>
<body>

<form action = "Initials" method = post >
Enter Your Name  : <input type = "text" name = "name" > <br>
<button type = "Submit"  > Submit </button>
<button type  = "Reset"> Cancel </button>

</form> 
</body>
</html>

//Servlet
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Initials")
public class Initials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Initials() { super(); }
	public String initials(String n)
	{
		String in = Character.toString(n.charAt(0));
	for (int i=0; i<n.length(); i++)
	if (n.charAt(i)==' ' && i+1 < n.length() &&  n.charAt(i+1)!=' ' )
		in+=n.charAt(i+1);
			
		return in.toUpperCase();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("name");
		String in=initials(n);
		out.println(in);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{  doGet(request, response);  }

}
