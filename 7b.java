//form.html
<body>
<form action = "book.jsp" method = post >

Enter Book number : <input type ="text" name = "bno" > <br>
Enter Title :  <input type ="text" name = "title" > <br>
Enter Author: <input type ="text" name = "author" > <br>
Enter Publication  <input type ="text" name = "pub" > <br>
Enter Price  <input type ="text" name = "price" > <br>
<button type = "Submit"> Submit </button>
<button type = "Reset"> Cancel </button>

</form> 
</body>

//book.jsp
<body>
<%@ page import="java.sql.*" %>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
int no = Integer.parseInt(request.getParameter("bno"));
String title = request.getParameter("title");
String author = request.getParameter("author");
String publisher = request.getParameter("pub");
int price = Integer.parseInt(request.getParameter("price"));

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
PreparedStatement pstmt = conn.prepareStatement("insert into books values(?,?,?,?,?)");
	pstmt.setInt(1,no);
	pstmt.setString(2,title);
	pstmt.setString(3,author);
	pstmt.setString(4,publisher);
	pstmt.setInt(5,price);
	pstmt.execute();
	//out.print("Success!");

RequestDispatcher rd = request.getRequestDispatcher("pol2.html");
rd.forward(request,response);
}
catch(Exception e)
{ 
	out.print("Error");
	out.print(e);
}
%>
</body>

//form2.jsp

<body>
<form action = "displaybooks.jsp" method = post >
Enter Title :  <input type ="text" name = "title" > <br>
<button type = "Submit"> Submit </button>
<button type = "Reset"> Cancel </button>
</form> 
</body>

//displaybooks.jsp
<%@ page import = "java.sql.*" %>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
Statement stmt = conn.createStatement();	
String title = request.getParameter("title");
ResultSet rs = stmt.executeQuery("Select * from books where title = '"+title+"'");	
      
while(rs.next())
{
	out.print(" Book No. " +  rs.getInt("bookno") + " Title " + rs.getString("title") + " Author " + rs.getString("author") );
	out.print(" Publisher " + rs.getString("publication") + " Price " + rs.getInt("price"));
}

}

catch(Exception e)
{
	out.print(e);
}
%>
