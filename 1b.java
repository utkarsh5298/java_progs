import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class prog
{
	public static void main(String []args) 
	{
		try 
		{

Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
Statement st = (Statement)con.createStatement();
			
ResultSet rs = st.executeQuery(" select No_of_Employee from Department where Name='CSE' ");
			rs.next();
	
System.out.println(" No of employees in cse department: "+ rs.getInt("No_of_Employee"));

rs =st.executeQuery("select Name,Dept_id from department where Year_Established='2010'");
			while(rs.next())
			{
				String name=rs.getString("Name");
				int did=rs.getInt("Dept_id");
	System.out.println("\n Name: "+name+"\n Dept_id: "+did );
			}
			st.close();
			con.close();

		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
