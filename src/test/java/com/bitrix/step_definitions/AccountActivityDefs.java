package com.bitrix.step_definitions;

import com.bitrix.pages.AccountActivityPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class AccountActivityDefs {

    @When("the user clicks on Account Activity page")
    public void the_user_clicks_on_Account_Activity_page() {
        new AccountActivityPage().accountActivityTab.click();
    }

    @Then("Following dropdown should be displayed")
    public void following_dropdown_should_be_displayed(List<String> dropDownOptions) {
        WebElement dropdownElement = Driver.get().findElement(By.id("aa_accountId"));

        Select accountDropdown = new Select(dropdownElement);

        List<WebElement> options = accountDropdown.getOptions();
        List<String> dropDownList = new ArrayList<>();
        for (WebElement option : options) {
            dropDownList.add(option.getText());
        }

        for (int i = 0; i < dropDownOptions.size(); i++) {
            if (dropDownList.contains(dropDownOptions.get(i))) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }


    }

    @Then("Following options should be displayed")
    public void following_options_should_be_displayed(List<String> menuOptions) {
        List<String> menuList = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//table//th")));
        System.out.println(menuList);
        System.out.println(menuOptions);
        if (menuList.equals(menuOptions)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }


    }


}
