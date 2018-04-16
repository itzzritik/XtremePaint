public class Frames extends CharObject
{
	int staerke;String frame;int im;
	public int getStaerke() 
	{
		return staerke;
	}
	public void setStaerke(int staerke) 
	{
		this.staerke = staerke;
	}
	public Frames(int x, int y)
	{
		super(x,y);
	}   
	public void setframe(String frame) 
	{
		this.frame = frame;
	}
	public void setframeimg(String frame) 
	{
		this.frame = frame;
	}
	public String getframe() 
	{
		return frame;
	}
	public int getIm() 
	{
		return im;
	}
	public void setIm(int im) 
	{
		this.im =im;
	}
}
