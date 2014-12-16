package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RadiometricListener implements ChangeListener
{

	private MidiApp midiApp;

	public RadiometricListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.updateRadiometric();
	}

}
