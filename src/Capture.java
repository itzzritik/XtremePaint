package src;

import java.awt.image.*;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;
public class Capture 
{
	ImageIcon img=new ImageIcon();
	public ImageIcon Screen()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		final Dimension d = kit.getScreenSize();
		Rectangle rect = new Rectangle(d);
		try 
		{
			Robot robot = new Robot();
			final BufferedImage image = robot.createScreenCapture(rect);
			image.flush();img=new ImageIcon(image);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return(img);
	}
}