package UILibrary;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UIAction
{
    Scenario scenario;

    public static void selectDropDown(WebDriver driver, WebElement element, String selection)
    {
        Select slct = new Select(element);
        List<WebElement> optionsList = slct.getOptions();
//            HashSet<WebElement> optionsElement = new HashSet<WebElement>(optionsList);

            for(WebElement ele: optionsList )
            {
                if (ele.getText()==selection)
                {
                    ele.click();
                    break;
                }
            }


    }

    public static void selectDropDown(String multipleSelections , WebDriver driver, WebElement element)
    {
        HashSet<String> selections = new HashSet<String>(Arrays.asList(multipleSelections.split(";")));
        Select slct = new Select(element);
        if (slct.isMultiple())
        {
            List<WebElement> optionsList = slct.getOptions();
//            HashSet<WebElement> optionsElement = new HashSet<WebElement>(optionsList);


            for(String selection : selections)
            {
                for(WebElement ele: optionsList )
                {
                    if (ele.getText()==selection)
                    {
                        ele.click();
                        break;
                    }
                }

            }
        }
        else
        {
            Assert.assertTrue("Drop Down does not support multiple selection",false);
        }


    }

    //Check or Uncheck Radio Button or CheckBox

    public static void checkBox()
    {

    }
}
