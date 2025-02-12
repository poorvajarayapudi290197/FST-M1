package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
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
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
        Thread.sleep(2000);
        WebElement actualTitle=driver.findElement(By.xpath("//h1[text()='Search Directory']"));
        System.out.println(actualTitle);

        String ExpectedTitle="Search Directory";
        if(actualTitle.equals(ExpectedTitle)){
            System.out.println("Title Matched");
        }
        else {
            System.out.println("Title not matched");
        }
        driver.close();

    }
}