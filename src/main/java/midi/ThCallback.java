package midi;

public class ThCallback extends Thread
{

	private MidiApp midiApp;
	private	int		rate;

	public ThCallback(MidiApp midiApp)
	{
		this.midiApp = midiApp;
		this.rate = 40;
	}

	public void run()
	{
		while(true)
		{
			try
			{
				sleep(rate);
				// System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			midiApp.checkSensor();
		}
	}

	public void setRate(int value)
	{
		rate = value;
	}
}
