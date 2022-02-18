package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_Logintest_001 extends BaseClass {
	@Test
	public void loginTest() throws IOException 
	{
		
		
		logger.info("URL opened");
		
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		
		logger.info("Entered username");
		lp.setPassword(password);
		
		logger.info("Entered password");
		
		if(driver.getTitle().equals("Guru99 Bank Home Page"))
		{
			Assert.assertTrue(true);
			logger.info("login test pass");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}
