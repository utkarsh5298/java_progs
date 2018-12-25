<body>
<form action="Cookieread" method="post">
Enter name:<input type="text" name="name"><br>
Enter panid :<input type="text" name="panid"><br>
Enter password:<input type="text" name="password"><br>
<button type="submit">Submit</button><br>
<button type="reset">Cancel</button>
</form> 
</body>

//cookie read

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
	Cookie mycookie=new Cookie("panid","-999");
	mycookie.setMaxAge(3600);
	response.addCookie(mycookie);

RequestDispatcher rd=request.getRequestDispatcher("Cookiewrite");
	rd.forward(request, response);

}


//cookie write

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
				response.setContentType("text/html");
PrintWriter out=response.getWriter();

		Cookie[] cookies=request.getCookies();
		String name="";
		String value="";
		String n1 = request.getParameter("name");
		String pid = request.getParameter("panid");
		int c=0;

for(int i=0; i<cookies.length; i++)
{
	name = cookies[i].getName();
	value = cookies[i].getValue();
	if(name.equals("admin") && value.equals(pid))
	{
		out.println("Welcome "+ n1);
		c=1;
		break;	
	}
}

if(c==0)
{
	Cookie mycookie = new Cookie("admin",pid);
	mycookie.setMaxAge(3600);
	response.addCookie(mycookie);
	out.println("welcome");
}
out.close();
}
