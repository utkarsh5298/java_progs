//main.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "ticket.jsp" method = "post" >
		Enter Name : <input type ="text" name = "name" > <br>
		Enter Age :  <input type ="text" name = "age" > <br>
		<button type = "Submit"> Submit </button>
	</form> 
</body>
</html>


//ticket.jsp
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
	String n = request.getParameter("name");
	int a = Integer.parseInt(request.getParameter("age"));
	out.println("Hello: " + n + " age: " + a + "\n"); 
	if(a>62)
		out.println("Your movie ticket price is Rs 50.00");
	else if(a<10)
		out.println("Your movie ticket price is Rs 30.00");
	else
		out.println("Your movie ticket price is Rs 80.00");
%>
</body>
</html>
