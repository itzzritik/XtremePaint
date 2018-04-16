import java.awt.*;
import javax.swing.*;import java.awt.event.*;
public class StatusBar extends JPanel 
{
	JLabel pos=new JLabel("0  ,  0                  ");JLabel resize =new JLabel(new AngledLinesWindowsCornerIcon());
	public StatusBar() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(10, 23));
		JPanel rightPanel = new JPanel(new BorderLayout());JPanel pane=new JPanel(new BorderLayout());
		pane.add(resize,BorderLayout.SOUTH);
		rightPanel.add(pane, BorderLayout.EAST);
		rightPanel.add(pos, BorderLayout.WEST);
		rightPanel.setOpaque(false);
		add(rightPanel, BorderLayout.EAST);
		resize.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(1,1,1,1)));
	}
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
	}
}
class AngledLinesWindowsCornerIcon implements Icon 
{
	private static final Color WHITE_LINE_COLOR = new Color(255, 255, 255);
	private static final Color GRAY_LINE_COLOR = new Color(172, 168, 153);
	private static final int WIDTH = 13;
	private static final int HEIGHT = 13;
	public int getIconHeight() {return WIDTH;}
	public int getIconWidth(){ return HEIGHT;}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		g.setColor(WHITE_LINE_COLOR);
		g.drawLine(0, 12, 12, 0);
		g.drawLine(5, 12, 12, 5);
		g.drawLine(10, 12, 12, 10);
		g.setColor(GRAY_LINE_COLOR);
		g.drawLine(1, 12, 12, 1);
		g.drawLine(2, 12, 12, 2);
		g.drawLine(3, 12, 12, 3);
		g.drawLine(6, 12, 12, 6);
		g.drawLine(7, 12, 12, 7);
		g.drawLine(8, 12, 12, 8);
		g.drawLine(11, 12, 12, 11);
		g.drawLine(12, 12, 12, 12);
	}
}
