package midi;

import com.phidgets.event.SensorChangeEvent;
import com.phidgets.event.SensorChangeListener;

public class TemperatureListener implements SensorChangeListener
{
	private MidiApp midiApp;

	public TemperatureListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void sensorChanged(SensorChangeEvent arg0)
	{
		System.out.println(arg0.getValue());
		midiApp.changeLevel(arg0.getIndex(), arg0.getValue());
	}
}
