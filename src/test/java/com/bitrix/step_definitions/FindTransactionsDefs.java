package com.bitrix.step_definitions;

import com.bitrix.pages.AccountActivityPage;
import com.bitrix.pages.AccountSummaryPage;
import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Locale;
//    THIS CODE BLOK IS WRITTEN BY ONDER SAHAN
public class FindTransactionsDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login();
        new AccountSummaryPage().accountActivityTab.click();
        new AccountActivityPage().findTransactionsLink.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDateInputBox.clear();
        accountActivityPage.toDateInputBox.clear();
        accountActivityPage.fromDateInputBox.sendKeys(fromDate);
        accountActivityPage.toDateInputBox.sendKeys(toDate);
        BrowserUtils.waitFor(1);

    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String str1, String str2) {
        Assert.assertTrue(new AccountActivityPage().fitsIn(str1,str2));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(new AccountActivityPage().isSorted());
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String str1) {
        Assert.assertFalse(new AccountActivityPage().contains(str1));  }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.descriptionInputBox.clear();
        accountActivityPage.descriptionInputBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        if (!Driver.get().findElement(By.xpath("(//tbody)[2]/tr")).isDisplayed()) {
            Assert.assertTrue(false);
            System.out.println("No results found");
        }
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (int i = 0; i < accountActivityPage.rows.size(); i++) {
            Assert.assertTrue(accountActivityPage.rows.get(i).getText().contains(description));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        for (int i = 0; i < accountActivityPage.rows.size(); i++) {
            Assert.assertFalse(!accountActivityPage.rows.get(i).getText().contains(description));
        }
    }
    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue(new AccountActivityPage().columnEmpty(3));

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(new AccountActivityPage().columnEmpty(4));
    }

    @When("user selects type {string}")
    public void user_selects_type(String selection) {
        new AccountActivityPage().selectType(selection);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertTrue(new AccountActivityPage().columnEmpty(4));
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue(new AccountActivityPage().columnEmpty(3));
    }

}

//
//    *******************************************
//    This is ANOTHER APPROACH FOR solution
//    @Then("results table should only show transactions dates between {string} to {string}")
//    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
//
//        BrowserUtils.waitFor(2);
//        String[] endSplit = toDate.split("-");
//        String toDatelast = "";
//        for (int i = 0; i < endSplit.length; i++) {
//            toDatelast += "" + endSplit[i];
//        }
//
//
//        String[] startSplit = fromDate.split("-");
//        String fromDateLast = "";
//        for (int i = 0; i < startSplit.length; i++) {
//            fromDateLast += "" + startSplit[i];
//        }
//
//
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[1]"));
//
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[1]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//
//            String[] splitDate = actual.split("-");
//            String wholeDate = "";
//            for (int j = 0; j < splitDate.length; j++) {
//                wholeDate += "" + splitDate[j];
//
//            }
//
//            if (Integer.parseInt(wholeDate) <= Integer.parseInt(toDatelast)) {
//                Assert.assertTrue(true);
//            } else if (Integer.parseInt(wholeDate) >= Integer.parseInt(fromDateLast)) {
//                Assert.assertTrue(true);
//            } else {
//                Assert.assertTrue(false);
//            }
//
//        }
//
//    }

//    @Then("the results should be sorted by most recent date")
//    public void the_results_should_be_sorted_by_most_recent_date() {
//
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[1]"));
//
//        List<String> result = new ArrayList<>();
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[1]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//
//            String[] splitDate = actual.split("-");
//            String wholeDate = "";
//
//            for (int j = 0; j < splitDate.length; j++) {
//                wholeDate += "" + splitDate[j];
//            }
//            result.add(wholeDate);
//
//        }
//        int max = Integer.parseInt(result.get(0));
//        for (int i = 1; i < result.size(); i++) {
//            if (max < Integer.parseInt(result.get(i))) {
//                Assert.assertFalse(false);
//            } else {
//                Assert.assertTrue(true);
//            }
//        }
//
//    }

