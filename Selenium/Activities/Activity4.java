package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {


        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Thread.sleep(2000);
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        Thread.sleep(2000);
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        Thread.sleep(2000);
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("btnAdd")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).sendKeys("firstName");
        driver.findElement(By.id("lastName")).sendKeys("lastName");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='save']")).click();


    }
}
