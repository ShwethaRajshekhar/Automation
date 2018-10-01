package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.HomePage;
import page.LoginPage;

public class TestLoginLogout extends BaseTest {

	@Test(priority=1, groups= {"login", "smoke"})
	public void testB() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("admin");
		Thread.sleep(5000);
		lp.setPassword("manager");
		HomePage hp = lp.clickLogin();
		hp.clickLogout();
		

		Reporter.log("testB.. executed",true);
	}
}
