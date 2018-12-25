class wait_eat
{
	int n;
	boolean value=false;

	synchronized public int eat()
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
		System.out.println("Got Meal number: "+n);
		value = false;
		notify();
		return n;
	}

	synchronized public void wait1(int n)
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
		this.n= n;
		System.out.println("Put Meal number: "+n);
		value = true;
		notify();

	}
}


class t1 extends Thread
{
	wait_eat p;
	t1(wait_eat m)
	{
		p=m;
		this.start();
	}
	public void run()
	{
		int i=0;
		while(true)
		{
			p.wait1(i++);
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class t2 extends Thread
{
	wait_eat p;
	t2(wait_eat m)
	{
		p=m;
		this.start();
	}
	public void run()
	{
		while(true)
		{
			p.eat();
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}

public class prog
{
	public static void main(String args[])
	{
		wait_eat p = new wait_eat();
		new t1(p);
		new t2(p);
	}
}
