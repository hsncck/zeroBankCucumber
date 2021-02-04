package com.bitrix.step_definitions;

import com.bitrix.pages.AccountSummaryPage;
import com.bitrix.pages.LoginPage;
import com.bitrix.pages.PayBillsPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryInfoDefs {

    @Given("the user accesses Account Summary Page")
    public void the_user_accesses_Account_Summary_Page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login();
    }

    @Then("the user should see Zero – Account summary title")
    public void the_user_should_see_Zero_Account_summary_title() {
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Summary", actualTitle);
    }

    @Then("the user should see following Account Types")
    public void the_user_should_see_following_Account_Types(List<String> menuOptions) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> options=BrowserUtils.getElementsText(accountSummaryPage.creditAccountOptions);
        System.out.println(menuOptions);
        System.out.println(options);

        if (options.equals(menuOptions)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
}
