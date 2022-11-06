package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test
    public void loginTest() {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));
        
        //Enter credentials
        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");
        
        //Click login
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
       
        String Navigationbar = driver.findElement(By.className("desktop-toolbar")).getCssValue("color");
        System.out.println("Back ground color of Navigation bar is: " + Navigationbar);
        
       String NavigationMenuColour = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]")).getCssValue("color");
        System.out.println("Navigation Menu Colour is: " + NavigationMenuColour);
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}