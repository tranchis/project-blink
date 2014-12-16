package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SustainListener implements ChangeListener
{

	private LEDFrame lf;

	public SustainListener(LEDFrame frame)
	{
		this.lf = frame;
	}

	public void stateChanged(ChangeEvent e)
	{
		lf.updateSustain();
	}

}
