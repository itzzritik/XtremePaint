import java.util.*;
public class changer
{
	public static native int SystemParametersInfo(int uiAction,int uiParam,String pvParam,int fWinIni);
	static
	{
		System.loadLibrary("user32");
	}
	public int Change(String path)
	{
		return SystemParametersInfo(20, 0, path, 0);
	}
	public static void main(String args[])
	{
		String wallpaper_file = "c:\\wallpaper.jpg";
		changer mychanger = new changer();
		mychanger.Change(wallpaper_file);
	}
}