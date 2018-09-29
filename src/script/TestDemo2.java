package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.LoginPage;

public class TestDemo2 extends BaseTest {

	@Test
	public void testB() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("admin");
		Thread.sleep(5000);
		lp.setPassword("manager");
		lp.clickLogin();

		Reporter.log("testB.. executed",true);
	}
}
