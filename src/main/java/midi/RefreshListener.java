package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RefreshListener implements ChangeListener
{

	private MidiApp midiApp;

	public RefreshListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.updateRefresh();
	}

}
