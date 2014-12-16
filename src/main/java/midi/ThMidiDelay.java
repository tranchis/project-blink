package midi;

import de.humatic.mmj.MidiOutput;
import de.humatic.mmj.MidiSystem;

public class ThMidiDelay extends Thread
{

	private MidiOutput mo;
	private int time;
	private byte[] bs;

	public ThMidiDelay(MidiOutput mo, int time, byte[] bs)
	{
		this.mo = mo;
		this.time = time;
		this.bs = bs;
	}

	public void run()
	{
		try
		{
			sleep(time);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mo.sendMidi(bs, MidiSystem.getHostTime());
	}
}
