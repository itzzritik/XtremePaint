package src;

import java.awt.image.*;
import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.image.*;
import javax.swing.filechooser.FileFilter;
import java.awt.geom.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import java.net.URL;import java.awt.Insets;
import com.sun.awt.AWTUtilities;
import java.awt.geom.Ellipse2D;
import java.awt.GraphicsDevice.WindowTranslucency.*;
public class MainWindow extends JFrame implements ChangeListener,Runnable
{
	private MainPanel panel = new MainPanel(this);BufferedImage theImage;int mb=0,db=0,cb=0;JMenuItem d0,d1,d2,d3,d4,d5,d6,d7,d8;int ppo=0;int fr=0;int et=0;
	protected JColorChooser tcc;JToolBar tool;JButton New,Load,Save,setup,print,printed,Image,wall,Undo,Redo,full;String loc="Drawing\\Stamps";
	JPanel co1=new JPanel(new FlowLayout());int imgsize=40;DefaultComboBoxModel mod;JLabel lab=new JLabel(" ");int sel=9;int wx=0,wy=0;
	Color newColor;int a=1;JButton open;JPanel add=new JPanel(new BorderLayout());String image[],frame[];JPanel panee=new JPanel(new BorderLayout());
	int xmou=200;int ymou=200;JButton addstamp,choose;JPanel Col=new JPanel(new BorderLayout());StatusBar state= new StatusBar();int ab=0;
	JToggleButton tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb8,tb9,tb10,tb11,tb12,tb13,tb14;int x1=0,x2,y1=0,y2;String dr="Pencil";int sc=0,ad=0;
	JPanel pane=new JPanel(new BorderLayout());int ik=0;int PX,PY;JSlider size = new JSlider(JSlider.HORIZONTAL,1,100,1);int zx=0,zy=0;
	JPanel filled=new JPanel(new BorderLayout());JToggleButton Screen,Add,paint,pen;JComboBox fontsel,stamp,Frames;JMenu men=new JMenu("Fonts");
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();int po=0,pp=0,txx=0;
	JPanel too=new JPanel(new BorderLayout());
	GraphicsDevice defaultScreen = env.getDefaultScreenDevice();JPanel sp=new JPanel(new BorderLayout()); int zzx=0,zzy=0,xxx=0,xxy=0;
	InfoWindow info = new InfoWindow();JLabel Tsize=new JLabel(" ");String txts="Font Size :";
	
