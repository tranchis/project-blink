package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReactionListener implements ChangeListener
{

	private MidiApp midiApp;

	public ReactionListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		midiApp.updateReaction();
	}

}
