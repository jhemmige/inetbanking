package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
public ReadConfig()  {
		
	File src = //This takes file path
	new File
	("/Users/jayashreehemmige/eclipse-workspace/MavenSelYoutubeBankingProject/Configurations/config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);// takes file source as input
		prop = new Properties();
		prop.load(fis);  //This takes file input stream object as input
	} catch (Exception e) {
		
		System.out.println("exception is :"+ e.getMessage());
	}
	
	
}

public String SettingURL() {
	
	String URL=	prop.getProperty("BaseURL");
		
		return URL;
		
}

public String getUsername() {
	
	
String UserName= prop.getProperty("UID");
	
return UserName;
}

public String getPassword() {
	
	String Password= prop.getProperty("PWD");
	
	return Password;
	
}

public String getChromePath() {
	
	String driverpath= prop.getProperty("ChromePath");
	
	return driverpath;
}

public String getfirefoxPath() {
	
	String driverpath= prop.getProperty("firefoxpath");
	
	return driverpath;


}

public String getiePath() {
	
	String driverpath= prop.getProperty("ie");
	
	return driverpath;


}


}


