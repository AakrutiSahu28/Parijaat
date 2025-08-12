package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue={"hooks","Stepdefinitions"},plugin={"pretty","html:target/CucumberReports/CucumberReport.html"},publish=true)

public class MyRunnerClass {


}