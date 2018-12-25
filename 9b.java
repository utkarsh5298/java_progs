import java.sql.*;
import java.util.Scanner;
public class qb9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n;
		int id,bal;
		int t;
		String name;
		String q;
		PreparedStatement ps;
		int amt;
		Statement s;
		ResultSet rs;
		try
		{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
if(!con.isClosed())
System.out.println("success");
s=con.createStatement();
con.setAutoCommit(false);
while(true)
{
System.out.println("1.entry 2.transact 3.display 4.exit");
n=in.nextInt();
switch(n)
{
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
		while(true)
	{
System.out.println("1.withdraw 2.deposit 3.display details 4.rollback 5. commit 6.main menu");
int i=in.nextInt();
switch(i)
	{
	case 1:
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
			break;
						

case 3:
               q="select * from bank where id="+id;							
              rs=s.executeQuery(q);
			        rs.next();
							System.out.print("id "+rs.getInt(1));
							System.out.print("  name "+rs.getString(2));
							System.out.println("  bal "+rs.getInt(3));
break;
						
case 4:
							System.out.println("rollback because of failure!");
							con.rollback();
              q="select * from bank where id="+id;
							rs=s.executeQuery(q);
              rs.next();
							System.out.print("id "+rs.getInt(1));
							System.out.print("  name "+rs.getString(2));
							System.out.println("  bal "+rs.getInt(3));
			break;
						
case 5:
							System.out.println("commiting successfully!");
							con.commit();							
              q="select * from bank where id="+id;							
              rs=s.executeQuery(q);							
              rs.next();
							System.out.print("id "+rs.getInt(1));					
              System.out.print("  name "+rs.getString(2));			
              System.out.println("  bal "+rs.getInt(3));
			break;

case 6:
break;
						}
						
					}
case 3:
	q="select * from bank";
	rs=s.executeQuery(q);
	while(rs.next()) {
	System.out.print("id "+rs.getInt(1));
	System.out.print("  name "+rs.getString(2));
	System.out.println("  bal "+rs.getInt(3));
				}
				break;
				case 4: break;
				}
					
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
