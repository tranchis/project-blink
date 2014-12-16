package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReleaseListener implements ChangeListener
{

	private MidiApp midiApp;

	public ReleaseListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.updateRelease();
	}

}
