package Examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class screenshot {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setup() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public class screenshotexample {
        public void takeScreenshot() throws IOException {
            // Take screenshot
            File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // This specifies the location the screenshot will be saved
            File screenShotName = new File("src/test/resources/screenshot.jpg");

            // This will copy the screenshot to the file created
            FileUtils.copyFile(scrShot, screenShotName);

            // Set filepath for image
            String filePath = "../" + screenShotName;

            // Set image HTML in the report
            String path = "<img src='" + filePath + "'/>";

            // Show image in report
            Reporter.log(path);
        }

    }
}
