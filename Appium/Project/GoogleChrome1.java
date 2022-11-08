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
import java.util.List;

public class GoogleChrome1 {

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


    }

    @Test
    public void test()
    {
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.view.View")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("tasksCard")));
        String Taskstoadd [] =
                {"Task1","Task2","Task3"
                };

        for(String Tasktoadd : Taskstoadd)
        {
            driver.findElement(MobileBy.id("taskInput")).sendKeys(Tasktoadd);
            driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[1][contains(@text,'Add Task')]")).click();

        }
        List<MobileElement> tasklist = driver.findElementsById("tasksList");
        for(MobileElement element: tasklist)
        {
            System.out.println("The No of Tasks are:"+ element.getSize());
            driver.findElement(MobileBy.id("tasksList")).click();
        }
        driver.findElement(MobileBy.className("android.widget.TextView"));
        List<MobileElement> tasklist1 = driver.findElements(MobileBy.id("tasksList"));
        Assert.assertEquals("TC Passed!",0, String.valueOf(tasklist1.size()));
        Assert.assertEquals("TC Failed!",1, String.valueOf(tasklist1.size()));



    }
    @AfterClass
    public void afterclass()
    {
        driver.quit();
    }
}
