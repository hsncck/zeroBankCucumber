package com.bitrix.step_definitions;

import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("login with valid input")
    public void login_with_valid_input() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login();
    }


    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Summary",actualTitle);

    }

    @Given("login with invalid username input")
    public void login_with_invalid_username_input() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage=new LoginPage();
        loginPage.login("us","password");

    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Log in",actualTitle);

    }

    @Then("the user should see warning message")
    public void the_user_should_see_warning_message() {
        String expected="Login and/or password are wrong.";
        Assert.assertEquals(expected,new LoginPage().alertMessage.getText());
    }
    @Given("login with invalid password input")
    public void login_with_invalid_password_input() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage=new LoginPage();
        loginPage.login("username","pass");

    }


    @Given("login without any input")
    public void login_without_any_input() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage=new LoginPage();
        loginPage.login("","");
    }
}
