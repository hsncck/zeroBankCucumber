package com.bitrix.pages;

import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signinButton;

    @FindBy(id = "user_login")
    public WebElement userLogin;

    @FindBy(id = "user_password")
    public WebElement userPassword;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(id = "details-button")
    public WebElement detailsButton;

    @FindBy(id = "proceed-link")
    public WebElement proceedLink;


    public void login() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        signinButton.click();
        userLogin.sendKeys(username);
        userPassword.sendKeys(password);
        submit.click();
        detailsButton.click();
        proceedLink.click();
        // verification that we logged
    }


}
