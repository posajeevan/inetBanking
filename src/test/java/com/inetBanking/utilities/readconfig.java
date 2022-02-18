package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {

	Properties prop;
	
	public readconfig()
	{
		File src=new File("./Configurations/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+e.getMessage());
		}
		
		
	}
	
	public String getApplicationUrl()
	{
		String url=prop.getProperty("baseUrl");
		return url;
	}
	public String getUserName()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	public String getChromepath()
	{
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxpath()
	{
		String firefoxpath=prop.getProperty("firefoxpath");
		return firefoxpath;
	}
}
