package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPageObjects {
	
	
	WebDriver ldriver;
	

	public AddCustomerPageObjects(WebDriver rdriver){
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);	
		
		
	}
	
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how= How.NAME, using="name")
	@CacheLookup
	WebElement AddName;
	

	@FindBy(how= How.XPATH, using="//tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement clickGender;
	
	
	@FindBy(how= How.NAME, using="rad1")
	@CacheLookup
	WebElement inputDOB;
	
	@FindBy(how= How.NAME, using="addr")
	@CacheLookup
	WebElement inputAddress;
	
	@FindBy(how= How.NAME, using="city")
	@CacheLookup
	WebElement inputCity;
	
	@FindBy(how= How.NAME, using="state")
	@CacheLookup
	WebElement inputstate;
	
	@FindBy(how= How.NAME, using="pinno")
	@CacheLookup
	WebElement inputpincode;
	
	@FindBy(how= How.NAME, using="telephoneno")
	@CacheLookup
	WebElement inputtelephone;
	
	@FindBy(how= How.NAME, using="emailid")
	@CacheLookup
	WebElement inputemailID;
	
	
	@FindBy(how= How.NAME, using="sub")
	@CacheLookup
	WebElement clickSubmit;
	
	
	
	public void clickAddNewcust() {
		
		lnkAddNewCustomer.click();
		
	}
	
	
	public void addNewcustName(String custname) {
		
		AddName.sendKeys(custname);
		
	}
	
	public void chooseGender() {
		
		clickGender.click();
		
	}
	
	public void addDOB(String mm, String dd, String yyyy) {
		
		
		inputDOB.sendKeys(mm);
		inputDOB.sendKeys(dd);
		inputDOB.sendKeys(yyyy);
	
	}
	
	public void AddAddress(String cAddress) {
		
		inputAddress.sendKeys(cAddress);
		
	}
	
	public void addCity(String ccity) {
		
		inputCity.sendKeys(ccity);
		
	}
	
	
	public void addState(String cstate) {
		inputstate.sendKeys(cstate);
		
	}
	
	public void custpinno(String cpinno) {
		inputpincode.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		inputtelephone.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		inputemailID.sendKeys(cemailid);
	}


	public void clicksubmitbutton() {
	clickSubmit.click();
	}
	
	
}
