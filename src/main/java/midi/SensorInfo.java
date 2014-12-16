package midi;

import java.io.Serializable;

public class SensorInfo implements Serializable
{
	private int				id;
	private String			name;
	private boolean			bActive;
	private boolean			bTrigger;
	private TriggerInfo		ti;
	private ContinousInfo	ci;
	private boolean			bInvert;
	private boolean			bRadiometric;
	private int				reaction;
	
	public int getReaction()
	{
		return reaction;
	}

	public void setReaction(int reaction)
	{
		this.reaction = reaction;
	}

	public SensorInfo(int id)
	{
		this.id = id;
		name = "";
		bActive = true;
		ti = new TriggerInfo();
		ci = new ContinousInfo();
		bInvert = false;
		bRadiometric = true;
		reaction = 10;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean isActive()
	{
		return bActive;
	}
	
	public void setActive(boolean active)
	{
		bActive = active;
	}
	
	public boolean isTrigger()
	{
		return bTrigger;
	}
	
	public void setTrigger(boolean trigger)
	{
		bTrigger = trigger;
	}
	
	public TriggerInfo getTi()
	{
		return ti;
	}
	
	public void setTi(TriggerInfo ti)
	{
		this.ti = ti;
	}
	
	public ContinousInfo getCi()
	{
		return ci;
	}
	
	public void setCi(ContinousInfo ci)
	{
		this.ci = ci;
	}

	public void setRadiometric(boolean radiometric)
	{
		bRadiometric = radiometric;
	}
	
	public boolean isRadiometric()
	{
		return bRadiometric;
	}
	
	public void setInvert(boolean invert)
	{
		bInvert = invert;
	}
	
	public boolean isInvert()
	{
		return bInvert;
	}
}
