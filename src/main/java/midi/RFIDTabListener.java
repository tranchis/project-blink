package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RFIDTabListener implements ChangeListener
{
	private MidiApp midiApp;

	public RFIDTabListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.updateRFID();
	}
}
