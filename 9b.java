import java.sql.*;
import java.util.Scanner;

public class Q9b {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		int n,id,bal,amt;
		boolean inner=true,outer=true;
		String name,q;
		
		Statement s;
		PreparedStatement ps;
		ResultSet rs;
		SavePoint sp;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			if(!con.isClosed())
				System.out.println("success");
			s=con.createStatement();
			con.setAutoCommit(false);
			
			while(outer) {
				System.out.println("1.entry 2.transact 3.display 4.exit");
				n=in.nextInt();
			
				switch(n) {
					case 1:
						q="insert into bank values (?,?,?)";
						ps=con.prepareStatement(q);
						System.out.print("id: ");
						id=in.nextInt();
						System.out.print("name: ");
						name=in.next();
						System.out.print("balance: ");
						bal=in.nextInt();
						ps.setInt(1, id);
						ps.setString(2, name);
						ps.setInt(3, bal);
						ps.executeUpdate();
						con.commit();
						break;
					case 2:
						System.out.print("please enter your id: ");
						id=in.nextInt();
						while(inner) {
							System.out.println("1.withdraw 2.deposit 3.display details 4.main menu");
							int i=in.nextInt();
							switch(i) {
								case 1:
									sp = con.setSavePoint("sp");
									System.out.print("please enter amount for withdrawal: ");
									amt=in.nextInt();
									q="select * from bank where id="+id;				
									rs=s.executeQuery(q);			
									rs.next();
									bal=rs.getInt("bal");					
									System.out.println(bal);
									bal=bal-amt;						
									System.out.println(bal);						
									q="update bank set bal="+bal+" where id="+id;			
									System.out.println(q);							
									s.executeUpdate(q);							
									System.out.println("balance deducted!");
									if (balance < 0)
										con.rollback(sp);
									con.releaseSavePoint(sp);
									con.commit();
									break;
						
								case 2:
									System.out.print("please enter amount for deposit: ");
									amt=in.nextInt();
									q="select * from bank where id="+id;
									rs=s.executeQuery(q);
									rs.next();
									bal=rs.getInt("bal");
									bal=bal+amt;
									q="update bank set bal="+bal+" where id="+id;
									s.executeUpdate(q);
									System.out.println("balance added!");
									con.commit();
									break;
						
								case 3:
									q="select * from bank where id="+id;							
									rs=s.executeQuery(q);
									rs.next();
									System.out.print("id: "+rs.getInt(1));
									System.out.print("name: "+rs.getString(2));
									System.out.println("bal: "+rs.getInt(3));
									break;

								case 4:
									inner=false;
									break;
							}	
						}
					
					case 3:
						q="select * from bank";
						rs=s.executeQuery(q);
						while(rs.next()) {
							System.out.print("id: "+rs.getInt(1));					
							System.out.print("name: "+rs.getString(2));			
							System.out.println("bal: "+rs.getInt(3));
						}
						break;
					case 4: 
						outer=false;
						break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
