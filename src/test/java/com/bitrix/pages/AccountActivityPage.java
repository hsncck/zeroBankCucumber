package com.bitrix.pages;

import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement findTransactionsLink;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInputBox;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInputBox;

    @FindBy(css = "[type='submit']")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(id = "aa_type")
    public WebElement typeSelect;

    @FindBy (id = "aa_type")
    public WebElement type;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr")
    public List<WebElement> rows;

    public Select typeOptionsList() {
        return new Select(typeSelect);
    }


    public String accountDropdown() {
        WebElement dropdownElement = Driver.get().findElement(By.id("aa_accountId"));

        Select accountDropdown = new Select(dropdownElement);

        String actualOption = accountDropdown.getFirstSelectedOption().getText();
        return actualOption;
    }

    public int[] numberedDate (String str){
        String [] date = str.split("-");
        int [] Date = new int[3];
        for (int i = 0; i < 3 ; i++) {
            Date[i] = Integer.parseInt(date[i]);
        }
        return Date;
    }

    public boolean fitsIn(String str1, String str2){
        boolean flag = true;
        for (int i = 1; i <= rows.size(); i++) {
            String dateString = Driver.get().findElement(By.xpath("(//tbody)[2]/tr[" + i + "]/td[1]")).getText();
            for (int j = 0; j < 3 ; j++) {
                if (!(numberedDate(dateString)[j] >= numberedDate(str1)[j] && numberedDate(dateString)[j] <= numberedDate(str2)[j])){
                    flag = false;
                } }
        }
        return flag;
    }
    public boolean isSorted(){
        boolean flag=true;
        int [] arr = new int[rows.size()];
        label:
        for (int j = 0; j < 3 ; j++){
            for (int i = 1; i <= rows.size() ; i++) {
                String dateString = Driver.get().findElement(By.xpath("(//tbody)[2]/tr[" + i + "]/td[1]")).getText();
                arr[i-1] = numberedDate(dateString)[j];
            }
            int first = arr[0];
            for (int i = 1; i < rows.size(); i++) {
                if (!(first >= arr[i])){
                    flag = false;
                    break label;
                }
            }
        }
        return flag;
    }

    public boolean contains(String str1){
        boolean flag = false;
        for (int i = 1; i <= rows.size(); i++) {
            String dateString = Driver.get().findElement(By.xpath("(//tbody)[2]/tr[" + i + "]/td[1]")).getText();
            if (numberedDate(dateString)[0] >= numberedDate(str1)[0] && numberedDate(dateString)[0] <= numberedDate(str1)[0]){
                if (numberedDate(dateString)[1] >= numberedDate(str1)[1] && numberedDate(dateString)[1] <= numberedDate(str1)[1]){
                    if (numberedDate(dateString)[2] >= numberedDate(str1)[2] && numberedDate(dateString)[2] <= numberedDate(str1)[2]){
                        flag = true;
                    }
                }
            }

        }
        return flag;
    }

    public boolean columnBlank(int column){
        String check = "";
        for (int i = 1; i <= rows.size(); i++) {
            String locator = "(//tbody)[2]/tr["+i+"]/td["+column+"]";
            check+=Driver.get().findElement(By.xpath(locator)).getText();
        }
        if (check.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    public void selectType (String selection){
        Select typeSelect = new Select(type);
        typeSelect.selectByVisibleText(selection);
    }
}

