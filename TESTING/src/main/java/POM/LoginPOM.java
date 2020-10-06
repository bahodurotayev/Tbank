package POM;

import Utilities.Driver;
import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM extends ParentClass{

    WebElement myElement;

    public LoginPOM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[id='email']")
    public WebElement user_input;

    @FindBy(css = "input[id='pwd1']")
    public WebElement password_input;

    @FindBy(css = "input[name='submit']")
    public WebElement login_button;

    @FindBy(css = "p[class='fa fa-user']")
    public WebElement userName_label;

    @FindBy(xpath = "//p[@class='fa fa-lock']")
    public WebElement password_label;

    @FindBy(id = "lblError")
    public WebElement error_label;


    public void findElementAndClickFunction(String ElementName){

        switch (ElementName){
            case "login_button":
                myElement = login_button;
                break;
        }

        clickFunction(myElement);
    }


    public void findElementAndSendKeysFunction(String ElementName , String value){

        switch (ElementName){
            case "user_input":
                myElement = user_input;
                break;
            case "password_input":
                myElement = password_input;
                break;
        }

        sendKeysFunction(myElement , value);
    }
}
