package src;

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
public class PrintTestFrame extends JFrame
{
	private PrintComponent canvas;JPanel buttonPanel = new JPanel();
	private PrintRequestAttributeSet attributes;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	public PrintTestFrame(BufferedImage img)
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice defaultScreen = env.getDefaultScreenDevice();setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (!defaultScreen.isFullScreenSupported()) 
		{
			JOptionPane.showMessageDialog(null,"Sorry!   FullScreen Not Supported on Your System","Error !!!",
				JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Icon/error.png"));
		}
		this.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
				{
					dispose();
				}
			}
		});
		setTitle("PrintTest");
		canvas = new PrintComponent();canvas.image(img);
		add(canvas, BorderLayout.CENTER);
		attributes = new HashPrintRequestAttributeSet();
		JButton printButton = new JButton("Print");
		buttonPanel.add(printButton);
		printButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					PrinterJob job = PrinterJob.getPrinterJob();
					job.setPrintable(canvas);
					if (job.printDialog(attributes)) job.print(attributes);
				}
				catch (PrinterException e)
				{
					JOptionPane.showMessageDialog(PrintTestFrame.this, e);
				}
			}
		});
		JButton pageSetupButton = new JButton("Page setup");
		buttonPanel.add(pageSetupButton);
		pageSetupButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				PrinterJob job = PrinterJob.getPrinterJob();
				job.pageDialog(attributes);
			}});
		JButton exit = new JButton("Close");buttonPanel.add(exit);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dispose();
			}
		});
		buttonPanel.setBackground(Color.black); add(buttonPanel, BorderLayout.NORTH);
		setUndecorated(true);defaultScreen.setFullScreenWindow(this);setResizable(false);setVisible(true);
	}
}

