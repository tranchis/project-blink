package midi;

import com.phidgets.event.TagGainEvent;
import com.phidgets.event.TagGainListener;
import com.phidgets.event.TagLossEvent;
import com.phidgets.event.TagLossListener;

public class RFIDListener implements TagGainListener, TagLossListener
{

	private MidiApp midiApp;

	public RFIDListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void tagGained(TagGainEvent arg0)
	{
		midiApp.tagGained(arg0.getValue());
	}

	public void tagLost(TagLossEvent arg0)
	{
		midiApp.tagLost(arg0.getValue());
	}

}
