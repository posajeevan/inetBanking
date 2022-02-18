package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.readconfig;

public class BaseClass {
	
	readconfig readcon=new readconfig();
	
	public String baseUrl=readcon.getApplicationUrl();
	public String username=readcon.getUserName();
	public String password=readcon.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("C:\\Users\\W10-Lenovo\\eclipse2\\inetBankingV1\\log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readcon.getChromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readcon.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
    
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomString()
	{
		String generatedstring= RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}
	public String randomNum()
	{
		String generatedstring2= RandomStringUtils.randomNumeric(4);
		return (generatedstring2);
	}
}
