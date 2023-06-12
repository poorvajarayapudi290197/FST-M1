package Activities;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

    public class appiumproject {
        // Driver Declaration
        AndroidDriver driver;
        WebDriverWait wait;
        String tasklist;

        // Set up method
        @BeforeClass
        public void setUp() throws MalformedURLException, InterruptedException {
            // Desired Capabilities
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.android.chrome");
            options.setAppActivity("com.google.android.apps.chrome.Main");
            options.noReset();

            // Server Address
            URL serverURL = new URL("http://localhost:4723/wd/hub");

            // Driver Initialization
            driver = new AndroidDriver(serverURL, options);

            // Open the page in Chrome

        }

        // Test method
        @Test
        public void chromeTest() throws InterruptedException {
            driver.get("https://www.training-support.net/selenium");
            Thread.sleep(10000);
            String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
            driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
            driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List\")"));
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            driver.findElement(AppiumBy.accessibilityId("To-Do List \uF0AE Elements get added at run time")).click();
            Thread.sleep(10000);
            String todolist=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).getText();
            System.out.println(todolist);
            Assert.assertEquals("To-Do List",todolist);
            Thread.sleep(10000);
            driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("creating task1");
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
            driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("creating task2");
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
            driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("creating task3");
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
            Thread.sleep(5000);
            //finding the no of tasks

            WebElement resource=driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id,tasksList]"));
            List<WebElement> tasks=resource.findElements(AppiumBy.className("android.widget.TextView"));
            System.out.println(tasks.size());
            for(int i=1;i<tasks.size();i++){
                System.out.println("Printing tasks"+tasks.get(i).getText());
                tasklist= tasks.get(i).getText();


            }
            Assert.assertEquals(6,tasks.size());
            Thread.sleep(10000);

            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='creating task1']")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='creating task2']")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='creating task3']")).click();

            Thread.sleep(3000);
            driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView[2]")).click();
            List<WebElement> tasks1=resource.findElements(AppiumBy.className("android.widget.TextView"));
            System.out.println(tasks1.size());
            Assert.assertEquals(2,tasks1.size());
        }
    }

