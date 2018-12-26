import java.util.Scanner;
class LowCgpaException extends Exception
{
	public String toString()
	{
		return "Low CGPA Exception raised!";

	}
}

class AgeOutOfRangeException extends Exception
{
	public String toString()
	{
		return "Age Out Of Range Exception raised!";

	}
}
public class prog 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Age:");
		int age = sc.nextInt();
		System.out.println("Enter CGPA: ");
		double cgpa = sc.nextDouble();
		int k =1;

		try
		{
			if(age<=25)
			{
				try
				{
					if(cgpa<8)
					{
				throw new LowCgpaException();
					}
					else
						k=0;
				}
				catch (LowCgpaException e)
				{
					System.out.println(e);
				}
			}
			else
			{
			throw new AgeOutOfRangeException();
			}
		}
		catch(AgeOutOfRangeException e)
		{
			System.out.println(e);
		}
		
		if(k==0)
System.out.println("Your application is accepted and is under study!");
}}
	
