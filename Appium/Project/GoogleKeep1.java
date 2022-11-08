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

public class GoogleKeep1 {
        AndroidDriver<MobileElement> driver;
        WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceId", "dieye6gijraubycu");
        ds.setCapability("platformName", "android");
        ds.setCapability("automationName", "UiAutomator2");
        ds.setCapability("appPackage", "com.google.android.keep");
        ds.setCapability("appActivity", ".activities.BrowseActivity");
        ds.setCapability("noReset", "true");

        URL ServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(ServerURL, ds);
        wait = new WebDriverWait(driver, 20);

        }

        @Test
        public void googleKeepAddNote() {

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
            driver.findElement(MobileBy.id("new_note_button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("title_editor_fragment")));
            driver.findElement(MobileBy.id("editable_title")).sendKeys("TodayMenu");
            driver.findElement(MobileBy.id("edit_note_text")).sendKeys("Poha,Rice,Roti");
            driver.findElement(MobileBy.id("Open navigation drawer")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.keep:id/drawer_layout")));
            driver.findElement(MobileBy.id("open_search_bar_text_view")).sendKeys("TodayMenu");
            MobileElement newtask = driver.findElement(MobileBy.id("browse_text_note"));
            Assert.assertEquals(newtask.isDisplayed(), true);

        }

        @AfterClass
        public void afterclass() {
            driver.quit();
        }
    }

