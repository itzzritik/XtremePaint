package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.event.*;
public class FullScreen extends JFrame 
{
	Image imag;DrawCanvas canvas;
	public FullScreen(Image img)
	{
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent w){}
			@Override
			public void windowOpened(WindowEvent e){}
			@Override
			public void windowClosed(WindowEvent e){}
			@Override
			public void windowIconified(WindowEvent e){}
			@Override
			public void windowDeiconified(WindowEvent e){canvas.Background=new Capture().Screen().getImage();canvas.repaint();}
			@Override
			public void windowActivated(WindowEvent e){}
			@Override
			public void windowDeactivated(WindowEvent e){}
		});
		setTitle("Image Preview");imag=img;
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice defaultScreen = env.getDefaultScreenDevice();
		if (!defaultScreen.isFullScreenSupported()) 
		{
			JOptionPane.showMessageDialog(null,"Sorry!   FullScreen Not Supported on Your System","Error !!!",
				JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Icon/error.png"));
		}
		canvas=new DrawCanvas(imag,new Capture().Screen().getImage());
		getContentPane().add(canvas);
		setDefaultCloseOperation(HIDE_ON_CLOSE);setUndecorated(true);
		setResizable(false);defaultScreen.setFullScreenWindow(this);
       setVisible(true);//setSize(500,500);
   }
   private class DrawCanvas extends JPanel implements MouseListener, MouseMotionListener,MouseWheelListener
   {
   	Image img,Background;int x=0,y=0,s1=0,s2=0;
   	JSlider size = new JSlider(JSlider.HORIZONTAL,1,10000,1);ImageIcon it;int x1=0,x2,y1=0,y2;int old1=0,old2=0;int res=0,val2=0;
   	int wf=Toolkit.getDefaultToolkit().getScreenSize().width,hf=Toolkit.getDefaultToolkit().getScreenSize().height;
   	DrawCanvas(Image img,Image Back)
   	{
   		setLayout(new BorderLayout());setDoubleBuffered(true);
   		Background=new ImageIcon(Back).getImage();
   		this.img=img;it=new ImageIcon(img);s1=new ImageIcon(img).getIconWidth();s2=new ImageIcon(img).getIconHeight();
   		x= Toolkit.getDefaultToolkit().getScreenSize().width;x=x/2;x=x-(new ImageIcon(img).getIconWidth()/2);
   		y= Toolkit.getDefaultToolkit().getScreenSize().height;y=y/2;y=y-(new ImageIcon(img).getIconHeight()/2);
   		size.setFocusable(true);size.requestFocus();size.addKeyListener(new KeyAdapter() 
   		{
   			public void keyPressed(KeyEvent e) 
   			{
   				if(e.getKeyCode()==27){dispose();}
   			}
   		});
   		JPanel pane=new JPanel(new FlowLayout());pane.addMouseListener(new MouseListener()
   		{
   			public void mouseClicked(MouseEvent e){}public void mousePressed(MouseEvent e){}public void mouseReleased(MouseEvent e){}
   			public void mouseExited(MouseEvent e){}
   			public void mouseEntered(MouseEvent e){setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));}
   		});
   		addMouseListener(this);addMouseWheelListener(this);addMouseMotionListener(this);
   		size.addChangeListener(new ChangeListener()
   		{
   			public void stateChanged(ChangeEvent e)
   			{
   				
   			}
   		});pane.setOpaque(false);JLabel zoom=new JLabel(new ImageIcon("Icon/zoom.png"));zoom.setText("     ");
   		size.setPreferredSize(new Dimension(500,30));pane.add(zoom);pane.add(size);add(pane,BorderLayout.SOUTH);
   	}
   	public void mouseReleased(MouseEvent e){setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));}
   	public void mouseClicked(MouseEvent e){dispose();}public void mouseEntered(MouseEvent e){}
   	public void mouseMoved(MouseEvent e){if(e.getX()>=x&&e.getY()>=y&&e.getX()<=(x+s1)&&e.getY()<=(y+s2)){setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));}
   	else{setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));}}
   	public void mousePressed(MouseEvent e){x1=e.getX();y1=e.getY();
   		if(e.getX()>=x&&e.getY()>=y&&e.getX()<=(x+s1)&&e.getY()<=(y+s2)){setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));}}
   		public void mouseExited(MouseEvent e){}public void mouseDragged(MouseEvent e)
   		{
   			if(e.getX()>=x&&e.getY()>=y&&e.getX()<=(x+s1)&&e.getY()<=(y+s2)){
   				x2=e.getX();y2=e.getY();if(x1>x2){x=x-(x1-x2);}else{x=x+(x2-x1);}if(y2>x1){y=y-(y1-y2);}else{y=y+(y2-y1);}repaint();x1=e.getX();y1=e.getY();}
   			}
   			public void mouseWheelMoved(MouseWheelEvent e) 
   			{
   				if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) 
   					{res=res-(e.getWheelRotation()*200);size.setValue(res);}
   			}
   			@Override
   			public void paintComponent(Graphics g2d)
   			{
   				super.paintComponent(g2d);g2d.setColor(new Color(0,0,0,100));
   				g2d.drawImage(Background,0,0,wf,hf,null);
         //g.fillRect(0,0,wf,hf);
   				Graphics2D g = (Graphics2D) g2d;
   				if (g instanceof Graphics2D) 
   				{
   					Paint p =new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 100),0.0f, getHeight(), new Color(0,0,0,150), true);
   					Graphics2D gg = (Graphics2D)g;gg.setPaint(p);gg.fillRect(0, 0, getWidth(), getHeight());
   				}
   				g2d.drawImage(img,x,y,s1,s2,null);
         //g.drawRect(5,5,wf-10,hf-10);
   			}
   		}
   	}