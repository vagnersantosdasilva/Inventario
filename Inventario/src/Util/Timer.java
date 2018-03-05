package Util;

public class Timer 
{
	private  long inicio;
	private  long intervalo;
	
	public  void setInicio()
	{
		
		this.inicio = System.currentTimeMillis();
		
	}
	public  long getInicio()
	{
		return inicio;
	}
	public  void setIntervalo()
	{
		this.intervalo =System.currentTimeMillis()-inicio;
	}
	public  long getIntervalo()
	{
		return intervalo;
	}
	

}
