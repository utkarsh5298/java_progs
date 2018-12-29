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
		System.out.println(" USN: "+ USN+"\n Department name: "+ Dept_name + "\n Grade 1: "+g1+"\n Grade 2: "+g2+"\n Grade 3: "+g3+"\n SGPA: "+sgpa);
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
		System.out.println("\n Staffid:  "+Staffid+"\n StaffName: "+StaffName+"\n Designation: "+ Designation +"\n Subject handled: "+subjects);
	}

}

//main

import Student.*;
import Staff.*;
import java.util.Scanner;
public class prog
{
	public static void main(String []args) 
	{
		String usn="";String dept="";String g1="";String g2="";String g3="";double sgpa=0.0;
		String sid="";String sname="";String des="";String subj="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter USN: ");
		usn=sc.next();
		System.out.println("Enter Dept: ");
		dept=sc.next();
		System.out.println("Enter Grade 1: ");
		g1=sc.next();
		System.out.println("Enter Grade 2: ");
		g2=sc.next();
		System.out.println("Enter Grade 3: ");
		g3=sc.next();
		System.out.println("Enter SGPA: ");
		sgpa=sc.nextDouble();
		stud_details s1 = new stud_details(usn,dept,g1,g2,g3,sgpa);
		System.out.println("Enter StaffID: ");
		sid=sc.next();
		System.out.println("Enter StaffName: ");
		sname=sc.next();
		System.out.println("Enter Designation: ");
		des=sc.next();
		System.out.println("Enter Subject Handled: ");
		subj=sc.next();
		staff_details s2 = new staff_details(sid,sname,des,subj);
		s1.display();
		s2.display();
	}
}

