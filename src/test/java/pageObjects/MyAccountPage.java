package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[normalize-space()='My Account']") WebElement confirmMSG;
	



	@FindBy(xpath="By.xpath(\"//a[@class='dropdown-item'][normalize-space()='Logout']") WebElement logout;
	
	public boolean isMyAccountPageExists() {
	    try {
	        return confirmMSG.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public String confirmLogin() {
	    return confirmMSG.getText();
	}

	
	public void clkLogout() {
	    logout.click();
	}

}
