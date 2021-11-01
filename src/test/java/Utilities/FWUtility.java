package Utilities;

import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.*;
import org.openqa.selenium.*;


import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public  class FWUtility
{

    public static WebElement waitWithFluentWait(WebDriver driver, By locator , int waitTimeOut, int frequencyInSeconds)
    {
        WebElement element;

        // Declaration Part
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(waitTimeOut))
                .pollingEvery(Duration.ofSeconds(frequencyInSeconds))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class );

        //Implementation part

        element = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public static String takeScreenshot(WebDriver driver, WebElement element, String ScreenShotName,ScreenShotType screenShotType ) throws IOException
    {

        File source;
        File target;

        //Highlight element in both the scenarios
        highlightElement(driver,element);

        switch(screenShotType)
        {
        case FULLPAGE:

            TakesScreenshot scrn = (TakesScreenshot) driver;
            source = scrn.getScreenshotAs(OutputType.FILE);
            break;
        case ONLY_ELEMENT:

            source = element.getScreenshotAs(OutputType.FILE);
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + screenShotType);
        }

        target =  new File(ScreenShotName+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot at - " + target.getAbsolutePath() );
        return target.getAbsolutePath();
    }

    public static String takeScreenshotAt(WebDriver driver, WebElement element, String ScreenShotName, String screenShotBasePath, ScreenShotType screenShotType ) throws IOException
    {

        File source;
        File target;

        //Highlight element in both the scenarios
        highlightElement(driver,element);

        switch(screenShotType)
        {
            case FULLPAGE:

                TakesScreenshot scrn = (TakesScreenshot) driver;
                source = scrn.getScreenshotAs(OutputType.FILE);
                break;
            case ONLY_ELEMENT:

                source = element.getScreenshotAs(OutputType.FILE);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + screenShotType);
        }

        target =  new File(screenShotBasePath + "\\"+ ScreenShotName+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot at - " + target.getAbsolutePath() );
        return target.getAbsolutePath();
    }

    public static byte[] takeScreenshotByte(WebDriver driver ) throws IOException
    {

        TakesScreenshot scrn = (TakesScreenshot) driver;
        return scrn.getScreenshotAs(OutputType.BYTES);
    }
    private static void highlightElement(WebDriver driver , WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);
    }

//    public enum ScreenShotType
//    {
//        FULLPAGE, ONLY_ELEMENT
//    }

}


