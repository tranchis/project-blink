package midi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RFIDNameListener implements ActionListener, KeyListener
{

	private MidiApp midiApp;

	public RFIDNameListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void actionPerformed(ActionEvent e)
	{
	}

	public void keyPressed(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
		midiApp.updateRFIDName();
	}

	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
