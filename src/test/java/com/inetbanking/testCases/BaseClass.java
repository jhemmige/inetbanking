package com.inetbanking.testCases;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import com.inetbanking.pageobjects.loginPageObjects;
import com.inetbanking.utilities.ReadConfig;



public class BaseClass{
	
	ReadConfig rc= new ReadConfig();
	
//Step 1: 	Declaring variables that's going to be used in test and then a driver.
	
	/*String BaseURL= "http://demo.guru99.com/V1/index.php";
	String UID= "mngr369280";
	String PWD= "YrujEnE";
	//public static Logger log ;*/
	WebDriver driver;
	String BaseURL= rc.SettingURL();
	String UID= rc.getUsername();
	String PWD= rc.getPassword();
	 // this driver is to instantiate chromedriver.
	
public static Logger logger; 	
//Step 2 is instantiation of Driver. Determining which driver - chrome, firefox, ie is used.	
//Get property is a method used to identify the file path until the project folder.so, instead of using 	
///Users/jayashreehemmige/eclipse-workspace/MavenSelYoutubeBankingProject/Drivers/chromedriver directly, 
// we use user.dir which fetches /Users/jayashreehemmige/eclipse-workspace/[PROJECTNAME]
	
	//@SuppressWarnings("deprecation")
	@Parameters("Browser")
	//@BeforeTest // TestNG annotation for prerequisite setup
	@BeforeClass
	public void testSetUp(String Br) {
		
	logger =	LogManager.getLogger(BaseClass.class.getName());
	//somehow fails	
		//System.setProperty(key, value)
		
	//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ ".\\Drivers\\chromedriver");
	
	
	
	if (Br.equals("chrome")) {	
		
		System.setProperty("webdriver.chrome.driver",rc.getChromePath());
		
		driver= new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","/Users/jayashreehemmige/eclipse-workspace/MavenSelYoutubeBankingProject/Drivers/chromedriver");
		
		
	}
	
	else if(Br.equals("firefox")) {
		
		System.setProperty("webdriver.gecko.driver",rc.getfirefoxPath());
		
		driver = new FirefoxDriver();
		
		//log= LogManager.getLogger(BaseClass.class.getName()); //dont get confused 
		//PropertyConfigurator.configure("log4j.properties");//dont get confused 
		//DOMConfigurator.configure("/resources/log4j2.xml");//dont get confused 
	}
	
	else if (Br.equals("ie")){
		
		System.setProperty("webdriver.ie.driver",rc.getiePath());
		
		driver= new InternetExplorerDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(BaseURL);
	
	
	
	}
	

	@AfterClass
	//@AfterTest
	public void tearDownS() {
		
		
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots1/" + tname + dateName + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
}
	
	
}
	
