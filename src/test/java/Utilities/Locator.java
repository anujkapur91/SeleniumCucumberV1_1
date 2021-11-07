package Utilities;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Locator
{
    private static String locatorString;
    static Properties prop;
    private By by;

    public Locator() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
        prop.load(fis);


    }

    public static By getLocator(String locatorName)
    {
        locatorString = prop.getProperty(locatorName);
        String[] l = locatorString.split(":");

        switch (l[0].toUpperCase())
        {
            case "XPATH":
                return By.xpath(l[1]);

            case "CSS":
                return By.cssSelector(l[1]);

            case "ID":
                return By.id(l[1]);

            default:
                return By.xpath(l[1]);
        }

//    return By.xpath("(//div[@class='card-up'])[1]");

    }

    public static By getTableColumns(String locatorName)
    {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
//        prop.load(fis);

        locatorString = prop.getProperty(locatorName);
        String[] l = locatorString.split(":");

        switch (l[0].toUpperCase())
        {
            case "XPATH":
                return By.xpath(l[1]+"/thead/tr/th");

            case "CSS":
                return By.cssSelector(l[1]);

            case "ID":
                return By.id(l[1]);

            default:
                return By.xpath(l[1]);
        }

//    return By.xpath("(//div[@class='card-up'])[1]");

    }

    public static String getLocatorPath(String locatorName)
    {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\Locator.properties");
//        prop.load(fis);

        locatorString = prop.getProperty(locatorName);
        String[] l = locatorString.split(":");
        return  l[0];


    }
}
