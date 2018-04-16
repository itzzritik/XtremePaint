import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import java.util.ArrayList;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
public class Saver extends Frame
{
	private BufferedImage theImage;
	private MainPanel panel;
	public Saver()
	{
	}
	public void save(String filename, ArrayList objekte,ArrayList drawing)
	{
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream("Project.Xtreme");
			out = new ObjectOutputStream(fos);
			out.writeObject(objekte);
			out.close();
			
			ArrayList Stamps = new ArrayList();ArrayList Frames = new ArrayList();
			for(int i=0; i<drawing.size(); i++)
			{
				if(String.valueOf(drawing.get(i)).startsWith("Stamp"))
				{
					Stamp st = (Stamp)drawing.get(i);
					Stamps.add(new File(st.getstamp()));
				}
				if(String.valueOf(drawing.get(i)).startsWith("Frames"))
				{
					Frames fr = (Frames)drawing.get(i);
					Frames.add(new File(fr.getframe()));
				}
			}
			ArrayList Project = new ArrayList();Project.add(new File("Project.Xtreme"));
			ArrayList Others = new ArrayList();Others.add(new File("Icon\\stop.gif"));
			Saver(Stamps,Frames,Others,Project,filename);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error!");
		}
	}
	public String getExtention(String File){String ext="";int i=File.lastIndexOf('.');if(i>0){ext=File.substring(i+1);}return ext.toLowerCase();}
	public void Saver(ArrayList Stamps,ArrayList Frames,ArrayList Others,ArrayList Project,String SavePath) 
	{
		try 
		{
			ZipFile zipFile;System.out.println(SavePath);
			if(getExtention(SavePath).equals("xtp")){zipFile = new ZipFile(SavePath);}else{zipFile = new ZipFile(SavePath+".xtp");}
			ZipParameters parameters = new ZipParameters();
			parameters.setEncryptFiles(true);parameters.setPassword("XtremeCorporation");
			parameters.setEncryptionMethod(99);parameters.setAesKeyStrength(3);
			if(Project.size()!=0){zipFile.addFiles(Project, parameters);}
			parameters.setRootFolderInZip("Stamps/");
			if(Stamps.size()!=0){zipFile.addFiles(Stamps, parameters);}
			parameters.setRootFolderInZip("Frames/");
			if(Frames.size()!=0){zipFile.addFiles(Frames, parameters);}
			parameters.setRootFolderInZip("Others/");
			if(Others.size()!=0){zipFile.addFiles(Others, parameters);}
		} 
		catch (ZipException e) 
		{
			e.printStackTrace();
		} 
	}
}
