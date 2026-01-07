package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Registration;

public class TC_AccountRegistration extends BaseClass{

	
	@Test(groups="sanity")
	public void verify_account_registration() {
		
		try {
		HomePage hp = new HomePage(driver );
		hp.clickMyAccount();
		
		logger.info("***clicked my account***");
		
		hp.clickRegister();
		
		logger.info("***clicked register***");

		
		Registration obj = new Registration(driver);
		obj.setfname(randomString());
		obj.setlname(randomString());
		obj.setemail(randomString()+"@gmail.com");
		obj.setPass("Admin@123");
		obj.agreeToggle();
		obj.Continuebtn();
		
		logger.info("***clicked continue***");

		
		String str = obj.getMSG();
		Assert.assertEquals("Your Account Has Been Created!", str);
		
		
		}
		catch(Exception s) {
			logger.error("Test Failed");
			logger.debug("Debug logs******");
			Assert.fail();
		}
		
		logger.info("***TC_AccountRegistration finished***");
		
	}
	
	
}
