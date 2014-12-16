package midi;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VelocityListener implements ChangeListener
{

	private LEDFrame lf;

	public VelocityListener(LEDFrame frame)
	{
		this.lf = frame;
	}

	public void stateChanged(ChangeEvent e)
	{
		lf.updateVelocity();
	}

}
