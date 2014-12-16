package midi;

import javax.sound.midi.Transmitter;

import de.humatic.mmj.MidiInput;
import de.humatic.mmj.MidiListener;
import de.humatic.mmj.MidiOutput;
import de.humatic.mmj.MidiSystem;
import de.humatic.mmj.MidiSystemListener;

public class MidiTest implements MidiSystemListener
{
	private Object myInPort;
	private MidiInput mi;
	private String[] hexChars = new String[]{"0","1", "2", "3", "4", "5","6","7","8","9","A", "B","C","D","E","F"};
	private MidiOutput mo;

	public MidiTest()
	{
		MidiSystem.initMidiSystem("mmj src", "mmj dest");
		
		for(int i=0;i<MidiSystem.getInputs().length;i++)
		{
			System.out.println("input: " + MidiSystem.getInputs()[i]);
		}
		for(int i=0;i<MidiSystem.getOutputs().length;i++)
		{
			System.out.println("output: " + MidiSystem.getOutputs()[i]);
		}
		
		MidiSystem.addSystemListener(this);
		if (mi != null) {
			mi.close();
			mi = null;
		}
		mi = openInput(0);
		System.out.println(mi.getDeviceInfo());
		if (mo != null) {
			mo.close();
			mo = null;
		}
		mo = openOutput(0);
		System.out.println(mo.getDeviceInfo());
		
		while(true)
		{
			mo.sendMidi(new byte[]{(byte)144, (byte)72, (byte)108}, de.humatic.mmj.MidiSystem.getHostTime());
		}
	
	}
	
	private MidiOutput openOutput(int index) {
		
		return de.humatic.mmj.MidiSystem.openMidiOutput(index);
		
	}	


	public static void main(String args[])
	{
		MidiTest	mt;
		
		mt = new MidiTest();
	}

	private MidiInput openInput(int index) {
		
		MidiInput mi = de.humatic.mmj.MidiSystem.openMidiInput(index);
		
		MidiInputListener mil = new MidiInputListener(mi);
		
		return mi;
		
	}
	
	public void systemChanged()
	{
		// TODO Auto-generated method stub
		
	}

	private class MidiInputListener implements MidiListener {
		
		private MidiInput myInput;
		
		private MidiInputListener(MidiInput in) {
			
			myInput = in;
			
			in.addMidiListener(this);
			
		}
		
		public void midiInput(byte[] data){
			
			System.out.println("Input from: "+myInput.getName());
			for (int i = 0; i < data.length; i++) {
				System.out.print(hexChars[(data[i] & 0xFF) / 16] );
				System.out.print(hexChars[(data[i] & 0xFF) % 16]+"  ");
				if (data.length > 5 && (i+1) % 16 == 0) System.out.println("");
			}
			System.out.println("");
		
		}

	}		

}
