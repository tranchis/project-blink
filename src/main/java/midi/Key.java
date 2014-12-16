package midi;

import java.awt.Rectangle;

	/** Piano & Key code basics taken from javasound demos (c) Sun Microsystems **/
     
	 class Key extends Rectangle {
        int noteState = 0;
        int kNum;
        boolean isBlack;
		private MidiApp midiApp;

        public Key(MidiApp midiApp, int x, int y, int width, int height, int num, boolean black) {
            super(x, y, width, height);
        	this.midiApp = midiApp;
            kNum = num;
            isBlack = black;
        }
        public boolean isNoteOn() {
            return noteState == 1;
        }
        public void on(int vel) {
		   try {
			   if (isBlack) vel = vel*2;
			   setNoteState(1);
			   midiApp.sendMidi(new byte[]{(byte)144, (byte)kNum, (byte)vel}, de.humatic.mmj.MidiSystem.getHostTime());
		   
			   System.out.println("kNum: " + kNum + ", vel: " + vel);
			}catch (Exception me) {}
        }
        public void off() {
			try {
			    setNoteState(0);
				midiApp.sendMidi(new byte[]{(byte)128, (byte)kNum, (byte)0}, de.humatic.mmj.MidiSystem.getHostTime());
				
		   }catch (Exception me) {}
        }
        public void setNoteState(int state) {
            noteState = state;
        }

        public void transpose(int oct) {
			kNum += oct*12;
		}
    }

