package com.bitrix.step_definitions;

import com.bitrix.pages.LoginPage;
import com.bitrix.pages.PayBillsPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseForeignCurrencyDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login();
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payBillsTab.click();

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> menuOptions) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.purchaseForeignCurrencyLink.click();

        BrowserUtils.waitFor(3);

        List<String> options = BrowserUtils.getElementsText(payBillsPage.currencyList);

        for (int i = 0; i < menuOptions.size(); i++) {
            if (options.contains(menuOptions.get(i))) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
//THERE IS UNKNOWN PROBLEM IN THIS CODE . CHECK IT LATER


    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.purchaseForeignCurrencyLink.click();
        BrowserUtils.waitFor(2);
        WebElement element = Driver.get().findElement(By.id("pc_calculate_costs"));
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", element);



    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();

        String expected="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expected,alert.getText());
        alert.accept();
        BrowserUtils.waitFor(2);

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.purchaseForeignCurrencyLink.click();
        BrowserUtils.waitFor(2);
        WebElement element = Driver.get().findElement(By.id("pc_calculate_costs"));
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", element);



    }
}
