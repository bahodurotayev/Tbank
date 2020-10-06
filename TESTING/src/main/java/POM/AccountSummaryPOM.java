package POM;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.Arrays;
import java.util.List;

public class AccountSummaryPOM extends ParentClass{

    WebElement myElement;
    List<WebElement> myList;

    public AccountSummaryPOM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[contains(text(),'Account Holder')]")
    public WebElement customer_name_label;

    @FindBy(xpath = "(//div[@class='table-cell']//p)[1]")
    public WebElement customer_name_info;

    @FindBy(xpath = "//p[contains(text(),'Account Number')]")
    public WebElement account_number_label;

    @FindBy(xpath = "(//div[@class='table-cell']//p)[2]")
    public WebElement account_number_info;

    @FindBy(xpath = "//p[contains(text(),'Balance')]")
    public WebElement account_balance_label;

    @FindBy(xpath = "(//div[@class='table-cell']//p)[3]")
    public WebElement account_balance_info;

    @FindBy (css = "a[href='InitTransaction.html']")
    public WebElement initiate_transaction_button;

    @FindBy(xpath = "//h4[contains(text(),'Transaction History')]")
    public WebElement transaction_history_header;

    @FindBy(xpath = "//h1")
    public WebElement account_page_header;

    @FindAll({
            @FindBy(css = "table[class='content-table']>thead>tr>th")
    })
    public List<WebElement> table_header_List;

    @FindAll({
            @FindBy(css = "td[data-label='TransactionID']"),
            @FindBy(css = "td[data-label='Transaction Type']"),
            @FindBy(css = "td[data-label='Transaction Amount']"),
            @FindBy(css = "td[data-label='Transaction Date']")
    })
    public List<WebElement> list_of_table_elements;

    @FindAll({
            @FindBy(css = "td[data-label='TransactionID']")
    })
    public List<WebElement> transaction_id_list;

    @FindAll({
            @FindBy(css = "td[data-label='Transaction Type']")
    })
    public List<WebElement> transaction_type_list;

    @FindAll({
            @FindBy(css = "td[data-label='Transaction Amount']")
    })
    public List<WebElement> transaction_amount_list;

    @FindAll({
            @FindBy(css = "td[data-label='Transfer Account']")
    })
    public List<WebElement> transfer_account_list;

    @FindAll({
            @FindBy(css = "td[data-label='Transaction Date']")
    })
    public List<WebElement> transaction_date_list;


    public String findWebElement(String elementName){

        switch (elementName){
            case "account_page_header":
                myElement = account_page_header;
                break;
            case "customer_name_label":
                myElement = customer_name_label;
                break;
            case "account_number_label":
                myElement = account_number_label;
                break;
            case "account_balance_label":
                myElement = account_balance_label;
                break;
            case "customer_name_info":
                myElement = customer_name_info;
                break;
            case "account_number_info":
                myElement = account_number_info;
                break;
            case "account_balance_info":
                myElement = account_balance_info;
                break;
            case "transaction_history_header":
                myElement = transaction_history_header;
                break;
        }
        waitUntilVisible(myElement);

        return myElement.getText();
    }

    public void findElementAndClickFunction(String ElementName){

        switch (ElementName){
            case "initiate_transaction_button":
                myElement = initiate_transaction_button;
                break;
        }

        clickFunction(myElement);
    }

    public boolean findCurrencyElementAndCheckFormat(String elementName){

        switch (elementName){
            case "account_balance_info":
                myElement = account_balance_info;
                break;
        }
        return currencyFunctionValidation(myElement);
    }

    public void compareActualAndExpectedLists(String elementListName){

        List<String> expected_list = Arrays.asList("TransactionID", "Transaction Type",
                "Transaction Amount", "Transfer Account", "Transaction Date");
        switch (elementListName){
            case "table_header_List":
                myList = table_header_List;
                break;
        }

        List<String> actual_list = listWebElementToString(myList);

        for (int i = 0; i < expected_list.size(); i++) {
            System.out.println(actual_list.get(i) + " : " + expected_list.get(i));
            Assert.assertEquals(actual_list.get(i), expected_list.get(i));
        }
    }
}
