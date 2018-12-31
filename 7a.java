import java.util.Scanner;

class Record
{
	String[] name= new String[50];
	int[] rnk= new int[50];
	
	Record()
	{
		System.out.println("Constructor call ");
	}
	
	void readvalues()
	{
		for(int i=0;i<=10;i++) 
		{
			Scanner sc = new Scanner(System.in);  
			System.out.println("Enter your name: ");  
			name[i]=sc.next();  
			System.out.println("Enter your rank: ");  
			rnk[i]=sc.nextInt();
		}

	}
	
	void display()
	{
		for(int i=0;i<=10;i++) 
		{
System.out.println("\n Name: " + name[i] + "\n Rank: " + rnk[i]);  
		}
	}
}



class Rank extends Record
{
	int index;
	Rank()
	{
		super();
		index=0;
	}
	
	void highest()
	{
		int max=999;
		for(int i=0;i<=10;i++) 
		{
			if(max>=rnk[i])
			{
				index =i;
				max=rnk[i];
			}
		}
	}
	
	
	void display()
	{
		super.display();
		System.out.println("\n\n Top most rank is : " +name[index] + "\n Rank is " + rnk[index] );
	
	}
}



public class prog 
{
	public static void main(String args[])
	{
                     Rank r = new Rank();
	      r.readvalues();
	      r.highest();
	      r.display();

	}
}