//    @Then("the results table should only not contain transactions dated {string}")
//    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
//
//        String[] split = date.split("-");
//        String fromDateLast = "";
//        for (int i = 0; i < split.length; i++) {
//            fromDateLast += "" + split[i];
//        }
//
//
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[1]"));
//        List<String> result = new ArrayList<>();
//
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[1]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//
//            String[] splitDate = actual.split("-");
//            String wholeDate = "";
//            for (int j = 0; j < splitDate.length; j++) {
//                wholeDate += "" + splitDate[j];
//            }
//            result.add(wholeDate);
//
//        }
//        for (String el : result
//        ) {
//            if (el.contains(fromDateLast)) {
//                el.replace(fromDateLast, "");
//            }
//
//        }
//        if (result.isEmpty()) {
//            Assert.assertTrue(false);
//        } else {
//            Assert.assertTrue(true);
//        }
//
//    }
//
//    @When("the user enters description {string}")
//    public void the_user_enters_description(String description) {
//        AccountActivityPage accountActivityPage = new AccountActivityPage();
//        accountActivityPage.descriptionInputBox.clear();
//        accountActivityPage.descriptionInputBox.sendKeys(description);
//    }
//
//    @Then("results table should only show descriptions containing {string}")
//    public void results_table_should_only_show_descriptions_containing(String description) {
//        if (!Driver.get().findElement(By.xpath("(//tbody)[2]/tr")).isDisplayed()) {
//            Assert.assertTrue(false);
//            System.out.println("No results found");
//        }
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr"));
//
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[2]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//
//            String[] split = actual.split(" ");
//
//            if (split[0].contains(description)) {
//                Assert.assertTrue(true);
//            } else {
//                Assert.assertTrue(false);
//            }
//
//        }
//    }
//
//    @Then("results table should not show descriptions containing {string}")
//    public void results_table_should_not_show_descriptions_containing(String description) throws InterruptedException {
//
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr"));
//
//        for (int i = 1; i <= numRows.size(); i++) {
//
//            String element = "(//tbody)[2]/tr[" + i + "]/td[2]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//
//            String[] split = actual.split(" ");
//
//            if (!(split[0].contains(description))) {
//                Assert.assertTrue(false);
//            } else {
//                Assert.assertTrue(true);
//            }
//
//        }
//    }
//
//    @Then("results table should show at least one result under Deposit")
//    public void results_table_should_show_at_least_one_result_under_Deposit() {
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[3]"));
//        List<String> result = new ArrayList<>();
//
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[3]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//            result.add(actual);
//        }
//        System.out.println(result);
//        if (result.isEmpty()) {
//            Assert.assertTrue(false);
//        } else {
//            Assert.assertTrue(true);
//        }
//
//    }
//
//    @Then("results table should show at least one result under Withdrawal")
//    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[4]"));
//        List<String> result = new ArrayList<>();
//
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[4]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//            result.add(actual);
//        }
//        if (result.isEmpty()) {
//            Assert.assertTrue(false);
//        } else {
//            Assert.assertTrue(true);
//        }
//    }
//
//    @When("user selects type {string}")
//    public void user_selects_type(String type) {
//        AccountActivityPage accountActivityPage = new AccountActivityPage();
//
//        accountActivityPage.typeOptionsList().selectByVisibleText(type);
//
//        String actualOption = accountActivityPage.typeOptionsList().getFirstSelectedOption().getText();
//        Assert.assertEquals(actualOption, type);
//        clicks_search();
//    }
//
//    @Then("results table should show no result under Withdrawal")
//    public void results_table_should_show_no_result_under_Withdrawal() {
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[4]"));
//
//
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[4]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//            System.out.println("actual" + actual);
//            if (!actual.isEmpty()) {
//                Assert.assertTrue(false);
//
//            }
//        }
//
//
//    }
//
//    @Then("results table should show no result under Deposit")
//    public void results_table_should_show_no_result_under_Deposit() {
//        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[3]"));
//        for (int i = 1; i <= numRows.size(); i++) {
//            String element = "(//tbody)[2]/tr[" + i + "]/td[3]";
//            String actual = Driver.get().findElement(By.xpath(element)).getText();
//            if (!actual.isEmpty()) {
//                Assert.assertTrue(false);
//                System.out.println("actual" + actual);
//            }
//        }
//
//    }



