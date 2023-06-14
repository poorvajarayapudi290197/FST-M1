package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Login page$")
    public void user_is_on_google(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver() ;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @When("^User enters username and password$")
    public void user_enters_details(){

        //Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_details(String username,String password){

        //Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("^Read the page title and confirmation message$")
    public void read_page_title(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);

    }
    @And("^Close browser$")
    public void close() throws Throwable {
        driver.close();
    }
}