package liveprojects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleChrome3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceId", "dieye6gijraubycu");
        ds.setCapability("platformName", "android");
        ds.setCapability("automationName", "UiAutomator2");
        ds.setCapability("appPackage", "com.android.chrome");
        ds.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        ds.setCapability("noReset", true);



        URL ServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(ServerURL, ds);
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Popups\"))")).click();
    }

    @Test(priority= 0)
    public void validcredentailstest()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.view.View")));
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button[contains(@text,'Sign In')]")).click();
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[2]")).sendKeys("password");
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button[contains(@text,'Log in')]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated((MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[4][contains(@text,'Welcome Back, admin')]")), "Welcome Back, admin"));
        String msg=driver.findElement(MobileBy.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", msg);


    }


    @Test (priority= 1)
    public void invalidcredentailstest()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.view.View")));
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button")).click();
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[1]")).sendKeys("admin123");
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[2]")).sendKeys("password123");
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button[contains(@text,'Log in')]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated((MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[4][contains(@text,'Invalid Credentials')]")), "Invalid Credentials"));
        String msg=driver.findElement(MobileBy.id("action-confirmation")).getText();
        Assert.assertEquals("Invalid Credentials", msg);


    }



    @AfterClass
    public void afterclass()
    {
        driver.quit();
    }
}

