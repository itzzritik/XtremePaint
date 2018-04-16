public class Tray extends CharObject 
{
	private int staerke;
	public Tray(int x, int y)
	{
		super(x,y);
		staerke=0;
	}
	public int getStaerke() 
	{
		return staerke;
	}
	public void setStaerke(int staerke) 
	{
		this.staerke = staerke;
	}
}
