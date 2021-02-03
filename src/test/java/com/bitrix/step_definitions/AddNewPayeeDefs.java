package com.bitrix.step_definitions;

import com.bitrix.pages.LoginPage;
import com.bitrix.pages.PayBillsPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeDefs {
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login();
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payBillsTab.click();

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeInfo) {

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.addNewPayeeLink.click();
        BrowserUtils.waitFor(2);
        payBillsPage.payeeNameInput.sendKeys(payeeInfo.get("Payee Name"));
        payBillsPage.payeeAddressInput.sendKeys(payeeInfo.get("Payee Address"));
        payBillsPage.accountInput.sendKeys(payeeInfo.get("Account"));
        payBillsPage.detailsInput.sendKeys(payeeInfo.get("Payee details"));
        payBillsPage.addButton.click();

        BrowserUtils.waitFor(2);

        String expected="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        String actual= payBillsPage.message.getText();
        Assert.assertEquals(actual,expected);

        System.out.println("payBillsPage.message.getText() = " + payBillsPage.message.getText());


    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {

    }
}
