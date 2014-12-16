package midi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ApplyConfigListener implements MouseListener
{
	private MidiApp midiApp;

	public ApplyConfigListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e)
	{
		midiApp.updateConfig();
	}

}
