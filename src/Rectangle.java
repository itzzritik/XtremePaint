package src;

  
public class Rectangle extends CharObject 
{	
	private boolean filled;
	private int hoehe;int staerke;
	private int breite;
	public Rectangle(int x, int y)
	{
		super(x,y);
	}
	public int getStaerke() 
	{
		return staerke;
	}
	public void setStaerke(int staerke) 
	{
		this.staerke = staerke;
	}
	public boolean isFilled() 
	{
		return filled;
	}
	public void setFilled(boolean filled) 
	{
		this.filled = filled;
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
