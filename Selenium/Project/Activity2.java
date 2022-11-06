package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    
    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
            
        //Open the browser
        driver.get("http://alchemy.hguy.co/crm");
    }
    
    @Test
    public void testCase1() {
    	 String url = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[1]/img")).getAttribute("src");
       System.out.println("Url of the header Image: " + url);
    }
    
   @AfterTest
   public void afterMethod() {
        //Close the browser
       driver.close();
    }

}
