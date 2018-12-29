//attendence variable store no of class attended out of 54
import java.util.Scanner;
interface student{
	String getValue();
}

interface department{
	float getattendance();
}

interface exam extends student,department{
	float calattendance();
	boolean eligible();	
}

class check implements exam{
	
	int sno;
	String sname;
	String clas;
	float attendance;
	float perc;
	
	public check(int s, String name, String c, float a) {
		sno=s;
		sname=name;
		clas=c;
		attendance=a;
	}
	
	@Override
	public String getValue() {
		return ("\nStudent Number: " +sno +"\nStudent Name: " +sname +"\nClass: " +clas +"\nAttendace: " +attendance + "\nAttendace Percentage: "+perc );
	}

	@Override
	public float getattendance() {
		return perc;
	}

	@Override
	public float calattendance() {
		perc = (attendance/54)*100;
		return perc;
	}

	@Override
	public boolean eligible() {
		if (perc>=85) 
			{return true;}
		else
			{return false;}
	}
	
}
public class prog {
	
	public static void main(String [] args) {
		int sno1=0;
		String sname1=" ";
		String clas1=" ";
		float attendance1=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number: ");
		sno1=sc.nextInt();
		System.out.println("Enter Name: ");
		sname1=sc.next();
		System.out.println("Enter Class: ");
		clas1=sc.next();
		System.out.println("Enter Att: ");
		attendance1=sc.nextFloat();
		check s1 = new check(sno1,sname1,clas1,attendance1);
		s1.calattendance();
		if(s1.eligible())
		{
			System.out.println(s1.getValue());
			System.out.print("Eligible!");
		}
		
		else
		{
			System.out.println(s1.getValue());
			System.out.print("Not eligible!");
			
		}
	}
	
}

