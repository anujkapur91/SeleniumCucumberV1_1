package pages;

import Utilities.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;

public class pgToolSQA extends BaseClass
{

    public pgToolSQA() throws IOException {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
//        prop.load(fis);
    }

    //Action
    public String validatePageTitle()
    {
        System.out.println("TOOLS QA - "+driver.getTitle());
        return driver.getTitle();

    }
}
