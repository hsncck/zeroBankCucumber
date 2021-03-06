package com.bitrix.pages;

import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage {

    @FindBy(xpath = "//a[@href='#ui-tabs-3']")
    public WebElement purchaseForeignCurrencyLink;

    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement addNewPayeeLink;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInput;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement detailsInput;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public WebElement message;

    @FindBy(id = "pc_currency")
    public List<WebElement> currencyList;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateButton;

    @FindBy(xpath = "(//*[@class='btn btn-primary'])[2]")
    public WebElement purchaseButton;

    @FindBy(id = "sp_amount")
    public WebElement amountInput;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "sp_description")
    public WebElement descriptionInput;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;




}

