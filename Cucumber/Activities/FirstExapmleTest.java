package examples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstExapmleTest {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities ds=new DesiredCapabilities();
        ds.setCapability("deviceId","dieye6gijraubycu" );
        ds.setCapability("platformName", "android");
        ds.setCapability("automationName", "UiAutomator2");
        ds.setCapability("appPackage", "com.miui.calculator");
        ds.setCapability("appActivity", "cal.CalculatorActivity");
        ds.setCapability("noRest", "true");

        URL ServerURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<>(ServerURL,ds);
    }

    @Test
    public void additionTest(){
        driver.findElement(By.id("btn_3_s"));
        driver.findElementByAccessibilityId("plus").click();
        driver.findElement(By.id("btn_6_s"));
        driver.findElementByAccessibilityId("equals").click();

        String actualresult="9";
        String expectedResult=driver.findElement(By.xpath("result")).getText();
        System.out.println("result is: " + expectedResult);

        Assert.assertEquals(actualresult,expectedResult);

    }

    @AfterClass
    public void tearDown(){

    }

}
