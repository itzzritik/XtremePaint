import javax.swing.ImageIcon;import java.awt.Image;import java.awt.*;
public class Stamp extends CharObject
{
	int staerke;String stamp;int im;
	public int getStaerke() 
	{
		return staerke;
	}
	public void setStaerke(int staerke) 
	{
		this.staerke = staerke;
	}
	public Stamp(int x, int y)
	{
		super(x,y);
	}   
	public void setstamp(String stamp1) 
	{
		this.stamp = stamp1;
	}
	public void setstampimg(String stamp) 
	{
		this.stamp =stamp;
	}
	public String getstamp() 
	{
		return stamp;
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
