package midi;

import com.phidgets.event.SensorChangeEvent;
import com.phidgets.event.SensorChangeListener;

public class LinearTouchListener implements SensorChangeListener
{
	private MidiApp midiApp;

	public LinearTouchListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void sensorChanged(SensorChangeEvent arg0)
	{
		midiApp.changeLinear(arg0.getIndex(), arg0.getValue());
	}
}
