package StepDefinitions;

import POM.LoginPOM;
import Utilities.Driver;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class TitlePageSteps {

    WebDriver driver;
    LoginPOM loginPOM = new LoginPOM();


    @When("^Title of the page is not empty$")
    public void titleOfThePageIsNotEmpty()  {

        driver = Driver.getDriver();
        Assert.assertFalse(driver.getTitle().isEmpty());
    }


    @Then("^Title of the page contains \"([^\"]*)\"$")
    public void titleOfThePageContains(String expected_title)  {

       Assert.assertTrue(driver.getTitle().contains(expected_title));
    }


    @Given("^Validate presence of Labels, Textboxes and login button$")
    public void validate_presence_of_Labels_Textboxes_and_login_button() {

        Assert.assertNotNull(loginPOM.userName_label);
        Assert.assertNotNull(loginPOM.password_label);
        Assert.assertNotNull(loginPOM.user_input);
        Assert.assertNotNull(loginPOM.password_input);
        Assert.assertNotNull(loginPOM.error_label);
        Assert.assertNotNull(loginPOM.login_button);
    }

    @Given("^Verify Placeholder contains Label name$")
    public void verify_Placeholder_contains_Label_name() {

        String user_placeholder = loginPOM.user_input.getAttribute("placeholder");
        Assert.assertEquals(user_placeholder, "Enter Username");
        String password_placeholder = loginPOM.password_input.getAttribute("placeholder");
        Assert.assertEquals(password_placeholder, "Enter Password");
    }

    @When("^user enter the password$")
    public void userEnterThePassword() {

        loginPOM.password_input.sendKeys("12345678");
    }

    @Then("^password is not visible and should be as asterisk or bullet signs$")
    public void passwordIsNotVisibleAndShouldBeAsAsteriskOrBulletSigns() {
        String pswd_input_type = loginPOM.password_input.getAttribute("type");
        Assert.assertEquals(pswd_input_type, "password");
    }
}
