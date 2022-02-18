package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("kumar");
		addcust.custgender("male");
		addcust.custdob("09", "06","1997");
		addcust.custaddress("India");
		addcust.custcity("Hyderabad");
		addcust.custstate("AndhraPradesh");
		addcust.custpinno("515751");
		addcust.custtelephoneno("9854671236");
		String email= randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("jeevan123456");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		boolean ris= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(ris==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"AddNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
}
