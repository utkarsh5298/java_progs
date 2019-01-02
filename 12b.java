<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="check.jsp" method="post">
        Enter username:<input type="text" name="name"><br>
        Enter age:<input type="text" name="age"><br>
        Enter marks:<input type="text" name="marks"><br>
        <button type="submit">Submit</button><br>
        <button type="reset">Cancel</button>
    </form>
</body>
</html>

//check.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int marks=Integer.parseInt(request.getParameter("marks"));
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));

	if(marks>=20)
		out.println("Eligible for SEE");
	else
		out.println("Not Eligible");

	RequestDispatcher rd=request.getRequestDispatcher("counter.jsp");
	rd.include(request,response);
%>
</body>
</html>
//counter.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.io.*,java.util.*" %>
	<%
		Integer hitsCount = (Integer)application.getAttribute("hitCounter"); 
		if( hitsCount == null || hitsCount == 0 ) {
            	out.println("Welcome to my website!");
        	    hitsCount = 1;
		} 
		else {
			out.println("Welcome back to my website!");
			hitsCount += 1;
		}
		application.setAttribute("hitCounter", hitsCount);
	%>
	<p>Total number of visits: <%= hitsCount%></p>
</body>
</html>
