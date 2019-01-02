//register.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "welcome.jsp" method = "post">
		Enter user name: <input type="text" name="user"><br>
		Enter password: <input type="password" name="pass"><br>
		<button type = "submit"> Register </button>
	</form>
</body>
</html>

//welcome.jsp
<%
	String name =request.getParameter("user");
	String password=request.getParameter("pass");
	if(name.equals("admin") && password.equals("1234")) {
		session.setAttribute("user",name);
    	request.getRequestDispatcher("sessiontrace.jsp").forward(request,response);
	}
	else {
		out.println("Not Valid!");	
	}
%>

//sessiontrace.jsp
<%
	if(session!=null) {
		String name=(String)session.getAttribute("user");
		out.println("Hello "+ name +", Welcome");
	}
	else {
		out.println("Please login first");
		request.getRequestDispatcher("register.html").include(request,response);
	}
%>
