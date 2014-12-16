package midi;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainTabListener implements ChangeListener
{
	private MidiApp ma;

	public MainTabListener(MidiApp ma)
	{
		this.ma = ma;
	}

	public void stateChanged(ChangeEvent e)
	{
		int index;
		
		index = ((JTabbedPane)e.getSource()).getSelectedIndex();
		ma.activateSpecialTab(index == 8, index == 9);
		ma.activateTab(index);
	}
}
