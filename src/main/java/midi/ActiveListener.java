package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ActiveListener implements ChangeListener
{
	private MidiApp midiApp;

	public ActiveListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.checkActive();
	}
}
