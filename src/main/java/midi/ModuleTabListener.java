package midi;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ModuleTabListener implements ChangeListener
{
	private MidiApp midiApp;

	public ModuleTabListener(MidiApp midiApp)
	{
		this.midiApp = midiApp;
	}

	public void stateChanged(ChangeEvent e)
	{
		JTabbedPane	tp;
		
		tp = (JTabbedPane)e.getSource();
		midiApp.changeModule(tp.getSelectedIndex());
	}
}
