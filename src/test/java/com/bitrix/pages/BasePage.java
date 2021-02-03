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


//    /**
//     * @return page name, for example: Dashboard
//     */
//    public String getPageSubTitle() {
//        //ant time we are verifying page name, or page subtitle, loader mask appears
//        waitUntilLoaderScreenDisappear();
////        BrowserUtils.waitForStaleElement(pageSubTitle);
//        return pageSubTitle.getText();
//    }
//
//
//
//
//    public String getUserName(){
//        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForVisibility(userName, 5);
//        return userName.getText();
//    }
//
//
//
    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
//    public void goToMyUser(){
//        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForClickablility(userName, 5).click();
//        BrowserUtils.waitForClickablility(myUser, 5).click();
//
//    }
//
//    /**
//     * This method will navigate user to the specific module in vytrack application.
//     * For example: if tab is equals to Activities, and module equals to Calls,
//     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
//     *
//     * @param tab
//     * @param module
//     */
//    public void navigateToModule(String tab, String module) {
//        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
//        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
//        try {
//            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
//            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
//            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
//        } catch (Exception e) {
//            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
//        }
//        try {
//            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
//            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
//            Driver.get().findElement(By.xpath(moduleLocator)).click();
//        } catch (Exception e) {
////            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
//            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
//        }
//}

}