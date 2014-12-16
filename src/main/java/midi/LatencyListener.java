package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LatencyListener implements ChangeListener
{
	private MidiApp midiApp;

	public LatencyListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.checkLatency();
	}
}
