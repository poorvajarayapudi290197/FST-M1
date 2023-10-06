package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Activity7 {
    public static void main(String args[]) throws InterruptedException {
        // Set up Firefox driver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/crm/");
        //to login
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        //to read a popup that contains additional information about the account/lead
        WebElement e=driver.findElement(By.xpath("//a[text()='Sales']"));
        WebElement f=driver.findElement(By.id("moduleTab_9_Leads"));

       Actions action = new Actions(driver);
        action.moveToElement(e).moveToElement(f).click().perform();
        String infoIcon="//tbody/tr[@class='oddListRowS1']//td[@align='right']";

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(infoIcon)));
        driver.findElement(By.xpath(infoIcon)).click();

        WebElement ph=driver.findElement(By.xpath("//span[@class='phone']"));
        System.out.println(ph.getText());
        driver.close();


    }

}
