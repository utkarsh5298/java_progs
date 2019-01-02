import java.sql.*;

public class Q1b {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			Statement st = con.createStatement();
			st.execute("Create table department (Dept_id int primary key,Name varchar(255),Year_Est varchar(5),number_emp int)");
			st.execute("insert into department values(1,'CSE','2010',10),(2,'ISE','2010',8)");
			ResultSet rs = st.executeQuery(" select number_emp from Department where Name='CSE' ");
			rs.next();
			System.out.println(" No of employees in cse department: "+ rs.getInt("number_emp"));
			rs =st.executeQuery("select Name,Dept_id from department where Year_Est='2010'");
			while(rs.next())
			{
				String name=rs.getString("Name");
				int did=rs.getInt("Dept_id");
				System.out.println("\n Name: "+name+"\n Dept_id: "+did );
			}
			st.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
