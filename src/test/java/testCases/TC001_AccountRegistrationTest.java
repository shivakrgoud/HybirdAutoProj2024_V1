package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() 
	{
		
		logger.info("***Starting TC001_AccountRegistration****");
		
		try {
		HomePage hp=new HomePage(driver);
		AccountRegisterationPage ar=new AccountRegisterationPage(driver);
		
		logger.info("Clicked Rigister Link");
		hp.clickRigister();
		
		logger.info("Providing customer details...");
		ar.setFirstName("raj"+randomString().toUpperCase());
		ar.setLastName("raj");
		ar.setAddress("1 street");
		ar.setCity("bangalore");
		ar.setState("karnataka");
		ar.setZipCode("560021");
		ar.setPhone(randomNumber(10));
		ar.setSSN("68686");
		ar.setUserName("ramkrg"+randomNumber(2));
		String password=randomAlfaNumberic();
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		ar.clickRegisterbtn();
		logger.info("Validate expected result...");
		String confmsg=ar.getconfirmationmsg();
		Assert.assertEquals(confmsg, "Your account was created successfully. You are now logged in.");
		}catch(Exception e)
		{
			logger.error("test Failed...");
			logger.debug("debug log..");
			Assert.fail();
		}
		logger.info("****  Finished TC001_AccountRigistration ****");
	}
}
