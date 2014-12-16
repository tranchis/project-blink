package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InvertListener implements ChangeListener
{
	private MidiApp midiApp;

	public InvertListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.checkInvert();
	}
}
