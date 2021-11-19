package UILibrary;

import Utilities.BaseClass;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class Ram extends BaseClass {
    Scenario scenario;

    public static void selectDropDown(WebDriver driver, WebElement element, String selection) {
        Select slct = new Select(element);
        List<WebElement> optionsList = slct.getOptions();
//            HashSet<WebElement> optionsElement = new HashSet<WebElement>(optionsList);

        for (WebElement ele : optionsList) {
            if (ele.getText().equals(selection) ) {
                ele.click();
                break;
            }
        }


    }

    public static void selectDropDown(String multipleSelections, WebDriver driver, WebElement element) {
        HashSet<String> selections = new HashSet<String>(Arrays.asList(multipleSelections.split(";")));
        Select slct = new Select(element);
        if (slct.isMultiple()) {
            List<WebElement> optionsList = slct.getOptions();
//            HashSet<WebElement> optionsElement = new HashSet<WebElement>(optionsList);


            for (String selection : selections) {
                for (WebElement ele : optionsList) {
                    if (ele.getText().equals(selection)) {
                        ele.click();
                        break;
                    }
                }

            }
        } else {
            Assert.fail("Drop Down does not support multiple selection");
        }


    }

    //Check or Uncheck Radio Button or CheckBox

    public static void checkBox(WebDriver driver, WebElement element, CheckBoxOption c)
    {
        if (c == CheckBoxOption.ON && !element.isSelected()) {
            element.click();
        } else if (c == CheckBoxOption.OFF && element.isSelected())
        {
            element.click();
        }
    }

    //Find a specific column and then a specific row with the help of text and then read a value from the required column

    public static String getDataFromTable(String tableName, String columToBeSearched, String valueToBeSearched, String columnWhoseValueToBeRetreived) throws IOException {

        List<WebElement> rows;
        WebElement cell;
        String strCellValue = null;
        int columToBeSearchedIndex;
        int columnWhoseValueToBeRetreivedIndex;
        columToBeSearchedIndex = getColumnIndex(tableName,columToBeSearched);
        columnWhoseValueToBeRetreivedIndex = getColumnIndex(tableName,columnWhoseValueToBeRetreived);

        rows = driver.findElements(By.xpath(locator.getLocatorPath(tableName)+"/tbody/tr"));
       for(int r=1; r<=rows.size(); r++)
       {
           cell = driver.findElement(By.xpath(locator.getLocatorPath(tableName)+"/tbody/tr[" + r + "]"+"/td["+ columToBeSearchedIndex +"]"));
           if(cell.getText().equals(valueToBeSearched))
           {
               strCellValue =  driver.findElement(By.xpath(locator.getLocatorPath(tableName)+"/tbody/tr[" + r + "]"+"/td["+ columnWhoseValueToBeRetreivedIndex +"]")).getText();
               return strCellValue;
           }
       }
        return strCellValue;



    }

    public static void clicksOn(String locatorName) throws Throwable
    {

            driver.findElement(locator.getLocator(locatorName)).click();




    }

    private static int getColumnIndex(String tableLocatorName, String columnaName) throws IOException
    {
        int strColumnIndex = 0;
        List<WebElement> columns =  driver.findElements(locator.getTableColumns(tableLocatorName));
        int cols = columns.size();

        //locking the column to be searched
        for (int c=1; c<=cols; c++)
        {
            if(columns.get(c).getText().equals(columnaName))
            {
                strColumnIndex = c;
                break;
            }
        }

        return strColumnIndex;
    }

    public static void checksBrokenLinkOnPage()throws IOException
    {
        String url,responseMessage;
        HttpURLConnection http;
        int statusCode;
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        for (WebElement e: elementList)
        {
            try
            {
                url = e.getAttribute("href");
                http = (HttpURLConnection) new URL(url).openConnection();
                http.setConnectTimeout(3000);
                http.connect();
                statusCode = http.getResponseCode();
                responseMessage = http.getResponseMessage();

                Hashtable brokenLinksCollection = new Hashtable();
                if (statusCode>=400)
                {
                    brokenLinksCollection.put(url, responseMessage);
                }

                Assert.assertTrue("Following Links are broken" +"/n"+ brokenLinksCollection,brokenLinksCollection.isEmpty() );
            }
            catch (MalformedURLException ex)
            {
                ex.printStackTrace();
            }

        }
    }
}