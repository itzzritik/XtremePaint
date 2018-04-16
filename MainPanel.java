import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.Color;
import java.awt.Robot;
import java.awt.AWTException;
public class MainPanel extends JPanel implements MouseListener, MouseMotionListener
{
	String ico=" ",img="Icon/pencil.png",im1="Drawing\\Stamps\\java.png",im2=null;int p=0,L=0,O=0,S=0,xx=0,yy=0,yes=0,s1,s2,s3=0,et=0,ef=0;
	private MainWindow mw;Color col=new Color(255,255,255);int posx=0,posy=0,px=0,py=0;ImageIcon screen=new ImageIcon();int cap=0;
	private int x;Toolkit toolkit = Toolkit.getDefaultToolkit();int iop=0;private int y;String font2="";int xZiel,yZiel;int paint=0;
	private int staerke;private boolean firstClick,firstFrei;private String Drawing;ArrayList draw;ArrayList res;
	private Color Farbe;private Color bgFarbe;private boolean filled;String key="";
	int za;BufferedImage theImage;JPanel colo=new JPanel();JRadioButtonMenuItem p0,p1,p2,p3,p4,p5;Graphics g;
	JPanel TextPane=new JPanel();JTextArea textArea = new JTextArea();JScrollPane areaScrollPane = new JScrollPane(textArea);
	JButton AddText=new JButton("Add Text");JButton Close=new JButton("Close");JPanel Buttons=new JPanel(new BorderLayout());
	public boolean img(String p)
	{
		String ex="";
		for(int i=p.length()-1;i>=0;i--)
		{
			char t=p.charAt(i);
			if(t=='.')
			{
				for(int j=i+1;j<p.length();j++)
				{
					ex=ex+p.charAt(j);
				}
			}
		}
		if(!ex.equalsIgnoreCase("ico")){return true;}return false;
	}
	public void fnt()
	{
		textArea.setFont(new Font(font2,Font.PLAIN,staerke));
		int hei=staerke+(staerke/3);if(hei>=80){areaScrollPane.setPreferredSize(new Dimension((int)getSize().getWidth()-200,hei));}else
		{areaScrollPane.setPreferredSize(new Dimension((int)getSize().getWidth()-200,65));}
		if(iop>5){if(hei>=60){Buttons.setPreferredSize(new Dimension(80,hei));}else{Buttons.setPreferredSize(new Dimension(80,60));}}iop++;
		TextPane.setPreferredSize(new Dimension((int)getSize().getWidth(),500));
	}
	public void Text_Pane()
	{
		Close.setBackground(Color.black);Close.setForeground(Color.white);Close.setPreferredSize(new Dimension(80,30));Close.setFocusable(false);
		Close.setToolTipText("Closes The Input Text Box");Close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText("");TextPane.setVisible(false);
			}
		});
		Close.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e){}public void mousePressed(MouseEvent e){Close.setBackground(Color.red);Close.setForeground(Color.black);}
			public void mouseExited(MouseEvent e){Close.setBackground(Color.black);Close.setForeground(Color.white);}public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e){Close.setBackground(new Color(100,0,0));}
		});
		
		AddText.setForeground(Color.white);AddText.setBackground(Color.black);AddText.setPreferredSize(new Dimension(80,30));AddText.setFocusable(false);
		AddText.setToolTipText("Add The Text Into The Drawing Panel");AddText.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				TextPane.setVisible(false);String Txt=textArea.getText();if(Txt!=null){string sm=new string(px,py);sm.setStaerke(staerke);
					sm.setFarbe(Farbe);sm.setText(Txt);sm.setFont(new Font(font2,Font.PLAIN,staerke));draw.add(sm);res.add(sm);}repaint();textArea.setText("");
				}
			});
		AddText.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e){}public void mousePressed(MouseEvent e){AddText.setBackground(new Color(0,150,0));AddText.setForeground(Color.black);}
			public void mouseExited(MouseEvent e){AddText.setBackground(Color.black);AddText.setForeground(Color.white);}public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e){AddText.setBackground(new Color(0,30,0));}
		});
		
		
		textArea.setColumns(100);textArea.setRows(2);textArea.setWrapStyleWord(true);textArea.setLineWrap(true);textArea.setFocusable(true);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);areaScrollPane.setFocusable(true);
		areaScrollPane.setPreferredSize(new Dimension((int)getSize().getWidth(),80));
		
		textArea.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e){}
			public void keyPressed(KeyEvent e){if(e.getKeyCode()==27){Close.setBackground(Color.red);}}
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode()==27){Close.doClick();Close.setBackground(Color.black);}
			}
		});
		
		Buttons.add(Close,BorderLayout.NORTH);Buttons.add(AddText,BorderLayout.CENTER);
		Buttons.setOpaque(false);Buttons.setPreferredSize(new Dimension(80,60));
		TextPane.setVisible(false);TextPane.setOpaque(false);TextPane.add(areaScrollPane);TextPane.add(Buttons);TextPane.setFocusable(true);
		TextPane.setCursor(toolkit.createCustomCursor(new ImageIcon("Icon/pencil1.gif").getImage(), new Point(xx,yy), "Pencil"));
		TextPane.setPreferredSize(new Dimension((int)getSize().getWidth(),90));
	}
	public MainPanel(MainWindow MW)
	{
		super();mw=MW;Drawing="Pencil";run();setLayout(new BorderLayout());
		setSize(300,300);
		addMouseListener(this);addMouseMotionListener(this);
		setDoubleBuffered(true);
		x=0; y=0;
		xZiel=0;yZiel=0;
		firstClick=true;
		staerke=1;
		draw = new ArrayList();
		res = new ArrayList();
		Farbe=Color.black;
		filled=false;
		bgFarbe=Color.white;
		firstFrei=true;colo.setOpaque(false);
        //add(colo,BorderLayout.CENTER);
		Text_Pane();add(TextPane,BorderLayout.NORTH);
	}
	public void run()
	{
		if(yes==0)
		{
			if(Drawing.equals("Rectangle")||Drawing.equals("Oval")||Drawing.equals("Line")||Drawing.equals("Shape")||Drawing.equals("Fill_Curve"))
				{img="Icon/Crosshair.png";xx=15;yy=15;}
			else if(Drawing.equals("Eraser")||Drawing.equals("Tube")||Drawing.equals("Tray")||Drawing.equals("Dotted"))
				{img="Icon/Target.png";xx=11;yy=11;}
			else if(Drawing.equals("Stamp")||Drawing.equals("Text"))
				{img=" ";xx=11;yy=11;}
			else if(Drawing.equals("Frames")){img="Icon\\stop.png";xx=11;yy=11;}Image image = new ImageIcon(img).getImage();
			if(Drawing.equals("Pick")){ImageIcon ig=new ImageIcon(new ImageIcon("Icon\\Dropper1.png").getImage().getScaledInstance(32,32,  java.awt.Image.SCALE_SMOOTH));
			xx=00;yy=ig.getIconHeight()-1;image=ig.getImage();}
			Point hotSpot = new Point(xx,yy);
			Cursor cursor= toolkit.createCustomCursor(image, hotSpot, "Pencil");
			setCursor(cursor);img="Icon/pencil.png";xx=0;yy=0;
		}
	}
	public void drawing(Graphics2D g)
	{
		g.setColor(bgFarbe);g.fillRect(0,0,getWidth(), getHeight());
		if(cap==1){g.drawImage(screen.getImage(),0,0,this);}
		if(!ico.equals(" "))
		{
			if(img(ico))
			{
				Image imagg=Toolkit.getDefaultToolkit().getImage(ico);
				int IW=new ImageIcon(imagg).getIconWidth(),IH=new ImageIcon(imagg).getIconHeight();
				int PW=(int)getSize().getWidth(),PH=(int)getSize().getHeight();double temp=(((PH*100f)/IH)/100f);
				int WWW=IW;int HHH=IH;if(IH>PH){HHH=PH;WWW=(int)(((double)IW)*temp);};        
				g.drawImage(imagg,0,0,WWW,HHH,this);
			}
			else
			{
				try
				{
					File file = new File(ico);sun.awt.shell.ShellFolder sf = sun.awt.shell.ShellFolder.getShellFolder(file);
					g.drawImage(sf.getIcon(true),0,0,this);
				}
				catch(Exception e){}
			}
		}
		for(int i=0; i<draw.size(); i++)
		{
			if(String.valueOf(draw.get(i)).startsWith("Rectangle"))
			{
				Rectangle r = (Rectangle)draw.get(i);p=i;
				g.setColor(r.getFarbe());g.setStroke(new BasicStroke(r.getStaerke()));
				if(r.isFilled())
					g.fillRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());
				else{g.drawRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());}g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("Oval"))
			{
				Oval o = (Oval)draw.get(i);O=i;
				g.setColor(o.getFarbe());g.setStroke(new BasicStroke(o.getStaerke()));
				if(o.isFilled())
					g.fillOval(o.getX(), o.getY(), o.getBreite(), o.getHoehe());
				else{g.drawOval(o.getX(), o.getY(), o.getBreite(), o.getHoehe());}g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("Line"))
			{
				Line l = (Line)draw.get(i);L=i;g.setColor(l.getFarbe());
                 //if(l.getStaerke()<5){g.setStroke(new BasicStroke(5));}
                 //else{g.setStroke(new BasicStroke(l.getStaerke()));}
				g.setStroke(new BasicStroke(l.getStaerke(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				g.drawLine(l.getX(), l.getY(), l.getBreite(), l.getHoehe());g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("Shape"))
			{
				Shape sh = (Shape)draw.get(i);S=i;
				g.setColor(sh.getFarbe());g.setStroke(new BasicStroke(sh.getStaerke()));
				g.drawLine(sh.getX(), sh.getY(), sh.getBreite(), sh.getHoehe());s1=sh.getBreite();s2=sh.getHoehe();g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("FreieZusammen"))
			{
				Composition z = (Composition)draw.get(i);
				g.setColor(z.getFarbe());g.setStroke(new BasicStroke(z.getStaerke(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				g.drawLine(z.getX(), z.getY(), z.getXZiel(), z.getYZiel());g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("Fill_Curve"))
			{
				Fill_Curve fi = (Fill_Curve)draw.get(i);
				g.setColor(fi.getFarbe());g.setStroke(new BasicStroke(fi.getStaerke()));
				g.drawLine(fi.getX(), fi.getY(), fi.getXZiel(), fi.getYZiel());g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("Dotted"))
			{
				Dotted f = (Dotted)draw.get(i);
				g.setColor(f.getFarbe());
				g.fillOval(f.getX(), f.getY(), f.getStaerke(), f.getStaerke());
			}
			else if(String.valueOf(draw.get(i)).startsWith("Tube"))
			{
				Tube tu = (Tube)draw.get(i);
				g.setColor(tu.getFarbe());
				g.drawOval(tu.getX(), tu.getY(), tu.getStaerke(), tu.getStaerke());
			}
			else if(String.valueOf(draw.get(i)).startsWith("Tray"))
			{
				Tray tr = (Tray)draw.get(i);
				g.setColor(tr.getFarbe());g.setStroke(new BasicStroke(2));
				g.drawRect(tr.getX(), tr.getY(), tr.getStaerke(), tr.getStaerke());g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("Eraser"))
			{
				Eraser fd = (Eraser)draw.get(i);g.setStroke(new BasicStroke(fd.getStaerke(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
				g.setColor(bgFarbe);g.fillRect(fd.getX(), fd.getY(), fd.getStaerke(), fd.getStaerke());g.setStroke(new BasicStroke(1));
			}
			else if(String.valueOf(draw.get(i)).startsWith("string"))
			{
				string st = (string)draw.get(i);g.setColor(st.getFarbe());int X=st.getX(),Y=st.getY();int siz=st.getStaerke();
				g.setStroke(new BasicStroke(siz/40));g.setFont(st.getFont());String txt[]=st.getText().split("\n");
				for(int ip=0;ip<=txt.length-1;ip++)
				{
					if(ip==0){siz=(st.getStaerke()/2)*(ip+1);}
					else{siz=((st.getStaerke())*(ip+1))-st.getStaerke()/2;}
					g.drawString(txt[ip],st.getX(),(st.getY()+siz));
				}
			}
			else if(String.valueOf(draw.get(i)).startsWith("Stamp"))
			{
				Stamp st = (Stamp)draw.get(i);ImageIcon ime=new ImageIcon(st.getstamp());
				int w=(ime.getIconWidth()/20)*(st.getStaerke());int h=(ime.getIconHeight()/20)*(st.getStaerke());
				g.drawImage(ime.getImage(),st.getX()-(w/2), st.getY()-(h/2),w,h,this);
			}
			else if(String.valueOf(draw.get(i)).startsWith("Frames"))
			{
				try
				{
					Frames fr = (Frames)draw.get(i);ImageIcon ime=new ImageIcon(fr.getframe());int sz=fr.getStaerke();
					for(int tr=-2;tr<getWidth()-ime.getIconWidth();tr=tr+ime.getIconWidth())
					{
						g.drawImage(ime.getImage(),tr,0,this);
					}
					for(int tr=0;tr<getHeight()-ime.getIconHeight();tr=tr+ime.getIconHeight())
					{
						g.drawImage(ime.getImage(),getWidth()-ime.getIconWidth()-5,tr,this);
					}
					for(int tr=-2;tr<getWidth()-ime.getIconWidth();tr=tr+ime.getIconWidth())
					{
						g.drawImage(ime.getImage(),tr,getHeight()-ime.getIconHeight()-9,this);
					}
					for(int tr=0;tr<getHeight()-ime.getIconHeight();tr=tr+ime.getIconHeight())
					{
						g.drawImage(ime.getImage(),-2,tr,this);
					}
					for(int j=i; j>=0; j--){if(j!=0&&String.valueOf(draw.get(j-1)).startsWith("Frames")){draw.remove(j-1);}}break;
				}
			catch(Exception e){}
		}
	}
}
public void paintComponent(Graphics g2d)
{
	final Graphics2D g = (Graphics2D) g2d;g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	drawing(g);g.setColor(Farbe);  
	if(xZiel!=0 && yZiel!=0 && firstClick==false)
	{
		if(Drawing.equals("Rectangle"))
		{
			if(p>0){Rectangle r = (Rectangle)draw.get(p);g.setStroke(new BasicStroke(staerke));p=0;}
			if(filled){g.fillRect(x,y,xZiel,yZiel);}
			else{g.drawRect(x,y,xZiel,yZiel);}
			g.setStroke(new BasicStroke(1));
		}
		else if(Drawing.equals("Oval"))
		{
			if(O>0){Oval o = (Oval)draw.get(O);g.setStroke(new BasicStroke(staerke));O=0;}
			if(filled){g.fillOval(x,y,xZiel,yZiel);}
			else{g.drawOval(x,y,xZiel,yZiel);}
			g.setStroke(new BasicStroke(1));
		}
		else if(Drawing.equals("Line"))
		{
			if(L>0){Line l = (Line)draw.get(L);g.setStroke(new BasicStroke(staerke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));L=0;}
			g.drawLine(x,y,xZiel,yZiel);
		}
		else if(Drawing.equals("Shape"))
		{
			if(S>0){Shape sh = (Shape)draw.get(S);g.setStroke(new BasicStroke(staerke));S=0;}if(s3==0){s1=x;s2=y;}
			g.drawLine(s1,s2,xZiel,yZiel);
		}
		else if(Drawing.equals("Dotted"))
		{
			yes=1;run();;Image image = toolkit.getImage(" ");
			Cursor cursor= toolkit.createCustomCursor(image, new Point(0,0), "Pencil");setCursor(cursor);
			g.fillOval(xZiel,yZiel, staerke,staerke);
		}
		else if(Drawing.equals("Tube"))
		{
			yes=1;run();;Image image = toolkit.getImage(" ");
			Cursor cursor= toolkit.createCustomCursor(image, new Point(0,0), "Pencil");setCursor(cursor);
			g.drawOval(xZiel,yZiel, staerke,staerke);
		}
		else if(Drawing.equals("Tray"))
		{
			yes=1;run();Image image = toolkit.getImage(" ");
			Cursor cursor= toolkit.createCustomCursor(image, new Point(0,0), "Pencil");setCursor(cursor);
			g.drawRect(xZiel,yZiel, staerke,staerke);
		}
		else if(Drawing.equals("Eraser"))
		{
			yes=1;run();Image image = toolkit.getImage(" ");
			Cursor cursor= toolkit.createCustomCursor(image, new Point(0,0), "Pencil");setCursor(cursor);
			g.setColor(bgFarbe);g.fillRect(xZiel,yZiel, staerke,staerke);g.setColor(Farbe);g.drawRect(xZiel,yZiel, staerke,staerke);
		}
		else if(Drawing.equals("Pencil")||Drawing.equals("Fill_Curve"))
		{
			g.drawLine(x,y,xZiel,yZiel);
		}
	}
	else
	{
		if(Drawing.equals("Stamp")&&paint==0)
		{
			if(im1!=null)
			{
				ImageIcon img1=new ImageIcon(im1);int w=(img1.getIconWidth()/20)*(staerke);int h=(img1.getIconHeight()/20)*(staerke);
				g.drawImage(img1.getImage(),xZiel-(w/2),yZiel-(h/2),w,h,this);
			}
			if(im2!=null)
			{
				Image img2=Toolkit.getDefaultToolkit().getImage(im2);
				ImageIcon img3=new ImageIcon(img2);int w=(img3.getIconWidth()/20)*staerke;int h=(img3.getIconHeight()/20)*staerke;
				g.drawImage(img2,xZiel-(w/2),yZiel-(h/2),w,h,this);
			}
			int siz=8;ImageIcon cen=new ImageIcon("Icon/cur.png");int ww=xZiel-(siz/2);int hh=yZiel-(siz/2);
			g.drawImage(cen.getImage(),ww,hh,siz,siz,this);
		}
		else if(Drawing.equals("Text"))
		{
			if(staerke/40>=1){g.setStroke(new BasicStroke(staerke/40));}else{g.setStroke(new BasicStroke(1));}
			int si=staerke/2;g.drawLine(xZiel,yZiel-si,xZiel,(yZiel+staerke)-si);
			g.drawLine(xZiel-(staerke/5),yZiel-si,xZiel+(staerke/5),yZiel-si);
			g.drawLine(xZiel-(staerke/5),(yZiel+staerke)-si,xZiel+(staerke/5),(yZiel+staerke)-si);g.setStroke(new BasicStroke(1));
		}
	}
}  
public void mouseReleased(MouseEvent e)
{
	if(paint==0){
		if(et==0){firstClick=true;firstFrei=true;yes=0;run();
			if(e.getButton() == MouseEvent.BUTTON1)
			{
				if(Drawing.equals("Rectangle"))
				{
					Rectangle r = new Rectangle(x,y);
					r.setStaerke(staerke);
					r.setHoehe(yZiel);
					r.setBreite(xZiel);
					r.setFilled(filled);
					r.setFarbe(Farbe);
					draw.add(r);res.add(r);
				}
				if(Drawing.equals("Oval"))
				{
					Oval o = new Oval(x,y);
					o.setStaerke(staerke);
					o.setHoehe(yZiel);
					o.setBreite(xZiel);
					o.setFilled(filled);
					o.setFarbe(Farbe);
					draw.add(o);res.add(o);
				}
				if(Drawing.equals("Line"))
				{
					Line l = new Line(x,y);
					l.setStaerke(staerke);
					l.setFarbe(Farbe);
					l.setBreite(xZiel);
					l.setHoehe(yZiel);
					draw.add(l);res.add(l);
				}
				if(Drawing.equals("Shape"))
				{
					int x1,x2;
					if(s3==0){x1=x;x2=y;}else{x1=s1;x2=s2;}
					Shape sh = new Shape(x1,x2);
					sh.setStaerke(staerke);
					sh.setFarbe(Farbe);
					sh.setBreite(xZiel);
					sh.setHoehe(yZiel);
					draw.add(sh);res.add(sh);
				}
				else if(Drawing.equals("Text"))
				{
					areaScrollPane.setPreferredSize(new Dimension((int)getSize().getWidth()-200,staerke+40));TextPane.setVisible(true);textArea.requestFocus();
				}
			}}
			et=0;s3=1;repaint();}
		}
		public void mouseClicked(MouseEvent e)
		{
		}
		public void mouseEntered(MouseEvent e)
		{if(paint==0){if(Drawing.equals("Stamp")||Drawing.equals("Text")){xZiel=e.getX();yZiel=e.getY();}}}
		public void mousePressed(MouseEvent e)
		{
			if(paint==0)
			{
				setFocusable(true);
				if(e.getButton() == MouseEvent.BUTTON1)
				{
					if(Drawing.equals("Stamp"))
					{
						Stamp st = new Stamp(e.getX(),e.getY());
						st.setStaerke(staerke);
						if(im1!=null){st.setstamp(im1);st.setIm(1);}
						if(im2!=null){st.setstampimg(im2);st.setIm(2);}
						draw.add(st);res.add(st);
					}
					else if(Drawing.equals("Text"))
					{
						px=e.getX();py=e.getY();
					}
					else if(Drawing.equals("Pick"))
					{
						ef=0;et=1;setFarbe(col);
						if(et==1)
						{
							if(mw.sel==1){mw.tb1.doClick();}
							else if(mw.sel==2){mw.tb2.doClick();}else if(mw.sel==3){mw.tb3.doClick();}
							else if(mw.sel==4){mw.tb4.doClick();}else if(mw.sel==5){mw.tb5.doClick();}
							else if(mw.sel==6){mw.tb6.doClick();}else if(mw.sel==7){mw.tb7.doClick();}
							else if(mw.sel==8){mw.tb8.doClick();}else if(mw.sel==9){mw.tb9.doClick();}
							else if(mw.sel==10){mw.tb10.doClick();}else if(mw.sel==11){mw.tb11.doClick();}
							else if(mw.sel==12){mw.tb12.doClick();}else if(mw.sel==14){mw.tb14.doClick();}run();
						}
					}
					repaint();
				}
			}
		}
		public void mouseExited(MouseEvent e)
		{
			if(paint==0)
			{
				mw.state.pos.setText("0, 0                  ");if(Drawing.equals("Stamp")||Drawing.equals("Text"))
				{xZiel=Toolkit.getDefaultToolkit().getScreenSize().width*3;yZiel=Toolkit.getDefaultToolkit().getScreenSize().height*3;repaint();}
			}
		}
		public void mouseDragged(MouseEvent e)
		{
			if(paint==0){
				if(firstClick&&(!Drawing.equals("Stamp")&&!Drawing.equals("Text")))
				{
					x=e.getX();
					y=e.getY();
					xZiel=e.getX()-x;
					yZiel=e.getY()-y;
					firstClick=false;
				}
				else
				{
					if((Drawing.equals("Stamp")||Drawing.equals("Text")||Drawing.equals("Shape")||Drawing.equals("Line") || Drawing.equals("Dotted")||
						Drawing.equals("Tube")||Drawing.equals("Tray")||Drawing.equals("Eraser")))
					{
						xZiel=e.getX();
						yZiel=e.getY();
					}
					else if(Drawing.equals("Pencil")||Drawing.equals("Fill_Curve"))
					{
						if(firstFrei==true)
						{
							x=e.getX();
							y=e.getY();
							firstFrei=false;
						}
						else
						{
							if(Drawing.equals("Pencil")){x=xZiel;y=yZiel;}
						}
						xZiel=e.getX();yZiel=e.getY();
					}
					else
					{
						xZiel=e.getX()-x;
						yZiel=e.getY()-y;
					}
				}
				if(Drawing.equals("Dotted"))
				{
					Dotted f = new Dotted(e.getX(),e.getY());
					f.setStaerke(staerke);
					f.setFarbe(Farbe);
					draw.add(f);res.add(f);
				}
				if(Drawing.equals("Tube"))
				{
					Tube tu = new Tube(e.getX(),e.getY());
					tu.setStaerke(staerke);
					tu.setFarbe(Farbe);
					draw.add(tu);res.add(tu);
				}
				if(Drawing.equals("Tray"))
				{
					Tray tr = new Tray(e.getX(),e.getY());
					tr.setStaerke(staerke);
					tr.setFarbe(Farbe);
					draw.add(tr);res.add(tr);
				}
				else if(Drawing.equals("Eraser"))
				{
					Eraser fd = new Eraser(e.getX(),e.getY());
					fd.setStaerke(staerke);
					fd.setFarbe(Farbe);
					fd.setXZiel(xZiel);
					fd.setYZiel(yZiel);
					draw.add(fd);res.add(fd);
				}
				else if(Drawing.equals("Pencil") && firstFrei==false)
				{
					Composition z = new Composition(x,y);
					z.setStaerke(staerke);z.setFarbe(Farbe);
					z.setXZiel(xZiel);
					z.setYZiel(yZiel);
					draw.add(z);res.add(z);
				}
				else if(Drawing.equals("Fill_Curve") && firstFrei==false)
				{
					Fill_Curve fi = new Fill_Curve(x,y);
					fi.setStaerke(staerke);fi.setFarbe(Farbe);
					fi.setXZiel(xZiel);
					fi.setYZiel(yZiel);
					draw.add(fi);res.add(fi);
				}
				repaint();}
			}
			public void mouseMoved(MouseEvent e)
			{
				if(Drawing.equals("Pick"))
				{
					BufferedImage img = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
					Graphics2D g = img.createGraphics();drawing(g);col = new Color(img.getRGB(e.getX(),e.getY()));
					if(et==1||ef==1){mw.Col.setBackground(col);mw.tcc.setColor(col);}
				}        
				if(Drawing.equals("Stamp")||Drawing.equals("Text"))
				{
					xZiel=e.getX();yZiel=e.getY();
				}
				mw.state.pos.setText(e.getX()+" , "+e.getY()+"                  ");repaint();
			}
			public void undo(ArrayList objekt)
			{
				if(objekt.size()>0)
				{
					objekt.remove(objekt.size()-1);
					repaint();
				}
			}
			public void redo(ArrayList object)
			{
				if(res.size()>object.size())
				{
					object.add(res.get(object.size()));
					repaint();
				}
			}
			public Color getFarbe()
			{
				return Farbe;
			}
			public void setFarbe(Color Farbe)
			{
				this.Farbe = Farbe;
			}
			public boolean isFilled() 
			{
				return filled;
			}
			public void setFilled(boolean filled) 
			{
				this.filled = filled;
			}
			public int getStaerke()
			{
				return staerke;
			}
			public void setStaerke(int staerke)
			{
				this.staerke = staerke;
			}
			public String getDrawing() 
			{
				return Drawing;
			}
			public void setDrawing(String Drawing)
			{
				this.Drawing = Drawing;
			}
			public ArrayList getres() 
			{
				return res;
			}
			public ArrayList getdraw()
			{
				return draw;
			}
			public void setdraw(ArrayList draw)
			{
				this.draw = draw;
			}
			public Color getBgFarbe() 
			{
				return bgFarbe;
			}
			public void setBgFarbe(Color bgFarbe) 
			{
				this.bgFarbe = bgFarbe;
				repaint();
			}
		}