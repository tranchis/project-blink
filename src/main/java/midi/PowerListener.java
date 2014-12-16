package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PowerListener implements ChangeListener
{

	private LEDFrame lf;

	public PowerListener(LEDFrame frame)
	{
		this.lf = frame;
	}

	public void stateChanged(ChangeEvent e)
	{
		lf.updatePower();
	}

}
