package liveprojects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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

public class GoogleTask {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setCapability("deviceId", "dieye6gijraubycu");
        ds.setCapability("platformName", "android");
        ds.setCapability("automationName", "UiAutomator2");
        ds.setCapability("appPackage", "com.google.android.apps.tasks");
        ds.setCapability("appActivity", ".ui.TaskListsActivity");
        ds.setCapability("noRest", "true");

        URL ServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(ServerURL, ds);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void createlistsonGoogleTasks() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")));
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_list")));
        driver.findElement(MobileBy.id("tasks_list")).click();
        driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(MobileBy.id("add-task-done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")));
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_list")));
        driver.findElement(MobileBy.id("tasks_list")).click();
        driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(MobileBy.id("add-task-done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")));
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_list")));
        driver.findElement(MobileBy.id("tasks_list")).click();
        driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(MobileBy.id("add-task-done")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));
        List<MobileElement> tasks= driver.findElementsById("task_name");

        String result1= tasks.get(0).getText();
        System.out.println(result1);
        Assert.assertEquals(result1, "Complete Activity with Google Tasks");

        String result2= tasks.get(1).getText();
        System.out.println(result2);
        Assert.assertEquals(result2, "Complete Activity with Google Tasks");

        String result3= tasks.get(2).getText();
        System.out.println(result3);
        Assert.assertEquals(result3, "Complete Activity with Google Tasks");


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
