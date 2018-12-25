import java.util.Scanner;

class NameException extends Exception
{
	public String toString()
	{
		return ("Name Exception");
	}
}

class AgeException extends Exception
{
	public String toString()
	{
		return ("Age Exception");
	}
}
class Emp_Details
{
	int age;
	String name;
	Emp_Details(int a,String n)
	{
		age=a;
		name=n;
	}
}
public class prog {
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age: ");  
		int age = sc.nextInt();
		System.out.println("Enter your name: ");  
		String name = sc.next();
		int nx=1, ax=1; 
		try
		{
			try
			{
				int ns = Integer.parseInt(name);
			}

			catch(Exception e)
			{
				nx=0;
			}
			if(nx==1)
				throw new NameException();
		}

		catch(NameException e)
		{
			System.out.println(e);
			ax=0;
		}


		try
		{
			if(age>50)
			{
				throw new AgeException();
			}
		}
		catch(AgeException e)
		{
			System.out.println(e);
			ax=0;
		}
		catch(Exception e)
		{
			System.out.println(e);
			ax=0;
		}

		if(ax==1)
		{
			new Emp_Details(age,name);
			System.out.println("Object created successfully! \n Name: "+ name+" \n Age: "+ age);
		}
	}

}
