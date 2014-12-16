package midi;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.LEDPhidget;
import com.phidgets.Phidget;
import com.phidgets.PhidgetException;
import com.phidgets.RFIDPhidget;

import de.humatic.mmj.CoreMidiDevice;
import de.humatic.mmj.MidiOutput;

public class PhidgetController extends Thread
{
	InterfaceKitPhidget		p;
	RFIDPhidget				rfid;
	private MidiApp 		midiApp;
	InterfaceKitPhidget		sp;
	String					serverId, port, password;
	LEDPhidget				lp;
	int						serialLP;
	

	public PhidgetController(MidiApp midiApp) throws PhidgetException
	{
		this.midiApp = midiApp;
		
		serialLP = 11111;
		
		p = new InterfaceKitPhidget();
		p.addSensorChangeListener(new TemperatureListener(midiApp));
		rfid = new RFIDPhidget();
		RFIDListener rl = new RFIDListener(midiApp);
		rfid.addTagGainListener(rl);
		rfid.addTagLossListener(rl);
		sp = new InterfaceKitPhidget();
		sp.addSensorChangeListener(new LinearTouchListener(midiApp));
		lp = new LEDPhidget();
	}
	
	public void run()
	{
		String	oldServerId, oldPort, oldPassword;
		int		oldSerialLP;
		
		oldServerId = "";
		oldPort = "";
		oldPassword = "";
		oldSerialLP = serialLP;
		
		while(true)
		{
			serverId = midiApp.getServerID();
			port = midiApp.getPort();
			password = midiApp.getPassword();
			
			try
			{
				if (!lp.isAttached() || oldSerialLP != serialLP || !oldServerId.equals(serverId) || !oldPassword.equals(password))
				{
					try
					{
						lp.close();
					}
					catch(PhidgetException e)
					{
					}
					lp.open(serialLP, serverId, password);
					midiApp.log("Opening LEDPhidget...");
					lp.waitForAttachment(500);
					midiApp.log("LEDPhidget opened.");
				}
			}
			catch (PhidgetException e)
			{
				midiApp.log(e);
				// e.printStackTrace();
			}
			
			try
			{
				if (!sp.isAttached() || !oldServerId.equals(serverId) || !oldPassword.equals(password))
				{
					try
					{
						sp.close();
					}
					catch(PhidgetException e)
					{
					}
					sp.open(28493, serverId, password);
					midiApp.log("Opening LinearTouchPhidget...");
					sp.waitForAttachment(500);
					midiApp.log("LinearTouchPhidget opened.");
				}
			}
			catch (PhidgetException e)
			{
				midiApp.log(e);
				// e.printStackTrace();
			}
	
			try
			{
				try
				{
					p.close();
				}
				catch(PhidgetException e)
				{
				}
				if(!p.isAttached() || !oldServerId.equals(serverId) || !oldPassword.equals(password))
				{
					p.open(67281, serverId, password);
					midiApp.log("Opening InterfaceKitPhidget...");
					p.waitForAttachment(500);
					midiApp.log("InterfaceKitPhidget opened.");
				}
			}
			catch (PhidgetException e)
			{
				midiApp.log(e);
				// e.printStackTrace();
			}
			
			try
			{
				try
				{
					rfid.close();
				}
				catch(PhidgetException e)
				{
				}
				if(!rfid.isAttached() || !oldServerId.equals(serverId) || !oldPassword.equals(password))
				{
					rfid.open(56466, serverId, password);
					midiApp.log("Opening RFIDPhidget...");
					rfid.waitForAttachment(500);
					midiApp.log("RFIDPhidget opened.");
				}
			}
			catch (PhidgetException e)
			{
				midiApp.log(e);
				// e.printStackTrace();
			}
			
			oldServerId = serverId;
			oldPort = port;
			oldPassword = password;
			oldSerialLP = serialLP;
			
			try
			{
				sleep(5000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws PhidgetException
	{
		InterfaceKitPhidget	p;
		ThWaiter		tw;
		double			rot;
		CoreMidiDevice	cmd[];
		int				i;
		MidiOutput		mi;
		String			inputs[];
		
//		MidiSystem.initMidiSystem("Arduino", "VirtualMIDI");
//		cmd = MidiSystem.getDevices();
//		for(i=0;i<cmd.length;i++)
//		{
//			System.out.println(i + ": " + cmd[i].getModel());
//		}
//		
//		inputs = MidiSystem.getInputs();
//		for(i=0;i<inputs.length;i++)
//		{
//			System.out.println(i + ": " + inputs[i]);
//		}
//		
//		mi = MidiSystem.openMidiOutput(0);
//		
//		inputs = MidiSystem.getOutputs();
//		for(i=0;i<inputs.length;i++)
//		{
//			System.out.println(i + ": " + inputs[i]);
//		}
//		
//		while(true)
//		{
//			int padchannel = 51;
//			int padnote = 45;
//			int onchannel = -112 - (padchannel - 1);
//			int offchannel = -128 - (padchannel - 1);
//			int vel = 40;
//			
//			mi.sendMidi(new byte[] { (byte)onchannel, (byte)padnote, (byte)vel }, MidiSystem.getHostTime());
//			//Thread.sleep(vel);
//			mi.sendMidi(new byte[] { (byte)offchannel, (byte)padnote, 0 }, MidiSystem.getHostTime());
//
//		}
		
		Phidget p2 = new InterfaceKitPhidget();
		p = new InterfaceKitPhidget();
		//p.openAny();
		p.open(67281);
		p.waitForAttachment();
		//p2.openAny("localhost", 5001, "hola");
		System.out.println(p.getDeviceID());
	}

	public void updateRadiometric(int sensor, boolean radio)
	{
		if(sensor < 8)
		{
//			p.setRa
		}
	}

	public void updateReaction(int sensor, int reaction) throws PhidgetException
	{
		if(sensor < 8)
		{
			p.setSensorChangeTrigger(sensor, reaction);
		}
		else if(sensor == 13)
		{
			sp.setSensorChangeTrigger(0, reaction);
			sp.setSensorChangeTrigger(1, reaction);
		}
	}

	public void setSerialLP(String serialLP)
	{
		this.serialLP = Integer.parseInt(serialLP);
	}

	public void sendLED(int l, double d)
	{
		try
		{
			if(lp.isAttached())
			{
				lp.setDiscreteLED(l, (int)d);
			}
		}
		catch (PhidgetException e)
		{
			midiApp.log(e);
		}
	}
}
