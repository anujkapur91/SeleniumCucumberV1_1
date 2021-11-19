package pages;

import UILibrary.Ram;
import Utilities.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;

public class pgDemoQA extends BaseClass
{

    public pgDemoQA() throws IOException
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
        prop.load(fis);

    }

    //Actions or Page Object Methods
    public String validatePageTitle()
    {
        return driver.getTitle();
    }

    //LogIn
    public pgElements clickOnElements() throws Throwable {
//        driver.findElement(By.xpath("(//div[@class='card-up'])[1]")).click();

//        driver.findElement(locator.getLocator("Elements")).click();
        Ram.clicksOn("Elements");
        Ram.checksBrokenLinkOnPage();
        return new pgElements();

    }

}
