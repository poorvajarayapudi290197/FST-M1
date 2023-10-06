package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity3 {
    public static void main(String args[]){
    // Set up Firefox driver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();

    // Open the page
        driver.get("https://alchemy.hguy.co/crm/");
    //to print the first copyright text in the footer to the console
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.findElement(By.id("admin_options")).getText());
        driver.close();
}

}
