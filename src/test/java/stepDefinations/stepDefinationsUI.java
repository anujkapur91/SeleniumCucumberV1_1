package stepDefinations;

import Utilities.BaseClass;
import Utilities.FWUtility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.pgDemoQA;
import pages.pgElements;
import pages.pgToolSQA;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class stepDefinationsUI extends BaseClass {

    WebDriver driver=null;
    pgDemoQA pgDemoQA= new pgDemoQA();
    pgElements pgElements ;
    pgToolSQA pgToolSQA ;

    public stepDefinationsUI() throws IOException
    {

    }

    @AfterStep
    public  void  TakeScreenShot(Scenario scenario) throws IOException
    {
//        TakesScreenshot sShot = (TakesScreenshot) BaseClass.driver;
//        byte[] sShotData = sShot.getScreenshotAs(OutputType.BYTES);
        if(BaseClass.driver!=null)
        {
            byte[] sShotData = FWUtility.takeScreenshotByte(BaseClass.driver);
            scenario.attach(sShotData, "image/png", timeStamp());
        }



    }
    @After
    public void tearDown()
    {
        if(BaseClass.driver!=null)
        {
            BaseClass.driver.close();
            BaseClass.driver.quit();
        }

    }

    public static String  timeStamp()
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        return timeStamp.replaceAll("[.]*", "");
    }




    @Given("User Opens Browser and Navigates to DemoQA")
    public void user_opens_browser_and_navigates_to_demo_qa() throws IOException {
        BaseClass.Initialization();
    }

    @Then("User validates the Page Title of DemoQA Page")
    public void user_validates_the_page_title_of_demo_qa_page() throws IOException
    {
        Assert.assertEquals(pgDemoQA.validatePageTitle(), "ToolsQA");
//        TakeScreenShot(scenario);
    }

    @Then("User clicks on Elements link on DemoQA Page")
    public void user_clicks_on_elements_link_on_demo_qa_page() throws IOException
    {
        pgElements = pgDemoQA.clickOnElements();
//        TakeScreenShot(scenario);
    }
    @Then("User validates the Page Title of Elements Page")
    public void user_validates_the_page_title_of_elements_page() throws IOException
    {
        Assert.assertEquals(pgElements.validatePageTitle(), "ToolsQA");
//        TakeScreenShot(scenario);

    }
    @Then("Use clicks on ToolSQA Banner")
    public void use_clicks_on_tool_sqa_banner() throws IOException
    {
        pgToolSQA = pgElements.clickOnHomePageLink();
//        TakeScreenShot(scenario);
    }
    @Then("User validates the Page Title of ToolSQAPage")
    public void user_validates_the_page_title_of_tool_sqa_page() throws IOException
    {
        Assert.assertEquals(pgToolSQA.validatePageTitle(), "ToolsQA");
//        TakeScreenShot(scenario);

    }
    @Then("User closes browser")
    public void user_closes_browser() {
        BaseClass.driver.close();
        BaseClass.driver.quit();
    }
}
