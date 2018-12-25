//trig
package AdvMath;
public class Trig 
{
	double x,total;


	
	public void cal(int m)
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
	    // triplet:  a^2 + b^2 = c^2
	    int a, b, c=0;
	 
	    //  loop from 2 to max_limitit
	    int m = 2;
	 
	    // Limiting c would limit all a, b and c
	    while (c < limit)
	    {
	        // now loop on j from 1 to i-1
	        for (int n = 1; n < m; ++n)
	        {
	            // Evaluate and print triplets using
	            // the relation between a, b and c
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

import AdvMath.*;

public class prog
{
	public static void main(String args[])
	{
		Trig t=new Trig();
		t.cal(45.0);
		t.display();
		
		Pythagorean pt = new Pythagorean();
		pt.triplets(15);
	}
}
