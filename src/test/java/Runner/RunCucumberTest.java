package Runner;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\src\\test\\java\\features\\TestAPI.feature"
		,glue= {"stepDefinations"}
		//,tags = ("@QA and @SMOKE")
//		,tags = ("@Gmaps")
		,dryRun = true ,plugin = {"pretty","json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/cucumber-pretty.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,monochrome = true
		)
//\TestAPI.feature
//,"json:target/cucumber.json"
public class RunCucumberTest 
{

}
