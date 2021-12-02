 package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPageObjects;
import com.inetbanking.pageobjects.loginPageObjects;

public class TC_AddNewCustomer_003_test extends BaseClass {
	
	
	
	@Test
	public void addingCustomer() throws InterruptedException, IOException {
		
		
		loginPageObjects logT= new loginPageObjects(driver);
		
		logT.setUname(UID);
		logT.setPwd(PWD);
		logT.signIn();
		
		
		Thread.sleep(3000);
		
		
		AddCustomerPageObjects Addcust= new AddCustomerPageObjects(driver);
		
		Addcust.clickAddNewcust();
		Addcust.addNewcustName("JayHe");
		Addcust.chooseGender();
		Addcust.addDOB("12", "02", "1920");
		Addcust.AddAddress("test address");
		
		Thread.sleep(3000);
		
		Addcust.addCity("Bangalore");
		Addcust.addState("karnataka");
		Addcust.custpinno("560090");
		Addcust.custtelephoneno("99011234565");

		String randemail=	getrandomemail()+"@gmail.com";
		Addcust.custemailid(randemail);
		Addcust.clicksubmitbutton();
		System.out.println(getrandomemail()+"gmail.com");
	
		
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			System.out.println("msg is present");
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			System.out.println("msg is absent");
			logger.info("test case failed....");
			captureScreen(driver,"addingCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
	public String getrandomemail() {
		
		
		String randomEmail= RandomStringUtils.randomAlphabetic(8);
		
		return randomEmail;
	}
	
	
	public String getRandomnNum() {
	
	
	String Alphnum=	RandomStringUtils.randomAlphanumeric(5);
	
	return Alphnum;
}
	
}
