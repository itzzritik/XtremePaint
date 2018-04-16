public class Tube extends CharObject 
{
	private int staerke;
	public Tube(int x, int y)
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
