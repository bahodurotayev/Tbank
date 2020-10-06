package StepDefinitions;

import POM.AccountSummaryPOM;
import POM.ParentClass;
import Utilities.Driver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.IllegalFormatException;
import java.util.List;

public class AccountSummarySteps {

    WebDriver driver;
    AccountSummaryPOM summaryPOM = new AccountSummaryPOM();
    ParentClass parentClass = new ParentClass();

    @Then("^Account Page contains Account number and Customer information$")
    public void account_Page_contains_Account_number_and_Customer_information() {

        summaryPOM.findWebElement("customer_name_label");
        summaryPOM.findWebElement("customer_name_info");
        summaryPOM.findWebElement("account_number_label");
        summaryPOM.findWebElement("account_number_info");
    }

    @Then("^Click on Initiate transaction button and redirected$")
    public void clickOnInitiateTransactionButtonAndRedirected() {

        summaryPOM.findElementAndClickFunction("initiate_transaction_button");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver = Driver.getDriver();
        String URL_account_page = driver.getCurrentUrl();
        System.out.println("url: " + URL_account_page);
        Assert.assertTrue(URL_account_page.contains("InitTransaction"));
    }

    @And("^Account Page displays correct Balance information$")
    public void accountPageDisplaysCorrectBalanceInformation() {

        summaryPOM.findWebElement("account_balance_label");
        summaryPOM.findWebElement("account_balance_info");

        boolean actual = summaryPOM.findCurrencyElementAndCheckFormat("account_balance_info");
        Assert.assertTrue(actual);
    }

    @And("^Account Page displays all headers$")
    public void accountPageDisplaysAllHeaders() {

        String any_Header = summaryPOM.findWebElement("account_page_header");
//        System.out.println("header: " + any_Header);
        Assert.assertTrue(any_Header.contains("ACCOUNT SUMMARY"));

        any_Header = summaryPOM.findWebElement("transaction_history_header");
        Assert.assertTrue(any_Header.contains("Transaction History"));
    }

    @Then("^Verify table contains correct \"([^\"]*)\"$")
    public void verifyTableContainsCorrect(String listName)  {

        summaryPOM.compareActualAndExpectedLists(listName);
    }

    @And("^Verify table columns are not empty$")
    public void verify_table_columns_are_not_empty(DataTable elements)  {

        List<WebElement> each_Element_in_Table = summaryPOM.list_of_table_elements;
        List<String> table_values = parentClass.listWebElementToString(each_Element_in_Table);

        for (String table_value : table_values) {

            Assert.assertNotNull(table_value);
        }

        List<WebElement> each_element_in_transaction_id = summaryPOM.transaction_id_list;
        List<String> transaction_ids = parentClass.listWebElementToString(each_element_in_transaction_id);

        int count = 0;
        for (String transaction_id : transaction_ids) {
            Assert.assertEquals(Integer.parseInt(transaction_id), ++count);
        }

        List<WebElement> each_element_in_transaction_amount = summaryPOM.transaction_amount_list;
        List<String> transaction_amount_values = parentClass.listWebElementToString(each_element_in_transaction_amount);

        for (String transaction_amount_value : transaction_amount_values) {

            double transaction_amount = Double.parseDouble(transaction_amount_value.substring(1));
            Assert.assertTrue(transaction_amount > 0);

        }

        List<WebElement> each_element_in_transaction_date = summaryPOM.transaction_date_list;
        List<String> transaction_date_values = parentClass.listWebElementToString(each_element_in_transaction_date);

        for (String transaction_date_value : transaction_date_values) {

            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
            LocalDate transaction_Date = LocalDate.parse(transaction_date_value, formatter);
            Assert.assertTrue(transaction_Date.isBefore(today));
            Assert.assertTrue(transaction_Date.isAfter(today.minusMonths(6)));
        }

    }

    @And("^Transaction amounts have valid format$")
    public void transactionAmountsHaveValidFormat() {

        List<WebElement> each_element_in_transaction_amount = summaryPOM.transaction_amount_list;

        for (WebElement element : each_element_in_transaction_amount) {

            boolean valid_format = parentClass.currencyFunctionValidation(element);
//            SoftAssert s1 = new SoftAssert();
//            s1.assertTrue(valid_format);
                Assert.assertTrue(valid_format);
        }
    }
}