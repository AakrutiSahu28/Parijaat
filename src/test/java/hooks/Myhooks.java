package hooks;

import java.time.Duration;
import java.util.Properties;

import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import Factory.Driverfactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Myhooks {


    private WebDriver driver;

    @Before
    public void setup() {
        Properties prop = ConfigReader.initializeProperties();
        Driverfactory.initializeBrowser(prop.getProperty("browser"));
        driver = Driverfactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void teardown(Scenario scenario) {


        // How to take screenshot for failed scenario/test cases
        String ScenarioaName = scenario.getName().replaceAll(" ", "_");
        if (scenario.isFailed()) {
            byte[] srcscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcscreenshot, "image/png", ScenarioaName);
        }
        //driver.quit();
    }}

