package hands_on;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithCaptcha {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://panvelmc.in/login");

        driver.manage().window().maximize();

        driver.findElement(By.id("txtUserName"))
                .sendKeys("sahil.s");

        driver.findElement(By.id("txtPassword"))
                .sendKeys("0211");

        // Manual CAPTCHA step
        System.out.println("Enter CAPTCHA manually and press ENTER here...");

        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // waits until you press Enter

        // Find login button again after CAPTCHA
        driver.findElement(By.id("//button[@id=\"btnLogin\"]")).click();

        System.out.println("Login successful");
        driver.quit();
        
    	
    	
         
          
          
          
          
          
          

    	
    }
}