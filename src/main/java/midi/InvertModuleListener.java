package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InvertModuleListener implements ChangeListener
{
	private MidiApp midiApp;

	public InvertModuleListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.checkModuleInvert();
	}
}
