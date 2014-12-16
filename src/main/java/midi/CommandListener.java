package midi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandListener implements ActionListener
{
	private char c;
	private MidiApp midiApp;

	public CommandListener(MidiApp midiApp, char c)
	{
		this.c = c;
		this.midiApp = midiApp;
	}

	public void actionPerformed(ActionEvent e)
	{
		midiApp.executeCommand(c);
	}
}
