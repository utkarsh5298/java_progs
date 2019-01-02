import java.sql.*;
import java.util.*;
public class prog{

	public static void main(String[] args) {
		Connection con=null;
		Scanner input=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			con.setAutoCommit(false);
			ResultSet rs;
			rs=stmt.executeQuery("select * from college");
			Savepoint sp1=con.setSavepoint();
			while(rs.next()) {
				if(rs.getDouble("cgpa")<9.0)
				{
					System.out.println(" Students with less than 9 cgpa is "+rs.getString("name"));
				}
				if(rs.getString("Name").equals("John")) {
					rs.updateDouble(4, 9.4);
					rs.updateRow();
					}
				}
			}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(BatchUpdateException e) {e.printStackTrace();}
		catch(SQLException e) {e.printStackTrace();}
		catch (Exception e) {e.printStackTrace();}
		
	}
}
