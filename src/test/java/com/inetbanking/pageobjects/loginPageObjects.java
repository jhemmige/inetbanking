package com.inetbanking.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginPageObjects {
	
	
WebDriver ldriver;


public loginPageObjects(WebDriver rdriver){
	
	
	ldriver=rdriver;
	
	PageFactory.initElements(rdriver, this);	
		
}


@FindBy(name="uid")
@CacheLookup
WebElement txtUname;
//insert enum body to complete declaration- this error means, we should insert a variable

@FindBy(name="password")
@CacheLookup
WebElement pwd;

@FindBy(xpath="//input[@value='LOGIN']")
@CacheLookup

WebElement login;

@FindBy(xpath="//a[contains(text(),'Log out')]")
@CacheLookup

WebElement logout;


/*By emailID=By.name("uid");

By pawd= By.name("password");

By signin=By.xpath("//input[@value='LOGIN']");

By Logout= By.xpath("//a[contains(text(),'Log out')]");*/

// this method doesnot return anything. Uses Uname as parameter.
public void setUname(String Uname) {
	
	txtUname.sendKeys(Uname);
	
	
}
//this method doesnot return anything. Uses Password as parameter.
public void setPwd(String Password) {
	
	
	pwd.sendKeys(Password);
	
}

public void signIn() {
	
	
	login.click();

}

public void signout() {
	
	logout.click();
	
}


/**public WebElement settingUname() {
	
	WebElement w=ldriver.findElement(emailID);
	
	return w;
	
}

public WebElement SettingPwd() {
	
	return ldriver.findElement(pawd);
	
}	
public WebElement entryIn() {
	
	return ldriver.findElement(signin);
	
}**/


}