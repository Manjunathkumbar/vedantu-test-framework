package com.vedantu.qa.pages;

import com.vedantu.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    @FindBy(xpath ="//li[text()='Anonymous']")
    WebElement userDisplay;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public String validateJoinCallPage() {
        String title = driver.getTitle();
        return title;
    }

    public boolean connecteduserDisplay() {
        boolean isdisplayed = userDisplay.isDisplayed();
        return isdisplayed;
    }

}
