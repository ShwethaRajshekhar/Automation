package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst {
	public WebDriver driver; //parallel not possible if we make it static,run on one browser at a time
	//works on one specific one browser if its made final
	//url changes so never make it static and final
	public String url=Utility.getPropertyValue(CONFIG_PATH, "URL");
	String ITO=Utility.getPropertyValue(CONFIG_PATH, "ITO"); //Go to config.properties and 
	//gets the value thru key ITO
	public long duration=Long.parseLong(ITO); //String converted to long
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@Parameters({"ip","browser"}) //send parameters thru XML if not take Optional values
	@BeforeMethod()
	public void openApplication(@Optional("localhost")String ip, @Optional("chrome")String browser)
	{
	    //driver=new ChromeDriver(); //local variable if WebDriver is used
		//driver=Utility.openBrowser(driver, "localhost", "chrome"); //value hardcoded
		driver=Utility.openBrowser(driver, ip, browser); //use @parameters and driver=null here?
		//method returns address of browser
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS); 
		driver.get(url); //gets url from ./config.properties
	}
	
	@AfterMethod
	public void closeApplication(ITestResult result ) //declare var of ITestResult interface
	{
		//Utility.getPhoto(driver, PHOTO_PATH); takes photo for all the test method
		String name=result.getName(); //subclass overridden method -getName(). returns name of test method
		int status=result.getStatus(); //returns status as 1pass or 2Fail or 3Skip
		if(status==2) //takes screenshot for failed test methods only
		{
			String path=Utility.getPhoto(driver, PHOTO_PATH);
			Reporter.log("Test:" +name+ " is Failed and photo is:" +path, true);
		}
		else {
			Reporter.log("Test:" +name+"is PASSED", true);
		}
		driver.quit(); 
		
	}
}
