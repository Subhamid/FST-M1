package activities;

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

public class Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities ds=new DesiredCapabilities();
        ds.setCapability("deviceId","dieye6gijraubycu" );
        ds.setCapability("platformName", "android");
        ds.setCapability("automationName", "UiAutomator2");
        ds.setCapability("appPackage", "com.android.contacts");
        ds.setCapability("appActivity", ".activities.PeopleActivity");
        ds.setCapability("noReset", true);

        URL ServerURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<>(ServerURL,ds);
        wait=new WebDriverWait(driver, 5);
    }

    @Test
    public void addContact() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new contact")));
        driver.findElementByAccessibilityId("Create new contact").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));
        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
        firstName.sendKeys("Prerana");
        lastName.sendKeys("Bohidar");
        phoneNumber.sendKeys("9599956982");
        driver.findElementById("editor_menu_save_button").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());
        String contactName = driver.findElementById("large_title").getText();
        Assert.assertEquals(contactName, "Prerana Bohidar");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
