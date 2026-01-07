package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_loginTest extends BaseClass{
	
	

	@Test(groups="regression")
	public void verifyLogin() {
		
		logger.info("home page launched***");
		
		try {
		
		HomePage hp = new HomePage(driver);
		
		//home page
		hp.clickMyAccount();
		logger.info("my account clicked***");

		
		hp.clickLogin();
		
		logger.info("login page launched***");

		
		//login page
		LoginPage login = new LoginPage(driver);
		
		login.setEmail(p.getProperty("email"));
		login.setPass(p.getProperty("password"));
		login.clickLogin();
		
		
		//my account page
		MyAccountPage obj = new MyAccountPage(driver);		
		
		String str = obj.confirmLogin();
		
		Assert.assertEquals("My Account", str);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("login successfull***");

		
	}
	
}
