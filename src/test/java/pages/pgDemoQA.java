package pages;

import UILibrary.UIAction;
import Utilities.BaseClass;
import Utilities.Locator;
import org.openqa.selenium.By;

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
//        System.out.println("DEMO QA - "+ driver.getTitle());
        return driver.getTitle();

    }

    //LogIn
    public pgElements clickOnElements() throws IOException {
//        driver.findElement(By.xpath("(//div[@class='card-up'])[1]")).click();

//        driver.findElement(locator.getLocator("Elements")).click();
        UIAction.clickElement("Elements");
        return new pgElements();

    }

}
