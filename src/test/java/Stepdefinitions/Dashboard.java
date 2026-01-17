package Stepdefinitions;

import Factory.Driverfactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class Dashboard {


    @Then("User waits on homepage for {int} seconds")
    public void user_waits_on_homepage_for_seconds(int seconds) {
        WebDriver driver = Driverfactory.getDriver();
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Waited on homepage for " + seconds + " seconds.");
    }

    @Then("User clicks on Dashboard button")
    public void user_clicks_on_dashboard_button() {
        WebDriver driver = Driverfactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Wait for the button to be visible
        By dashboardButtonLocator = By.xpath("//mat-icon[normalize-space()='chevron_right']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardButtonLocator));

        // Then wait for it to be clickable
        WebElement dashboardButton = wait.until(ExpectedConditions.elementToBeClickable(dashboardButtonLocator));

        // Now click the button
        dashboardButton.click();
    }



    @Then("Dashboard details tab opens.")
    public void dashboard_details_tab_opens()  {

        WebDriver driver = Driverfactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlContains("/dashboard"));
    }


}
