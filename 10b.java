<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Cookieread" method="post">
		Enter name:<input type="text" name="name"><br>
		Enter panid :<input type="text" name="panid"><br>
		Enter password:<input type="text" name="password"><br>
		<button type="submit">Submit</button>
		<button type="reset">Cancel</button>
	</form> 
</body>
</html>

//Cookieread.java
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookieread")
public class Cookieread extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public Cookieread() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String panid=request.getParameter("panid");
    	Cookie mycookie=new Cookie("admin",panid);
    	mycookie.setMaxAge(3600);
    	response.addCookie(mycookie);
    	RequestDispatcher rd=request.getRequestDispatcher("Cookiewrite");
    	rd.forward(request, response);

   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


//Cookiewrite.java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookiewrite")
public class Cookiewrite extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    public Cookiewrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] cookies=request.getCookies();
		String name="";
		String value="";
		String n1 = request.getParameter("name");
		String pid = request.getParameter("panid");
		int c=0;
		
		for(int i=0; i<cookies.length; i++) {
			name = cookies[i].getName();
			value = cookies[i].getValue();
			if(name.equals("admin") && value.equals(pid)) {
				out.println("Welcome Back"+ n1);
				c=1;
				break;	
			}
		}
		
		if(c==0) {
			Cookie mycookie = new Cookie("admin",pid);
			mycookie.setMaxAge(3600);
			response.addCookie(mycookie);
			out.println("Welcome");
		}
		out.close();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
