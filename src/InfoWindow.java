package src;

import javax.swing.*;
import java.awt.*;import java.io.*;
import java.awt.event.*;
import java.lang.reflect.Method;
public class InfoWindow extends JPanel implements Runnable
{
	int sx=0,sy=0,tx=0,ty=0,p=1,halfX=0,pp=5,pa=0,l=295,lines=2;Thread th=new Thread(this);
	ButtonGroup page = new ButtonGroup();JRadioButton page1=new JRadioButton();JRadioButton page2=new JRadioButton();
	JButton left =new JButton(new ImageIcon("Icon/Arrow_Left.png"));JButton right =new JButton(new ImageIcon("Icon/Arrow_Right.png"));
	JButton Java=new JButton("World of Java");JButton Home=new JButton("Home");
	int l1=250,l2=330,l3=335,linx=310,liny=310;
	
	String Text[]={"XTREME PAINT",
	"This is a Unique Application Created Specially For Painting.",
	"It is a Painting Application Loaded With Lots of Fun Painting Tools.",
	"It is Loaded With Other Tools Which Makes It Better Than Other Paint Application.",
	"AWESOME FEATURES",
	"Faster Saving and Loading Function.",
	"Save Your Progress in The Form of Project Files, Which Can Be Re-Loaded Any Time.",
	"It Has Its Own Supported Projects Saving Extention => \"*.xtp\"",
	"Unlimited Undo and Redo, Till Possible.",
	"Draw an Image and Set it as Desktop Wallpaper.",
	"It Has Two Unique Modes => Window Mode and FullScreen Mode.",
	"It Has an Exellent Feature, To Preview Your Drawing in Full Screen.",
	"It Has a Unique Stamp Feature, That Lets You Play With Stamps.",
	"It Also Has a Unique Frame Feature, That Improves your Creativity of Painting.",
	"It Has a Unique Colour Picker, That Helps to Get The Color That is On Your Canvas.",
	"The Best Feature Is Its Unique ScreenShot Function."};
	String Backup[]=new String[Text.length]; 
	Font VDUB;
	public InfoWindow()
	{
		super();
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("Icon/pencil1.gif").getImage(), new Point(00,00), "Pencil"));
		setOpaque(false);setDoubleBuffered(true);setLayout(null);
		left.setFocusable(false);page1.setFocusable(false);page2.setFocusable(false);right.setFocusable(false);Java.setFocusable(false);Home.setFocusable(false);
		page.add(page1);page.add(page2);page1.setSelected(true);
		Java.setVisible(false);Home.setVisible(false);Java.setBackground(Color.black);Home.setBackground(Color.black);Java.setForeground(Color.white);
		Home.setForeground(Color.white);Java.setFont(new Font("Comic Sans MS",Font.BOLD, 17));Home.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
		add(left);add(page1);add(page2);add(right); add(Java);add(Home);
		
		left.setBorderPainted(false);left.setBorder(null);left.setContentAreaFilled(false);
		left.setPressedIcon(new ImageIcon("Icon/Arrow_Left Pressed.png"));left.setRolloverIcon(new ImageIcon("Icon/Arrow_Left_2.png"));
		right.setBorderPainted(false);right.setBorder(null);right.setContentAreaFilled(false);
		right.setPressedIcon(new ImageIcon("Icon/Arrow_Right Pressed.png"));right.setRolloverIcon(new ImageIcon("Icon/Arrow_Right_2.png"));
		
		Java.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		left.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		right.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		page1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		page2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		left.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(p==0){page1.doClick();p=1;}else{page2.doClick();p=0;}
			}
		});
		right.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(p==0){page1.doClick();p=1;}else{page2.doClick();p=0;}
			}
		});
		this.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e){}
			public void keyPressed(KeyEvent e){}
			public void keyReleased(KeyEvent e){if(e.getKeyCode()==37){left.doClick();}else if(e.getKeyCode()==39){right.doClick();}}
		});
		
		page1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(pp==5&&pa==1){pa=0;pp=1;}else if(pp==4&&pa==1){pa=0;pp=0;}
			}
		});
		
		page2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(pp==5&&pa==0){pa=1;pp=1;}else if(pp==4&&pa==0){pa=1;pp=0;}
			}
		});
		
		Java.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				openURL("http://www.ritikstore.weebly.com/world-of-java.html");
			}
		});
		Home.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				openURL("http://www.ritikstore.weebly.com/index.html");
			}
		});
		try
		{
			VDUB= Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("Icon/VDUB.TTF"));
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(VDUB);VDUB=VDUB.deriveFont(40.0f);
		}
		catch(Exception e){}
	}
	public void openURL(String url) 
	{
		String osName = System.getProperty("os.name");
		try
		{
			if (osName.startsWith("Windows"))
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			else 
			{
				String[] browsers = { "firefox", "opera", "konqueror","epiphany", "mozilla", "netscape" };
				String browser = null;
				for (int count = 0; count < browsers.length && browser == null; count++)
				{
					if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0)
						browser = browsers[count];
					Runtime.getRuntime().exec(new String[] { browser, url });
				}
			}
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Error in opening browser"+":\n" + e.getLocalizedMessage());
		}
	}
	public void what(int i){try{if(i==0){}else if(i==1){th.start();}}catch(Exception ef){}}
	public void run()
	{
		while(true)
		{
			if(pp==1)
			{
				pp=4;
				for (int i=0; i<Text.length; i++)
				{
					Backup[i]=Text[i];
				}
				for (int i=4; i<Text.length; i++)
				{
					if(i==4){lines=2;}Text[i]="";l=l+40;linx=1000;liny=1000;lines=lines+5;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				}
				Text[15]="   Please Visit My Website ( Homepage )        =>";l3=400;lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[14]="                    For More Fun Please Enter World of Java   =>";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}Java.setVisible(true);
				Text[13]="";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}Home.setVisible(true);
				Text[12]="                            ! ! ! ! !   Thank You   ! ! ! ! !";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[11]="                And I Wish That You Enjoyed This Application.";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[10]="          I Want to Thank You For Using This Paint Application.";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[9]=" Hi User, I am Ritik Srivastava Creator and Designer of This Application.";l2=470;lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[8]="           ";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[7]="        This Application Also Have Very Attractive Interface.";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[6]="                                This Application Has High Graphics Content.";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[5]="This Application is Implemented in Java.";l1=273;lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				Text[4]="    THANKING YOU !!!";lines=lines-5;l=l-40;repaint();try{Thread.sleep(10);}catch(Exception ef){}lines=2;l=295;linx=250;liny=250;repaint();
			}
			else if(pp==0)
			{
				for (int i=4; i<Text.length; i++)
				{
					Text[i]="";l=l+40;linx=1000;liny=1000;lines=lines+5;repaint();if(i==13){Home.setVisible(false);Java.setVisible(false);}try{Thread.sleep(10);}catch(Exception ef){}
				}
				pp=5;l1=250;l2=330;l3=335;
				for (int i=Text.length-1; i>=4; i--)
				{
					Text[i]=Backup[i];l=l-40;lines=lines-5;repaint();try{Thread.sleep(10);}catch(Exception ef){}
				}lines=2;l=295;linx=310;liny=310;
				repaint();
			}
			try{Thread.sleep(500);}catch(Exception ef){}
		}
	}
	public void siz(Dimension size)
	{
		sx=(int)size.getWidth();sy=(int)size.getHeight();requestFocus();halfX=sx/2;
		page1.setBounds((sx/2)-20,sy-50,20,20);page2.setBounds((sx/2),sy-50,20,20);
		left.setBounds((sx/2)-300,sy-65,50,50);right.setBounds((sx/2)+300-50,sy-65,50,50);
		Java.setBounds(halfX+260,670,150,40);Home.setBounds(halfX+260,710,150,40);
	}
	public void paintComponent(Graphics g2d)
	{
		Graphics2D g = (Graphics2D) g2d;g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if (g instanceof Graphics2D) 
		{
			Paint p =new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 230),0.0f, getHeight(), new Color(0,0,0,160), true);
			Graphics2D gg = (Graphics2D)g;gg.setPaint(p);gg.fillRect(0, 0, getWidth(), getHeight());
		}
		tx=halfX-100;ty=(sy/2);
		g.setColor(Color.white);
		VDUB=VDUB.deriveFont(50.0f);g.setFont(VDUB);
		g.drawString(Text[0], halfX-260,60);
		g.setStroke(new BasicStroke(2));g.drawLine(halfX-280,70,halfX+280,70);
		
		g.setFont(new Font("Segoe UI",Font.BOLD, 28));
		g.drawString(Text[1],halfX-395,120);
		g.drawString(Text[2],halfX-445,160);
		g.drawString(Text[3],halfX-540,200);
		
		g.setStroke(new BasicStroke(5));g.drawLine(0,230,sx,230);
		
		VDUB=VDUB.deriveFont(38.0f);g.setFont(VDUB);
		g.setStroke(new BasicStroke(lines,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));g.drawLine(halfX-linx,l,halfX+liny,l);
		g.drawString(Text[4],halfX-285,280);
		
		g.setFont(new Font("Segoe UI",Font.BOLD, 28));
		
		g.drawString(Text[5],halfX-l1,340);
		g.drawString(Text[6],halfX-550,380);
		g.drawString(Text[7],halfX-410,420);
		g.drawString(Text[8],halfX-270,460);
		g.drawString(Text[9],halfX-l2,500);
		g.drawString(Text[10],halfX-430,540);
		g.drawString(Text[11],halfX-425,580);
		g.drawString(Text[12],halfX-408,620);
		g.drawString(Text[13],halfX-505,660);
		g.drawString(Text[14],halfX-535,700);
		g.drawString(Text[15],halfX-l3,740);
	}
}