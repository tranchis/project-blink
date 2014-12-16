package midi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class RangeListener implements MouseMotionListener
{
	private MidiApp midiApp;

	public RangeListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void mouseDragged(MouseEvent e)
	{
		midiApp.updateRanges();
	}

	public void mouseMoved(MouseEvent e)
	{
		// midiApp.updateRanges();
	}
}
