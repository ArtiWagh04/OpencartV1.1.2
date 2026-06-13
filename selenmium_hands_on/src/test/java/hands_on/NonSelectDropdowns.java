package hands_on;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NonSelectDropdowns{
	public static void main(String[] args) {
		
				
ChromeOptions options =  new ChromeOptions();
    	
    	//options.addArguments("--headless");
    	//options.addArguments("--incognito");
    	options.addArguments("--disable-notifications");
    	
    	  WebDriver driver = new ChromeDriver(options);

          driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
          
          driver.manage().window().maximize();
          
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          
          
          
          WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));
          
          element.sendKeys("Admin");
          
          driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
          
          driver.findElement(By.xpath("//button")).click();
          
         // driver.findElement(By.)
          
          WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i)[4]")));
          
          element2.click();
          
        //  driver.findElement(By.xpath("(//i)[4]")).click();
          
          driver.findElement(By.xpath("//a[text()=\"About\"]")).click();
          
          driver.findElement(By.xpath("//button[@class=\"oxd-dialog-close-button oxd-dialog-close-button-position\"]")).click();
          
         // driver.findElement(By.xpath("(//a)[2])")).click();
          
          //driver.findElement(By.xpath("(//i)[12])")).click();
          System.out.println("SUCCESS!!!!");
          
          driver.quit();
          
          
	}

}
