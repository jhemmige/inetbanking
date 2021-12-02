package com.inetbanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.Driver;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginPageObjects;

public class TC_LoginTest_001_test extends BaseClass{
	
	@Test
	public void loginTest() throws IOException  {
		
		driver.get(BaseURL);
		
		logger.info("window opened correctly");
		logger.debug("I am debugging");
		loginPageObjects lpo= new loginPageObjects(driver);
		
		//This uses @findby methods in loginpageObjects Class
		lpo.setUname(UID); // this requires data from baseclass since LoginPage Object has Uname as Parameter
		lpo.setPwd(PWD);
		lpo.signIn();
		
		
		System.out.println(logger.getName());
		
		logger.error("there's no error here");
		logger.error("what should the msg be here");
		
		//not a good idea to hardcode UserID /Pwd
		/*lpo.settingUname().sendKeys("mngr369280");
		lpo.SettingPwd().sendKeys("YrujEnE");
		lpo.entryIn();*/
		
		
		//This uses BY methods in loginpageObjects Class
		/*lpo.settingUname().sendKeys(UID);
		lpo.SettingPwd().sendKeys(PWD);
		lpo.entryIn();*/
		
		System.out.println(driver.getTitle());
		
		//validation
		
		 if 
		
		(driver.getTitle().equals("GTPL Bank Manager HomePage"))
			
		{
			Assert.assertTrue(true);
			System.out.println("test passed");
			System.out.println(System.getProperty("user.dir"));
			logger.info("title shown correctly1");
			logger.info("Lets add more to this");
		}
		 
	 else {
		 
		captureScreen(driver, "loginTest");
		Assert.assertTrue(false);
		System.out.println("test failed");
		logger.info("title not shown correctly");

		
		
		
	 }
}
	
}
