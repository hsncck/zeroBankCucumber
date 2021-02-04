package com.bitrix.step_definitions;

import com.bitrix.pages.PayBillsPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class PayBillsDefs {

    @Given("the user accesses the Pay Bills tab")
    public void the_user_accesses_the_Pay_Bills_tab() {
       new PayBillsPage().payBillsTab.click();
    }

    @When("the user should see Zero – Pay Bills")
    public void the_user_should_see_Zero_Pay_Bills() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Pay Bills",actualTitle);
    }

    @Then("the user should enters payment info")
    public void the_user_should_enters_payment_info() {
     PayBillsPage payBillsPage=new PayBillsPage();
     payBillsPage.amountInput.sendKeys("100");
     payBillsPage.dateInput.sendKeys("2021-02-02");
     payBillsPage.descriptionInput.sendKeys("hello");
     payBillsPage.payButton.click();

    }

    @Then("the user should see submit message")
    public void the_user_should_see_submit_message() {
        String expected="The payment was successfully submitted.";
        Assert.assertEquals(expected,new PayBillsPage().message.getText());

    }

    @Then("the user should enters without any input")
    public void the_user_should_enters_without_any_input() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.payButton.click();
    }

    @Then("the user should see Please fill out message")
    public void the_user_should_see_Please_fill_out_message() {
        BrowserUtils.waitFor(2);
        String errorMessage = new PayBillsPage().amountInput.getAttribute("validationMessage");
        System.out.println(errorMessage);

        String expected="Please fill out this field.";
        Assert.assertEquals(expected,errorMessage);

    }

    @Then("the user should enters amount field alphabetical char")
    public void the_user_should_enters_amount_field_alphabetical_char() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.amountInput.sendKeys("kjsdfh");
        payBillsPage.dateInput.sendKeys("2021-02-02");
        payBillsPage.descriptionInput.sendKeys("hello");
        payBillsPage.payButton.click();
    }

    @Then("the user should not see submit message")
    public void the_user_should_not_see_submit_message() {
        String expected="The payment was successfully submitted.";
        Assert.assertNotEquals(expected,new PayBillsPage().message.getText());
    }

    @Then("the user should enters date field alphabetical char")
    public void the_user_should_enters_date_field_alphabetical_char() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.amountInput.sendKeys("100");
        payBillsPage.dateInput.sendKeys("şaksd");
        payBillsPage.descriptionInput.sendKeys("hello");
        payBillsPage.payButton.click();
    }

    @Then("the user should see error message")
    public void the_user_should_see_error_message() {
        BrowserUtils.waitFor(2);
        String errorMessage = new PayBillsPage().dateInput.getAttribute("validationMessage");
        System.out.println(errorMessage);
        String expected="Please fill out this field.";
        Assert.assertEquals(expected,errorMessage);
    }
}