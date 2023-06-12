package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class GoogleTask {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;
    String taskname;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    // Test method
    @Test
    public void Task1() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(10000);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        String taskname = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Tasks']")).getText();

        Assert.assertEquals(taskname, "Google Tasks");


    }
    @Test
    public void Task2() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(10000);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        String taskname = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")).getText();

        Assert.assertEquals(taskname, "Google Keep");


    }
    @Test
    public void Task3() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(10000);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        String taskname = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")).getText();

        Assert.assertEquals(taskname, "second Activity Google Keep");


    }




}
