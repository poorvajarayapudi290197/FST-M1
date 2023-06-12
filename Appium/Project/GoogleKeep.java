package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GoogleKeep {
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
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
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
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        Thread.sleep(10000);
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("APPIUM PROJECT");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("creating note");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        String title=driver.findElement(AppiumBy.id("index_note_title")).getText();
        Assert.assertEquals(title, "APPIUM PROJECT");
    }


}