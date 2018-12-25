//main.html
<body>
<form action = "ticket.jsp" method = post >
Enter Name : <input type ="text" name = "name" > <br>
Enter Age :  <input type ="text" name = "age" > <br>
<button type = "Submit"> Submit </button>
</form> 
</body>


//ticket.jsp
<body>
<%
String n = request.getParameter("name");
int a = Integer.parseInt(request.getParameter("age"));
out.println("Hello, " + n + " " + a + " "); 
if(a>62)
	out.println("Your movie ticket price is Rs 7.00");
else if(a<10)
	out.println("Your movie ticket price is Rs 5.00");
else
	out.println("Your movie ticket price is Rs 9.50");
%>
</body>
