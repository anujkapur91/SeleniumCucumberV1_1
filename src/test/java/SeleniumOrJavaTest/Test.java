package SeleniumOrJavaTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String...args) throws InterruptedException {
        System.setProperty( "webdriver.edge.driver", "C:\\Users\\Anuj kapur\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

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

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait( driver,20);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().sendKeys("Anuj Kapur");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        System.out.println("$$$$$$$$$$  " + driver.findElement(By.id("result")).getText() + " $$$$$$$$$$$$$$$");
        driver.quit();


    }
}
