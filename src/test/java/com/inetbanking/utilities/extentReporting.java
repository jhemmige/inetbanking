package com.inetbanking.utilities;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.testCases.BaseClass;

public class extentReporting extends TestListenerAdapter
{
	
	BaseClass bc= new BaseClass();
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public WebDriver driver;
	
	
		
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//Specify where the report should be created.
		htmlReporter.config().setDocumentTitle("Youtube SDET Hybrid Automation InetBanking Test Project"); // Tile of report
		htmlReporter.config().setReportName("Jayashree's_Functional Test Automation Report"); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
	
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Jayashree Hemmige");
		extent.setSystemInfo ( "Operating System", "Mac OS");
		
		
		
		//System.out.println("this is for browser test"+ Browser);
		
		
		
	}
	
	public void onTestSuccess(ITestResult testCase)
	{
		logger=extent.createTest(testCase.getName()); // create new entry in th report
		
	System.out.println("this is name of testcase"+ testCase.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(testCase.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	
		
	System.out.println("Yay, my test passed from extent Reports");
	
	}
	
	public void onTestFailure(ITestResult testCase)
	{
		logger=extent.createTest(testCase.getName()); // create new entry in th report
		
		
		logger.log(Status.FAIL,MarkupHelper.createLabel(testCase.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		logger.log(Status.FAIL, "TEST CASE FAILED DUE TO " + testCase.getThrowable());
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots1\\"+testCase.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		}
		
	}
		
	
	
	public void onTestSkipped(ITestResult testCase)
	{
		logger=extent.createTest(testCase.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(testCase.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

	
}