	JTabbedPane Tab;JPanel Tab1,Tab2;JToolBar File,Home;
	public MainWindow()
	{
		super("Xtreme Paint");setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);panel.setFocusable(true);info.setFocusable(true);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent w)
			{
				if(JOptionPane.showConfirmDialog(new JFrame(),"Are you sure to close this window?", "Really Closing?",JOptionPane.YES_NO_OPTION)==0){System.exit(0);}
			}
			public void windowResized(WindowEvent w)
			{
				info.siz(panel.getSize());info.repaint();
			}
		});
		try{sun.awt.shell.ShellFolder sf = sun.awt.shell.ShellFolder.getShellFolder(new File("Icon/paint.ico"));
		this.setIconImage(sf.getIcon(true));}catch(Exception e){}
		addstamp=new JButton("  Add     ",new ImageIcon("ToolBar/add.gif"));choose=new JButton("Choose",new ImageIcon("ToolBar/image.png"));
		co1.setVisible(false);tool = new JToolBar("Drawing Panel",JToolBar.VERTICAL);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-28);
		setLocationRelativeTo(null);getContentPane().setLayout(new BorderLayout());createMenu();
		tcc = new JColorChooser();tcc.getSelectionModel().addChangeListener(this);
		Toolkit toolkit = Toolkit.getDefaultToolkit();  Point hotSpot = new Point(0,0);
		JLabel cn=new JLabel(new ImageIcon("Icon/Color.png"));Image image = toolkit.getImage("Icon/pencil1.gif");tcc.setPreviewPanel(new JPanel());
		sp.setPreferredSize(new Dimension(80,135));sp.setVisible(false);
		Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Pencil1");Col.add(cn,BorderLayout.CENTER);JPanel Coo=new JPanel();
		Coo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(5,5,5,5)));
		Coo.add(Col);Col.setPreferredSize(new Dimension(80,40));JPanel pp1=new JPanel(new BorderLayout());
		pp1.add(new JPanel(),BorderLayout.SOUTH);pp1.add(sp,BorderLayout.CENTER);Col.setBackground(Color.white);
		setCursor(cursor);open =new JButton();panee.add(open,BorderLayout.NORTH);panee.add(pp1,"Center");panee.add(Coo,BorderLayout.SOUTH);   
		JPanel cp=new JPanel(new BorderLayout());cp.add(tcc,BorderLayout.CENTER);
		pane.add(cp,BorderLayout.SOUTH);pane.add(panel.colo,BorderLayout.CENTER);(panel.colo).setVisible(false);
		pane.setOpaque(false);
		tcc.setColor(Color.black);open.setIcon(new ImageIcon("Icon/color1.png"));open.setFocusable(false);
		open.setPreferredSize(new Dimension(104,62));open.setFont(new Font("Comic Sans MS",Font.BOLD, 40));open.setToolTipText("Choose the Color");
		tcc.setCursor(toolkit.createCustomCursor(new ImageIcon("Icon\\pencil1.gif").getImage(),new Point(0,0), "Pencil"));
		
		state.resize.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e){}public void mousePressed(MouseEvent e){zzx = e.getX();zzy = e.getY();xxx = e.getXOnScreen();xxy = e.getYOnScreen();}
			public void mouseExited(MouseEvent e){}public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
		});
		state.resize.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent e)
			{if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0){ 
				if(e.getXOnScreen()>xxx){int six=e.getXOnScreen()-xxx;int siy=e.getYOnScreen()-xxy;setSize(getWidth()-six,getHeight()-siy);}}
				else if(xxx>e.getXOnScreen()){int six=xxx-e.getXOnScreen();int siy=xxy-e.getYOnScreen();setSize(getWidth()+six,getHeight()+siy);}
			}public void mouseMoved(MouseEvent e){}
		});
		
		open.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(ik==0){sp.setVisible(true);co1.setVisible(true);(panel.colo).setVisible(true);tcc.setVisible(true);ik=1;open.setIcon(new ImageIcon("Icon/color2.png"));}
				else if(ik==1){sp.setVisible(false);co1.setVisible(false);(panel.colo).setVisible(false);tcc.setVisible(false);ik=0;open.setIcon(new ImageIcon("Icon/color1.png"));}
			}
		});back();Thread th=new Thread(this);th.start();
	}
	public void run()
	{
		while(true)
		{
			try
			{
				if(getSize().getWidth()!=wx){wx=(int)getSize().getWidth();info.siz(panel.getSize());info.repaint();}
				if(getSize().getWidth()!=wy){wy=(int)getSize().getHeight();info.siz(panel.getSize());info.repaint();}
				Col.setBackground(tcc.getColor());
				size.setToolTipText("Adjust The Size of The "+dr);choose.setToolTipText("Choose A "+dr+" From Your System");
				addstamp.setToolTipText("Add A "+dr+" To The Above List");try{Thread.sleep(50);}catch(Exception op){}
                //run();SwingUtilities.invokeLater(this);
			}
			catch(Exception e){try{Thread.sleep(100);}catch(Exception op){}}
		}
	}
	public void showWindow()
	{
		tcc.setPreferredSize(new Dimension(this.getWidth(),270));info.setVisible(false);
		tcc.setVisible(false);Tab();tool();
		getContentPane().add(Tab,BorderLayout.NORTH);
		getContentPane().add(BorderLayout.CENTER,panel);
		too.add(panee,BorderLayout.SOUTH);too.add(tool,BorderLayout.CENTER);
		getContentPane().add(too, "West");
		JPanel pane2=new JPanel(new BorderLayout());panel.add(pane, BorderLayout.SOUTH);pane2.add(state, BorderLayout.SOUTH);
		getContentPane().add(pane2, BorderLayout.PAGE_END);panel.add(info,BorderLayout.CENTER);
		setVisible(true);PX=panel.getWidth();PY=panel.getHeight();JFrame.setDefaultLookAndFeelDecorated(true);
	}
	public void stateChanged(ChangeEvent e)
	{
		newColor = tcc.getColor();
		if(a==1){panel.setFarbe(newColor);}
		if(a==2){panel.setBgFarbe(newColor);}
	}
	public void back()
	{
        //co1.setOpaque(false);
		ButtonGroup bp = new ButtonGroup();
		pen = new JToggleButton("           Choose Pen Color              ",new ImageIcon("Icon/pen.png"));pen.setPreferredSize(new Dimension(40,40));pen.setFocusable(false);
		pen.setPreferredSize(new Dimension(250,40));bp.add(pen);co1.add(pen);
		pen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				a=1;Toolkit.getDefaultToolkit().beep();
			}
		});
		paint = new JToggleButton("    Choose Background Color ",new ImageIcon("Icon/back.png"));paint.setPreferredSize(new Dimension(40,40));paint.setFocusable(false);
		paint.setPreferredSize(new Dimension(250,40));bp.add(paint);co1.add(paint);
		paint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				a=2;Toolkit.getDefaultToolkit().beep();
			}
		});
		Toolkit toolkit = Toolkit.getDefaultToolkit();Image image = toolkit.getImage("Icon/pencil1.gif");
		Cursor cursor= toolkit.createCustomCursor(image,new Point(0,0), "Pencil");co1.setCursor(cursor);
		pen.setSelected(true);panel.colo.add(co1);
	}
	public void Tab()
	{
		Tab1=new JPanel(new BorderLayout());Tab1.setFocusable(false);Tab1.setPreferredSize(new Dimension(0,30));
		File = new JToolBar();File.setFloatable(false);File.setRollover(true);File.add(new JLabel("  "));
		Tab1.add(File,BorderLayout.CENTER);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		New = new JButton(new ImageIcon("ToolBar/new.gif"));New.setFocusable(false);File.add(New);New.setRolloverIcon(new ImageIcon("ToolBar/new2.gif"));
		New.setText("New");New.setToolTipText("Clears The Drawing Panel.");New.setPreferredSize(new Dimension(65,40));New.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				New();
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Save = new JButton(new ImageIcon("ToolBar/Save.gif"));Save.setFocusable(false);File.add(Save);Save.setRolloverIcon(new ImageIcon("ToolBar/save2.gif"));
		Save.setText("Save");Save.setToolTipText("Saves Your Progress.");Save.setPreferredSize(new Dimension(70,40));Save.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Save();
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Load = new JButton(new ImageIcon("ToolBar/open.gif"));Load.setFocusable(false);File.add(Load);File.addSeparator();
		Load.setToolTipText("Opens Any Previousy Saved Project Files.");
		Load.setText("Open");Load.setRolloverIcon(new ImageIcon("ToolBar/open2.gif"));Load.setPreferredSize(new Dimension(70,40));
		Load.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel.TextPane.setVisible(false);if(ik==1){open.doClick();}Load();
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		setup = new JButton(new ImageIcon("ToolBar/windows.png"));setup.setFocusable(false);File.add(setup);
		setup.setText("Print Setup ");setup.setRolloverIcon(new ImageIcon("ToolBar/windows2.png"));setup.setPreferredSize(new Dimension(100,40));
		setup.setToolTipText("Adjusts The Print Command.");setup.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Printed(2);
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		print = new JButton(new ImageIcon("ToolBar/prev.png"));print.setFocusable(false);File.add(print);print.setRolloverIcon(new ImageIcon("ToolBar/prev2.png"));
		print.setToolTipText("Shows The Print Preview.");
		print.setText("Print Preview ");print.setPreferredSize(new Dimension(112,40));print.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel.setFocusable(false);Print();
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		printed = new JButton(new ImageIcon("ToolBar/print.png"));printed.setFocusable(false);File.add(printed);File.addSeparator();
		printed.setText("Print  ");printed.setRolloverIcon(new ImageIcon("ToolBar/print2.png"));printed.setPreferredSize(new Dimension(70,40));
		printed.setToolTipText("Prints The Drawed Image as a Hard Copy.");
		printed.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Printed(1);
			}
		});
		
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Tab2=new JPanel(new BorderLayout());Tab2.setFocusable(false);Tab2.setPreferredSize(new Dimension(0,30));
		Home = new JToolBar();Home.setFloatable(false);Home.setRollover(true);Home.add(new JLabel("  "));
		Tab2.add(Home,BorderLayout.CENTER);
		
		
		Undo = new JButton(new ImageIcon("ToolBar/undo.gif"));Undo.setFocusable(false);Home.add(Undo);Undo.setToolTipText("Undo The Last Change.");
		Undo.setText("Undo");Undo.setRolloverIcon(new ImageIcon("ToolBar/undo2.gif"));
		Undo.setPreferredSize(new Dimension(70,40));
		Undo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel.undo(panel.getdraw());
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Redo = new JButton(new ImageIcon("ToolBar/redo.gif"));Redo.setFocusable(false);Home.add(Redo);Home.addSeparator();Redo.setToolTipText("Redo Your Last Undo.");
		Redo.setText("Redo");Redo.setRolloverIcon(new ImageIcon("ToolBar/redo2.gif"));Redo.setPreferredSize(new Dimension(70,40));
		Redo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel.redo(panel.getdraw());
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Screen = new JToggleButton(new ImageIcon("ToolBar/Capture.png"));Screen.setFocusable(false);
		Screen.setToolTipText("Captures The Screen and Loads to The Drawing Panel ");Screen.setRolloverIcon(new ImageIcon("ToolBar/Capture2.png"));
		Screen.setText("Screen Shot   ");Home.add(Screen);Screen.setPreferredSize(new Dimension(110,40));Screen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(sc==0)
				{
					Add.setVisible(false);Add.setVisible(false);sc=1;setVisible(false);Screen.setText("Remove It   ");try{Thread.sleep(500);}catch(Exception ee){}
					panel.screen=new ImageIcon((new Capture().Screen()).getImage().getScaledInstance(panel.getWidth(),panel.getHeight(),4));
					panel.cap=1;panel.repaint();setVisible(true);
				}
				else if(sc==1){Add.setVisible(true);Screen.setText("Screen Shot   ");sc=0;panel.cap=0;panel.repaint();}
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Add = new JToggleButton(new ImageIcon("ToolBar/add.gif"));Add.setFocusable(false);Home.add(Add);Add.setToolTipText("Loads an Image To Drawing Panel");
		Add.setText("Add Image  ");Add.setPreferredSize(new Dimension(100,40));Home.addSeparator();
		Add.setRolloverIcon(new ImageIcon("ToolBar/add2.gif"));Add.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(ad==0)
					{ad=1;Add.setText("Remove It   ");Screen.setVisible(false);Add();}
				else if(ad==1){ad=0;Add.setText("Add Image  ");Screen.setVisible(true);panel.ico=" ";panel.repaint();}
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Image = new JButton(new ImageIcon("ToolBar/image.png"));Image.setFocusable(false);Home.add(Image);Image.setToolTipText("Saves The Drawing an an Image.");
		Image.setText("Save as Image");Image.setRolloverIcon(new ImageIcon("ToolBar/image2.gif"));Image.setPreferredSize(new Dimension(122,40));
		Image.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Image();
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		wall = new JButton(new ImageIcon("ToolBar/wall.png"));wall.setFocusable(false);Home.add(wall);Home.addSeparator();wall.setToolTipText("Sets Your Drawing as Desktop Wallpaper.");
		wall.setText("Set as Wallpaper");wall.setRolloverIcon(new ImageIcon("ToolBar/wall2.png"));wall.setPreferredSize(new Dimension(135,40));
		wall.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Wall();
			}
		});
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		full = new JButton(new ImageIcon("ToolBar/fullscreen.png"));full.setFocusable(false);Home.add(full);full.setToolTipText("Shows Your Drawing's Preview in FullScreen.");
		full.setText("Full Screen");full.setRolloverIcon(new ImageIcon("ToolBar/fullscreen2.png"));full.setPreferredSize(new Dimension(106,40));
		full.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		full.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e){}public void mousePressed(MouseEvent e){full.setEnabled(false);}
			public void mouseExited(MouseEvent e){}public void mouseReleased(MouseEvent e){if(ab==0){panel.setFocusable(false);full();}full.setEnabled(true);}
			public void mouseEntered(MouseEvent e){}
		});
		
		
        Tab=new JTabbedPane();//Tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        Tab.addTab("   File   ",new ImageIcon(""),Tab1,"Contains Tools To Maintain Xtreme Paint."); 
        Tab.addTab("   Home   ",new ImageIcon(""),Tab2,"Contains Tools To Edit Xtreme Paint."); 
        Tab.setSelectedIndex(1);
    }
    public void tool()
    {
    	tool.setFloatable(false);tool.setRollover(true);int bs=35;
    	ButtonGroup g1 = new ButtonGroup();filled.setVisible(false);
    	JToggleButton t1=new JToggleButton();t1.setIcon(new ImageIcon("Drawing/not filled.png"));t1.setFocusable(false);g1.add(t1);filled.add(t1,"North");
    	JToggleButton t2=new JToggleButton();t2.setIcon(new ImageIcon("Drawing/filled.png"));t2.setFocusable(false);g1.add(t2);filled.add(t2,"South");
    	t1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			panel.setFilled(false);
    		}
    	});
    	t2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			panel.setFilled(true);
    		}
    	});
    	filled.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(8,10,8,10)));
    	filled.setPreferredSize(new Dimension(90,90));t1.setSelected(true);
    	size.setPreferredSize(new Dimension(90,90));size.setVisible(true);
    	size.addChangeListener(new ChangeListener()
    	{
    		public void stateChanged(ChangeEvent e)
    		{
    			JSlider source = (JSlider)e.getSource();int siz=(int)source.getValue();panel.setStaerke(siz);
    			if(txx==1){txts="Font Size : "+siz;Tsize.setText(txts);}panel.repaint();panel.fnt();
    		}
    	});
    	size.setMinorTickSpacing(10);size.setMajorTickSpacing(99);size.setPaintTicks(true);size.setPaintLabels(true);
    	size.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(1,1,1,1)));
    	ButtonGroup g0 = new ButtonGroup();JPanel full =new JPanel(new BorderLayout());JPanel full2 =new JPanel(new BorderLayout());
    	JPanel p1= new JPanel();
    	tb1=new JToggleButton();tb1.setIcon(new ImageIcon("Drawing/rect.png"));g0.add(tb1);tb1.setPreferredSize(new Dimension(bs+5,bs));p1.add(tb1);
    	tb2=new JToggleButton();tb2.setIcon(new ImageIcon("Drawing/oval.png"));g0.add(tb2);tb2.setPreferredSize(new Dimension(bs+5,bs));p1.add(tb2);
    	tb1.setFocusable(false);tb2.setFocusable(false);
    	JPanel p2= new JPanel();
    	tb3=new JToggleButton();tb3.setIcon(new ImageIcon("Drawing/line.png"));g0.add(tb3);tb3.setPreferredSize(new Dimension(bs+5,bs));p2.add(tb3);
    	tb4=new JToggleButton();tb4.setIcon(new ImageIcon("Drawing/dot.png"));g0.add(tb4);tb4.setPreferredSize(new Dimension(bs+5,bs));p2.add(tb4);
    	tb3.setFocusable(false);tb4.setFocusable(false);
    	JPanel p7= new JPanel();
    	tb13=new JToggleButton();tb13.setIcon(new ImageIcon(new ImageIcon("Icon/Dropper.png").getImage().getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH)));
    	g0.add(tb13);tb13.setPreferredSize(new Dimension(bs+5,bs));p7.add(tb13);
    	tb14=new JToggleButton();tb14.setIcon(new ImageIcon("Drawing/A.png"));g0.add(tb14);tb14.setPreferredSize(new Dimension(bs+5,bs));p7.add(tb14);
    	tb13.setFocusable(false);tb14.setFocusable(false);
    	JPanel p3= new JPanel();
    	tb5=new JToggleButton();tb5.setIcon(new ImageIcon("Drawing/fill.png"));g0.add(tb5);tb5.setPreferredSize(new Dimension(bs+5,bs));p3.add(tb5);
    	tb6=new JToggleButton();tb6.setIcon(new ImageIcon("Drawing/eraser.png"));g0.add(tb6);tb6.setPreferredSize(new Dimension(bs+5,bs));p3.add(tb6);
    	tb5.setFocusable(false);tb6.setFocusable(false);
    	JPanel p4= new JPanel();
    	tb7=new JToggleButton();tb7.setIcon(new ImageIcon("Drawing/tube.png"));g0.add(tb7);tb7.setPreferredSize(new Dimension(bs+5,bs));p4.add(tb7);
    	tb8=new JToggleButton();tb8.setIcon(new ImageIcon("Drawing/tray.png"));g0.add(tb8);tb8.setPreferredSize(new Dimension(bs+5,bs));p4.add(tb8);
    	tb7.setFocusable(false);tb8.setFocusable(false);
    	JPanel p5= new JPanel();
    	tb11=new JToggleButton();tb11.setIcon(new ImageIcon("Drawing/stamp.png"));g0.add(tb11);tb11.setPreferredSize(new Dimension(bs+5,bs));p5.add(tb11);
    	tb12=new JToggleButton();tb12.setIcon(new ImageIcon("Drawing/border.png"));g0.add(tb12);tb12.setPreferredSize(new Dimension(bs+5,bs));p5.add(tb12);
    	tb11.setFocusable(false);tb12.setFocusable(false);
    	JPanel p6= new JPanel();
    	tb9=new JToggleButton();tb9.setIcon(new ImageIcon("Drawing/pencil.png"));g0.add(tb9);tb9.setPreferredSize(new Dimension(bs+5,bs));p6.add(tb9);
    	tb10=new JToggleButton();tb10.setIcon(new ImageIcon("Drawing/poly.png"));g0.add(tb10);tb10.setPreferredSize(new Dimension(bs+5,bs));p6.add(tb10);
    	tb9.setFocusable(false);tb10.setFocusable(false);
    	
        ////////////////////////////////////////////////////
    	tb1.setToolTipText("Rectangle");tb2.setToolTipText("Oval");tb3.setToolTipText("Line");tb4.setToolTipText("Brush");tb5.setToolTipText("Vortex");
    	tb6.setToolTipText("Eraser");tb7.setToolTipText("Spiral");tb8.setToolTipText("Groovy Spiral");tb9.setToolTipText("Pencil");
    	tb10.setToolTipText("Polygon");tb11.setToolTipText("Stamp");tb12.setToolTipText("Frame");tb13.setToolTipText("Color Picker");
    	tb14.setToolTipText("Text");
        ////////////////////////////////////////////////////
    	
    	File dest=new File("Drawing\\Stamps");File [] list=dest.listFiles();int sz=0;
    	for(int i=0;i<list.length;i++){if(list[i].getName().equals("Thumbs.db")){sz=1;}}
    		String images[]=new String[list.length];
    	for(int i=0,j=0;i<images.length;i++)
    	{
    		if(!list[i].getName().equals("Thumbs.db")){images[j]=list[i].getName();j++;}else{}
    	}
    	image=images;
    	if(sz==1)
    	{
    		image=new String[images.length-1];
    		for(int i=0;i<image.length;i++)
    		{
    			image[i]=images[i];
    		}
    	}
    	panel.im1=loc+"\\"+images[0];stamp = new JComboBox(image);stamp.setVisible(false);stamp.setFocusable(false);stamp.setToolTipText("Choose a Stamp");
        ///////////////////////////////////////////////////////////////////////////
    	File dest1=new File("Drawing\\Frames");File list1[]=dest1.listFiles();sz=0;int pb=0;
    	for(int i=0;i<list1.length;i++){if(list1[i].getName().equals("Thumbs.db")||list1[i].getName().equals("None")){sz=1;pb++;}}
    		String images1[]=new String[list1.length];int j=0;
    	for(int i=0;i<images1.length;i++)
    	{
    		if(!list1[i].getName().equals("Thumbs.db")||!list1[i].getName().equals("None")){images1[j]=list1[i].getName();j++;}
    	}
    	frame=images1;
    	if(pb>0)
    	{
    		frame=new String[images1.length];
    		for(int i=0;i<frame.length;i++)
    		{
    			if(!images1[i].equals("None")){frame[i]=images1[i];}
    		}
    	}
    	images1=frame;frame=new String[images1.length-1];
    	for(int i=0,q=0;i<images1.length;i++)
    	{
    		if(images1[i]!=null){frame[q]=images1[i];q++;}
    	}
    	String res[]=frame;frame=new String[res.length+1];
    	for(int i=0;i<frame.length;i++)
    	{
    		if(i==0){frame[i]="None";}
    		else{frame[i]=res[i-1];}
    	}int yes=0;
    	for(int i=0;i<frame.length;i++)
    	{
    		if(frame[i].equals("Thumbs.db")){yes++;}
    	}
    	if(yes!=0)
    	{
    		res=frame;frame=new String[res.length-1];
    		for(int i=0,q=0;i<frame.length;i++)
    		{
    			if(!res[i].equals("Thumbs.db")){frame[i]=res[q];q++;}
    		}
    	}
    	Frames = new JComboBox(frame);Frames.setPreferredSize(new Dimension(104,25));Frames.setVisible(false);Frames.setFocusable(false);
    	Frames.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(1,1,1,1)));
    	Frames.setToolTipText("Choose a Frame");Frames.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			JComboBox cb = (JComboBox)e.getSource();String nS = (String)cb.getSelectedItem();
    			Frames st = new Frames(0,0);st.setStaerke(panel.getStaerke());nS=loc+"\\"+nS;
    			st.setframe(nS);st.setIm(1);panel.draw.add(st);panel.res.add(st);panel.repaint();
    		}
    	});
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	fontsel=new JComboBox(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
    	fontsel.setPreferredSize(new Dimension(104,25));fontsel.setVisible(false);fontsel.setFocusable(false);
    	fontsel.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			JComboBox cb4 = (JComboBox)e.getSource();String nS = (String)cb4.getSelectedItem();panel.font2=nS;panel.fnt();
    		}
    	});
    	fontsel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(1,1,1,1)));
    	
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	stamp.setPreferredSize(new Dimension(104,25));stamp.setMaximumRowCount(10);
    	stamp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(1,1,1,1)));
    	stamp.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			JComboBox cb = (JComboBox)e.getSource();String nS = (String)cb.getSelectedItem();nS=loc+"\\"+nS;int siz=new ImageIcon(nS).getIconWidth();
    			panel.im1 = nS;panel.im2=null;if(siz<=25){imgsize=siz*5;}else if(siz<=50){imgsize=siz*2;}else{imgsize=siz/5;}
    			size.setMaximum(imgsize);size.setMinimum(4);panel.repaint();size.setMinorTickSpacing(1);size.setMajorTickSpacing(imgsize);
    		}
    	});
    	add.setVisible(false);addstamp.setFocusable(false);choose.setFocusable(false);
    	addstamp.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			JFileChooser f = new JFileChooser();f.setPreferredSize(new Dimension(1100,700));
    			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files ( jpg , png , bmp , ico , gif , tga , tif , tiff , webp )", "jpg","png","bmp","gif","tga","tif","tiff","webp");
    			f.setFileFilter(filter);f.setFileView(new FileIconView(filter, new ImageIcon("ToolBar/image.png")));
    			f.setAccessory(new ImagePreviewer(f));f.setCurrentDirectory(new File("."));f.setApproveButtonText("Choose");f.setDialogTitle("Add a Stamp");
    			f.showOpenDialog(null);String fil=f.getSelectedFile().getPath();try{copy(fil,loc);}catch(Exception ep){}
    			File file3=new File(loc+"\\"+name(fil));String sta=null;sta=JOptionPane.showInputDialog("Input The Stamp Name");if(sta==null){sta=("Stamp-"+ppo);ppo++;}
    			File file4=new File(loc+"\\"+sta);boolean re = file3.renameTo(file4);if(fr==0){stamp.insertItemAt(sta,1);}else{Frames.insertItemAt(sta,1);}
    		}
    	});
    	choose.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e) 
    		{
    			JFileChooser f = new JFileChooser();f.setPreferredSize(new Dimension(1100,700));
    			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files ( jpg , png , bmp , ico , gif , tga , tif , tiff , webp )", "jpg","png","bmp","gif","tga","tif","tiff","webp");
    			f.setFileFilter(filter);f.setFileView(new FileIconView(filter, new ImageIcon("ToolBar/image.png")));
    			f.setAccessory(new ImagePreviewer(f));f.setCurrentDirectory(new File("."));f.setApproveButtonText("Choose");f.setDialogTitle("Choose a Stamp");
    			f.showOpenDialog(null);String url= f.getSelectedFile().getPath();if(fr==0){panel.im2=url;panel.im1=null;}
    			else{Frames st = new Frames(0,0);st.setStaerke(panel.getStaerke());st.setframe(url);st.setIm(1);panel.draw.add(st);panel.res.add(st);panel.repaint();}                
    		}
    	});
    	
        /*tb1.setBackground(new Color(100,100,100));tb2.setBackground(new Color(100,100,100));tb3.setBackground(new Color(100,100,100));
        tb4.setBackground(new Color(100,100,100));tb5.setBackground(new Color(100,100,100));tb6.setBackground(new Color(100,100,100));
        tb7.setBackground(new Color(100,100,100));*/
        
        add.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(10,1,10,1)));
        add.add(addstamp,"North");add.add(choose,"South");add.setPreferredSize(new Dimension(104,90));JPanel pp=new JPanel(new BorderLayout());
        pp.add(p2,BorderLayout.NORTH);pp.add(p7,BorderLayout.CENTER);
        full.add(p1,BorderLayout.NORTH);full.add(pp,BorderLayout.CENTER);full.add(p3,BorderLayout.SOUTH);
        full2.add(p4,BorderLayout.NORTH);full2.add(p5,BorderLayout.CENTER);full2.add(p6,BorderLayout.SOUTH);
        listen(tb1);listen(tb2);listen(tb3);listen(tb4);listen(tb5);listen(tb6);listen(tb7);listen(tb8);listen(tb9);listen(tb10);listen(tb11);listen(tb12);
        listen(tb13);listen(tb14);
        tb9.setSelected(true);JPanel pane2=new JPanel(new BorderLayout());pane2.add(full,BorderLayout.NORTH);pane2.add(full2,BorderLayout.CENTER);
        pane2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(2,2,2,2)));
        JLabel pl=new JLabel("Drawing Panel");pl.setFont( new Font("Comic Sans MS",Font.BOLD, 14));
        tool.add(pl);size.setPreferredSize(new Dimension(102,80));filled.setPreferredSize(new Dimension(102,85));
        tool.add(pane2);tool.add(new JLabel(" "));tool.add(size);
        tool.add(filled);tool.add(Tsize);tool.add(Frames);tool.add(fontsel);tool.add(stamp);tool.add(new JLabel(" "));tool.add(add);
    }
    public void createMenu()
    {
    	JMenuBar mb = new JMenuBar();
    	mb.addMouseListener(new MouseListener()
    	{
    		public void mouseClicked(MouseEvent e){}public void mousePressed(MouseEvent e){zx = e.getX();zy = e.getY();zy=zy+30;}
    		public void mouseExited(MouseEvent e){}public void mouseReleased(MouseEvent e){}
    		public void mouseEntered(MouseEvent e){}
    	});
    	mb.addMouseMotionListener(new MouseMotionListener()
    	{
    		public void mouseDragged(MouseEvent e)
    		{if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0&&pp==0) {
    			setLocation(e.getXOnScreen()-zx, e.getYOnScreen()-zy);}
    		}public void mouseMoved(MouseEvent e){}
    	});
    	JMenu menu1 = new JMenu("File");
    	d0 = new JMenuItem("Save");d0.setIcon(new ImageIcon("ToolBar/save.gif"));
    	d1 = new JMenuItem("Load");d1.setIcon(new ImageIcon("ToolBar/open.gif"));
    	d2 = new JMenuItem("Save as Image");d2.setIcon(new ImageIcon("ToolBar/image.png"));
    	d3 = new JMenuItem("Add Image");d3.setIcon(new ImageIcon("ToolBar/add.gif"));
    	d8 = new JMenuItem("Print Setup");d8.setIcon(new ImageIcon("ToolBar/windows.png"));
    	d4 = new JMenuItem("Print Preview");d4.setIcon(new ImageIcon("ToolBar/prev.png"));
    	d5 = new JMenuItem("Print");d5.setIcon(new ImageIcon("ToolBar/print.png"));
    	d6 = new JMenuItem("New");d6.setIcon(new ImageIcon("ToolBar/new.gif"));
    	d7 = new JMenuItem("Exit");d7.setIcon(new ImageIcon("ToolBar/power.png"));
    	
    	d0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    	d1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    	d2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    	d3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    	d8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
    	d4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    	d5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    	d6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    	d7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
    	
    	menu1.add(d6);
    	menu1.addSeparator();
    	menu1.add(d0);
    	menu1.add(d1);
    	menu1.addSeparator();
    	menu1.add(d8);
    	menu1.add(d4);
    	menu1.add(d5);
    	menu1.addSeparator();
    	menu1.add(d2);
    	menu1.add(d3);
    	menu1.addSeparator();
    	menu1.add(d7);
    	
    	JMenu menu2 = new JMenu("Edit");
    	JMenuItem c0 = new JMenuItem("Undo");c0.setIcon(new ImageIcon("ToolBar/undo.gif"));menu2.add(c0);
    	JMenuItem c1 = new JMenuItem("Redo");c1.setIcon(new ImageIcon("ToolBar/redo.gif"));menu2.add(c1);
    	c0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    	c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
    	
    	JMenu menu3 = new JMenu("View");
    	JCheckBoxMenuItem m0 = new JCheckBoxMenuItem("Menu Tool Bar");m0.setSelected(true);menu3.add(m0);
    	JCheckBoxMenuItem m1 = new JCheckBoxMenuItem("Drawing Tool Bar");m1.setSelected(true);menu3.add(m1);
    	JCheckBoxMenuItem m2 = new JCheckBoxMenuItem("Color Tool Bar");m2.setSelected(true);menu3.add(m2);menu3.addSeparator();
    	JMenuItem f0 = new JMenuItem("FullScreen Mode");c0.setIcon(new ImageIcon("ToolBar/undo.gif"));menu3.add(f0);
    	JMenuItem f1 = new JMenuItem("Window Mode");c1.setIcon(new ImageIcon("ToolBar/redo.gif"));menu3.add(f1);
    	m0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
    	m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    	m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    	f0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    	f1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
    	
    	JMenu menu4 = new JMenu("Help");
    	JMenuItem po0 = new JMenuItem("About");po0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
    	menu4.add(po0);
    	
    	addMenuListener(d0);
    	addMenuListener(d1);
    	addMenuListener(d2);
    	addMenuListener(d3);
    	addMenuListener(d4);
    	addMenuListener(d5);
    	addMenuListener(d6);
    	addMenuListener(d7);
    	addMenuListener(d8);
    	addMenuListener(c0);
    	addMenuListener(c1);
    	addMenuListener(f0);
    	addMenuListener(f1);
    	addMenuListener(po0);
    	m0.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){menuEingabe(e.getActionCommand());}}); 
    	m1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){menuEingabe(e.getActionCommand());}}); 
    	m2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){menuEingabe(e.getActionCommand());}}); 
    	
    	mb.add(menu1);mb.add(new JLabel(" "));
    	mb.add(menu2);mb.add(new JLabel(" "));
    	mb.add(menu3);mb.add(new JLabel(" "));
    	mb.add(menu4);
    	setJMenuBar(mb);
    }
    public void listen(JToggleButton button)
    {
    	button.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if(e.getSource() == tb1){et=0;txx=0;panel.setDrawing("Rectangle");dr="Rectangle";fill();txts=" ";Tsize.setText(txts);size.setValue(panel.getStaerke());sel=1;}
    			else if(e.getSource() == tb2){et=0;txx=0;panel.setDrawing("Oval");dr="Oval";fill();txts=" ";Tsize.setText(txts);size.setValue(panel.getStaerke());sel=2;}
    			else if(e.getSource() == tb3){et=0;txx=0;panel.setDrawing("Line");dr="Line";slider();txts=" ";Tsize.setText(txts);size.setValue(15);sel=3;}
    			else if(e.getSource() == tb4){et=0;txx=0;panel.setDrawing("Dotted");dr="Brush";slider();txts=" ";Tsize.setText(txts);size.setValue(15);sel=4;}
    			else if(e.getSource() == tb5){et=0;txx=0;panel.setDrawing("Fill_Curve");dr="Vortex";slider();txts=" ";Tsize.setText(txts);size.setValue(1);sel=5;}
    			else if(e.getSource() == tb6){et=0;txx=0;panel.setDrawing("Eraser");dr="Eraser";slider();txts=" ";Tsize.setText(txts);size.setValue(15);sel=6;}
    			else if(e.getSource() == tb7){et=0;txx=0;panel.setDrawing("Tube");dr="Spiral";slider();txts=" ";Tsize.setText(txts);size.setValue(60);sel=7;}
    			else if(e.getSource() == tb8){et=0;txx=0;panel.setDrawing("Tray");dr="Groovy Spiral";slider();txts=" ";Tsize.setText(txts);size.setValue(60);sel=8;}
    			else if(e.getSource() == tb9){et=0;txx=0;panel.setDrawing("Pencil");dr="Pencil";slider();txts=" ";Tsize.setText(txts);size.setValue(panel.getStaerke());sel=9;}
    			else if(e.getSource() == tb10){et=0;txx=0;panel.setDrawing("Shape");dr="Polygon";slider();txts=" ";Tsize.setText(txts);size.setValue(panel.getStaerke());sel=10;}
    			else if(e.getSource() == tb11)
    			{
    				et=0;txx=0;fr=0;panel.setDrawing("Stamp");dr="Stamp";stamp.setVisible(true);txts=" ";Tsize.setText(txts);panel.xZiel=Toolkit.getDefaultToolkit().getScreenSize().width*3;
    				loc="Drawing\\Stamps";panel.yZiel=Toolkit.getDefaultToolkit().getScreenSize().height*3;stamp();Tsize.setVisible(true);sel=11;
    			}
    			else if(e.getSource() == tb12){et=0;txx=0;stamp();dr="Frame";panel.setDrawing("Frames");txts=" ";Tsize.setText(txts);fr=1;loc="Drawing\\Frames";Tsize.setVisible(false);
    			size.setVisible(false);Frames.setVisible(true);stamp.setVisible(false);panel.run();sel=12;}
    			else if(e.getSource() == tb13){slider();txx=0;size.setVisible(false);panel.setDrawing("Pick");txts=" ";Tsize.setText(txts);panel.ef=1;panel.run();panel.repaint();}
    			else if(e.getSource() == tb14){text();txx=1;Tsize.setVisible(true);dr="Text";panel.setDrawing("Text");txts="Font Size : 25";Tsize.setText(txts);panel.run();panel.repaint();sel=14;size.setValue(25);}
    		}
    	}); 
    }
    public void fill(){panel.run();fontsel.setVisible(false);panel.ef=0;size.setMinorTickSpacing(10);size.setMajorTickSpacing(99);Frames.setVisible(false);size.setPreferredSize(new Dimension(102,80));size.setVisible(true);size.setMaximum(100);size.setMinimum(1);filled.setVisible(true);stamp.setVisible(false);add.setVisible(false);size.setPaintTicks(true);size.setPaintLabels(true);panel.s3=0;}
    public void slider(){panel.run();fontsel.setVisible(false);panel.ef=0;size.setMinorTickSpacing(10);size.setMajorTickSpacing(99);Frames.setVisible(false);size.setPreferredSize(new Dimension(102,80));size.setVisible(true);size.setMaximum(100);size.setMinimum(1);filled.setVisible(false);stamp.setVisible(false);add.setVisible(false);size.setPaintTicks(true);size.setPaintLabels(true);panel.s3=0;}
    public void stamp(){panel.run();fontsel.setVisible(false);panel.ef=0;Frames.setVisible(false);size.setPreferredSize(new Dimension(104,30));size.setVisible(true);size.setMaximum(imgsize);size.setMinimum(4);filled.setVisible(false);stamp.setVisible(true);add.setVisible(true);size.setPaintTicks(false);size.setPaintLabels(false);panel.s3=0;}
    public void text(){stamp();size.setMaximum(100);fontsel.setVisible(true);size.setPreferredSize(new Dimension(104,40));stamp.setVisible(false);add.setVisible(false);size.setMinimum(8);size.setMaximum(294);size.setMinorTickSpacing(16);size.setMajorTickSpacing(142);size.setPaintTicks(true);}
    public void addMenuListener(JMenuItem menu)
    {
    	menu.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			menuEingabe(e.getActionCommand());
    		}
    	}); 
    }
    private void menuEingabe(String s)
    {
    	if(s.equals("Choose Pen Colour"))
    	{
    		a=1;Toolkit.getDefaultToolkit().beep();
    	}
    	else if(s.equals("Undo"))
    	{
    		panel.undo(panel.getdraw());
    	}
    	else if(s.equals("Window Mode"))
    	{
    		dispose();setUndecorated(false);pp=0;
    		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-28);setVisible(true);
    	}
    	else if(s.equals("FullScreen Mode"))
    	{
    		dispose();setUndecorated(true);setLocation(0,0);pp=1;
    		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);setVisible(true);
    	}
    	else if(s.equals("Redo"))
    	{
    		panel.redo(panel.getdraw());
    	}
    	else if(s.equals("Print Preview"))
    	{
    		Print();
    	}
    	else if(s.equals("Print"))
    	{
    		Printed(1);
    	}
    	else if(s.equals("Print Setup"))
    	{
    		Printed(2);
    	}
    	else if(s.equals("Exit"))
    	{
    		if(JOptionPane.showConfirmDialog(new JFrame(),"Are you sure to close this window?", "Really Closing?",JOptionPane.YES_NO_OPTION)==0){System.exit(0);}
    	}
    	else if(s.equals("Menu Tool Bar"))
    	{
    		if(mb==0){Tab.setVisible(false);mb=1;}else{Tab.setVisible(true);mb=0;} 
    	}
    	else if(s.equals("Drawing Tool Bar"))
    	{
    		if(db==0){tool.setVisible(false);db=1;}else{tool.setVisible(true);db=0;} 
    	}
    	else if(s.equals("Color Tool Bar"))
    	{
    		if(cb==0){open.setVisible(false);pane.setVisible(false);co1.setVisible(false);cb=1;}else{open.setVisible(true);pane.setVisible(true);
    			if(ik==1){co1.setVisible(true);}cb=0;} 
    		}
    		else if(s.equals("Choose Background Colour"))
    		{
    			a=2;Toolkit.getDefaultToolkit().beep();
    		}
    		else if(s.equals("Undo"))
    		{
    			panel.undo(panel.getdraw());
    		}
    		else if(s.equals("Redo"))
    		{
    			panel.redo(panel.getdraw());
    		}
    		else if(s.equals("About"))
    		{
    			if(ab==0&&!(panel.getDrawing()).equals("Text"))
    			{
                if(ik==1){open.doClick();}tool.setVisible(false);too.setVisible(false);//File.setVisible(false);
                ab=1;info.siz(panel.getSize());info.setVisible(true);info.siz(panel.getSize());info.what(1);
                panel.paint=1;info.repaint();
            }
            else if(ab==1){ab=0;info.setVisible(false);panel.paint=0;tool.setVisible(true);Tab.setVisible(true);too.setVisible(true);info.what(0);}
        }
        else if(s.equals("Save"))
        {   
        	Save();
        }
        else if(s.equals("Save as Image"))
        {
        	Image();
        }
        else if(s.equals("Load"))
        {
        	Load();
        }
        else if(s.equals("New"))
        {
        	New();
        }
        else if(s.equals("Add Image"))
        {
        	Add();
        }
        else if(!s.equals(""))
        	panel.setDrawing(s);   
    }
    public String name(String fold)
    {
    	String name="";
    	for(int i=fold.length()-1;i>=0;i--)
    	{
    		char t=fold.charAt(i);if(t=='/'||t=='\\')
    		{
    			for(int j=i+1;j<fold.length();j++){name=name+fold.charAt(j);}break;
    		}
    }
    return(name);
}
public void Wall()
{
	String Symbols[]={"~","!","@","#","$","%","^","&","*","(",")","_","-","+","=","|","\\","{","}","[","]",":",";","\"","\'","<",">",",",".","?","/"};
	theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_RGB);
	Graphics2D g = theImage.createGraphics();g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);panel.drawing(g);
	try{ImageIO.write(theImage, "BMP", new File("Icon/Wallpaper.bmp"));}catch(Exception y){System.out.println("error");}
	new Wallpaper(System.getProperty("user.dir")+"/Icon/Wallpaper.bmp");
}
public void Add()
{
	JFileChooser f = new JFileChooser();f.setPreferredSize(new Dimension(1100,700));
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files ( jpg , png , bmp , ico , gif , tga , tif , tiff , webp )", "jpg","png","bmp","ico","gif","tga","tif","tiff","webp");
	f.setFileFilter(filter);f.setFileView(new FileIconView(filter, new ImageIcon("ToolBar/image.png")));
	f.setAccessory(new ImagePreviewer(f));f.setCurrentDirectory(new File("."));f.setApproveButtonText("Add Image");f.setDialogTitle("Load an Image");
	int result =f.showOpenDialog(null);switch (result){case JFileChooser.CANCEL_OPTION:{Add.doClick();return;}}
	panel.ico = f.getSelectedFile().getPath();panel.repaint();
}
public String getExtention(String File){String ext="";int i=File.lastIndexOf('.');if(i>0){ext=File.substring(i+1);}return ext.toLowerCase();}
public void Image()
{
	JFileChooser f = new JFileChooser();
	f.setCurrentDirectory(new File("."));
	f.setApproveButtonText("Save");
	f.setDialogTitle("Save Image to");
        /////////////////////////////////////////////////
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Windows Metafile (.wmf)", "wmf");f.setFileFilter(filter);
	filter = new FileNameExtensionFilter("TIFF Tag Image File Format (.tif)", "tif");f.setFileFilter(filter);
	filter = new FileNameExtensionFilter("Device Independent Bitmap (.bmp)", "bmp");f.setFileFilter(filter);
	filter = new FileNameExtensionFilter("GIF Graphics Interchange Format (.gif)", "gif");f.setFileFilter(filter);
	filter = new FileNameExtensionFilter("PNG Portable Network Graphics Format (.png)", "png");f.setFileFilter(filter);
	filter = new FileNameExtensionFilter("JPEG File Interchange Format (.jpg)", "jpg");f.setFileFilter(filter);
	f.setFileView(new FileIconView(filter, new ImageIcon("ToolBar/image.png")));
	int result = f.showOpenDialog(null);
	switch (result)
	{
		case JFileChooser.CANCEL_OPTION:return;
	}
        //////////////////////////////////////////////////
	File myfile=f.getSelectedFile();
	if(f.getFileFilter().getDescription().equals("JPEG File Interchange Format (.jpg)"))
	{
		theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = theImage.createGraphics();g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);panel.drawing(g);
		try
		{
			if(getExtention(myfile.toString()).equals("jpg")){ImageIO.write(theImage, "JPEG",myfile);}
			else {ImageIO.write(theImage, "JPEG", new File(myfile.toString()+".jpg"));}
		}
		catch(Exception y){Image();}
	}
	else if(f.getFileFilter().getDescription().equals("PNG Portable Network Graphics Format (.png)"))
	{
		theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = theImage.createGraphics();g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);panel.drawing(g);
		try
		{
			if(getExtention(myfile.toString()).equals("png")){ImageIO.write(theImage, "PNG",myfile);}
			else {ImageIO.write(theImage, "PNG", new File(myfile.toString()+".png"));}
		}
		catch(Exception y){Image();}
	}
	else if(f.getFileFilter().getDescription().equals("GIF Graphics Interchange Format (.gif)"))
	{
		theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = theImage.createGraphics();g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);panel.drawing(g);
		try
		{
			if(getExtention(myfile.toString()).equals("gif")){ImageIO.write(theImage, "GIF",myfile);}
			else {ImageIO.write(theImage, "GIF", new File(myfile.toString()+".gif"));}
		}
		catch(Exception y){Image();}
	}
	else if(f.getFileFilter().getDescription().equals("Device Independent Bitmap (.bmp)"))
	{
		theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = theImage.createGraphics();g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);panel.drawing(g);
		try
		{
			if(getExtention(myfile.toString()).equals("bmp")){ImageIO.write(theImage, "BMP",myfile);}
			else {ImageIO.write(theImage, "BMP", new File(myfile.toString()+".bmp"));}
		}
		catch(Exception y){Image();}
	}
	else{JOptionPane.showMessageDialog(null,"Sorry This Format Not Available !!!");}
}
public void Save()
{
	JFileChooser f = new JFileChooser();f.setCurrentDirectory(new File("."));
	f.setApproveButtonText("Save");f.setDialogTitle("Save Your Project");
        /////////////////////////////////////////////////
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Xtreme Paint Projects ", "xtp");
	f.setFileFilter(filter);f.setFileView(new FileIconView(filter, new ImageIcon("Icon/k.png")));
	int result = f.showSaveDialog(null);
	switch (result)
	{
		case JFileChooser.CANCEL_OPTION:return;
	}
	String filename = f.getSelectedFile().getPath();
	Saver saver = new Saver();
	ArrayList saveArray = new ArrayList();
	saveArray.add(panel.getdraw());
	saver.save(filename, saveArray,panel.getdraw());
}
public void Load()
{
	try
	{
		JFileChooser f = new JFileChooser();
		f.setCurrentDirectory(new File("."));
		f.setApproveButtonText("Load");
		f.setDialogTitle("Load Existing Project");
            /////////////////////////////////////////////////
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Xtreme Paint Projects ", "xtp");
		f.setFileFilter(filter);f.setFileView(new FileIconView(filter, new ImageIcon("Icon/k.png")));
		int result = f.showOpenDialog(null);
		switch (result)
		{
			case JFileChooser.CANCEL_OPTION:return;
		}
            //////////////////////////////////////////////////
		String filename = f.getSelectedFile().getPath();
		Loader loader = new Loader();
		ArrayList loadArray = loader.load(filename);
		panel.setdraw((ArrayList)loadArray.get(0));
		Thread.sleep(500);panel.repaint();
		loader.deleteTemp(new File("Project/"+getName(filename)));
	}
	catch(Exception e){}
}
public String getName(String File)
{
	String name="";int i=File.lastIndexOf('\\');if(i>0){name=File.substring(i+1);}
	i=name.lastIndexOf('.');if(i>0){name=name.substring(0,i);}return name;
}
public void full()
{
	theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g = theImage.createGraphics();
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);panel.drawing(g);
        //new ImageEditor(new ImageIcon(theImage).getImage());
	new FullScreen(new ImageIcon(theImage).getImage());
}
public void Print()
{
	theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g = theImage.createGraphics();g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	panel.drawing(g);JFrame frame = new PrintTestFrame(theImage);
}
public void Printed(int i)
{
	theImage = new BufferedImage(PX,PY,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g = theImage.createGraphics();g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	panel.drawing(g);JFrame frame = new Print(theImage,i);
}
public String isjpg(String name)
{
	String t=name;int L=name.length();
	for(int i=L-1;i>L-6;i--)
	{
		char te=name.charAt(i);
		if(te=='.')
		{
			t=name.substring(0,i);break;
		}
	}
	return(t);
}
public void New()
{
	tcc.setColor(Color.black);panel.setBgFarbe(Color.white);panel.getdraw().clear();tb9.setSelected(true);size.setValue(0);
	panel.ico=" ";panel.getres().clear();panel.p=0;panel.L=0;panel.setDrawing("Pencil");panel.run();slider();
	if(sc==1){Screen.doClick();}if(ad==1){Add.doClick();}panel.p=0;panel.L=0;panel.O=0;panel.S=0;panel.cap=0;
	panel.TextPane.setVisible(false);txts=" ";Tsize.setText(txts);if(ik==1){open.doClick();}panel.repaint();
}
private static void abort(String msg) throws Exception { throw new IOException(msg);}
public static void copy(String from_name, String to_name)throws Exception
{
	File from_file = new File(from_name);File to_file = new File(to_name);
	if (!from_file.exists()){abort("FileCopy: no such source file: " + from_name);}
	if (!from_file.isFile()){abort("FileCopy: can't copy directory: " + from_name);}
	if (!from_file.canRead()){abort("FileCopy: source file is unreadable: " + from_name);}
	if (to_file.isDirectory()){to_file = new File(to_file, from_file.getName());}
	if (to_file.exists()) 
	{
		if (!to_file.canWrite()){abort("FileCopy: destination file is unwriteable: " + to_name);}
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));String response = in.readLine();
		if (!response.equals("Y") && !response.equals("y")){abort("FileCopy: existing file was not overwritten.");}
	}
	else 
	{  
		String parent = to_file.getParent(); 
		if (parent == null) parent = System.getProperty("user.dir");File dir = new File(parent);       
		if (!dir.exists()){abort("FileCopy: destination directory doesn't exist: " + parent);}
		if (dir.isFile()){abort("FileCopy: destination is not a directory: " + parent);}
		if (!dir.canWrite()){abort("FileCopy: destination directory is unwriteable: " + parent);}
	}
	FileInputStream from = null;FileOutputStream to = null;  
	try 
	{
		from = new FileInputStream(from_file); 
		to = new FileOutputStream(to_file);    
		byte[] buffer = new byte[4096];      
		int bytes_read;                        
		while((bytes_read = from.read(buffer)) != -1) 
			to.write(buffer, 0, bytes_read);            
	}
	finally 
	{
		if (from != null) try { from.close(); } catch (IOException e) { ; }
		if (to != null) try { to.close(); } catch (IOException e) { ; }
	}
}
}
class FileIconView extends FileView
{
	public FileIconView(FileFilter aFilter, Icon anIcon)
	{
		filter = aFilter;
		icon = anIcon;
	}
	public Icon getIcon(File f)
	{
		if (!f.isDirectory() && filter.accept(f)) return icon;
		else return null;
	}
	private FileFilter filter;
	private Icon icon;
}
class ImagePreviewer extends JLabel
{
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
	public ImagePreviewer(JFileChooser chooser)
	{
		setPreferredSize(new Dimension(500, 400));
		setBorder(BorderFactory.createEtchedBorder());
		chooser.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent event)
			{
				if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
				{
					File f = (File) event.getNewValue();
					if (f == null)
					{
						setIcon(null);
						return;
					}
					String path=f.getPath();
					if(img(path))
					{
						ImageIcon icon = new ImageIcon(path);
						if (icon.getIconWidth() > getWidth()) icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
						setIcon(icon);
					}
					else
					{
						try{
							File file = new File(path);sun.awt.shell.ShellFolder sf = sun.awt.shell.ShellFolder.getShellFolder(file);
							Icon icon = new ImageIcon(sf.getIcon(true));setIcon(icon);}catch(Exception e){}
						}
					}
				}
			});
	}
}