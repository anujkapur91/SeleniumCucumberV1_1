package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    public static RequestSpecification request;
    public static Response response;

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
//    System.setProperty( "webdriver.edge.driver", "C:\\Users\\Anuj kapur\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//    pageLoadTimeOut = 20
//    implicitWait = 20
    WebDriverManager.edgedriver().setup();
//    driver = new ChromeDriver();
    EdgeOptions eo = new EdgeOptions();
    eo.addArguments("--disable-notifications"); // disabeling notifications
    eo.addArguments("start-maximized");
//    eo.addArguments("--headless");
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//    capabilities.setCapability(EdgeOptions.CAPABILITY, eo);
//    eo.merge(capabilities);

    driver = new EdgeDriver(eo);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(prop.getProperty("pageLoadTimeOut"))));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
    driver.get(prop.get("url").toString());
    locator = new Locator();

}
}
