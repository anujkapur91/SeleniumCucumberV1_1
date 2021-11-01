package UILibrary;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public  class Utility
{

    public static WebElement waitWithFluentWait(WebDriver driver, By locator , int waitTimeOut, int frequencyInSeconds)
    {
        WebElement element;

        // Declaration Part
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(waitTimeOut))
                .pollingEvery(Duration.ofSeconds(frequencyInSeconds))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class );
        //Implimentation part

        element = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }
}
