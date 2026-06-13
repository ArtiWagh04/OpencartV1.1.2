package hands_on;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdowns {
	
	public static void main(String[] args) {
		
		ChromeOptions options =  new ChromeOptions();

		
		options.addArguments("--disable-notifications");
    	
  	  WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://demoqa.com/select-menu");
        
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("(//div[@class=\"css-19bb58m\"])[1]")).click();
        
        driver.findElement(By.xpath(" //div[text()=\"Another root option\"]")).click();
        
        WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"oldSelectMenu\"]"));
//
//        driver.findElement(By.xpath("//option[text()=\"Aqua\"]")).click();
        
        Select select = new Select(dropdown);
        
        select.selectByVisibleText("Aqua");
        
        driver.findElement(By.xpath("(//div[@class=\"css-19bb58m\"])[3]")).click();
      
        driver.findElement(By.xpath("//div[text()='Blue']")).click();
        driver.findElement(By.xpath("//div[text()='Red']")).click();
        
        System.out.println("SUCCESS!!!!!!!!!!!");
        
        driver.quit();
		
	}

}
