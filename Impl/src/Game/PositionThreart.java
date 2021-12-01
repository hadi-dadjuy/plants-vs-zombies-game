package Game;

public  class PositionThreart 
{
	private static boolean p1Thraet=false;
	private static boolean p2Thraet=false;
	private static boolean p3Thraet=false;
	private static boolean p4Thraet=false;
	private static boolean p5Thraet=false;

	
	public static void setPosition1Threat(boolean b)
	{
		p1Thraet=b;
	}
	public static void setPosition2Threat(boolean b)
	{
		p2Thraet=b;
	}
	public static void setPosition3Threat(boolean b)
	{
		p3Thraet=b;
	}
	public static void setPosition4Threat(boolean b)
	{
		p4Thraet=b;
	}
	public static void setPosition5Threat(boolean b)
	{
		p5Thraet=b;
	}
	
	
	public static boolean getP1Condition()
	{
		return p1Thraet;
	}
	public static  boolean getP2Condition()
	{
		return p2Thraet;

	}
	public static boolean getP3Condition()
	{
		return p3Thraet;

	}
	public static boolean getP4Condition()
	{
		return p4Thraet;

	}
	public static boolean getP5Condition()
	{
		return p5Thraet;

	}
	
	
	public static boolean isThreat(int position)
	{
		if(position==1)
			return getP1Condition();
		else if(position==2)
			return getP2Condition();
		else if(position==3)
			return getP3Condition();
		else if(position==4)
			return getP4Condition();
		else 
			return getP5Condition();
		
		
	}
	

	public static void setThreat(int position,boolean b)
	{
		if(position==1)
			setPosition1Threat(b);		
		else if(position==2)
			setPosition2Threat(b);		
		else if(position==3)
			setPosition3Threat(b);		
		else if(position==4)
			setPosition4Threat(b);		
		else 
			setPosition5Threat(b);		
	}
	
	
	public static void setDefault()
	{
		p1Thraet=false;
		p2Thraet=false;
		p3Thraet=false;
		p4Thraet=false;
		p5Thraet=false;
	}

}
