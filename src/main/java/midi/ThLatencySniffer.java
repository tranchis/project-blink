package midi;

public class ThLatencySniffer extends Thread
{
	private MidiApp	midiApp;
	private boolean	bFinished;
	private int sensor;
	private int module;
	private double previous, newer, time, difference, progress, base, oldBase, nObs, oldObs;

	public ThLatencySniffer(int sensor, int module, MidiApp midiApp)
	{
		this.midiApp = midiApp;
		this.bFinished = false;
		this.sensor = sensor;
		this.module = module;
		this.previous = 0;
		this.newer = 0;
		this.time = 0;
		this.progress = 0;
		this.base = 0;
		this.oldBase = 0;
		this.nObs = 0;
		this.oldObs = 0;
	}

	public void run()
	{
		double reading;
		
		while(!bFinished)
		{
			try
			{
				//System.out.println("Newer: " + newer + ", Previous: " + previous);
				sleep(40); //midiApp.getLatency(sensor, module));
				time = time + 40;
				progress = time / midiApp.getLatency(sensor, module);
				reading = midiApp.read(sensor, module);
				newer = newer + reading;
				nObs = nObs + 1;
				//System.out.println("Latency in " + sensor + ", " + module + ": " + midiApp.getLatency(sensor, module));
				if(time > midiApp.getLatency(sensor, module))
				{
					difference = newer - previous;
					if(difference != 0)
					{
						//System.out.println("New difference: " + difference);
					}
					previous = newer;
					newer = 0;
					time = 0;
					progress = 0;
					oldBase = base;
					base = reading;
					oldObs = nObs;
					nObs = 0;
				}
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown()
	{
		bFinished = true;
	}

	public double getEase()
	{
		double	formula;
		double	res;
		
		if(difference > 0)
		{
			formula = 1 + Math.sin((progress + 3) * Math.PI / 2);
		}
		else if(difference < 0)
		{
			formula = Math.sin(progress * Math.PI / 2);
		}
		else // difference == 0
		{
			formula = 0;
		}
		
		//System.out.println("base: " + base + ", formula: " + formula + ", progress: " + progress + ", difference: " + difference);
		
		res = midiApp.getNormalizedPosition(oldBase, formula, difference, sensor, module, oldObs, base);
		
		return res;
	}
}
