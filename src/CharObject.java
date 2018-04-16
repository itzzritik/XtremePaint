package src;

import java.awt.Color;
import java.io.Serializable;
public class CharObject implements Serializable
{
	private int x;
	private int y;
	private Color farbe;
	public CharObject(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public Color getFarbe() 
	{
		return farbe;
	}
	public void setFarbe(Color farbe) 
	{
		this.farbe = farbe;
	}
	public int getX() 
	{
		return x;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getY() 
	{
		return y;
	}
	public void setY(int y) 
	{
		this.y = y;
	}
}
