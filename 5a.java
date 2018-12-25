class display
{
	
boolean value=false;

	synchronized public void welcome()
	{
		while(!value)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		System.out.println("Welcome");
		value = false;
		notify();

	}

	synchronized public void goodbye()
	{
		while(value)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

		}
		System.out.println("Good Bye");
		value = true;
		notify();
	}

}





class t1 extends Thread
{
	display p;
	t1(display m)
	{
		p=m;
		this.start();
	}
	
	public void run()
	{
		while(true)
		{
			p.welcome();
		}
	}
}






class t2 extends Thread
{
	display p;
	t2(display m)
	{
		p=m;
		this.start();
	}
	
	public void run()
	{
		while(true)
		{
			p.goodbye();
		}
	}
}




public class prog 
{
	public static void main (String [] args)
	{
		display p = new display();
		new t1(p);
		new t2(p);
	}
}
