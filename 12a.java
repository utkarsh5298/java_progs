class mythread extends Thread
{
	int n;
	mythread(int n)
	{
		this.n=n;
	}
	public void run()
	{
		System.out.println("Running thread "+n);
		while(true)   {}
	}
}

public class prog 
{
	public static void main(String []args)
	{
		mythread t1 = new mythread(1);
		mythread t2 = new mythread(2);
		mythread t3 = new mythread(3);
		mythread t4 = new mythread(4);
		mythread t5 = new mythread(5);
		
		t1.setPriority(9);
		t2.setPriority(8);
		t3.setPriority(7);
		t4.setPriority(6);
		t5.setPriority(5);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		try 
		{
			t1.sleep(100);
			t2.sleep(100);
		} 
catch (InterruptedException e)
		{	
			e.printStackTrace();
		}
		
		if(t1.isAlive())
			System.out.println("Active t1");
		else
			System.out.println("Sleep t1");
		if(t2.isAlive())
			System.out.println("Active t2");
		else
			System.out.println("Sleep t2");
		if(t3.isAlive())
			System.out.println("Active t3");
		else
			System.out.println("Sleep t3");
		if(t4.isAlive())
			System.out.println("Active t4");
		else
			System.out.println("Sleep t4");
		if(t5.isAlive())
			System.out.println("Active t5");
		else
			System.out.println("Sleep t5");		
	}
}
