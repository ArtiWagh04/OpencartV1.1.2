package hands_on;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowFramesAndWindowPopups {
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(options);
		

        driver.navigate().to("https://demoqa.com/select-menu");
        
        driver.manage().window().maximize();
        
        String parent = driver.getWindowHandle();
        
        
        
        driver.findElement(By.xpath("(//div[@class=\"header-text\"])[3]")).click();
        
        /*
        
        driver.findElement(By.xpath("//span[text()=\"Browser Windows\"]")).click();
        
        driver.findElement(By.xpath("//button[@id=\"tabButton\"]")).click();
        
        driver.findElement(By.xpath("//button[@id=\"windowButton\"]")).click();

        driver.findElement(By.xpath("//button[@id=\"messageWindowButton\"]")).click();
        
      
        
        Set<String> windowHandles = driver.getWindowHandles();
        
        for(String win: windowHandles) {
        	if(!win.equals(parent)) {
        		driver.switchTo().window(win);
        		 //System.out.println(driver.getTitle()); 
        		 System.out.println(driver.getCurrentUrl());
        		driver.close();
        		
        	}
        }
        
       
        
        driver.switchTo().window(parent);
        */
        
        driver.findElement(By.xpath("(//li[@class=\"btn btn-light \" and @id=\"item-2\"])[2]")).click();
        
        
        
        WebElement frame1 = driver.findElement(By.id("frame1"));        
        driver.switchTo().frame(frame1);
        
        
        
        System.out.println("frame1");
        
        driver.switchTo().defaultContent();
        
        WebElement frame2 = driver.findElement(By.id("frame2"));        

        
        driver.switchTo().frame(frame2);
        
        System.out.println("frame2");
        
        
		
		
	}

}
