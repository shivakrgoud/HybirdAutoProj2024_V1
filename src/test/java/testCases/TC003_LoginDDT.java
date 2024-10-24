package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.OverviewPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
				   login failed - test fail

Data is invalid - login success - test fail  - logout
				  login failed - test pass
*/

public class TC003_LoginDDT extends BaseClass {
	

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven") // getting data provider from different class
	public void verify_loginDDT(String un, String pwd, String exp)
	{
		logger.info("*** Starting TC003_LoginDDTTest *****");
	
		
		try {
			HomePage hp=new HomePage(driver);
			hp.setUsername(un);
			hp.setpassword(pwd);
			hp.clicklogin();
//			MyaccountPage
			OverviewPage op=new OverviewPage(driver);

			boolean targetPage=op.isAccountOverViewExists();
			
			Assert.assertEquals(targetPage, true,"login Passed");
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{			
					op.click_Logout();
					Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					op.click_Logout();
					Assert.assertTrue(false);
					
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
			}catch(Exception e)
			{
				Assert.fail();
			}
		
			logger.info("***** Finished TC_003_LoginDDT ******");
			
		}
		
	}
