package SeleniumOrJavaTest;

import Utilities.ScreenShotType;
import Utilities.FWUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Test {

    public static void main(String...args) throws InterruptedException, IOException {
        System.setProperty( "webdriver.edge.driver", "C:\\Users\\Anuj kapur\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10) );
    //.implicitlyWait(10000, TimeUnit.MILLISECONDS);

//        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//        Thread.sleep(10000);
//        driver.switchTo().alert().accept();
//
//        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//        Thread.sleep(10000);
//        driver.switchTo().alert().accept();
//
//        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//        Thread.sleep(10000);
//        driver.switchTo().alert().dismiss();
        WebElement x = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        FWUtility.takeScreenshot(driver, x,"Alert", ScreenShotType.FULLPAGE );

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                //WebDriverWait( driver,20);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().sendKeys("Anuj Kapur AQA");
//        Thread.sleep(3000);
        driver.switchTo().alert().accept();
//        Thread.sleep(3000);
        FWUtility.takeScreenshotAt(driver, driver.findElement(By.id("result")),"Result", "C:\\Users\\Anuj kapur\\Desktop", ScreenShotType.ONLY_ELEMENT );

        System.out.println("$$$$$$$$$$  " + driver.findElement(By.id("result")).getText() + " $$$$$$$$$$$$$$$");
        driver.quit();


    }
}
