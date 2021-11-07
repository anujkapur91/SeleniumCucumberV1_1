package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass
{

    public static WebDriver driver;
    public static Properties prop;
    public static Locator locator;
    public BaseClass()
    {

        try
        {
            prop = new Properties();
            FileInputStream  fis = new FileInputStream("C:\\Users\\Anuj kapur\\Eclipse2021\\SeleniumCucumberV1_1\\config.properties");
            prop.load(fis);


        }catch(IOException e)
        {
            System.out.println(e.getMessage());

        }
    }

public static void Initialization() throws IOException {
    String URL = prop.getProperty("url");
    System.setProperty( "webdriver.edge.driver", "C:\\Users\\Anuj kapur\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//    pageLoadTimeOut = 20
//    implicitWait = 20
    driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(prop.getProperty("pageLoadTimeOut"))));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
    driver.get(prop.get("url").toString());

    locator = new Locator();

}
}
