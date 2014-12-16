package midi;

public class LEDSensorInfo
{
	private double	min, max;
	private boolean	invert;
	private double	multiplier;
	
	public LEDSensorInfo()
	{
		min = 950;
		max = 1000;
		invert = false;
		multiplier = 1.0;
	}
	
	public double getMin()
	{
		return min;
	}
	public void setMin(double d)
	{
		this.min = d;
	}
	public double getMax()
	{
		return max;
	}
	public void setMax(double d)
	{
		this.max = d;
	}
	public boolean isInvert()
	{
		return invert;
	}
	public void setInvert(boolean invert)
	{
		this.invert = invert;
	}
	public double getMultiplier()
	{
		return multiplier;
	}
	public void setMultiplier(double multiplier)
	{
		this.multiplier = multiplier;
	}
}
