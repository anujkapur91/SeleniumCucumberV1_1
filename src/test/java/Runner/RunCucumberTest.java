package Runner;

import org.junit.Before;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\src\\test\\java\\features"
		,glue= {"stepDefinations"}
		//,tags = ("@QA and @SMOKE")
//		,tags = ("@Gmaps")
		,dryRun = false ,plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty.html"}
		,monochrome = true
		)
//\RestAssuredFeatureFile.feature

public class RunCucumberTest 
{

}
