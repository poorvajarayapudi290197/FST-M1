package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity5 {
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
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Names");
        Thread.sleep(2000);
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Adidas");
        Thread.sleep(2000);
        driver.findElement(By.id("personal_optGender_1")).click();
        Thread.sleep(2000);
        Select gender=new Select(driver.findElement(By.id("personal_cmbNation")));
        gender.selectByVisibleText("Hungarian");
        Thread.sleep(2000);
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(2000);
        driver.close();


    }
}
