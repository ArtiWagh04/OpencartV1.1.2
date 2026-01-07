package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups={"master, regression"})
	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("TC_LoginDT started***");

	
		HomePage hp = new HomePage(driver);
		
		//home page
		hp.clickMyAccount();
		logger.info("my account clicked***");
		
		hp.clickLogin();
		
		logger.info("login page launched***");

		
		//login page
		LoginPage login = new LoginPage(driver);
		
		login.setEmail(email);
		login.setPass(pwd);
		login.clickLogin();
		
		
		//my account page
		MyAccountPage obj = new MyAccountPage(driver);		
		boolean targetPage = obj.isMyAccountPageExists();



		
		if(exp.equalsIgnoreCase("valid")) {
			
				logger.info("TC_LoginDT with valid data finished***");

				Assert.assertTrue(true);
				obj.clkLogout();
				logger.info("Logout successfull");
			}

		
		if(exp.equalsIgnoreCase("invalid")) {
			
				Assert.assertTrue(false);
				
			}
			
		
		
		
		logger.info("TC_LoginDT finished***");

		
	}
	
}
