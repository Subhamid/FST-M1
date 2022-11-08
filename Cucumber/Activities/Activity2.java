package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

        @BeforeClass
        public void setUp() throws MalformedURLException {
            DesiredCapabilities ds=new DesiredCapabilities();
            ds.setCapability("deviceId","dieye6gijraubycu" );
            ds.setCapability("platformName", "android");
            ds.setCapability("automationName", "UiAutomator2");
            ds.setCapability("appPackage", "com.android.chrome");
            ds.setCapability("appActivity", "com.google.android.apps.chrome.Main");
            ds.setCapability("noRest", "true");

            URL ServerURL=new URL("http://localhost:4723/wd/hub");
            driver=new AndroidDriver<>(ServerURL,ds);
            wait=new WebDriverWait(driver, 20);
        }

    @Test
    public void testSearchAppium() {
        driver.get("https://www.training-support.net/");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("About Us")));
        String pageTitle = driver
                .findElementByXPath("//android.widget.TextView[@text='Training Support']")
                .getText();
        System.out.println("Title on Homepage: " + pageTitle);
        MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
        aboutButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.xpath("//android.widget.TextView[@text='About Us']")
        ));
        String newPageTitle = driver
                .findElementByXPath("//android.widget.TextView[@text='About Us']")
                .getText();
        System.out.println("Title on new page: " + newPageTitle);
        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
