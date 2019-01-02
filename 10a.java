//trig
package AdvMath;
public class Trig 
{
	double x,total;
	public void cal(double m)
	{
		x = Math.toRadians(m);
		total = Math.sin(x)+ Math.cos(x)+ Math.tan(x);
	}
	public void display()
	{
		System.out.println("sinx + cosx + tanx = " + total);
	}
}

//pythagorean triplets
package AdvMath;
public class Pythagorean 
{
	
	public void triplets(int limit)
	{
	    int a, b, c=0;
	    int m = 2;
	    while (c < limit)
	    {
	        for (int n = 1; n < m; ++n)
	        {
	            a = m*m - n*n;
	            b = 2*m*n;
	            c = m*m + n*n;
	 
	            if (c > limit)
	                break;
	 
	            System.out.println(a + " " + b + " " +c);
	        }
	        m++;
	    }
	}

}

//main
import java.util.Scanner;
import AdvMath.*;
public class prog
{
	public static void main(String args[])
	{
		double angle=0.0;
		int limit=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Angle: ");
		angle=sc.nextDouble();
		Trig t=new Trig();
		t.cal(angle);
		t.display();
		
		Pythagorean pt = new Pythagorean();
		System.out.println("Enter Limit: ");
		limit=sc.nextInt();
		pt.triplets(limit);
	}
}
