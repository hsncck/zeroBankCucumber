package com.bitrix.pages;

import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class  BasePage {
    @FindBy(id = "account_summary_tab")
    public WebElement accountSummaryTab;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivityTab;

    @FindBy(id = "transfer_funds_tab")
    public WebElement transferFundsTab;

    @FindBy(id = "pay_bills_tab")
    public WebElement payBillsTab;

    @FindBy(id = "money_map_tab")
    public WebElement moneyMapTab;

    @FindBy(id = "online_statements_tab")
    public WebElement onlineStatementsTab;

    @FindBy(id = "searchTerm")
    public WebElement searchTerm;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement userName;

    @FindBy(id = "logout_link")
    public WebElement logOutLink;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

}
