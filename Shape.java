public class Shape extends CharObject
{
	private int hoehe;int staerke;
	private int breite;
	public int getStaerke() 
	{
		return staerke;
	}
	public void setStaerke(int staerke) 
	{
		this.staerke = staerke;
	}
	public Shape(int x, int y)
	{
		super(x,y);
	}	
	public int getBreite() 
	{
		return breite;
	}
	public void setBreite(int breite) 
	{
		this.breite = breite;
	}
	public int getHoehe() 
	{
		return hoehe;
	}
	public void setHoehe(int hoehe) 
	{
		this.hoehe = hoehe;
	}
}
