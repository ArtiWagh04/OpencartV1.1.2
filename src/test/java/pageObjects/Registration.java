package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration extends BasePage{

	public Registration(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


@FindBy(xpath="//input[@id='input-firstname']") WebElement fName;
@FindBy(xpath="//input[@id='input-lastname']") WebElement lName;
@FindBy(xpath="//input[@id='input-email']") WebElement email;
@FindBy(xpath="//input[@id='input-password']") WebElement pass;
@FindBy(xpath="//button[normalize-space()='Continue']") WebElement btnContinue;
	
@FindBy(xpath="//input[@name='agree']") WebElement Agree;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMSG;

public void setfname(String fname) {
	fName.sendKeys(fname);
}

public void setlname(String lname) {
	lName.sendKeys(lname);
}

public void setemail(String emailID) {
	email.sendKeys(emailID);

}

public void setPass(String password) {
	pass.sendKeys(password);
}

public void agreeToggle() {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // wait until checkbox is present
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("agree")));

    // scroll to checkbox
    js.executeScript("arguments[0].scrollIntoView({block:'center'});", Agree);

    // click using JS (bypass overlay)
    js.executeScript("arguments[0].checked = true;", Agree);
    js.executeScript("arguments[0].dispatchEvent(new Event('change'));", Agree);
}


public void Continuebtn() {
	btnContinue.click();
}

public String getMSG() {
	try {
		return (confirmMSG.getText());
	}
	catch(Exception e){
		return (e.getMessage());
	}
}

}
