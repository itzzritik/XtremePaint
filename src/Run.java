package src;

public class Run
{
    public static void main(String[] args)
    {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if (info.getName().equals("Nimbus"))
                {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());break;
                }
            }
            //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.GTKLookAndFeel");
            new MainWindow().showWindow();
        }catch(Exception e){}
    }
}