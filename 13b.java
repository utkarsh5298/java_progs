//create cookies
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		for(int i=1;i<4;i++)
		{
			Cookie mycookie=new Cookie("session"+i,"value"+i);
			response.addCookie(mycookie);
			mycookie=new Cookie("persistent"+i,"value"+i);
			mycookie.setMaxAge(3600);
			response.addCookie(mycookie);
		}
		pw.println("cookie created");
	}

//read cookies
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		Cookie[] cookies=request.getCookies();
		String name="";
		String value="";
		
		if(cookies==null)
			pw.println("No Cookies <br>");
		else {
		for(int i=0;i<cookies.length;i++)
		{
			name=cookies[i].getName();
			value=cookies[i].getValue();
pw.println("<tr> <td>"+ name +"</td>  <td>"+value+"</td> </tr><br>");
	}
	}
}
