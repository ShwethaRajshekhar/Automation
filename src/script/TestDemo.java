package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class TestDemo extends BaseTest
{
	
	@Test
	public void testA()
	{
		Reporter.log("test...",true);
	}

}
