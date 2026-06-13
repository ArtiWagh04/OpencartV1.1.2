package hands_on;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouseActions {
	
	public static void main(String[] args) {
ChromeOptions options =  new ChromeOptions();

		
		options.addArguments("--disable-notifications");
    	
  	  WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://demoqa.com/select-menu");
        
        driver.manage().window().maximize();
        
        Actions action = new Actions(driver);
        
        WebElement element = driver.findElement(By.xpath("(//div[@class=\"header-text\"])[6]"));
        
        System.out.println(element.isDisplayed());
        System.out.println(element.isEnabled());
        
      //  action.scrollToElement(element).build().perform(); this giving excpetion that ------ ElementClickInterceptedException
      //  Other element would receive the click: <footer>...</footer>
        
         action.moveToElement(element).build().perform(); //-- this too giving same exception so 
        // used JS executor to bring element to center of the screen
        
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        
//        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
//        
        element.click();
        
        System.out.println("SUCCESS!!!!!!!!!");
        
	}

}
