//form.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "book.jsp" method = "post" >
		Enter Book number : <input type ="text" name = "bno" > <br>
		Enter Title :  <input type ="text" name = "title" > <br>
		Enter Author: <input type ="text" name = "author" > <br>
		Enter Publication  <input type ="text" name = "pub" > <br>
		Enter Price  <input type ="text" name = "price" > <br>
		<button type = "Submit"> Submit </button>
		<button type = "Reset"> Cancel </button>
	</form> 
</body>
</html>

//book.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*" %>
	<%@ page import="javax.servlet.RequestDispatcher" %>
	<%
		int no = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("pub");
		int price = Integer.parseInt(request.getParameter("price"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			PreparedStatement ps = con.prepareStatement("insert into books values(?,?,?,?,?)");
			ps.setInt(1,no);
			ps.setString(2,title);
			ps.setString(3,author);
			ps.setString(4,publisher);
			ps.setInt(5,price);
			ps.execute();
			RequestDispatcher rd = request.getRequestDispatcher("pol2.html");
			rd.forward(request,response);
		}
		catch(Exception e) { 
			out.print("Error");
			out.print(e);
		}
	%>
</body>
</html>

//pol2.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "displaybooks.jsp" method = "post" >
		Enter Title :  <input type ="text" name = "title" > <br>
		<button type = "Submit"> Submit </button>
		<button type = "Reset"> Cancel </button>
	</form> 
</body>
</html>
//displaybooks.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*" %>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			Statement stmt = conn.createStatement();	
			String title = request.getParameter("title");
			ResultSet rs = stmt.executeQuery("Select * from books where title = '"+title+"'");	
      
			while(rs.next()) {
				out.print("Book No.: "+rs.getInt("no")+"<br>");
				out.print("Title: "+rs.getString("title")+"<br>");
				out.print("Author: "+rs.getString("author")+"<br>");
				out.print("Publisher: "+rs.getString("publisher")+"<br>");
				out.print("Price: "+rs.getInt("price")+"<br>");
				out.print("<br>");
			}
		}
		catch(Exception e) {
			out.print(e);
		}
	%>
</body>
</html>
