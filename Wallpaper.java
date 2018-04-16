import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.*;import java.util.*;
@SuppressWarnings("serial")
public class Wallpaper
{
	public Wallpaper(String p)
	{
		File file = new File("Icon/wall.bat");
		try
		{
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter wr = new BufferedWriter(fileWriter);
			wr.write("@echo off");wr.newLine();
			wr.write("call :quiet>nul 2>&1");wr.newLine();
			wr.write("goto :EOF");wr.newLine();
			wr.write(":quiet");wr.newLine();
			wr.write(":: Configure Wallpaper");wr.newLine();
			wr.write("reg add \"hkcu\\control panel\\desktop\" /v wallpaper /t REG_SZ /d \"\" /f ");wr.newLine();
			wr.write("reg add \"hkcu\\control panel\\desktop\" /v wallpaper /t REG_SZ /d \""+p+"\" /f ");wr.newLine();
			wr.write("reg delete \"hkcu\\Software\\Microsoft\\Internet Explorer\\Desktop\\General\" /v WallpaperStyle /f");wr.newLine();
			wr.write(":: Make the changes effective immediately");wr.newLine();
			wr.write("%SystemRoot%\\System32\\RUNDLL32.EXE user32.dll,UpdatePerUserSystemParameters ");wr.newLine();
			wr.write("exits");wr.newLine();wr.close();
			Desktop desktop = null;if (Desktop.isDesktopSupported()){desktop = Desktop.getDesktop();}
			desktop.open(new File("Icon/wall.bat"));Thread.sleep(500);new File("Icon/wall.bat").delete();
		}
		catch(Exception e){}
	}
}