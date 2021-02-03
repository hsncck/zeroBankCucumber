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

        List<String> options = BrowserUtils.getElementsText(payBillsPage.currecyList);
        List<String> actualOptions=new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            actualOptions.add(options.get(i));
        }
        System.out.println(actualOptions);
        System.out.println(menuOptions);

        for (int i = 0; i < menuOptions.size(); i++) {
            if (!(actualOptions.contains(menuOptions.get(i)))) {
                Assert.assertTrue(false);
            } else {
                Assert.assertTrue(true);
            }
        }


    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

    }
}
