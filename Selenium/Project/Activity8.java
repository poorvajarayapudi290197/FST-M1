package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
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

        //to open the accounts page and print the contents of the table.
        WebElement e=driver.findElement(By.xpath("//a[text()='Sales']"));
        WebElement f=driver.findElement(By.id("moduleTab_9_Accounts"));

        Actions action = new Actions(driver);
        action.moveToElement(e).moveToElement(f).click().perform();

         /* to wait until the table load*/
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[@class='oddListRowS1']//td[@align='right']")));

        for( int i=1;i<=5;i++)
            System.out.println(driver.findElement(By.xpath("//tbody/tr[@class='oddListRowS1'][" + i + "]/td[3]")).getText());

        driver.close();


    }

}
