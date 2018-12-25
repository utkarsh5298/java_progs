protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	
	try
		{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","");
Statement st = (Statement) conn.createStatement();
ResultSet rs=st.executeQuery("select * from subjects");
	while(rs.next())
	{
	int fid=rs.getInt("FacID");
String sub=rs.getString("SubName");
	out.println("FacID "+fid+" SubName "+sub);
	out.println("<br>");
	}			
PreparedStatement pst=(PreparedStatement) conn.prepareStatement("update subjects set SubName='java' where SubID=1 and FacID=1");
int n = pst.executeUpdate();
out.println("Number of Rows Updated "+n );
out.println("<br>");	
}
catch(Exception e)
{
out.println(e);
}
}
