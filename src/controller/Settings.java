package controller;

import java.io.*;

import utils.CONFIG;
import utils.CONSTS;

public class Settings {
	private static int language=0;
	public static void initSettings()
	{
		File f=new File(CONFIG.CONFIG_FILE_NAME);
		try {
			BufferedReader reader=new BufferedReader(new FileReader(f));
			String strTemp=reader.readLine();
			String language=strTemp.substring(strTemp.indexOf(CONSTS.CONFIG_STRING_SPLIT)+1,strTemp.length());
			if(language.equals(CONSTS.STRING_LANGUAGE_ENGLISH))
			{
				Settings.language=0;
			}
			else
			{
				Settings.language=1;
			}
			if(reader!=null)
			{
				reader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveSettings()
	{
		String writeTo="language=";
		File f=new File(CONFIG.CONFIG_FILE_NAME);
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(f));
			if(Settings.language==CONSTS.LANGUAGE_ENGLISH)
			{
				writeTo+=CONSTS.STRING_LANGUAGE_ENGLISH;
			}
			else
			{
				writeTo+=CONSTS.STRING_LANGUAGE_CHINESE;
			}
			writer.write(writeTo);
			if(writer!=null)
			{
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the language
	 */
	public static int getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public static void setLanguage(int language) {
		Settings.language = language;
	}
	
}
