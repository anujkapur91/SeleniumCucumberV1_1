package pages;

import Utilities.BaseClass;
import Utilities.LocatorRepository;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;

public class pgElements extends BaseClass
{
    public pgElements() throws IOException {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
//        prop.load(fis);
    }

    //Actions

    public String validatePageTitle()
    {
        System.out.println("ELEMENTS - "+driver.getTitle());
        return driver.getTitle();
    }

    public pgToolSQA clickOnHomePageLink() throws IOException {
        driver.findElement(By.xpath("(//div[@id='app']//img)[1]")).click();
        return new pgToolSQA();

    }
}
