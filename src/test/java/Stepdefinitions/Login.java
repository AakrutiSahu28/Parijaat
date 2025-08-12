package Stepdefinitions;

import Factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Login {

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        WebDriver driver = Driverfactory.getDriver();
        driver.get("https://cp-app.test.salesbeecloud.com/login");
    }

    @When("User enters valid CP id {string}")
    public void user_enters_valid_cp_id(String cpId) {
        WebDriver driver = Driverfactory.getDriver();
        WebElement cpIdField = driver.findElement(By.id("mat-input-0"));
        cpIdField.sendKeys(cpId);
    }

    @When("User clicks the Submit button")
    public void user_clicks_the_submit_button() {
        WebDriver driver = Driverfactory.getDriver(); // ✅ Fetch the driver instance first

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-button-wrapper']"))
        );

        submitButton.click();
    }


    @Then("login successful")
    public void login_successful() {
        WebDriver driver = Driverfactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait until the dashboard icon (chevron_right) is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//mat-icon[normalize-space()='chevron_right']")
        ));

        System.out.println("Login was successful, Dashboard icon is visible.");


    }

}
