import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Print extends JFrame
{
	private PrintComponent canvas;
	private PrintRequestAttributeSet attributes;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	public Print(BufferedImage img,int pr)
	{
		setTitle("PrintTest");
		canvas = new PrintComponent();canvas.image(img);
		add(canvas, BorderLayout.CENTER);
		attributes = new HashPrintRequestAttributeSet();
		if(pr==1)
		{
			try
			{
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(canvas);
				if (job.printDialog(attributes)) job.print(attributes);
			}
			catch (PrinterException e){}
		}
		else if(pr==2)
		{
			PrinterJob job = PrinterJob.getPrinterJob();
			job.pageDialog(attributes);
		}
	}
}
class PrintComponent extends JComponent implements Printable
{
	BufferedImage img;int x,y,x1,y1;
	public void image(BufferedImage img)
	{
		this.img=img;
		x=Toolkit.getDefaultToolkit().getScreenSize().width;
		y=Toolkit.getDefaultToolkit().getScreenSize().height;
		x1=x/2;x1=x1-(img.getWidth()/2);
		y1=y/2;y1=y1-(img.getHeight()/2);y1=y1-30;
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		drawPage(g2);
	}
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException
	{
		if (page >= 1) return Printable.NO_SUCH_PAGE;
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(pf.getImageableX(), pf.getImageableY());
		g2.draw(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf.getImageableHeight()));
		drawPage(g2);
		return Printable.PAGE_EXISTS;
	}
	public void drawPage(Graphics2D g2)
	{
		g2.fillRect(0,0,x,y);g2.drawImage(img,x1,y1,this);
	}
}

