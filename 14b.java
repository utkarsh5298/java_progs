"select * from student where cgpa<9";

Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
String query1="select name,cgpa from student";
ResultSet rs1=st1.executeQuery(query1);
    while(rs1.next())
	{
	    	if(rs1.getString("name").equals("john"))
	    	{
	                	break;
	    	}
	}
rs1.updateDouble("cgpa", 9.4);
rs1.updateRow(); 
