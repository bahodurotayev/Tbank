package POM;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParentClass {

    WebDriverWait wait;
    WebDriver driver;

    public ParentClass() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver,10);
    }

    public void clickFunction(WebElement element){

        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element , String value){

        waitUntilVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public void waitUntilVisible(WebElement elementToWait){

        wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }

    public void waitUntilClickable(WebElement elmentToWait){

        wait.until(ExpectedConditions.elementToBeClickable(elmentToWait));
    }

    public void scrollToElement(WebElement elementToScroll){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    public boolean currencyFunctionValidation(WebElement elementToConvert){

        String money = elementToConvert.getText().substring(1);
        System.out.println(money);
        Pattern p=Pattern.compile("^\\$?(([1-9]\\d{0,9}(,\\d{3})*)|0)?\\.\\d{0,2}$");
        Matcher m=p.matcher(money);
        System.out.println(m.matches());

        return m.matches();
    }

    public double stringToDoubleConverter(WebElement elementToConvert){

        String amount = elementToConvert.getText().substring(1);

        return Double.parseDouble(amount);
    }

    public List<String> listWebElementToString(List<WebElement> myElements){

        List<String> actualResultString = new ArrayList<>();

        for(WebElement eachElement:myElements){

            actualResultString.add(eachElement.getText());
        }

        return actualResultString;
    }
}
