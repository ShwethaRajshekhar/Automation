package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst {
	public WebDriver driver; //parallel not possible if we make it static,run on one browser at a time
	//works on one specific one browser if its made final
	//url changes so never make it static and final
	public String url=Utility.getPropertyValue(CONFIG_PATH, "URL");
	String ITO=Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration=Long.parseLong(ITO);
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	 @BeforeMethod
	public void openApplication()
	{
	    driver=new ChromeDriver(); //local variable if WebDriver
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@AfterMethod
	public void closeApplication()
	{
		driver.close(); 
	}
}
