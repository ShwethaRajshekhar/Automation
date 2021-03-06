package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//all static methods
public class Utility {
	public static String getPropertyValue(String path, String Key) //path of config.properties
	{
		String v="";
		try {
			Properties p=new Properties(); //create object of Properties class
			p.load(new FileInputStream(path)); //loads config.properties file using path
			v=p.getProperty(Key); //gets the value by key(url)
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	public static void writeResultToXL(String path,String sheet, int pass, int fail)
	{
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			w.getSheet(sheet).getRow(1).getCell(0).setCellValue(pass);
			w.getSheet(sheet).getRow(1).getCell(1).setCellValue(fail);
			w.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static String getXLData(String path,String sheet, int r , int c)
	{
		String v="";
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(sheet).getRow(r).getCell(c).toString();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	
	public static int getXLRowCount(String path, String sheet)
	{
		int count=0;
		try
		{
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			count=w.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public static String getPhoto(WebDriver driver, String folder)
	{
		Date d=new Date();
		String dateTime=d.toString().replaceAll(":", "_");
		String path=folder+"/"+dateTime+".png"; //./photo/thu Sep 27 12_10_33 IST 2018.png 
		try {
			TakesScreenshot t =(TakesScreenshot)driver; //type casting to takesScreenshot interface
			File srcFile=t.getScreenshotAs(OutputType.FILE); //takes screenshot 
			File destFile=new File(path); // Creates new file in the path
			FileUtils.copyFile(srcFile, destFile); //copy the screenshot to destination 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return path;
	}
	
	public static WebDriver openBrowser(WebDriver driver, String ip, String browser) //Grid
	{
		if(ip.equals("localhost"))
		{
			if(browser.equals("chrome"))
			{
				driver=new ChromeDriver(); //set the address of chrome browser to driver
			}
			else {
				driver=new FirefoxDriver(); //set the address of firefox browser to driver
			}
		}
		
		else
		{
			try 
			{
				URL u=new URL("http://" +ip+":4444/wd/hub");
				DesiredCapabilities d=new DesiredCapabilities();
				d.setBrowserName(browser);
				driver=new RemoteWebDriver(u,d);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return driver;
	}
	
	
	
	

}
