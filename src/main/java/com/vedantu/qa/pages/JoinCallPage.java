package com.vedantu.qa.pages;

import com.vedantu.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinCallPage extends TestBase {

    @FindBy(xpath ="//button[text() = 'Join Call']")
    WebElement joinCallButton;

    public JoinCallPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateJoinCallPage() {
        String title = driver.getTitle();
        return title;
    }

    public void joinCall() {
        joinCallButton.click();
    }


}
