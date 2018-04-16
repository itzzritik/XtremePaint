public class Eraser extends CharObject 
{
	private int staerke,xZiel,yZiel;
	public Eraser(int x, int y)
	{
		super(x,y);staerke=0;
	}
	public int getStaerke() 
	{
		return staerke;
	}
	public void setStaerke(int staerke) 
	{
		this.staerke = staerke;
	}
	public int getXZiel() 
	{
		return xZiel;
	}
	public void setXZiel(int ziel) 
	{
		xZiel = ziel;
	}
	public int getYZiel() 
	{
		return yZiel;
	}
	public void setYZiel(int ziel) 
	{
		yZiel = ziel;
	}
}
