//register.html
<form action = "welcome.jsp" method = post>
Enter user name: <input type="text" name="user"><br>
Enter password: <input type="text" name="pass"><br>

<button type = "submit"> Register </button>
</form>


//welcome.jsp
<%
String name =request.getParameter("user");
String password=request.getParameter("pass");
if(name.equals("admin") && password.equals("1234"))
{
	out.println("Welcome "+ name);
	HttpSession s = request.getSession();
	session.setAttribute("user",name);
    request.getRequestDispatcher("sessiontrace.jsp").forward(request,response);
}
else
out.println("Not Valid! ");
%>

//sessiontrace.jsp
<%
HttpSession s=request.getSession(false);
if(session!=null)
{
	String name=(String)session.getAttribute("user");
	out.println("Hello "+ name +" Welcome");
}
else
{
	out.println("Please login first");
	request.getRequestDispatcher("register.html").include(request,response);
}
%>
