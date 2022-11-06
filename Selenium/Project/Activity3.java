package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
	
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
	    	 String txt = driver.findElement(By.xpath("//*[@id=\"admin_options\"]")).getText();
	       System.out.println("The first copyright text in the footer: " + txt);
	    }
	    
	   @AfterTest
	   public void afterMethod() {
	        //Close the browser
	       driver.close();
	    }

	}

