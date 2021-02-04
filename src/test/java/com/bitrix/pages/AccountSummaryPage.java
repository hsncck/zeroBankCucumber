package com.bitrix.pages;

import com.bitrix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=1']")
    public WebElement savingsLink;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=2']")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCardLink;

    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=4']")
    public WebElement loanLink;

    @FindBy(css = ".board-header")
    public List<WebElement> headers;

    @FindBy(xpath = "(//*[@class='table'])[3]//th")
    public List<WebElement> creditAccountOptions;






}
