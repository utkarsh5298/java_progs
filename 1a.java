//attendence variable store no of class attended out of 54

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
		
		check s1 = new check(1,"A","5B",23);
		s1.calattendance();
		if(s1.eligible())
		{
			System.out.print("Eligible!");
			System.out.println(s1.getValue());
		}
		
		else
		{
			System.out.print("Not eligible!");
			System.out.println(s1.getValue());
			
		}
	}
	
}

