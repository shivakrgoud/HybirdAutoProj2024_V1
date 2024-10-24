package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import pageObjects.OverviewPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("*** Starting TC002_LoginTest *****");
		SoftAssert softAssert = new SoftAssert();
		
		try {
			HomePage hp=new HomePage(driver);
			hp.setUsername(p.getProperty("username"));
			hp.setpassword(p.getProperty("password"));
			hp.clicklogin();
//			MyaccountPage
			OverviewPage op=new OverviewPage(driver);
//			String accountoverr=op.validateAccountOverView();
			
//			softAssert.assertEquals(accountoverr, "Accounts Overvie","this assertion fail");
			boolean targetpage=op.isAccountOverViewExists();
			
			Assert.assertEquals(targetpage, true,"login Passed");
			
		}catch(Exception e) 
		{logger.debug("Login failed");}
	}

}
