package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class Activity1 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/crm/");
        //to read the title of the website and verify the text
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        String pageTitle=driver.getTitle();
        Assert.assertEquals("SuiteCRM", pageTitle);
        driver.close();
    }
}
