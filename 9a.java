import java.util.Scanner;

public class Library 
{
	int acc_num;
	String title, author;
	Scanner sc = new Scanner(System.in);
	void input()
	{

		System.out.println("Enter Accession Number:");
		acc_num = sc.nextInt();
		System.out.println("Enter Title:");
		title = sc.next();
		System.out.println("Enter Author Name:");
		author = sc.next();
	}


	void compute()
	{
		System.out.println("Enter Number of days late:");
		int late = sc.nextInt();
		int fine = late * 2;
		System.out.println("The fine is: " + fine + " rupees");
	}

	void display()
	{
	System.out.println(acc_num + " " + title + " " + author + " ");
	}
}

//main method


public class prog
{
	public static void main(String args[])
	{
		Library l = new Library();
		l.input();
		l.compute();
		l.display();
	}
}
