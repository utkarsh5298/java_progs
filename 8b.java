<body>
<form action = 'gradetest.jsp' method = post >
Enter Your Marks :<input type="text" name="marks">
<button type="submit" >Submit </button>
</form>
</body>

//gradetest.jsp

<body>
<%
int m = Integer.parseInt(request.getParameter("marks"));

if (m>90)
	out.print("A");
else if(m>80)
	out.print("B");
else if(m>70)
	out.print("C");
else 
	out.print("FAIL");
%>
</body>
