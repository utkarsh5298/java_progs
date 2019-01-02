import java.util.Scanner;

public class prog
{
	public static void main(String args[])
	{
		String s = ""; 
		int count = 0;

		System.out.println("Enter your string:"); 
		Scanner sc = new Scanner(System.in);
		s=sc.nextLine();
		s=s.toUpperCase();
		System.out.println(s);
		for(int i=0;i<s.length()-1;i++) 
			if(s.charAt(i) == s.charAt(i+1))
				count+=1;
		
		System.out.println(count);

	}
}
