package midi;

public class ThWaiter extends Thread
{
	public void run()
	{
		try
		{
			sleep(10000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
