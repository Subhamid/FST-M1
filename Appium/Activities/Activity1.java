package activities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities ds=new DesiredCapabilities();
        ds.setCapability("deviceId","dieye6gijraubycu" );
        ds.setCapability("platformName", "android");
        ds.setCapability("automationName", "UiAutomator2");
        ds.setCapability("appPackage", "com.android.calculator2");
        ds.setCapability("appActivity", ".Calculator");
        ds.setCapability("noRest", "true");

        URL ServerURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<>(ServerURL,ds);
        wait=new WebDriverWait(driver, 20);
    }

    @Test
    public void add() {

        driver.findElementById("digit_5").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();
        driver.findElementById("eq").click();
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "45");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
