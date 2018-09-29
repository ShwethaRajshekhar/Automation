package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
			
	private WebDriver driver;
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN ;

			
			//initialization
			public LoginPage(WebDriver driver) //use parameterized constructor
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
				
	}
			
			//utilization
			public void setUserName(String un)
			{
				unTB.sendKeys(un);
			}
			public void setPassword(String pw)
			{
				pwTB.sendKeys(pw);
			}

			public void clickLogin()
			{
				loginBTN.click();
			}


}
