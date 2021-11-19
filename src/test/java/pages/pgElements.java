package pages;

import UILibrary.Ram;
import Utilities.BaseClass;

public class pgElements extends BaseClass
{
    public pgElements()
    {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
//        prop.load(fis);
    }

    //Actions

    public String validatePageTitle()
    {

        return driver.getTitle();
    }

    public pgToolSQA clickOnHomePageLink() throws Throwable {

//        driver.findElement(By.xpath("(//div[@id='app']//img)[1]")).click();
        Ram.clicksOn("HomePageBanner");
        return new pgToolSQA();

    }
}
