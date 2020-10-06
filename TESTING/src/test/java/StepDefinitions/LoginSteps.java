package StepDefinitions;

import POM.LoginPOM;
import Utilities.Driver;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;
    LoginPOM loginPOM = new LoginPOM();

    @Given("^Navigate to website$")
    public void navigate_to_website()  {
        driver = Driver.getDriver();
        driver.get("D:\\HelloScrumProject\\UI\\Login.html");
        driver.manage().window().maximize();
    }


    @When("^Entering  \"([^\"]*)\" and \"([^\"]*)\" credentials$")
    public void enteringAndCredentials(String userName, String password)  {

        loginPOM.findElementAndSendKeysFunction("user_input", userName);
        loginPOM.findElementAndSendKeysFunction("password_input", password);
        loginPOM.findElementAndClickFunction("login_button");
    }

    @Then("^User should login successfully and redirected to appropriate page$")
    public void user_should_login_successfully_and_redirected_to_appropriate_page()  {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String URL_account_page = driver.getCurrentUrl().toLowerCase();
        System.out.println("url: " + URL_account_page);
        Assert.assertTrue(URL_account_page.contains("account%20summary"));
    }

    @Then("^Empty username message will display$")
    public void emptyUsernameMessageWillDisplay() {

        String username_error = loginPOM.error_label.getText().toLowerCase();
        Assert.assertTrue(username_error.contains("please enter username"));
    }

    @Then("^Empty password message will display$")
    public void emptyPasswordMessageWillDisplay() {

        String password_error = loginPOM.error_label.getText().toLowerCase();
        Assert.assertTrue(password_error.contains("please enter password"));
    }

    @Then("^Appropriate message will display$")
    public void appropriateMessageWillDisplay() {

        String message = loginPOM.error_label.getText().toLowerCase();
        Assert.assertTrue(message.contains("username and password are required"));
    }

    @Then("^Invalid Credential error message will display$")
    public void invalidCredentialErrorMessageWillDisplay() {

        String invalid_Credentials = loginPOM.error_label.getText().toLowerCase();
        Assert.assertTrue(invalid_Credentials.contains("invalid credentials"));
    }
}
