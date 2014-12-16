package midi;

import java.io.Serializable;

public class ContinousInfo implements Serializable
{
	protected int			module;
	protected ModuleInfo	mi[];
	
	public ContinousInfo()
	{
		int i;
		
		module = 1;
		mi = new ModuleInfo[3];
		
		for(i=0;i<3;i++)
		{
			mi[i] = new ModuleInfo(i+1);
		}
	}
	
	public int getModule()
	{
		return module;
	}
	public void setModule(int module)
	{
		this.module = module;
	}
	public ModuleInfo[] getMi()
	{
		return mi;
	}
	public void setMi(ModuleInfo[] mi)
	{
		this.mi = mi;
	}
}
