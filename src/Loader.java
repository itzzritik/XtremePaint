import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import net.lingala.zip4j.core.ZipFile;import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
public class Loader
{
	boolean Yesall=false,Noall=false;public Loader(){}
	public void Extract(String filename,String name)
	{
		try 
		{
			ZipFile zipFile = new ZipFile(filename);
			if (zipFile.isEncrypted()) 
			{
				zipFile.setPassword("XtremeCorporation");
			}
			List fileHeaderList = zipFile.getFileHeaders();
			for (int i = 0; i < fileHeaderList.size(); i++) 
			{
				FileHeader fileHeader = (FileHeader)fileHeaderList.get(i);
				zipFile.extractFile(fileHeader,"Project\\"+name+"\\");
			}
		} 
		catch (ZipException e) 
		{
			e.printStackTrace();
		}
	}
	public String getName(String File)
	{
		String name="";int i=File.lastIndexOf('\\');if(i>0){name=File.substring(i+1);}
		i=name.lastIndexOf('.');if(i>0){name=name.substring(0,i);}return name;
	}
	public ArrayList load(String filename)
	{
		Extract(filename,getName(filename));ArrayList DrawList = new ArrayList();FileInputStream fis = null;ObjectInputStream in = null;
		ArrayList StampDel = new ArrayList();
		try
		{
			fis = new FileInputStream("Project/"+getName(filename)+"/Project.Xtreme");
			in = new ObjectInputStream(fis);DrawList = (ArrayList)in.readObject();in.close();
			String[] files=new File("Project/"+getName(filename)+"/Stamps/").list();
			for(int i=0;i<files.length;i++)
			{
				if(!(new File("Drawing/Stamps/"+files[i]).exists()))
				{
					if(!Yesall&&!Noall)
					{
						Object[] options = {"Add","Add all","Skip","Skip all"};
						int opt=JOptionPane.showOptionDialog(null,"A New Stamp Named "+files[i]+" Exists in The Loaded Project File."+
							"\nDo You Want to Add The Stamp in Your Library ?","Congratulation !!!",
							1,1,new ImageIcon("Project/"+getName(filename)+"/Stamps/"+files[i]),options,null);
						if(opt==0){}else if(opt==1){Yesall=true;}else if(opt==2){}else if(opt==3){Noall=true;}
					}
					if(!Noall)
					{
						copy("Project/"+getName(filename)+"/Stamps/"+files[i],"Drawing/Stamps/"+files[i]);
					}
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Sorry!   Error In Loading The File \nPlease Check The File\nIt May Be Damaged or Corrupt !!!\nError => "+e,"Error !!!",
				JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Icon/stop.gif"));
		}
		return DrawList;
	}
	public void deleteTemp(File file)throws IOException
	{
		if(file.isDirectory())
		{
			if(file.list().length==0)
			{
				file.delete();
				System.out.println("Directory is deleted : "+ file.getAbsolutePath());
			}
			else
			{
				String files[] = file.list();
				for (String temp : files) 
				{
					File fileDelete = new File(file, temp);
					deleteTemp(fileDelete);
				}
				if(file.list().length==0)
				{
					file.delete();
					System.out.println("Directory is deleted : "+ file.getAbsolutePath());
				}
			}
		}
		else
		{
			file.delete();
			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}
	public void copy(String from_name, String to_name)
	{
		try
		{
			File from_file = new File(from_name);File to_file = new File(to_name);
			FileInputStream from = null;FileOutputStream to = null;  
			from = new FileInputStream(from_file);to = new FileOutputStream(to_file);    
			byte[] buffer = new byte[4096];int bytes_read;                        
			while((bytes_read = from.read(buffer)) != -1){to.write(buffer, 0, bytes_read);}    
		}
		catch(Exception e){System.out.println(e);}
	}
}