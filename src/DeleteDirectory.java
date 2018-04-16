package src;

import java.io.File;
import java.io.IOException;

public class DeleteDirectory
{
	private static final String SRC_FOLDER = "C:/Ritik Blue j";
	public static void main(String[] args)
	{   
		File directory = new File(SRC_FOLDER);
		if(!directory.exists())
		{
			System.out.println("Directory does not exist.");
			System.exit(0);
		}
		else
		{
			try
			{
				delete(directory);
			}
			catch(IOException e)
			{
				e.printStackTrace();System.exit(0);
			}
		}
		System.out.println("Done");
	}
	public static void delete(File file)throws IOException
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
					delete(fileDelete);
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
}