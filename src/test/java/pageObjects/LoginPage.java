package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement loginBtn;
	

	public void setEmail(String eMail) {
		email.sendKeys(eMail);
	}
	
	public void setPass(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	
	

}
