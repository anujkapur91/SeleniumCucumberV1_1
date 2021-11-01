package pages;

import Utilities.BaseClass;
import Utilities.LocatorRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class pgDemoQA extends BaseClass
{
    public static Properties prop;

    public pgDemoQA() throws IOException
    {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
//        prop.load(fis);

    }

    //Actions or Page Object Methods
    public String validatePageTitle()
    {
        System.out.println("DEMO QA - "+ driver.getTitle());
        return driver.getTitle();

    }

    //LogIn
    public pgElements clickOnElements() throws IOException {
        driver.findElement(By.xpath("(//div[@class='card-up'])[1]")).click();
        return new pgElements();
    }

}
