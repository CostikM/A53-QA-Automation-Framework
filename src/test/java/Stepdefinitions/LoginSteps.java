package Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I open browser")
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @After
    public  void closeBrowser(){
        driver.quit();
    }

    @And("I open Login Page")
    public void openLogin() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @When("I submit")
    public void clickSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }
    @Then("I am Logged in")
    public void loggedIn(){
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }
}
