package midi;

import java.awt.Color;

public class LEDRFIDInfo
{
	private boolean[]	active;
	private Color		color;

	public LEDRFIDInfo()
	{
		int	i;
		
		active = new boolean[64];
		for(i=0;i<64;i++)
		{
			active[i] = false;
		}
		color = Color.WHITE;
	}
	
	public boolean[] getActive()
	{
		return active;
	}
	public void setActive(boolean[] active)
	{
		this.active = active;
	}
	public Color getColor()
	{
		return color;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
}
