package midi;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class KeyAction extends AbstractAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6222237063154700072L;
	private int counter;
	private MidiApp midiApp;

	public KeyAction(MidiApp midiApp, int counter)
	{
		this.counter = counter;
		this.midiApp = midiApp;
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println(counter);
		midiApp.tabChange(counter);
	}
}
