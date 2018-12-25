//student package 
package Student;


public class stud_details 
{
	String USN, Dept_name, g1,g2,g3;
	double sgpa;
	
	public stud_details(String u,String d,String gr1,String gr2,String gr3,double sg)
	{
		USN=u;
		Dept_name=d;
		g1=gr1;
		g2=gr2;
		g3=gr3;
		sgpa=sg;
	}
	
	public void display()
	{
		System.out.println(" USN : "+ USN+"\n Department name :"+ Dept_name + "\n Grade 1 "+g1+"\n Grade 2 "+g2+"\n Grade 3 "+g3+"\n SGPA: "+sgpa);
	}

}

//staff package 
package Staff;
public class staff_details {

	String Staffid, StaffName, Designation, subjects;
	
	public staff_details(String i,String n,String d,String s)
{
		Staffid=i;
		StaffName=n;
		Designation=d;
		subjects=s;
	}
	
	public void display()
	{
		System.out.println("\n Staffid:  "+Staffid+"\n StaffName "+StaffName+"\n Designation "+ Designation +"\n Subject handled "+subjects);
	}

}

//main

import Student.*;
import Staff.*;
public class prog
{
	public static void main(String []args) 
	{
		stud_details s1 = new stud_details("1MS15CS148","CSE","S","A","S",9.70);
		s1.display();
		
		staff_details s2 = new staff_details("TE001","ABC","HOD", "Mathematics");
		s2.display();
	}
}
