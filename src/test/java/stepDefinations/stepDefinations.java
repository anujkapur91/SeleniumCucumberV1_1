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

public class stepDefinations extends BaseClass {

    WebDriver driver=null;
    Scenario scenario;
    pgDemoQA pgDemoQA= new pgDemoQA();
    pgElements pgElements ;
    pgToolSQA pgToolSQA ;

    public stepDefinations() throws IOException {
    }

//    @AfterStep
//    public void TakeScreenShot(Scenario scenario) throws IOException {
//        TakesScreenshot sShot = (TakesScreenshot) driver;
////        byte[] sShotData = sShot.getScreenshotAs(OutputType.BYTES);
//        byte[] sShotData = FWUtility.takeScreenshotByte(driver);
//        scenario.attach(sShotData, "image/png", timeStamp());
//
//    }
//    @After
//    public void tearDown()
//    {
//        BaseClass.driver.close();
//        BaseClass.driver.quit();
//    }

    public String  timeStamp()
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        return timeStamp.replaceAll("[.]*", "");
    }




    @Given("User Opens Browser and Navigates to DemoQA")
    public void user_opens_browser_and_navigates_to_demo_qa() {
        BaseClass.Initialization();
    }

    @Then("User validates the Page Title of DemoQA Page")
    public void user_validates_the_page_title_of_demo_qa_page()
    {
        Assert.assertEquals(pgDemoQA.validatePageTitle(), "ToolsQA");


    }
    @Then("User clicks on Elements link on DemoQA Page")
    public void user_clicks_on_elements_link_on_demo_qa_page() throws IOException {
        pgElements = pgDemoQA.clickOnElements();
    }
    @Then("User validates the Page Title of Elements Page")
    public void user_validates_the_page_title_of_elements_page() {
        Assert.assertEquals(pgElements.validatePageTitle(), "ToolsQA");

    }
    @Then("Use clicks on ToolSQA Banner")
    public void use_clicks_on_tool_sqa_banner() throws IOException {
        pgToolSQA = pgElements.clickOnHomePageLink();
    }
    @Then("User validates the Page Title of ToolSQAPage")
    public void user_validates_the_page_title_of_tool_sqa_page() {
        Assert.assertEquals(pgToolSQA.validatePageTitle(), "ToolsQA");

    }
    @Then("User closes browser")
    public void user_closes_browser() {
        BaseClass.driver.close();
        BaseClass.driver.quit();
    }
}
