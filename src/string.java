import java.awt.*;
public class string extends CharObject
{
	int staerke;String st;Font font;
	public string(int x, int y)
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
	public Font getFont() 
	{
		return font;
	}
	public void setFont(Font font) 
	{
		this.font = font;
	}
	public String getText() 
	{
		return st;
	}
	public void setText(String st) 
	{
		this.st = st;
	}
}
