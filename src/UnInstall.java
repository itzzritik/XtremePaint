package src;

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.*;import java.io.File;
public class UnInstall extends JFrame implements ActionListener,Runnable
{    
	JLabel logo = new JLabel(new ImageIcon("Icon/logo.png"));JPanel s1=new JPanel(new BorderLayout());JButton finish = new JButton(" Un-Install ");
	JButton prev = new JButton(" Previous ");JButton next = new JButton(" Next ");JButton cancle = new JButton(" Cancle ");int pr=0;int reset=1;
	JLabel p1=new JLabel();JLabel p2=new JLabel();JLabel p3=new JLabel();JLabel p4=new JLabel();JProgressBar pro = new JProgressBar(0,2000);
	JLabel p5=new JLabel();String txt[]={"Welcome To Ritik's Paint Un-Install Program","This Will Delete All The Data of Ritik's Paint Program",
	"Press Next To Procide With The Uninstall of The Program","Or Press Cancle Button To Close"};int num = 0;int t=0;Thread th=new Thread(this);
	JLabel p6=new JLabel("                                                                ");int z1=0;
	JCheckBox yes =new JCheckBox("Restart");JCheckBox no=new JCheckBox("Restart Later");ButtonGroup g = new ButtonGroup();
	public UnInstall()
	{
		super("Un-Install => Ritik's Paint");setSize(600,520);setResizable(false);logo.setBackground(Color.black);
		int x= Toolkit.getDefaultToolkit().getScreenSize().width;x=x/2;x=x-(this.getWidth()/2);
		int y= Toolkit.getDefaultToolkit().getScreenSize().height;y=y/2;y=y-(this.getHeight()/2);setLocation(x,y);prev.setVisible(false);
		JPanel f1 = new JPanel(new FlowLayout());finish.setVisible(false);p1.setText(txt[0]);p2.setText(txt[1]);p3.setText(txt[2]);p4.setText(txt[3]);
		prev.setIcon(new ImageIcon("Icon/left.png"));next.setIcon(new ImageIcon("Icon/right.png"));finish.setIcon(new ImageIcon("Icon/right.png"));
		prev.setPreferredSize(new Dimension(100,40));next.setPreferredSize(new Dimension(100,40));
		cancle.setPreferredSize(new Dimension(120,40));finish.setPreferredSize(new Dimension(120,40));
		f1.add(prev);f1.add(next);f1.add(finish);f1.add(cancle);
		JPanel full = new JPanel(new BorderLayout());full.add(f1,"East");
		Font ft = new Font("Comic Sans MS",Font.PLAIN, 16);yes.setSelected(true);
		cancle.addActionListener(this);next.addActionListener(this);prev.addActionListener(this);finish.addActionListener(this);JPanel st=new JPanel();
		p1.setFont(ft); p2.setFont(ft);p3.setFont(ft);p4.setFont(ft);p5.setFont(ft);p6.setFont(ft);g.add(yes);g.add(no);
		st.add(new JLabel(new ImageIcon("Icon/top.png")));st.add(p1);st.add(p2);st.add(p3);st.add(p4);st.add(pro);st.add(yes);
		
		no.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				reset=0;
			}
		});
		yes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				reset=1;
			}
		});
		st.add(new JLabel(" "));st.add(no);
		st.add(p6);st.add(p5);pro.setVisible(false);yes.setVisible(false);no.setVisible(false);
		s1.add("West", logo);s1.add("Center", st);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("Center", s1);
		getContentPane().add("South",full);setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == prev)
		{
			p1.setText(txt[0]);p2.setText(txt[1]);p3.setText(txt[2]);p4.setText(txt[3]);finish.setVisible(false);next.setVisible(true);
		}
		else if (e.getSource() == next)
		{
			prev.setVisible(true);p1.setText("Now You Are Ready To Un-Install From Your System");p2.setText("                                              ");
			p3.setText("Press Cancle Button To Exit The Un-Installer"); p4.setText("Press Finish Button To Procide Un-Install");next.setVisible(false);finish.setVisible(true);
		}
		else if (e.getSource() == finish)
		{
			p1.setText("Please Wait While Ritik's Paint is Being Un-Installed");p2.setText("                                              ");pr=1;
			p3.setText("                                              "); p4.setText("                                              ");pro.setVisible(true);
			pro.setPreferredSize(new Dimension(410,21));pro.setIndeterminate(true);pro.setValue(0);
			prev.setVisible(false);next.setVisible(false);cancle.setEnabled(false);finish.setVisible(false);cancle.setText(" Next ");
			cancle.setIcon(new ImageIcon("Icon/right.png"));p5.setText(" Initializing The Files ");th.start();
		}
		else if (e.getSource() == cancle)
		{
			if(pr==0){int ins=Integer.parseInt(String.valueOf(JOptionPane.showConfirmDialog(null,"Do You Really Wan't To cancle The Un-Install",
				"Cancle",JOptionPane.OK_CANCEL_OPTION)));if(ins==0){setVisible(false);}}else if(pr==1)
			{
				p1.setText("Ritik's Paint Has Been Un-Installed From Your System");p2.setText("Your System needs a Restart So Choose an Option :");
				p3.setText("                                                                                       ");
				p4.setText("      ");
				pro.setVisible(false);yes.setVisible(true);no.setVisible(true);
				cancle.setText(" Finish ");p5.setText("");pr=2;
			}
			else{if(reset==1){try{Runtime.getRuntime().exec("shutdown -r");}catch(Exception pe){}}setVisible(false);}
		}
	}
	public void run()
	{
		if(z1==0){
			try{Thread.sleep(2000);} catch (InterruptedException ef){}pro.setIndeterminate(false);z1=1;}
			else{
				if(t==0) 
				{
					p5.setText("   "+((num*100)/2000)+" %");pro.setValue(num);
					num=num+20;if(num>2010){t=1;}
				}
				else if(t==1) 
				{
					try{Thread.sleep(1000);} catch (InterruptedException e){}
					p1.setText("Ritik's Paint Has Been Un-Installed From Your System");p2.setText("                                              ");
					p3.setText("Please Wait While Un-Installer Initializes The Files");p4.setText("                                              ");
					pro.setPreferredSize(new Dimension(410,25));pro.setIndeterminate(true);p5.setText(" Initializing ");
					try{Thread.sleep(2500);} catch (InterruptedException e){}
					p3.setText("Please Press Finish Button To Exit");
					File file = new File("Icon/del.bat");Desktop desktop = null;
					if (Desktop.isDesktopSupported()){desktop = Desktop.getDesktop();}
					try{desktop.open(file);}catch (Exception re){}p5.setText(" Compleated ");cancle.setEnabled(true);th.stop();
				}}
				try{Thread.sleep(30);}catch (InterruptedException e){}run();
			}
			public static void main()
			{
				try
				{
					for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
					{
						if ("Nimbus".equals(info.getName()))
						{
							UIManager.setLookAndFeel(info.getClassName());
							UIManager.getLookAndFeelDefaults().put("nimbusOrange", (new Color(0,120,240)));break;
						}
					}
				} catch (Exception ex){}
				UnInstall c = new UnInstall();c.setSize(600,520);c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}

